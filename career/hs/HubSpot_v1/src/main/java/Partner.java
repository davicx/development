import java.net.Inet4Address;
import java.time.LocalDate;
import java.util.ArrayList;

public class Partner {
    String first_name;
    String last_name;
    String email;
    String country;
    String dates;
    ArrayList<Integer> datesArray;

    //public Partner(String firstName, String lastName, String email, String country,ArrayList<LocalDate> dates) {
    public Partner(String firstName, String lastName, String email, String country,String dates) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.email = email;
        this.country = country;
        this.dates = dates;
        ArrayList<Integer> currentDates = new ArrayList<Integer>();
        this.datesArray = currentDates;
    }

}