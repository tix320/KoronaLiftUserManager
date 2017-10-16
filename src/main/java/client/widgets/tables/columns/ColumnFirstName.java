package client.widgets.tables.columns;

import client.models.User;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * First name column of Table.
 */
public class ColumnFirstName extends TextColumn<User> {
    
    @Override
    public String getValue(User user) {
        return user.getFirstName();
    }
}