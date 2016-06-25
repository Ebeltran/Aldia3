/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AplOperadorDao;
import dao.AplOperadorDaoImpl;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.AplOperador;
import util.MyMailServer;
import util.MyUtil;

/**
 *
 * @author Eduar
 */
@ManagedBean
@ViewScoped
public class CambioClaveBean1 implements Serializable{

    private static final long serialVersionUID = 1L;
    private AplOperador aplOperador = new AplOperador();;
    String msg;
    String url;
    String subject;
    String from;
    String mailer;
    String nombre;
    String msgMail;
    FacesMessage message;
    Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    private String msgEx;
    
    
    public CambioClaveBean1() {
        
        this.aplOperador.setLogin((String) session.get("login"));
        this.aplOperador.setUsuario((String) session.get("nombreUsuario"));
        this.aplOperador.setCorreo_email((String) session.get("email"));
//        this.aplOperador.setClave("");
    
    }

    public AplOperador getAplOperador() {
        return aplOperador;
    }

    public void setAplOperador(AplOperador aplOperador) {
        this.aplOperador = aplOperador;
    }
    
    public void btnCambioClave() throws Exception  {
        
        AplOperadorDao aplOperadorDao = new AplOperadorDaoImpl();

        this.aplOperador.setPassword(this.aplOperador.getClave());
        
        msg = aplOperadorDao.cambioClave(aplOperador);
        if (msg.equals("Clave cambiada Satisfactoriamente")) {
            
            /*Envio Correo*/
            url = MyUtil.basePublicUrl();
            nombre = this.aplOperador.getUsuario();
            subject = "Cambio de Clave en Aldia3 " + nombre;
            from = this.aplOperador.getCorreo_email();
            StringBuilder body = new StringBuilder();
            body.append("Hola ").append(nombre).append("<br/><br/>");
            body.append("Nos permitimos confirmale que se ha actualizado la clave en AldiaSOft<br/><br/>");
            body.append("No olvide copie y pegue el siguiente enlace en Mozilla FireFox <br/>").append(url).append("<br/><br/>");
            body.append("Usuario: ").append(this.aplOperador.getUsuario()).append("<br/>");
            body.append("Clave: ").append(this.aplOperador.getClave()).append("<br/><br/>");
            body.append("Cordial saludo<br/><br/>");
            body.append((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombreUsuario"));
            body.append("<br/>");
            body.append((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("emp_nombre"));
                        
            MyMailServer myMailServer = new MyMailServer();
            
            mailer = "AldiaSoft Creacion de Cuenta";
            msgMail = myMailServer.sendMail(this.aplOperador.getCorreo_email(), from, subject, mailer, body.toString());
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, nombre);
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, nombre);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
        }
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        
//        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
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
    
}
