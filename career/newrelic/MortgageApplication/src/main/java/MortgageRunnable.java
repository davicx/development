import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MortgageRunnable implements Runnable {

    protected Socket clientSocket = null;

    //Constructor (pass in connection we accepted from Client)
    public MortgageRunnable(Socket clientSocket) {
        System.out.println("DV MortgageRunnable Created");
        this.clientSocket = clientSocket;
    }

    public void run() {
        //Need to read in information from client program and write it back (use buffered reader)

        //Create new input stream reader
        try {
            //Get Input Stream
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //Send Information Back
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String arg1;
            arg1 = in.readLine();
            System.out.println("DV S: " + arg1);
            out.println("DV S: out.println");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
