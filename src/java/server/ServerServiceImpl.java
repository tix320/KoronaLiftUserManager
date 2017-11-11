package server;

import client.ServerAPI.ServerService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import server.converters.CityConverter;
import server.converters.UserConverter;
import server.database.CityController;
import server.database.UserController;
import server.entity.City;
import server.entity.User;
import shared.models.CityDto;
import shared.models.UserDto;

import java.util.ArrayList;
import java.util.List;

public class ServerServiceImpl extends RemoteServiceServlet implements ServerService {

    @Override
    public final void addUser(final UserDto userDto) {
        UserController.getInstance().add(UserConverter.getConverter().convertToEntity(userDto));
    }

    @Override
    public final void editUser(final UserDto userDto) {
        UserController.getInstance().update(UserConverter.getConverter().convertToEntity(userDto));
    }

    @Override
    public final void removeUser(final UserDto userDto) {
        UserController.getInstance().delete(UserConverter.getConverter().convertToEntity(userDto));
    }

    @Override
    public final List<UserDto> getUsers() {
        List<UserDto> list = new ArrayList<>();
        for (User user : UserController.getInstance().getAll()) {
            list.add(UserConverter.getConverter().convertToDto(user));
        }
        return list;
    }

    @Override
    public final List<CityDto> getCities() {
        List<CityDto> list = new ArrayList<>();
        for (City city : CityController.getInstance().getAll()) {
            list.add(CityConverter.getConverter().convertToDto(city));
        }
        return list;
    }
}
