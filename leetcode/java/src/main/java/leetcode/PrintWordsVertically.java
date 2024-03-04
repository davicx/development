package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintWordsVertically {
    public static void main(String[] args) {
        String s = "HOW ARE YOU";
        //[0][0] [1][0] [2][0]
        //[0][1] [1][1] [2][1]
        //[0][2] [1][2] [2][2]
        //String s = "TO BE OR NOT TO BE";

        printVertically(s);


    }

    public static List<String> printVertically(String s) {
        List<String> words;
        List<String> outputArray = new ArrayList<>();
        Integer maxLength = 0;
        words = Arrays.asList(s.split(" "));

        //STEP 1: Get max length
        for (int i = 0; i < words.size(); i++) {
            maxLength = Math.max(words.get(i).length(), maxLength);
            //System.out.println(words.get(i).length() + " | " + words.get(i));
        }

        //STEP 2: Loop over words
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < words.size(); j++) {
                //System.out.println(j + " " + i);
                System.out.print(words.get(j).charAt(i) + " | ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");


        return outputArray;

    }
}


/*
    public static List<String> printVertically(String s) {
        List<String> words = new ArrayList<>();
        words = Arrays.asList(s.split(" "));

        for (int i = 0; i < 5; i++) {
            //System.out.println(i);
        }

        return words;

    }
 */