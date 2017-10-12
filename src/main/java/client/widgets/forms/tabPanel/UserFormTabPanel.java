package client.widgets.forms.tabPanel;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * Tab panel for any widgets.
 */
public class UserFormTabPanel extends Composite {
    
    /**
     * Create Tab panel, where are added user forms.
     */
    public UserFormTabPanel(AddUserForm addUserForm, EditUserForm editUserForm) {
        TabPanel userFormTabPanel = new TabPanel();
    
        userFormTabPanel.add(addUserForm, "Добавить");
        userFormTabPanel.add(editUserForm, "Изменить");
        
        userFormTabPanel.setStyleName("user-tab-panel-general");
        userFormTabPanel.getTabBar().selectTab(0);
        userFormTabPanel.setAnimationEnabled(true);
        
        initWidget(userFormTabPanel);
    }
}
