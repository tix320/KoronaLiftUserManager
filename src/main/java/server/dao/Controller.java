package server.dao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import server.entity.IsEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Data access object to interact with the database.
 *
 * @param <D> is a type of data.
 */
@Transactional
public abstract class Controller<D> {

    /** Class of entity. */
    @Setter(value = AccessLevel.PROTECTED)
    private Class<D> entityClass;

    /** Instance of entity manager. */
    @Getter
    @PersistenceContext(unitName = "TestUnit")
    private EntityManager entityManager;

    /**
     * Add new data object.
     *
     * @param newEntity is adding data object.
     */
    public void add(IsEntity newEntity) {
        entityManager.merge(newEntity);
    }

    /**
     * Delete data object.
     *
     * @param removableEntity is removing data object.
     */
    public void delete(IsEntity removableEntity) {
        D entity = entityManager.find(entityClass, removableEntity.getId());
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    /**
     * Update data object.
     *
     * @param alterableEntity is updating data object.
     */
    public void update(IsEntity alterableEntity) {
        if (entityManager.find(entityClass, alterableEntity.getId()) != null) {
            entityManager.merge(alterableEntity);
        }
    }

    /**
     * Get all data objects.
     *
     * @return list of data objects.
     */
    public abstract List<D> getAll();
}