package client.widgets.tables;

import client.dataUpdaters.DataSource;
import client.dataUpdaters.DataUpdater;
import client.objects.User;

import java.util.ArrayList;
import java.util.List;

public class UserTableDataUpdater implements DataUpdater<User, UserTable> {
    
    /** List of registered tables. */
    private List<UserTable> userTables;
    
    /** List of registered sources. */
    private List<DataSource> userDataSources;
    
    public UserTableDataUpdater() {
        userTables = new ArrayList<>();
        userDataSources = new ArrayList<>();
    }
    
    @Override
    public void registerSource(DataSource source) {
        userDataSources.add(source);
    }
    
    @Override
    public void removeSource(DataSource source) {
        userDataSources.remove(source);
    }
    
    @Override
    public void registerObserver(UserTable observer) {
        observer.setTableUpdater(this);
        userTables.add(observer);
    }
    
    @Override
    public void removeObserver(UserTable observer) {
        observer.setTableUpdater(null);
        userTables.remove(observer);
    }
    
    @Override
    public void updateObservers(User user, UpdateType updateType) {
        userTables.forEach(userTable -> userTable.updateTable(user, updateType));
    }
    
    public void sendSelectedUser(User user) {
        userDataSources.forEach(userDataSource -> userDataSource.response(user));
    }
}
