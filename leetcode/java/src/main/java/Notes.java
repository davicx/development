import java.util.*;


public class Notes {
    public static void main(String[] args) {

    }


}







/*


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
public class Main {

    public static void main(String[] args) {

        //TreeNode p = TreeNode.newTree(3,9,20,null,null,15,7);
        TreeNode smalltree = TreeNode.newTree(1, 2, 3, 4, 5);
        System.out.println(smalltree.val);

    }




    //PROBLEM 17: Amazon Fresh (Amazon)
    public static void callAmazonFresh() {
        //String[][] codeList = {{ "apple", "apple" }, { "apple", "apple" }, { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[][] codeList = {{ "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart = {"orange", "apple", "apple", "banana", "orange", "banana"};
        amazonFresh(shoppingCart, codeList);
    }


    public static int amazonFresh(String[] shoppingCart, String[][] codeList) {

        //Create a Window that slides over the shopping Cart
        String[] firstCode = codeList[0];
        int leftWindow = 0;
        int rightWindow = firstCode.length;

        Queue<String> shoppingCartQueue = new LinkedList<String>();

        for(int i = 0; i < shoppingCart.length; i++) {
            //System.out.println(shoppingCart[i]);
            shoppingCartQueue.add(shoppingCart[i]);
        }

        System.out.println(shoppingCartQueue);
        shoppingCartQueue.poll();


        for(int j = 0; j < firstCode.length; j++) {
            System.out.println(firstCode[j]);
        }





        return 1;

    }


    char[] charArray = s.toCharArray();
    int indexToRemove = 0;
    Character charToRemove;
    Character charToAdd;

    Map<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < charArray.length; i++) {

        Character c = charArray[i];

        //Once we have k (four) characters we cant start our sliding window
        if (i <= k-1) {
            //System.out.println("don't do anything " + charArray[i]);
            map.put(c, map.getOrDefault(c, 0)+ 1);
            //System.out.println(charArray[i]);
        } else {

            charToRemove = charArray[indexToRemove];
            charToAdd = charArray[i];

            //System.out.println("Char to Remove and Its Current Value " + charToRemove + " "  + map.get(charToRemove));
            if(map.get(charToRemove) == 1) {
                map.remove(charToRemove);
            } else {
                map.put(charToRemove, map.get(charToRemove) - 1);
            }

            //System.out.println("Add " + charToAdd + " Remove " + charToRemove);
            //map.put(charToAdd, map.get(charToAdd) + 1);

            map.put(charToAdd, map.getOrDefault(charToAdd, 0)+ 1);

            indexToRemove++;

        }

        if(i > k - 2) {
            System.out.println(map.size());
        }


        //Could move up into Else statement
        if(map.size() == k - 1) {
            System.out.println(map);
            System.out.println("match");

        } else {
            System.out.println(map);
            System.out.println("NOT A match");

        }
        System.out.println(" ");
    }






    //PROBLEM 16: Maximum Depth of Binary Tree
    public static void callMaxDepth() {
        TreeNode p = TreeNode.newTree(3,9,20,null,null,15,7);
        System.out.println(maxDepth(p));

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //Ask the question what level are you at
        int leftNode = maxDepth(root.left);
        int rightNode = maxDepth(root.right);

        //Take the maximum and add one
        return Math.max(leftNode, rightNode) + 1;

    }


    //PROBLEM 15: Minimum Depth of Binary Tree
    public static void callminTreeDepth() {
        TreeNode p = TreeNode.newTree(3,9,20,null,null,15,7);
        minTreeDepth(p);
        //System.out.println(p.right.left.val);

    }

    public static int minTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            System.out.println(root.val);
        }

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int numberOfNodes = queue.size();

            while(numberOfNodes > 0 ) {
                TreeNode currentNode =  queue.poll();

                //Check For Any Children (If none its a leaf node)
                if(currentNode.left == null && currentNode.right == null) {
                    depth++;
                    return depth;
                }

                //Left Child
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                //Right Child
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }

                numberOfNodes--;
            }
            depth++;

        }
        return depth;
    }



    //PROBLEM 12: Substrings of size K with K - 1 distinct chars (Amazon)
    public static void callSubstringSizeKOptimized() {
        //String: s = "awaglknagawunagwkwagl";
        //k = 4;

        //String s = "awaglk";
        //String s = "abacde";
        int k = 5;
        String s = "democracy";
        //int k = 5;
        //String s = "abcadef";
        //int k = 4;

        substringSizeKRepeatOptimized(s, k);
        //substringSizeKRepeat(s, k);

        //callSubstringSizeKOptimized();
        //Character[] chars = {'a', 'b', 'c', 'd',  'a', 'b'};


        Map<Character, Integer> charMap = new HashMap<>();
        for(Character individualChar : chars) {
            charMap.put(individualChar, charMap.getOrDefault(individualChar, 0)+ 1);
        }

        System.out.println(charMap);

        System.out.println(charMap.get('a'));
        charMap.put('a', charMap.get('a') - 1);
        charMap.put('a', charMap.get('a') - 1);
        charMap.put('a', charMap.get('a') - 1);
        System.out.println(charMap.get('a'));


    }



    public static void substringSizeKRepeatOptimized(String s, int k) {
        char[] charArray = s.toCharArray();
        int indexToRemove = 0;
        Character charToRemove;
        Character charToAdd;

        Map<Character, Integer> map = new HashMap<>();

        //Loop over every character in the Array
        for (int i = 0; i < charArray.length; i++) {

            Character c = charArray[i];

            //Once we have k (four) characters we cant start our sliding window
            if (i <= k-1) {
                //System.out.println("don't do anything " + charArray[i]);
                map.put(c, map.getOrDefault(c, 0)+ 1);
                //System.out.println(charArray[i]);
            } else {

                charToRemove = charArray[indexToRemove];
                charToAdd = charArray[i];

                //System.out.println("Char to Remove and Its Current Value " + charToRemove + " "  + map.get(charToRemove));
                if(map.get(charToRemove) == 1) {
                    map.remove(charToRemove);
                } else {
                    map.put(charToRemove, map.get(charToRemove) - 1);
                }

                //System.out.println("Add " + charToAdd + " Remove " + charToRemove);
                //map.put(charToAdd, map.get(charToAdd) + 1);

                map.put(charToAdd, map.getOrDefault(charToAdd, 0)+ 1);

                indexToRemove++;

            }

            if(i > k - 2) {
                System.out.println(map.size());
            }


            //Could move up into Else statement
            if(map.size() == k - 1) {
                System.out.println(map);
                System.out.println("match");

            } else {
                System.out.println(map);
                System.out.println("NOT A match");

            }
            System.out.println(" ");
        }


        //Sliding Window Analyzing (k) Elements at a time


        int leftWindow = 0;
        int rightWindow = k;

        for (rightWindow = k; rightWindow <= charArray.length; rightWindow++, leftWindow++) {
            String subString = s.substring(leftWindow, rightWindow);

            System.out.println(subString);

            List<Character> charList = new ArrayList<Character>();
            Map<Character, Integer> map = new HashMap<>();

            for(char c : subString.toCharArray()) {
                charList.add(c);
                map.put(c, map.getOrDefault(c, 0)+ 1);
            }

            System.out.println(map);

            if(map.size() == k - 1) {
                System.out.println("Found one " + subString);
            }

        }

    }

    //Works- Not Optimized
    public static void substringSizeKRepeat(String s, int k) {
        char[] charArray = s.toCharArray();

        int leftWindow = 0;
        int rightWindow = k;
        int count = 0;

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
        //System.out.println(count);
    }



    //PROBLEM 4: Max Sum Subarray
    public static void callMaxSumSubArray() {
        //int[] nums = {4,3,2,7,8,2,3,1};
        //int[] nums = {1,2,3,5,4,8,6,2};
        //int[] nums = {4,2,1,7,8,1,2,8,1,0};
        int[] nums = {4,2,1,7,8,2};
        int windowSize = 3;
        System.out.println("ANSWER: " + maxSumSubArray(nums, windowSize));

    }

    public static int maxSumSubArray(int[] nums, int windowSize) {
        int currentSum = 0;
        int maxSumSeen = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
            System.out.println("For " + i);

            if(i >= windowSize - 1) {
                maxSumSeen = Math.max(currentSum, maxSumSeen);
                currentSum = currentSum - nums[i - (windowSize - 1)];
                //System.out.println("Inside If Current Sum " + currentSum);
            }
        }

        return maxSumSeen;
    }



    //PROBLEM 14: Binary Tree Level Order Traversal (102)
    public static void callLevelOrder() {
        TreeNode p = TreeNode.newTree(3,9,20,null,null,15,7);
        System.out.println(p);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        //Create a Q to hold tree nodes to process
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i< size; i++) {
                TreeNode current = queue.remove();
                currentLevel.add(current.val);

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }

            result.add(currentLevel);

        }
        return result;

    }



    //PROBLEM 12: Sliding Window that Grows (Mine)
    public static void callGrowingWindow() {
        String s = "hello";

        growingWindow(s);
    }

    public static void growingWindow(String s) {
        char[] charArray = s.toCharArray();

        int leftWindow = 0;

        for (int rightWindow = 0; rightWindow < charArray.length + 1; rightWindow++) {
            System.out.println(s.substring(leftWindow, rightWindow));
        }
    }



    //PROBLEM 10: Recursion
    public static void callRecursion() {
        //sayHi(5);
        //countBackwards(5);

    }

    public static void sayHi(int n) {
        //Need a Base Case
        if(n == 0) {
            System.out.println("done");
        } else {
            System.out.println("hi");
            n--;
            sayHi(n);
        }
    }

    public static void countBackwards(int n) {
        //Need a Base Case
        if(n == 0) {
            System.out.println("done");
        } else {
            System.out.println(n);
            n--;
            countBackwards(n);
        }
    }





    //PROBLEM 9: Same Tree
    public static void callIsSameTree() {
        TreeNode p = TreeNode.newTree(1, 2, 3, 4, 5);
        TreeNode q = TreeNode.newTree(1, 2, 3);

        System.out.println(isSameTree(p, q));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null ) {
            return true;
        } else if (p == null || q == null ) {
            return false;
        } else if(p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }




    //PROBLEM 8: Word Ladder
    public static void callLadderLength() {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordListString = {"hot","dot","dog","lot","log","cog"};

        List<String> wordList = new ArrayList<String>();

        for (int i = 0; i < wordListString.length; i++) {
            wordList.add(wordListString[i]);
        }

        ladderLength(beginWord, endWord, wordList);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        //Make sure that we have an end word in the set
        if(!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        queue.add(beginWord);

        int changes = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return changes;
                }

                //Check all the Words (the BFS)
                for (int j = 0; j < word.length(); j++) {

                    //Loop over the alphabet
                    for (int k = 'a'; k < 'z'; k++) {
                        char[] arr = word.toCharArray();
                        arr[j] = (char) k;

                        String str = new String(arr);
                        if(set.contains(str) && !visited.contains(str)) {
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            changes = changes + 1;
        }

        return changes;
    }


    //PROBLEM 7: Binary tree Paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String > paths = new ArrayList<>();

        if(root == null) {
            return paths;
        }

        depthFirstSearch(root, "", paths);

        return paths;

    }

    public void depthFirstSearch(TreeNode root, String path, List<String > paths) {
        path = path + root.val;

        //Case 1: At a Leaf Node (no more children to traverse)
        if(root.left == null && root.right == null) {
            paths.add(path);
            return;
        }

        //Case 2: Keep traversing Left Child
        if(root.left != null) {
            depthFirstSearch(root.left, path + "->", paths);
        }

        //Case 3: Keep traversing Right Child
        if(root.right != null) {
            depthFirstSearch(root.right, path + "->", paths);
        }
    }



    //PROBLEM 6: Fixed Sliding Window (My Example)
    public static void callFixedSlidingWindow() {

        //String s = "abcabcabc";
        String s = "abcde";
        char[] charArray = s.toCharArray();
        int k = 3;

        int leftWindow = 0;
        int rightWindow = 3;

        while (rightWindow <= charArray.length) {

            //Option 1: Look at the charArray
            System.out.println("Option 1: " + charArray[leftWindow] + " " + charArray[leftWindow + 1] + " " + charArray[leftWindow + 2]);

            //Option 2: Create a small string from the large
            char subString[] = {charArray[leftWindow], charArray[leftWindow + 1], charArray[leftWindow + 2]};
            String eachSubstring = new String(subString);
            System.out.println("Option 2: " + eachSubstring);

            ///Option 3: Only use the original string
            System.out.println("Option 3: " + s.substring(leftWindow, rightWindow));

            leftWindow = leftWindow + 1;
            rightWindow = rightWindow + 1;
            System.out.println(" ");
        }
    }



    //PROBLEM 5: Longest Substring Without Repeating Characters
    public static void callLengthOfLongestSubstring() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int leftWindow = 0; //i
        int rightWindow = 0; //j
        int longestString = 0;
        int totalLoops = 1;

        HashSet<Character> currentSetOfCharacters = new HashSet<>();

        while (leftWindow < s.length()) {

            if (!currentSetOfCharacters.contains(s.charAt(leftWindow))){
                currentSetOfCharacters.add(s.charAt(leftWindow));
                System.out.println("If Statement ");

                leftWindow = leftWindow + 1;
                longestString = Math.max(currentSetOfCharacters.size(), longestString);
            } else {
                currentSetOfCharacters.remove(s.charAt(rightWindow));
                rightWindow = rightWindow + 1;
                System.out.println("Else Statement ");
            }
            System.out.println();
            totalLoops = totalLoops + 1;

        }
        return longestString;

    }



    //PROBLEM 3: Number of Islands
    public static void calltopKFrequent() {

        //Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
        //Input: [], k = 4
        //String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        //int k = 4;
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        topKFrequent(words, k);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            System.out.println(word);
            //If word is in there put it in and add to count by one if not default to zero
            map.put(word, map.getOrDefault(word, 0)+ 1);


        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

            @Override
            public int compare(String word1, String word2) {
                int frequency1 = map.get(word1);
                int frequency2 = map.get(word2);

                if(frequency1 == frequency2) {
                    return word2.compareTo(word1);
                }

                return frequency1 - frequency2;
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
            if(pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();

        //Add elements to list from the Priority Q
        while(!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);
        System.out.println(result);

        return result;

    }


    //PROBLEM 2: Number of Islands
    public static void callNumIslands() {
        char[][] grid = {   {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        char[][] smallGrid = {
                {'1','0','1'},
                {'1','1','0'}
        };

        numIslands(smallGrid);
    }

    private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) { return 0;}

        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //System.out.println(grid[i][j]);
                if(grid[i][j] == '1') {
                    islands = islands + 1;
                    //System.out.println("one found");
                    fillWithWater(grid, rows, cols, i, j);
                }
            }
        }
        System.out.println(islands);
        return islands;

    }

    public static void fillWithWater(char[][] grid, int rows, int cols, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        //2D to 1D: R* cols + C
        //1D to 2D: index / #cols = R, index % #cols = C
        queue.add(i * cols + j);
        grid[i][j] = '0';

        while(!queue.isEmpty()) {
            int index = queue.poll();

            //Convert back to 2D
            int row = index / cols;
            int col = index % cols;

            for(int[] direction : DIRECTIONS) {
                int x = direction[0] + row;
                int y = direction[1] + col;
                if(x > -1 && x < rows && y > -1 && y < cols && grid[x][y] == '1') {
                    grid[x][y] = '0';
                    queue.add(x * cols + y);
                }

            }
        }
    }



    //PROBLEM 1: Find All Duplicates in an Array
    public static void callFindDuplicates() {
        int[] nums = {4,3,2,7,8,2,3,1};
        findDuplicates(nums);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                result.add(index + 1);
            }
            nums[index] = -nums[index];

        }
        return result;

    }
}


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

        for(String word : valid_word_counts.keySet()) {
            System.out.println("key: " + valid_word_counts.get(word) + " value: " + word);
            max = valid_word_counts.get(word);
            result = word;
        }


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


}


import java.util.*;

public class Master {
    public static void main(String[] args) {

        //ALGORITHMS
        //Type 1: Sliding Window


        //Type 2: Hash Map with Count

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



        //Like an array
        HashSet<String> myHashSet = new HashSet();

        myHashSet.add("davey");
        myHashSet.add("bilbo");
        myHashSet.add("frodo");

        System.out.println(myHashSet);


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



        String[] words = {"one", "two", "two", "three",  "three", "three"};

        Map<String, Integer> mapCount = new HashMap<>();
        for(String word : words) {
            mapCount.put(word, mapCount.getOrDefault(word, 0)+ 1);
        }


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

 */

