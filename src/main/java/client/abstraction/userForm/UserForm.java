package client.abstraction.userForm;

import client.UI.userTable.UsersTableUpdater;
import client.modules.User;

public interface UserForm {
    
    void registerUsersTableUpdater(UsersTableUpdater usersTableUpdater);
    
    void removeUsersTableUpdater(UsersTableUpdater usersTableUpdater);
    
    void submitAction();
    
    void updateInputs(User user);
    
    
}
