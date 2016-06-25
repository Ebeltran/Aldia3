/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EmpSDao;
import dao.EmpSDaoImpl;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.EmpS;
import util.MyUtil;
import util.MyUtilFormat;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class AutoCompletarProspecto implements Serializable {

    private static final long serialVersionUID = 1L;
    private EmpS empS = new EmpS();
    private List<EmpS> empSs  = new ArrayList<>();
    
    String msgEx = null;
    String msg = null;
    String query = null;
    FacesMessage message;
    Date date = new Date();
    
//    EmpSDao empSDao = new EmpSDaoImpl();
    
    public AutoCompletarProspecto() {
        this.empS.setLjuridica(false);
        this.empS.setLpersona(false);
        this.empS.setN_nit_tip_identidad(0);
        this.empS.setCabeza_es(null);
        this.empS.setN_apl_sexo(0);
        this.empS.setN_apl_e_civil(0);
        this.empS.setN_apl_sangre_tipo(0);
        this.empS.setVr_salario_aspira(0);
        
    }
    
    /**
     * Metodo para hacer reset al formulario
     */
    public void resetFormulario(){
        this.empS = new EmpS();
    }

    public List<EmpS> getEmpSs() {
        EmpSDao empSDao = new EmpSDaoImpl();
        this.empSs = new ArrayList<>();
        int contratar = 1;
        int contratado = 0;
        int rechazado= 0;
        this.empSs = empSDao.findEmpSAlista(contratar, contratado, rechazado);
        
        return empSs;
    }

    public void setEmpSs(List<EmpS> empSs) {
        this.empSs = empSs;
    }
    
    /**
     * Boton para salvar informacion del EmpS: Prospecto
     */
    public void btnCreateEmpS() {
        EmpSDao empSDao = new EmpSDaoImpl();

        this.empS.setSi_es_cabeza_familia(false);
        
        for (String ls : this.empS.getCabeza_es()) {
            if        (ls.contains("ES CABEZA")) {
                this.empS.setSi_es_cabeza_familia(true);
            } else {
                this.empS.setSi_es_cabeza_familia(false);
            } 
        }
        this.empS.setN_emp_estado_laboral(1);       // N_ESTADO_EMP ENTERO
        this.empS.setN_pago_periodo(1);             // N_APL_PAGO_PERIODO ENTERO,
        this.empS.setSi_es_contratar(true);         // SI_CONTRATAR NO_O_SI
        this.empS.setSi_es_contratado(false);       // SI_CONTRATADO NO_O_SI
        this.empS.setSi_es_rechazado(false);        // SI_RECHAZADO NO_O_SI
//        this.empS.setSi_es_pago_aux_tran(true);     // SI_PAGO_A_TRANSPORTE SI_O_NO
        this.empS.setSi_es_salario_integral(false); // SI_SAL_INTEGRAL NO_O_SI
        this.empS.setProfesion("");                 // PROFESION CADENA_256
        this.empS.setN_emp_pago_forma(0);           // N_EMP_PAGO_FORMA ENTERO
        this.empS.setIdenti_banco("");              // IDENTI_BANCO NIT_DEFI
        this.empS.setId_ban_cuenta(0);              // ID_BAN_CUENTA ENTERO
        this.empS.setN_ban_cuenta_tipo(0);          // N_BAN_CUENTA_TIPO ENTERO
        this.empS.setCuenta_cta("");                // CUENTA_CTA CADENA_30
        this.empS.setBan_sucursal("");                   // BAN_SUC CADENA_60
        this.empS.setNo_estatura(0);                // NO_ESTATURA DINERO_2
        this.empS.setNo_peso(0);                    // NO_PESO DINERO_2
        this.empS.setObservacion("");               // OBSERVACION CADENA_2000
        this.empS.setIdenti_eps("");                // IDENTI_EPS NIT_DEFI
        this.empS.setIdenti_fdp("");                // IDENTI_FDP NIT_DEFI
        this.empS.setIdenti_fdc("");                // IDENTI_FDC NIT_DEFI
        this.empS.setVr_salario_aspira(Double.parseDouble(MyUtilFormat.formatDelete(this.empS.getSalario_aspira())));
        
        msg = this.empS.getApellido_1() + " "+ this.empS.getApellido_2() + " " +
              this.empS.getNombre_1() + " " + this.empS.getNombre_2() + " "+
              "Identificacion: " + this.empS.getIdenti_con();
        
        if (empSDao.create(this.empS)) {
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, this.empS.getMensaje(), msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {    
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Crear el registro de Nit", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    /**
     * Metodo para seleccionar Boton Para Guardar propspecto
     * @param actionEvent 
     */
    public void btnUpdateProspecto(ActionEvent actionEvent) {
        EmpSDao empSDao = new EmpSDaoImpl();
        
        this.empS.setFec_desde(util.ConversionUtil.getTimestamp());
        this.empS.setFec_hasta(util.ConversionUtil.getTimestamp());
        this.empS.setVr_salario_aspira(Double.parseDouble(MyUtilFormat.formatDelete(this.empS.getSalario_aspira())));
        this.empS.setFecha_control(util.ConversionUtil.getTimestamp());
        
        this.empS.setFecha_control(util.ConversionUtil.getTimestamp());
        if (this.empS.getSi_es_contratar()) {
            this.empS.setSi_contratar("Si");
        } else {
            this.empS.setSi_contratar("No");
        }
        if (this.empS.getSi_es_contratado()) {
            this.empS.setSi_contratado("Si");
        } else {
            this.empS.setSi_contratado("No");
        }
        if (this.empS.getSi_es_rechazado()) {
            this.empS.setSi_rechazado("Si");
        } else {
            this.empS.setSi_rechazado("No");
        }
        if (this.empS.getSi_es_cabeza_familia()) {
            this.empS.setSi_cabeza_familia("Si");
        } else {
            this.empS.setSi_cabeza_familia("No");
        }
//        if (this.empS.getSi_es_pago_aux_tran()) {
//            this.empS.setSi_pago_aux_tran("Si");
//        } else {
//            this.empS.setSi_cabeza_familia("No");
//        }
//        if (this.empS.getSi_es_salario_integral()) {
//            this.empS.setSi_salario_integral("Si");
//        } else {
//            this.empS.setSi_salario_integral("No");
//        }

        msg = empSDao.update(this.empS);
        
        if (msg.contains("Registro Modificado y Actualizado Satisfactoriamente")) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void handleChangeNit() {
        if (this.empS.getIdenti() != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            EmpSDao empSDao = new EmpSDaoImpl();
            
            msg = empSDao.findByEmpS(empS);

            if (!msg.equals("Identificacion no existe en la DB")) {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                this.empS.setN_nit_tip_identidad(0);
                this.empS.setIdenti(null);
                this.empS.setLjuridica(false);
                this.empS.setLpersona(false);
                try {
                    context.getExternalContext().redirect(MyUtil.baseUrl() + "app/master/crearProspecto.xhtml");
                } catch (IOException ex) {
                    msgEx = ex.getMessage();
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                }
            }
        }
    }
    
    /**
     * Metodo para el boton de Salir del modulo
     */
    public void resetFinalizar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect(MyUtil.baseUrl() + "app/inicio.xhtml");
        } catch (IOException ex) {
            msgEx = ex.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    /**
     * 
     */
    public void handleChangeTipoSangre() {
        
        if (this.empS.getN_apl_sangre_tipo() != 0) {
            
        }
    }
    
    /**
     * 
     */
    public void handleChangeContrato() {
        this.empS.setLintegral(false);
        if (this.empS.getN_con_tipo() >= 2) {
            this.empS.setLfechafin(true);
        } else {
            this.empS.setLfechafin(false);
        }
        
    }
    
    /**
     * Metodo para cambio de tipo de identidad Nit y Personas naturales
     */
    public void handleChangeTipoI() {
        if (this.empS.getN_nit_tip_identidad()!= 0) {
            if (this.empS.getN_nit_tip_identidad()!= 4) {
                this.empS.setLjuridica(false);
                this.empS.setLpersona(true);
            }
            this.empS.setIdenti(null);
        }
    }
    
    /**
     * Metodo para ajustar Cabeza de familia
     */
    public void handleChangeCabezaEs() {
        
        for (String ls : this.empS.getCabeza_es()) {
            if(ls.equals(1)) {
                this.empS.setSi_es_cabeza_familia(true);
            } else {
                this.empS.setSi_es_cabeza_familia(false);
            }
        }
    }
    
    /**
     * metodo generar autocompletar para ciudad direccion
     * @param query
     * @return 
     */
    public List<EmpS> completeCiudad(String query) {
        EmpSDao empSDao = new EmpSDaoImpl();
        
        List<EmpS> quieries = empSDao.findAutoCompCiudad(query);
        return quieries;
    }
    
    /**
     * metodo generar autocompletar para ciudad Nace
     * @param query
     * @return 
     */
    public List<EmpS> completeCiudadNace(String query) {
        EmpSDao empSDao = new EmpSDaoImpl();
        
        List<EmpS> quieries = empSDao.findAutoCompCiudadNace(query);
        return quieries;
    }

    /**
     * Para generar Autocompletar para Cargo
     * @param query
     * @return 
     */
    public List<EmpS> completeCargo(String query) {
        EmpSDao empSDao = new EmpSDaoImpl();
        
        List<EmpS> quieries = empSDao.findAutoCompCargo(query);
        return quieries;
    }  
    
    /**
     * Para generar Autocompletar para Centro de Trabajo
     * @param query
     * @return 
     */
    public List<EmpS> completeCCosto(String query) {
        EmpSDao empSDao = new EmpSDaoImpl();
        
        List<EmpS> quieries = empSDao.findAutoCompCentroCosto(query);
        return quieries;
    }  
    
    public EmpS getEmpS() {
        if (empS.getIdenti() == null) {
            // almacena valores en this de converter
            
        }
        return empS;
    }

    public void setEmpS(EmpS empS) {
        if (empS.getIdenti() == null) {
            // almacena valores en this de converter 
            
        }
        this.empS = empS;
    }
    
}
