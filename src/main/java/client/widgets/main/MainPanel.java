package client.widgets.main;

import client.widgets.userForm.UserAddForm;
import client.widgets.userForm.UserEditForm;
import client.widgets.userTable.UsersTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * Main panel of UI.
 */
public class MainPanel {
    
    /** Panel, where there will be user forms. */
    private TabPanel userTabPanel;
    
    /** Form, from which will be added users. */
    private UserAddForm userAddForm;
    
    /** Form, from which will be edited users. */
    private UserEditForm userEditForm;
    
    /**
     * Create and initialize the main panel of UI.
     *
     * @return main panel.
     */
    public FlowPanel createUI() {
        final FlowPanel mainPanel = new FlowPanel();
        final UsersTable usersTable = new UsersTable();
        
        userTabPanel = new TabPanel();
        userAddForm = new UserAddForm();
        userEditForm = new UserEditForm();
        
        createTabPanel();
        
        usersTable.setUserAddForm(userAddForm);
        usersTable.setUserEditForm(userEditForm);
        
        userAddForm.setUsersTable(usersTable);
        userEditForm.setUsersTable(usersTable);
        
        mainPanel.add(userTabPanel);
        mainPanel.add(usersTable);
        
        return mainPanel;
        
    }
    
    /**
     * Create Tab panel, where are added user forms.
     */
    private void createTabPanel() {
        userTabPanel.setStyleName("user-tab-panel-general");
        userTabPanel.add(userAddForm, "Добавить");
        userTabPanel.add(userEditForm, "Изменить");
        userTabPanel.getTabBar().selectTab(0);
        userTabPanel.setAnimationEnabled(true);
    }
}
