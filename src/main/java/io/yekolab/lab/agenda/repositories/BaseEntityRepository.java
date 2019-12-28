package io.yekolab.lab.agenda.repositories;

import io.yekolab.lab.agenda.entities.BaseEntity;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
        Root<T> rt = q.from(entityClass());
        return entityManager().createQuery(q).getResultList();
    }
    
    public Stream<T> stream(){
        CriteriaBuilder cBuilder = this.entityManager()
                .getCriteriaBuilder();
        CriteriaQuery q = cBuilder.createQuery(entityClass());
        Root<T> rt = q.from(entityClass());
        return entityManager().createQuery(q).getResultStream();
    }
    
    public T saveOrEdit(T entity){
        if (Objects.nonNull(entity.getId())) {
            entityManager().persist(entity);
            return entity;
        } else {
            return entityManager().merge(entity);
        }
    }
    
    public T findById(ID id){
        return entityManager().find(entityClass(), id);
    }
    
    public void remove(ID id){
        T _entity = findById(id);
        entityManager().remove(_entity);
    }
    
    public void delete(T entity){
        entity.setDeleted(false);
    }
    
    public Optional<T> findOptionalById(ID id){
        return Optional.ofNullable(findById(id));
    }
}