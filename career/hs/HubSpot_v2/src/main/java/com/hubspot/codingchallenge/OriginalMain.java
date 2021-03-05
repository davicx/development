package com.hubspot.codingchallenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

public class OriginalMain {
    private static final String getRequestURL = "http://localhost:3003/users";
    private static final String postRequestURL = "http://localhost:3003/users";

    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<String> userAvailabilityDates = new ArrayList<String>();
        userAvailabilityDates.add("2020-2-1");
        userAvailabilityDates.add("2020-7-1");
        userAvailabilityDates.add("2020-8-1");

        Partner currentPartner = new Partner("David", "V", "david@gmail.com", "Norway", userAvailabilityDates);

        //STEP 1: Create a GET Request to get data utilizing the PartnerAPI class
        PartnerResponseHandler partnerRawResponse = getRequest(getRequestURL);
        System.out.println(partnerRawResponse.status);
        System.out.println(partnerRawResponse.responseBody);



    }

    public static PartnerResponseHandler getRequest(String getRequestURL) throws IOException, InterruptedException {
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

        PartnerResponseHandler getResponse = new PartnerResponseHandler(responseStatus, responseBody);

        return getResponse;
    }


}


        /*
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        sd.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        Date dateValue = sd.parse("2021-02-28");
        System.out.println(dateValue);

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
        calendar.setTime(dateValue);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        dateValue = calendar.getTime();
        System.out.println(dateValue);
        */

/*



 */
/*
        String string = "2021-1-14";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);


 */
    /*
    public static LocalDate parseDate(String Localdate) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(Localdate);
        } catch (ParseException e) {
            return null;
        }
    }

     */
//Convert Dates

        /*

        LocalDate dateOneLocal = LocalDate.parse("2021-1-14");
        LocalDate dateTwoLocal = LocalDate.parse("2021-2-14");
        LocalDate dateThreeLocal = LocalDate.parse("2021-4-14");
        LocalDate dateFourLocal = LocalDate.parse("2021-7-14");


         */



        /*
        if(dateOne.compareTo(dateTwo) > 0) {
            System.out.println("Date 1 occurs after Date 2");
        } else if(dateOne.compareTo(dateTwo) < 0) {
            System.out.println("Date 1 occurs before Date 2");
        } else if(dateOne.compareTo(dateTwo) == 0) {
            System.out.println("Both dates are equal");
        }
        */



//WORKING CODE
    /*


                //System.out.println(currentStringDate);
                //Date dateOneToday= parseDate(currentStringDate);



                //System.out.println("Today " + dateOneToday + " Tomorrow " + dateTwoTomorrow);
                System.out.println(currentDate  + " " + nextAvailableDate);

            for(int i = 0; i < allPartners.size(); i++) {
            System.out.println(allPartners.get(i).first_name + " " + allPartners.get(i).last_name + " " + allPartners.get(i).country);
            for(int j = 0; j < allPartners.size(); j++) {
                System.out.println(allPartners.get(i).datesArray.get(j));
            }
        }

        Date dateOne = parseDate("2021-02-28");
        Date dateTwo = parseDate("2021-2-14");
        Date dateThree = parseDate("2021-4-14");
        Date dateFour = parseDate("2021-7-14");
        System.out.println(dateOne);

        Date dateOneTomorrow = addDays(dateOne, 1);
        System.out.println(dateOneTomorrow);
     */

            /*
        //WORKS
        Date currentDate;
        Date nextAvailableDate;
        Date currentDateTomorrow;

        //Loop Over all the Partners
        for(int i = 0; i < allPartners.size(); i++) {
            System.out.println(allPartners.get(i).first_name + " " + allPartners.get(i).last_name + " " + allPartners.get(i).country);

            //Loop Over each Date the Current Partners is Available
            for (int j = 0; j < allPartners.get(i).datesArray.size()-1; j++) {
                currentDate = parseDate(allPartners.get(i).datesArray.get(j));
                currentDateTomorrow = addDays(currentDate, 1);
                nextAvailableDate = parseDate(allPartners.get(i).datesArray.get(j+1));

                //Check if they are available two days in a row and add the date to a map
                if(currentDateTomorrow.compareTo(nextAvailableDate) == 0) {
                    System.out.println("Two days in a row! " + currentDate + " " + nextAvailableDate);
                }
            }
            System.out.println();

        }

         */

