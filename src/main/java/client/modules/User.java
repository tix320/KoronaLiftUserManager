package client.modules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class User {
    
    /** User's unique number. */
    private int ID;
    
    /** User's first name. */
    private String firstName;
    
    /** User's middle name. */
    private String middleName;
    
    /** User's last name. */
    private String lastName;
    
    /** User's city name. */
    private String city;
    
    /** User's gender. */
    private Gender gender;
    
    /** User's date of birth. */
    private Date dateOfBirth;
}
