package client.abstraction.userTable;

import client.UI.userTable.UsersTableUpdater;
import client.abstraction.userForm.UserForm;
import client.modules.User;
import com.google.gwt.user.cellview.client.CellTable;

public interface Table {
    
    UsersTableUpdater getUsersTableUpdater();
    
    /**
     * Set table updater to table.
     *
     * @param usersTableUpdater is a adding table updater.
     */
    void setUsersTableUpdater(UsersTableUpdater usersTableUpdater);
    
    CellTable<User> getCellTable();
    
    /**
     * Send data to the any form.
     *
     * @param user is a owner of data.
     */
    void updateInputsData(User user);
    
    /**
     * Add form, who will transfer the data.
     *
     * @param userForm is adding form.
     */
    void registerUserForm(UserForm userForm);
    
    /**
     * Delete the form..
     *
     * @param userForm is removing form.
     */
    void removeUserForm(UserForm userForm);
}
