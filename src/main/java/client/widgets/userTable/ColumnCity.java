package client.widgets.userTable;

import client.modules.User;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * City's column of Table.
 */
public class ColumnCity extends TextColumn<User> {
    
    @Override
    public String getValue(User object) {
        return object.getCity();
    }
}
