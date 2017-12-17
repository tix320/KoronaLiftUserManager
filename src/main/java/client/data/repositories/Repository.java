package client.data.repositories;

import client.ServerAPI.ServerService;
import client.ServerAPI.ServerServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeHandler;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction for creating any repository.
 *
 * @param <D> is a type of data.
 */
public abstract class Repository<D> {

    /** Instance for requests. */
    static final ServerServiceAsync SERVER_SERVICE = GWT.create(ServerService.class);

    /** Users list. */
    @Setter(value = AccessLevel.PROTECTED)
    private List<D> resultList;

    /** List of observers. */
    @Getter
    private final List<ChangeHandler> listeners = new ArrayList<>();

    /**
     * Get result list by creating new list.
     *
     * @return result list.
     */
    public List<D> getResultList() {
        return new ArrayList<>(resultList);
    }

    /**
     * Add object, who will listener.
     *
     * @param listener for addition in listeners list.
     */
    public final void registerListener(final ChangeHandler listener) {
        listeners.add(listener);
    }

    /**
     * Notify listeners.
     */
    void handleEvent() {
        listeners.forEach(listener -> listener.onChange(null));
    }
}
