/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ebeltran
 */
public class AutoComp implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7429245275034482241L;
	private int n_apl_ciudad;
    private String no_apl_ciudad;
    private int n_apl_ciudad_padre;
    private String ciudad;
    private String departamento;
    private String depto;
    private String ciudad_depto;
    private String ciudad_dep;
    private float latitud;
    private float longitud;

    private int n_ciudad_nace;
    private String no_ciudad_nace;
    private int n_ciudad_padre_nace;
    private String ciudad_nace;
    private String departamento_nace;
    private String depto_nace;
    private String ciudad_depto_nace;
    private String ciudad_dep_nace;
    private float latitud_nace;
    private float longitud_nace;

    public int getN_apl_ciudad() {
        return n_apl_ciudad;
    }

    public void setN_apl_ciudad(int n_apl_ciudad) {
        this.n_apl_ciudad = n_apl_ciudad;
    }

    public String getNo_apl_ciudad() {
        return no_apl_ciudad;
    }

    public void setNo_apl_ciudad(String no_apl_ciudad) {
        this.no_apl_ciudad = no_apl_ciudad;
    }

    public int getN_apl_ciudad_padre() {
        return n_apl_ciudad_padre;
    }

    public void setN_apl_ciudad_padre(int n_apl_ciudad_padre) {
        this.n_apl_ciudad_padre = n_apl_ciudad_padre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getCiudad_depto() {
        return ciudad_depto;
    }

    public void setCiudad_depto(String ciudad_depto) {
        this.ciudad_depto = ciudad_depto;
    }

    public String getCiudad_dep() {
        return ciudad_dep;
    }

    public void setCiudad_dep(String ciudad_dep) {
        this.ciudad_dep = ciudad_dep;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public int getN_ciudad_nace() {
        return n_ciudad_nace;
    }

    public void setN_ciudad_nace(int n_ciudad_nace) {
        this.n_ciudad_nace = n_ciudad_nace;
    }

    public String getNo_ciudad_nace() {
        return no_ciudad_nace;
    }

    public void setNo_ciudad_nace(String no_ciudad_nace) {
        this.no_ciudad_nace = no_ciudad_nace;
    }

    public int getN_ciudad_padre_nace() {
        return n_ciudad_padre_nace;
    }

    public void setN_ciudad_padre_nace(int n_ciudad_padre_nace) {
        this.n_ciudad_padre_nace = n_ciudad_padre_nace;
    }

    public String getCiudad_nace() {
        return ciudad_nace;
    }

    public void setCiudad_nace(String ciudad_nace) {
        this.ciudad_nace = ciudad_nace;
    }

    public String getDepartamento_nace() {
        return departamento_nace;
    }

    public void setDepartamento_nace(String departamento_nace) {
        this.departamento_nace = departamento_nace;
    }

    public String getDepto_nace() {
        return depto_nace;
    }

    public void setDepto_nace(String depto_nace) {
        this.depto_nace = depto_nace;
    }

    public String getCiudad_depto_nace() {
        return ciudad_depto_nace;
    }

    public void setCiudad_depto_nace(String ciudad_depto_nace) {
        this.ciudad_depto_nace = ciudad_depto_nace;
    }

    public String getCiudad_dep_nace() {
        return ciudad_dep_nace;
    }

    public void setCiudad_dep_nace(String ciudad_dep_nace) {
        this.ciudad_dep_nace = ciudad_dep_nace;
    }

    public float getLatitud_nace() {
        return latitud_nace;
    }

    public void setLatitud_nace(float latitud_nace) {
        this.latitud_nace = latitud_nace;
    }

    public float getLongitud_nace() {
        return longitud_nace;
    }

    public void setLongitud_nace(float longitud_nace) {
        this.longitud_nace = longitud_nace;
    }    
    
}
