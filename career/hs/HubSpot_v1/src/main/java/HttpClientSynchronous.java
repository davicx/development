import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientSynchronous {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:3003/users"))
                .setHeader("User-Agent", "My Request") // add request header
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print response headers
        HttpHeaders headers = response.headers();
        //headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());
        parseResponse(response.body().toString());

    }

    public static String parseResponse(String responseBody) {
        JSONArray currentUsers = new JSONArray(responseBody);
        for(int i = 0; i < currentUsers.length(); i++) {
            JSONObject currentUser = currentUsers.getJSONObject(i);
            String firstName = currentUser.getString("firstName");
            String lastName = currentUser.getString("lastName");
            String email = currentUser.getString("email");
            String country = currentUser.getString("country");
            String dates = currentUser.getString("dates");
            System.out.println(firstName + " " + lastName);
        }
        return "";
    }


    static class Partner {
        private String firstName = "";
        private String lastName = "";
        private String email = "";
        private String country = "";
        private String dates = "";

        Partner() {

        }
    }
}

/*
import com.google.gson.Gson;

public class dataToJSON {

    public static void main(String[] args) {

        UserJSON currentUser = new UserJSON();
        Gson gson = new Gson();
        String currentUserJSON = gson.toJson(currentUser);
        System.out.println(currentUserJSON);

        UserJSON returnedUser = gson.fromJson(currentUserJSON, UserJSON.class);
        System.out.println(returnedUser.name);
        System.out.println(returnedUser.last_name);
        System.out.println(returnedUser.city);

    }

    static class UserJSON {
        private String name = "David";
        private String last_name = "Vasquez";
        private String city = "Victoria";

        UserJSON() {

        }
    }

    static class User {
        private int userID = 1;
        private String userName = "abc";
        private String userCountry = "abc";

        User() {

        }
    }

}

 */