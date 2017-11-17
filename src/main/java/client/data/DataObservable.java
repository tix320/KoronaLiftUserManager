package client.data;

import java.util.List;

/**
 * Interface to get any data and notify observers.
 *
 * @param <D> is a type of data.
 */
public interface DataObservable<D> {

    /**
     * Add object, who will observe.
     *
     * @param observer is adding observer.
     */
    void registerObserver(DataObserver<D> observer);

    /**
     * Send actual data to observers.
     *
     * @param data is a new data.
     */
    void updateObservers(List<D> data);
}
