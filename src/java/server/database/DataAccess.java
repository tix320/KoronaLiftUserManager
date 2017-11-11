package server.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Data access object to interact with the database.
 *
 * @param <D> is a type of data.
 */
public abstract class DataAccess<D> {

    /** Instance of session factory. */
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    /**
     * Get instance of session factory.
     *
     * @return session factory.
     */
    static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Get all data objects.
     *
     * @return list of data objects.
     */
    public abstract List<D> getAll();

    /**
     * Add new data object.
     *
     * @param entity is adding data object.
     */
    public abstract void add(D entity);

    /**
     * Delete data object.
     *
     * @param entity is removing data object.
     */
    public abstract void delete(D entity);

    /**
     * Update data object.
     *
     * @param entity is updating data object.
     */
    public abstract void update(D entity);
}
