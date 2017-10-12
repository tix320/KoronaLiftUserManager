package client.widgets.tables;

import client.widgets.forms.UserForm;
import client.dataUpdaters.DataUpdater;
import client.objects.User;

import java.util.ArrayList;
import java.util.List;

public class UserTableDataUpdater implements DataUpdater<User, UserForm, UserTable> {
    
    /** List of registered tables. */
    private List<UserTable> userTables;
    
    /** List of registered forms. */
    private List<UserForm> userForms;
    
    public UserTableDataUpdater() {
        userTables = new ArrayList<>();
        userForms = new ArrayList<>();
    }
    
    @Override
    public void addDataSource(UserForm userForm) {
        userForms.add(userForm);
    }
    
    public void sendSelectedUser(User selectedUser) {
        userForms.forEach(userForm -> userForm.updateInputs(selectedUser));
    }
    
    @Override
    public void registerObserver(UserTable userTable) {
        userTables.add(userTable);
        userTable.setUserTableDataUpdater(this);
    }
    
    @Override
    public void removeObserver(UserTable userTable) {
        userTables.remove(userTable);
        userTable.setUserTableDataUpdater(null);
    }
    
    @Override
    public void addNewObject(User newUser) {
        userTables.forEach(userTable -> userTable.addNewObject(newUser));
    }
    
    @Override
    public void editThisObject(User oldUser, User newUser) {
        userTables.forEach(userTable -> userTable.editThisObject(oldUser, newUser));
    }
    
    @Override
    public void removeThisObject(User user) {
        userTables.forEach(userTable -> userTable.removeThisObject(user));
    }
}
