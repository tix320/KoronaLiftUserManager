package server.serviceHelpers;

import server.injection.ConverterManager;
import server.injection.DaoManager;
import shared.dto.CityDto;
import shared.dto.UserDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Service helper for users requests.
 */
@RequestScoped
public class UserServiceHelper {

    @Inject
    private ConverterManager converterManager;

    @Inject
    private DaoManager daoManager;

    /**
     * Add new user.
     *
     * @param userDto is additional user.
     */
    public void addUser(final UserDto userDto) {
        daoManager.getUserController().add(converterManager.getUserConverter().convertToEntity(userDto));
    }

    /**
     * Edit this user.
     *
     * @param userDto is editing user.
     */
    public void editUser(final UserDto userDto) {
        daoManager.getUserController().update(converterManager.getUserConverter().convertToEntity(userDto));
    }

    /**
     * Remove this user.
     *
     * @param userDto is removing user.
     */
    public void removeUser(final UserDto userDto) {
        daoManager.getUserController().delete(converterManager.getUserConverter().convertToEntity(userDto));
    }

    /**
     * Get list of users from database.
     *
     * @return list of users.
     */
    public List<UserDto> getUsers() {
        return converterManager.getUserConverter().convertToDto(daoManager.getUserController().getAll());
    }

    /**
     * Get users quantity from city.
     *
     * @param cityDto is current city.
     * @return quantity of users.
     */
    public long getUsersQuantityFromThisCity(CityDto cityDto) {
        return daoManager.getUserController().getUsersQuantityFromThisCity(converterManager.getCityConverter().convertToEntity(cityDto));
    }
}
