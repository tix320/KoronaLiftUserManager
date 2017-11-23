package shared.models;

import client.widgets.user.HasUniqueness;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for cities.
 */
@Setter
@Getter
public class CityDto implements Serializable, HasUniqueness {

    private static final long serialVersionUID = -1355704257405143045L;

    /** Unique number of city. */
    private int id;

    /** Name of city. */
    private String name;

    @Override
    public int uniqueNumber() {
        return id;
    }

    @Override
    public String getValue() {
        return name;
    }
}
