import java.util.*;

public class MainToSort {

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
        /*
        for(String word : valid_word_counts.keySet()) {
            System.out.println("key: " + valid_word_counts.get(word) + " value: " + word);
            max = valid_word_counts.get(word);
            result = word;
        }
        */

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

        /*
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

         */

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


}


