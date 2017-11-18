package shared.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Gender types.
 */
@AllArgsConstructor
public enum Gender {
    MALE(0, "Мужский"), FEMALE(1, "Женский");

    /** Gender code. */
    @Getter
    private int code;

    /** Name of constant. */
    @Getter
    private String name;

}
