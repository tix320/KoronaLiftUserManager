package client.widgets.tables;

import client.objects.User;
import client.widgets.tables.columns.ColumnCity;
import client.widgets.tables.columns.ColumnDateOfBirth;
import client.widgets.tables.columns.ColumnDelete;
import client.widgets.tables.columns.ColumnFirstName;
import client.widgets.tables.columns.ColumnLastName;
import client.widgets.tables.columns.ColumnMiddleName;
import client.widgets.tables.columns.ColumnSex;
import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import lombok.Setter;

/**
 * Create custom widget to keep the users.
 * Users will be added from UserAddForm or edited from EditAddForm.
 */
public class UserTable extends Composite implements Table {
    @Setter
    private UserTableDataUpdater tableUpdater;
    private SingleSelectionModel<User> selModel;
    private int selectedUserIndex;
    private ListDataProvider<User> users;
    private CellTable<User> cellTable;
    private ColumnFirstName columnFirstName;
    private ColumnMiddleName columnMiddleName;
    private ColumnLastName columnLastName;
    private ColumnSex columnSex;
    private ColumnCity columnCity;
    private ColumnDateOfBirth columnDateOfBirth;
    private ColumnDelete columnDelete;
    
    public UserTable() {
        cellTable = new CellTable<>();
        selModel = new SingleSelectionModel<>();
        users = new ListDataProvider<>();
        users.addDataDisplay(cellTable);
        
        cellTable.setSelectionModel(selModel);
        
        initColumns();
        addColumns();
        setSelectedItemListener();
        
        initWidget(cellTable);
    }
    
    /**
     * Initialize columns for table.
     */
    private void initColumns() {
        
        columnFirstName = new ColumnFirstName();
        columnMiddleName = new ColumnMiddleName();
        columnLastName = new ColumnLastName();
        columnSex = new ColumnSex();
        columnCity = new ColumnCity();
        columnDateOfBirth = new ColumnDateOfBirth();
        columnDelete = new ColumnDelete(new ButtonCell());
        columnDelete.setFieldUpdater((index, object, value) -> deleteButtonAction(object));
    }
    
    /**
     * Action of delete button.
     * Send info to delete user from registered tables.
     *
     * @param user is a removing object.
     */
    private void deleteButtonAction(User user) {
        tableUpdater.updateObservers(user, UpdateType.REMOVE);
    }
    
    /**
     * Add columns to table.
     */
    private void addColumns() {
        cellTable.setStyleName("users-table-general");
        cellTable.addColumn(columnFirstName, "Имя");
        cellTable.addColumn(columnMiddleName, "Отчество");
        cellTable.addColumn(columnLastName, "Фамилия");
        cellTable.addColumn(columnCity, "Город");
        cellTable.addColumn(columnSex, "Пол");
        cellTable.addColumn(columnDateOfBirth, "Дата рождения");
        cellTable.addColumn(columnDelete, "Удалить");
    }
    
    /**
     * Set listener for selected item of table.
     */
    private void setSelectedItemListener() {
        selModel.addSelectionChangeHandler(event -> {
            selectedUserIndex = users.getList().indexOf(selModel.getSelectedObject());
            sendSelectedObject(selModel.getSelectedObject());
        });
    }
    
    public void updateTable(User user, UpdateType updateType) {
        if (updateType == UpdateType.ADD) {
            users.getList().add(user);
        } else if (updateType == UpdateType.REMOVE) {
            users.getList().remove(user);
        } else if (updateType == UpdateType.EDIT) {
            users.getList().set(selectedUserIndex, user);
        }
    }
    
    private void sendSelectedObject(User selectedUser) {
        tableUpdater.sendSelectedUser(selectedUser);
    }
}

    
  
