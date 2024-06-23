package leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        //Input: s = "()"
        //String s = "()[]{}";
        //String s = "((";
        //String s = "){";
        String s = "(){}}{";
        //Input: s = "(]"
        //String s ="()";
        Boolean answer = isValid(s);
        System.out.println("Answer " + answer);

    }

    public static boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();

        if ((s.length() % 2) != 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);

            if(charStack.size() == 0) {
                if(currentChar == ')' || currentChar == ']' || currentChar == '}') {
                    return false;
                }
            }

            //Opening Bracket (put on Queue)
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                charStack.add(currentChar);

            //Closing Bracket
            } else {
                Character topOfStackChar = charStack.peek();
                Character closingCharType = getClosingCharacterType(topOfStackChar);

                if(currentChar == closingCharType) {
                    charStack.pop();
                } else {
                    return false;
                }
            }
        }

        if(charStack.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static Character getClosingCharacterType(Character c) {
        if(c == '(') {
            return ')';
        } else if (c== '[') {
            return ']';
        } else if (c== '{') {
            return '}';
        } else {
            return '-';
        }
    }

}
