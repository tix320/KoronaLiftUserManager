package client.UI.userTable.columns;

import client.abstraction.userTable.Table;
import client.modules.User;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.cellview.client.Column;
import lombok.Setter;

public class ColumnDelete extends Column<User, String> {
    
    @Setter
    private Table table;
    
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
    
    @Override
    public void onBrowserEvent(Context context, Element elem, User object, NativeEvent event) {
        table.getUsersTableUpdater().removeUser(object);
        super.onBrowserEvent(context, elem, object, event);
    }
}
