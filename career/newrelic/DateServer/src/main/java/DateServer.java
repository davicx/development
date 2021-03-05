import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {

    public static void main(String args[]) throws IOException {
        ServerSocket listener = new ServerSocket(4000);

        //Only allows one client
        System.out.println("Waiting for Connection");
        Socket client = listener.accept();

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        //out.println("Connected");
        String date = (new Date().toString());
        out.println(date);
        out.println("Sent Date");
        client.close();
        listener.close();

    }
}

/*

//Works
public class DateServer {

    public static void main(String args[]) throws IOException {
        ServerSocket listener = new ServerSocket(4000);

        //Only allows one client
        System.out.println("Waiting for Connection");
        Socket client = listener.accept();

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        //out.println("Connected");
        String date = (new Date().toString());
        out.println(date);
        out.println("Sent Date");
        client.close();
        listener.close();

    }
}
*/