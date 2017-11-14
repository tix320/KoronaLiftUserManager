package shared.models;

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
    private int id;

    /** Name of city. */
    private String name;

    @Override
    public final String toString() {
        return name;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CityDto city = (CityDto) o;

        return id == city.id && name.equals(city.name);
    }

    @Override
    public final int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}
