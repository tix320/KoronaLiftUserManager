package client.widgets.userForm.tabPanel;

import lombok.Getter;

public enum TabText {
    ADD("Добавить"),EDIT("Изменить");
    @Getter private String text;
    
     TabText(String text){
        this.text = text;
        
        
    }
}
