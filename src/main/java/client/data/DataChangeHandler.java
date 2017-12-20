package client.data;

import com.google.gwt.event.shared.EventHandler;

/**
 * Interface to handle data changes.
 *
 * @param <D> is type of data.
 */
public interface DataChangeHandler<D> extends EventHandler {

    /**
     * Update this listener.
     *
     * @param event is data change.
     */
    void update(DataChangeEvent<D> event);
}
