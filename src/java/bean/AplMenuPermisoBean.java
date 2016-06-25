/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AplMenuPermisoDao;
import dao.AplMenuPermisoDaoImpl;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.AplMenuPermiso;

@ManagedBean
@ViewScoped
public class AplMenuPermisoBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private AplMenuPermiso aplMenPer = new AplMenuPermiso();
    private List<AplMenuPermiso> lsOperador = new ArrayList<>(); 
    private List<AplMenuPermiso> lsPermiso = new ArrayList<>();
           
    String query = null;
    
    /**
     * Creates a new instance of aplMenuPermisoBean
     */
    public AplMenuPermisoBean() { 
    }

    /**
     * Metodo para hacer reset al formulario
     */
    public void resetFormulario(){
        this.aplMenPer = new AplMenuPermiso();
    }

    public List<AplMenuPermiso> getLsPermiso() {
        query = this.aplMenPer.getUsuario();
        AplMenuPermisoDao aplMenuPermisoDao = new AplMenuPermisoDaoImpl();
        this.lsPermiso = new ArrayList<>();
        this.lsPermiso = aplMenuPermisoDao.findOperOne(query);
        return lsPermiso;
    }

    public List<AplMenuPermiso> getLsOperador() {
        query = this.aplMenPer.getUsuario();
        AplMenuPermisoDao aplMenuPermisoDao = new AplMenuPermisoDaoImpl();
        this.lsOperador = new ArrayList<>(); 
        this.lsOperador = aplMenuPermisoDao.findOper();
        return lsOperador;
    }
  
    public void btnUpdateAplMenuPermiso(ActionEvent actionEvent) {
        AplMenuPermisoDao aplMenuPermisoDao = new AplMenuPermisoDaoImpl();
        boolean Ok = aplMenuPermisoDao.updatePer(lsPermiso);
        String msg;
        if (Ok ) {
            msg = "Actualizados permisos para " + this.aplMenPer.getNombre();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "No se actualizado permisos para " + this.aplMenPer.getUsuario();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void setAplMenPer(AplMenuPermiso aplMenPer) {
        this.aplMenPer = aplMenPer;
    }

    public void setLsOperador(List<AplMenuPermiso> lsOperador) {
        this.lsOperador = lsOperador;
    }

    public void setLsPermiso(List<AplMenuPermiso> lsPermiso) {
        this.lsPermiso = lsPermiso;
    }

}