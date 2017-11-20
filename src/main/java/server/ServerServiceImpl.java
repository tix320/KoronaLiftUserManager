package server;

import client.ServerAPI.ServerService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import server.injection.Converter;
import server.injection.Dao;
import shared.models.CityDto;
import shared.models.UserDto;

import javax.inject.Inject;
import java.util.List;

public class ServerServiceImpl extends RemoteServiceServlet implements ServerService {

    private static final long serialVersionUID = -2615428359694308574L;

    @Inject
    private Converter converter;

    @Inject
    private Dao dao;

    @Override
    public void addUser(final UserDto userDto) {
        dao.getUserController().add(converter.getUserConverter().convertToEntity(userDto));
    }

    @Override
    public void editUser(final UserDto userDto) {
        dao.getUserController().update(converter.getUserConverter().convertToEntity(userDto));
    }

    @Override
    public void removeUser(final UserDto userDto) {
        dao.getUserController().delete(converter.getUserConverter().convertToEntity(userDto));
    }

    @Override
    public List<UserDto> getUsers() {
        return converter.getUserConverter().convertToDto(dao.getUserController().getAll());
    }

    @Override
    public List<CityDto> getCities() {
        return converter.getCityConverter().convertToDto(dao.getCityController().getAll());
    }
}
