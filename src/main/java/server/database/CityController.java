package server.database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import server.entity.City;

import java.util.List;

/**
 * Data transfer of cities.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CityController extends DataAccess<City> {

    /** Instance of city controller. */
    private static CityController cityController;

    /**
     * Get instance of city controller.
     *
     * @return city controller.
     */
    public static CityController getInstance() {
        if (cityController == null) {
            cityController = new CityController();
        }
        return cityController;
    }

    @Override
    public List<City> getAll() {
        Session session = DataAccess.getSessionFactory().openSession();
        return session.createQuery("FROM City ORDER BY id", City.class).getResultList();
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
