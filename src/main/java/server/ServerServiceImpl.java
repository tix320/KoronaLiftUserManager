package server;

import client.ServerAPI.ServerService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import server.injection.ConverterManager;
import server.injection.DaoManager;
import shared.dto.CityDto;
import shared.dto.UserDto;

import javax.inject.Inject;
import java.util.List;

public class ServerServiceImpl extends RemoteServiceServlet implements ServerService {
    private static final long serialVersionUID = -2615428359694308574L;

    @Inject
    private ConverterManager converterManager;

    @Inject
    private DaoManager daoManager;

    @Override
    public void addUser(final UserDto userDto) {
        daoManager.getUserController().add(converterManager.getUserConverter().convertToEntity(userDto));
    }

    @Override
    public void editUser(final UserDto userDto) {
        daoManager.getUserController().update(converterManager.getUserConverter().convertToEntity(userDto));
    }

    @Override
    public void removeUser(final UserDto userDto) {
        daoManager.getUserController().delete(converterManager.getUserConverter().convertToEntity(userDto));
    }

    @Override
    public List<UserDto> getUsers() {
        return converterManager.getUserConverter().convertToDto(daoManager.getUserController().getAll());
    }

    @Override
    public List<CityDto> getCities() {
        return converterManager.getCityConverter().convertToDto(daoManager.getCityController().getAll());
    }
}
