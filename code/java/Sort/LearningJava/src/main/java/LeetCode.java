public class LeetCode {

    public static void main(String[] args) {

        //RUN CODE: Two Sum
        int[] nums = {2, 7, 11, 15};
        int[] numsTwo = {3,2,4};

        int[] answer = twoSum(nums, 6);

        System.out.println("Answer");
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }


        


    }

    //PROBLEM 1: Two Sum
    public static int[] twoSum(int[] nums, int target) {
        int answerArray[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println(nums[i] + " " + nums[j]);
                int current_sum = nums[i] + nums[j];
                if(target == current_sum) {
                    answerArray[0] =  nums[i];
                    answerArray[1] =  nums[j];
                    return answerArray;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }



}

/*

    public static int[] twoSum(int[] nums, int target) {
        //int[] anArray = new int[2];
        int answerArray[] = new int[2];
        outerloop:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println(nums[i]);
                System.out.println(nums[j]);
                int tempSum = nums[i] + nums[j];
                if (tempSum == target) {
                    System.out.println("equals");
                    answerArray[0] = i;
                    answerArray[1] = j;
                    //break outerloop;
                } else {
                    System.out.println("Does not Equal");
                }
            }
        }

        return answerArray;



                int tempSum = nums[i] + nums[j];
                if (tempSum == target) {
                    int[] answerArray = {i, j};
                    System.out.println("equals");
                    return answerArray;
                } else {
                    int[] failureArray = {0, 1};
                    System.out.println("Does not Equal");
                    return failureArray;
                }

            }

        }


    }


    */