/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AplOperadorDao;
import dao.AplOperadorDaoImpl;
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
public class CambioClaveBean implements Serializable{

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
    
    
    public CambioClaveBean() {
        
        this.aplOperador.setLogin((String) session.get("login"));
        this.aplOperador.setUsuario((String) session.get("nombreUsuario"));
        this.aplOperador.setCorreo_email((String) session.get("email"));
        this.aplOperador.setPassword("");
    
    }

    public AplOperador getAplOperador() {
        
//        
//
//        this.aplOperador = new AplOperador();
//                
//        this.aplOperador.setLogin((String) session.get("login"));
//        this.aplOperador.setUsuario((String) session.get("nombreUsuario"));
//        this.aplOperador.setCorreo_email((String) session.get("email"));
//        this.aplOperador.setPassword("");
        
        return aplOperador;
    }

    public void setAplOperador(AplOperador aplOperador) {
        this.aplOperador = aplOperador;
    }
 
    public void btnCambioClave() throws Exception  {
        
        AplOperadorDao aplOperadorDao = new AplOperadorDaoImpl();

        this.aplOperador.setClave_1(this.aplOperador.getPassword());
        
        msg = aplOperadorDao.cambioClave(aplOperador);
        if (msg.equals("Clave cambiada Satisfactoriamente")) {
            
            /*Envio Correo*/
            url = MyUtil.basePublicUrl();
            nombre = (String) session.get("nombreUsuario");
            
            subject = "Cambio de Clave en Aldia3 " + nombre;
            
            // Cuenta desde donde se enviarar el correo de confirmacion
            from = (String) session.get("email");
            
            StringBuilder body = new StringBuilder();
            body.append("Hola ").append(nombre).append("<br/>");
            body.append("Nos permitimos confirmale la clave creada para el sitio<br/><br/>");
            body.append("Copie y pegue el siguiente enlace en Mozilla FireFox ").append(url).append("<br/><br/>");
            body.append("Usuario: ").append(this.aplOperador.getUsuario()).append("<br/>");
            body.append("Clave: ").append("**********").append("<br/><br/>");
            body.append("Cordial saludo<br/><br/>");
            body.append((String) session.get("usuario"));
            body.append("<br/>");
            body.append((String) session.get("emp_nombre"));
                        
            MyMailServer myMailServer = new MyMailServer();
            
            mailer = "AldiaSoft Creacion de Cuenta";
            msgMail = myMailServer.sendMail(this.aplOperador.getCorreo_email(), from, subject, mailer, body.toString());
            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            
        }
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
}
