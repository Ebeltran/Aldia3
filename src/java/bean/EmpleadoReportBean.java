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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Empleado;
import util.MyUtil;

/**
 *
 * @author Eduar
 */
@ManagedBean
@ViewScoped
public class EmpleadoReportBean implements Serializable {

    private static final long serialVersionUID = 1L; 
    private Empleado empleado = new Empleado();;
    private List<Empleado> vigentes;
    private List<Empleado> retirados;
    private List<Empleado> ingresos;
    private List<Empleado> cumpleanos;
    
    Date date = new Date();
    
    Date fecha_reporte_desde;
    Date fecha_reporte_hasta;
    boolean siReporte;
    private FacesMessage message;
    private String msgEx;
 
    public EmpleadoReportBean() {
        
        empleado = new Empleado();
        this.empleado.setLpersona(false);
        
        Calendar cal = Calendar.getInstance();
        if (this.fecha_reporte_hasta == null) {
            this.fecha_reporte_hasta = cal.getTime();
                    }            
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        this.fecha_reporte_desde = cal.getTime();
  
    }
    
    public List<Empleado> getVigentes() {
        
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        this.vigentes = new ArrayList<>();
        this.vigentes = empleadoDao.findVigentes(this.fecha_reporte_hasta);
        if (!this.vigentes.isEmpty())
            empleado.setLpersona(true);
        return vigentes;
    }

    public List<Empleado> getRetirados() {
        
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        this.retirados = new ArrayList<>();
        this.retirados = empleadoDao.findRetirados(this.fecha_reporte_desde, this.fecha_reporte_hasta);
        if (!this.retirados.isEmpty())
            empleado.setLpersona(true);
        return retirados;
    }

    public List<Empleado> getIngresos() {
        
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        this.ingresos = new ArrayList<>();
        this.ingresos = empleadoDao.findIngresos(this.fecha_reporte_desde, this.fecha_reporte_hasta);
        if (!this.ingresos.isEmpty())
            empleado.setLpersona(true);
        return ingresos;
    }

    public List<Empleado> getCumpleanos() {
        
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        this.cumpleanos = new ArrayList<>();
        this.cumpleanos = empleadoDao.findCumpleanos(this.fecha_reporte_hasta);
        if (!this.cumpleanos.isEmpty())
            empleado.setLpersona(true);
        return cumpleanos;
    }


    public void btnReportVigentes(ActionEvent actionEvent) {
        
        this.empleado.setLpersona(true);
        
    }

    public void setVigentes(List<Empleado> vigentes) {
        this.vigentes = vigentes;
    }

    public void setRetirados(List<Empleado> retirados) {
        this.retirados = retirados;
    }

    public void setIngresos(List<Empleado> ingresos) {
        this.ingresos = ingresos;
    }

    public void setCumpleanos(List<Empleado> cumpleanos) {
        this.cumpleanos = cumpleanos;
    }
    
    public void handleFecha_hasta() {
        
//        if (this.fecha_reporte_hasta != null) {
            this.empleado.setLpersona(true);
//        }
    }
    
    public Date getFecha_reporte_desde() {
        return fecha_reporte_desde;
    }

    public void setFecha_reporte_desde(Date fecha_reporte_desde) {
        this.fecha_reporte_desde = fecha_reporte_desde;
    }

    public Date getFecha_reporte_hasta() {
        return fecha_reporte_hasta;
    }

    public void setFecha_reporte_hasta(Date fecha_reporte_hasta) {
        this.fecha_reporte_hasta = fecha_reporte_hasta;
    }

    public boolean isSiReporte() {
        return siReporte;
    }

    public void setSiReporte(boolean siReporte) {
        this.siReporte = siReporte;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    /**
     * Metodo para el boton de Salir del modulo
     */
    public void resetFinalizar() {
        FacesContext aFContext = FacesContext.getCurrentInstance();
        
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
}
