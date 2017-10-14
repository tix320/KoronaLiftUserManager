package client.data.repositories;

import client.data.Repository;
import client.data.UpdateType;
import client.models.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Repository for users.
 */
public class UsersRepository extends Repository<User> {
    
    /** Repository reference. */
    private static UsersRepository usersRepository;
    
    /** List of usersMap. */
    private Map<Integer, User> usersMap = new HashMap<>();
    
    /** Next user ID. */
    private Integer nextID = 0;
    
    /**
     * Create the repository.
     */
    public static UsersRepository getInstance() {
        if (usersRepository == null) {
            usersRepository = new UsersRepository();
        }
        return usersRepository;
    }
    
    /**
     * Add new user.
     *
     * @param user is adding user.
     */
    public void addUser(User user) {
        Integer userID = ++nextID;
        user.setID(userID);
        usersMap.put(userID, user);
        updateObservers(user, UpdateType.ADD);
    }
    
    /**
     * Edit the user.
     *
     * @param ID is index of user.
     * @param user is a new data of user.
     */
    public void editUser(Integer ID, User user) {
        usersMap.put(ID, user);
        updateObservers(user, UpdateType.EDIT);
    }
    
    /**
     * Remove the user.
     *
     * @param ID is a removing user's ID.
     */
    public void removeUser(Integer ID) {
        updateObservers(usersMap.get(ID), UpdateType.REMOVE);
        usersMap.remove(ID);
    }
    
    /**
     * Send any data from observers to sources.
     *
     * @param user is a data owner.
     */
    public void responseFromObserver(Integer ID, User user) {
        sources.forEach(source -> source.response(ID, user));
    }
}