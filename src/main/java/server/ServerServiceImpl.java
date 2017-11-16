package server;

import client.ServerAPI.ServerService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import server.beansAccess.Converters;
import server.beansAccess.Dao;
import shared.models.CityDto;
import shared.models.UserDto;

import javax.inject.Inject;
import java.util.List;

public class ServerServiceImpl extends RemoteServiceServlet implements ServerService {

    @Inject
    private Converters converters;

    @Inject
    private Dao dao;

    private static final long serialVersionUID = -2615428359694308574L;

    @Override
    public void addUser(final UserDto userDto) {
        dao.getUserController().add(converters.getUserConverter().convertToEntity(userDto));
    }

    @Override
    public void editUser(final UserDto userDto) {
        dao.getUserController().update(converters.getUserConverter().convertToEntity(userDto));
    }

    @Override
    public void removeUser(final UserDto userDto) {
        dao.getUserController().delete(converters.getUserConverter().convertToEntity(userDto));
    }

    @Override
    public List<UserDto> getUsers() {
        return converters.getUserConverter().convertToDto(dao.getUserController().getAll());
    }

    @Override
    public List<CityDto> getCities() {
        return converters.getCityConverter().convertToDto(dao.getCityController().getAll());
    }
}
