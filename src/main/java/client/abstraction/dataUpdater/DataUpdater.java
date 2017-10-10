package client.abstraction.dataUpdater;

import client.abstraction.ObjectOperator;

/**
 * Utility for updating any data and notify own observers.
 * Object-Source-Follower.
 *
 * @param <O> is a type of object.
 * @param <S> is a type of data source.
 * @param <F> is a type of follower.
 */
public interface DataUpdater<O, S, F> extends ObjectOperator<O> {
    
    /**
     * Add new data source.
     *
     * @param source is a data source.
     */
    void addDataSource(S source);
    
    /**
     * Add widget, who will follow this updater.
     *
     * @param widget is adding widget.
     */
    void registerObserver(F widget);
    
    /**
     * Delete the widget.
     *
     * @param widget is removing widget.
     */
    void removeObserver(F widget);
    
    
}
