package simple;

public class User {
    public Integer userID;
    public String userName;
    private String location;

    public User(Integer inputUserID, String inputUserName) {
        this.userID = inputUserID;
        this.userName = inputUserName;
    }

    //Get User ID
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    //Get User ID
    public Integer getUserID() {
        return userID;
    }

    //Get Username
    public String getUserName() {
        return userName;
    }

    //Set Username
    public void setUserName(String userName) {
        this.userName = userName;
    }

    //Get Location
    public String getLocation() {
        return location;
    }

    //Set Location
    public void setLocation(String location) {
        this.location = location;
    }

    //Method: Say Hi
    public void sayHi() {
        System.out.println("hello!!");
    }
}


/*
    public Integer userID;
    public String userName;
    public String location;

    public User(Integer inputUserID, String inputUserName) {
        this.userID = inputUserID;
        this.userName = inputUserName;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getLocation() {
        return location;
    }

    public void sayHi() {
        System.out.println("hello!!");
    }

 */