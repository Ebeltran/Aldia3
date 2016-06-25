package bean;


import dao.ConceptoPagoDao;
import dao.ConceptoPagoDaoImpl;
import dao.ContabilidadDao;
import dao.ContabilidadDaoImpl;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import model.ConceptoPago;
import model.Contabilidad;
import org.primefaces.event.SelectEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduar
 */
@ManagedBean
@ViewScoped
public class ConceptoPagoBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private ConceptoPago conceptoPago = new ConceptoPago();
    private List<ConceptoPago> lista = new ArrayList<>(); 
    
    private Contabilidad contabiliadDB = new Contabilidad();
    private Contabilidad contabiliadCR = new Contabilidad();
    
    private String msg;
    private FacesMessage message;
    
    public List<ConceptoPago> getLista() {
        ConceptoPagoDao conceptoPagosDao = new ConceptoPagoDaoImpl();
        this.lista = new ArrayList<>();
        this.lista = conceptoPagosDao.findAll();
        return lista;
    }
    
    public List<Contabilidad> autoCompleteCuenta (String query) {
        
        ContabilidadDao contaDao = new ContabilidadDaoImpl();
        query = query.toUpperCase();
        List <Contabilidad> quieries = contaDao.findByContabilidad(query);
        return quieries;

    }
    
    public void onItemSelectDB(SelectEvent event) {
        this.conceptoPago.setCuenta_numero_db(this.contabiliadDB.getCuenta_numero());
        this.conceptoPago.setNom_apl_cta_base_db(this.contabiliadDB.getCuenta_nombre());
    }
    
    public void onItemSelectCR(SelectEvent event) {
        this.conceptoPago.setCuenta_numero_cr(this.contabiliadDB.getCuenta_numero());
        this.conceptoPago.setNom_apl_cta_base_cr(this.contabiliadCR.getCuenta_nombre());
    }
    
    public ConceptoPago getConceptoPago() {
        return conceptoPago;
    }
   
    public void btnCreateConceptoPago(ActionEvent actionEvent) throws MessagingException {    
        ConceptoPagoDao conceptoPagoDao = new ConceptoPagoDaoImpl();
        
        msg = conceptoPagoDao.create(conceptoPago);
    
    }

    public void btnUpdateConceptoPago(ActionEvent actionEvent) throws MessagingException {    
        
        ConceptoPagoDao conceptoPagoDao = new ConceptoPagoDaoImpl();
        
        msg = conceptoPagoDao.update(conceptoPago);
        
        if (msg.contains("Registro Modificado y Actualizado Satisfactoriamente")) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    
    }

    public Contabilidad getContabiliadDB() {
        this.conceptoPago.setN_apl_cta_base_db(this.contabiliadDB.getId());
        return contabiliadDB;
    }

    public Contabilidad getContabiliadCR() {
        this.conceptoPago.setN_apl_cta_base_cr(this.contabiliadDB.getId());
        return contabiliadCR;
    }

    public void setContabiliadDB(Contabilidad contabiliadDB) {
        this.contabiliadDB = contabiliadDB;
    }

    public void setContabiliadCR(Contabilidad contabiliadCR) {
        this.contabiliadCR = contabiliadCR;
    }

    public void setConceptoPago(ConceptoPago conceptoPago) {
        this.conceptoPago = conceptoPago;
    }

    public void setLista(List<ConceptoPago> lista) {
        this.lista = lista;
    }

    /**
     * Metodo para actualizar el formulario
     * recargado los objetos de autocompletar
     */
    public void updateFormulario() {
        ContabilidadDao contabilidadDao = new ContabilidadDaoImpl();
        this.contabiliadDB = contabilidadDao.findByCuentaConta(String.valueOf(this.conceptoPago.getN_apl_cta_base_db()));
        this.contabiliadCR = contabilidadDao.findByCuentaConta(String.valueOf(this.conceptoPago.getN_apl_cta_base_cr()));
    }
    /**
     * Metodo para hacer reset al formulario
     */
    public void resetFormulario() {
        
        this.conceptoPago = new ConceptoPago();
        this.conceptoPago.setLsi_aporte_arl(false);
        this.conceptoPago.setLsi_aporte_fdp(false);
        this.conceptoPago.setLsi_aporte_para(false);
        this.conceptoPago.setLsi_aporte_pos(false);
        this.conceptoPago.setLsi_auxilio_tra(false);
        this.conceptoPago.setLsi_cesantia(false);
        this.conceptoPago.setLsi_control_dia(false);
        this.conceptoPago.setLsi_cuenta_costo(false);
        this.conceptoPago.setLsi_interfaz(false);
        this.conceptoPago.setLsi_pago_cierre(false);
        this.conceptoPago.setLsi_presenta_can(false);
        this.conceptoPago.setLsi_puc_base_db(false);
        this.conceptoPago.setLsi_puc_base_cr(false);
        this.conceptoPago.setLsi_sal_basico(false);
        this.conceptoPago.setLsi_sal_integral(false);
        
    }

}