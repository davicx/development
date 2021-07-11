import java.util.*;

public class Master {
    public static void main(String[] args) {
        //PART 1: Primitives
        boolean result = true;
        char capitalC = 'C';
        byte b = 100;
        short s = 10000;
        int a = 0;

        //PART 2: Arrays
        //Simple Array
        String[] usersEmpty;
        String usersTen[] = new String[10];
        String[] users = {"Bilbo", "Frodo", "David"};

        //Array List
        ArrayList<String> userArrayList = new ArrayList<String>();
        userArrayList.add("davey");

        //PART 3: Control Statements
        //For Loop
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        //If Statements
        if (1 == 1) {
            System.out.println("One is one");
        } else {
            System.err.println("Nope");
        }

        //While Loop
        while (a < 5) {
            System.out.println(a);
            a++;
        }

        //PART 3: Classes
        User davey = new User(1);
        System.out.println(davey.userName);
        davey.sayHi();

        //PART 4: Data Structures
        //Hash Map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "david");

        map.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        Map<String, Integer> mapCounter = new HashMap<>();
        mapCounter.put("david", mapCounter.getOrDefault("david", 0)+ 1);
        mapCounter.put("david", mapCounter.getOrDefault("david", 0)+ 1);
        mapCounter.put("frodo", mapCounter.getOrDefault("frodo", 0)+ 1);
        System.out.println(mapCounter);

        //Hash Set
        Set<String> stringSet = new HashSet<String>();
        stringSet.add("hiya");
        stringSet.contains("hiya");
        System.out.println(stringSet);

        String myString = "hiya";

        loopOverString(myString);
    }

    //PART 5: Functions
    //loopOverString(s);
    public static int loopOverString(String s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                System.out.print(c);
            }
            System.out.println();
        }

        return 1;
    }
}

public class User {
    public int userID;
    String userName = "hiya";

    //Constructor
    public User(int currentUserID) {
        userID = currentUserID;
    }

    //Method
    public void sayHi() {
        System.out.println("hello!!");
    }

}