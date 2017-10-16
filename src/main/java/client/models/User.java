package client.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class User {
    
    /** User's unique number. */
    private Integer ID;
    
    /** User's first name. */
    private String firstName;
    
    /** User's middle name. */
    private String patronymic;
    
    /** User's last name. */
    private String lastName;
    
    /** User's gender. */
    private Gender gender;
    
    /** User's city name. */
    private String city;
    
    /** User's date of birth. */
    private Date dateOfBirth;
}