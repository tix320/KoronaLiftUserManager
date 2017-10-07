package client.abstraction.userTable;

import client.UI.userTable.UsersTableUpdater;
import client.abstraction.userForm.UserForm;
import client.modules.User;
import com.google.gwt.user.cellview.client.CellTable;

public interface Table {
    
    UsersTableUpdater getUsersTableUpdater();
    
    void setUsersTableUpdater(UsersTableUpdater usersTableUpdater);
    
    CellTable<User> getCellTable();
    
    void updateInputsData(User user);
    
    void registerUserForm(UserForm userForm);
    
    void removeUserForm(UserForm userForm);
}
