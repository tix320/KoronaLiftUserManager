package server.injection;

import lombok.Getter;
import server.dao.Controller;
import server.dao.DataAccessor;
import server.dao.EntityType;
import server.entity.City;
import server.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
@Getter
public class Dao {

    @Inject
    @DataAccessor(type = EntityType.USER)
    private Controller<User> userController;

    @Inject
    @DataAccessor(type = EntityType.CITY)
    private Controller<City> cityController;
}
