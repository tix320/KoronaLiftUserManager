package client.UI.userTable;

import client.modules.User;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * Date of birth column of Table.
 */
public class ColumnDateOfBirth extends TextColumn<User> {
    
    @Override
    public String getValue(User object) {
        DateTimeFormat df = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_SHORT);
        return df.format(object.getDateOfBirth());
    }
}
