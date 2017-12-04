package client.ServerAPI;

import com.google.gwt.user.client.rpc.AsyncCallback;
import shared.dto.CityDto;
import shared.dto.UserDto;

import java.util.List;

public interface ServerServiceAsync {

    /**
     * Add new user.
     *
     * @param user  is adding user.
     * @param async is asynchronous callback.
     */
    void addUser(UserDto user, AsyncCallback<Void> async);

    /**
     * Edit user.
     *
     * @param user  is editing user.
     * @param async is asynchronous callback.
     */
    void editUser(UserDto user, AsyncCallback<Void> async);

    /**
     * Remove user.
     *
     * @param user  is removing user.
     * @param async is asynchronous callback.
     */
    void removeUser(UserDto user, AsyncCallback<Void> async);

    /**
     * Get list of users from database.
     *
     * @param async is asynchronous callback.
     */
    void getUsers(AsyncCallback<List<UserDto>> async);

    /**
     * Get list of cities from database.
     *
     * @param async is asynchronous callback.
     */
    void getCities(AsyncCallback<List<CityDto>> async);
}