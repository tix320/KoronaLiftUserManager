package client.UI.userForm.tabPanel;

import client.UI.userForm.UserForm;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabPanel;

import java.util.Arrays;

/**
 * Tab panel for any widgets.
 */
public class UserFormTabPanel extends Composite {
    
    /**
     * Create Tab panel, where are added user forms.
     */
    public UserFormTabPanel(UserForm... userForms) {
        TabPanel userFormTabPanel = new TabPanel();
        Arrays.stream(userForms).forEach(userForm -> userFormTabPanel.add(userForm, userForm.getSendType().getText()));
        userFormTabPanel.setStyleName("user-tab-panel-general");
        userFormTabPanel.getTabBar().selectTab(0);
        userFormTabPanel.setAnimationEnabled(true);
        
        initWidget(userFormTabPanel);
    }
}
