package client.UI.userTable;

import client.UI.userTable.columns.ColumnCity;
import client.UI.userTable.columns.ColumnDateOfBirth;
import client.UI.userTable.columns.ColumnDelete;
import client.UI.userTable.columns.ColumnFirstName;
import client.UI.userTable.columns.ColumnLastName;
import client.UI.userTable.columns.ColumnMiddleName;
import client.UI.userTable.columns.ColumnSex;
import client.abstraction.table.Table;
import client.modules.User;
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
public class UserTable extends Composite implements Table<User> {
    @Setter
    private UserTableDataUpdater userTableDataUpdater;
    private SingleSelectionModel<User> selModel;
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
        columnDelete.setFieldUpdater((index, object, value) -> deleteAction(object));
    }
    
    /**
     * Action of delete button.
     *
     * @param user is a removing object.
     */
    private void deleteAction(User user) {
        userTableDataUpdater.removeThisObject(user);
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
        selModel.addSelectionChangeHandler(event -> sendSelectedObject(selModel.getSelectedObject()));
    }
    
    @Override
    public void addNewObject(User newUser) {
        users.getList().add(newUser);
    }
    
    @Override
    public void editThisObject(User oldUser, User newUser) {
        int index = users.getList().indexOf(oldUser);
        users.getList().remove(oldUser);
        users.getList().add(index, newUser);
    }
    
    @Override
    public void removeThisObject(User user) {
        users.getList().remove(user);
    }
    
    @Override
    public void sendSelectedObject(User selectedUser) {
        userTableDataUpdater.sendSelectedUser(selectedUser);
    }
}

    
  
