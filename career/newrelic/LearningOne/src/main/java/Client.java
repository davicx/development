import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String args[]) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPort = 4000;
        Socket myClientSocket = new Socket(serverIP, serverPort);


    }
}


/*
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String args[]) throws IOException  {
        Scanner sc = new Scanner(System.in);
        Socket s = null;
        int number, temp;

        try {
            s = new Socket("127.0.0.1", 1342);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Scanner sc1 = new Scanner(s.getInputStream());
            System.out.println("Enter a Number");
            number = sc.nextInt();
            PrintStream p = new PrintStream(s.getOutputStream());
            p.println(number);

            //Accept Server Result
            temp = sc1.nextInt();
            System.out.println(temp);


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
*/
