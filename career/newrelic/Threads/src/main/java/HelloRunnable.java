public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
        hello();
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }

    public void hello() {
        System.out.println("Hello DV!");
    }
}


