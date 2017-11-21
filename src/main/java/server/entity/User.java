package server.entity;

import lombok.Getter;
import lombok.Setter;
import shared.types.Gender;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity of users.
 */
@Setter
@Getter
@Entity
@Table(name = "users")
public class User extends IdentityEntity {

    /** Length of full name in database. */
    private static final int FULL_NAME_LENGTH = 30;

    /** User's first name. */
    @Column(length = FULL_NAME_LENGTH)
    private String firstName;

    /** User's middle name. */
    @Column(length = FULL_NAME_LENGTH)
    private String patronymic;

    /** User's last name. */
    @Column(length = FULL_NAME_LENGTH)
    private String lastName;

    /** User's gender. */
    private Gender gender;

    /** User's city name. */
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    /** User's date of birth. */
    private Date dateOfBirth;
}
