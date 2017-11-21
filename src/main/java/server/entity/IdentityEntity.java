package server.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class for identity entities.
 */
@MappedSuperclass
public class IdentityEntity implements EntityI<Integer> {

    /** Unique number of entity. */
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) FIXME : bug
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
