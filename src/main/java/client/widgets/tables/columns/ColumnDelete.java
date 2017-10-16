package client.widgets.tables.columns;

import client.models.User;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.user.cellview.client.Column;

/**
 * Column with button to remove users.
 */
public class ColumnDelete extends Column<User, String> {
    
    /**
     * Construct a new Column with a given {@link Cell}.
     *
     * @param cell the Cell used by this Column.
     */
    public ColumnDelete(Cell<String> cell) {
        super(cell);
    }
    
    @Override
    public String getValue(User user) {
        return "Удалить";
    }
}