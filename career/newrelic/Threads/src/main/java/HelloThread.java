
public class HelloThread extends Thread {

    public void run() {
        System.out.println("Hello from a thread!");
        hello();
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
    }

    public void hello() {
        System.out.println("Hello DV!");
    }
}