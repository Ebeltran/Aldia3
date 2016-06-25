/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import util.MyReportNames;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class ArchivoNombreBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombreR;

    public String getNombreContrato() {
        return MyReportNames.nombreContrato(nombreR);
    }
    
    public String getNombreResumen() {
        return MyReportNames.nombreResumen(nombreR);
    }
    
    public String getNombreVisita() {
        return MyReportNames.nombreVisita(nombreR);
    }
    
    public String getNombreExamenIngreso() {
        return MyReportNames.nombreExamenIngreso(nombreR);
    }
    
    public String getNombreCartaBanco() {
        return MyReportNames.nombreCartaBanco(nombreR);
    }
    
}
