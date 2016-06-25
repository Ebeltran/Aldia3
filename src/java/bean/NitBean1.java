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
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.Nit;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import util.MyUtil;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class NitBean1 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Nit nit = new Nit(); 
    private List<Nit> lsNits = new ArrayList(); 
    private List<Nit> lstNits = new ArrayList();
    private List<SelectItem> listSelect;
    
    private String[] chekNit;
    String msg = null;
    String msgEx = null;
    FacesMessage message;
    
    private List<String> lsChekNit = new ArrayList<String>();
    
    /**
     * Creates a new instance of nitBean
     */
    public NitBean1() {
        FacesContext contex = FacesContext.getCurrentInstance();
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

    public Nit getNit() {
        return nit;
    }

    public List<Nit> getLsNits() {
        NitDao nitDao = new NitDaoImpl();
        this.lsNits = new ArrayList<>();
        this.lsNits = nitDao.findAll();
        return lsNits;
    }

    public List<Nit> getLstNits() {
        return lstNits;
    }

    public void setNit(Nit nit) {
        this.nit = nit;
    }

    public void setLsNits(List<Nit> lsNits) {
        this.lsNits = lsNits;
    }

    public void setLstNits(List<Nit> lstNits) {
        this.lstNits = lstNits;
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

    public List<SelectItem> completeText(String query) {
        NitDao nitDao = new NitDaoImpl();
        this.lsNits = new ArrayList<>();

        List<Nit> lista = nitDao.findAutoCompRazonSocial(query);        
        for (Nit ls :lista) {
           this.listSelect.add(new SelectItem(ls.getIdenti(), ls.getRazon_social()));
        }
       
        return listSelect;

    }
    
    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }
    
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
    
    public void handleChangeAutoRete() {
        if (this.nit.isSi_es_auto_rf() ) {
            
        }
    }
        
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
    
    public void handleChangeNit() {
        if (this.nit.getIdenti() != null) {
            FacesContext contex = FacesContext.getCurrentInstance();
            String query = nit.getIdenti();
            NitDao nitDao = new NitDaoImpl();
                    
//            msg = nitDao.findByNit(query);

            if (!msg.equals("Identificacion no existe en la DB")) {
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

    public void handleChangeDV() {
        if (this.nit.getD_v() != null) {
            FacesContext contex = FacesContext.getCurrentInstance();
            int aFactor[] = {71,67,59,53,47,43,41,37,29,23,19,17,13,7,3};
            int nAcum = 0;
            int nResto = 0;
            int b = 1;
            String cDv = nit.getD_v();
            String cNit = String.format("%015d", Integer.parseInt(nit.getIdenti()));
            
            String nDv = null;
            for (int i=0; i<cNit.length(); i++) {
                nAcum = nAcum + (Integer.parseInt(cNit.substring(i,b)) * aFactor[i]);
                b++;
            }
            
            nResto = nAcum - (nAcum / 11) * 11;
            
            if        (nResto == 0 || nResto == 11) {
                nDv = "0";
            } else if (nResto == 1 || nResto == 10) {
                nDv = "1";
            } else if (nResto == 2) {
                nDv = "9";
            } else if (nResto == 3) {
                nDv = "8";
            } else if (nResto == 4) {
                nDv = "7";
            } else if (nResto == 5) {
                nDv = "6";
            } else if (nResto == 6) {
                nDv = "5";
            } else if (nResto == 7) {
                nDv = "4";
            } else if (nResto == 8) {
                nDv = "3";
            } else if (nResto == 9) {
                nDv = "2";
            }
            
            if (!cDv.equals(nDv)) {
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
    
    public void validarNit(FacesContext contex,
            UIInput toValidate, Object value) {
        contex = FacesContext.getCurrentInstance();
        String query = (String) value;
        NitDao nitDao = new NitDaoImpl();
        
        if (query != null) {
//            msg = nitDao.findByNit(query);
            if (!msg.equals("Identificacion no existe en la DB")) {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
    }

    public void btnCreateNit() {
        NitDao nitDao = new NitDaoImpl();
        
        this.nit.setSi_es_cli(false);
        this.nit.setSi_es_ter(false);
        this.nit.setSi_es_emp(false);
        this.nit.setSi_es_ban(false);
        this.nit.setSi_es_ter(false);
        this.nit.setSi_es_ban(false);
        this.nit.setSi_es_auto_rf(false);
        
//        for (String ls : this.getAuto_rete()) {
//            if        (ls.contains("Auto Retenedor")) {
//                this.nit.setSi_es_auto_rf(true);
//            } else  {
//                this.nit.setSi_es_auto_rf(false);
//            }
//        }
        
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
            contex.getExternalContext().redirect(MyUtil.baseLogin() + "app/master/nits.xhtml");
        } catch (IOException ex) {
            msgEx = ex.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public String[] getChekNit() {
        return chekNit;
    }

    public void setChekNit(String[] chekNit) {
        this.chekNit = chekNit;
    }

    public List<String> getLsChekNit() {
        return lsChekNit;
    }

    public void setLsChekNit(List<String> lsChekNit) {
        this.lsChekNit = lsChekNit;
    }
}
