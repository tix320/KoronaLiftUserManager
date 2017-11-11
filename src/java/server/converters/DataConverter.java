package server.converters;

/**
 * Data converter interface to convert client-server objects.
 *
 * @param <D> is type of Dto.
 * @param <E> is type of entity.
 */
public interface DataConverter<D, E> {

    /**
     * Convert entity object to dto.
     *
     * @param e is entity object.
     * @return dto object.
     */
    D convertToDto(E e);

    /**
     * Convert dto to entity object.
     *
     * @param d is entity object.
     * @return entity object.
     */
    E convertToEntity(D d);
}
