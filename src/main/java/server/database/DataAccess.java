package server.database;

import java.util.List;

/**
 * Data access object to interact with the database.
 *
 * @param <D> is a type of data.
 */
public interface DataAccess<D> {

    /**
     * Get all data objects.
     *
     * @return list of data objects.
     */
    List<D> getAll();

    /**
     * Add new data object.
     *
     * @param entity is adding data object.
     */
    void add(D entity);

    /**
     * Delete data object.
     *
     * @param entity is removing data object.
     */
    void delete(D entity);

    /**
     * Update data object.
     *
     * @param entity is updating data object.
     */
    void update(D entity);
}
