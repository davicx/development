package tools;
import java.util.Comparator;
import java.util.PriorityQueue;


public class PriorityQueueTool<S> {
    public static void main(String[] args) {
        //System.out.println("hi");
        //simpleQueue();

        queueWithClass();

        //-1
        //System.out.println("aa".compareToIgnoreCase("bb"));


    }

    public static void queueWithClass() {

        //Create Users
        SimpleUser a = new SimpleUser("a", 15);
        SimpleUser b = new SimpleUser("b",2);
        SimpleUser c = new SimpleUser("c",6);
        SimpleUser d = new SimpleUser("d",4);
        SimpleUser e = new SimpleUser("e",200 );
        SimpleUser f = new SimpleUser("f", 6);

        //Example 1: Sort by User name
        PriorityQueue<SimpleUser> myFriends = new PriorityQueue<>(Comparator.comparing(SimpleUser::getUserName));
        myFriends.add(f);
        myFriends.add(b);
        myFriends.add(c);
        myFriends.add(a);
        myFriends.add(d);
        myFriends.add(a);
        myFriends.add(e);

        System.out.println("ANSWER: Sort by User Name");
        System.out.println(myFriends.poll().getUserName());
        System.out.println(myFriends.poll().getUserName());
        System.out.println(myFriends.poll().getUserName());
        System.out.println(myFriends.poll().getUserName());
        System.out.println(myFriends.poll().getUserName());
        System.out.println(myFriends.poll().getUserName());
        System.out.println(myFriends.poll().getUserName());
        System.out.println(" ");

        //Example 2: Sort by User ID
        PriorityQueue<SimpleUser> myFriendsID = new PriorityQueue<>(Comparator.comparing(SimpleUser::getUserID));
        myFriendsID.add(f);
        myFriendsID.add(b);
        myFriendsID.add(c);
        myFriendsID.add(a);
        myFriendsID.add(d);
        myFriendsID.add(a);
        myFriendsID.add(e);

        System.out.println("ANSWER: Sort by User ID");
        System.out.println(myFriendsID.poll().getUserID());
        System.out.println(myFriendsID.poll().getUserID());
        System.out.println(myFriendsID.poll().getUserID());
        System.out.println(myFriendsID.poll().getUserID());
        System.out.println(myFriendsID.poll().getUserID());
        System.out.println(myFriendsID.poll().getUserID());
        System.out.println(" ");

        //Example 3: Sort by User Name in Reverse
        PriorityQueue<SimpleUser> myFriendsReverse = new PriorityQueue<>(Comparator.comparing(SimpleUser::getUserName).reversed());
        myFriendsReverse.add(f);
        myFriendsReverse.add(b);
        myFriendsReverse.add(c);
        myFriendsReverse.add(a);
        myFriendsReverse.add(d);
        myFriendsReverse.add(a);
        myFriendsReverse.add(e);

        System.out.println("ANSWER: Sort by User Name in Reverse Order  s");
        System.out.println(myFriendsReverse.poll().getUserName());
        System.out.println(myFriendsReverse.poll().getUserName());
        System.out.println(myFriendsReverse.poll().getUserName());
        System.out.println(myFriendsReverse.poll().getUserName());
        System.out.println(myFriendsReverse.poll().getUserName());
        System.out.println(myFriendsReverse.poll().getUserName());
        System.out.println(myFriendsReverse.poll().getUserName());

        System.out.println(" ");

    }

    public static void simpleQueue() {
        PriorityQueue<String> myQueue = new PriorityQueue<>();

        myQueue.add("Sam");
        myQueue.add("Frodo");
        myQueue.add("Merry");
        myQueue.add("David");

        //System.out.print(myQueue);
        System.out.println("Get top element: " + myQueue.peek());

        // Remove the top element of the queue
        myQueue.poll();
        System.out.print(myQueue);

    }


}

class FriendComparator implements Comparator<SimpleUser> {
    public int compare(SimpleUser userOne, SimpleUser userTwo) {
        if (userOne.getUserName().compareToIgnoreCase(userTwo.getUserName()) > 0)
            return 1;
        else if (userOne.getUserName().compareToIgnoreCase(userTwo.getUserName()) < 0)
            return -1;
        return 0;
    }
}

class SimpleUser {
    private String userName;
    private Integer userID;

    public SimpleUser(String userName, Integer userID) {
        this.userID = userID;
        this.userName = userName;
    }

    //Get Username
    public String getUserName() {
        return userName;
    }

    //Set Username
    public void setUserName(String userName) {
        this.userName = userName;
    }

    //Get User ID
    public Integer getUserID() {
        return userID;
    }

}
