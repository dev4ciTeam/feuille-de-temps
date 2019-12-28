/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.yekolab.lab.agenda.services;

import io.yekolab.lab.agenda.entities.UserEntity;
import io.yekolab.lab.agenda.repositories.UserEntityRepository;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ricken BAZOLO
 */
@Named
public class UserEntityService {
    
    @Inject
    UserEntityRepository userEntityRepository;

    public UserEntityService() {
    }
    
    public UserEntity login(String email, String password){
        return userEntityRepository
                .findAllByCredential(email, password)
                .orElse((new UserEntity()));
    }
}
