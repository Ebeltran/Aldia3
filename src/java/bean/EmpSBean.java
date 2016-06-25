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
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.AplDefine;
import model.EmpS;
import util.MyUtil;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class EmpSBean implements Serializable {
    
    private static final long serialVersionUID = 7734069478966964431L;
    private List<EmpS> lsEmpSs;
    private EmpS empS = new EmpS();
    
    private List<SelectItem> listSelect;
    
    String msgEx = null;
    String msg = null;
    String query = null;
    FacesMessage message;
    
    public EmpSBean() {
//        EmpS empS = new EmpS();
        this.empS.setLjuridica(false);
        this.empS.setLpersona(false);
        this.empS.setN_nit_tip_identidad(0);
        this.empS.setCabeza_es(null);
        this.empS.setN_apl_sexo(0);
        this.empS.setN_apl_e_civil(0);
        this.empS.setN_apl_sangre_tipo(0);
    }
    
    /**
     * Metodo para hacer reset al formulario
     */
    public void resetFormulario(){
        this.empS = new EmpS();
    }
    
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
        
        if (empSDao.create(this.empS)) {
            msg = this.empS.getMensaje();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {    
            msg = "Error al Crear el registro de Nit";
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void btnAlistaProspecto() {

        query = empS.getIdenti();
        EmpSDao empSDao = new EmpSDaoImpl();
        
        msg = empSDao.findByEmpS(empS);
        
//        cia = lsCias.get(0);
    }
    
    public void handleChangeTipoSangre() {
        
        if (this.empS.getN_apl_sangre_tipo() != 0) {
            
        }
    }

    public void handleChangeContrato() {
        this.empS.setLintegral(false);
        if (this.empS.getN_con_tipo() >= 2) {
            this.empS.setLfechafin(true);
        } else {
            this.empS.setLfechafin(false);
        }
        
    }
    
    public void handleChangeTipoI() {
        if (this.empS.getN_nit_tip_identidad()!= 0) {
            if (this.empS.getN_nit_tip_identidad()!= 4) {
                this.empS.setLjuridica(false);
                this.empS.setLpersona(true);
            }
            this.empS.setIdenti(null);
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
     * Metodo para hacer Salir del modulo
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

    public void setLsEmpSs(List<EmpS> lsEmpSs) {
        this.lsEmpSs = lsEmpSs;
    }

    public List<EmpS> getLsEmpSs() {
        EmpSDao empSDao = new EmpSDaoImpl();
        this.lsEmpSs = new ArrayList<>();
        int contratar = 1;
        int contratado = 0;
        int rechazado= 0;
        this.lsEmpSs = empSDao.findEmpSAlista(contratar, contratado, rechazado);
        return lsEmpSs;
    }

    public EmpS getEmpS() {
        query = this.empS.getIdenti();
//        if (query != null) {
//            EmpSDao empSDao = new EmpSDaoImpl();
//            msg = empSDao.findByEmpS(empS);
//        }
        return empS;
    }

    public void setEmpS(EmpS empS) {
        this.empS = empS;
    }

//    public EmpS getSelectedEmpS() {
//        query = this.selectedEmpS.getIdenti();
//        return selectedEmpS;
//    }
    
    public List<SelectItem> getContratoDuracion() throws IOException {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findContratoTipo();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_con_tipo(), ls.getNom_con_tipo()));
        }
        return listSelect;
    }
    
    public List<SelectItem> onCambioPagoForma() {
        if (empS.getN_emp_pago_forma() == 1) {
            this.empS.setLpagoforma(true);
        } else {
            this.empS.setLpagoforma(false);
        }
        return listSelect;
    }
    
    public List<SelectItem> onCambioContratoTrabajo() {

        if (empS.getN_con_tipo() == 0) {
            AplDefineDao aplDefineDao = new AplDefineDaoImpl();
            this.listSelect = new ArrayList<>();
            List<AplDefine> lista = aplDefineDao.findContratoTipo();
            for (AplDefine ls : lista) {
                this.listSelect.add(new SelectItem(ls.getN_con_tipo(), ls.getNom_con_tipo()));
            }
        } else {
            AplDefineDao aplDefineDao = new AplDefineDaoImpl();
            this.listSelect = new ArrayList<>();
            List<AplDefine> lista = aplDefineDao.findContratoTrabajo(empS.getN_con_tipo());
            for (AplDefine ls : lista) {
                this.listSelect.add(new SelectItem(ls.getN_apl_con_trabajo(), ls.getNom_con_trabajo()));
            }
        }
        return listSelect;
    }
    
    public List<SelectItem> onClaseContrato() {
        if (empS.getN_con_tipo() != 0) {
            AplDefineDao aplDefineDao = new AplDefineDaoImpl();
            this.listSelect = new ArrayList<>();
            List<AplDefine> lista = aplDefineDao.findContratoTrabajoSelect(empS.getN_con_tipo());
            for (AplDefine ls : lista) {
                if (ls.isLsi_vence()) {
                    this.empS.setLfechafin(true);
                } else {
                    this.empS.setFecha_final(aplDefineDao.findByFechaHasta());
                    this.empS.setLfechafin(false);
                }
//                if (ls.isLsi_aux_tran()) {
//                    this.empS.setLauxtran(true);
//                } else {
//                    this.empS.setLauxtran(false);
//                }
//                if (ls.isLsi_salario_integral()) {
//                    this.empS.setLintegral(true);
//                } else {
//                    this.empS.setLintegral(false);
//                }
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
        return listSelect;
    }
            
    public List<SelectItem> getContratoClases() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findContratoTrabajo(empS.getN_con_tipo());
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_apl_con_trabajo(), ls.getNom_con_trabajo()));
        }
        return listSelect;
    }
    
    public void btnUpdateContratar(ActionEvent actionEvent) {
        EmpSDao empSDao = new EmpSDaoImpl();
        
        // Pilas
        
        boolean Ok = empSDao.updateContrato(empS);
        
        if (Ok ) {
            msg = "Actualizados permisos para";
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, this.empS.getRazon_social());
        } else {
            msg = "No se actualizado permisos para";
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, this.empS.getRazon_social());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}