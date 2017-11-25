package client.widgets.tables.columns;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.TextColumn;
import shared.dto.UserDto;

/**
 * Date of birth column of Table.
 */
public class ColumnDateOfBirth extends TextColumn<UserDto> {

    @Override
    public final String getValue(final UserDto user) {
        DateTimeFormat df = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_SHORT);
        return df.format(user.getDateOfBirth());
    }
}
