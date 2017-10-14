package client.data;

/**
 * To become an observer of information, need to implement an interface.
 *
 * @param <D> is a type of data.
 */
public interface DataObserver<D> {
    
    /**
     * Update data.
     *
     * @param data is a data owner.
     * @param updateType is a type of update.
     */
    void update(D data, UpdateType updateType);
}