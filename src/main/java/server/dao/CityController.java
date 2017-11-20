package server.dao;

import server.entity.City;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Data transfer of cities.
 */
@Named
@RequestScoped
@DataAccessor(type = EntityType.CITY)
public class CityController extends Controller<City> {

    public CityController() {
        setEntityClass(City.class);
    }

    @Override
    public List<City> getAll() {
        return getEntityManager().createQuery("FROM City ORDER BY id", City.class).getResultList();
    }
}
