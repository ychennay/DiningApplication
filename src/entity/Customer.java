package entity;

/**
 * Created by ychen4 on 4/30/2017.
 */
import java.util.Date;

public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Date dateOfBirth;

    public Customer(long id, String firstName, String lastName, String email, String mobile) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.dateOfBirth = new Date();
    }

    public Customer() {
    }

    //..Getter and setter methods

}