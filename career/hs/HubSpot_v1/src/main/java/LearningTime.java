import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LearningTime {

    public static void main(String[] args) throws ParseException {

        //Create New Date
        Date date = new Date();
        System.out.println(date);

        //Format
        SimpleDateFormat formattedDate;
        //formattedDate = new SimpleDateFormat("hh:mm:ss");
        formattedDate = new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzz");
        //System.out.println(formattedDate.format(date));

        //Time (mS) since Jan 1, 1970
        long timeSince = date.getTime();
        //System.out.println(timeSince);


        //Compare Dates
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        //Date d1 = sdformat.parse("2019-04-15");
        //Date d2 = sdformat.parse("2019-08-10");
        Date dateOne = new Date();
        Date dateTwo = parseDate("2022-2-14");


        System.out.println("The date 1 is: " + sdformat.format(dateOne));
        System.out.println("The date 2 is: " + sdformat.format(dateTwo));
        if(dateOne.compareTo(dateTwo) > 0) {
            System.out.println("Date 1 occurs after Date 2");
        } else if(dateOne.compareTo(dateTwo) < 0) {
            System.out.println("Date 1 occurs before Date 2");
        } else if(dateOne.compareTo(dateTwo) == 0) {
            System.out.println("Both dates are equal");
        }

    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

}
