import java.util.*;

public class Master {
    public static void main(String[] args) {

        //ALGORITHMS
        //Type 1: Sliding Window


        //Type 2: Hash Map with Count
        /*
        Map<String, Integer> map = new HashMap<>();
        String word = "hi";
        String word2 = "hi";
        String word3 = "hello";
        String word4 = "maybe";

        map.put(word, map.getOrDefault(word, 0) + 1);
        System.out.println(map);
        map.put(word2, map.getOrDefault(word2, 0) + 1);
        System.out.println(map);
        map.put(word3, map.getOrDefault(word3, 0) + 1);
        System.out.println(map);
        map.put(word4, map.getOrDefault(word4, 0) + 1);
        System.out.println(map);
        */



        //In the loops only one declares int i = 0 or we get a lot of errors

        //PART 1: Primitives
        boolean result = true;
        char capitalC = 'C';
        byte b = 100;
        short s = 10000;
        int i = 100000;

        //PART 2: Variables
        String hiya = "Hi!";
        int number = 1000;

        //PART 3: Data Structures
        //Simple Array
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        int[] myNum = {10, 20, 30, 40};
        char[] inputString = {'h','e','l','l','o'};

        //Loop over array
        int[] myArray = {2,7,11,15};


        //Create array with three boxes
        int[] myNumberArray = new int[3];


        //Array List
        ArrayList<String> myArrayList = new ArrayList<String>();
        myArrayList.add("Volvo");
        myArrayList.add("BMW");
        myArrayList.add("Ford");

        //Queue
        Queue<String> bbqLine = new LinkedList<String>();
        bbqLine.add("David");
        bbqLine.add("Frodo");
        bbqLine.add("Bilbo");
        System.out.println(bbqLine.peek());
        bbqLine.poll(); //Remove the Next Person


        //Hash Set (Must be unique)
        int[] numberList = {3,5,1};

        //callSubstringSizeK();
        Queue<String> myQueue = new LinkedList<>();
        myQueue.add("element 1");
        myQueue.add("element 2");
        myQueue.add("element 3");

        String firstElement = myQueue.element();
        String firstPeek = myQueue.peek();
        System.out.println(firstPeek);

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        //System.out.println(myQueue);
        //System.out.println(q);


        /*
        //Like an array
        HashSet<String> myHashSet = new HashSet();

        myHashSet.add("davey");
        myHashSet.add("bilbo");
        myHashSet.add("frodo");

        System.out.println(myHashSet);
        */

        //Hash Map (This maps keys to values)
        int[] nums = {2, 7, 11, 15};
        Map<Integer, Integer> map = new HashMap<>();
        for (i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        map.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        //Hash Map with Default Count
        String[] words = {"one", "two", "two", "three",  "three", "three"};

        Map<String, Integer> mapCount = new HashMap<>();
        for(String word : words) {
            mapCount.put(word, mapCount.getOrDefault(word, 0)+ 1);
        }

        //HashMap with Char Count

        Character[] chars = {'a', 'b', 'c', 'd',  'a', 'b'};

        Map<Character, Integer> charMap = new HashMap<>();
        for(Character individualChar : chars) {
            charMap.put(individualChar, charMap.getOrDefault(individualChar, 0)+ 1);
        }

        System.out.println(charMap);

        System.out.println(charMap.get('a'));


      /*
        String[] words = {"one", "two", "two", "three",  "three", "three"};

        Map<String, Integer> mapCount = new HashMap<>();
        for(String word : words) {
            mapCount.put(word, mapCount.getOrDefault(word, 0)+ 1);
        }
     */

        //System.out.println(map);

        //PART 4: Control Statements
        //If Statements
        if (1 == 1) {
            //System.out.println("One is one");
        } else {
            //System.err.println("Nope");
        }

        //For Loop
        for (i = 0; i < 5; i++) {
            //System.out.println(i);
        }

        //Call Recursion
        factorialRecursion(5);

    }

    //Recursion
    public static int factorialRecursion(int n) {
        if(n <= 1 ) {
            System.out.println("Last Loop  " + n);
            return 1;
        } else {
            System.out.println("Loop " + n);
            return n * factorialRecursion(n - 1);
        }
    }

}
