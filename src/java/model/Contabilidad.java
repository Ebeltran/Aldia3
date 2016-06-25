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

public class Contabilidad implements Serializable {
    
    private int id;
    private int id_depende;
    private String cuenta_numero;
    private String cuenta_nombre;
    private String cuenta_nombre_depende;
    private String cuenta_depende;
    private String cuenta_naturaleza;
    private String cuenta_nivel;
    private String cuenta_afectable;
    private Date fecha_crea;
    private Date factual;   
    
    private String si_es_cuenta_costo;
    
    private int si_cuenta_costo;
    
    private Boolean lsi_cuenta_costo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_depende() {
        return id_depende;
    }

    public void setId_depende(int id_depende) {
        this.id_depende = id_depende;
    }

    public String getCuenta_numero() {
        return cuenta_numero;
    }

    public void setCuenta_numero(String cuenta_numero) {
        this.cuenta_numero = cuenta_numero;
    }

    public String getCuenta_nombre() {
        return cuenta_nombre;
    }

    public void setCuenta_nombre(String cuenta_nombre) {
        this.cuenta_nombre = cuenta_nombre;
    }

    public String getCuenta_nombre_depende() {
        return cuenta_nombre_depende;
    }

    public void setCuenta_nombre_depende(String cuenta_nombre_depende) {
        this.cuenta_nombre_depende = cuenta_nombre_depende;
    }

    public String getCuenta_depende() {
        return cuenta_depende;
    }

    public void setCuenta_depende(String cuenta_depende) {
        this.cuenta_depende = cuenta_depende;
    }

    public String getCuenta_naturaleza() {
        return cuenta_naturaleza;
    }

    public void setCuenta_naturaleza(String cuenta_naturaleza) {
        this.cuenta_naturaleza = cuenta_naturaleza;
    }

    public String getCuenta_nivel() {
        return cuenta_nivel;
    }

    public void setCuenta_nivel(String cuenta_nivel) {
        this.cuenta_nivel = cuenta_nivel;
    }

    public String getCuenta_afectable() {
        return cuenta_afectable;
    }

    public void setCuenta_afectable(String cuenta_afectable) {
        this.cuenta_afectable = cuenta_afectable;
    }

    public Date getFecha_crea() {
        return fecha_crea;
    }

    public void setFecha_crea(Date fecha_crea) {
        this.fecha_crea = fecha_crea;
    }

    public Date getFactual() {
        return factual;
    }

    public void setFactual(Date factual) {
        this.factual = factual;
    }

    public String getSi_es_cuenta_costo() {
        return si_es_cuenta_costo;
    }

    public void setSi_es_cuenta_costo(String si_es_cuenta_costo) {
        this.si_es_cuenta_costo = si_es_cuenta_costo;
    }

    public int getSi_cuenta_costo() {
        return si_cuenta_costo;
    }

    public void setSi_cuenta_costo(int si_cuenta_costo) {
        this.si_cuenta_costo = si_cuenta_costo;
    }

    public Boolean getLsi_cuenta_costo() {
        return lsi_cuenta_costo;
    }

    public void setLsi_cuenta_costo(Boolean lsi_cuenta_costo) {
        this.lsi_cuenta_costo = lsi_cuenta_costo;
    }
    
        
}   