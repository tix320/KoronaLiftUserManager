package client.objects;

import client.data.Repository;
import client.widgets.tables.UpdateType;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository for users.
 */
public class UsersRepository extends Repository<User> {
    
    /** Repository reference. */
    private static UsersRepository usersRepository;
    
    /** List of users. */
    private List<User> users;
    
    /** Next user ID. */
    private int nextID = 0;
    
    /**
     * Init repository.
     */
    private UsersRepository() {
        initUsers();
    }
    
    /**
     * Create the repository.
     */
    public static UsersRepository createRepository() {
        if (usersRepository == null) {
            usersRepository = new UsersRepository();
        }
        return usersRepository;
    }
    
    /**
     * Init users list.
     */
    private void initUsers() {
        users = new ArrayList<>();
    }
    
    
    /**
     * Add new user.
     *
     * @param user is adding user.
     */
    public void addUser(User user) {
        user.setID(++nextID);
        users.add(user);
        updateObservers(user, UpdateType.ADD);
    }
    
    /**
     * Edit the user.
     *
     * @param index is index of user.
     * @param user is a new data of user.
     */
    public void editUser(int index, User user) {
        users.set(index, user);
        updateObservers(user, UpdateType.EDIT);
    }
    
    /**
     * Remove the user.
     *
     * @param user is a removing user.
     */
    public void removeUser(User user) {
        users.remove(user);
        updateObservers(user, UpdateType.REMOVE);
    }
    
    /**
     * Send any data from observers to sources.
     *
     * @param user is a data owner.
     */
    public void responseFromObserver(User user) {
        int index = users.indexOf(user);
        sources.forEach(source -> source.response(index, user));
    }
}
