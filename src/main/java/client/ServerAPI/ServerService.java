package client.ServerAPI;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import shared.dto.CityDto;
import shared.dto.UserDto;

import java.util.List;

@RemoteServiceRelativePath("SampleService")
public interface ServerService extends RemoteService {

    /**
     * Add new user.
     *
     * @param user is adding user.
     * @return quantity of users from this city.
     */
    long addUser(UserDto user);

    /**
     * Edit user.
     *
     * @param user is editing user.
     * @return quantity of users from this city.
     */
    long editUser(UserDto user);

    /**
     * Remove user.
     *
     * @param user is removing user.
     * @return quantity of users from this city.
     */
    long removeUser(UserDto user);

    /**
     * Get list of users from database.
     *
     * @return list of users
     */
    List<UserDto> getUsers();

    /**
     * Add new city.
     *
     * @param city is adding city.
     */
    void addCity(CityDto city);

    /**
     * Get list of cities from database.
     *
     * @return list of cities.
     */
    List<CityDto> getCities();
}
