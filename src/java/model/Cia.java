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
public class Cia implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7560053731311174315L;
	private int id_agencia;
    private int id_almacen;
    private String identi;
    private int n_rotulo;
    private int n_cia_estado;
    private String razon_social;
    private int n_con_moneda;
    private int n_cia_ruta;
    private int n_cia_zona;
    private int id_almacen_padre;
    private String razon_comercial;
    private int si_es_activo;
    private Date fecha_hoy;
    private Date fec_desde;
    private Date fec_hasta;
    
    private String emp_nombre;
    private String emp_nit;
    private String emp_direccion;
    private String emp_telefono;
    private String emp_telefono1;
    private String emp_telefono2;
    private String emp_telefax;
    private String emp_ciudad;
    private String emp_barrio;
    private String emp_e_mail;
    private String emp_e_mail_a;
    private String emp_logo;
    private String emp_marca_agua;
    private float emp_latitud;
    private float emp_longitud;

    public int getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(int id_agencia) {
        this.id_agencia = id_agencia;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getIdenti() {
        return identi;
    }

    public void setIdenti(String identi) {
        this.identi = identi;
    }

    public int getN_rotulo() {
        return n_rotulo;
    }

    public void setN_rotulo(int n_rotulo) {
        this.n_rotulo = n_rotulo;
    }

    public int getN_cia_estado() {
        return n_cia_estado;
    }

    public void setN_cia_estado(int n_cia_estado) {
        this.n_cia_estado = n_cia_estado;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public int getN_con_moneda() {
        return n_con_moneda;
    }

    public void setN_con_moneda(int n_con_moneda) {
        this.n_con_moneda = n_con_moneda;
    }

    public int getN_cia_ruta() {
        return n_cia_ruta;
    }

    public void setN_cia_ruta(int n_cia_ruta) {
        this.n_cia_ruta = n_cia_ruta;
    }

    public int getN_cia_zona() {
        return n_cia_zona;
    }

    public void setN_cia_zona(int n_cia_zona) {
        this.n_cia_zona = n_cia_zona;
    }

    public int getId_almacen_padre() {
        return id_almacen_padre;
    }

    public void setId_almacen_padre(int id_almacen_padre) {
        this.id_almacen_padre = id_almacen_padre;
    }

    public String getRazon_comercial() {
        return razon_comercial;
    }

    public void setRazon_comercial(String razon_comercial) {
        this.razon_comercial = razon_comercial;
    }

    public int getSi_es_activo() {
        return si_es_activo;
    }

    public void setSi_es_activo(int si_es_activo) {
        this.si_es_activo = si_es_activo;
    }

    public Date getFecha_hoy() {
        return fecha_hoy;
    }

    public void setFecha_hoy(Date fecha_hoy) {
        this.fecha_hoy = fecha_hoy;
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

    public String getEmp_nombre() {
        return emp_nombre;
    }

    public void setEmp_nombre(String emp_nombre) {
        this.emp_nombre = emp_nombre;
    }

    public String getEmp_nit() {
        return emp_nit;
    }

    public void setEmp_nit(String emp_nit) {
        this.emp_nit = emp_nit;
    }

    public String getEmp_direccion() {
        return emp_direccion;
    }

    public void setEmp_direccion(String emp_direccion) {
        this.emp_direccion = emp_direccion;
    }

    public String getEmp_telefono() {
        return emp_telefono;
    }

    public void setEmp_telefono(String emp_telefono) {
        this.emp_telefono = emp_telefono;
    }

    public String getEmp_telefono1() {
        return emp_telefono1;
    }

    public void setEmp_telefono1(String emp_telefono1) {
        this.emp_telefono1 = emp_telefono1;
    }

    public String getEmp_telefono2() {
        return emp_telefono2;
    }

    public void setEmp_telefono2(String emp_telefono2) {
        this.emp_telefono2 = emp_telefono2;
    }

    public String getEmp_telefax() {
        return emp_telefax;
    }

    public void setEmp_telefax(String emp_telefax) {
        this.emp_telefax = emp_telefax;
    }

    public String getEmp_ciudad() {
        return emp_ciudad;
    }

    public void setEmp_ciudad(String emp_ciudad) {
        this.emp_ciudad = emp_ciudad;
    }

    public String getEmp_barrio() {
        return emp_barrio;
    }

    public void setEmp_barrio(String emp_barrio) {
        this.emp_barrio = emp_barrio;
    }

    public String getEmp_e_mail() {
        return emp_e_mail;
    }

    public void setEmp_e_mail(String emp_e_mail) {
        this.emp_e_mail = emp_e_mail;
    }

    public String getEmp_e_mail_a() {
        return emp_e_mail_a;
    }

    public void setEmp_e_mail_a(String emp_e_mail_a) {
        this.emp_e_mail_a = emp_e_mail_a;
    }

    public String getEmp_logo() {
        return emp_logo;
    }

    public void setEmp_logo(String emp_logo) {
        this.emp_logo = emp_logo;
    }

    public String getEmp_marca_agua() {
        return emp_marca_agua;
    }

    public void setEmp_marca_agua(String emp_marca_agua) {
        this.emp_marca_agua = emp_marca_agua;
    }

    public float getEmp_latitud() {
        return emp_latitud;
    }

    public void setEmp_latitud(float emp_latitud) {
        this.emp_latitud = emp_latitud;
    }

    public float getEmp_longitud() {
        return emp_longitud;
    }

    public void setEmp_longitud(float emp_longitud) {
        this.emp_longitud = emp_longitud;
    }
   
}
