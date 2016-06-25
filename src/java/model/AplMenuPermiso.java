/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author ebeltran
 */
public class AplMenuPermiso implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -9183170693123867386L;
	private int id_Menu;
    private String nombre_Menu;
    private String ruta_Jsp;
    private String ruta_Icon;
    private String ruta_Ayuda;
    private String descripcion;
    private String si_Permiso;
    private int no_Orden;
    private int tab_Menus_Id;
    private Timestamp fecha;
    private Date fec_Desde;
    private Date fec_Hasta;
    private String tipo_Menu;
    private String mensaje;
    private String usuario;
    private String nombre;
    private boolean lpermiso;
    private boolean lfestivo;
    
    public AplMenuPermiso() {
    }

    public int getId_Menu() {
        return id_Menu;
    }

    public void setId_Menu(int id_Menu) {
        this.id_Menu = id_Menu;
    }

    public String getNombre_Menu() {
        return nombre_Menu;
    }

    public void setNombre_Menu(String nombre_Menu) {
        this.nombre_Menu = nombre_Menu;
    }

    public String getRuta_Jsp() {
        return ruta_Jsp;
    }

    public void setRuta_Jsp(String ruta_Jsp) {
        this.ruta_Jsp = ruta_Jsp;
    }

    public String getRuta_Icon() {
        return ruta_Icon;
    }

    public void setRuta_Icon(String ruta_Icon) {
        this.ruta_Icon = ruta_Icon;
    }

    public String getRuta_Ayuda() {
        return ruta_Ayuda;
    }

    public void setRuta_Ayuda(String ruta_Ayuda) {
        this.ruta_Ayuda = ruta_Ayuda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSi_Permiso() {
        return si_Permiso;
    }

    public void setSi_Permiso(String si_Permiso) {
        this.si_Permiso = si_Permiso;
    }

    public int getNo_Orden() {
        return no_Orden;
    }

    public void setNo_Orden(int no_Orden) {
        this.no_Orden = no_Orden;
    }

    public int getTab_Menus_Id() {
        return tab_Menus_Id;
    }

    public void setTab_Menus_Id(int tab_Menus_Id) {
        this.tab_Menus_Id = tab_Menus_Id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Date getFec_Desde() {
        return fec_Desde;
    }

    public void setFec_Desde(Date fec_Desde) {
        this.fec_Desde = fec_Desde;
    }

    public Date getFec_Hasta() {
        return fec_Hasta;
    }

    public void setFec_Hasta(Date fec_Hasta) {
        this.fec_Hasta = fec_Hasta;
    }

    public String getTipo_Menu() {
        return tipo_Menu;
    }

    public void setTipo_Menu(String tipo_Menu) {
        this.tipo_Menu = tipo_Menu;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isLpermiso() {
        return lpermiso;
    }

    public void setLpermiso(boolean lpermiso) {
        this.lpermiso = lpermiso;
    }

    public boolean isLfestivo() {
        return lfestivo;
    }

    public void setLfestivo(boolean lfestivo) {
        this.lfestivo = lfestivo;
    }

}