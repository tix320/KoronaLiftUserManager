package client.widgets.custom;

/**
 * Functional interface for object processing and returning any object.
 *
 * @param <P> is type of processed object.
 * @param <R> is type of return value.
 */
@FunctionalInterface
public interface Analyzer<P, R> {

    /**
     * Get any value.
     *
     * @param param is input object.
     * @return the function result.
     */
    R getValue(P param);
}
