package client.widgets;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TabPanel;

public class MainPanel {

    private TabPanel userTabPanel;
    private UserAddForm userAddForm;
    private UserEditForm userEditForm;

    public FlowPanel createUI() {
        final FlowPanel mainPanel = new FlowPanel();
        final UsersTable usersTable = new UsersTable();

        userTabPanel = new TabPanel();
        userAddForm = new UserAddForm();
        userEditForm = new UserEditForm();

        createTabPanel();

        usersTable.setUserEditForm(userEditForm);
        usersTable.setUserAddForm(userAddForm);

        userAddForm.setUsersTable(usersTable);
        userEditForm.setUsersTable(usersTable);

        mainPanel.add(userTabPanel);
        mainPanel.add(usersTable);

        return mainPanel;

    }

    /**
     * Create Tab panel, where are added user forms.
     */
    private void createTabPanel(){
        userTabPanel.setStyleName("user-tab-panel-general");
        userTabPanel.add(userAddForm, "Добавить");
        userTabPanel.add(userEditForm, "Изменить");
        userTabPanel.getTabBar().selectTab(0);
        userTabPanel.setAnimationEnabled(true);
    }
}
