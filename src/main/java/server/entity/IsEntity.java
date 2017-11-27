package server.entity;

/**
 * Entities must implement this interface to perform CRUD operations.
 *
 * @param <T> is type of ID.
 */
public interface IsEntity<T> {

    /**
     * Get entity id.
     *
     * @return id.
     */
    T getId();

    /**
     * Set entity id.
     *
     * @param id of entity.
     */
    void setId(T id);
}
