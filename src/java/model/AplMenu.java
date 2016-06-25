/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author ebeltran
 */
public class AplMenu implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7874325975726348543L;
	private int id_menu;
    private int tab_menus_id;
    private int no_orden;
    private String nombre_menu;
    private String ruta_jsp;
    private String ruta_icon;
    private String descripcion;
    private String ruta_ayuda;
    private String si_permiso;
    private Timestamp fecha;
    private Timestamp fec_hora;
    private String tipo_menu;
    private Timestamp fec_hasta;
    private String mensaje;
    private boolean lpermiso;
    
    public AplMenu() {
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public int getTab_menus_id() {
        return tab_menus_id;
    }

    public void setTab_menus_id(int tab_menus_id) {
        this.tab_menus_id = tab_menus_id;
    }

    public int getNo_orden() {
        return no_orden;
    }

    public void setNo_orden(int no_orden) {
        this.no_orden = no_orden;
    }

    public String getNombre_menu() {
        return nombre_menu;
    }

    public void setNombre_menu(String nombre_menu) {
        this.nombre_menu = nombre_menu;
    }

    public String getRuta_jsp() {
        return ruta_jsp;
    }

    public void setRuta_jsp(String ruta_jsp) {
        this.ruta_jsp = ruta_jsp;
    }

    public String getRuta_icon() {
        return ruta_icon;
    }

    public void setRuta_icon(String ruta_icon) {
        this.ruta_icon = ruta_icon;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuta_ayuda() {
        return ruta_ayuda;
    }

    public void setRuta_ayuda(String ruta_ayuda) {
        this.ruta_ayuda = ruta_ayuda;
    }

    public String getSi_permiso() {
        return si_permiso;
    }

    public void setSi_permiso(String si_permiso) {
        this.si_permiso = si_permiso;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Timestamp getFec_hora() {
        return fec_hora;
    }

    public void setFec_hora(Timestamp fec_hora) {
        this.fec_hora = fec_hora;
    }

    public Timestamp getFec_hasta() {
        return fec_hasta;
    }

    public void setFec_hasta(Timestamp fec_hasta) {
        this.fec_hasta = fec_hasta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo_menu() {
        return tipo_menu;
    }

    public void setTipo_menu(String tipo_menu) {
        this.tipo_menu = tipo_menu;
    }

    public boolean isLpermiso() {
        return lpermiso;
    }

    public void setLpermiso(boolean lpermiso) {
        this.lpermiso = lpermiso;
    }

}
