import java.util.*;

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

        /*
        for(int j = 0; j < firstCode.length; j++) {
            System.out.println(firstCode[j]);
        }
        */




        return 1;

    }

    /*
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
*/





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

        /*
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

         */
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

        /*
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
        */
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