package server.beansAccess;

import javax.ejb.EJB;
import javax.inject.Named;
import lombok.Getter;
import server.database.DataAccess;
import server.entity.City;
import server.entity.User;

@Named
@Getter
public class Dao {

    @EJB(beanName = "UserController")
    private DataAccess<User> userController;

    @EJB(beanName = "CityController")
    private DataAccess<City> cityController;
}
