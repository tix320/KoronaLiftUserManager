package client.widgets.tables.columns;

import com.google.gwt.user.cellview.client.TextColumn;
import shared.dto.UserDto;


/**
 * Sex column of Table.
 */
public class ColumnSex extends TextColumn<UserDto> {

    @Override
    public final String getValue(final UserDto user) {
        return user.getGender().getName();
    }
}
