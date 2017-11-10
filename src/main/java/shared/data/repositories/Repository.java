package shared.data.repositories;

import client.ServerAPI.ServerService;
import client.ServerAPI.ServerServiceAsync;
import com.google.gwt.core.client.GWT;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import shared.data.DataObservable;
import shared.data.DataObserver;
import shared.data.DataSource;

/**
 * Abstraction for creating any repository.
 *
 * @param <D> is a type of data.
 */
public abstract class Repository<D> implements DataObservable<D> {

    /** Instance for requests. */
    static final ServerServiceAsync SERVER_SERVICE = GWT.create(ServerService.class);

    /** List of observers. */
    private List<DataObserver<D>> observers = new ArrayList<>();

    /** List of data sources. */
    @Getter
    private List<DataSource<D>> sources = new ArrayList<>();

    /**
     * Add data source.
     *
     * @param source is a data source.
     */
    public void registerSource(final DataSource<D> source) {
        sources.add(source);
    }

    @Override
    public final void registerObserver(final DataObserver<D> observer) {
        observers.add(observer);
    }

    @Override
    public final void updateObservers(final List<D> data) {
        observers.forEach(dataObserver -> dataObserver.update(data));
    }
}
