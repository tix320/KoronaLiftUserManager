package client.ServerAPI;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import shared.models.CityDto;
import shared.models.UserDto;

import java.util.List;


@RemoteServiceRelativePath("SampleService")
public interface ServerService extends RemoteService {

    /**
     * Add new user.
     *
     * @param user is adding user.
     */
    void addUser(UserDto user);

    /**
     * Edit user.
     *
     * @param user is editing user.
     */
    void editUser(UserDto user);

    /**
     * Remove user.
     *
     * @param user is removing user.
     */
    void removeUser(UserDto user);

    /**
     * Get list of users from database.
     *
     * @return list of users
     */
    List<UserDto> getUsers();

    /**
     * Get list of cities from database.
     *
     * @return list of cities.
     */
    List<CityDto> getCities();
}
