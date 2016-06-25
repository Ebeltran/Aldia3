/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EmpleadoDao;
import dao.EmpleadoDaoImpl;
import jasperSoft.JasperSoftReport;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.Empleado;
import static util.MyFiles.numeroRandon;
import util.MyUtil;
import static util.MyUtil.rutaReport;
import static util.MyUtil.rutaResources;



/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class EmpleadoConAutoComBean implements Serializable {

    private static FacesMessage message;
    private static final long serialVersionUID = 1L;
    private Empleado empleado = new Empleado();
    private List<Empleado> empleados = new ArrayList<>();
    
    private List<SelectItem> listSelect;
    
    private String msgEx;
    private FacesContext aFContext;
    
//    StringBuilder archivoSale = new StringBuilder();
    String archivoS;
    File archivo;
    File archivoBorrar;
    String archivoJasper;
    
    String msg;
    String msg_n_a;
    String Si_es_Vigente;
    int resultado;
    
//    String archivoSale;
    Map<String, Object> parameters;
    List<InputStream> pdfs;
    OutputStream output;
    
    
    public List<Empleado> completeEmpleadoVigente(String query) {

        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        query = query.toUpperCase();
        Si_es_Vigente = "Si";
        List<Empleado> quieries = empleadoDao.findAutoCompFuncionario(query, Si_es_Vigente);
        
        return quieries;
    }
  
    public List<Empleado> completeEmpleadoRetirado(String query) {

        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        query = query.toUpperCase();
        Si_es_Vigente = "No";
        
        List<Empleado> quieries = empleadoDao.findAutoCompFuncionario(query, Si_es_Vigente);
        
        return quieries;
    }
      
    public void btnUpdateSalario (ActionEvent actionEvent) throws IOException {
        aFContext = FacesContext.getCurrentInstance();
        
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        Empleado empleadoNew = empleadoDao.findByEmpleado(this.empleado.getIdenti());
    
        this.empleado.setId_documen(-1);
        msg_n_a = new StringBuilder().append("El Rotulo de Direccion para ").append(this.empleado.getNombres_apellidos()).toString();
        
        if (this.empleado.getN_emp_pago_clase() == empleadoNew.getN_emp_pago_clase()
                && this.empleado.getVr_salario_ultimo() == empleadoNew.getVr_salario_ultimo()) {

            msg = new StringBuilder().append("No ha sido Actualizado ").toString();
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg_n_a, msg);
            empleado = new Empleado();
            this.empleado.setLpersona(false);
            
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
            aFContext.getExternalContext().redirect(new StringBuilder().append(MyUtil.baseUrl()).append("app/master/modificarSalario.xhtml").toString());
        } else {

            msg = empleadoDao.updateSalarios(empleado, empleadoNew.getN_emp_pago_clase());
            if (msg.contains("La Clase de Pago (Salario) ha sido Modificada y Actualizada Satisfactoriamente")) {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg_n_a, msg);
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg_n_a, msg);
            }
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    /**
     * Actuliza rotulo del funcionario
     * @param actionEvent 
     * @throws java.io.IOException 
     */
    public void btnUpdateRotulo (ActionEvent actionEvent) throws IOException {
        aFContext = FacesContext.getCurrentInstance();
        
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        Empleado empleadoNew = empleadoDao.findByEmpleado(this.empleado.getIdenti());
        
        resultado = this.empleado.getCiudad_depto().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empleado.setN_apl_ciudad(Integer.parseInt(this.empleado.getCiudad_depto().substring(resultado + 7)));
        }    
        this.empleado.setId_documen(-1);
        msg_n_a = new StringBuilder().append("El Rotulo de Direccion para ").append(this.empleado.getNombres_apellidos()).toString();
        if ((this.empleado.getDireccion().equals(empleadoNew.getDireccion())
                && this.empleado.getBarrio().equals(empleadoNew.getBarrio())
                && this.empleado.getCiudad_depto().equals(empleadoNew.getCiudad_depto())
                && this.empleado.getTel_uno().equals(empleadoNew.getTel_uno())
                && this.empleado.getTel_aux().equals(empleadoNew.getTel_aux())
                && this.empleado.getFax().equals(empleadoNew.getFax())
                && this.empleado.getE_mail().equals(empleadoNew.getE_mail())
                && this.empleado.getE_mail_a().equals(empleadoNew.getE_mail_a())
                && this.empleado.getPagina_web().equals(empleadoNew.getPagina_web())
                && this.empleado.getLatitud() == empleadoNew.getLatitud()
                && this.empleado.getLongitud() == empleadoNew.getLongitud()
                && this.empleado.getN_apl_ciudad() == empleadoNew.getN_apl_ciudad())
                || resultado > 0) {
            msg = new StringBuilder().append("No ha sido Actualizado ").toString();
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg_n_a, msg);
            empleado = new Empleado();
            this.empleado.setLpersona(false);
            
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
            aFContext.getExternalContext().redirect(new StringBuilder().append(MyUtil.baseUrl()).append("app/master/modificarRotulo.xhtml").toString());
        } else {

            msg = empleadoDao.updateRotulo(empleado);
            if (msg.contains("El rotulo de direccion ha sido Modificada y Actualizada Satisfactoriamente")) {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg_n_a, msg);
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg_n_a, msg);
            }
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    /**
     * Actualiza cargo del funcionario
     * @param actionEvent 
     * @throws java.io.IOException 
     */
    public void btnUpdateCargo (ActionEvent actionEvent) throws IOException {
        aFContext = FacesContext.getCurrentInstance();
        
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        Empleado empleadoNew = empleadoDao.findByEmpleado(this.empleado.getIdenti());
        
        resultado = this.empleado.getCargo().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empleado.setN_cargo(Integer.parseInt(this.empleado.getCargo().substring(resultado + 7)));
        }
        
        msg_n_a = new StringBuilder().append("El Cargo para ").append(this.empleado.getNombres_apellidos()).toString();
        if (this.empleado.getN_cargo() == empleadoNew.getN_cargo() ||
            resultado < 7 ) {
            msg = new StringBuilder().append("No ha sido Actualizado ").toString();
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg_n_a, msg);
            empleado = new Empleado();
            this.empleado.setLpersona(false);
            
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } else {
            this.empleado.setId_documen(-1);
            
            msg = empleadoDao.updateCargo(empleado, empleadoNew.getN_cargo());
            if (msg.contains("El Cargo ha sido Modificado y Actualizado Satisfactoriamente")) {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg_n_a, msg);
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg_n_a, msg);
            }
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
        
        aFContext.getExternalContext().redirect(new StringBuilder().append(MyUtil.baseUrl()).append("app/master/modificarCargo.xhtml").toString());
    }
    
    /**
     * Actualiza centro de trabajo del funcionario
     * @param actionEvent 
     * @throws java.io.IOException 
     */
    public void btnUpdateCentroTrabajo (ActionEvent actionEvent) throws IOException {
        aFContext = FacesContext.getCurrentInstance();
        
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        Empleado empleadoNew = empleadoDao.findByEmpleado(this.empleado.getIdenti());
        
        resultado = this.empleado.getCen_costo().indexOf(" ID => ");
        if (resultado > 0 ) {
            this.empleado.setN_centro_costo(Integer.parseInt(this.empleado.getCen_costo().substring(resultado + 7)));
        }
        msg_n_a = new StringBuilder().append("El Centro de Trabajo para ").append(this.empleado.getNombres_apellidos()).toString();
        if (this.empleado.getN_centro_costo() == empleadoNew.getN_centro_costo() ||
            resultado < 7 ) {
            msg = new StringBuilder().append("No ha sido Actualizado ").toString();
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg_n_a, msg);
            empleado = new Empleado();
            this.empleado.setLpersona(false);
            
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
            aFContext.getExternalContext().redirect(new StringBuilder().append(MyUtil.baseUrl()).append("app/master/modificarCentroTrabajo.xhtml").toString());
        } else {
            this.empleado.setId_documen(-1);
        
            msg = empleadoDao.updateCenTrabajo(empleado, empleadoNew.getN_centro_costo());
            if (msg.contains("El Centro de Trabajo ha sido Modificado y Actualizado Satisfactoriamente")) {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg_n_a, msg);
                
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg_n_a, msg);
            }
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    /**
     * Actualiza seguridad Social del funcionario
     * @param actionEvent 
     * @throws java.io.IOException 
     */
    public void btnUpdateSeguridadSocial (ActionEvent actionEvent) throws IOException {
        aFContext = FacesContext.getCurrentInstance();
        
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        Empleado empleadoNew = empleadoDao.findByEmpleado(this.empleado.getIdenti());
        
        this.empleado.setId_documen(-1);
        
        msg_n_a = new StringBuilder().append("La Seguridad Social para ").append(this.empleado.getNombres_apellidos()).toString();
        if (this.empleado.getIdenti_eps().equals(empleadoNew.getIdenti_eps())
                && this.empleado.getIdenti_fdp().equals(empleadoNew.getIdenti_fdp())
                && this.empleado.getIdenti_fdc().equals(empleadoNew.getIdenti_fdc())) {
            msg = new StringBuilder().append("No ha sido Actualizado ").toString();
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg_n_a, msg);
            empleado = new Empleado();
            this.empleado.setLpersona(false);
            
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
            aFContext.getExternalContext().redirect(new StringBuilder().append(MyUtil.baseUrl()).append("app/master/modificarSeguridadSocial.xhtml").toString());
        } else {
            String IdentiEps, IdentiFdp, IdentiFdc;
            
            if (this.empleado.getIdenti_eps().equals(empleadoNew.getIdenti_eps())) {
                IdentiEps = "";
            } else {
                IdentiEps = empleadoNew.getIdenti_eps();
            }
            if (this.empleado.getIdenti_fdp().equals(empleadoNew.getIdenti_fdp())) {
                IdentiFdp = "";
            } else {
                IdentiFdp = empleadoNew.getIdenti_fdp();
            }
            if (this.empleado.getIdenti_fdc().equals(empleadoNew.getIdenti_fdc())) {
                IdentiFdc = "";
            } else {
                IdentiFdc = empleadoNew.getIdenti_fdc();
            }
            
            msg = empleadoDao.updateSeguridadSocial(empleado, IdentiEps, IdentiFdp, IdentiFdc);
            if (msg.contains(": Seguridad Social ha sido Modificado y Actualizado Satisfactoriamente")) {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg_n_a, msg);
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg_n_a, msg);
            }
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    /**
     * Actualiza forma de pago del funcionario
     * @param actionEvent 
     * @throws java.io.IOException 
     */
    public void btnUpdateFormaPago (ActionEvent actionEvent) throws IOException {
        aFContext = FacesContext.getCurrentInstance();
        
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        Empleado empleadoNew = empleadoDao.findByEmpleado(this.empleado.getIdenti());
        
        this.empleado.setId_documen(-1);

        msg_n_a = new StringBuilder().append("La Forma de Pago para ").append(this.empleado.getNombres_apellidos()).toString();
        if (this.empleado.getN_emp_pago_forma() == empleadoNew.getN_emp_pago_forma()
                && this.empleado.getIdenti_banco().equals(empleadoNew.getIdenti_banco())
                && this.empleado.getBan_sucursal().equals(empleadoNew.getBan_sucursal())
                && this.empleado.getN_ban_cuenta_tipo() == empleadoNew.getN_ban_cuenta_tipo()
                && this.empleado.getCuenta_cta().equals(empleadoNew.getCuenta_cta())) {
            msg = new StringBuilder().append("No ha sido Actualizado ").toString();
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg_n_a, msg);
            empleado = new Empleado();
            this.empleado.setLpersona(false);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
            aFContext.getExternalContext().redirect(new StringBuilder().append(MyUtil.baseUrl()).append("app/master/modificarFormaPago.xhtml").toString());
        } else {
            msg = empleadoDao.updateFormaPago(empleado, empleadoNew.getN_emp_pago_forma());
            if (msg.contains("La Forma de Pago ha sido Modificada y Actualizada Satisfactoriamente")) {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg_n_a, msg);
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg_n_a, msg);
            }
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    /**
     * 
     * @param actionEvent 
     * @throws java.io.FileNotFoundException 
     */
    public void btnReportContratoLaboral(ActionEvent actionEvent) throws FileNotFoundException {

        // Contrato Laboral
        archivoJasper = "contratoLaboral";

        archivo = new File(rutaReport() + new StringBuilder().append("PDF").append(File.separatorChar).append("Contratos").toString()); 
        if (!archivo.exists()) {
            archivo.mkdirs();
        }
        archivoS = new StringBuilder().append("PDF").append(File.separatorChar).append("Contratos").append(File.separatorChar).append(this.empleado.getReporte_nombre()).append("_Contrato").toString();
        System.out.println("ALDIA3_LOG_ContratoLaboral_archivoS: " + archivoS);
        
        parameters = new HashMap<>();
        parameters.put("IC_LOGIN", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login"));
        parameters.put("ID_AGENCIA", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia"));
        parameters.put("ID_ALMACEN", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen"));
        parameters.put("IDENTI_E", this.empleado.getIdenti());
        parameters.put("NO_CON_TRABAJO_E", this.empleado.getNo_con_trabajo());
        parameters.put("SI_ES_CONTRATO", "Si");
        parameters.put("RUTA_RESOURCES", rutaResources());

        JasperSoftReport.createReport(parameters, archivoJasper, archivoS);
        
    }
    
    /**
     * Metodo para imprimir el resumen de contrato
     * @param actionEvent 
     * @throws java.io.FileNotFoundException 
     */
    public void btnReportResumenContrato(ActionEvent actionEvent) throws FileNotFoundException {
        
        // Nombre del archivo para Imprimir
        archivoJasper = "contratoResumen";
        
        archivo = new File(rutaReport() + new StringBuilder().append("PDF").append(File.separatorChar).append("Contratos").toString()); 
        if (!archivo.exists()) {
            archivo.mkdirs();
        }
        archivoS = new StringBuilder().append("PDF").append(File.separatorChar).append("Contratos").append(File.separatorChar).append(this.empleado.getReporte_nombre()).append("_Resumen").toString();
        System.out.println("ALDIA3_LOG_ResumenContrato_archivoS: " + archivoS);
        
        // Establece parametros
        parameters = new HashMap<>();
        parameters.put("IC_LOGIN", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login"));
        parameters.put("ID_AGENCIA", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia"));
        parameters.put("ID_ALMACEN", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen"));
        parameters.put("IDENTI_E", this.empleado.getIdenti());
        parameters.put("NO_CON_TRABAJO_E", this.empleado.getNo_con_trabajo());
        parameters.put("SI_ES_CONTRATO", "No");
        parameters.put("RUTA_RESOURCES", rutaResources());

        JasperSoftReport.createReport(parameters, archivoJasper, archivoS);
    }

    /**
     * Metodo para imprimir los pendientes al contrato
     * @param actionEvent 
     * @throws java.io.FileNotFoundException 
     */
    public void btnReportPendientes(ActionEvent actionEvent) throws FileNotFoundException {
    
        // Nombre del archivo para Imprimir
        archivoJasper = "aplCartaGen";
                
        archivo = new File(rutaReport() + new StringBuilder().append("PDF").append(File.separatorChar).append("Pendientes").toString()); 
        if (!archivo.exists()) {
            archivo.mkdirs();
        }
        archivoS = new StringBuilder().append("PDF").append(File.separatorChar).append("Pendientes").append(File.separatorChar).append(this.empleado.getReporte_nombre()).append("_Pendiente").toString();
        System.out.println("ALDIA3_LOG_ReportPendientes_archivoS: " + archivoS);
        // Establece parametros
        parameters = new HashMap<>();
        parameters.put("IC_LOGIN", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login"));
        parameters.put("ID_AGENCIA_E", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia"));
        parameters.put("ID_ALMACEN_E", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen"));
        parameters.put("IDENTI_E", this.empleado.getIdenti());
        parameters.put("N_APL_CARTA_E", 5);
        parameters.put("RUTA_RESOURCES", rutaResources());

        JasperSoftReport.createReport(parameters, archivoJasper, archivoS);
    }
    
    /**
     * Metodo para imprimir los pendientes al contrato
     * @param actionEvent 
     * @throws java.lang.Exception 
     */
    public void btnReportVisita(ActionEvent actionEvent) throws Exception {
    
        // Visita Diomiciliaria -> fichaGrafologica P 3
        archivoJasper = "fichaGrafologicaV";

        archivo = new File(rutaReport() + new StringBuilder().append("TMP").toString()); 
        if (!archivo.exists()) {
            archivo.mkdirs();
        }
        
        String archivoTmp3 = new StringBuilder().append("TMP").append(File.separatorChar).append(siExisteArchivo("_FGrafo")).toString();
        System.out.println("ALDIA3_LOG_ReportVisita_archivoTmp3: " + archivoTmp3);
        
        // Establece parametros
        parameters = new HashMap<>();
        parameters.put("IC_LOGIN", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login"));
        parameters.put("ID_AGENCIA_E", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia"));
        parameters.put("IDENTI_E", this.empleado.getIdenti());

        JasperSoftReport.createReport(parameters, archivoJasper, archivoTmp3);

        // Visita Diomiciliaria -> fichaDecadactilar P 2
        archivoJasper = "fichaDecadactilarV";
        String archivoTmp2 = new StringBuilder().append("TMP").append(File.separatorChar).append(siExisteArchivo("_FDeca")).toString();
        System.out.println("ALDIA3_LOG_ReportVisita_archivoTmp2: " + archivoTmp2);
        
        // Establece parametros
        parameters = new HashMap<>();
        parameters.put("IC_LOGIN", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login"));
        parameters.put("ID_AGENCIA_E", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia"));
        parameters.put("IDENTI_E", this.empleado.getIdenti());

        JasperSoftReport.createReport(parameters, archivoJasper, archivoTmp2);

        // Visita Diomiciliaria -> P 1
        archivoJasper = "visitaDomiciliaria";
        String archivoTmp1 = new StringBuilder().append("TMP").append(File.separatorChar).append(siExisteArchivo("_Visita")).toString();
        System.out.println("ALDIA3_LOG_ReportVisita_archivoTmp1: " + archivoTmp1);
        
        // Establece parametros
        parameters = new HashMap<>();
        parameters.put("IC_LOGIN", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login"));
        parameters.put("ID_AGENCIA_E", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia"));
        parameters.put("IDENTI_E", this.empleado.getIdenti());
        parameters.put("RUTA_RESOURCES", rutaResources());

        JasperSoftReport.createReport(parameters, archivoJasper, archivoTmp1);

        archivo = new File(rutaReport() + new StringBuilder().append("PDF").append(File.separatorChar).append("Visitas").toString());
        if (!archivo.exists()) {
            archivo.mkdirs();
        }
        archivoS = new StringBuilder().append(rutaReport()).append("PDF").append(File.separatorChar).append("Visitas").append(File.separatorChar).append(this.empleado.getReporte_nombre()).append("_Visita.PDF").toString();
        System.out.println("ALDIA3_LOG_ReportVisita_archivoS: " + archivoS);
        
        String archivoTmp4 = new StringBuilder().append("TMP").append(File.separatorChar).append(siExisteArchivo("_Fase1")).toString();
        System.out.println("ALDIA3_LOG_ReportVisita_archivoTmp4: " + archivoTmp4);
        
        archivoTmp1 = new StringBuilder().append(rutaReport()).append(archivoTmp1).append(".PDF").toString();
        archivoTmp2 = new StringBuilder().append(rutaReport()).append(archivoTmp2).append(".PDF").toString();
        archivoTmp3 = new StringBuilder().append(rutaReport()).append(archivoTmp3).append(".PDF").toString();
        archivoTmp4 = new StringBuilder().append(rutaReport()).append(archivoTmp4).append(".PDF").toString();
        System.out.println("ALDIA3_LOG_ReportVisita_archivoTmp1: " + archivoTmp1);
        System.out.println("ALDIA3_LOG_ReportVisita_archivoTmp2: " + archivoTmp2);
        System.out.println("ALDIA3_LOG_ReportVisita_archivoTmp3: " + archivoTmp3);
        System.out.println("ALDIA3_LOG_ReportVisita_archivoTmp4: " + archivoTmp4);

//        String archivoTmp4 = new StringBuilder().append(rutaReport()).append("TMP").append(File.separatorChar).append(numeroRandon()).append("_Fase1.PDF").toString();
        
        // Uniendo archivos
        util.MyPDFFiles.concatenar2PDF (archivoTmp1, archivoTmp2, archivoTmp4);
        
        util.MyPDFFiles.concatenar2PDF (archivoTmp4, archivoTmp3, archivoS);
        
        // borrando temporales
        StringBuilder auxiliar = new StringBuilder();
        
        if ((util.MyFiles.eliminarArchivo(archivoTmp1)).contains("NO ha Sido Eliminado Archivo")) {
            auxiliar.append("Archivo ").append(archivoTmp1).append("NO ha Sido Eliminado");
        }
        if ((util.MyFiles.eliminarArchivo(archivoTmp2)).contains("NO ha Sido Eliminado Archivo")) {
            auxiliar.append("Archivo ").append(archivoTmp1).append("NO ha Sido Eliminado");
        }
        if ((util.MyFiles.eliminarArchivo(archivoTmp3)).contains("NO ha Sido Eliminado Archivo")) {
           auxiliar.append("Archivo ").append(archivoTmp3).append("NO ha Sido Eliminado"); 
        }
        if ((util.MyFiles.eliminarArchivo(archivoTmp4)).contains("NO ha Sido Eliminado Archivo")) {
           auxiliar.append("Archivo ").append(archivoTmp3).append("NO ha Sido Eliminado"); 
        }
        
        if (auxiliar.toString().length() > 0) {
            System.out.println("ALDIA3_LOG_Por alguna razon los archivos Temporales" + auxiliar.toString());
            
        }
    }
    
    /**
     * Metodo para retirar al funcionario
     * @param actionEvent
     * @throws FileNotFoundException
     * @throws Exception 
     */
    public void btnFinalContratoLaboral(ActionEvent actionEvent) throws FileNotFoundException, Exception {
        
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        
        msg = empleadoDao.finalContrato(empleado);
        if (msg.contains("Se ha Finalizado el Contrato de Trabajo")) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            // se genera reporte
            archivoJasper = "aplCartaGen";

            archivo = new File(rutaReport() + new StringBuilder().append("PDF").append(File.separatorChar).append("Fin_Contrato").toString());
            if (!archivo.exists()) {
                archivo.mkdirs();
            }
            archivoS = new StringBuilder().append("PDF").append(File.separatorChar).append("Contratos").append(File.separatorChar).append(this.empleado.getReporte_nombre()).append("Fin_Contrato").toString();

            // Establece parametros
            parameters = new HashMap<>();
            parameters.put("IC_LOGIN", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login"));
            parameters.put("ID_AGENCIA_E", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia"));
            parameters.put("ID_ALMACEN_E", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen"));
            parameters.put("IDENTI_E", this.empleado.getIdenti());
            parameters.put("N_APL_CARTA_E", 7);
            parameters.put("RUTA_RESOURCES", rutaResources());

            JasperSoftReport.createReport(parameters, archivoJasper, archivoS);

        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
    public void btnReintegraFuncionario(ActionEvent actionEvent) throws FileNotFoundException, Exception {
        
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        
        msg = empleadoDao.reintegraContrato(empleado);
        if (msg.contains("Registro Modificado y Actualizado Satisfactoriamente")) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
    /**
     * Metodo para el boton de Salir del modulo
     */
    public void resetFinalizar() {
        aFContext = FacesContext.getCurrentInstance();
        
        empleado = new Empleado();
        this.empleado.setLpersona(true);
        
        empleado = new Empleado();
        this.empleado.setLpersona(true);
        
        try {
            aFContext.getExternalContext().redirect(MyUtil.baseUrl() + "app/inicio.xhtml");
        } catch (IOException ex) {
            msgEx = ex.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
        
    }
   
    public List<SelectItem> onCambioPagoForma() {
        if (empleado.getN_emp_pago_forma() == 1) {
            this.empleado.setLpagoforma(true);
        } else {
            this.empleado.setLpagoforma(false);
        }
        return listSelect;
    }
    /**
     * Metodo para hacer Salir del modulo
     */
    public void reset() {
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            contex.getExternalContext().redirect(MyUtil.baseLogin() + "app/inicio.xhtml");
        } catch (IOException ex) {
            msgEx = ex.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    private static String siExisteArchivo(String sufijo) {
        String archivo = null;
        boolean i = true;
        while (i) {
            archivo = new StringBuilder().append(numeroRandon()).append(sufijo).toString();
            File file = new File(new StringBuilder().append(rutaReport()).append("TMP").append(File.separatorChar).append(archivo).append(".PDF").toString());
            if (file.exists()) {
                archivo = new StringBuilder().append(numeroRandon()).append(sufijo).toString();
            } else {
               i = false;
            }
        }
        return archivo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

}