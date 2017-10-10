package client.UI.userTable.columns;

import client.modules.User;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.user.cellview.client.Column;

public class ColumnDelete extends Column<User, String> {
    
    /**
     * Construct a new Column with a given {@link Cell}.
     *
     * @param cell the Cell used by this Column
     */
    public ColumnDelete(Cell<String> cell) {
        super(cell);
    }
    
    @Override
    public String getValue(User object) {
        return "Delete";
    }
}

