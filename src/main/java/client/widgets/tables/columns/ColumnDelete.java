package client.widgets.tables.columns;

import client.objects.User;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.user.cellview.client.Column;

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
    public String getValue(User object) {
        return "Delete";
    }
}

