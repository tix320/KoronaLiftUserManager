package client.UI.main;

import client.UI.userForm.forms.UserAddForm;
import client.UI.userForm.forms.UserEditForm;
import client.UI.userForm.tabPanel.UserFormTabPanel;
import client.UI.userTable.UsersTable;
import client.containers.UserContainer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import lombok.Getter;

/**
 * Main panel of UI.
 */
public class MainPanel extends Composite {
    
    @Getter
    private static UserContainer userContainer;
    
    /**
     * Create and initialize the main panel of UI.
     */
    public MainPanel() {
        final FlowPanel mainPanel = new FlowPanel();
        final UsersTable usersTable = new UsersTable();
        
        final UserAddForm userAddForm = new UserAddForm();
        final UserEditForm userEditForm = new UserEditForm();
        
        userContainer = new UserContainer(usersTable, userAddForm, userEditForm);
        
        final UserFormTabPanel userFormTabPanel = new UserFormTabPanel();
        
        mainPanel.add(userFormTabPanel);
        mainPanel.add(usersTable);
        
        initWidget(mainPanel);
    }
}
