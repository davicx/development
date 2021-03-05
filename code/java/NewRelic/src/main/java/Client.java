import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        sendNumber();
    }

    public static void sendNumber() throws IOException {
        String hostName = "127.0.0.1";
        int portNumber = 9090;

        //Establish connection to server
        Socket echoClientSocket = new Socket(hostName, portNumber);
        DataOutputStream outToServer = new DataOutputStream(echoClientSocket.getOutputStream());

        //Send Numbers to Server
        for (int i = 0; i < 1; i++) {
            outToServer.writeInt(1);
        }

        //Put 2
        for (int i = 0; i < 2; i++) {
            outToServer.writeInt(2);
        }

        //Put 3
        for (int i = 0; i < 3; i++) {
            outToServer.writeInt(3);
        }

        //Put 4
        for (int i = 0; i < 4; i++) {
            outToServer.writeInt(4);
        }
    }


    public static void singleNumber() throws IOException {
        String hostName = "127.0.0.1";
        int portNumber = 9090;

        //Establish connection to server
        Socket socket = new Socket(hostName, portNumber);

        DataInputStream input = new DataInputStream(socket.getInputStream());
        //String serverResponse = input.readLine();
        Integer serverResponse = input.readInt();
        System.out.println(serverResponse);
        socket.close();

        // Client side
        //final DataInputStream FromServer = new DataInputStream(Server_info.getInputStream());
        //final DataOutputStream ToServer = new DataOutputStream(Server_info.getOutputStream());
    }




}






