import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServerBackup {
    private static ArrayList<String> incomingMessages = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        int portNumber = 9090;

        int totalMessagesReceived = 0;

        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket client = serverSocket.accept();

        //Create a Buffered Output Sender
        PrintWriter outFromServerToClient = new PrintWriter(client.getOutputStream(), true);

        //Create a Buffered Input Reader
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //Get Data
        try {
            while(true) {
                Integer currentNumber = inFromClient.read();
                System.out.println("SERVER: Current Number " + currentNumber);
                if(totalMessagesReceived > 1000) {
                    break;
                }
            }

        } finally {
            //Close the Socket
            serverSocket.close();
            outFromServerToClient.close();
            inFromClient.close();
            System.exit(0);

        }

    }

    //SERVER 1: Handle Numbers
    public static void handleNumbers(int portNumber) throws IOException {
        int totalMessagesReceived = 0;

        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket client = serverSocket.accept();

        //Create a Buffered Output Sender
        PrintWriter outFromServerToClient = new PrintWriter(client.getOutputStream(), true);

        //Create a Buffered Input Reader
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //Get Data from Client
        Map<Integer, Integer> numbersMap = new HashMap<Integer, Integer>();

        try {
            while(true) {
                Integer currentNumber = inFromClient.read();
                totalMessagesReceived = totalMessagesReceived + 1;


                if(totalMessagesReceived > 1000) {
                    System.out.println(numbersMap);
                    System.out.println("SERVER Map Size " + numbersMap.size());
                    System.out.println("SERVER Total Messages  " + totalMessagesReceived);
                    System.out.println("DV: Sent date lata!");
                    break;
                }

                //Add to Hashmap
                //System.out.println(currentNumber);
                //System.out.println(numbersMap);
                //System.out.println(" ___________ ");

                System.out.println(currentNumber);
                //numbersMap.put(currentNumber, numbersMap.getOrDefault(currentNumber, 0)+ 1);

            }

        } finally {
            //Close the Socket
            serverSocket.close();
            outFromServerToClient.close();
            inFromClient.close();
            System.exit(0);

        }

    }



    //SERVER 2: Handle Text Input
    public static void handleTextInput(int portNumber) throws IOException {

        int totalMessagesReceived = 0;

        ServerSocket serverSocket = new ServerSocket(portNumber);

        //Get a Connection from the Server
        //System.out.println("DV: Waiting for a connection");
        Socket client = serverSocket.accept();
        //System.out.println("DV: Connected to client");

        //Create a Buffered Output Sender
        PrintWriter outFromServerToClient = new PrintWriter(client.getOutputStream(), true);

        //Create a Buffered Input Reader
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //Get Data from Client
        Map<String, Integer> userNameMap = new HashMap<>();

        try {
            while(true) {
                String clientInputString = inFromClient.readLine();
                totalMessagesReceived = totalMessagesReceived + 1;
                System.out.println("Total Messages: " + totalMessagesReceived + " " + clientInputString);

                if(totalMessagesReceived > 10) {
                    break;
                }

                //Add to Hashmap
                userNameMap.put(clientInputString, userNameMap.getOrDefault(clientInputString, 0)+ 1);

                /*
                incomingMessages.add(clientInputString);
                totalMessagesReceived++;
                //System.out.println("SERVER: Says " + clientInputString);
                System.out.println("SERVER: All Current Messages " + totalMessagesReceived);
                for(int i = 0; i < incomingMessages.size(); i++) {
                    System.out.println(incomingMessages.get(i));
                }
                */

                outFromServerToClient.println("SERVER to CLIENT: Hello from the Server~ " + clientInputString);
            }

        } finally {
            //Close the Socket
            System.out.println(userNameMap);
            System.out.println("DV: Sent date lata!");
            serverSocket.close();
            outFromServerToClient.close();
            inFromClient.close();
            System.exit(0);

        }

    }

}


