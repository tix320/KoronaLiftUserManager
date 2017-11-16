package server.beansAccess;

import lombok.Getter;
import server.database.DataAccess;
import server.entity.City;
import server.entity.User;

import javax.ejb.EJB;
import javax.inject.Named;

@Named
@Getter
public class Dao {

    @EJB(beanName = "UserController")
    private DataAccess<User> userController;

    @EJB(beanName = "CityController")
    private DataAccess<City> cityController;
}
