/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.yekolab.lab.agenda.interceptor;

import io.yekolab.lab.agenda.entities.UserEntity;
import java.io.Serializable;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@SessionScoped
public class UserSession implements Serializable{
    private UserEntity userEntity;

    public UserSession() {
    }
    
    public void putInSession(UserEntity userEntity){
        this.userEntity = userEntity;
    }
    
    public boolean isLogin(){
        return Objects.nonNull(this.userEntity);
    }
    
    public UserEntity getUser(){
        return this.userEntity;
    }
}
