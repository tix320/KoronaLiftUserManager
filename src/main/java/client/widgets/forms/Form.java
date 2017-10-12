package client.widgets.forms;

/**
 * Interface for creating any forms.
 * Forms are support processing of sent information.
 *
 * @param <U> is a type of data updater.
 */
public interface Form<U> {
    
    /**
     * Add data updater, who will transfer the data.
     *
     * @param dataUpdater is adding data updater.
     */
    void registerDataUpdater(U dataUpdater);
    
    /**
     * Delete the data updater.
     *
     * @param dataUpdater is removing data updater.
     */
    void removeDataUpdater(U dataUpdater);
    
    /**
     * Action of submit.
     */
    void submitAction();
}
