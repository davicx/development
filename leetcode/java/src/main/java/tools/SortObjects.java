package tools;

import simple.User;
import java.util.ArrayList;
import java.util.Comparator;

public class SortObjects {
    public static void main(String[] args) {
        User davey = new User(1, "davey");
        User frodo = new User(4, "frodo");
        User sam = new User(3, "sam");
        User merry = new User(5, "merry");
        User pippin = new User(2, "pippin");

        ArrayList<User> users = new ArrayList<User>();

        users.add(davey);
        users.add(frodo);
        users.add(sam);
        users.add(merry);
        users.add(pippin);

        //TYPE 1: Unsorted
        System.out.println("TYPE 1: Unsorted");
        //users.forEach((s)->System.out.println(s.getUserName()));
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getUserID() + " | " + users.get(i).getUserName());
        }
        System.out.println("  ");

        //TYPE 2: Sort by User ID
        System.out.println("TYPE 2: Sort by User ID");
        //users.sort((User userOne, User userTwo)->userOne.getUserID()-userTwo.getUserID());
        users.sort(Comparator.comparingInt(User::getUserID));
        //users.forEach((s)->System.out.println(s.userName));
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getUserID() + " | " + users.get(i).getUserName());
        }
        System.out.println("  ");


        //TYPE 3: Sort by User Name
        System.out.println("TYPE 3: Sort by User Name");
        //users.sort((User userOne, User userTwo)->userOne.getUserName().compareTo(userTwo.getUserName()));
        users.sort(Comparator.comparing(User::getUserName));
        //users.forEach((s)->System.out.println(s.userName));
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getUserID() + " | " + users.get(i).getUserName());
        }
        System.out.println("  ");

    }
}
