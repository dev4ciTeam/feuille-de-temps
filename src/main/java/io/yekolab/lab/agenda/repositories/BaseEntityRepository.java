package io.yekolab.lab.agenda.repositories;

import io.yekolab.lab.agenda.entities.BaseEntity;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author ricken BAZOLO
 * @param <T> Entity  extends
 * @param <ID> Identity type
 */
public abstract class BaseEntityRepository<T extends BaseEntity, ID> {
    
    protected abstract EntityManager entityManager();
    
    private Class<T> entityClass(){
        ParameterizedType paramType = 
                (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) paramType.getActualTypeArguments()[0];
    }
    
    public List<T> findAll(){
        CriteriaBuilder cBuilder = this.entityManager()
                .getCriteriaBuilder();
        CriteriaQuery q = cBuilder.createQuery(entityClass());
        return entityManager().createQuery(q).getResultList();
    }
}