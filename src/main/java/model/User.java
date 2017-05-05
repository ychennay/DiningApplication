package main.java.model;

/**
 * Created by ychen4 on 5/5/2017.
 */
public class User {

    public String firstName;
    public int id;

    public User(){}

    public User(String firstName, int id) {
        this.firstName = firstName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
