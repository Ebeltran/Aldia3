/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AplOperadorDao;
import dao.AplOperadorDaoImpl;
import jasperSoft.JasperSoftReport;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import model.AplOperador;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import util.MyMailServer;
import util.MyUtil;
import util.StringUtils;

@ManagedBean
@ViewScoped
public class AplOperadorBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private List<AplOperador> aplOperadors;  
    private AplOperador selectedAplOperador; 
    private Date fecha_reporte;
    
    FacesMessage message;
    
    String msgMail = "";
    String nombre;
    String from;
    
    String claveNueva = "";
    String msgEx = null;
    String msg;
    
    Date date = new Date();
    
    /**
     * Creates a new instance of aplOperadorBean
     */
    public AplOperadorBean() {
        
    }

    /**
     * Metodo para hacer reset al formulario
     */
    public void resetFormulario(){
        this.selectedAplOperador = new AplOperador();
    }
    
    public List<AplOperador> getAplOperadors() {
        AplOperadorDao aplOperadorDao = new AplOperadorDaoImpl();
        this.aplOperadors = new ArrayList<>();
        this.aplOperadors = aplOperadorDao.findAll();
        return aplOperadors;
    }

    public AplOperador getSelectedAplOperador() { 
        return selectedAplOperador;  
    }

    public void setSelectedAplOperador(AplOperador selectedAplOperador) {
        this.selectedAplOperador = selectedAplOperador;
    }

    public void onClose(CloseEvent event) {
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
//    public void btnCambioClave() throws Exception  {
//        
//        AplOperadorDao aplOperadorDao = new AplOperadorDaoImpl();
//
//        this.selectedAplOperador.setClave_1(this.claveNueva);
//        msg = aplOperadorDao.cambioClave(this.selectedAplOperador);
//        if (msg.equals("Clave cambiada Satisfactoriamente")) {
//            
//            /*Envio Correo*/
//            String url = MyUtil.basePublicUrl();
//        
//            String nombre = this.selectedAplOperador.getNombre_1() + " "
//                    + this.selectedAplOperador.getNombre_2() + " "
//                    + this.selectedAplOperador.getApellido_1()+ " "
//                    + this.selectedAplOperador.getApellido_2();
//            
//            String subject = "Cambio de Clave en Aldia3 " + nombre;
//            // Cuenta desde donde se enviarar el correo de confirmacion
//            String from = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email");
//            
//            StringBuilder body = new StringBuilder();
//            body.append("Hola ").append(nombre).append("<br/>");
//            body.append("Nos permitimos confirmale la clave creada para el sitio<br/><br/>");
//            body.append("Copie y pegue el siguiente enlace en Mozilla FireFox ").append(url).append("<br/><br/>");
//            body.append("Usuario: ").append(this.selectedAplOperador.getUsuario()).append("<br/>");
//            body.append("Clave: ").append("**********").append("<br/><br/>");
//            body.append("Cordial saludo<br/><br/>");
//            body.append((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombreUsuario"));
//            body.append("<br/>");
//            body.append((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("emp_nombre"));
//                        
//            MyMailServer myMailServer = new MyMailServer();
//            
//            mailer = "AldiaSoft Creacion de Cuenta";
//            msgMail = myMailServer.sendMail(this.selectedAplOperador.getCorreo_email(), from, subject, mailer, body.toString());
//            
//            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
//            FacesContext.getCurrentInstance().addMessage(null, message);
//
//        } else {
//            
//            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
//            FacesContext.getCurrentInstance().addMessage(null, message); 
//            
//        }
//        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
//    }
    
    public void btnResetClave() throws Exception  {
        
        AplOperadorDao aplOperadorDao = new AplOperadorDaoImpl();

        claveNueva = StringUtils.generateRandomPassword();
        this.selectedAplOperador.setPassword(claveNueva);
        
        
        msg = aplOperadorDao.resetClave(this.selectedAplOperador);
        if (msg.equals("Clave restablecida Satisfactoriamente")) {
            
            /*Envio Correo*/
            
            StringBuilder auxiliar = new StringBuilder();
            if (!"".equals(this.selectedAplOperador.getNombre_2().trim())) {
                auxiliar.append(this.selectedAplOperador.getNombre_1().trim()).append(" ");
                auxiliar.append(this.selectedAplOperador.getNombre_2());
            } else {
                auxiliar.append(this.selectedAplOperador.getNombre_1().trim());
            }
            if (!"".equals(this.selectedAplOperador.getApellido_2().trim())) {
                auxiliar.append(" ").append(this.selectedAplOperador.getApellido_1().trim());
                auxiliar.append(" ").append(this.selectedAplOperador.getApellido_2().trim());
            } else {
                auxiliar.append(" ").append(this.selectedAplOperador.getApellido_1().trim());
            }
            nombre = auxiliar.toString();
            
            StringBuilder subject = new StringBuilder();
            subject.append("Reset Clave en Aldia3 ").append(nombre);
            
            // Cuenta desde donde se enviarar el correo de confirmacion
            from = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email");
            
            StringBuilder body = new StringBuilder();
            body.append("Hola ").append(nombre).append("<br/>");
            body.append("Nos permitimos confirmale he,mos restablecido su clave en AldiaSoft<br/><br/>");
            body.append("Copie y pegue el siguiente enlace en Mozilla FireFox ").append("<br/>").append(MyUtil.baseUrl_noFaces()).append("<br/><br/>");
            body.append("Usuario: ").append(this.selectedAplOperador.getUsuario()).append("<br/>");
            body.append("Clave: ").append(claveNueva).append("<br/><br/>");
            body.append("Cordial saludo<br/><br/>");
            body.append((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombreUsuario"));
            body.append("<br/>");
            body.append((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("emp_nombre"));
                        
            MyMailServer myMailServer = new MyMailServer();
            
            StringBuilder mailer = new StringBuilder();
            subject.append("AldiaSoft Restablece Clave");
            
            msgMail = myMailServer.sendMail(this.selectedAplOperador.getCorreo_email(), from, subject.toString(), mailer.toString(), body.toString());
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, nombre);
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
        }
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
    public void btnCreateAplOperador(ActionEvent actionEvent) throws MessagingException {
        AplOperadorDao aplOperadorDao = new AplOperadorDaoImpl();

        this.selectedAplOperador.setCfec_desde(new java.text.SimpleDateFormat("yyyy.MM.dd").format(this.selectedAplOperador.getFec_desde()));
        this.selectedAplOperador.setChora_desde(new java.text.SimpleDateFormat("HH:mm:ss").format(this.selectedAplOperador.getHora_desde()));
        this.selectedAplOperador.setChora_hasta(new java.text.SimpleDateFormat("HH:mm").format(this.selectedAplOperador.getHora_hasta())+":59");
         
        if (this.selectedAplOperador.getLsi_activo()) {
            this.selectedAplOperador.setSi_activo("Si");
        } else {
            this.selectedAplOperador.setSi_activo("No");
        }
        if (this.selectedAplOperador.getLsi_festivo()) {
            this.selectedAplOperador.setSi_festivo("Si");
        } else {
            this.selectedAplOperador.setSi_festivo("No");
        }
        
        claveNueva = StringUtils.generateRandomPassword();
        this.selectedAplOperador.setClave_1(claveNueva);

        if (aplOperadorDao.create(this.selectedAplOperador)){
//        if (1 == 1) {
            msg = this.selectedAplOperador.getMensaje();

            /*Envio Correo*/
            
            StringBuilder auxiliar = new StringBuilder();
            if (!"".equals(this.selectedAplOperador.getNombre_2().trim())) {
                auxiliar.append(this.selectedAplOperador.getNombre_1().trim()).append(" ");
                auxiliar.append(this.selectedAplOperador.getNombre_2());
            } else {
                auxiliar.append(this.selectedAplOperador.getNombre_1().trim());
            }
            if (!"".equals(this.selectedAplOperador.getApellido_2().trim())) {
                auxiliar.append(" ").append(this.selectedAplOperador.getApellido_1().trim());
                auxiliar.append(" ").append(this.selectedAplOperador.getApellido_2().trim());
            } else {
                auxiliar.append(" ").append(this.selectedAplOperador.getApellido_1().trim());
            }
            nombre = auxiliar.toString();
            
            StringBuilder subject = new StringBuilder();
            subject.append("Bienvenido a Aldia3 ").append(nombre);
            
            // Cuenta desde donde se enviarar el correo de confirmacion
            from = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email");
            
            StringBuilder body = new StringBuilder();
            body.append("Hola ").append(nombre).append("<br/>");
            body.append("Nos permitimos confirmale la clave creada para el sitio<br/><br/>");
            body.append("Copie y pegue el siguiente enlace en Mozilla FireFox ").append(MyUtil.baseUrl_noFaces()).append("<br/><br/>");
            body.append("Usuario: ").append(this.selectedAplOperador.getUsuario()).append("<br/>");
            body.append("Clave: ").append(claveNueva).append("<br/><br/>");
            body.append("Cordial saludo<br/><br/>");
            body.append((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombreUsuario"));
            body.append("<br/>");
            body.append((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("emp_nombre"));
                        
            MyMailServer myMailServer = new MyMailServer();
            
            StringBuilder mailer = new StringBuilder();
            
            body.append("AldiaSoft Creacion de Cuenta");
            msgMail = myMailServer.sendMail(this.selectedAplOperador.getCorreo_email(), from, subject.toString(), mailer.toString(), body.toString());
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, nombre);
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            msg = "Error al Crear el registro de AplOperador";
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, nombre);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }        
     }
    
    public void btnUpdateAplOperador(ActionEvent actionEvent) {
        AplOperadorDao aplOperadorDao = new AplOperadorDaoImpl();

        this.selectedAplOperador.setCfec_desde(new java.text.SimpleDateFormat("yyyy.MM.dd").format(this.selectedAplOperador.getFec_desde()));
        this.selectedAplOperador.setChora_desde(new java.text.SimpleDateFormat("HH:mm:ss").format(this.selectedAplOperador.getHora_desde()));
        this.selectedAplOperador.setChora_hasta(new java.text.SimpleDateFormat("HH:mm:ss").format(this.selectedAplOperador.getHora_hasta()));
        
        if (this.selectedAplOperador.getLsi_activo()) {
            this.selectedAplOperador.setSi_activo("Si");
        } else {
            this.selectedAplOperador.setSi_activo("No");
        }
        if (this.selectedAplOperador.getLsi_festivo()) {
            this.selectedAplOperador.setSi_festivo("Si");
        } else {
            this.selectedAplOperador.setSi_festivo("No");
        }
        
        msg = aplOperadorDao.update(this.selectedAplOperador);
        if (msg.contains("Registro Modificado y Actualizado Satisfactoriamente")) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void btnDeleteAplOperador(ActionEvent actionEvent) {
        AplOperadorDao aplOperadorDao = new AplOperadorDaoImpl();
        if (aplOperadorDao.delete(selectedAplOperador)) {
            msg = "Se eliminó correctamente AplOperador";
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al eliminar el registro";
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }        
    }
    
    public void btnReportAplOperador(ActionEvent actionEvent) {
        try {
            
            // Nombre del archivo para Imprimir
            String archivoJasper = "ALGO";
            
            // Nombre del archivo para guardar
            String archivoSale   = "ALGO";
            
            // Establece parametros
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("ID_AGENCIA_E", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia"));
            parameters.put("IC_LOGIN", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login"));
            parameters.put("FECHA_EE", new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(fecha_reporte));
            JasperSoftReport.createReport(parameters, archivoJasper, archivoSale);
            
            FacesContext contex = FacesContext.getCurrentInstance();
            
            // Redirecciona Pagina
            contex.getExternalContext().redirect("reporteOperador.xhtml");
//        RequestContext.getCurrentInstance().openDialog("selectReport");
        } catch (IOException ex) {
            Logger.getLogger(AplOperadorBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void reportAplOperador() throws IOException {
//        FacesContext contex = FacesContext.getCurrentInstance();
        JasperSoftReport.showViewer();
        // Redirecciona Pagina
//        contex.getExternalContext().redirect("operadoresReport.xhtml");
    }
    
    /***
     * 
     * @param event
     */
    public void onReportChoose(SelectEvent event) {
        
        JasperSoftReport.showViewer();
        
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha", new java.text.SimpleDateFormat("yyyy.MM.dd").format(fecha_reporte));
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
    
    /***
     * 
     * @param fecha_reporte
     */
    public void selectReportFromDialog(Date fecha_reporte) {
        
        RequestContext.getCurrentInstance().closeDialog(fecha_reporte);
    }
            
    /**
     * Metodo para subir la imagen al servidor
     * @param event 
     */
    public void subirImagen(FileUploadEvent event){
        message = new FacesMessage();
        this.selectedAplOperador = new AplOperador();
        try {
            this.selectedAplOperador.setImagen_firma(event.getFile().getContents());
//            String imagen_firma = MyUtilJsf.guardaBlobEnFicheroTemporal(aplOperadorBean.this.selectedAplOperador.getImagen_firma(), event.getFile().getFileName());
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            message.setSummary("Imagen subida exitosamente");
        } catch (Exception e) {
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Problemas al subir la imagen");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha Selected", format.format(event.getObject())));
    }
    
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
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
    
    public Date getFecha_reporte() {
        return fecha_reporte;
    }

    public void setFecha_reporte(Date fecha_reporte) {
        this.fecha_reporte = fecha_reporte;
    }

    public String getClaveNueva() {
        return claveNueva;
    }

    public void setClaveNueva(String claveNueva) {
        this.claveNueva = claveNueva;
    }
    
}