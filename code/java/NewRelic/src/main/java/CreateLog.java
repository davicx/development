import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CreateLog {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("C:/Users/vasquez_d/IdeaProjects/NewRelic/src/main/logs/myNames.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            ArrayList<String> userNames = new ArrayList<String>();
            userNames.add("David");
            userNames.add("Frodo");
            userNames.add("Bilbo");
            for (int i = 0; i < userNames.size(); i++) {
                logger.info(userNames.get(i));
            }

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
