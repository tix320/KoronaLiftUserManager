package client.data.repositories;

import client.ServerAPI.ServerService;
import client.ServerAPI.ServerServiceAsync;
import client.data.DataChangeEvent;
import client.data.DataChangeHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;

import java.util.List;

/**
 * Abstraction for creating any repository.
 *
 * @param <D> is a type of data.
 */
public abstract class Repository<D> {

    /** Instance for managing handlers and listeners. */
    private final HandlerManager handlerManager = new HandlerManager(this);

    /** Data change event instance. */
    private final DataChangeEvent<D> event = new DataChangeEvent<>();

    /** Instance for requests. */
    static final ServerServiceAsync SERVER_SERVICE = GWT.create(ServerService.class);

    /**
     * Add object, who will listener.
     *
     * @param handler for addition in listeners list.
     */
    public final void addChangeHandler(final DataChangeHandler handler) {
        handlerManager.addHandler(event.getAssociatedType(), handler);
    }

    /**
     * Notify listeners.
     *
     * @param list id changed data.
     */
    void handleEvent(final List<D> list) {
        event.setDataList(list);
        handlerManager.fireEvent(event);
    }
}
