package server.dao;

import server.entity.City;

import javax.enterprise.context.RequestScoped;
import java.util.List;

/**
 * Data transfer of cities.
 */
@RequestScoped
@DataAccessor(type = EntityType.CITY)
public class CityController extends Controller<City> {

    public CityController() {
        setEntityClass(City.class);
    }

    @Override
    public List<City> getAll() {
        return getEntityManager().createQuery("FROM City ORDER BY name", City.class).getResultList();
    }
}
