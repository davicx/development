import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {

    public static void main(String[] args) throws IOException {
        int portNumber = 9090;

        getNumbers(portNumber);

    }


    public static void getNumbers(int portNumber) throws IOException {
        int totalMessagesReceived = 0;

        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket client = serverSocket.accept();

        //Create a Buffered Output Sender
        DataOutputStream outFromServerToClient = new DataOutputStream(client.getOutputStream());

        //Create a Buffered Input Reader
        DataInputStream inFromClient = new DataInputStream(client.getInputStream());

        try {
            while(true) {
                Integer currentNumber = inFromClient.readInt();
                System.out.println(currentNumber);

                if(totalMessagesReceived > 10) {
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




    public static void sendSingleInt(int portNumber) throws IOException {
        ServerSocket listener = new ServerSocket(portNumber);
        Socket client = listener.accept();

        //Create a Buffered Output Sender
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        //Create a Buffered Input Reader
        DataInputStream in = new DataInputStream(client.getInputStream());
        out.writeInt(7);
        System.out.println("Server Sent date");

        client.close();
        listener.close();
        // Server side
        //final DataInputStream InFromClient = new DataInputStream(soc_1.getInputStream());
        //final DataOutputStream OutToClient = new DataOutputStream(soc_1.getOutputStream());
        // than use OutToClient.writeInt() and InFromClient.readInt()
    }

}


