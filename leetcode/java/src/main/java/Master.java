import java.util.ArrayList;

public class Master {
    public static void main(String[] args) {
        String myString = "hi";

        User currentUser = new User(1, "Davey");
        User userFriend = new User(2, "Bilbo");

        //boolean result = currentUser.getClass().equals( userFriend.getClass());
        currentUser.addFriend("bilbo");
        currentUser.addFriend("frodo");

        System.out.println(currentUser.getFriends());

        //Inheritance
        Parent parentClass = new Parent(1);
        Child childClass = new Child("My parent has ID 2", 2);
        System.out.println(parentClass.userID);
        System.out.println(childClass.parentsName);
        childClass.sayHello("davey");
        childClass.sayHello();








    }

}


