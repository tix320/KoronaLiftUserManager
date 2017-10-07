package client.UI.main;

import client.UI.userForm.forms.UserAddForm;
import client.UI.userForm.forms.UserEditForm;
import client.UI.userForm.tabPanel.UserFormTabPanel;
import client.UI.userTable.UsersTable;
import client.UI.userTable.UsersTableUpdater;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import lombok.Getter;

/**
 * Main panel of UI.
 */
public class UserControlPanel extends Composite {
    
    private FlowPanel mainPanel;
    
    private UsersTable usersTable;
    
    @Getter
    private UserFormTabPanel userFormTabPanel;
    
    @Getter
    private UsersTableUpdater usersTableUpdater;
    
    /**
     * Create and initialize the main panel of UI.
     */
    public UserControlPanel() {
        mainPanel = new FlowPanel();
        usersTable = new UsersTable();
        
        usersTableUpdater = new UsersTableUpdater();
        
        usersTableUpdater.registerTable(usersTable);
        
        UserAddForm userAddForm = new UserAddForm();
        UserEditForm userEditForm = new UserEditForm();
        userAddForm.registerUsersTableUpdater(usersTableUpdater);
        userEditForm.registerUsersTableUpdater(usersTableUpdater);
        userFormTabPanel = new UserFormTabPanel(userAddForm, userEditForm);
        
        usersTable.registerUserForm(userAddForm);
        usersTable.registerUserForm(userEditForm);
        
        mainPanel.add(userFormTabPanel);
        mainPanel.add(usersTable);
        
        initWidget(mainPanel);
    }
}
