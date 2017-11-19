package server.beansAccess;

import javax.ejb.EJB;
import javax.inject.Named;
import lombok.Getter;
import server.converters.DataConverter;
import server.entity.City;
import server.entity.User;
import shared.models.CityDto;
import shared.models.UserDto;

@Named
@Getter
public class Converters {

    @EJB(beanName = "UserConverter")
    private DataConverter<UserDto, User> userConverter;

    @EJB(beanName = "CityConverter")
    private DataConverter<CityDto, City> cityConverter;
}
