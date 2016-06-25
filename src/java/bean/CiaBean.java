/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CiaDao;
import dao.CiaDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Cia;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class CiaBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Cia cia = new Cia(); 
    String msgEx = null;
    FacesMessage message;
    
    public CiaBean() {
        
    }

    public Cia getCia() {
        return cia;
    }

    public void setCia(Cia cia) {
        this.cia = cia;
    }

    public List<Cia> getLsCias() {
        CiaDao ciaDao = new CiaDaoImpl();
        new ArrayList<>();
        List<Cia> lsCias = ciaDao.findCia();
        
        return lsCias;
    }

    public void setLsCias(List<Cia> lsCias) {
    }

    public List<Cia> getLsCiaAgencias() {
        CiaDao ciaDao = new CiaDaoImpl();
        new ArrayList<>();
        List<Cia> lsCias = ciaDao.findCiaSucAll(1);
        
        return lsCias;
    }

    public void setLsCiaAgencias(List<Cia> lsCiaAgencias) {
    }

    public String getMsgEx() {
        return msgEx;
    }

    public void setMsgEx(String msgEx) {
        this.msgEx = msgEx;
    }

    public FacesMessage getMessage() {
        return message;
    }

    public void setMessage(FacesMessage message) {
        this.message = message;
    }


    /**
     * Metodo para hacer reset al formulario
     */
    public void resetFormulario() {
        this.cia = new Cia();
    }
    
}
