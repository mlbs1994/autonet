/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="logoutBean")
@ViewScoped
public class LogoutBean implements Serializable
{    
    
    public String logout()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml";
        
        /*
        
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        if(session!=null)
        {
            session.invalidate();
        }
        
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        req.logout();
        
        return "login.xhtml?faces-redirect=true";
        
        */
    }
}
