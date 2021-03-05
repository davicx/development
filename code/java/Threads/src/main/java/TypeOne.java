public class TypeOne {

    //Not considered as nice!
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    public static class MyThread extends Thread {
        public void run(){
            System.out.println("MyThread running");
            System.out.println("MyThread finished");
        }
    }


}
