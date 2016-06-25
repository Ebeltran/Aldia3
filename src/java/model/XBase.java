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
 * @author Eduar
 */
public class XBase implements Serializable {
    
    
    private String cod;
    private String nombre;
    private String nit;
    private String clase;
    private String dv;
    private String cliente;
    private String emplead;
    private String tercero;
    private String banco;
    private String activo;
    private Date factua;
    private String cal_fis;
    private String auto_rf;
    private String pejuri;
    private String ape1;
    private String ape2;
    private String nom1;
    private String nom2;
    private String control;
    private String ta_cree;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEmplead() {
        return emplead;
    }

    public void setEmplead(String emplead) {
        this.emplead = emplead;
    }

    public String getTercero() {
        return tercero;
    }

    public void setTercero(String tercero) {
        this.tercero = tercero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Date getFactua() {
        return factua;
    }

    public void setFactua(Date factua) {
        this.factua = factua;
    }

    public String getCal_fis() {
        return cal_fis;
    }

    public void setCal_fis(String cal_fis) {
        this.cal_fis = cal_fis;
    }

    public String getAuto_rf() {
        return auto_rf;
    }

    public void setAuto_rf(String auto_rf) {
        this.auto_rf = auto_rf;
    }

    public String getPejuri() {
        return pejuri;
    }

    public void setPejuri(String pejuri) {
        this.pejuri = pejuri;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getNom1() {
        return nom1;
    }

    public void setNom1(String nom1) {
        this.nom1 = nom1;
    }

    public String getNom2() {
        return nom2;
    }

    public void setNom2(String nom2) {
        this.nom2 = nom2;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getTa_cree() {
        return ta_cree;
    }

    public void setTa_cree(String ta_cree) {
        this.ta_cree = ta_cree;
    }
    
    
}
