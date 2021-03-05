package threads;

import java.util.Scanner;

public class VideoTwo {
    public static void main(String[] args) {
        ProcessorFirstVideo processorOne = new ProcessorFirstVideo();
        processorOne.start();

        System.out.println("Press return to stop ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        processorOne.shutdown();
    }
}



class ProcessorFirstVideo extends Thread {
    private boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Hello " + running);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }

}
