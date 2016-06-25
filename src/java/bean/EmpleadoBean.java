/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EmpleadoDao;
import dao.EmpleadoDaoImpl;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Empleado;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class EmpleadoBean implements Serializable{

    private static final long serialVersionUID = -8183789415603381848L;
    
    private List<Empleado> lsEmpleados;  
    private Empleado empleado = new Empleado(); ; 
    
    String password;
     
    String msgEx = null;
    FacesMessage message;
    String msg;
    
    /**
     * Metodo para hacer reset al formulario
     */
    public void resetFormulario(){
        this.empleado = new Empleado();
    }

    public List<Empleado> getLsEmpleados() {
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        this.lsEmpleados = new ArrayList<>();
        this.lsEmpleados = empleadoDao.findEmleadoContratar();
        return lsEmpleados;
    }

    public void setLsEmpleados(List<Empleado> lsEmpleados) {
        this.lsEmpleados = lsEmpleados;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public void btnContratoLaboral(ActionEvent actionEvent) {
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();

        // Nombre del reporte JasperSoft
        String archivoJasper = "ContratoLaboral" + ".jasper";
        // Nombre del reporte que se generara
        String archivoSale   = "ContratoLaboral";
        

//        empleadoDao.contratoLaboral(empleado, archivoJasper, archivoSale);

    }
    
    public void contratoLaboral() throws IOException {
        FacesContext contex = FacesContext.getCurrentInstance();
        
        // Redirecciona Pagina
        contex.getExternalContext().redirect("operadoresReport.xhtml");
    }    
}
