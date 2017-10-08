package client.UI.userForm.tabPanel;

import client.UI.userForm.forms.UserAddForm;
import client.UI.userForm.forms.UserEditForm;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabPanel;
import lombok.Getter;

public class UserFormTabPanel extends Composite {
    
    @Getter
    private UserAddForm userAddForm;
    @Getter
    private UserEditForm userEditForm;
    
    /**
     * Create Tab panel, where are added user forms.
     */
    public UserFormTabPanel(UserAddForm userAddForm, UserEditForm userEditForm) {
        TabPanel userFormTabPanel = new TabPanel();
        this.userAddForm = userAddForm;
        this.userEditForm = userEditForm;
    
        userFormTabPanel.add(userAddForm, TabText.ADD.getText());
        userFormTabPanel.add(userEditForm, TabText.EDIT.getText());
        
        userFormTabPanel.setStyleName("user-tab-panel-general");
        userFormTabPanel.getTabBar().selectTab(0);
        userFormTabPanel.setAnimationEnabled(true);
        
        initWidget(userFormTabPanel);
    }
}
