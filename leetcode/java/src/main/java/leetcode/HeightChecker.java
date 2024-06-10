package leetcode;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        Integer[] heights = {1,1,4,2,1,3};


    }

    public static int heightChecker(int[] heights) {
        System.out.println(heights);

        //STEP 1: Copy Original Array
        int heightsSorted[] = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            heightsSorted[i] = heights[i];
        }

        Arrays.sort(heightsSorted);

        //Print them
        for (int i = 0; i < heights.length; i++) {
            System.out.print(heights[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < heightsSorted.length; i++) {
            System.out.print(heightsSorted[i] + " ");
        }

        return 1;

    }
}
