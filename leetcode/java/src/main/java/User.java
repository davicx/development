import java.util.ArrayList;

public class User {
    public int userId;
    public String userName;
    private final ArrayList<String> userFriends = new ArrayList<String>();

    //Constructor
    public User(int userId, String currentUserName) {
        this.userId = userId;
        userName = currentUserName;

    }

    //Add Friend
    public void addFriend(String friendName) {
        userFriends.add(friendName);
    }

    //Get Friends
    public ArrayList<String> getFriends() {
        return userFriends;

    }
}


/*

    // the Bicycle class has
    // three fields
    public int cadence;
    public int gear;
    public int speed;

    // the Bicycle class has
    // one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    // the Bicycle class has
    // four methods
    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

 */