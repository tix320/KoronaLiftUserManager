package client.data;

/**
 * Interface to send any data.
 *
 * @param <D> is a type of data.
 */
public interface DataSource<D> {

    /**
     * Send data.
     */
    void sendData();

    /**
     * Response from target.
     *
     * @param data from target.
     */
    default void response(D data) {
    }
}
