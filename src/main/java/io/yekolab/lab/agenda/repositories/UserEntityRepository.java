/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.yekolab.lab.agenda.repositories;

import io.yekolab.lab.agenda.entities.UserEntity;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ricken BAZOLO
 */
public class UserEntityRepository extends BaseEntityRepository<UserEntity, Long> {

    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager entityManager() {
        return em;
    }

    public Optional<UserEntity> findByEmail(String email) {
        Objects.requireNonNull(email);
        return this.stream()
                .filter(u -> Objects.equals(u.getEmail(), email))
                .findFirst();
    }

    public Optional<UserEntity> findAllByCredential(String email,
            String password) {
        UserEntity entity = null;
        try {
            entity = em.createNamedQuery("UserEntity.findAllByCredential",
                    UserEntity.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
        }
        return Optional.ofNullable(entity);
    }

}
