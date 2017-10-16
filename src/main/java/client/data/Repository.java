package client.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction for creating any repository.
 */
public abstract class Repository<D> {
    
    /** List of observers. */
    private List<DataObserver<D>> observers = new ArrayList<>();
    
    /** List of data sources. */
    protected List<DataSource<D>> sources = new ArrayList<>();
    
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
