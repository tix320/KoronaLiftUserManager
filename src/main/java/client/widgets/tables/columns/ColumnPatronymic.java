package client.widgets.tables.columns;

import com.google.gwt.user.cellview.client.TextColumn;
import shared.dto.UserDto;


/**
 * Patronymic column of Table.
 */
public class ColumnPatronymic extends TextColumn<UserDto> {

    @Override
    public final String getValue(final UserDto user) {
        return user.getPatronymic();
    }
}
