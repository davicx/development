package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> intervals = createIntervals();
        ArrayList<ArrayList<Integer>> answer = merge(intervals);
        System.out.println("ANSWER");
        System.out.println(answer);
    }


    public static ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> intervals) {
        ArrayList<ArrayList<Integer>> answerArray = new ArrayList<>();

        //STEP 1: Check for small input
        if(intervals.size() < 2) {
            return intervals;
        }

        //STEP 2: Sort the intervals
        Collections.sort(intervals, Comparator.comparing(o -> o.get(0)));

        //STEP 3: Merge
        ArrayList<Integer> tempInterval = intervals.get(0);
        Boolean newInterval = true;

        for (int i = 0; i < intervals.size(); i++) {

            //Last interval
            if(i == intervals.size() - 1) {
                System.out.println("Last interval " + intervals.get(i));
            }

            //We just added a new interval so we need to start over
            if(newInterval == true) {
                tempInterval = intervals.get(i);
                newInterval = false;

            //Check if we can merge
            } else {
                if(tempInterval.get(1) < intervals.get(i).get(0)) {
                    answerArray.add(tempInterval);
                    newInterval = true;
                } else {
                    Integer newRight = Math.max(tempInterval.get(1), intervals.get(i).get(1));
                    tempInterval.add(1,newRight);
                }
            }
        }

        return answerArray;

    }

    public static ArrayList<ArrayList<Integer>> createIntervals() {
        //intervals = [[1,3],[2,6],[8,10],[15,18]]
        //intervals = [[1,3],[5,9],[8,10],[15,18]]
        //intervals = [[1,3],[5,9],[8,10]
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        ArrayList<Integer> three = new ArrayList<>();
        ArrayList<Integer> four = new ArrayList<>();
        one.add(1);
        one.add(3);
        two.add(6);
        two.add(9);
        three.add(8);
        three.add(10);
        four.add(15);
        four.add(18);

        intervals.add(three);
        intervals.add(one);
        intervals.add(two);
        intervals.add(four);

        return intervals;

    }
}




/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> intervals = createIntervals();
        ArrayList<ArrayList<Integer>> answer =  merge(intervals);
        System.out.println(answer);

    }

    public static ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> intervals) {
        ArrayList<ArrayList<Integer>> answerArray = new ArrayList<>();

        if(intervals.size() < 1) {
            return intervals;
        }

        //STEP 1: Sort the intervals
        Collections.sort(intervals, Comparator.comparing(o -> o.get(0)));

        //STEP 2: Merge
        for (int i = 0; i < intervals.size(); i++) {
            //System.out.println(intervals.get(i));
            if(answerArray.size() == 0 || answerArray.get(answerArray.size() - 1).get(1) < intervals.get(i).get(0)) {
                answerArray.add(intervals.get(i));
            } else {
                Integer leftValue = answerArray.get(answerArray.size() - 1).get(0);
                Integer rightValue = Math.max(intervals.get(i).get(1), answerArray.get(answerArray.size() - 1).get(1));
                //answerArray.add(answerArray.size() - 1).get(1), leftValue);
                System.out.println("here");
                System.out.println(answerArray.get(answerArray.size() - 1).get(0));
                System.out.println(answerArray.get(answerArray.size() - 1).get(1));
                ArrayList<Integer> tempArray = new ArrayList<>();
                tempArray.add(leftValue);
                tempArray.add(rightValue);
                System.out.println(tempArray);
                Integer index = answerArray.size() - 1;

                answerArray.set(index, tempArray);

            }


            /*
            if(answerArray.size() == 0 || intervals.get(i).get(0) > answerArray.get(answerArray.size() - 1).get(1)) {
                answerArray.add(intervals.get(i));
            } else {
                Integer currentValue = Math.max(intervals.get(i).get(1), answerArray.get(answerArray.size() - 1).get(1));
                answerArray.get(answerArray.size() -1).add(1, currentValue);
                //answerArray.get(answerArray.size() - 1).get(1)) =
            }
            }
        if(answerArray.length == 0 || intervals[i][0] > answerArray[answerArray.length-1][1]) {
            answerArray.push(intervals[i])
        } else {
            answerArray[answerArray.length - 1][1] = Math.max(intervals[i][1], answerArray[answerArray.length-1][1])
        }


        }

                return answerArray;

                }



               if(answerArray.size() == 0 || intervals.get(i).get(0) > answerArray.get(answerArray.size() - 1).get(1)) {
                answerArray.add(intervals.get(i));
            } else {
                Integer newValue = Math.max(answerArray.get(answerArray.size() - 1).get(1), intervals.get(i).get(1));
                answerArray.get(answerArray.size()-1).set(1,newValue);
            }

    function mergeIntervals(intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }
        var answerArray = [];
        intervals.sort(sortFunction);

        for (let i = 0; i < intervals.length; i++) {
            if(answerArray.length == 0 || intervals[i][0] > answerArray[answerArray.length - 1][1]) {
                answerArray.push(intervals[i]);
            } else {
                answerArray[answerArray.length - 1][1] = Math.max(answerArray[answerArray.length - 1][1], intervals[i][1])
            }
            //console.log(intervals[i][0] + " " + answerArray[answerArray.length - 1][1]);
            //console.log(intervals[0][0] + " " + intervals[i][1]);
        }
        return answerArray;
    }


 */
