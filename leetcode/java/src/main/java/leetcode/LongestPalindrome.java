package leetcode;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "baba";
        //String s = "";
        //String s = "abba";
        Integer answer = longestPalindrome(s);
        System.out.println("ANSWER " + answer);

    }

    //public static String longestPalindrome(String s) {
    public static Integer longestPalindrome(String s) {
        Integer answer = 0;
        String answerSingle = "";
        Integer answerDouble = 0;

        if(s.length() == 1) {
            return 1;
        }

        if(s.length() == 2) {
            if(s.charAt(0) == s.charAt(1)) {
                return 2;
            } else {
                return 1;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            String currentLongestSingle = checkSingleLetterLength(s,i);
            System.out.println(currentLongestSingle);
            //Integer currentLongestDouble = checkDoubleLetter(s,i);
            if(currentLongestSingle.length() >= answerSingle.length()) {
                answerSingle = currentLongestSingle;
            }
        }

        //answer = Math.max(answerSingle, answerDouble);
        System.out.println("answerSingle " + answerSingle);

        return answer;
    }

    public static String checkSingleLetterLength(String s, Integer place) {
        char startingChar = s.charAt(place);
        String longestString = String.valueOf(startingChar) ;

        Integer currentStringLength = 1;

        //System.out.println("Checking " + s.charAt(place) + " " + place );
        Integer leftPointer = place;
        Integer rightPointer = place;

        for (int i = place; i < s.length(); i++) {
            leftPointer = leftPointer - 1;
            rightPointer = rightPointer + 1;

            if(leftPointer < 0 || rightPointer > s.length() - 1) {
                break;
            }
            char centerChar = s.charAt(i);
            char leftChar = s.charAt(leftPointer);
            char rightChar = s.charAt(rightPointer);

            if(leftChar == rightChar) {
                currentStringLength = currentStringLength + 2;
                //System.out.println("found a match " + currentStringLength + " " + place);
                Integer temp = currentStringLength /2 ;
                Integer stringStartIndex = place - temp;
                Integer stringEndIndex = place + temp + 1;
                System.out.println(stringStartIndex + " " + stringEndIndex);

                longestString = s.substring(stringStartIndex,stringEndIndex);
                //System.out.println(longestString);
            }
        }

        return longestString;
    }


}
