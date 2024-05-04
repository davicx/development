package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortArrays {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> intervals = createIntervals();

        //TYPE 1: Sort Integers
        System.out.println("TYPE 1: Sort Integers");
        System.out.println(intervals);
        Collections.sort(intervals, Comparator.comparing(o -> o.get(0)));
        System.out.println(intervals);
        System.out.println(" ");

        //Type 2: Sort Strings
        System.out.println("Type 2: Sort Strings");
        ArrayList<ArrayList<String>> namesAndNumbers = createStrings();
        System.out.println(namesAndNumbers);
        //Collections.sort(namesAndNumbers, (o1, o2) -> o1.get(0).compareTo(o2.get(0)));
        Collections.sort(namesAndNumbers, Comparator.comparing(o -> o.get(0)));
        System.out.println(namesAndNumbers);
    }

    public static ArrayList<ArrayList<Integer>> createIntervals() {
        //intervals = [[1,3],[2,6],[8,10],[15,18]]
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        ArrayList<Integer> three = new ArrayList<>();
        one.add(1);
        one.add(4);
        two.add(8);
        two.add(12);
        three.add(2);
        three.add(5);
        intervals.add(three);
        intervals.add(one);
        intervals.add(two);

        return intervals;

    }

    public static ArrayList<ArrayList<String>> createStrings() {
        ArrayList<ArrayList<String>> namesAndNumbers = new ArrayList<ArrayList<String>>();
        namesAndNumbers.add(new ArrayList<String>(Arrays.asList("Mike", "(805) 766-4920")));
        namesAndNumbers.add(new ArrayList<String>(Arrays.asList("Emily", "(705) 668-9292", "(705) 555-1060")));
        namesAndNumbers.add(new ArrayList<String>(Arrays.asList("James", "(605) 965-2000")));

        return namesAndNumbers;

    }

}
