package client.UI.userTable;

import client.abstraction.userTable.Table;
import client.abstraction.userTable.TableDataUpdater;
import client.modules.User;
import com.google.gwt.view.client.ListDataProvider;

public class UsersTableUpdater implements TableDataUpdater {
    private ListDataProvider<User> usersList;
    
    public UsersTableUpdater() {
        usersList = new ListDataProvider<>();
    }
    
    @Override
    public void registerTable(Table table) {
        usersList.addDataDisplay(table.getCellTable());
        table.setUsersTableUpdater(this);
    }
    
    @Override
    public void removeTable(Table table) {
        usersList.removeDataDisplay(table.getCellTable());
    }
    
    public void addUser(User newUser) {
        usersList.getList().add(newUser);
    }
    
    public void editUser() {
        usersList.refresh();
    }
    
    public void removeUser(User user) {
        usersList.getList().remove(user);
    }
}
