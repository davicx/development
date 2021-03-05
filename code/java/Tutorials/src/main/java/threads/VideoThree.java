package threads;

//Stop 5mins 
public class VideoThree {

    public static void main(String[] args) {
        VideoThree app = new VideoThree();
        app.doWork();
    }


    private int count = 0;

    //This is a synchronized block 
    public synchronized void increment() {
        count++;
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {

                    //There are actually three steps here
                    //count = count + 1;
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    //count++;
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count " + count);

    }


}

