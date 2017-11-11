package server.converters;

import server.entity.User;
import shared.models.UserDto;

/**
 * Converter to convert user objects.
 */
public class UserConverter implements DataConverter<UserDto, User> {

    /** Instance of user converter. */
    private static UserConverter userConverter;

    /**
     * Get instance of user converter.
     *
     * @return user converter.
     */
    public static UserConverter getConverter() {
        if (userConverter == null) {
            userConverter = new UserConverter();
        }
        return userConverter;
    }

    @Override
    public final UserDto convertToDto(final User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setPatronymic(user.getPatronymic());
        userDto.setLastName(user.getLastName());
        userDto.setGender(user.getGender());
        userDto.setCity(CityConverter.getConverter().convertToDto(user.getCity()));
        userDto.setDateOfBirth(user.getDateOfBirth());
        return userDto;
    }

    @Override
    public final User convertToEntity(final UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setPatronymic(userDto.getPatronymic());
        user.setLastName(userDto.getLastName());
        user.setGender(userDto.getGender());
        user.setCity(CityConverter.getConverter().convertToEntity(userDto.getCity()));
        user.setDateOfBirth(userDto.getDateOfBirth());
        return user;
    }
}
