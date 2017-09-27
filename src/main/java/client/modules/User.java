package client.modules;

import java.util.Date;

public class User {
     private String firstName;
    private String middleName;
    private String lastName;
    private String city;
    private boolean sex;
    private Date dateOfBirthday;

    public User(String firstName, String middleName, String lastName, String city, boolean sex, Date dateOfBirthday) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.city = city;
        this.sex = sex;
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public boolean getSex() {
        return sex;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

}
