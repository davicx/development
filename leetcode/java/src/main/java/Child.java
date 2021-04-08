public class Child extends Parent {
    String parentsName;

    //Constructor
    public Child(String parentsName, int userID) {
        super(userID);
        this.parentsName = parentsName;
    }

    //Say Hello
    public void sayHello(String message) {
        System.out.println("Hello, " + message);
    }

    //Method Overloading
    public void sayHello() {
        System.out.println("Hello");
    }

}
