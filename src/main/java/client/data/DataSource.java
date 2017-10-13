package client.data;

/**
 * Interface to send any data.
 *
 * @param <D> is a type of data.
 */
public interface DataSource<D> {
    
    /**
     * Response from target.
     *
     * @param index of data.
     * @param data from target.
     */
    default void response(int index, D data) {
    
    }
}
