package client.widgets.tables.columns;

import client.objects.User;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * First name column of Table.
 */
public class ColumnFirstName extends TextColumn<User> {
    
    @Override
    public String getValue(User object) {
        return object.getFirstName();
    }
}
