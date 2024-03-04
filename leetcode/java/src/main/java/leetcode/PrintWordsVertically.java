package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintWordsVertically {
    public static void main(String[] args) {
        String s = "HOW ARE YOU";

        printVertically(s);


    }

    public static List<String> printVertically(String s) {
        List<String> words;
        words = Arrays.asList(s.split(" "));

        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i).length() + " | " + words.get(i));
            System.out.println(" ");
        }

        return words;

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