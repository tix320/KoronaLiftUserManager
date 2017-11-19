package server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity of cities.
 */
@Setter
@Getter
@Entity
@Table(name = "cities")
public class City {

    /** Length of city name in database. */
    private static final int CITY_NAME_LENGTH = 30;

    /** Unique number of city. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Name of city. */
    @Column(length = CITY_NAME_LENGTH)
    private String name;
}
