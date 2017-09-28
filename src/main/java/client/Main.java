package client;

import client.widgets.UserAddForm;
import client.widgets.UsersTable;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

public class Main implements EntryPoint {

    private static FlowPanel mainFlowPanel;
    private static UserAddForm userAddForm;
    private static UsersTable usersTable;

     private void initWidgets(){
        mainFlowPanel = new FlowPanel();
        usersTable = new UsersTable();
        userAddForm = new UserAddForm();

        mainFlowPanel.add(userAddForm);
        mainFlowPanel.add(usersTable);
    }

    public static UsersTable getUsersTable() {
        return usersTable;
    }

    @Override
    public void onModuleLoad() {
        initWidgets();

        RootPanel.get().add(mainFlowPanel);
    }
}