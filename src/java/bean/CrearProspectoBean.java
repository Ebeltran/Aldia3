/**
 * 
 */
package bean;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.EmpSDao;
import dao.EmpSDaoImpl;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import model.EmpS;
import util.MyUtil;
import util.MyUtilFormat;

/**
 * @author ebeltran
 *
 */
@ManagedBean
@ViewScoped
public class CrearProspectoBean implements Serializable {
	
    private static final long serialVersionUID = 1L;
    private EmpS empS = new EmpS();
    private List<EmpS> empSs  = new ArrayList<EmpS>();
    
    String msgEx = null;
    String msg = null;
    String query = null;
    FacesMessage message;
    
    Date date = new Date();
    
    public CrearProspectoBean() {
        this.empS.setLjuridica(false);
        this.empS.setLpersona(false);
        this.empS.setN_nit_tip_identidad(0);
        this.empS.setCabeza_es(null);
        this.empS.setSi_es_cabeza_familia(false);
        
        this.empS.setSi_es_situacion_militar(false);
        this.empS.setSi_es_tel_aux(false);
        this.empS.setSi_es_fax(false);
        this.empS.setSi_es_e_mail_a(false);
        this.empS.setSi_es_pagina_web(false);

        this.empS.setTel_aux("");
        this.empS.setFax("");
        this.empS.setE_mail_a("");
        this.empS.setPagina_web("");       
        
        this.empS.setN_apl_sexo(0);
        this.empS.setN_apl_e_civil(0);
        this.empS.setN_apl_sangre_tipo(0);
        this.empS.setN_apl_ciudad(0);
        this.empS.setN_ciudad_nace(0);
        this.empS.setN_cargo_aspira(0);
        this.empS.setVr_salario_aspira(0);
        
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
        int resultado;
        
        resultado = this.empS.getCiudad_depto().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_apl_ciudad(Integer.parseInt(this.empS.getCiudad_depto().substring(resultado + 7)));
        }
        
        resultado = this.empS.getNom_cargo_aspira().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_cargo_aspira(Integer.parseInt(this.empS.getNom_cargo_aspira().substring(resultado + 7)));
            this.empS.setN_cargo(Integer.parseInt(this.empS.getNom_cargo_aspira().substring(resultado + 7)));
        }
        resultado = this.empS.getNom_cen_costo().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_cen_costo(Integer.parseInt(this.empS.getNom_cen_costo().substring(resultado + 7)));
        }
        
        resultado = this.empS.getCiudad_depto_nace().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_ciudad_nace(Integer.parseInt(this.empS.getCiudad_depto_nace().substring(resultado + 7)));
        }
        
        if (this.empS.getN_apl_sexo()  == 1) {
            this.empS.setSi_es_cabeza_familia(false);
        }
        
        this.empS.setN_emp_estado_laboral(1);         // N_ESTADO_EMP ENTERO
        this.empS.setN_pago_periodo(1);               // N_APL_PAGO_PERIODO ENTERO,
        this.empS.setSi_es_contratar(true);           // SI_CONTRATAR NO_O_SI
        this.empS.setSi_es_contratado(false);         // SI_CONTRATADO NO_O_SI
        this.empS.setSi_es_rechazado(false);          // SI_RECHAZADO NO_O_SI
        this.empS.setN_emp_pago_forma(0);             // N_EMP_PAGO_FORMA ENTERO
        this.empS.setIdenti_banco("");                // IDENTI_BANCO NIT_DEFI
        this.empS.setId_ban_cuenta(0);                // ID_BAN_CUENTA ENTERO
        this.empS.setN_ban_cuenta_tipo(0);            // N_BAN_CUENTA_TIPO ENTERO
        this.empS.setCuenta_cta("");                  // CUENTA_CTA CADENA_30
        this.empS.setBan_sucursal("");                // BAN_SUC CADENA_60
        this.empS.setIdenti_eps("");                  // IDENTI_EPS NIT_DEFI
        this.empS.setIdenti_fdp("");                  // IDENTI_FDP NIT_DEFI
        this.empS.setIdenti_fdc("");                  // IDENTI_FDC NIT_DEFI
        
        if (this.empS.getLongitud() == null) {
            this.empS.setLongitud(MyUtilFormat.int2Double(0));
        }
        if (this.empS.getLatitud() == null) {
            this.empS.setLatitud(MyUtilFormat.int2Double(0));
        }
            
        this.empS.setIdenti(MyUtilFormat.formatDelete(this.empS.getIdenti_con()));
        this.empS.setVr_salario_aspira(Double.parseDouble(MyUtilFormat.formatDelete(this.empS.getSalario_aspira())));
        this.empS.setVr_salario(Double.parseDouble(MyUtilFormat.formatDelete(this.empS.getSalario_aspira())));
        
        if (empSDao.create(this.empS)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, this.empS.getMensaje(),
                    this.empS.getApellido_1() + " " + this.empS.getApellido_2()
                    + " " + this.empS.getNombre_1() + " " + this.empS.getNombre_2()
                    + " Identificacion: " + MyUtilFormat.formatOutput(this.empS.getIdenti()));

            this.empS.setLpersona(false);
            this.empS.setApellido_1("");
            this.empS.setApellido_2("");
            this.empS.setNombre_1("");
            this.empS.setNombre_2("");
            
        } else {
            
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al mofificar el registro para", 
                    this.empS.getApellido_1() + " " + this.empS.getApellido_2()
                    + " " + this.empS.getNombre_1() + " " + this.empS.getNombre_2()
                    + " Identificacion: " + MyUtilFormat.formatOutput(this.empS.getIdenti()));
            
        }
        
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
    
    /**
     * Metodo para seleccionar Boton Para Guardar prospecto
     * @param actionEvent 
     */
    public void btnUpdateProspecto(ActionEvent actionEvent) {
        EmpSDao empSDao = new EmpSDaoImpl();
        
        this.empS.setFec_desde(util.ConversionUtil.getTimestamp());
        this.empS.setFec_hasta(util.ConversionUtil.getTimestamp());
        this.empS.setVr_salario_aspira(Double.parseDouble(MyUtilFormat.formatDelete(this.empS.getSalario_aspira())));
        this.empS.setFecha_actual(util.ConversionUtil.getTimestamp());
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
//            this.empS.setSi_pago_aux_tran("No");
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
    
    public void handleZona1() {
        
        this.empS.setSi_es_tel_aux(true);
                
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
        query = query.toUpperCase();
        
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
        query = query.toUpperCase();
        
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
        query = query.toUpperCase();
        
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
        query = query.toUpperCase();
        
        List<EmpS> quieries = empSDao.findAutoCompCentroCosto(query);
        return quieries;
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
     * Metodo para hacer reset al formulario
     */
    public void resetFormulario(){
        this.empS = new EmpS();
    }
    
    public EmpS getEmpS() {
        return empS;
    }

    public void setEmpS(EmpS empS) {
        this.empS = empS;
    }

}
