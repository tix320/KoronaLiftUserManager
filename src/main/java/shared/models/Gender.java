package shared.models;

import lombok.Getter;

/**
 * Gender types.
 */
public enum Gender {
    MALE("Мужский"), FEMALE("Женский");

    /** Name of constant. */
    @Getter
    private String name;

    /**
     * Constructor for initializing.
     *
     * @param memberName is a name of constant.
     */
    Gender(final String memberName) {
        this.name = memberName;
    }
}
