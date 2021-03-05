import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;

public class Main {

    private static final String url = "http://localhost:3003/users";

    public static void main(String[] args) throws IOException, InterruptedException {

        Partner davey = new Partner("David", "V", "David@gmail.com", "Norway", "2020-1-20");
        Partner bilbo = new Partner("Bilbo", "V", "David@gmail.com", "Norway", "2020-1-20");
        Partner frodo = new Partner("Frodo", "V", "David@gmail.com", "Norway", "2020-1-20");
        Partner sam = new Partner("Frodo", "V", "David@gmail.com", "shire", "2020-1-20");

        davey.datesArray.add(1);
        davey.datesArray.add(2);
        davey.datesArray.add(3);
        davey.datesArray.add(7);

        bilbo.datesArray.add(2);
        bilbo.datesArray.add(3);
        bilbo.datesArray.add(5);
        bilbo.datesArray.add(7);

        frodo.datesArray.add(1);
        frodo.datesArray.add(2);
        frodo.datesArray.add(3);
        frodo.datesArray.add(7);

        sam.datesArray.add(1);
        sam.datesArray.add(2);
        sam.datesArray.add(3);
        sam.datesArray.add(7);

        //Create Array List of All Users
        ArrayList<Partner> allUsers = new ArrayList<Partner>();
        allUsers.add(davey);
        allUsers.add(bilbo);
        allUsers.add(frodo);
        allUsers.add(sam);

        //Create Array Lists of All Countries
        HashSet<String> allCountries = new HashSet<String>();
        Map<Integer, Integer> mapNorway = new HashMap<Integer, Integer>();

        String searchCountry = "Norway";
        for(int i = 0; i < allUsers.size(); i++) {
            //System.out.println(allUsers.get(i).country);
            allCountries.add(allUsers.get(i).country);
        }

        //Put Dates into Hashmap

        for(int i = 0; i < allUsers.size(); i++) {
            //System.out.println(allUsers.get(i).country);
            allCountries.add(allUsers.get(i).country);
            for(int j = 0; j < allUsers.get(i).datesArray.size(); j++) {
                System.out.println(allUsers.get(i));

            }
            /*
            if(Objects.equals(searchCountry, new String(allUsers.get(i).country))) {

            }
             */
        }

        /*
        for(int i = 0; i < allCountries.size(); i++) {
            System.out.println(allCountries);

        }
        */




    /*

        Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < millionInts.size(); i++) {
            map.put(millionInts.get(i), map.getOrDefault(millionInts.get(i), 0)+ 1);
        }

            map.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

     */


        //STEP 1: Get Data
        /*
        ArrayList<Partner> partnersArray = new ArrayList<Partner>();
        GetResponse currentResponse = new GetResponse();
        currentResponse = sendGet();
        partnersArray = getPartnersArray(currentResponse.responseBody);
        for(int i = 0; i < partnersArray.size(); i++) {
            System.out.println(partnersArray.get(i).firstName + " " + partnersArray.get(i).lastName);
        }
         */


        //STEP 2 Handle Data

        //STEP 3: Send Reponse Post
        sendPostRequest();


}




    //Method: Send a Post Request to Server
    public static void sendPostRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        //Create JSON Response
        Partner davey = new Partner("David", "V", "David@gmail.com", "Norway", "2020-1-20");
        Gson gson = new Gson();
        String daveyJSON = gson.toJson(davey);

        // json formatted data
        /*
        String json = new StringBuilder()
                .append("{")
                .append("\"first_name\":\"David\",")
                .append("\"last_name\":\"V\",")
                .append("\"email\":\"David@gmail.com\",")
                .append("\"country\":\"Norway\",")
                .append("\"dates\":\"2020-2-14\"")
                .append("}").toString();
        */


        // add json header
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(daveyJSON))
                .uri(URI.create("http://localhost:3003/post_user"))
                .setHeader("User-Agent", "My Send") // add request header
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());

    }





    //Method: Get JSON Data from a URL
    public static GetResponse sendGet() throws IOException, InterruptedException {

        //The response
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .setHeader("User-Agent", "My Request")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        HttpHeaders headers = response.headers();
        //headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        //Response: Status Code
        System.out.println(response.statusCode());
        int status = response.statusCode();

        // print response body
        GetResponse currentResponse = new GetResponse();
        currentResponse.status = status;
        currentResponse.responseBody = response.body();
        //System.out.println(response.body());
        //usersToJSON(response.body().toString());

        return currentResponse;


    }

    //Method 2: Create an ArrayList from the JSON response we got
    public static  ArrayList<Partner> getPartnersArray(String jsonResponse) {
        ArrayList<Partner> partnersArray = new ArrayList<Partner>();
        JSONArray currentUsers = new JSONArray(jsonResponse);

        for(int i = 0; i < currentUsers.length(); i++) {
            JSONObject currentUser = currentUsers.getJSONObject(i);
            String firstName = currentUser.getString("firstName");
            String lastName = currentUser.getString("lastName");
            String email = currentUser.getString("email");
            String country = currentUser.getString("country");
            String dates = currentUser.getString("dates");

            Partner currentPartner = new Partner(firstName, lastName, email, country, dates);
            partnersArray.add(currentPartner);

        }

        return partnersArray;
    }







}
