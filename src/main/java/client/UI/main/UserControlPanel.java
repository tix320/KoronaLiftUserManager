package client.UI.main;

import client.UI.userForm.forms.UserAddForm;
import client.UI.userForm.forms.UserEditForm;
import client.UI.userForm.tabPanel.UserFormTabPanel;
import client.UI.userTable.UsersTable;
import client.UI.userTable.UsersTableUpdater;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * Main panel of UI.
 */
public class UserControlPanel extends Composite {
    
    /**
     * Create and initialize the main panel of UI.
     */
    public UserControlPanel() {
    
        FlowPanel mainPanel = new FlowPanel();
    
        UsersTable usersTable = new UsersTable();
    
        UserAddForm userAddForm = new UserAddForm();
        UserEditForm userEditForm = new UserEditForm();
        UserFormTabPanel userFormTabPanel = new UserFormTabPanel(userAddForm, userEditForm);
    
        UsersTableUpdater usersTableUpdater = new UsersTableUpdater();
        userAddForm.registerUsersTableUpdater(usersTableUpdater);
        userEditForm.registerUsersTableUpdater(usersTableUpdater);
        
        usersTableUpdater.registerTable(usersTable);
        
        usersTable.registerUserForm(userAddForm);
        usersTable.registerUserForm(userEditForm);
        
        mainPanel.add(userFormTabPanel);
        mainPanel.add(usersTable);
        
        initWidget(mainPanel);
    }
}
