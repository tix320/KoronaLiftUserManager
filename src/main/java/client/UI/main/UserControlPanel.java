package client.UI.main;

import client.UI.userForm.UserForm;
import client.UI.userForm.tabPanel.UserFormTabPanel;
import client.UI.userTable.UserTable;
import client.UI.userTable.UserTableDataUpdater;
import client.abstraction.SendType;
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
    
        UserTable userTable = new UserTable();
    
        UserForm addUserForm = new UserForm(SendType.ADD);
        UserForm editUserForm = new UserForm(SendType.EDIT);
        UserFormTabPanel userFormTabPanel = new UserFormTabPanel(addUserForm, editUserForm);
    
        UserTableDataUpdater userTableDataUpdater = new UserTableDataUpdater();
    
        userTableDataUpdater.registerObserver(userTable);
    
        addUserForm.registerDataUpdater(userTableDataUpdater);
        editUserForm.registerDataUpdater(userTableDataUpdater);
        
        mainPanel.add(userFormTabPanel);
        mainPanel.add(userTable);
        
        initWidget(mainPanel);
    }
}
