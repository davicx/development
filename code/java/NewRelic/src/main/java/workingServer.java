import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class workingServer {
    private static ArrayList<String> incomingMessages = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        int portNumber = 9090;

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
        try {
            while(true) {
                String clientInputString = inFromClient.readLine();
                incomingMessages.add(clientInputString);
                //System.out.println("SERVER: Says " + clientInputString);
                System.out.println("SERVER: All Current Messages ");
                for(int i = 0; i < incomingMessages.size(); i++) {
                    System.out.println(incomingMessages.get(i));
                }


                outFromServerToClient.println("SERVER to CLIENT: Hello from the Server~ " + clientInputString);
            }

        } finally {
            //Close the Socket
            System.out.println("DV: Sent date lata!");
            serverSocket.close();
            outFromServerToClient.close();
            inFromClient.close();
            System.exit(0);

        }

    }
}
