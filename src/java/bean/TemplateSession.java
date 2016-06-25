/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.AplOperador;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@javax.faces.bean.ViewScoped
public class TemplateSession implements Serializable {

    private static final long serialVersionUID = 4061193628238098294L;
    
    public void checkSession() {
        FacesContext fContext = FacesContext.getCurrentInstance();
        try {
            AplOperador aplOperador = (AplOperador) fContext.getExternalContext().getSessionMap().get("operador");
            if (aplOperador  == null) {
                fContext.getExternalContext().redirect("./../error.xhtml");
            } else {
            }
        } catch (Exception e) {
            // log para guardar registro de error
            
        }
    }
}
