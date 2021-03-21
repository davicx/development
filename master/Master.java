import java.util.ArrayList;

public class JumpingOnClouds {

    public static void main(String[] args) {
        //int[] ar = {0,0,0,1,0,0};
        //int[] ar = {0, 1, 0, 1, 0, 0, 1, 0};

        //int[] ar = {0, 1, 0 };
        //int[] ar = {0, 1, 0, 0, 0, 0};
        int[] ar = {0, 0, 1, 0, 0, 1, 0};
        System.out.println("ANSWER " + jumpingOnClouds(ar));

    }

    static int jumpingOnClouds(int[] c) {
        int totalJumps = 0;
        int[] cloudsArray = c;
        int lastCloudIndex = c.length - 1;
        int nextToLastCloudIndex = c.length - 2;

        for (int i = 0; i < lastCloudIndex; i++) {
            if(i != nextToLastCloudIndex) {

                //Jump 2
                if (cloudsArray[i + 2] == 0) {
                    i++;
                }
            }

            totalJumps++;

            System.out.println(cloudsArray[i]);
        }

        return totalJumps;

    }
}


        /*
        while (currentCloudIndex < fullCloudPathLength) {

            if(currentCloudIndex < nextToLastCloudIndex) {

                //Make the Jump
                nextCloudLongJump = c[currentCloudIndex + 2];

                if (nextCloudLongJump == 0) {
                    currentCloudIndex = currentCloudIndex + 2;
                } else {
                    currentCloudIndex = currentCloudIndex + 1;
                }
                totalJumps++;
                //System.out.println(cloudsArray[currentCloudIndex] + " | " +  " Total Jumps " + totalJumps + " " + fullCloudPathLength + " " + currentCloudIndex);
                System.out.println(cloudsArray[currentCloudIndex] + " | " +  " Total Jumps " + totalJumps);
            }

            if(currentCloudIndex == nextToLastCloudIndex) {
                totalJumps++;
                System.out.println("next to last cloud ");
                System.out.println(cloudsArray[currentCloudIndex] + " | " +  " Total Jumps " + totalJumps);
                //System.out.println(cloudsArray[currentCloudIndex] + " | " + fullCloudPathLength + " " + currentCloudIndex);
            }

            if(currentCloudIndex == lastCloudIndex) {
                System.out.println("last cloud ");
                System.out.println(cloudsArray[currentCloudIndex] + " | " +  " Total Jumps " + totalJumps);
                //System.out.println(cloudsArray[currentCloudIndex] + " | " + fullCloudPathLength + " " + currentCloudIndex);
            }
            System.out.println("CURRENT INDEX " + currentCloudIndex);

            currentCloudIndex++;

        }
        return totalJumps;

    }
 */



        /*
                    //ACTION 1: You are not on the last cloud or second to last cloud
            if(currentCloudIndex != lastCloudIndex || currentCloudIndex != nextToLastCloudIndex) {
                System.out.println(cloudsArray[currentCloudIndex]);

            } else {

                //ACTION 2: You are next to the last cloud do a small jump there and exit
                if (currentCloudIndex == nextToLastCloudIndex) {
                    System.out.println("One away " + cloudsArray[currentCloudIndex]);

                //ACTION 3: You are on the last cloud yay!
                } else {
                    System.out.println("Last Cloud " + cloudsArray[currentCloudIndex]);
                }

            }

            currentCloudIndex++;

        * */
        /*



            //ACTION 1: You are not on the last cloud or second to last cloud
            if(currentCloudIndex != lastCloudIndex) {
                System.out.println(currentCloudIndex);


            } else {

                System.out.println("ELSE " + currentCloudIndex);

            }

            currentCloudIndex++;


        }
*/
            /*

            if (currentCloudIndex == lastCloudIndex) {
                return totalJumps;

                //ACTION 2: You are next to the last cloud do a small jump there and exit
            } else if (currentCloudIndex == lastCloudIndex - 1) {
                totalJumps++;
                return totalJumps;

                //ACTION 3: If your not at the end do a small or long jump
            } else {
                nextCloudLongJump = c[currentCloudIndex + 2];

                if (nextCloudLongJump == 0) {
                    currentCloudIndex = currentCloudIndex + 2;
                } else {
                    currentCloudIndex = currentCloudIndex + 1;
                }
                totalJumps++;
                return totalJumps;
            }

        }

        */


    /*

      int totalJumps = 0;
        int currentCloudIndex = 0;
        int[] cloudsArray = c;
        int pathLength = c.length;
        int cloudFromLongJump = 0;
        int largeJump = 2;


        while(currentCloudIndex < pathLength) {
            cloudFromLongJump = c[currentCloudIndex + largeJump];

            if (cloudFromLongJump == 0) {
                currentCloudIndex = currentCloudIndex + 2;
            } else {
                currentCloudIndex = currentCloudIndex + 1;
            }

            System.out.println("Index " + currentCloudIndex + " Value " + cloudsArray[currentCloudIndex]);
            System.out.println("Total Jumps: " + totalJumps);

            totalJumps++;
        }


        return totalJumps;
     */

    /*

        //Your are at the last jump (Two Away)
        if (currentCloudIndex == pathLength - 2) {
            cloudFromLongJump = cloudsArray[currentCloudIndex + largeJump];
        }

        //Your are at the last jump (One Away)
        if(currentCloudIndex == pathLength - 1) {

        }
     */
/*
       //Empty Array
        if(cloudsArray.length == 0) {
            return 0;
        }
            //You Landed on the Last Cloud
            if (currentCloudIndex == pathLength) {

                break;

            //You were one away from the final cloud
            } else if (currentCloudIndex == pathLength - 1) {
                totalJumps++;
                break;

            //Find the Next Cloud to Jump To
            } else if (currentCloudIndex <= pathLength - 2){

                cloudFromLongJump = c[currentCloudIndex + largeJump];
                if (cloudFromLongJump == 0) {
                    currentCloudIndex = currentCloudIndex + 2;
                } else {
                    currentCloudIndex = currentCloudIndex + 1;
                }
                totalJumps++;
            } else {

            }


 if(currentCloudIndex + largeJump < c.length) {
                cloudFromLongJump = c[currentCloudIndex + largeJump];
            } else {
                if(currentCloudIndex < cloudLength) {
                    totalJumps++;
                }

                return totalJumps;
            }

            if (cloudFromLongJump == 0) {
                currentCloudIndex = currentCloudIndex + 2;
            } else {
                currentCloudIndex = currentCloudIndex + 1;
            }
            totalJumps++;

        while(currentCloudIndex < cloudLength) {
            if(currentCloudIndex + largeJump < c.length) {
                cloudFromLongJump = c[currentCloudIndex + largeJump];
            } else {
                if(currentCloudIndex < cloudLength) {
                    totalJumps++;
                }

                return totalJumps;
            }

            if (cloudFromLongJump == 0) {
                currentCloudIndex = currentCloudIndex + 2;
            } else {
                currentCloudIndex = currentCloudIndex + 1;
            }
            totalJumps++;
            System.out.println("Index " + currentCloudIndex + " Value " + c[currentCloudIndex]);
            System.out.println("Total Jumps: " + totalJumps);
        }
 */