import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MortgageClient {
    public static void main(String args[]) {
        String hostName = "127.0.0.1";
        int portNumber = 4000;
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;
        InputStreamReader ir;

        try {
            clientSocket = new Socket(hostName, portNumber);

            //Output Stream
            out = new PrintWriter(clientSocket.getOutputStream());
            ir = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(ir);

            //Send the Message
            out.println("hiya DV");

            //Recieve the Message
            String serverResponse = in.readLine();
            System.out.println("DV Came from Server " + serverResponse);


        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }



    }

}


/*
        String hostName = "127.0.0.1";
        int portNumber = 4000;

        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }*/