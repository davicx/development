import java.lang.reflect.Array;
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
        int[] myArray = new int[3];
        usersTen[0] = "hi";
        System.out.println(usersTen[0]);
        String[] currentUsers = {"david", "sam", "bilbo"};

        //Array List (Resizable)
        ArrayList<String> users = new ArrayList<String>();
        users.add("davey");
        users.add("sam");
        users.add("merry");
        users.size();
        //users.get(0);
        //users.set(0, "merry");
        //users.clear();

        //PART 4: SIMPLE SORT
        Collections.reverse(users);
        Collections.sort(users);

        //PART 5: Control
        //For Loop
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < users.size(); i++) {
            System.out.println(i);
        }

        for (String user : users) {
            System.out.println(user);
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

        //PART 6: Class
        SimpleUser davey = new SimpleUser("davey");
        SimpleUser sam = new SimpleUser("sam");
        System.out.println(sam.getUserName());


        //PART 7: DATA STRUCTURES
        //Set
        Set<Integer> mySet = new HashSet<Integer>();

        //Hash Map
        int[] nums = {2, 7, 11, 15};
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            myMap.put(nums[i], i);
        }

        myMap.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        Map<String, Integer> mapCounter = new HashMap<>();
        mapCounter.put("david", mapCounter.getOrDefault("david", 0)+ 1);
        mapCounter.put("david", mapCounter.getOrDefault("david", 0)+ 1);
        mapCounter.put("frodo", mapCounter.getOrDefault("frodo", 0)+ 1);
        System.out.println("Size of mapCounter " + mapCounter);

        //Stack
        Stack<String> friends = new Stack<String>();
        friends.add("frodo");
        friends.add("bilbo");
        friends.add("sam");
        //System.out.println(friends.pop());
        //System.out.println(friends.peek());
        //friends.empty();
        //friends.get(0);
        for (int i = 0; i < friends.size(); i++) {
            //System.out.println(friends.get(i));
        }

        //Queue
        Queue<String> queue = new LinkedList<>();

        // add elements to the queue
        queue.add("apple");
        queue.add("banana");
        queue.add("cherry");

        // print the queue
        System.out.println("Queue: " + queue);

        //remove the element at the front of the queue
        String front = queue.remove();
        System.out.println("Removed element: " + front);
        queue.add("yummy strawberry");

        //peek at the element at the front of the queue
        String peeked = queue.peek();
        System.out.println("Peeked element: " + peeked);

        // print the updated queue
        System.out.println("Queue after peek: " + queue);

        //Method
        System.out.println(" METHOD ");
        String[] words = {"one", "two", "two", "three", "three", "three"};
        countWords(words);


    }

    //METHOD
    //Method 1: Simple Method
≥Method

    //Method 2: Count Words
    public static Map<String, Integer> countWords(String[] words) {

        //Hash Map with Default Count
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        wordMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        return wordMap;
    }

    //Method 3: Loop over String
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


//CLASS
class SimpleUser {
    private String userName;

    public SimpleUser(String userName) {
        this.userName = userName;
    }

    //Get Username
    public String getUserName() {
        System.out.println(userName);
        return userName;
    }

    //Set Username
    public void setUserName(String userName) {
        this.userName = userName;
    }
}