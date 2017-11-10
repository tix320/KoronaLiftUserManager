package shared.data;

import java.util.List;

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
     */
    void update(List<D> data);
}
