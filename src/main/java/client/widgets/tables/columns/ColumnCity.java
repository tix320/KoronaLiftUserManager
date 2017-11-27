package client.widgets.tables.columns;

import com.google.gwt.user.cellview.client.TextColumn;
import shared.dto.UserDto;

/**
 * City's column of Table.
 */
public class ColumnCity extends TextColumn<UserDto> {

    @Override
    public final String getValue(final UserDto user) {
        return user.getCity().getName();
    }
}
