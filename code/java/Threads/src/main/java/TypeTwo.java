public class TypeTwo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Main " + i);
        }
        Thread myThread = new Thread(new MyRunnable());
        myThread.start();
    }

    //This is a normal Java Thread
    public static class MyRunnable implements Runnable {
        public void run(){
            for (int i = 0; i < 5; i++) {

                try {
                    System.out.println("Thread " + i);
                    Thread.sleep(5000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
            //System.out.println("MyThread running");
            //System.out.println("MyThread finished");
        }
    }

}
