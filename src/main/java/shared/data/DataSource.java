package shared.data;

/**
 * Interface to send any data.
 *
 * @param <D> is a type of data.
 */
public interface DataSource<D> {

    /**
     * Response from target.
     *
     * @param data from target.
     */
    default void response(D data) {

    }
}
