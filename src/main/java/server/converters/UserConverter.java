package server.converters;

import server.entity.User;
import shared.models.UserDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Converter to convert user objects.
 */
@Stateless
public class UserConverter implements DataConverter<UserDto, User>, Serializable {

    @Inject
    private CityConverter cityConverter;

    @Override
    public final UserDto convertToDto(final User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setPatronymic(user.getPatronymic());
        userDto.setLastName(user.getLastName());
        userDto.setGender(user.getGender());
        userDto.setCity(cityConverter.convertToDto(user.getCity()));
        userDto.setDateOfBirth(user.getDateOfBirth());
        return userDto;
    }

    @Override
    public List<UserDto> convertToDto(final List<User> list) {
        List<UserDto> listDto = new ArrayList<>();
        for (User user : list) {
            listDto.add(convertToDto(user));
        }
        return listDto;
    }

    @Override
    public final User convertToEntity(final UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setPatronymic(userDto.getPatronymic());
        user.setLastName(userDto.getLastName());
        user.setGender(userDto.getGender());
        user.setCity(cityConverter.convertToEntity(userDto.getCity()));
        user.setDateOfBirth(userDto.getDateOfBirth());
        return user;
    }
}
