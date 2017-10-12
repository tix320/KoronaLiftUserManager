package client.widgets.tables.columns;

import client.objects.UserGender;
import client.objects.User;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * Sex column column of Table.
 */
public class ColumnSex extends TextColumn<User> {
    
    @Override
    public String getValue(User object) {
        return object.getUserGender() == UserGender.MALE ? "Мужской" : "Женский";
    }
}
