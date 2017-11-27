package server.dao;

import server.entity.User;

import javax.enterprise.context.RequestScoped;
import java.util.List;

/**
 * Data transfer of users.
 */
@RequestScoped
@DataAccessor(type = EntityType.USER)
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
}
