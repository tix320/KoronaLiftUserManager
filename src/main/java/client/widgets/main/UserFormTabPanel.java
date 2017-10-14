package client.widgets.main;

import client.widgets.forms.AddUserForm;
import client.widgets.forms.EditUserForm;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * Tab panel for any widgets.
 */
public class UserFormTabPanel extends Composite {
    
    /** Add user form tab text. */
    private static final String ADD_TAB_TEXT = "Добавить";
    
    /** Edit user form tab text. */
    private static final String EDIT_TAB_TEXT = "Изменить";
    
    /**
     * Create Tab panel, where are added user forms.
     */
    public UserFormTabPanel() {
        TabPanel userFormTabPanel = new TabPanel();
        AddUserForm addUserForm = new AddUserForm();
        EditUserForm editUserForm = new EditUserForm();
        
        userFormTabPanel.add(addUserForm, ADD_TAB_TEXT);
        userFormTabPanel.add(editUserForm, EDIT_TAB_TEXT);
        
        userFormTabPanel.setStyleName("user-tab-panel-general");
        userFormTabPanel.getTabBar().selectTab(0);
        userFormTabPanel.setAnimationEnabled(true);
        
        initWidget(userFormTabPanel);
    }
}