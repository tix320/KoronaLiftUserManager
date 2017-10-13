package client.objects;

import lombok.Getter;

/**
 * Gender types.
 */
public enum Gender {
    MALE("Мужский"), FEMALE("Женский");
    
    @Getter
    private String name;
    
    Gender(String name) {
        this.name = name;
    }
}