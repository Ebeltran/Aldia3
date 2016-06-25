/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EmpSDao;
import dao.EmpSDaoImpl;
import jasperSoft.JasperSoftReport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.EmpS;
import util.MyUtil;
import static util.MyUtil.rutaReport;
import static util.MyUtil.rutaResources;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class DocumentoProspectoBean implements Serializable {

   private static final long serialVersionUID = 1L;
    private static FacesContext aFContext;
    
    private EmpS empS = new EmpS();
    private List<EmpS> empSs = new ArrayList<EmpS>();
    
    String msgEx = null;
    String msg = null;
    String query = null;
    FacesMessage message;
    
    String archivoS;
    File archivo;
    String archivoJasper;

    
//    public DocumentoProspectoBean() {
//        empS = new EmpS();
//        this.empS.setLpersona(false);
//    }
    
    /**
     * Metodo para realizar busqueda de prospectos en la tabala EMP_S 
     * que se encuentren con N_EMP_ESTADO_LABORAL_E = 1 equivalentes a 
     * CANDIDATO SELECCIONABLE para ser incluidos en los informes de precontratacion
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
     * 
     */
    public void buscarPropecto() {
        EmpSDao empSDao = new EmpSDaoImpl();

        msg = empSDao.findByEmpS(empS);

        if (!msg.contains(this.empS.getIdenti())) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            this.empS.setN_nit_tip_identidad(0);
            this.empS.setIdenti(null);
            this.empS.setLpersona(false);
        } else {
            this.empS.setLpersona(true);
            
        }
    }

    public void btnExamenMedicoIngreso(ActionEvent actionEvent) throws FileNotFoundException {

        // Carta Examen Medico
        archivoJasper = "aplCartaGen";

        archivo = new File(rutaReport() + new StringBuilder().append("PDF").append(File.separatorChar).append("Carta_Examen").toString()); 
        if (!archivo.exists()) {
            archivo.mkdirs();
        }
        
        archivoS = new StringBuilder().append("PDF").append(File.separatorChar).append("Carta_Examen").append(File.separatorChar).append(this.empS.getReporte_nombre()).append("_ExamenIngreso").toString();
        System.out.println("ALDIA3_LOG_ExamenMedicoIngreso_archivoS: " + archivoS);
        
        // Establece parametros
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("IC_LOGIN", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login"));
        parameters.put("ID_AGENCIA_E", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia"));
        parameters.put("ID_ALMACEN_E", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen"));
        parameters.put("IDENTI_E", this.empS.getIdenti());
        parameters.put("N_APL_CARTA_E", 2);
        parameters.put("NO_REFERENCIA_PERSONAL", 0);
        parameters.put("NO_REFERENCIA_LABORAL", 0);
        parameters.put("RUTA_RESOURCES", rutaResources());

        JasperSoftReport.createReport(parameters, archivoJasper, archivoS);

    }
    
    public void btnCartaBanco(ActionEvent actionEvent) throws FileNotFoundException {
        
        // // Carta Carta Banco
        archivoJasper = "aplCartaGen";

        archivo = new File(rutaReport() + new StringBuilder().append("PDF").append(File.separatorChar).append("Carta_Banco").toString()); 
        if (!archivo.exists()) {
            archivo.mkdirs();
        }
        archivoS = new StringBuilder().append("PDF").append(File.separatorChar).append("Carta_Banco").append(File.separatorChar).append(this.empS.getReporte_nombre()).append("_CartaBanco").toString();
        System.out.println("ALDIA3_LOG_CartaBanco_archivoS: " + archivoS);
        
        // Establece parametros
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("IC_LOGIN", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login"));
        parameters.put("ID_AGENCIA_E", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia"));
        parameters.put("ID_ALMACEN_E", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen"));
        parameters.put("IDENTI_E", this.empS.getIdenti());
        parameters.put("N_APL_CARTA_E", 1);
        parameters.put("NO_REFERENCIA_PERSONAL", 0);
        parameters.put("NO_REFERENCIA_LABORAL", 0);
        parameters.put("RUTA_RESOURCES", rutaResources());
        
        JasperSoftReport.createReport(parameters, archivoJasper, archivoS);

    }
    
    /**
     * Metodo para el boton de Salir del modulo
     */
    public void resetFinalizar() {
        aFContext = FacesContext.getCurrentInstance();
        
        empS = new EmpS();
        this.empS.setLauxtran(true);
        
        try {
            aFContext.getExternalContext().redirect(MyUtil.baseUrl() + "app/inicio.xhtml");
        } catch (IOException ex) {
            msgEx = ex.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
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
