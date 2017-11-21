package server.entity;

/**
 * Entities must implement this interface to perform CRUD operations.
 *
 * @param <T> is type of ID.
 */
public interface EntityI<T> {

    T getId();

    void setId(T id);
}
