package client.widgets.main;

import client.containers.UserContainer;
import client.widgets.userForm.forms.UserAddForm;
import client.widgets.userForm.forms.UserEditForm;
import client.widgets.userForm.tabPanel.UserFormTabPanel;
import client.widgets.userTable.UsersTable;
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
