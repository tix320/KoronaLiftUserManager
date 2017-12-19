package server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity of cities.
 */
@Setter
@Getter
@Entity
@Table(name = "cities")
public class City extends IdentityEntity {

    /** Length of city name in database. */
    private static final int CITY_NAME_LENGTH = 30;

    /** Name of city. */
    @Column(length = CITY_NAME_LENGTH, unique = true)
    private String name;
}
