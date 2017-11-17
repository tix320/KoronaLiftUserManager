package client.data.repositories;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import shared.models.UserDto;

import java.util.List;


/**
 * Repository for usersList.
 */
public final class UsersRepository extends Repository<UserDto> {

    /** Repository reference. */
    private static UsersRepository usersRepository;

    /**
     * Private constructor for singleton.
     */
    private UsersRepository() {
        getUsersFromDB();
    }

    /**
     * Create the repository.
     *
     * @return created repository.
     */
    static UsersRepository getInstance() {
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
    public void addUser(final UserDto user) {
        SERVER_SERVICE.addUser(user, new AsyncCallback<Void>() {
            @Override
            public void onFailure(final Throwable throwable) {
                Window.alert("Failed to add user.");
            }

            @Override
            public void onSuccess(final Void aVoid) {
                getUsersFromDB();
            }
        });

    }

    /**
     * Edit the user.
     *
     * @param user is a new data of user.
     */
    public void editUser(final UserDto user) {
        SERVER_SERVICE.editUser(user, new AsyncCallback<Void>() {
            @Override
            public void onFailure(final Throwable throwable) {
                Window.alert("Failed to edit user.");
            }

            @Override
            public void onSuccess(final Void aVoid) {
                getUsersFromDB();
            }
        });
    }

    /**
     * Remove the user.
     *
     * @param user is a removing user.
     */
    public void removeUser(final UserDto user) {
        SERVER_SERVICE.removeUser(user, new AsyncCallback<Void>() {
            @Override
            public void onFailure(final Throwable throwable) {
                Window.alert("Failed to remove user.");
            }

            @Override
            public void onSuccess(final Void aVoid) {
                getUsersFromDB();
            }
        });
    }

    /**
     * Get users from Database.
     */
    private void getUsersFromDB() {
        SERVER_SERVICE.getUsers(new AsyncCallback<List<UserDto>>() {
            @Override
            public void onFailure(final Throwable throwable) {
                Window.alert("Failed to load users list.");
            }

            @Override
            public void onSuccess(final List<UserDto> users) {
                updateObservers(users);
            }
        });
    }

    /**
     * Send any data from observers to sources.
     *
     * @param user is a data owner.
     */
    public void responseFromObserver(final UserDto user) {
        getSources().forEach(source -> source.response(user));
    }
}
