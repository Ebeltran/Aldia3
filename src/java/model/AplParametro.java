/*
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
public class AplParametro implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 2923513525360033328L;
    private int n_parametro;
    private int n_orden;
    private String denominacion;
    private String importe;
    private String descripcion;
    private Date fec_desde;
    private Date fec_hasta;
    
    private Date fecha_cambio;
    
    private String cfec_desde;
    private String cfec_hasta;
    private String mensaje;
    
    
    public String empresa_nombre;
    public String empresa_nit;
    public String empresa_direccion;
    public String empresa_telefono1;
    public String empresa_telefono2;
    public String empresa_telefax;
    public String empresa_ciudad;
    public String empresa_logo;
    public String empresa_marca_agua;

    public AplParametro() {
    }

    public int getN_parametro() {
        return n_parametro;
    }

    public void setN_parametro(int n_parametro) {
        this.n_parametro = n_parametro;
    }

    public int getN_orden() {
        return n_orden;
    }

    public void setN_orden(int n_orden) {
        this.n_orden = n_orden;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFec_desde() {
        return fec_desde;
    }

    public void setFec_desde(Date fec_desde) {
        this.fec_desde = fec_desde;
    }

    public Date getFec_hasta() {
        return fec_hasta;
    }

    public void setFec_hasta(Date fec_hasta) {
        this.fec_hasta = fec_hasta;
    }

    public Date getFecha_cambio() {
        return fecha_cambio;
    }

    public void setFecha_cambio(Date fecha_cambio) {
        this.fecha_cambio = fecha_cambio;
    }

    public String getCfec_desde() {
        return cfec_desde;
    }

    public void setCfec_desde(String cfec_desde) {
        this.cfec_desde = cfec_desde;
    }

    public String getCfec_hasta() {
        return cfec_hasta;
    }

    public void setCfec_hasta(String cfec_hasta) {
        this.cfec_hasta = cfec_hasta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEmpresa_nombre() {
        return empresa_nombre;
    }

    public void setEmpresa_nombre(String empresa_nombre) {
        this.empresa_nombre = empresa_nombre;
    }

    public String getEmpresa_nit() {
        return empresa_nit;
    }

    public void setEmpresa_nit(String empresa_nit) {
        this.empresa_nit = empresa_nit;
    }

    public String getEmpresa_direccion() {
        return empresa_direccion;
    }

    public void setEmpresa_direccion(String empresa_direccion) {
        this.empresa_direccion = empresa_direccion;
    }

    public String getEmpresa_telefono1() {
        return empresa_telefono1;
    }

    public void setEmpresa_telefono1(String empresa_telefono1) {
        this.empresa_telefono1 = empresa_telefono1;
    }

    public String getEmpresa_telefono2() {
        return empresa_telefono2;
    }

    public void setEmpresa_telefono2(String empresa_telefono2) {
        this.empresa_telefono2 = empresa_telefono2;
    }

    public String getEmpresa_telefax() {
        return empresa_telefax;
    }

    public void setEmpresa_telefax(String empresa_telefax) {
        this.empresa_telefax = empresa_telefax;
    }

    public String getEmpresa_ciudad() {
        return empresa_ciudad;
    }

    public void setEmpresa_ciudad(String empresa_ciudad) {
        this.empresa_ciudad = empresa_ciudad;
    }

    public String getEmpresa_logo() {
        return empresa_logo;
    }

    public void setEmpresa_logo(String empresa_logo) {
        this.empresa_logo = empresa_logo;
    }

    public String getEmpresa_marca_agua() {
        return empresa_marca_agua;
    }

    public void setEmpresa_marca_agua(String empresa_marca_agua) {
        this.empresa_marca_agua = empresa_marca_agua;
    }

}
