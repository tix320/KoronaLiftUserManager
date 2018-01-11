package shared.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for cities.
 */
@Setter
@Getter
public class CityDto implements Serializable {
    private static final long serialVersionUID = -1355704257405143045L;

    /** Unique number of city. */
    private Integer id;

    /** Name of city. */
    private String name;
}
