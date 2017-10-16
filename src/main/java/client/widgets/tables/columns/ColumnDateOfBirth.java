package client.widgets.tables.columns;

import client.models.User;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * Date of birth column of Table.
 */
public class ColumnDateOfBirth extends TextColumn<User> {
    
    @Override
    public String getValue(User user) {
        DateTimeFormat df = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_SHORT);
        return df.format(user.getDateOfBirth());
    }
}