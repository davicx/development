package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class AmazonMaximizeRevenue {
    public static void main(String[] args) {
        /*
        ArrayList<Integer> products = new ArrayList<Integer>();
        products.add(1);
        products.add(2);
        products.add(4);
         */

        ArrayList<Integer> products = new ArrayList<Integer>();
        products.add(10);
        products.add(10);
        products.add(8);
        products.add(9);
        products.add(1);

        //Type of item (n)
        //Customers or Items Sold (m)
        int answer = maximizeRevenue(products, 5, 6);
        System.out.println(answer);

    }


    public static Integer maximizeRevenue(ArrayList<Integer> products, Integer itemTypes, Integer customers) {
        Integer totalRevenue = 0;

        for (int i = 0; i < customers; i++) {
            Collections.sort(products);
            Integer lastArrayElement = products.size() - 1;

            //Get Price of Last Item and add to total
            Integer itemPrice = products.get(lastArrayElement);

            totalRevenue = totalRevenue + itemPrice;
            Integer updatedPrice = itemPrice - 1;

            products.set(lastArrayElement, updatedPrice);

        }

        return totalRevenue;

    }


    public static Integer sumArray(ArrayList<Integer> nums) {
        Integer sum = 0;

        for (int i = 0; i < nums.size(); i++) {
            sum = sum + nums.get(i);
        }

        return sum;

    }

}


/*

        ArrayList<String> products = new ArrayList<String>();
        int answer = heightChecker(products);


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
 */