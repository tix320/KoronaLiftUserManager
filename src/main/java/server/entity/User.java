package server.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import shared.types.Gender;

/**
 * Entity of users.
 */
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    /** Length of full name in database. */
    private static final int FULL_NAME_LENGTH = 30;

    /** Users unique number. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
