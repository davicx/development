import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class clientBackup {

    public static void main(String[] args) throws IOException, InterruptedException {
        String hostName = "127.0.0.1";
        int portNumber = 9090;

        //Establish connection to server
        Socket echoClientSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(echoClientSocket.getOutputStream(), true);
        Integer numberToServer = 5;
        out.println(numberToServer);
    }



    public static void sendNumbers() throws IOException {
        String hostName = "127.0.0.1";
        int portNumber = 9090;

        DecimalFormat df2 = new DecimalFormat("##.####");

        //Establish connection to server
        Socket echoClientSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(echoClientSocket.getOutputStream(), true);

        int startTime = (int) System.currentTimeMillis();
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        numberList = getNumbers();

        //Send Numbers to Server
        /*
        for (int i = 0; i < numberList.size(); i++) {
            out.println(numberList.get(i));
        }
        */
        for (int i = 0; i < 1; i++) {
            out.println(1);
        }

        //Put 2
        for (int i = 0; i < 2; i++) {
            out.println(2);
        }

        //Put 3
        for (int i = 0; i < 3; i++) {
            out.println(3);
        }

        //Put 4
        for (int i = 0; i < 4; i++) {
            out.println(4);
        }
        int endTime = (int) System.currentTimeMillis();
        int totalTime = endTime - startTime;
        double totalSeconds = totalTime / 1000;

        System.out.println("Total Seconds: " + df2.format(totalSeconds) );

    }




    //Utility Functions
    public static ArrayList<Integer> getNumbers() {
        ArrayList<Integer> millionInts = new ArrayList<Integer>();
        Random rand = new Random();
        int currentNumber = 0;

        for (int j = 0; j<1005; j++) {
            currentNumber = rand.nextInt(100) + 1;
            //System.out.println(currentNumber);
            //System.out.println(currentNumber);
            millionInts.add(currentNumber);

        }
        return millionInts;

    }









    public static void sendTextAwaitResponse() throws IOException, InterruptedException  {
        String hostName = "127.0.0.1";
        int portNumber = 9090;

        //Establish connection to server
        Socket echoClientSocket = new Socket(hostName, portNumber);

        BufferedReader input = new BufferedReader(new InputStreamReader(echoClientSocket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(echoClientSocket.getOutputStream(), true);

        //Send Data to the Server
        ArrayList<String> userNames = new ArrayList<String>();
        userNames.add("David");
        userNames.add("Frodo");
        userNames.add("Bilbo");
        while(true) {
            for (int i = 0; i < userNames.size(); i++) {
                //System.out.println(userNames.get(i));
                Thread.sleep(1000);
                out.println(userNames.get(i));
                if (userNames.get(i) == "quit") {
                    break;
                }
            }
        }
    }

    public static void sendText() throws IOException, InterruptedException  {
        String hostName = "127.0.0.1";
        int portNumber = 9090;

        //Establish connection to server
        Socket echoClientSocket = new Socket(hostName, portNumber);

        BufferedReader input = new BufferedReader(new InputStreamReader(echoClientSocket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(echoClientSocket.getOutputStream(), true);

        //Send Data to the Server
        ArrayList<String> userNames = new ArrayList<String>();
        userNames.add("David");
        userNames.add("Frodo");
        userNames.add("Bilbo");
        while(true) {
            for (int i = 0; i < userNames.size(); i++) {
                //System.out.println(userNames.get(i));
                Thread.sleep(1000);
                out.println(userNames.get(i));
                if (userNames.get(i) == "quit") {
                    break;
                }
            }
        }
    }



    public static void askForInput() throws IOException, InterruptedException {
        String hostName = "127.0.0.1";
        int portNumber = 9090;

        //Establish connection to server
        Socket echoClientSocket = new Socket(hostName, portNumber);

        BufferedReader input = new BufferedReader(new InputStreamReader(echoClientSocket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(echoClientSocket.getOutputStream(), true);

        while (true) {
            System.out.println("Please say something: ");
            String userInput = keyboard.readLine();
            out.println(userInput);

            if (userInput == "quit") {
                break;
            }

            String serverResponse = input.readLine();
            System.out.println("The Server Says " + serverResponse);

        }
    }

    /*
            //sendNumbers();

    private static DecimalFormat df2 = new DecimalFormat("##.####");

        Map<Integer, Integer> numbersMap = new HashMap<>();

        int numberOne = 1;
        int numberTwo = 3;
        int numberThree = 1;
        int numberFour = 1;
        int numberFive = 2;
        numbersMap.put(numberOne, numbersMap.getOrDefault(numberOne, 0)+ 1);
        System.out.println(numbersMap);
        numbersMap.put(numberTwo, numbersMap.getOrDefault(numberTwo, 0)+ 1);
        System.out.println(numbersMap);
        numbersMap.put(numberThree, numbersMap.getOrDefault(numberThree, 0)+ 1);
        System.out.println(numbersMap);
        numbersMap.put(numberFour, numbersMap.getOrDefault(numberFour, 0)+ 1);
        System.out.println(numbersMap);
        numbersMap.put(numberFive, numbersMap.getOrDefault(numberFive, 0)+ 1);
        System.out.println(numbersMap);

        System.out.println("_______________");


        Random rand = new Random();
        int currentNumber = 0;
        Map<Integer, Integer> numbersMapLoop = new HashMap<>();
        for (int j = 0; j<10; j++) {
            currentNumber = rand.nextInt(10) + 1;
            System.out.println(currentNumber);
            numbersMapLoop.put(currentNumber, numbersMap.getOrDefault(currentNumber, 0)+ 1);
        }

        System.out.println(numbersMapLoop);
     */


}



