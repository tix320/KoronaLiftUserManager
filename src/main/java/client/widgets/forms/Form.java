package client.widgets.forms;

import client.dataUpdaters.DataSource;

/**
 * Interface for creating any forms.
 */
public interface Form<D> extends DataSource<D> {
    
    /**
     * Action of submit.
     */
    void submitAction();
}
