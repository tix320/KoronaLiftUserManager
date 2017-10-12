package client.widgets.forms;

import lombok.Getter;

/**
 * Define type of some send.
 */
public enum SendType {
    ADD("Добавить"), EDIT("Изменить");
    
    @Getter
    private String text;
    
    SendType(String text) {
        this.text = text;
    }
}