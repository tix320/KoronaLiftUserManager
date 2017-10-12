package client.objects;

/**
 * Operator for manipulating with objects.
 *
 * @param <O> is a type of Object.
 */
public interface ObjectOperator<O> {
    
    /**
     * Send actual data to observers.
     *
     * @param newObject are data owner.
     */
    void addNewObject(O newObject);
    
    /**
     * Send actual data to observers.
     *
     * @param oldObject is removing object.
     * @param newObject is new object.
     */
    void editThisObject(O oldObject, O newObject);
    
    /**
     * Send actual data to observers.
     *
     * @param object is removing object.
     */
    void removeThisObject(O object);
}
