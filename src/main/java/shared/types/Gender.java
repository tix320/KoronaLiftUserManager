package shared.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Gender types.
 */
@AllArgsConstructor
public enum Gender {
    MALE("Мужской"), FEMALE("Женский");

    /** Name of constant. */
    @Getter
    private String name;
}
