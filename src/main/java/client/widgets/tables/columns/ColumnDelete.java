package client.widgets.tables.columns;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.user.cellview.client.Column;
import shared.models.UserDto;

/**
 * Column with button to remove users.
 */
public class ColumnDelete extends Column<UserDto, String> {

    /**
     * Construct a new Column with a given {@link Cell}.
     *
     * @param cell the Cell used by this Column.
     */
    public ColumnDelete(final Cell<String> cell) {
        super(cell);
    }

    @Override
    public final String getValue(final UserDto user) {
        return "Удалить";
    }
}
