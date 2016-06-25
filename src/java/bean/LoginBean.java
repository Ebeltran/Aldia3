/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AplOperadorDao;
import dao.AplOperadorDaoImpl;
import dao.CiaDao;
import dao.CiaDaoImpl;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import model.AplOperador;
import model.Cia;
import org.primefaces.context.RequestContext;
import util.MyUtil;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private AplOperador aplOperador;
    private final AplOperadorDao aplOperadorDao;
    private final CiaDao ciaDao;
    boolean loggedIn = false;
    
    FacesMessage msg;
    String ruta = null;  
    
    private Cia cia;
    
    
    public LoginBean() {
        this.aplOperadorDao = new AplOperadorDaoImpl();
        if (this.aplOperador == null) {
            this.aplOperador = new AplOperador();
        }
        
        this.ciaDao = new CiaDaoImpl();
        if (this.cia == null) {
            this.cia = new Cia();
        }
    }
    
    public AplOperador getAplOperador() {
        return aplOperador;
    }
    
    public void setAplOperador(AplOperador aplOperador) {
        this.aplOperador = aplOperador;
    }
    
    public void login(ActionEvent actionEvent) throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        
        List<Cia> lsCias = ciaDao.findCia();
        
        cia = lsCias.get(0);
        List<Cia> lsCiaAgencias = ciaDao.findCiaSucAll(cia.getId_agencia());
        Cia ciaAge = lsCiaAgencias.get(0);

        aplOperador.setId_agencia(cia.getId_agencia());
        
        this.aplOperador = this.aplOperadorDao.findByAplOperador(aplOperador);
        
        if (aplOperador.getId_error() == 1 || aplOperador.getId_error() == 2) {
            loggedIn = true;
            this.aplOperador.setUsuario(this.aplOperador.getLogin());
            
            StringBuilder nombresApellidos = new StringBuilder();

            if (!"".equals(this.aplOperador.getNombre_2().trim())) {
                
                nombresApellidos.append(this.aplOperador.getNombre_1().trim()).append(" ");
                nombresApellidos.append(this.aplOperador.getNombre_2());
            } else {
                nombresApellidos.append(this.aplOperador.getNombre_1().trim());
            }

            if (!"".equals(this.aplOperador.getApellido_2().trim())) {
                nombresApellidos.append(" ").append(this.aplOperador.getApellido_1().trim());
                nombresApellidos.append(" ").append(this.aplOperador.getApellido_2().trim());
            } else {
                nombresApellidos.append(" ").append(this.aplOperador.getApellido_1().trim());
            }
            this.aplOperador.setUsuario(nombresApellidos.toString());
            
            // Almacenar en la session JSF
            Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            session.put("login", this.aplOperador.getLogin());
            session.put("nombreUsuario", this.aplOperador.getUsuario());
//            session.put("firma_mecanica", this.aplOperador.getFirma_mecanica());
            session.put("email", this.aplOperador.getCorreo_email());
            session.put("fecha_sesion", this.aplOperador.getFec_ini_trabajo());
            session.put("tiempoInicial", System.currentTimeMillis());
            
            session.put("id_agencia", ciaAge.getId_agencia());
            session.put("id_almacen", ciaAge.getId_almacen());
            session.put("emp_nombre", cia.getEmp_nombre());
            session.put("emp_nit", cia.getEmp_nit());
            session.put("emp_dir", cia.getEmp_direccion());
            session.put("emp_tel1", cia.getEmp_telefono1());
            session.put("emp_tel2", cia.getEmp_telefono2());
            session.put("emp_fax", cia.getEmp_telefax());
            session.put("emp_ciudad", cia.getEmp_ciudad());
            session.put("emp_barrio", cia.getEmp_barrio());
            session.put("emp_e_mail", cia.getEmp_e_mail());
            session.put("emp_e_mail_a", cia.getEmp_e_mail_a());
            session.put("emp_logo", cia.getEmp_logo());
            session.put("emp_agua", cia.getEmp_marca_agua());
            session.put("path_imagen", MyUtil.baseUrl()+"faces/resources/images/logos/");
            
            if (aplOperador.getId_error() == 1) {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", nombresApellidos.toString());
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, nombresApellidos.toString(), 
                        "Para poder trabajar debe a cambiar clave");
            }
            
//            ruta = MyUtil.baseUrl();
            ruta = new StringBuilder().append(MyUtil.baseUrl()).append("app/inicio.xhtml").toString();
            
        } else {
            loggedIn = false;
            
            if (aplOperador.getId_error() == 3) {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, this.aplOperador.getUsuario(),
                        "No esta autirizado para trabajar en este horario");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Usuario y/o Clave no son validos");
            }
            if (this.aplOperador == null) {
                this.aplOperador = new AplOperador();
            }
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("ruta", ruta);

    }

    public void logout() {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();

        try {
            // Usar el contexto de JSF para invalidar la sesión,
            // NO EL DE SERVLETS (nada de HttpServletRequest)
            ((HttpSession) ctx.getSession(false)).invalidate();

            // Redirección de nuevo con el contexto de JSF,
            // si se usa una HttpServletResponse fallará.
            // Sin embargo, como ya está fuera del ciclo de vida 
            // de JSF se debe usar la ruta completa -_-U
            ctx.redirect(ctxPath + "/faces/login.xhtml");
        } catch (IOException ex) {
        }
    }
    
    public void logoutRedireccion() {

//        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();

        try {
            // Usar el contexto de JSF para invalidar la sesión,
            // NO EL DE SERVLETS (nada de HttpServletRequest)
            ((HttpSession) ctx.getSession(false)).invalidate();

            // Redirección de nuevo con el contexto de JSF,
            // si se usa una HttpServletResponse fallará.
            // Sin embargo, como ya está fuera del ciclo de vida 
            // de JSF se debe usar la ruta completa -_-U
            ctx.redirect(ctxPath + "/faces/login.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//    	ruta = MyUtil.basePublicUrl();
//    	
//        RequestContext context = RequestContext.getCurrentInstance();
//        
//        context.addCallbackParam("loggedIn", false);
//        context.addCallbackParam("ruta", ruta);
//        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//
//        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(loggedIn);
//        session.invalidate();
//
//        context.addCallbackParam("loggetOut", true);
//        context.addCallbackParam("ruta", ruta);
    }
    
}