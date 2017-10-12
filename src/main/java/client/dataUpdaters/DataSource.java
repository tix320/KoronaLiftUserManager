package client.dataUpdaters;

/**
 * Interface to send any data.
 *
 * @param <D> is a type of data.
 */
public interface DataSource<D> {
    
    /**
     * Add data updater, who will transfer the data.
     *
     * @param dataUpdater is adding data updater.
     */
    void setDataUpdater(DataUpdater dataUpdater);
    
    /**
     * Delete the data updater.
     *
     * @param dataUpdater is removing data updater.
     */
    void removeDataUpdater(DataUpdater dataUpdater);
    
    
    /**
     * Response from target.
     *
     * @param data from target.
     */
    default void response(D data) {
    
    }
}
