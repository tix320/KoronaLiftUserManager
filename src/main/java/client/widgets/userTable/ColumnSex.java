package client.widgets.userTable;

import client.modules.Gender;
import client.modules.User;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * Sex column column of Table.
 */
public class ColumnSex extends TextColumn<User> {
    
    @Override
    public String getValue(User object) {
        return object.getGender()== Gender.MALE ? "Мужской" : "Женский";
    }
}
