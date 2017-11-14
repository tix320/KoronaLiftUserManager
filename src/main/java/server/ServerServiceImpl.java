package server;

import client.ServerAPI.ServerService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import lombok.val;
import server.converters.CityConverter;
import server.converters.UserConverter;
import server.database.CityController;
import server.database.UserController;
import shared.models.CityDto;
import shared.models.UserDto;

import javax.inject.Inject;
import java.util.List;


public class ServerServiceImpl extends RemoteServiceServlet implements ServerService {
    private static final long serialVersionUID = -2615428359694308574L;

    @Inject
    private UserController userController;

    @Inject
    private CityController cityController;

    @Inject
    private UserConverter userConverter;

    @Inject
    private CityConverter cityConverter;

    @Override
    public void addUser(final UserDto userDto) {
        userController.add(userConverter.convertToEntity(userDto));
    }

    @Override
    public void editUser(final UserDto userDto) {
        userController.update(userConverter.convertToEntity(userDto));
    }

    @Override
    public void removeUser(final UserDto userDto) {
        userController.delete(userConverter.convertToEntity(userDto));
    }

    @Override
    public List<UserDto> getUsers() {
        val users = userController.getAll();
        return userConverter.convertToDto(users);
    }

    @Override
    public List<CityDto> getCities() {
        return cityConverter.convertToDto(cityController.getAll());
    }
}

