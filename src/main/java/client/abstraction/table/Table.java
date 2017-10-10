package client.abstraction.table;

import client.abstraction.ObjectOperator;

/**
 * Interface for creating any tables.
 *
 * @param <O> type of object.
 */
public interface Table<O> extends ObjectOperator<O> {
    
    /**
     * Send the selected object of table somewhere.
     *
     * @param object is a selected object.
     */
    void sendSelectedObject(O object);
    
}
