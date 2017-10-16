package client.widgets.tables.columns;

import client.models.User;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * Patronymic column of Table.
 */
public class ColumnPatronymic extends TextColumn<User> {
    
    @Override
    public String getValue(User user) {
        return user.getPatronymic();
    }
}