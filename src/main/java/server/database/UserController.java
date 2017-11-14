package server.database;

import server.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Data transfer of users.
 */
@Stateless
public class UserController implements DataAccess<User> {

    @PersistenceContext(unitName = "TestUnit")
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("FROM User ORDER BY id", User.class).getResultList();
    }

    @Override
    public void add(final User newUser) {
        entityManager.persist(newUser);
    }

    @Override
    public void delete(final User removableUser) {
        entityManager.remove(removableUser);
    }

    @Override
    public void update(final User alterableUser) {

        User user = entityManager.find(User.class, alterableUser.getId());

        user.setFirstName(alterableUser.getFirstName());
        user.setPatronymic(alterableUser.getPatronymic());
        user.setLastName(alterableUser.getLastName());
        user.setGender(alterableUser.getGender());
        user.setCity(alterableUser.getCity());
        user.setDateOfBirth(alterableUser.getDateOfBirth());

        entityManager.refresh(user);
    }
}
