package server.database;

import server.entity.City;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Data transfer of cities.
 */
@Stateless
public class CityController implements DataAccess<City> {

    @PersistenceContext(unitName = "TestUnit")
    private EntityManager entityManager;

    @Override
    public List<City> getAll() {
        return entityManager.createQuery("FROM City ORDER BY id", City.class).getResultList();
    }

    @Override
    public void add(final City entity) {

    }

    @Override
    public void delete(final City entity) {

    }

    @Override
    public void update(final City entity) {

    }
}
