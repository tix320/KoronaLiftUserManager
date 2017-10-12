package client.dataUpdaters;


import client.widgets.tables.UpdateType;

/**
 * Utility for updating any data and notify own observers.
 *
 * @param <D> is a type of data.
 * @param <O> is a type of observer.
 */
public interface DataUpdater<D, O> {
    
    /**
     * Add data source.
     *
     * @param source is a data source.
     */
    void registerSource(DataSource source);
    
    /**
     * Remove the data source.
     *
     * @param source is a removing source.
     */
    void removeSource(DataSource source);
    
    /**
     * Add observer, who will follow this updater.
     *
     * @param observer is adding observer.
     */
    void registerObserver(O observer);
    
    /**
     * Remove the observer.
     *
     * @param observer is removing observer.
     */
    void removeObserver(O observer);
    
    /**
     * Send data from sources to observers.
     *
     * @param data is sending data.
     */
    void updateObservers(D data, UpdateType updateType);
}
