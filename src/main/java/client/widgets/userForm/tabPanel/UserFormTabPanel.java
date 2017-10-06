package client.widgets.userForm.tabPanel;

import client.widgets.main.MainPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabPanel;

public class UserFormTabPanel extends Composite {
    
    /**
     * Create Tab panel, where are added user forms.
     */
    public UserFormTabPanel() {
        TabPanel userFormTabPanel = new TabPanel();
        
        userFormTabPanel.add(MainPanel.getUserContainer().getUserAddForm(), TabText.ADD.getText());
        userFormTabPanel.add(MainPanel.getUserContainer().getUserEditForm(), TabText.EDIT.getText());
        
        userFormTabPanel.setStyleName("user-tab-panel-general");
        userFormTabPanel.getTabBar().selectTab(0);
        userFormTabPanel.setAnimationEnabled(true);
        
        initWidget(userFormTabPanel);
    }
}
