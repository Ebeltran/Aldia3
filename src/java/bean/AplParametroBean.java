/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AplParametroDao;
import dao.AplParametroDaoImpl;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import model.AplParametro;

/**
 *
 * <ui:include src="readAusencias.xhtml" />
 *               <ui:include src="insertAusencias.xhtml" />                     
 *               <ui:include src="updateAusencias.xhtml" />  
 * 
 * 
 * @author ebeltran
 */
@ManagedBean
@SessionScoped
public class AplParametroBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<AplParametro> aplParametros; 
    private AplParametro aplParametro; 
    
    String msgEx = null;
    String msg;
    FacesMessage message;  

    public AplParametroBean() {

    }
    
    /**
     * Metodo para hacer reset al formulario
     */
    public void resetFormulario() {
        this.aplParametro = new AplParametro();
    }

    public List<AplParametro> getAplParametros() {
        AplParametroDao aplParametroDao = new AplParametroDaoImpl();
        this.aplParametros = new ArrayList<>();
        this.aplParametros = aplParametroDao.findAll();        
        return aplParametros;
    }

    public AplParametro getAplParametro() {
        return aplParametro;
    }

    public void setAplParametro(AplParametro aplParametro) {
        this.aplParametro = aplParametro;
    }

    public void setAplParametros(List<AplParametro> aplParametros) {
        this.aplParametros = aplParametros;
    }

    public void btnCreateAplParametro(ActionEvent actionEvent) throws MessagingException {
        AplParametroDao aplParametroDao = new AplParametroDaoImpl();
        
        if (aplParametroDao.create(this.aplParametro)){
            msg = this.aplParametro.getMensaje();
           
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            msg = "Error al Crear el registro de AplParametro";
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void btnUpdateAplParametro(ActionEvent actionEvent) {
        AplParametroDao aplParametroDao = new AplParametroDaoImpl();
    
        msg = aplParametroDao.update(this.aplParametro);
        if (msg.contains("Registro Modificado y Actualizado Satisfactoriamente")) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
}
