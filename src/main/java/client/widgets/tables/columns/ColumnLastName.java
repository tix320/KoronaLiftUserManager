package client.widgets.tables.columns;

import com.google.gwt.user.cellview.client.TextColumn;
import shared.dto.UserDto;

/**
 * Last name column of Table.
 */
public class ColumnLastName extends TextColumn<UserDto> {

    @Override
    public final String getValue(final UserDto user) {
        return user.getLastName();
    }
}
