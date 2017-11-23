package server.dao;

import lombok.Getter;
import lombok.Setter;
import server.entity.EntityI;

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
    @Setter
    private Class<D> entityClass;

    @Getter
    @PersistenceContext(unitName = "TestUnit")
    private EntityManager entityManager;

    /**
     * Add new data object.
     *
     * @param newEntity is adding data object.
     */
    public void add(EntityI newEntity) {
        entityManager.merge(newEntity);
    }

    /**
     * Delete data object.
     *
     * @param removableEntity is removing data object.
     */
    public void delete(EntityI removableEntity) {
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
    public void update(EntityI alterableEntity) {
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