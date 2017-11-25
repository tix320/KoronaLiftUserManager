package client.data;

import java.util.List;

/**
 * To become an observer of information, need to implement this interface.
 *
 * @param <D> is a type of data.
 */
public interface DataObserver<D> {

    /**
     * Update data.
     *
     * @param data is a data owner.
     */
    void update(List<D> data);
}
