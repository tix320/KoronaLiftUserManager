package client.widgets.tables.columns;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.user.cellview.client.Column;
import shared.dto.UserDto;

/**
 * Column with button to show user's avatar.
 */
public class ColumnAvatar extends Column<UserDto, String> {

    /** Show avatar button's text. */
    private static final String SHOW_AVATAR = "Показать аватар";

    /**
     * Construct a new Column with a given {@link Cell}.
     *
     * @param cell the Cell used by this Column
     */
    public ColumnAvatar(Cell<String> cell) {
        super(cell);
    }

    @Override
    public String getValue(UserDto user) {
        return SHOW_AVATAR;
    }
}
