package bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

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
public class ModificarPropesctoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private EmpS empS = new EmpS();
    private List<EmpS> empSs = new ArrayList<EmpS>();

    String msgEx = null;
    String msg = null;
    String query = null;
    FacesMessage message;
    Date date = new Date();
    
    public ModificarPropesctoBean() {
        this.empS.setLpersona(false);
        this.empS.setN_nit_tip_identidad(0);
        this.empS.setCabeza_es(null);
        this.empS.setN_apl_sexo(0);
        this.empS.setN_apl_e_civil(0);
        this.empS.setN_apl_sangre_tipo(0);
        this.empS.setN_apl_ciudad(0);
        this.empS.setN_ciudad_nace(0);
        this.empS.setN_cargo_aspira(0);
        this.empS.setVr_salario_aspira(0);
        
    }
    
    /**
     * Metodo para realizar Modificacion de prospectos en la tabala EMP_S 
     * que se encuentren con N_EMP_ESTADO_LABORAL_E = 1 equivalentes a 
     * CANDIDATO SELECCIONABLE
     * @param query 
     * @return 
     */
    public List<EmpS> completePropecto(String query) {
        
        int i = 1;    
        EmpSDao empsDao = new EmpSDaoImpl();
        query = query.toUpperCase();
        List<EmpS> quieries = empsDao.findAutoCompProspecto(query, i);

        return quieries;
    }
    
    /**
     * Metodo para realizar Modificacion de prospectos en la tabala EMP_S 
     * que se encuentren con N_EMP_ESTADO_LABORAL_E = 3 equivalentes a 
     * RETIRADO
     * @param query 
     * @return 
     */
    public List<EmpS> recuperaPropecto(String query) {
        
        int i = 3;    
        EmpSDao empsDao = new EmpSDaoImpl();
        query = query.toUpperCase();
        List<EmpS> quieries = empsDao.findAutoCompProspecto(query, i);

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
     * Metodo para seleccionar Boton Para Guardar prospecto
     * @param actionEvent 
     */
    public void btnUpdateProspecto(ActionEvent actionEvent) {
        EmpSDao empSDao = new EmpSDaoImpl();
        int resultado;
        
        resultado = this.empS.getCiudad_depto().indexOf(" ID => ");
        this.empS.setN_apl_ciudad(Integer.parseInt(this.empS.getCiudad_depto().substring(resultado + 7)));
        
        resultado = this.empS.getNom_cargo_aspira().indexOf(" ID => ");
        this.empS.setN_cargo_aspira(Integer.parseInt(this.empS.getNom_cargo_aspira().substring(resultado + 7)));
        this.empS.setN_cargo(Integer.parseInt(this.empS.getNom_cargo_aspira().substring(resultado + 7)));
        
        resultado = this.empS.getNom_cen_costo().indexOf(" ID => ");
        this.empS.setN_cen_costo(Integer.parseInt(this.empS.getNom_cen_costo().substring(resultado + 7)));
        
        resultado = this.empS.getCiudad_depto_nace().indexOf(" ID => ");
        this.empS.setN_ciudad_nace(Integer.parseInt(this.empS.getCiudad_depto_nace().substring(resultado + 7)));
        
        if (this.empS.getN_apl_sexo()  == 1) {
            this.empS.setSi_es_cabeza_familia(false);
        }
        this.empS.setFecha_actual(util.ConversionUtil.getTimestamp());
        this.empS.setFecha_control(util.ConversionUtil.getTimestamp());
        
        this.empS.setIdenti(MyUtilFormat.formatDelete(this.empS.getIdenti_con()));
        this.empS.setVr_salario_aspira(Double.parseDouble(MyUtilFormat.formatDelete(this.empS.getSalario_aspira())));
        this.empS.setVr_salario(Double.parseDouble(MyUtilFormat.formatDelete(this.empS.getSalario_aspira())));
        
        msg = empSDao.update(this.empS);
                            
        if (msg.contains("Registro Modificado y Actualizado Satisfactoriamente")) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg + " para", 
                    this.empS.getApellidos_nombres() + " Identificacion: "+  MyUtilFormat.formatOutput(this.empS.getIdenti()));
                    
            this.empS.setLpersona(false);
            this.empS.setApellidos_nombres("");
            
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al registrar el registro para", 
                    this.empS.getApellidos_nombres() + " Identificacion: "+  MyUtilFormat.formatOutput(this.empS.getIdenti()));
            
        }
        
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
    
    /**
     * Metodo para seleccionar Boton para Guardar prospecto convertido a 
     * de RETIRADO a CANDIDATO SELECCIONABLE
     * @param actionEvent 
     */
    public void btnRecuperaProspecto(ActionEvent actionEvent) {
        EmpSDao empSDao = new EmpSDaoImpl();
        
        this.empS.setN_emp_estado_laboral(3);
        this.empS.setSi_contratado("No");
        
        this.empS.setIdenti(MyUtilFormat.formatDelete(this.empS.getIdenti_con()));
        
        msg = empSDao.update(this.empS);
                            
        if (msg.contains("Se ha Recuperado el Contrato de Trabajo")) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg + " para", 
                    this.empS.getApellidos_nombres() + " Identificacion: "+  MyUtilFormat.formatOutput(this.empS.getIdenti()));
                    
            this.empS.setLpersona(false);
            this.empS.setApellidos_nombres("");
            
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al registrar el registro para", 
                    this.empS.getApellidos_nombres() + " Identificacion: "+  MyUtilFormat.formatOutput(this.empS.getIdenti()));
            
        }
        
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
    
    /**
     * Metodo para el boton de Salir del modulo
     */
    public void resetFinalizar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        empS = new EmpS();
        
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