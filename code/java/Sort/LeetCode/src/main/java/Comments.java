import java.util.*;

public class Comments {

/*
    //ISLANDS WORKING

    //PROBLEM 2: Number of Islands (First)

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        //Access the Grid Row
        for(int i=0; i<grid.length; i++) {

            //Access the Column
            for(int j=0; j<grid[i].length; j++) {

                //If we see a 1 turn all its touching islands to 0
                if(grid[i][j] == '1') {
                    count += 1;
                    callBFS(grid, i, j);
                }
            }
        }

        return count;

    }

        public static void callBFS(char[][] grid, int i, int j) {
        //Do a Boundary Check
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;

        }
            grid[i][j] = '0';
            callBFS(grid, i+1, j); //Up
            callBFS(grid, i-1, j); //Down
            callBFS(grid, i, j-1); //Left
            callBFS(grid, i, j+1); //Right
    }
}







    //WORKS

        int leftWindow = 0; //i
        int rightWindow = 0; //j
        int longestString = 0;
        int totalLoops = 1;

        HashSet<Character> currentSetOfCharacters = new HashSet<>();

        while (rightWindow < s.length()) {
            System.out.println("Loop: " + totalLoops + " leftWindow: " + leftWindow + " rightWindow: " + rightWindow + " SET: " + currentSetOfCharacters);

            if (!currentSetOfCharacters.contains(s.charAt(rightWindow))){
                currentSetOfCharacters.add(s.charAt(rightWindow));
                System.out.println("If Statement ");

                rightWindow = rightWindow + 1;
                longestString = Math.max(currentSetOfCharacters.size(), longestString);
            } else {
                currentSetOfCharacters.remove(s.charAt(leftWindow));
                leftWindow = leftWindow + 1;
                System.out.println("Else Statement ");
            }
            System.out.println();
            totalLoops = totalLoops + 1;

        }

        //System.out.println(longestString);


    //OTHER WORK




        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character

        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        System.out.println(ans);


        //Window: Window Length is equal to rightWindow - leftWindow + 1
        int leftWindow = 0; //j
        int rightWindow = 0; //i
        int largestSubstring = 0;
        int stringLength = s.length();
        char currentCharacter;

        if(s == null || s.length() == 0) {
            //return 0;
            //System.out.println("no good");
        }

        //If you find a Char in the set then you move rightWindow Forward
        Set<Character> allCharactersSet = new HashSet<>();
        Map<Character, Integer> sub = new HashMap<>(); // current index of character



        for (int i = 0; i < stringLength; i++) {

            //Check if Letter we are looking at was already put in our dictionary (we have seen it before)
            //System.out.println(s.charAt(i));
            currentCharacter = s.charAt(i);



        }



            int i =0, j = 0, max = 0;


                while(i < s.length()) {
                    char c = s.charAt(i);

                    System.out.println("Current C: " + c + " Current Set: " + set);

                    //If our set contains the Character Remove that Character at the J Index
                    while(set.contains(c)) {
                        set.remove(s.charAt(j));
                        ++j;
                    }
                    set.add(c);
                    System.out.println("Current Set: " + set);
                    System.out.println("_______________");

                    //Compute the Length of our Window
                    max = Math.max(max, i-j + 1);
                    //++i;
                    i = i + 1;
                }
                //return max;
                System.out.println(max);

        int stringLength = s.length();
        int maxValue = 0;


        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < stringLength; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxValue = Math.max(maxValue, j - i + 1);
            map.put(s.charAt(j), j + 1);
            System.out.println("Window " + i + " " + j);
            System.out.println("Current Map " + map);
        }
        System.out.println(maxValue);


        if(s == null || s.length() == 0) {
            //return 0;
            System.out.println("no good");
        }


           Map<Integer, String> usersHashMap = new HashMap<Integer, String>();
        usersHashMap.put(1, "vasquezd");
        usersHashMap.put(2, "frodo");
        usersHashMap.put(3, "bilbo");

        System.out.println(usersHashMap.get(1));

        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        wordCount.put("hi", 1);
        wordCount.put("and", 1);

        int largestGroup = 1;
        ArrayList<Integer> allMaxSizes = new ArrayList<Integer>();

        //Check if String is Empty
        if(s.isEmpty()) {
            System.out.println("The String is Empty");
            //return 0;
        }

        //Check if String is Just Whitespace
        boolean isWhitespace = s.matches("^\\s*$");
        if(isWhitespace == true) {
            System.out.println("you got played sucka!");
            //return 1;
        }

        //String is Ok so we can run our Code
        String[] originalStringArray = s.split("");
        List<List<String>> masterArrayList = new ArrayList<List<String>>();

        //Create All Arrays and hold them in an array
        for (int i = 0; i < originalStringArray.length; i++) {
            ArrayList<String> tempStringArray = new ArrayList<String>();
            for (int j = i; j < originalStringArray.length; j++) {
                tempStringArray.add(originalStringArray[j]);
                //System.out.println(i + " " + j);
            }
            //System.out.println(tempStringArray);
            masterArrayList.add(tempStringArray);

        }

        int maxHigh = 1;
        //Loop Over
        for (int i = 0; i < masterArrayList.size(); i++) {
            String[] currentLoopStringArray = masterArrayList.get(i).toArray(new String[0]);
            System.out.println("First Loop " + masterArrayList.get(i));


            ArrayList<String> stringArray = new ArrayList<String>();
            Set<String> stringSet = new HashSet<String>();

            int tempMaxHigh = 0;
            for (int j = 0; j < currentLoopStringArray.length; j++) {
                //System.out.println(currentLoopStringArray[j]);

                stringArray.add(currentLoopStringArray[j]);
                stringSet.add(currentLoopStringArray[j]);
                //System.out.println("Array " + stringArray);
                //System.out.println("Set " + stringSet);
                if(stringSet.size() < stringArray.size()){
                    //System.out.println("Just found the max " + stringSet.size());
                    //System.out.println("Set " + stringSet );
                    if(maxHigh < stringSet.size()) {
                        maxHigh = stringSet.size();
                    }

                    break;
                    //duplicateFound = true;
                } else {
                    if(maxHigh < stringArray.size()) {
                        maxHigh = stringArray.size();
                    }

                    //System.out.println(stringArray.size());
                }
                System.out.println(maxHigh);

            }
            //System.out.println(stringSet.size());
        }

        //System.out.println(allMaxSizes);

        /*


        System.out.println(currentLoopStringArray[j]);

        stringArray.add(currentLoopStringArray[j]);
        stringSet.add(currentLoopStringArray[j]);
        System.out.println(stringArray);
        System.out.println(stringSet);

        //Check if we have a duplicate
        if(stringSet.size() < stringArray.size()) {
            duplicateFound = true;
            System.out.println(stringSet);
            largestGroup = stringSet.size();

            //System.out.println("duplicate Found: " + duplicateFound);
            if(largestGroup < stringSet.size()) {

                stringArray.clear();
                stringSet.clear();
                break;
            }



        }
        if(duplicateFound == false) {
            largestGroup = originalStringArray.length;
        }


        System.out.println("________________");
        System.out.println(duplicateFound);
        System.out.println(largestGroup);




//String[][] masterArray;
//masterArray = new String[][];

//List<String> x = new ArrayList<String>();
//x.add("Hello");
//x.add("world!");
//masterArrayList.add(x);

//System.out.println(Arrays.deepToString(ls2d.toArray()));


//Create a Set and List to use to compare things



//stringArray.clear();
//stringSet.clear();










                //Check if we have a duplicate
                if(stringSet.size() < stringArray.size()) {
                    System.out.println("duplicate Found");
                    if(largestGroup < stringSet.size()) {
                        largestGroup = stringSet.size();
                    }

                    stringArray.clear();
                    stringSet.clear();

                }
    //Check if they are Distinct
            if(stringSet.size() == stringArray.size()) {
        System.out.println("unique");
    } else {
        System.out.println("Not Unique");
    }

              for (int j = i; j < masterArray.length; j++) {
                boolean duplicateFound = false;
                stringArray.add(masterArray[j]);
                stringSet.add(masterArray[j]);
                System.out.println(stringArray);
                System.out.println(stringSet);

                //Check for Duplicates
                if (stringSet.size() < stringArray.size()) {
                    System.out.println("we found the max from this Char " + stringSet.size());
                    largestGroup = stringSet.size();
                    duplicateFound = true;
                }

            }

            stringArray.clear();
            stringSet.clear();
            System.out.println("Next Letter ");

        int globalLargestGroup = 1;
        boolean allUnique = true;

        //Loop over the array
        for (int i = 0; i < masterArray.length; i++) {
            for (int j = i; j < masterArray.length; j++) {
                stringArray.add(masterArray[j]);
                stringSet.add(masterArray[j]);
                System.out.println(stringArray);
                System.out.println(stringSet);
                if (stringSet.size() < stringArray.size()) {
                    System.out.println("happened " + stringSet.size());


                    allUnique = false;
                    if(stringSet.size() > globalLargestGroup) {
                        globalLargestGroup = stringSet.size();
                        System.out.println("Set " + " globalLargestGroup " + stringSet.size());
                    }
                    stringArray.clear();
                    stringSet.clear();
                }

            }
            stringArray.clear();
            stringSet.clear();
        }
        if(allUnique == true) {
            globalLargestGroup = masterArray.length;
        }
        System.out.println("Global Largest " + globalLargestGroup);
      int currentLargestGroup = 1;

            //Check Each Position
            for (int j = i; j < masterArray.length; j++) {
                stringArray.add(masterArray[j]);
                stringSet.add(masterArray[j]);
                System.out.println(stringArray);
                System.out.println(stringSet);
                if (stringSet.size() < stringArray.size()) {
                    System.out.println("Just happened " + stringSet.size());
                    if(currentLargestGroup < stringSet.size()) {
                        currentLargestGroup = stringSet.size();
                        stringArray.clear();
                        stringSet.clear();
                    }
                }
            }
            if(stringSet.size() == stringArray.size()) {
                currentLargestGroup = stringSet.size();
            }
            if(currentLargestGroup > globalLargestGroup) {
                globalLargestGroup = currentLargestGroup;
            }



                if (stringSet.size() < stringArray.size()) {
                    System.out.println("Just happened " + stringSet.size());
                    largestGroup = stringSet.size();
                    stringArray.clear();
                    stringSet.clear();
                    i--;
                }

              //System.out.println(masterArray[i]);
            //System.out.println("total loops " + i);
            stringArray.add(masterArray[i]);
            stringSet.add(masterArray[i]);
            System.out.println(stringArray);
            System.out.println(stringSet);

            //If the Set is less that means we have found a duplicate


                //We are keeping a running total of our Largest Thingy, if we got a new one then yay! Set largestGroup
                if(stringSet.size() < stringArray.size()) {
                    largestGroup = stringSet.size();
                    System.out.println(i);
                    stringArray.clear();
                    stringSet.clear();
                    i--;
                }

//System.out.println("Group Fell apart " + i);
//System.out.println("Largest Group " + largestGroup);
//System.out.println(stringArray.size());
//System.out.println(stringSet.size());


        map.entrySet().forEach(entry->{
            //System.out.println(entry.getKey() + " " + entry.getValue());
        });


    public static int[] twoSum(int[] nums, int target) {
        //int[] anArray = new int[2];
        int answerArray[] = new int[2];
        outerloop:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println(nums[i]);
                System.out.println(nums[j]);
                int tempSum = nums[i] + nums[j];
                if (tempSum == target) {
                    System.out.println("equals");
                    answerArray[0] = i;
                    answerArray[1] = j;
                    //break outerloop;
                } else {
                    System.out.println("Does not Equal");
                }
            }
        }

        return answerArray;



                int tempSum = nums[i] + nums[j];
                if (tempSum == target) {
                    int[] answerArray = {i, j};
                    System.out.println("equals");
                    return answerArray;
                } else {
                    int[] failureArray = {0, 1};
                    System.out.println("Does not Equal");
                    return failureArray;
                }

            }

        }


    }





        public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution" + );
    }

    public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}


        map.entrySet().forEach(entry->{
            System.out.println(entry.getKey() );
        });






import java.util.*;

public class Main {

    public static void main(String[] args) {

        //PROBLEM 16: First Unique
        String[][] codeList = {{ "apple", "apple" }, { "apple", "apple" }, { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart = {"orange", "apple", "apple", "banana", "orange", "banana"};

        //System.out.println(codeList.length);

        int numberOfPrizeLists = 0;

        //System.out.println(amazonFresh(codeList, shoppingCart));

        int i = 0, j = 0;
        int loop = 0;
        //int codeLen = codeList[i].length;
        while (i < codeList.length && j + codeList[i].length <= shoppingCart.length) {
            //System.out.println(i + " " + codeList.length);
            //System.out.println(codeList[i].length + " " + shoppingCart.length );

            boolean match = true;
            for (int k = 0; k < codeList[i].length; k++) {
                loop = loop + 1;
                //System.out.println("shoppingCart "+ shoppingCart[j+k]);
                System.out.println("codeList " + codeList[i][k]);
                System.out.println("shoppingCart " + shoppingCart[j+k]);
                System.out.println("");

                //System.out.println("Loop " + loop);
                if (!codeList[i][k].equals("anything") && !shoppingCart[j+k].equals(codeList[i][k])) {
                    match = false;
                    //System.out.println("Not a Match");
                    //System.out.println("________________");
                    break;
                }
                //System.out.println("________________");
                //System.out.println(match);
            }


            if (match) {
                //System.out.println("MATCH ");

                //j += codeList[i].length;
                j = j + codeList[i].length;
                i++;
            } else {
                //System.out.println("NOT A MATCH  ");
                j++;
            }
        }
        if (i == codeList.length) {
            //System.out.println(1);
        } else {
            //System.out.println(0);
        }
        int loopCounter = j + codeList[i].length;
        //System.out.println("j + codeList[i].length " + loopCounter);
        //System.out.println("shoppingCart.length " + shoppingCart.length);
        //System.out.println("Code List Length " + codeList.length);
        //System.out.println("TOTAL MATCHES (i) " + i);
        //return (i == codeList.length) ? 1 : 0;

    }





    public static int amazonFresh(String[][] codeList, String[] shoppingCart) {
        int constestWinner = 0;

        int i = 0;
        int j = 0;

        while (i < codeList.length && j + codeList[i].length <= shoppingCart.length) {

            boolean match = true;
            for (int k = 0; k < codeList[i].length; k++) {
                System.out.println(codeList[i][k]);

                if (!codeList[i][k].equals("anything") && !shoppingCart[j+k].equals(codeList[i][k])) {
                    match = false;
                    System.out.println("match " + match);
                    break;
                }
            }
            if (match) {
                j += codeList[i].length;
                i++;
            } else {
                j++;
            }
        }
        if (i == codeList.length) {
            return 1;
        } else {
            return 0;
        }


        //return constestWinner;
    }


    //PROBLEM 15: Pairs of Songs With Total Durations Divisible by 60
    public static void runPairsOfSongs() {
        //String s = "abcabce";
        //String s = "cdd";
        //String s = "  "
        //String s = "abcade";
        String s = "abcadefagh";
        //String s = "aab";
        //String s = "pwkwew";
        //String s = "bbbbb";
        //String s = "aab";
        //String s = "abac";
    }

    public static int pairsOfSongs(String s) {
        int[] time = {30, 20, 150, 100, 40};
        int[] arr = new int[60];

        int answer = 0;
        for (int i = 0; i < time.length; i++) {
            int mod = time[i] % 60; // 120%60=0, 1%60=1

            int target = (60 - mod) % 60; // 120 target = 0; 1 then target=59

            System.out.println("The Number " + time[i] + " The Modulus " + mod + " The target " + target);
            answer = answer + arr[target];
            //System.out.println(arr[mod]);
            //System.out.println(answer);
            arr[mod]++;

        }
        System.out.println(answer);
        return answer;
    }


    //PROBLEM 10: Longest Substring without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {


        return 0;

    }


    //PROBLEM 9: Reverse an Integer
    public static int reverse(int x) {
        int reversedInteger = 0;
        int lastDigit;

        while (x != 0) {
            lastDigit = x % 10;
            x /= 10;

            //System.out.println(x + " Last Digit " + lastDigit + " Current Reversed Int " + reversedInteger);

            if(reversedInteger > Integer.MAX_VALUE/10 || reversedInteger == Integer.MAX_VALUE && lastDigit/10  > 7) {
                return 0;
            }
            if(reversedInteger < Integer.MIN_VALUE/10 || reversedInteger == Integer.MIN_VALUE && lastDigit/10  < -8) {
                return 0;
            }
            reversedInteger = (reversedInteger * 10) + lastDigit;

        }
        System.out.println("output " + reversedInteger);
        return reversedInteger;

    }


    //PROBLEM 8: Is the Number a Palindrome
    public static void runIsPalindrome() {
        int x = 121;
        System.out.println(isPalindrome(x));
    }


    public static boolean isPalindrome(int x) {

        //Make sure it is not negative
        if(x < 0 || (x > 0 && x < 10)) {
            return false;
        }

        if(x == 0 ) {
            return true;
        }

        //Logic
        int reverseInt = 0;
        while(x > reverseInt) {
            int pop = x % 10;
            x /= 10;
            reverseInt = (reverseInt * 10) + pop;
        }

        if(x == reverseInt || x == reverseInt / 10) {
            return true;
        } else {
            return false;
        }

    }


    //PROBLEM 7: Most Common Word
    public static void mostCommonWord() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit", "dontsayme"};
        System.out.println(mostCommonWord(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        //Create a Hashset of the banned words
        HashSet<String> banned_words = new HashSet<>();
        HashMap<String, Integer> valid_word_counts = new HashMap<>();

        for(String banned_word : banned) {
            //System.out.println(banned_word);
            banned_words.add(banned_word);
            //banned_words.put(banned_word);
        }

        String[] words = paragraph.toLowerCase().split("\\W+");
        for(String word : words ) {
            //System.out.println(word);
            if(!banned_words.contains(word)) {
                valid_word_counts.put(word, valid_word_counts.getOrDefault(word, 0) + 1);

            }
        }

        System.out.println(valid_word_counts);

        int max = 0;
        String result = "";

        //Loop over the HashMap

        for(String word : valid_word_counts.keySet()) {
            System.out.println("key: " + valid_word_counts.get(word) + " value: " + word);
            max = valid_word_counts.get(word);
            result = word;
        }

 */
     /*
        for(String word : valid_word_counts.keySet()) {
            if(valid_word_counts.get(word) > max) {
                max = valid_word_counts.get(word);
                result = word;
            }

        }

        return result;
    }



    //PROBLEM 6: Treasure Island II
    public static void runTreasureIsland() {
        char[][] mapTwo = new char[][]{
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}};

        System.out.println(treasureIsland(mapTwo));

    }

    public static int treasureIsland(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int row=grid.length, col=grid[0].length, minStep=Integer.MAX_VALUE;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j]=='S') {
                    minStep=Math.min(minStep, bfs(grid, i, j));
                }
            }
        }
        return minStep;
    }

    public static int bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{row, col});
        int steps=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()) {
            int size=queue.size();
            while(size>0) {
                int[] coor=queue.poll();
                int x=coor[0], y=coor[1];
                if(grid[x][y]=='X') return steps;
                visited[x][y]=true;
                for(int i=0; i<directions.length; i++) {
                    int dx=x+directions[i][0];
                    int dy=y+directions[i][1];
                    if(dx>=0 && dx<grid.length && dy>=0 && dy<grid[0].length && !visited[dx][dy] && grid[dx][dy]!='D') {
                        queue.offer(new int[]{dx,dy});
                    }
                }
                size--;
            }
            steps++;
        }
        return -1;
    }


    //PROBLEM 5: Number of Islands
    public static void runNumberOfIslands(){
        char[][] grid = { {'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'1','0','0','0','0'}};
        char[][] simpleGrid = { {'1','0'}, {'1','1'}};

        //System.out.println(numIslandsTwo(simpleGrid));
        System.out.println(numIslandsTwo(grid));
    }

    public static int numIslandsTwo(char[][] grid) {
        //if (grid == null ) { return 0;}

        int islandCount = 0;

        //Access the Grid Row
        for(int i=0; i<grid.length; i++) {

            //Access the Column
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    //Increase the Islands
                    islandCount = islandCount + 1;

                    //Turn the rest of this island to 0 (grid and your current position)
                    turnLandToWater(grid, i, j);
                }
            }
        }

        return islandCount;
    }

    private static void turnLandToWater(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;

        }
        grid[i][j] = '0';
        turnLandToWater(grid, i+1, j); //Up
        turnLandToWater(grid, i-1, j); //Down
        turnLandToWater(grid, i, j-1); //Left
        turnLandToWater(grid, i, j+1); //Right


        //Conditions to check in every direction of our current position
        //Is the row less then 0
        //Is the row greater then the row length
        //Is the column less then 0
        //Is the column greater then the column length
        //If you hit a condition exit
        //Last Base Condition is if you see a 0
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        //Change your current Position to a 0 (We know we are on a 1)
        grid[i][i] = '0';

        //Must call this to the up, down, left and right positions
        //System.out.println(grid[][]);
        turnLandToWater(grid, i-1, j); //Down
        turnLandToWater(grid, i+1, j); //Up
        turnLandToWater(grid, i, j-1); //Left
        turnLandToWater(grid, i, j+1); //Right



    }



    //PROBLEM 4: Closest Point to Origin
    public static void runkClosest(){
        //Input: points = [[1,3],[-2,2]], K = 1
        int[][] points = {{1,3}, {-2,2}};
        int[][] outputPoints = kClosest(points, 1);
    }

    public static int[][] kClosest(int[][] points, int K) {

        //Create a heap that is no larger then k
        //PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0] * b[0]  + b[1] * b[1]) - (a[0] * a[0]  + a[1] * a[1]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
            }
        });



        for(int[] point: points) {
            maxHeap.add(point);
            if(maxHeap.size() > K ) {
                maxHeap.remove();
            }
        }

        int[][] result = new int[K][2];
        int i = 0;
        while(!maxHeap.isEmpty()) {
            result[i] = maxHeap.poll();
            i++;
        }

        return result;

    }



    //PROBLEM 3: Reverse a String
    public static void runReverseString(){
        char[] inputString = {'h','e','l','l','o'};
        System.out.println(inputString);
        reverseString(inputString);
        System.out.println(inputString);
    }

    public static char[] reverseString(char[] s) {
        for(int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
        return s;
    }





    //PROBLEM 1: Two Sum (Answer A)
    public static void runTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int[] numsTwo = {3,2,4};
        int[] answer = twoSum(nums, 9);

        System.out.println("_____Answer_____");
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        System.out.println("_____Answer_____");
    }

    public static int[] twoSumA(int[] nums, int target) {

        int answerArray[] = new int[2];
        System.out.println(target);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //System.out.println(nums[i] + " " + nums[j]);
                int current_sum = nums[i] + nums[j];
                System.out.println(target + " " + current_sum);
                if(target == current_sum) {
                    //System.out.println(current_sum);
                    answerArray[0] =  i;
                    answerArray[1] =  j;
                    return answerArray;

                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    //PROBLEM 1: Two Sum (Answer B)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //PROBLEM 12: Smallest Subarray with Given Sum
    public static int smallestSubarray(int[] inputArray, int targetSum) {

        //Need a Window Start and a Window End

        //int[] input = new int[]{4,2,2,7,8,1,2,8,10};
        //int targetSum = 8;

        int windowStart = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int currentWindowSum = 0;

        for(int windowEnd = 0; windowEnd< inputArray.length; windowEnd++) {
            currentWindowSum = currentWindowSum + inputArray[windowEnd];

            //Ask can we do better (Shrink Left hand Side)
            while (currentWindowSum >= targetSum) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= inputArray[windowStart];
                windowStart++;
            }

        }
        //System.out.println(minWindowSize);
        return minWindowSize;
    }

    //PROBLEM 11: Max Sum Subarray of size k
    public static int findMaxSumSubarray(int[] arr, int k) {
        ArrayList<Integer> numberArrayList = new ArrayList<Integer>();
        numberArrayList.add(4);
        numberArrayList.add(2);
        numberArrayList.add(1);
        numberArrayList.add(7);
        numberArrayList.add(8);
        numberArrayList.add(2);
        numberArrayList.add(8);
        numberArrayList.add(1);
        numberArrayList.add(0);


        int maxValue = Integer.MIN_VALUE;
        int currentRunningSum = 0;

        for(int i = 0; i< numberArrayList.size(); i++) {
            currentRunningSum = currentRunningSum + numberArrayList.get(i);
            if (i >= k - 1) {
                maxValue = Math.max(maxValue, currentRunningSum);
                currentRunningSum -= numberArrayList.get(i-(k-1));
            }
        }

        //System.out.println(maxValue);
        return maxValue;

    }

    //PROBLEM 14: Two Sum
    public static void runTwoSumThree() {
        //int[] nums = {2, 7, 11, 15};
        int[] nums = {3, 2, 4};
        int target = 6;
    }

    public static int twoSumThree(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        //Add items to the Hashmap
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);

        }
        System.out.println(map);

        int searchValue;
        int[] answerArray = new int[2];
        //int arrayholder = 0;
        for (int i = 0; i < nums.length; i++) {
            searchValue = target - nums[i];

            System.out.println("searchValue " + searchValue);
            if (map.containsKey(searchValue)) {
                System.out.println("If Loop " + map.get(searchValue));
                //answerArray[arrayholder] = map.get(searchValue);
                //arrayholder = arrayholder + 1;
            } else {
                System.out.println("Not found");
            }
        }

        return 1;


    }


        /*
    //Option 1: Look at the charArray
    System.out.println("Option 1: " + charArray[leftWindow] + " " + charArray[leftWindow + 1] + " " + charArray[leftWindow + 2]+ " " + charArray[leftWindow + 3]);

    //Option 2: Create a small string from the large
    char subString[] = {charArray[leftWindow], charArray[leftWindow + 1], charArray[leftWindow + 2]};
    String eachSubstring = new String(subString);
    System.out.println("Option 2: " + eachSubstring);

    ///Option 3: Only use the original string
    System.out.println("Option 3: " + s.substring(leftWindow, rightWindow));

    leftWindow = leftWindow + 1;
    rightWindow = rightWindow + 1;
    System.out.println(" ");

    * */



        /*
        while (rightWindow <= s.length()) {
            String subString = s.substring(leftWindow, rightWindow);

            List<Character> charList = new ArrayList<Character>();
            Set<Character> charSet = new HashSet<Character>();
            for(char c : subString.toCharArray()) {
                charList.add(c);
                charSet.add(c);
                count = count + 1;
            }
            System.out.println(charSet);

            if(charSet.size() == k - 1) {
                System.out.println("Found one " + subString);
            }
            //System.out.println(charList);
            leftWindow = leftWindow + 1;
            rightWindow = rightWindow + 1;
        }

        */
}



