package client.UI.userTable;

import client.modules.User;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * Middle name column of Table.
 */
public class ColumnMiddleName extends TextColumn<User> {
    
    @Override
    public String getValue(User object) {
        return object.getMiddleName();
    }
}
