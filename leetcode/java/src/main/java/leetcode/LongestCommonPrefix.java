package leetcode;

import java.util.HashSet;
import java.util.Set;


//STATUS: Accepted
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String answer = longestCommonPrefix(strs);
        System.out.println(answer);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }

        //STEP 1: Get smallest word
        Integer longestWordLength = strs[0].length();

        for (int i = 0; i < strs.length; i++) {
            longestWordLength = Math.min(longestWordLength, strs[i].length());
        }

        //STEP 2: Find the longest prefix
        Integer longestPrefix = 0;

        for (int i = 0; i < longestWordLength; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < strs.length; j++) {
                set.add(strs[j].charAt(i));
            }

            if(set.size() == 1) {
                longestPrefix = longestPrefix + 1;
            } else {
                break;
            }
        }

        return strs[0].substring(0, longestPrefix);

    }
}

