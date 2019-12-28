/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.yekolab.lab.agenda.backingbeans;

import io.yekolab.lab.agenda.interceptor.UserSession;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@RequestScoped
public class BeanAdminDashboard {
    @Inject
    UserSession session;
    
}
