package client.widgets.tables.columns;

import client.objects.User;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * Last name column of Table.
 */
public class ColumnLastName extends TextColumn<User> {
    
    @Override
    public String getValue(User object) {
        return object.getLastName();
    }
}
