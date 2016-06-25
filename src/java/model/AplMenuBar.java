/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import org.primefaces.component.menu.Menu;

/**
 *
 * @author ebeltran
 */
public class AplMenuBar implements Serializable {

    private static final long serialVersionUID = 1L;
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
    private int total;
    private String textof;

    private AplMenuBar aplMenuBar;
    private List<Menu> listaMenu;

    public AplMenuBar() {
//        this.id_Menu = 0;
//        this.nombre_Menu = "";
//        this.ruta_Jsp = "";
//        this.ruta_Icon = "";
//        this.descripcion = "";
//        this.tab_Menus_Id = 0;
//        this.tipo_Menu = "";
    }

    public AplMenuBar(int id_Menu) {
        this.id_Menu = id_Menu;
    }

    public AplMenuBar(List<Menu> listaMenu) {
        this.listaMenu = listaMenu;
    }

    public AplMenuBar(int id_Menu, String nombre_Menu, String ruta_Jsp, 
            String ruta_Icon, String descripcion, int tab_Menus_Id, String tipo_Menu) {
        this.id_Menu = id_Menu;
        this.nombre_Menu = nombre_Menu;
        this.ruta_Jsp = ruta_Jsp;
        this.ruta_Icon = ruta_Icon;
        this.descripcion = descripcion;
        this.tab_Menus_Id = tab_Menus_Id;
    }

    public AplMenuBar getAplMenuBar() {
        return aplMenuBar;
    }

    public void setAplMenuBar(AplMenuBar aplMenuBar) {
        this.aplMenuBar = aplMenuBar;
    }

    public List<Menu> getListaMenu() {
        return listaMenu;
    }

    public void setListaMenu(List<Menu> listaMenu) {
        this.listaMenu = listaMenu;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTextof() {
        return textof;
    }

    public void setTextof(String textof) {
        this.textof = textof;
    }

    public String getTipo_Menu() {
        return tipo_Menu;
    }

    public void setTipo_Menu(String tipo_Menu) {
        this.tipo_Menu = tipo_Menu;
    }
  
}