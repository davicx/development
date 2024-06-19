package leetcode;

import java.util.Arrays;

//STATUS: Accepted
public class HeightChecker {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        int answer = heightChecker(heights);
        System.out.println(answer);
    }

    public static int heightChecker(int[] heights) {
        int answer = 0;
        if(heights.length <= 1) {
            return heights.length;
        }

        //STEP 1: Copy Original Array
        int heightsSorted[] = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            heightsSorted[i] = heights[i];
        }

        Arrays.sort(heightsSorted);

        System.out.println(" ");
        for (int i = 0; i < heightsSorted.length; i++) {
            System.out.println(heightsSorted[i] + " " + heights[i]);
            if(heightsSorted[i] != heights[i]) {
                answer = answer + 1;
            }
        }

        return answer;

    }
}
