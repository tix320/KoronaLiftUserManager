package client.widgets.tables.columns;

import client.models.User;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * Last name column of Table.
 */
public class ColumnLastName extends TextColumn<User> {
    
    @Override
    public String getValue(User user) {
        return user.getLastName();
    }
}