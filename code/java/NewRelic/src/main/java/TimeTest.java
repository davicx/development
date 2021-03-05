import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TimeTest {
    public static void main(String[] args) {
        int startTime = (int) System.currentTimeMillis();

        ArrayList<Integer> millionInts = new ArrayList<Integer>();
        Random rand = new Random();
        int currentNumber = 0;

        for (int j = 0; j<50000; j++) {
            currentNumber = rand.nextInt(50);
            //System.out.println(currentNumber);
            millionInts.add(currentNumber);

        }

        //System.out.println(millionInts.size());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < millionInts.size(); i++) {
            map.put(millionInts.get(i), map.getOrDefault(millionInts.get(i), 0)+ 1);
        }

        int endTime = (int) System.currentTimeMillis();
        int totalTime = endTime - startTime;
        System.out.println("Start " + java.time.LocalDateTime.now() + " Mill: " + System.currentTimeMillis());
        System.out.println("Done " + java.time.LocalDateTime.now() + " Mill: " + System.currentTimeMillis());
        System.out.println("Total: " + totalTime);

    }
}
