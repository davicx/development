import java.util.LinkedList;
import java.util.Queue;

public class LearningQueue {

    public static void main(String[] args) {
        Queue<String> bbqLine = new LinkedList<String>();
        bbqLine.add("David");
        bbqLine.add("Frodo");
        bbqLine.add("Bilbo");
        System.out.println(bbqLine.peek());
        bbqLine.poll(); //Remove the Next Person
        System.out.println(bbqLine);

    }
}