package server.database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import server.entity.User;

import java.util.List;

/**
 * Data transfer of users.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserController extends DataAccess<User> {

    /** Instance of user controller. */
    private static UserController userController;

    /**
     * Get instance of user controller.
     *
     * @return user controller.
     */
    public static UserController getInstance() {
        if (userController == null) {
            userController = new UserController();
        }
        return userController;
    }

    @Override
    public List<User> getAll() {
        Session session = DataAccess.getSessionFactory().openSession();
        return session.createQuery("FROM User ORDER BY id", User.class).getResultList();
    }

    @Override
    public void add(final User newUser) {
        Session session = DataAccess.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.save(newUser);
        transaction.commit();
    }

    @Override
    public void delete(final User removableUser) {
        Session session = DataAccess.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.delete(removableUser);
        transaction.commit();
    }

    @Override
    public void update(final User alterableUser) {
        Session session = DataAccess.getSessionFactory().openSession();

        User user = session.get(User.class, alterableUser.getId());

        user.setFirstName(alterableUser.getFirstName());
        user.setPatronymic(alterableUser.getPatronymic());
        user.setLastName(alterableUser.getLastName());
        user.setGender(alterableUser.getGender());
        user.setCity(alterableUser.getCity());
        user.setDateOfBirth(alterableUser.getDateOfBirth());

        Transaction transaction = session.beginTransaction();
        transaction.commit();
    }
}
