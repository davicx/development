import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //int[] height = {4,3,2,1,4};
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));


    }















    public static int maxArea(int[] height) {
        int maxVolume = 0;
        int currentVolume = 0;
        int distance;
        int lowerWall;

        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++) {
                distance = j - i;
                lowerWall = Math.min(height[i], height[j]);
                //System.out.println(height[i] + " " + height[j] + " " + lowerWall);
                System.out.println(distance + " " + lowerWall);

                currentVolume = lowerWall * distance;
                maxVolume = Math.max(maxVolume, currentVolume);
                //System.out.println(currentVolume);

            }
        }
        return maxVolume;

    }

}
