package client.widgets.main;

import client.data.DataRepository;
import client.data.Repository;
import client.objects.User;
import client.widgets.forms.tabPanel.AddUserForm;
import client.widgets.forms.tabPanel.EditUserForm;
import client.widgets.forms.tabPanel.UserFormTabPanel;
import client.widgets.tables.UserTable;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * Main panel of UI.
 */
public class UserControlPanel extends Composite {
    
    /**
     * Create and initialize the main panel of UI.
     */
    public UserControlPanel() {
        FlowPanel mainPanel = new FlowPanel();
    
        UserTable userTable = new UserTable();
    
        AddUserForm addUserForm = new AddUserForm();
        EditUserForm editUserForm = new EditUserForm();
        UserFormTabPanel userFormTabPanel = new UserFormTabPanel(addUserForm, editUserForm);
    
        Repository<User> usersRepository = DataRepository.getUsersRepository();
    
        usersRepository.registerObserver(userTable);
        usersRepository.registerSource(addUserForm);
        usersRepository.registerSource(editUserForm);
        
        mainPanel.add(userFormTabPanel);
        mainPanel.add(userTable);
    
        initWidget(mainPanel);
    }
}
