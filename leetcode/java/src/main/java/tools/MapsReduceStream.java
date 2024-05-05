package tools;

import simple.User;

import java.util.ArrayList;
import java.util.Arrays;

public class MapsReduceStream {
    public static void main(String[] args) {
        User davey = new User(1, "davey");
        User frodo = new User(2, "frodo");
        User sam = new User(3, "sam");
        User merry = new User(4, "merry");
        User pippin = new User(5, "pippin");

        ArrayList<User> userObjects = new ArrayList<User>();
        userObjects.add(sam);
        userObjects.add(pippin);
        userObjects.add(merry);
        userObjects.add(davey);
        userObjects.add(frodo);

        ArrayList<String> users = new ArrayList<String>();
        users.add("Sam");
        users.add("frodo");
        users.add("david");

        //Filter
        //List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        users.stream()
                .map(String::toLowerCase)
                .filter(user -> user.startsWith("s"))
                .forEach(System.out::println);
        //Map

        //Stream

        //Reduce

    }
}
