package shared.models;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO for users.
 */
@Setter
@Getter
public class UserDto implements Serializable {

    private static final long serialVersionUID = -3940035670218210064L;

    /** User's unique number. */
    private int id;

    /** User's first name. */
    private String firstName;

    /** User's middle name. */
    private String patronymic;

    /** User's last name. */
    private String lastName;

    /** User's gender. */
    private Gender gender;

    /** User's city name. */
    private CityDto city;

    /** User's date of birth. */
    private Date dateOfBirth;
}
