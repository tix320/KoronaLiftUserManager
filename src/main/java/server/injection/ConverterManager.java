package server.injection;

import lombok.Getter;
import server.converters.DataConverter;
import server.entity.City;
import server.entity.User;
import shared.dto.CityDto;
import shared.dto.UserDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

/**
 * Manager of converters.
 */
@RequestScoped
@Getter
public class ConverterManager {

    @EJB(beanName = "UserConverter")
    private DataConverter<UserDto, User> userConverter;

    @EJB(beanName = "CityConverter")
    private DataConverter<CityDto, City> cityConverter;
}
