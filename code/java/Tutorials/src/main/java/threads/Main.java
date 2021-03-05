package threads;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



    }

    //Type 1: Extend the Thread Class
    public static void typeOne() {
        Runner runnerOne = new Runner();
        runnerOne.start();

        Runner runnerTwo = new Runner();
        runnerTwo.start();
    }

    //Type 2: Implement Runnable and pass to the Constructor
    public static void typeTwo() {
        Thread threadOne = new Thread(new Runner());
        threadOne.start();

        Thread threadTwo = new Thread(new Runner());
        threadTwo.start();
    }


    //Type 3: Quick way to do this (Anonymous Class)
    public static void typeThree() {
        Thread threadThree = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hello " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadThree.start();
    }

    //Type 4: Executor Services (in a thread pool)


}


//Type 1: Extend the Thread Class
class Runner extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

//Type: Two
class RunnerTwo implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

