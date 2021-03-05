package com.hubspot.codingchallenge;
//TOC: Methods
//METHODS A: Get and Post Methods
//Method A1: Send a Get Request for Partner Data
//Method A2: Send a POST Request to Send Conference Data

//METHODS B: Get and Post Methods
//Method B1: Send a Get Request for Partner Data

//METHODS C: JSON Helper Functions
//Method C1: Convert GET Response into data (Objects)

//METHODS D: Date and Time Helper Functions
//Method D1:

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    private static final String getRequestURL = "http://localhost:3003/users";
    private static final String postRequestURL = "http://localhost:3003/users";
    //private static Map<LocalDate, Integer> datesMap = new HashMap<LocalDate, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {

        ArrayList<Partner> allPartners = new ArrayList<Partner>();

        //STEP 1: GET all data from API and convert out of JSON
        getResponseHandler partnerResponseObject = getPartnerData(getRequestURL);
        int responseStatus = partnerResponseObject.status;
        String partnerRawData = partnerResponseObject.responseBody;

        //Handle Invalid Response
        if(responseStatus < 200 || responseStatus > 299) {
            System.err.println("The server returned an invalid response ");
            System.exit(0);
        }

        //Convert Data to JSON
        allPartners = parsePartnerData(partnerRawData);

        //STEP 2: Handle data and find the best possible date for each Conference
        HashSet<String> uniqueCountriesSet = new HashSet<String>();
        HashMap<String, Conference> allPossibleConferences = new HashMap<String, Conference>();

        LocalDate currentDate;
        LocalDate nextAvailableDate;
        LocalDate currentDateTomorrow;

        //Loop over all the Partners and get their available dates and the country they are from
        for(int i = 0; i < allPartners.size(); i++) {
            //System.out.println(allPartners.get(i).firstName + " " + allPartners.get(i).lastName + " " + allPartners.get(i).country);

            String currentCountry = allPartners.get(i).country.toLowerCase();

            //DETERMINE CONFERENCE Create a New Conference and Add Dates
            if(!uniqueCountriesSet.contains(currentCountry)) {
                Conference newConference = new Conference(currentCountry);
                allPossibleConferences.put(currentCountry, newConference);
                //System.out.println("Conference Created");
            }

            //INSIDE CONFERENCE: We now have the correct conference that matches the country location
            Conference currentConference = allPossibleConferences.get(currentCountry);
            uniqueCountriesSet.add(currentCountry);
            int currentMaxAttendees = currentConference.attendeeCount;
            currentConference.attendeeEmails.add(allPartners.get(i).email);

            //Current Partner: Loop Over each Date the Current Partners is Available
            for (int j = 0; j < allPartners.get(i).datesArray.size()-1; j++) {

                //Current Date Information
                currentDate = LocalDate.parse(allPartners.get(i).datesArray.get(j));
                nextAvailableDate = LocalDate.parse(allPartners.get(i).datesArray.get(j+1));
                currentDateTomorrow = currentDate.plusDays(1);

                //Check if they are available two days in a row and add the date to a map
                if(currentDateTomorrow.compareTo(nextAvailableDate) == 0) {
                    //System.out.println("Two days in a row! " + currentDate + " " + nextAvailableDate);
                    currentConference.allDates.put(currentDate,  currentConference.allDates.getOrDefault(currentDate, 0)+ 1);
                    int tempMaxAttendees = currentConference.allDates.get(currentDate);

                    //Update Max Attendees
                    if(currentMaxAttendees < tempMaxAttendees) {
                        currentConference.attendeeCount = tempMaxAttendees;
                        currentConference.startDate = currentDate;
                    }
                }
            }
        }

        // using for-each loop for iteration over Map.entrySet()
        //System.out.println("Norway " + allPossibleConferences.get("norway").allDates);
        //System.out.println(allPossibleConferences.get("norway").attendeeCount + " " + allPossibleConferences.get("norway").startDate + " " + allPossibleConferences.get("norway").attendeeEmails);
        //System.out.println("Shire " + allPossibleConferences.get("shire").allDates);
        //System.out.println(allPossibleConferences.get("shire").attendeeCount + " " + allPossibleConferences.get("shire").startDate + " " + allPossibleConferences.get("shire").attendeeEmails);


        //STEP 3: Convert the data back to JSON and POST this to the server
        sendPartnerData();
    }

    public static ArrayList<Partner> parsePartnerData(String partnerRawData) {
        ArrayList<Partner> allPartners = new ArrayList<>();
        Gson gson = new Gson();
        PartnerModel[] partnersList = gson.fromJson(partnerRawData, PartnerModel[].class);
        //System.out.println(partnerRawData);
        //System.out.println(partnersList.length);

        //Create a new Partner and add to the allPartners List
        for(int i = 0; i < partnersList.length; i++) {
            String firstName = partnersList[i].first_name;
            String lastName = partnersList[i].last_name;
            String email = partnersList[i].email;
            String country = partnersList[i].country;
            ArrayList<String> availableDates = partnersList[i].dates;
            Partner currentPartner = new Partner(firstName, lastName, email, country, availableDates);
            allPartners.add(currentPartner);
        }


        return allPartners;

    }


    //METHODS A: Get and Post Methods
    //Method A1: Send a GET Request for Partner Data
    public static getResponseHandler getPartnerData(String getRequestURL) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(getRequestURL))
                .setHeader("User-Agent", "My Request")
                .build();

        //Handle Response and Response Headers
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        HttpHeaders headers = response.headers();
        //headers.map().forEach((headerKey, headerValue) -> System.out.println(headerKey + ":" + headerValue));
        int responseStatus = response.statusCode();
        String responseBody = response.body();
        //System.out.println(responseStatus);

        //Create a Hashmap with the Reponse (responseMap<Status Code, Response Body>)
        //System.out.println(response.body());

        getResponseHandler getResponse = new getResponseHandler(responseStatus, responseBody);

        return getResponse;
    }


    //METHODS B: Get and Post Methods
    //Method B1: Send a Get Request for Partner Data
    public static void sendPartnerData() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();


        Gson gson = new Gson();
        ArrayList<String> datesArray = new ArrayList<String>();
        datesArray.add("Monday");
        datesArray.add("Friday");

        //HashMap<LocalDate, Integer> datesArray = new HashMap<>();
        ArrayList<Partner> usersArray = new ArrayList<Partner>();

        Partner currentPartner = new Partner("davey", "v", "email", "country", datesArray);
        Partner newPartner = new Partner("hiya", "v", "email", "country", datesArray);
        usersArray.add(currentPartner);
        usersArray.add(newPartner);
        String userJson = gson.toJson(usersArray);


            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(userJson))
                    .uri(URI.create("http://localhost:3003/post_user"))
                    .setHeader("User-Agent", "My Send") // add request header
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // print status code
            System.out.println(response.statusCode());

            // print response body
            System.out.println(response.body());

        }


    ///

    //METHODS C: JSON Helper Functions
    //Method C1: Convert GET Response into data (Objects)


    //METHODS D: Date and Time Helper Functions
    //Method D1:


}

