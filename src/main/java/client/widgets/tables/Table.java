package client.widgets.tables;

import client.dataUpdaters.DataObserver;
import client.objects.User;

/**
 * Interface for creating any tables.
 */
public interface Table extends DataObserver {
    
    /**
     * Update table data.
     *
     * @param user is a new data owner.
     * @param updateType is a update type.
     */
    void updateTableData(User user, UpdateType updateType);
}
