package client.widgets.user;

import shared.data.DataSource;

/**
 * Interface for creating any forms.
 *
 * @param <D> is type of data.
 */
public interface Form<D> extends DataSource<D> {

    /**
     * Action of submit.
     */
    void submitAction();
}
