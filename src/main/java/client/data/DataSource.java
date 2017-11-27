package client.data;

/**
 * Interface to send any data.
 *
 * @param <D> is a type of data.
 */
public interface DataSource<D> {

    /**
     * Send data.
     * @param data to send.
     */
    void sendData(D data);

    /**
     * Response from target.
     *
     * @param data from target.
     */
    default void response(D data) {
    }
}
