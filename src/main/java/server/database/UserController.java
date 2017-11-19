package server.database;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import server.entity.User;

/**
 * Data transfer of users.
 */
@Stateless
public class UserController implements DataAccess<User> {

    @PersistenceContext(unitName = "TestUnit")
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("FROM User ORDER BY id",
            User.class).getResultList();
    }

    @Override
    public void add(final User newUser) {
        entityManager.persist(newUser);
    }

    @Override
    public void delete(final User removableUser) {
        User user = entityManager.find(User.class, removableUser.getId());
        entityManager.remove(user);
    }

    @Override
    public void update(final User alterableUser) {
        if (entityManager.find(User.class, alterableUser.getId()) != null) {
            entityManager.merge(alterableUser);
        }
    }
}
