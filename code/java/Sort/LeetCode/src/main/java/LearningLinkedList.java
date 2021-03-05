import java.util.LinkedList;

public class LearningLinkedList {
    public static void main(String[] args) {

        LinkedList<String> myLinkedList = new LinkedList<String>();

        myLinkedList.add("bilbo");
        myLinkedList.add("david");
        myLinkedList.add("Frodo");
        myLinkedList.add("Galadriel");

        System.out.println(myLinkedList);

        System.out.println(myLinkedList.get(2));

    }


}
