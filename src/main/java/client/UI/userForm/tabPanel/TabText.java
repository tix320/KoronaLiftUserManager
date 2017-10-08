package client.UI.userForm.tabPanel;

import lombok.Getter;

/**
 * Text of tab panel tabs.
 */
public enum TabText {
    ADD("Добавить"), EDIT("Изменить");
    @Getter
    private String text;
    
    TabText(String text) {
        this.text = text;
    }
}
