/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AplDefineDao;
import dao.AplDefineDaoImpl;
import dao.EmpSDao;
import dao.EmpSDaoImpl;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import model.AplDefine;
import model.EmpS;
import util.MyUtil;
import util.MyUtilFormat;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class AlistarContratoBean implements Serializable {

   private static final long serialVersionUID = 1L;
    private EmpS empS = new EmpS();
    private List<EmpS> empSs = new ArrayList<EmpS>();
    private ArrayList<SelectItem> listSelect;
    
    private List<SelectItem> selContratoTrabajo;
    private List<SelectItem> selTipoContrato;
    
    String msgEx = null;
    String msg = null;
    String msg_n_a;
    String query = null;
    FacesMessage message;
    Date date = new Date();
  
    public AlistarContratoBean() {
        empS = new EmpS();
        this.empS.setN_nit_tip_identidad(0);
        this.empS.setN_apl_ciudad(0);
        this.empS.setN_con_tipo(0);
        this.empS.setN_apl_con_trabajo(0);
        this.empS.setN_emp_pago_forma(0);
        this.empS.setLpagoforma(false);
        this.empS.setLpersona(false);
        this.empS.setLfechafin(false);
        this.empS.setLauxtran(false);
        this.empS.setLintegral(false);
        this.empS.setLauxtran(true);
        
    }
    
    /**
     * Metodo para realizar Consultar de prospectos en la tabala EMP_S 
     * que se encuentren con N_EMP_ESTADO_LABORAL_E = 1 equivalentes a 
     * CANDIDATO SELECCIONABLE para ser contratados
     * @param query
     * @return 
     */
    public List<EmpS> completePropecto(String query) {

        int i = 1;
        EmpSDao empsDao = new EmpSDaoImpl();
        query = query.toUpperCase();
        List<EmpS> quieries = empsDao.findAutoCompProspecto(query, 1);

        return quieries;
    }
    
    /**
     * 
     */
    public void buscarPropecto() {
        EmpSDao empSDao = new EmpSDaoImpl();

        msg = empSDao.findByEmpS(empS);

        if (!msg.contains(this.empS.getIdenti())) {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            this.empS.setN_nit_tip_identidad(0);
            this.empS.setIdenti(null);
            this.empS.setLpersona(false);
        } else {
            this.empS.setLpersona(true);
            
        }
    }
    
    /**
     * Trae los elementos del OneSelectMenu para 
     * Duracion del contrato
     * @return selDuraContrato
     */
    public List<SelectItem> getTipoContrato() {
        this.selTipoContrato = new ArrayList<>();
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        
        List<AplDefine> lista = aplDefineDao.findContratoTipo();
        selTipoContrato.clear();
        for (AplDefine ls : lista) {
            this.selTipoContrato.add(new SelectItem (ls.getN_con_tipo(), ls.getNom_con_tipo()));
        }
        return selTipoContrato;
    }

    /**
     * Trae los elementos del OneSelectMenu para
     * Tipos de Contrato padres
     * @return selContratoTrabajo
     */
    public List<SelectItem> getContratoTrabajo() {
        this.selContratoTrabajo = new ArrayList<>();
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        
        List<AplDefine> lista = aplDefineDao.findContratoTrabajo(empS.getN_con_tipo());
        selContratoTrabajo.clear();
        
        for (AplDefine ls : lista) {
            this.selContratoTrabajo.add(new SelectItem (ls.getN_apl_con_trabajo(), ls.getNom_con_trabajo()));
        }
        return selContratoTrabajo;
    }
    
    /**
     * Permite traer los elementos para los cambios de 
     * elementos del OneSelectMenu segun la
     * primera seleccion 
     */
    public void onCambioContratoTrabajo() {
        this.selContratoTrabajo = new ArrayList<>();
        if (empS.getN_con_tipo() != 0) {
            this.selContratoTrabajo = new ArrayList<>();
            AplDefineDao aplDefineDao = new AplDefineDaoImpl();
            
            List<AplDefine> lista = aplDefineDao.findContratoTrabajo(this.empS.getN_con_tipo());
            for (AplDefine ls : lista) {
                this.selContratoTrabajo.add(new SelectItem(ls.getN_apl_con_trabajo(), ls.getNom_con_trabajo()));
            }
        } else {
            this.selTipoContrato = new ArrayList<>();
            AplDefineDao aplDefineDao = new AplDefineDaoImpl();
            
            List<AplDefine> lista = aplDefineDao.findContratoTipo();
            for (AplDefine ls : lista) {
                this.selTipoContrato.add(new SelectItem(ls.getN_con_tipo(), ls.getNom_con_tipo()));
            }
        }        
    }
    
    /**
     * Actuliza los elemnto de acuerdo con el 
     * contrato seleccionado 
     */
    public void onClaseContrato() {
        if (empS.getN_apl_con_trabajo() != 0) {
            AplDefineDao aplDefineDao = new AplDefineDaoImpl();
            this.listSelect = new ArrayList<>();
            List<AplDefine> lista = aplDefineDao.findContratoTrabajoSelect(empS.getN_apl_con_trabajo());
            
            for (AplDefine ls : lista) {
                if (ls.isLsi_vence()) {
                    this.empS.setLfechafin(true);
                } else {
                    this.empS.setFecha_final(aplDefineDao.findByFechaHasta());
                    this.empS.setLfechafin(false);
                }
                if (ls.getSi_es_aux_tran().equalsIgnoreCase("Si")) {
                    this.empS.setSi_es_pago_aux_tran(true);
                    this.empS.setLauxtran(false);
                } else {
                    this.empS.setSi_es_pago_aux_tran(false);
                    this.empS.setLauxtran(false);
                }
                if (ls.getSi_es_salario_integral().equalsIgnoreCase("Si")) {
                    this.empS.setSi_es_salario_integral(true);
                } else {
                    this.empS.setSi_es_salario_integral(false);
                }
                if (ls.isLsi_pide_labor()) {
                    this.empS.setLlabor(true);
                } else {
                    this.empS.setLlabor(false);
                }
                if (ls.isLsi_pago_eps()) {
                    this.empS.setLsieps(true);
                } else {
                    this.empS.setLsieps(false);
                }
                if (ls.isLsi_pago_fdp()) {
                    this.empS.setLsifdp(true);
                } else {
                    this.empS.setLsifdp(false);
                }
                if (ls.isLsi_pago_fdc()) {
                    this.empS.setLsifdc(true);
                } else {
                    this.empS.setLsifdc(false);
                }
                if (ls.isLsi_pago_arl()) {
                    this.empS.setLsiarl(true);
                } else {
                    this.empS.setLsiarl(false);
                }
                if (ls.isLsi_pago_sena()) {
                    this.empS.setLsisena(true);
                } else {
                    this.empS.setLsisena(false);
                }
                if (ls.isLsi_pago_icbf()) {
                    this.empS.setLsiicbf(true);
                } else {
                    this.empS.setLsiicbf(false);
                }
                if (ls.isLsi_pago_ccf()) {
                    this.empS.setLsiccf(true);
                } else {
                    this.empS.setLsiccf(false);
                }

            }
            
        }
    }
        
    public void btnContratar(ActionEvent actionEvent) {
        EmpSDao empSDao = new EmpSDaoImpl();
        int resultado;
    
        resultado = this.empS.getCiudad_depto_contrata().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_ciudad_contrata(Integer.parseInt(this.empS.getCiudad_depto_contrata().substring(resultado + 7)));
        }
        
        resultado = this.empS.getCiudad_depto_firma().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_ciudad_firma(Integer.parseInt(this.empS.getCiudad_depto_firma().substring(resultado + 7)));
        }
        
        resultado = this.empS.getCiudad_depto_trabaja().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_ciudad_trabaja(Integer.parseInt(this.empS.getCiudad_depto_trabaja().substring(resultado + 7)));
        }
        
        resultado = this.empS.getNom_cargo_aspira_id().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_cargo(Integer.parseInt(this.empS.getNom_cargo_aspira_id().substring(resultado + 7)));
        }
        
        resultado = this.empS.getNom_cen_costo_id().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_cen_costo(Integer.parseInt(this.empS.getNom_cen_costo_id().substring(resultado + 7)));
        }

        this.empS.setVr_salario(Double.parseDouble(MyUtilFormat.formatDelete(this.empS.getSalario())));
        
        this.empS.setFecha_control(util.ConversionUtil.getTimestamp());
        
        if (this.empS.getN_emp_pago_forma() != 1) {
            this.empS.setIdenti_banco("");
            this.empS.setBan_sucursal("");
            this.empS.setN_ban_cuenta_tipo(0);
            this.empS.setCuenta_cta("");
        }
        
        msg = empSDao.contrataProspecto(this.empS);
        
        msg_n_a = new StringBuilder().append("para").append(this.empS.getApellidos_nombres()).append(" Identificacion: ").append(MyUtilFormat.formatOutput(this.empS.getIdenti())).toString();
        if (msg.contains("Ha sido contratado Satisfactoriamente con")) {
        
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, new StringBuilder().append(msg).append(" para").toString(), msg_n_a);
            
            empS = new EmpS();
            
        } else {
            
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al registrar el registro para", msg_n_a);
            
        }
        
        FacesContext.getCurrentInstance().addMessage(null, message);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        
    }
        
    /**
     * Metodo para seleccionar Boton Para Guardar prospecto
     * @param actionEvent 
     */
    public void btnUpdatePropecto(ActionEvent actionEvent) {
        EmpSDao empSDao = new EmpSDaoImpl();
        int resultado;
        
        resultado = this.empS.getCiudad_depto_contrata().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_ciudad_contrata(Integer.parseInt(this.empS.getCiudad_depto_contrata().substring(resultado + 7)));
        }
        
        resultado = this.empS.getCiudad_depto_firma().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_ciudad_firma(Integer.parseInt(this.empS.getCiudad_depto_firma().substring(resultado + 7)));
        }
        
        resultado = this.empS.getCiudad_depto_trabaja().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_ciudad_trabaja(Integer.parseInt(this.empS.getCiudad_depto_trabaja().substring(resultado + 7)));
        }
        
        resultado = this.empS.getNom_cargo().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empS.setN_cargo(Integer.parseInt(this.empS.getNom_cargo().substring(resultado + 7)));
        }
        this.empS.setN_cargo_aspira(Integer.parseInt(this.empS.getNom_cargo().substring(resultado + 7)));
        if (resultado > 0 ) {
            resultado = this.empS.getNom_cen_costo().indexOf(" ID => ");
        }
        this.empS.setN_cen_costo(Integer.parseInt(this.empS.getNom_cen_costo().substring(resultado + 7)));
        
        this.empS.setFec_desde(util.ConversionUtil.getTimestamp());
        this.empS.setFec_hasta(util.ConversionUtil.getTimestamp());
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
        
        if (this.empS.getSi_es_pago_aux_tran()) {
            this.empS.setSi_pago_aux_tran("Si");
        } else {
            this.empS.setSi_pago_aux_tran("No");
        }
        if (this.empS.getSi_es_salario_integral()) {
            this.empS.setSi_salario_integral("Si");
        } else {
            this.empS.setSi_salario_integral("No");
        }
        
        this.empS.setVr_salario(Double.parseDouble(MyUtilFormat.formatDelete(this.empS.getSalario())));
        
        msg = empSDao.update(this.empS);
        
        if (msg.contains("Registro Modificado y Actualizado Satisfactoriamente")) {
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg + " para", 
                    this.empS.getApellidos_nombres() + " Identificacion: "+  MyUtilFormat.formatOutput(this.empS.getIdenti()));
            
            empS = new EmpS();
            
        } else {
            
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al registrar el registro para", 
                    this.empS.getApellidos_nombres() + " Identificacion: "+  MyUtilFormat.formatOutput(this.empS.getIdenti()));
            
        }
        
        
        FacesContext.getCurrentInstance().addMessage(null, message);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        
    }
    
    /**
     * Cambio de forma de Pago
     */
    public void onCambioPagoForma() {
        if (empS.getN_emp_pago_forma() == 1) {
            this.empS.setLpagoforma(true);
        } else {
            this.empS.setLpagoforma(false);
            this.empS.setIdenti_banco("");
            this.empS.setBan_sucursal("");
            this.empS.setN_ban_cuenta_tipo(0);
            this.empS.setCuenta_cta("");
           
        }
    }
    
    /**
     * Metodo para el boton de Salir del modulo
     */
    public void resetFinalizar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        empS = new EmpS();
        this.empS.setLauxtran(true);
        
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
    public void resetFormulario() {
        this.empS = new EmpS();
    }

    public EmpS getEmpS() {
        return empS;
    }

    public void setEmpS(EmpS empS) {
        this.empS = empS;
    }

    public List<EmpS> getEmpSs() {
        return empSs;
    }

    public void setEmpSs(List<EmpS> empSs) {
        this.empSs = empSs;
    }

}
