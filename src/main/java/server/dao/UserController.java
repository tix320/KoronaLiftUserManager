package server.dao;

import server.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Data transfer of users.
 */
@Named
@RequestScoped
@DataAccessor(type = EntityType.USER)
public class UserController extends Controller<User> {

    @Override
    public List<User> getAll() {
        return getEntityManager().createQuery("FROM User ORDER BY id", User.class).getResultList();
    }
}
