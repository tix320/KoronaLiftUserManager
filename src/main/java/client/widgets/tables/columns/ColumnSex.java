package client.widgets.tables.columns;

import client.models.Gender;
import client.models.User;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * Sex column of Table.
 */
public class ColumnSex extends TextColumn<User> {

    @Override
    public String getValue(User user) {
        return user.getGender().getName();
    }
}