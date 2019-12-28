package io.yekolab.lab.agenda.backingbeans;

import io.yekolab.lab.agenda.entities.UserEntity;
import io.yekolab.lab.agenda.interceptor.UserSession;
import io.yekolab.lab.agenda.services.UserEntityService;
import java.util.Objects;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
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
    
    @Inject
    private AlertBean alert;
    @Inject
    UserSession UserSession;
    @Inject
    UserEntityService userEntityService;

    public BeanLogin() {
    }
    
    public String login(){
        System.out.println("Email: "+this.email);
        System.out.println("Password: "+this.password);
        final UserEntity user = userEntityService
                .login(this.email, this.password);
        if (user.getId() > 0) {
            UserSession.putInSession(user);
            return "admin/dashboard.xhtml?faces-redirect=true";
        }
        alert.setRendered(true);
        alert.setColor("warning");
        alert.setMessage("Informations invalide email/password !");
        return "";
    }
    
    public void ajaxLogin(AjaxBehaviorEvent event){
        System.out.println("Email: "+this.email);
        System.out.println("Password: "+this.password);
        alert.setRendered(true);
        alert.setColor("warning");
        alert.setMessage("OK!");
       
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

    public AlertBean getAlert() {
        return alert;
    }

    public void setAlert(AlertBean alert) {
        this.alert = alert;
    }
    
    
}
