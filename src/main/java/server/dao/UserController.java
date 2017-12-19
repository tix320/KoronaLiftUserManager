package server.dao;

import server.entity.City;
import server.entity.User;

import javax.enterprise.context.RequestScoped;
import java.util.List;

/**
 * Data transfer of users.
 */
@RequestScoped
public class UserController extends Controller<User> {

    /**
     * Set entity class.
     */
    public UserController() {
        setEntityClass(User.class);
    }

    @Override
    public List<User> getAll() {
        return getEntityManager().createQuery("FROM User ORDER BY id", User.class).getResultList();
    }

    /**
     * Get users quantity filter by City.
     *
     * @param city for filter.
     * @return quantity of users.
     */
    public Long getUsersQuantityFromThisCity(final City city) {
        return getEntityManager().createQuery("SELECT count (user) FROM User user where user.city = :city", Long.class)
                .setParameter("city", city)
                .getSingleResult();
    }
}
