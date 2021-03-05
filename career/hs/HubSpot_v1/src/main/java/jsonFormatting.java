import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class jsonFormatting {
    public static void main(String[] args) {

        UserJSON currentUser = new UserJSON();
        Gson gson = new Gson();
        String currentUserJSON = gson.toJson(currentUser);
        System.out.println(currentUserJSON);

        //Parse From JSON
        //UserJSON returnedUser = gson.fromJson(currentUserJSON, UserJSON.class);
        //System.out.println(returnedUser.name);
        //System.out.println(returnedUser.last_name);
        //System.out.println(returnedUser.city);

        formatObjects();

    }
    public static void formatObjects() {
        Gson gson = new Gson();
        Answer countryOne = new Answer();
        countryOne.allDates.add("2020-2-14");
        countryOne.allDates.add("2020-7-1");
        Answer countryTwo = new Answer();
        countryTwo.allDates.add("2020-1-14");
        countryTwo.allDates.add("2020-6-14");

        String countryOneJSON = gson.toJson(countryOne);
        Answer[] countryArray;
        countryArray = new Answer[2];
        countryArray[0] = countryOne;
        countryArray[1] = countryTwo;

        String answersInJSON = gson.toJson(countryArray);
        System.out.println(answersInJSON);



    }

    static class Answer {
        private String country = "Norway";
        private String dates = "2020-2-14";
        private ArrayList<String> allDates = new ArrayList<String>();;

        Answer() {

        }
    }


    static class UserJSON {
        private String name = "David";
        private String last_name = "Vasquez";
        private String city = "Victoria";

        UserJSON() {

        }
    }


}

/*


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