package client.UI.userTable;

import client.UI.userTable.columns.ColumnCity;
import client.UI.userTable.columns.ColumnDateOfBirth;
import client.UI.userTable.columns.ColumnDelete;
import client.UI.userTable.columns.ColumnFirstName;
import client.UI.userTable.columns.ColumnLastName;
import client.UI.userTable.columns.ColumnMiddleName;
import client.UI.userTable.columns.ColumnSex;
import client.abstraction.userForm.UserForm;
import client.abstraction.userTable.Table;
import client.modules.User;
import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.view.client.SingleSelectionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Create custom widget to keep the users.
 * Users will be added from UserAddForm or edited from EditAddForm.
 */
public class UsersTable extends Composite implements Table {
    private final SingleSelectionModel<User> selModel;
    private UsersTableUpdater usersTableUpdater;
    private List<UserForm> userForms;
    private CellTable<User> usersCellTable;
    private ColumnFirstName columnFirstName;
    private ColumnMiddleName columnMiddleName;
    private ColumnLastName columnLastName;
    private ColumnSex columnSex;
    private ColumnCity columnCity;
    private ColumnDateOfBirth columnDateOfBirth;
    private ColumnDelete columnDelete;
    
    public UsersTable() {
        userForms = new ArrayList<>();
        usersCellTable = new CellTable<>();
        selModel = new SingleSelectionModel<>();
        usersCellTable.setVisibleRange(0, 100);
        
        usersCellTable.setSelectionModel(selModel);
        
        initColumns();
        addColumns();
        setSelectedItemListener();
    
        initWidget(usersCellTable);
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
        columnDelete.setTable(this);
    }
    
    /**
     * Add columns to table.
     */
    private void addColumns() {
        usersCellTable.setStyleName("users-table-general");
        usersCellTable.addColumn(columnFirstName, "Имя");
        usersCellTable.addColumn(columnMiddleName, "Отчество");
        usersCellTable.addColumn(columnLastName, "Фамилия");
        usersCellTable.addColumn(columnCity, "Город");
        usersCellTable.addColumn(columnSex, "Пол");
        usersCellTable.addColumn(columnDateOfBirth, "Дата рождения");
        usersCellTable.addColumn(columnDelete);
        
    }
    
    /**
     * Set listener for selected item of table.
     */
    private void setSelectedItemListener() {
        selModel.addSelectionChangeHandler(event -> updateInputsData(selModel.getSelectedObject()));
    }
    
    @Override
    public UsersTableUpdater getUsersTableUpdater() {
        return this.usersTableUpdater;
    }
    
    @Override
    public void setUsersTableUpdater(UsersTableUpdater usersTableUpdater) {
        this.usersTableUpdater = usersTableUpdater;
    }
    
    @Override
    public CellTable<User> getCellTable() {
        return usersCellTable;
    }
    
    @Override
    public void updateInputsData(User user) {
        userForms.forEach(userForm -> userForm.updateInputs(user));
    }
    
    @Override
    public void registerUserForm(UserForm userForm) {
        userForms.add(userForm);
    }
    
    @Override
    public void removeUserForm(UserForm userForm) {
        userForms.remove(userForm);
    }
}
