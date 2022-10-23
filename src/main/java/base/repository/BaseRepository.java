package base.repository;


import base.entity.BaseEntity;
import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<E extends BaseEntity> {
    E save (E e);

    E update (E e);

    void delete (E e);

    E findById (Long id);

    List<E> findAll();

    boolean isExistsById(Long id);

    Long countAll();

    EntityManager getEntityManager();
}