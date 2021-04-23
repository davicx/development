package classes;

public class myStatic {
    static int a = 10;
    static int b;

    // static block
    static {
        System.out.println("Static block initialized.");
        b = a * 4;
    }
    public static void sayHello() {
        System.out.println("hiya!");
        System.out.println(b);
    };

}
