package client.data;

import client.widgets.tables.UpdateType;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction of any repository.
 */
public abstract class DataRepository<D> {
    
    /** List of observers. */
    private List<DataObserver<D>> observers;
    
    /** List of data sources. */
    protected List<DataSource<D>> sources;
    
    /**
     * Create the repository.
     */
    protected DataRepository() {
        initObservers();
        initSources();
    }
    
    /**
     * Init observers list.
     */
    private void initObservers() {
        observers = new ArrayList<>();
    }
    
    /**
     * Init sources list.
     */
    private void initSources() {
        sources = new ArrayList<>();
    }
    
    /**
     * Add object, who will observe this repository.
     *
     * @param observer is adding observer.
     */
    public void registerObserver(DataObserver<D> observer) {
        observers.add(observer);
    }
    
    /**
     * Send actual data to observers.
     *
     * @param object is a new data.
     * @param updateType is a update type.
     */
    protected void updateObservers(D object, UpdateType updateType) {
        observers.forEach(dataObserver -> dataObserver.update(object, updateType));
    }
    
    
    /**
     * Add data source.
     *
     * @param source is a data source.
     */
    public void registerSource(DataSource<D> source) {
        sources.add(source);
    }
}
