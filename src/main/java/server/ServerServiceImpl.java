package server;

import client.ServerAPI.ServerService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import server.serviceHelpers.CityServiceHelper;
import server.serviceHelpers.UserServiceHelper;
import shared.dto.CityDto;
import shared.dto.UserDto;

import javax.inject.Inject;
import java.util.List;

public class ServerServiceImpl extends RemoteServiceServlet implements ServerService {
    private static final long serialVersionUID = -2615428359694308574L;

    @Inject
    private UserServiceHelper userServiceHelper;

    @Inject
    private CityServiceHelper cityServiceHelper;

    @Override
    public long addUser(final UserDto userDto) {
        userServiceHelper.addUser(userDto);
        return userServiceHelper.getUsersQuantityFromThisCity(userDto.getCity());
    }

    @Override
    public long editUser(final UserDto userDto) {
        userServiceHelper.editUser(userDto);
        return userServiceHelper.getUsersQuantityFromThisCity(userDto.getCity());
    }

    @Override
    public long removeUser(final UserDto userDto) {
        userServiceHelper.removeUser(userDto);
        return userServiceHelper.getUsersQuantityFromThisCity(userDto.getCity());
    }

    @Override
    public List<UserDto> getUsers() {
        return userServiceHelper.getUsers();
    }

    @Override
    public void addCity(CityDto cityDto) {
        cityServiceHelper.addCity(cityDto);
    }

    @Override
    public List<CityDto> getCities() {
        return cityServiceHelper.getCities();
    }
}
