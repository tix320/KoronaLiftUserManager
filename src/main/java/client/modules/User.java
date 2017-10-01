package client.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private String firstName;
    private String middleName;
    private String lastName;
    private int cityIndex;
    private boolean male;
    private Date dateOfBirthday;
}
