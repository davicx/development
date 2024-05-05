package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortCharsAscending {
    public static void main(String[] args) {
        ArrayList<String> charsArray = new ArrayList<>();
        charsArray.add("H");
        charsArray.add("B");
        charsArray.add("M");
        charsArray.add("A");
        charsArray.add("N");
        charsArray.add("L");

        charsArray.sort(Comparator.naturalOrder());
        System.out.println(charsArray);

        charsArray.sort(Comparator.reverseOrder());
        System.out.println(charsArray);

        ArrayList<String> answer = sortCharsAscending(charsArray);
        System.out.println(answer);

    }

    public static ArrayList<String> sortCharsAscending(ArrayList<String> chars) {
        ArrayList<String> answer = new ArrayList<>();
        PriorityQueue<String> charQueue = new PriorityQueue<>();

        for (String c : chars) {
            //System.out.println(c);
            charQueue.add(c);
        }

        Integer size = charQueue.size();

        for (int i = 0; i < size; i++) {
            String currentChar = charQueue.poll();
            //System.out.println(currentChar);
            //System.out.println(charQueue.poll());
            answer.add(currentChar);
        }

        return answer;
    }


}
