import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        //String text = System.console().readLine();
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String userInput = keyboard.readLine();
        System.out.println("Text is: " + userInput);
    }
}
