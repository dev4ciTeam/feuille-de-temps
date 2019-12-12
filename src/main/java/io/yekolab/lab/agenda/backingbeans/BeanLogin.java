package io.yekolab.lab.agenda.backingbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ricken BAZOLO
 */
@Named
@RequestScoped
public class BeanLogin {
    private String email;
    private String password;

    public BeanLogin() {
    }
    
    public String login(){
        System.out.println("Email: "+this.email);
        System.out.println("Password: "+this.password);
        return "admin/dashboard.xhtml";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
