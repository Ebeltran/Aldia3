/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AplMenuDao;
import dao.AplMenuDaoImpl;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.AplMenu;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class AplMenuBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private List<AplMenu> aplMenus;  
    private AplMenu selectedAplMenu; 
    String msg;
    
    /**
     * Creates a new instance of aplMenuBean
     */
    public AplMenuBean() {
    }
    
    /**
     * Metodo para hacer reset al formulario
     */
    public void resetFormulario(){
        this.selectedAplMenu = new AplMenu();
    }
    
    public List<AplMenu> getAplMenus() {
        AplMenuDao aplMenuDao = new AplMenuDaoImpl();
        this.aplMenus = new ArrayList<>();
        this.aplMenus = aplMenuDao.findAll();
        return aplMenus;
    }

    public AplMenu getSelectedAplMenu() {
        return selectedAplMenu;
    }

    public void setSelectedAplMenu(AplMenu selectedAplMenu) {
        this.selectedAplMenu = selectedAplMenu;
    }
    
    public void btnCreateAplMenu(ActionEvent actionEvent) {
        AplMenuDao aplMenuDao = new AplMenuDaoImpl();
        
        if (aplMenuDao.create(this.selectedAplMenu)){
            msg = this.selectedAplMenu.getMensaje();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al Crear el registro de AplMenu";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }        
     }
    
    public void btnUpdateAplMenu(ActionEvent actionEvent) {
        AplMenuDao aplMenuDao = new AplMenuDaoImpl();
        
        if (this.selectedAplMenu.isLpermiso()) {
            this.selectedAplMenu.setSi_permiso("Si");
        } else {
            this.selectedAplMenu.setSi_permiso("No");
        }
        
        msg = aplMenuDao.update(this.selectedAplMenu);
        
        if (msg.contains("Registro Modificado y Actualizado Satisfactoriamente")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al Actualizar el registro de AplMenu";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void btnDesActivateAplMenu(ActionEvent actionEvent) {
        AplMenuDao aplMenuDao = new AplMenuDaoImpl();
        msg = aplMenuDao.desActivate(this.selectedAplMenu);
         
        if (msg.contains("Opcion inactivada correctamente")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al Desactivar el registro de AplMenu";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }    
    }
}
