/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.NitDao;
import dao.NitDaoImpl;
import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


import model.Nit;
import org.primefaces.context.RequestContext;
import util.MyD_V_Dian;
import util.MyUtil;


/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class NitBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Nit nit;
    private List<Nit> lsNits = new ArrayList<Nit>(); 
    private List<String> lsChekNit = new ArrayList<String>();
    
    private String[] chekNit;
    String msg = null;
    String msgEx = null;
    FacesMessage message;
    
    /**
     * Creates a new instance of nitBean
     */
    public NitBean() {
        this.nit = new Nit();
        this.nit.setLjuridica(false);
        this.nit.setLpersona(false);
        this.nit.setSi_auto_rf("No");
        this.nit.setSi_activo("Si");
        this.nit.setNit_es(null);
        this.nit.setN_nit_tip_identidad(0);
        this.nit.setN_nit_cla_sociedad(0);
        this.nit.setN_nit_tip_contribuyente(0);
        this.nit.setN_nit_digni(0);
        this.nit.setN_apl_sexo(0);
        this.nit.setN_apl_e_civil(0);
        this.nit.setN_apl_sangre_tipo(0);
    }
    
    /**
     * Implementa los cambios que se suceden en el NIT 
     * por los tipos de documento
     * 4 NIT los demas para personas no juridicas
     * 
     */
    public void handleChangeTipoI() {
        FacesContext contex = FacesContext.getCurrentInstance();
        if (this.nit.getN_nit_tip_identidad()!= 0) {
            if (this.nit.getN_nit_tip_identidad()== 4) {
                this.nit.setLjuridica(true);
                this.nit.setLpersona(false);
            } else if (this.nit.getN_nit_tip_identidad()!= 0) {
                this.nit.setLjuridica(false);
                this.nit.setLpersona(true);
            }
            this.nit.setIdenti(null);
            try {
                contex.getExternalContext().redirect(MyUtil.baseUrl() + "app/master/nits.xhtml");
            } catch (IOException ex) {
                msgEx = ex.getMessage();
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            }
        }
    }
    
    /**
     * Implementa los cambios que se suceden en la Autoretencion del NIT 
     */
    public void handleChangeAutoRete() {
        if (this.nit.isSi_es_auto_rf() ) {
            this.nit.setSi_auto_rf("Si");
        } else {
            this.nit.setSi_auto_rf("No");
        }
            
    }
    
    /**
     * Implementa los cambios que se suceden en la las categorias del NIT
     * Cliente, Tercero, Banco o Tercero 
     */
    public void handleChangeNitEs() {
        for (String ls : this.nit.getNit_es()) {
            if        (ls.contains("CLIENTE")) {
                this.nit.setSi_es_cli(true);
            } else if (ls.contains("TERCERO")) {
                this.nit.setSi_es_ter(true);
            } else if (ls.contains("EMPLEADO")) {
                this.nit.setSi_es_emp(true);
            } else if (ls.contains("BANCO")) {
                this.nit.setSi_es_ban(true);
            }
        }
    }
   
    /**
     * Implementa los cambios en NIT
     */
    public void handleChangeNit() {
        if (this.nit.getIdenti() != null) {
            FacesContext contex = FacesContext.getCurrentInstance();
            String query = nit.getIdenti();
            NitDao nitDao = new NitDaoImpl();
            Nit nit = new Nit();
            
            nit = nitDao.findByNit(query);

            if (!nit.getMensaje().equals("Identificacion no existe en la DB")) {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                this.nit.setN_nit_tip_identidad(0);
                this.nit.setIdenti(null);
                this.nit.setD_v(null);
                this.nit.setLjuridica(false);
                this.nit.setLpersona(false);
                this.nit.setSi_es_cli(false);
                this.nit.setSi_es_ter(false);
                this.nit.setSi_es_emp(false);
                this.nit.setSi_es_ban(false);
                this.nit.setNit_es(null);
                try {
                    contex.getExternalContext().redirect(MyUtil.baseUrl() + "app/master/nits.xhtml");
                } catch (IOException ex) {
                    msgEx = ex.getMessage();
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                }
            }
        }
    }
    
    
    public List<String> buscaNit (String query) {
        NitDao nitDao = new NitDaoImpl();
        this.lsNits = new ArrayList<>();
        List<Nit> lista = nitDao.findAutoCompRazonSocial(query);
        List<String> results = new ArrayList<>();
        for (Nit m : lista) {
            results.add("Nit: " + m.getIdenti() + " Razon Social " + m.getRazon_social());
        }
        return results;
    }
    
    public void handleChangeDV() {
    
        if (this.nit.getD_v() != null) {
            FacesContext contex = FacesContext.getCurrentInstance();
            String cD_v = nit.getD_v();
            String cNit = String.format("%015d", Integer.parseInt(nit.getIdenti()));
            
            String nD_v = MyD_V_Dian.calculoDigitoVerificacion(cNit);
            
            if (!cD_v.equals(nD_v)) {
                this.nit.setD_v(null);
                msg = "Digito de Verificacion para Numero de Documento "
                       + this.nit.getIdenti() + " No es Valido";
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                try {
                    contex.getExternalContext().redirect(MyUtil.baseUrl() + "app/master/nits.xhtml");
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
     * Boton para crear nuevo Nit
     */
    public void btnCreateNit() {
        NitDao nitDao = new NitDaoImpl();
        
        this.nit.setSi_es_cli(false);
        this.nit.setSi_es_ter(false);
        this.nit.setSi_es_emp(false);
        this.nit.setSi_es_ban(false);
        this.nit.setSi_es_ter(false);
        this.nit.setSi_es_ban(false);
        this.nit.setSi_es_auto_rf(false);
        
        for (String ls : this.nit.getNit_es()) {
            if        (ls.contains("CLIENTE")) {
                this.nit.setSi_es_cli(true);
            } else if (ls.contains("TERCERO")) {
                this.nit.setSi_es_ter(true);
            } else if (ls.contains("EMPLEADO")) {
                this.nit.setSi_es_emp(true);
            } else if (ls.contains("BANCO")) {
                this.nit.setSi_es_ban(true);
            }
        }
        
        if (nitDao.create(this.nit)) {
            msg = this.nit.getMensaje();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {    
            msg = "Error al Crear el registro de Nit";
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
    }
    
    /**
     * Para obtener el resultado de la consulta de autocompletar
     * @param query
     * @return 
     */
    public List<Nit> completeNit(String query) {

        NitDao nitDao = new NitDaoImpl();
        List<Nit> quieries = nitDao.findAutoCompRazonSocial(query);

        return quieries;
    }
    
    /**
     * Metodo para hacer Salir del modulo
     */
    public void resetFinalizar() {
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            contex.getExternalContext().redirect(MyUtil.baseUrl() + "app/inicio.xhtml");
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
        FacesContext contex = FacesContext.getCurrentInstance();
        this.nit = new Nit();
        this.nit.setN_nit_tip_identidad(0);
        this.nit.setIdenti(null);
        this.nit.setD_v(null);
        this.nit.setLjuridica(false);
        this.nit.setLpersona(false);
        this.nit.setSi_es_cli(false);
        this.nit.setSi_es_ter(false);
        this.nit.setSi_es_emp(false);
        this.nit.setSi_es_ban(false);
        this.nit.setNit_es(null);
        try {
            
            RequestContext.getCurrentInstance().reset("form:panel");
            contex.getExternalContext().redirect(MyUtil.baseUrl() + "app/master/nits.xhtml");
        } catch (IOException ex) {
            msgEx = ex.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    public void traeNit() {
        ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        
        this.nit.setLjuridica(true);
        
        try {
            contex.redirect(MyUtil.baseUrl() + "app/master/consultaNits.xhtml");
        } catch (IOException ex) {
            msgEx = ex.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    public Nit getNit() {
        return nit;
    }

    public void setNit(Nit nit) {
        this.nit = nit;
    }

    public List<Nit> getLsNits() {
        NitDao nitDao = new NitDaoImpl();
        this.lsNits = new ArrayList<>();
        this.lsNits = nitDao.findAll();
        return lsNits;
    }

    public void setLsNits(List<Nit> lsNits) {
        this.lsNits = lsNits;
    }

    public List<String> getLsChekNit() {
        return lsChekNit;
    }

    public void setLsChekNit(List<String> lsChekNit) {
        this.lsChekNit = lsChekNit;
    }

    public String[] getChekNit() {
        return chekNit;
    }

    public void setChekNit(String[] chekNit) {
        this.chekNit = chekNit;
    }

}