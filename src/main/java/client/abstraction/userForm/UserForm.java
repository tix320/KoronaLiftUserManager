package client.abstraction.userForm;

import client.UI.userTable.UsersTableUpdater;
import client.modules.User;

public interface UserForm {
    
    /**
     * Add table updater, who will transfer the data.
     *
     * @param usersTableUpdater is adding table updater.
     */
    void registerUsersTableUpdater(UsersTableUpdater usersTableUpdater);
    
    /**
     * Delete the table updater.
     *
     * @param usersTableUpdater is removing table updater.
     */
    void removeUsersTableUpdater(UsersTableUpdater usersTableUpdater);
    
    /**
     * Action of submit.
     */
    void submitAction();
    
    /**
     * Update form data from some source.
     *
     * @param user is a owner of data.
     */
    void updateInputs(User user);
    
    
}
