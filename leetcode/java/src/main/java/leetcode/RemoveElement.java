package leetcode;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println("hi");

        //int[] nums = {3,2,2,3};
        //int[] nums = {1,2,3,4};
        int[] nums = {0,1,2,2,3,0,4,2};
        //[0,1,2,2,3,0,4,2]
        int answer = removeElement(nums, 2);
        printArray(nums);
        System.out.println(answer);

    }

    public static int removeElement(int[] nums, int val) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val){
                answer = answer + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int nextAvailableSpace = determineAvailableArrayEnd(nums, val);
            if(i >= nextAvailableSpace) {
                System.out.println(" i + "  +  i + "  is greater then space " + nextAvailableSpace);
                break;
            }

            if(nums[i] == val){
                swapArrayElements(nums, i, nextAvailableSpace);
            }
        }

        return answer;
    }


    public static int[] swapArrayElements(int[] nums, int leftIndex, int rightIndex) {
        int tempLeftValue = nums[leftIndex];
        int tempRightValue = nums[rightIndex];


        nums[leftIndex] = tempRightValue;
        nums[rightIndex] = tempLeftValue;


        return nums;
    }

    public static int determineAvailableArrayEnd(int[] nums, int val) {
        for (int i = nums.length -1; i >= 0; i--) {
            if(nums[i] != val){
                return i;
            }
        }
        return -1;
    }


    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
    }



}


/*

        printArray(nums);
        swapArrayElements(nums, 0,3);
        printArray(nums);
        swapArrayElements(nums, 1,2);
        printArray(nums);

    public static int removeElement(int[] nums, int val) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            int availableArrayIndex = determineAvailableArrayEnd(nums, val);

            if(availableArrayIndex == -1 || availableArrayIndex < i) {
                break;
            }

            //Start swap
            if(nums[i] == val) {
                System.out.println("Swapping");
                int leftValue = nums[i]; //3
                int rightValue = nums[availableArrayIndex]; //2

                nums[i] = rightValue;
                nums[rightValue] = leftValue;

            }

            printArray(nums);
        }

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                answer = answer + 1;
            }
        }

        return answer;
    }
public static int[] swapElements(int[] nums, int i) {
    //swapped = false and i > 0
    boolean swapped = false;
    Integer endOfArray = nums.length - 1;
    Integer currentValue = nums[i];

    while(swapped = false && i > 0) {

    }

    return nums;
}
if(nums[i] != val) {
    answer = answer + 1;
}
 */