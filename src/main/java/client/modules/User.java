package client.modules;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {

    private int ID;
    private String firstName;
    private String middleName;
    private String lastName;
    private int cityNumber;
    private boolean male;
    private Date dateOfBirthday;
}
