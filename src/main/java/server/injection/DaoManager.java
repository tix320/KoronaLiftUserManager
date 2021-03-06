package server.injection;

import lombok.Getter;
import server.dao.Controller;
import server.dao.DataAccessor;
import server.dao.EntityType;
import server.dao.UserController;
import server.entity.City;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Manager of data accessors.
 */
@RequestScoped
@Getter
public class DaoManager {

    @Inject
    private UserController userController;

    @Inject
    @DataAccessor(type = EntityType.CITY)
    private Controller<City> cityController;
}
