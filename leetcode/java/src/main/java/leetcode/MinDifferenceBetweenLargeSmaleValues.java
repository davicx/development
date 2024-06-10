package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinDifferenceBetweenLargeSmaleValues {
    public static void main(String[] args) {
        System.out.println("hi");
        //int[] myNums = {1,2,4,5,12,100,1000};
        int[] myNums = {1,100,101,5000,5001,5002,20000};
        minDifference(myNums);
    }

    public static int minDifference(int[] nums) {
        Arrays.sort(nums);

        PriorityQueue<MinDifference> minDifferenceQueue = new PriorityQueue<>(Comparator.comparing(MinDifference::getDifference).reversed());

        for (int i = 0; i < nums.length - 1; i++) {
            MinDifference tempDifference = new MinDifference(i, i+1, nums[i+1] - nums[i], nums[i]);
            minDifferenceQueue.add(tempDifference);
        }
        int queueSize = minDifferenceQueue.size();

        for (int i = 0; i < queueSize; i++) {
            MinDifference currentQueueVal = minDifferenceQueue.poll();
            System.out.println( "[" + currentQueueVal.getLeft() + ", " + currentQueueVal.getRight() + "]");
            System.out.println(currentQueueVal.getValue() + " " + currentQueueVal.getDifference());
            System.out.println(" ");
        }

        /*
        System.out.println(minDifferenceQueue.size());
        //MinDifference currentVal = minDifferenceQueue.poll();

        System.out.println(currentVal.getLeft());
        System.out.println(minDifferenceQueue.poll().getDifference());
        System.out.println(minDifferenceQueue.poll().getDifference());
        System.out.println(minDifferenceQueue.poll().getDifference());
        System.out.println(minDifferenceQueue.poll().getDifference());
        System.out.println(minDifferenceQueue.poll().getDifference());
        System.out.println(minDifferenceQueue.poll().getDifference());
         */


        return 1;
    }

}


class MinDifference {
    private Integer left;
    private Integer right;
    private Integer difference;


    private Integer value;

    public MinDifference(Integer left, Integer right, Integer difference, Integer value) {
        this.left = left;
        this.right = right;
        this.difference = difference;
        this.value = value;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public Integer getDifference() {
        return difference;
    }

    public void setDifference(Integer difference) {
        this.difference = difference;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

/*
    while (studentQueueIterator.hasNext()) {
        MinDifference currentClass = studentQueueIterator.next();
        System.out.println(currentClass.getLeft() + " " + currentClass.getRight() + " " + currentClass.getDifference());
    }
 */
