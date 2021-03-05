import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Client {

    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("127.0.0.1", 4000);

        //Create a reader to read server information
        BufferedReader input = new BufferedReader(new InputStreamReader( socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        //Out to Server
        while (true) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Input: ");
            String command = keyboard.readLine();
            if(command.equals("quit")) break;

            out.println(command);

            //Blocking Operation
            String serverResponse = input.readLine();
            System.out.println(serverResponse);

        }

        socket.close();
        System.exit(0);
    }
}

/*
public class Client {

    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("127.0.0.1", 4000);

        //Create a reader to read server information
        BufferedReader input = new BufferedReader(new InputStreamReader( socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        //Out to Server
        while (true) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Input: ");
            String command = keyboard.readLine();
            if(command.equals("quit")) break;

            out.println(command);

            //Blocking Operation
            String serverResponse = input.readLine();
            System.out.println(serverResponse);

        }

        socket.close();
        System.exit(0);
    }
}


//Works
public class Client {

    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("127.0.0.1", 4000);

        //Create a reader to read server information
        BufferedReader input = new BufferedReader(new InputStreamReader( socket.getInputStream()));

        //Blocking Operation
        String serverResponse = input.readLine();
        System.out.println(serverResponse);

        socket.close();
        System.exit(0);
    }
}
*/
