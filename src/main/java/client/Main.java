package client;

import client.widgets.UserAddForm;
import client.widgets.UserEditForm;
import client.widgets.UsersTable;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

public class Main implements EntryPoint {

    private UserAddForm userAddForm;
    private UserEditForm userEditForm;

    private void createUI() {
        TabPanel userTabPanel = new TabPanel();
        FlowPanel mainFlowPanel = new FlowPanel();
        UsersTable usersTable = new UsersTable();

        userAddForm = new UserAddForm();
        userEditForm = new UserEditForm();

        usersTable.setUserEditForm(userEditForm);
        usersTable.setUserAddForm(userAddForm);

        userAddForm.setUsersTable(usersTable);
        userEditForm.setUsersTable(usersTable);

        userTabPanel.setStyleName("user-tab-panel-general");
        userTabPanel.add(userAddForm, "Добавить");
        userTabPanel.add(userEditForm, "Изменить");
        userTabPanel.getTabBar().selectTab(0);
        userTabPanel.setAnimationEnabled(true);

        mainFlowPanel.add(userTabPanel);
        mainFlowPanel.add(usersTable);
        RootPanel.get().add(mainFlowPanel);

    }

    @Override
    public void onModuleLoad() {
        createUI();
    }
}