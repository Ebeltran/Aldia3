/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ebeltran
 */
public class JaspRep implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -150189046368034252L;
	private Date fecha_reporte;

    public JaspRep() {
    }

    public Date getFecha_reporte() {
        return fecha_reporte;
    }

    public void setFecha_reporte(Date fecha_reporte) {
        this.fecha_reporte = fecha_reporte;
    }
    
    
}
