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
public class ConceptoPago implements Serializable {
    
    private int id;
    private int id_depende;
    private int n_pago_concepto;
    private int id_documen;
    private int n_apl_conce_tipo;
    private int n_apl_conce_liq;
    private int n_apl_grupo;
    private int n_apl_perio_pago;
    private int n_apl_cta_base_db;
    private int n_apl_cta_base_cr;
    
    private int n_apl_cta_sufijo_db;
    private int n_apl_cta_sufijo_cr;
    private int n_apl_uni_medida;
    
    private String nombre;
    private String nombre_corto;
    private String descripcion;
    
    private String nom_apl_conce_tipo;
    private String nom_apl_grupo;
    private String nom_apl_conce_liq;
    private String nom_apl_perio_pago;
    private String nom_apl_cta_base_db;
    private String nom_apl_cta_base_cr;
    private String nom_apl_cta_sufijo_db;
    private String nom_apl_cta_sufijo_cr;
    private String nom_apl_uni_medida;
    
    private float factor_x_100;
    private float cantidad;
    private float vr_concepto;
    private float cantidad_minima;
    private float cantidad_maxima;
    private float valor_minimo;
    private float valor_maximo;

    private int si_cuenta_costo;
    private int si_puc_base_db;
    private int si_puc_base_cr;
    private int si_control_dia;
    private int si_pago_cierre;
    private int si_sal_integral;
    private int si_sal_basico;
    private int si_interfaz;
    private int si_a_volante;
    private int si_presenta_can;
    private int si_sal_variable;
    private int si_cesantia;
    private int si_prima;
    private int si_vacacion;
    private int si_auxilio_tra;
    private int si_aporte_pos;
    private int si_aporte_fdp;
    private int si_aporte_arl;
    private int si_aporte_para;
    
    private Boolean lsi_cuenta_costo;
    private Boolean lsi_puc_base_db;
    private Boolean lsi_puc_base_cr;
    private Boolean lsi_control_dia;
    private Boolean lsi_pago_cierre;
    private Boolean lsi_sal_integral;
    private Boolean lsi_sal_basico;
    private Boolean lsi_interfaz;
    private Boolean lsi_a_volante;
    private Boolean lsi_presenta_can;
    private Boolean lsi_sal_variable;
    private Boolean lsi_cesantia;
    private Boolean lsi_prima;
    private Boolean lsi_vacacion;
    private Boolean lsi_auxilio_tra;
    private Boolean lsi_aporte_pos;
    private Boolean lsi_aporte_fdp;
    private Boolean lsi_aporte_arl;
    private Boolean lsi_aporte_para;
    private Boolean lCtaBaseDB;
    private Boolean lCtaBaseCR;
    
    private String si_es_cuenta_costo;
    private String si_es_puc_base_db;
    private String si_es_puc_base_cr;
    private String si_es_control_dia;
    private String si_es_pago_cierre;
    private String si_es_sal_integral;
    private String si_es_sal_basico;
    private String si_es_interfaz;
    private String si_es_a_volante;
    private String si_es_presenta_can;
    private String si_es_sal_variable;
    private String si_es_cesantia;
    private String si_es_prima;
    private String si_es_vacacion;
    private String si_es_auxilio_tra;
    private String si_es_aporte_pos;
    private String si_es_aporte_fdp;
    private String si_es_aporte_arl;
    private String si_es_aporte_para;
    
    private String cuenta_numero_db;
    private String cuenta_nombre_db;
    private String cuenta_nombre_depende_db;
    private String cuenta_depende_db;
    private String cuenta_naturaleza_db;
    private String cuenta_nivel_db;
    private String cuenta_afectable_db;
    
    private String cuenta_numero_cr;
    private String cuenta_nombre_cr;
    private String cuenta_nombre_depende_cr;
    private String cuenta_depende_cr;
    private String cuenta_naturaleza_cr;
    private String cuenta_nivel_cr;
    private String cuenta_afectable_cr;
    
    private Date fecha;
    private Date fecha_actual;
    private Date fec_desde;
    private Date fec_hasta;

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

    public int getN_pago_concepto() {
        return n_pago_concepto;
    }

    public void setN_pago_concepto(int n_pago_concepto) {
        this.n_pago_concepto = n_pago_concepto;
    }

    public int getId_documen() {
        return id_documen;
    }

    public void setId_documen(int id_documen) {
        this.id_documen = id_documen;
    }

    public int getN_apl_conce_tipo() {
        return n_apl_conce_tipo;
    }

    public void setN_apl_conce_tipo(int n_apl_conce_tipo) {
        this.n_apl_conce_tipo = n_apl_conce_tipo;
    }

    public int getN_apl_conce_liq() {
        return n_apl_conce_liq;
    }

    public void setN_apl_conce_liq(int n_apl_conce_liq) {
        this.n_apl_conce_liq = n_apl_conce_liq;
    }

    public int getN_apl_grupo() {
        return n_apl_grupo;
    }

    public void setN_apl_grupo(int n_apl_grupo) {
        this.n_apl_grupo = n_apl_grupo;
    }

    public int getN_apl_perio_pago() {
        return n_apl_perio_pago;
    }

    public void setN_apl_perio_pago(int n_apl_perio_pago) {
        this.n_apl_perio_pago = n_apl_perio_pago;
    }

    public int getN_apl_cta_base_db() {
        return n_apl_cta_base_db;
    }

    public void setN_apl_cta_base_db(int n_apl_cta_base_db) {
        this.n_apl_cta_base_db = n_apl_cta_base_db;
    }

    public int getN_apl_cta_base_cr() {
        return n_apl_cta_base_cr;
    }

    public void setN_apl_cta_base_cr(int n_apl_cta_base_cr) {
        this.n_apl_cta_base_cr = n_apl_cta_base_cr;
    }

    public int getN_apl_cta_sufijo_db() {
        return n_apl_cta_sufijo_db;
    }

    public void setN_apl_cta_sufijo_db(int n_apl_cta_sufijo_db) {
        this.n_apl_cta_sufijo_db = n_apl_cta_sufijo_db;
    }

    public int getN_apl_cta_sufijo_cr() {
        return n_apl_cta_sufijo_cr;
    }

    public void setN_apl_cta_sufijo_cr(int n_apl_cta_sufijo_cr) {
        this.n_apl_cta_sufijo_cr = n_apl_cta_sufijo_cr;
    }

    public int getN_apl_uni_medida() {
        return n_apl_uni_medida;
    }

    public void setN_apl_uni_medida(int n_apl_uni_medida) {
        this.n_apl_uni_medida = n_apl_uni_medida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_corto() {
        return nombre_corto;
    }

    public void setNombre_corto(String nombre_corto) {
        this.nombre_corto = nombre_corto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNom_apl_conce_tipo() {
        return nom_apl_conce_tipo;
    }

    public void setNom_apl_conce_tipo(String nom_apl_conce_tipo) {
        this.nom_apl_conce_tipo = nom_apl_conce_tipo;
    }

    public String getNom_apl_grupo() {
        return nom_apl_grupo;
    }

    public void setNom_apl_grupo(String nom_apl_grupo) {
        this.nom_apl_grupo = nom_apl_grupo;
    }

    public String getNom_apl_conce_liq() {
        return nom_apl_conce_liq;
    }

    public void setNom_apl_conce_liq(String nom_apl_conce_liq) {
        this.nom_apl_conce_liq = nom_apl_conce_liq;
    }

    public String getNom_apl_perio_pago() {
        return nom_apl_perio_pago;
    }

    public void setNom_apl_perio_pago(String nom_apl_perio_pago) {
        this.nom_apl_perio_pago = nom_apl_perio_pago;
    }

    public String getNom_apl_cta_base_db() {
        return nom_apl_cta_base_db;
    }

    public void setNom_apl_cta_base_db(String nom_apl_cta_base_db) {
        this.nom_apl_cta_base_db = nom_apl_cta_base_db;
    }

    public String getNom_apl_cta_base_cr() {
        return nom_apl_cta_base_cr;
    }

    public void setNom_apl_cta_base_cr(String nom_apl_cta_base_cr) {
        this.nom_apl_cta_base_cr = nom_apl_cta_base_cr;
    }

    public String getNom_apl_cta_sufijo_db() {
        return nom_apl_cta_sufijo_db;
    }

    public void setNom_apl_cta_sufijo_db(String nom_apl_cta_sufijo_db) {
        this.nom_apl_cta_sufijo_db = nom_apl_cta_sufijo_db;
    }

    public String getNom_apl_cta_sufijo_cr() {
        return nom_apl_cta_sufijo_cr;
    }

    public void setNom_apl_cta_sufijo_cr(String nom_apl_cta_sufijo_cr) {
        this.nom_apl_cta_sufijo_cr = nom_apl_cta_sufijo_cr;
    }

    public String getNom_apl_uni_medida() {
        return nom_apl_uni_medida;
    }

    public void setNom_apl_uni_medida(String nom_apl_uni_medida) {
        this.nom_apl_uni_medida = nom_apl_uni_medida;
    }

    public float getFactor_x_100() {
        return factor_x_100;
    }

    public void setFactor_x_100(float factor_x_100) {
        this.factor_x_100 = factor_x_100;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getVr_concepto() {
        return vr_concepto;
    }

    public void setVr_concepto(float vr_concepto) {
        this.vr_concepto = vr_concepto;
    }

    public float getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(float cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public float getCantidad_maxima() {
        return cantidad_maxima;
    }

    public void setCantidad_maxima(float cantidad_maxima) {
        this.cantidad_maxima = cantidad_maxima;
    }

    public float getValor_minimo() {
        return valor_minimo;
    }

    public void setValor_minimo(float valor_minimo) {
        this.valor_minimo = valor_minimo;
    }

    public float getValor_maximo() {
        return valor_maximo;
    }

    public void setValor_maximo(float valor_maximo) {
        this.valor_maximo = valor_maximo;
    }

    public int getSi_cuenta_costo() {
        return si_cuenta_costo;
    }

    public void setSi_cuenta_costo(int si_cuenta_costo) {
        this.si_cuenta_costo = si_cuenta_costo;
    }

    public int getSi_puc_base_db() {
        return si_puc_base_db;
    }

    public void setSi_puc_base_db(int si_puc_base_db) {
        this.si_puc_base_db = si_puc_base_db;
    }

    public int getSi_puc_base_cr() {
        return si_puc_base_cr;
    }

    public void setSi_puc_base_cr(int si_puc_base_cr) {
        this.si_puc_base_cr = si_puc_base_cr;
    }

    public int getSi_control_dia() {
        return si_control_dia;
    }

    public void setSi_control_dia(int si_control_dia) {
        this.si_control_dia = si_control_dia;
    }

    public int getSi_pago_cierre() {
        return si_pago_cierre;
    }

    public void setSi_pago_cierre(int si_pago_cierre) {
        this.si_pago_cierre = si_pago_cierre;
    }

    public int getSi_sal_integral() {
        return si_sal_integral;
    }

    public void setSi_sal_integral(int si_sal_integral) {
        this.si_sal_integral = si_sal_integral;
    }

    public int getSi_sal_basico() {
        return si_sal_basico;
    }

    public void setSi_sal_basico(int si_sal_basico) {
        this.si_sal_basico = si_sal_basico;
    }

    public int getSi_interfaz() {
        return si_interfaz;
    }

    public void setSi_interfaz(int si_interfaz) {
        this.si_interfaz = si_interfaz;
    }

    public int getSi_a_volante() {
        return si_a_volante;
    }

    public void setSi_a_volante(int si_a_volante) {
        this.si_a_volante = si_a_volante;
    }

    public int getSi_presenta_can() {
        return si_presenta_can;
    }

    public void setSi_presenta_can(int si_presenta_can) {
        this.si_presenta_can = si_presenta_can;
    }

    public int getSi_sal_variable() {
        return si_sal_variable;
    }

    public void setSi_sal_variable(int si_sal_variable) {
        this.si_sal_variable = si_sal_variable;
    }

    public int getSi_cesantia() {
        return si_cesantia;
    }

    public void setSi_cesantia(int si_cesantia) {
        this.si_cesantia = si_cesantia;
    }

    public int getSi_prima() {
        return si_prima;
    }

    public void setSi_prima(int si_prima) {
        this.si_prima = si_prima;
    }

    public int getSi_vacacion() {
        return si_vacacion;
    }

    public void setSi_vacacion(int si_vacacion) {
        this.si_vacacion = si_vacacion;
    }

    public int getSi_auxilio_tra() {
        return si_auxilio_tra;
    }

    public void setSi_auxilio_tra(int si_auxilio_tra) {
        this.si_auxilio_tra = si_auxilio_tra;
    }

    public int getSi_aporte_pos() {
        return si_aporte_pos;
    }

    public void setSi_aporte_pos(int si_aporte_pos) {
        this.si_aporte_pos = si_aporte_pos;
    }

    public int getSi_aporte_fdp() {
        return si_aporte_fdp;
    }

    public void setSi_aporte_fdp(int si_aporte_fdp) {
        this.si_aporte_fdp = si_aporte_fdp;
    }

    public int getSi_aporte_arl() {
        return si_aporte_arl;
    }

    public void setSi_aporte_arl(int si_aporte_arl) {
        this.si_aporte_arl = si_aporte_arl;
    }

    public int getSi_aporte_para() {
        return si_aporte_para;
    }

    public void setSi_aporte_para(int si_aporte_para) {
        this.si_aporte_para = si_aporte_para;
    }

    public Boolean getLsi_cuenta_costo() {
        return lsi_cuenta_costo;
    }

    public void setLsi_cuenta_costo(Boolean lsi_cuenta_costo) {
        this.lsi_cuenta_costo = lsi_cuenta_costo;
    }

    public Boolean getLsi_puc_base_db() {
        return lsi_puc_base_db;
    }

    public void setLsi_puc_base_db(Boolean lsi_puc_base_db) {
        this.lsi_puc_base_db = lsi_puc_base_db;
    }

    public Boolean getLsi_puc_base_cr() {
        return lsi_puc_base_cr;
    }

    public void setLsi_puc_base_cr(Boolean lsi_puc_base_cr) {
        this.lsi_puc_base_cr = lsi_puc_base_cr;
    }

    public Boolean getLsi_control_dia() {
        return lsi_control_dia;
    }

    public void setLsi_control_dia(Boolean lsi_control_dia) {
        this.lsi_control_dia = lsi_control_dia;
    }

    public Boolean getLsi_pago_cierre() {
        return lsi_pago_cierre;
    }

    public void setLsi_pago_cierre(Boolean lsi_pago_cierre) {
        this.lsi_pago_cierre = lsi_pago_cierre;
    }

    public Boolean getLsi_sal_integral() {
        return lsi_sal_integral;
    }

    public void setLsi_sal_integral(Boolean lsi_sal_integral) {
        this.lsi_sal_integral = lsi_sal_integral;
    }

    public Boolean getLsi_sal_basico() {
        return lsi_sal_basico;
    }

    public void setLsi_sal_basico(Boolean lsi_sal_basico) {
        this.lsi_sal_basico = lsi_sal_basico;
    }

    public Boolean getLsi_interfaz() {
        return lsi_interfaz;
    }

    public void setLsi_interfaz(Boolean lsi_interfaz) {
        this.lsi_interfaz = lsi_interfaz;
    }

    public Boolean getLsi_a_volante() {
        return lsi_a_volante;
    }

    public void setLsi_a_volante(Boolean lsi_a_volante) {
        this.lsi_a_volante = lsi_a_volante;
    }

    public Boolean getLsi_presenta_can() {
        return lsi_presenta_can;
    }

    public void setLsi_presenta_can(Boolean lsi_presenta_can) {
        this.lsi_presenta_can = lsi_presenta_can;
    }

    public Boolean getLsi_sal_variable() {
        return lsi_sal_variable;
    }

    public void setLsi_sal_variable(Boolean lsi_sal_variable) {
        this.lsi_sal_variable = lsi_sal_variable;
    }

    public Boolean getLsi_cesantia() {
        return lsi_cesantia;
    }

    public void setLsi_cesantia(Boolean lsi_cesantia) {
        this.lsi_cesantia = lsi_cesantia;
    }

    public Boolean getLsi_prima() {
        return lsi_prima;
    }

    public void setLsi_prima(Boolean lsi_prima) {
        this.lsi_prima = lsi_prima;
    }

    public Boolean getLsi_vacacion() {
        return lsi_vacacion;
    }

    public void setLsi_vacacion(Boolean lsi_vacacion) {
        this.lsi_vacacion = lsi_vacacion;
    }

    public Boolean getLsi_auxilio_tra() {
        return lsi_auxilio_tra;
    }

    public void setLsi_auxilio_tra(Boolean lsi_auxilio_tra) {
        this.lsi_auxilio_tra = lsi_auxilio_tra;
    }

    public Boolean getLsi_aporte_pos() {
        return lsi_aporte_pos;
    }

    public void setLsi_aporte_pos(Boolean lsi_aporte_pos) {
        this.lsi_aporte_pos = lsi_aporte_pos;
    }

    public Boolean getLsi_aporte_fdp() {
        return lsi_aporte_fdp;
    }

    public void setLsi_aporte_fdp(Boolean lsi_aporte_fdp) {
        this.lsi_aporte_fdp = lsi_aporte_fdp;
    }

    public Boolean getLsi_aporte_arl() {
        return lsi_aporte_arl;
    }

    public void setLsi_aporte_arl(Boolean lsi_aporte_arl) {
        this.lsi_aporte_arl = lsi_aporte_arl;
    }

    public Boolean getLsi_aporte_para() {
        return lsi_aporte_para;
    }

    public void setLsi_aporte_para(Boolean lsi_aporte_para) {
        this.lsi_aporte_para = lsi_aporte_para;
    }

    public Boolean getlCtaBaseDB() {
        return lCtaBaseDB;
    }

    public void setlCtaBaseDB(Boolean lCtaBaseDB) {
        this.lCtaBaseDB = lCtaBaseDB;
    }

    public Boolean getlCtaBaseCR() {
        return lCtaBaseCR;
    }

    public void setlCtaBaseCR(Boolean lCtaBaseCR) {
        this.lCtaBaseCR = lCtaBaseCR;
    }

    public String getSi_es_cuenta_costo() {
        return si_es_cuenta_costo;
    }

    public void setSi_es_cuenta_costo(String si_es_cuenta_costo) {
        this.si_es_cuenta_costo = si_es_cuenta_costo;
    }

    public String getSi_es_puc_base_db() {
        return si_es_puc_base_db;
    }

    public void setSi_es_puc_base_db(String si_es_puc_base_db) {
        this.si_es_puc_base_db = si_es_puc_base_db;
    }

    public String getSi_es_puc_base_cr() {
        return si_es_puc_base_cr;
    }

    public void setSi_es_puc_base_cr(String si_es_puc_base_cr) {
        this.si_es_puc_base_cr = si_es_puc_base_cr;
    }

    public String getSi_es_control_dia() {
        return si_es_control_dia;
    }

    public void setSi_es_control_dia(String si_es_control_dia) {
        this.si_es_control_dia = si_es_control_dia;
    }

    public String getSi_es_pago_cierre() {
        return si_es_pago_cierre;
    }

    public void setSi_es_pago_cierre(String si_es_pago_cierre) {
        this.si_es_pago_cierre = si_es_pago_cierre;
    }

    public String getSi_es_sal_integral() {
        return si_es_sal_integral;
    }

    public void setSi_es_sal_integral(String si_es_sal_integral) {
        this.si_es_sal_integral = si_es_sal_integral;
    }

    public String getSi_es_sal_basico() {
        return si_es_sal_basico;
    }

    public void setSi_es_sal_basico(String si_es_sal_basico) {
        this.si_es_sal_basico = si_es_sal_basico;
    }

    public String getSi_es_interfaz() {
        return si_es_interfaz;
    }

    public void setSi_es_interfaz(String si_es_interfaz) {
        this.si_es_interfaz = si_es_interfaz;
    }

    public String getSi_es_a_volante() {
        return si_es_a_volante;
    }

    public void setSi_es_a_volante(String si_es_a_volante) {
        this.si_es_a_volante = si_es_a_volante;
    }

    public String getSi_es_presenta_can() {
        return si_es_presenta_can;
    }

    public void setSi_es_presenta_can(String si_es_presenta_can) {
        this.si_es_presenta_can = si_es_presenta_can;
    }

    public String getSi_es_sal_variable() {
        return si_es_sal_variable;
    }

    public void setSi_es_sal_variable(String si_es_sal_variable) {
        this.si_es_sal_variable = si_es_sal_variable;
    }

    public String getSi_es_cesantia() {
        return si_es_cesantia;
    }

    public void setSi_es_cesantia(String si_es_cesantia) {
        this.si_es_cesantia = si_es_cesantia;
    }

    public String getSi_es_prima() {
        return si_es_prima;
    }

    public void setSi_es_prima(String si_es_prima) {
        this.si_es_prima = si_es_prima;
    }

    public String getSi_es_vacacion() {
        return si_es_vacacion;
    }

    public void setSi_es_vacacion(String si_es_vacacion) {
        this.si_es_vacacion = si_es_vacacion;
    }

    public String getSi_es_auxilio_tra() {
        return si_es_auxilio_tra;
    }

    public void setSi_es_auxilio_tra(String si_es_auxilio_tra) {
        this.si_es_auxilio_tra = si_es_auxilio_tra;
    }

    public String getSi_es_aporte_pos() {
        return si_es_aporte_pos;
    }

    public void setSi_es_aporte_pos(String si_es_aporte_pos) {
        this.si_es_aporte_pos = si_es_aporte_pos;
    }

    public String getSi_es_aporte_fdp() {
        return si_es_aporte_fdp;
    }

    public void setSi_es_aporte_fdp(String si_es_aporte_fdp) {
        this.si_es_aporte_fdp = si_es_aporte_fdp;
    }

    public String getSi_es_aporte_arl() {
        return si_es_aporte_arl;
    }

    public void setSi_es_aporte_arl(String si_es_aporte_arl) {
        this.si_es_aporte_arl = si_es_aporte_arl;
    }

    public String getSi_es_aporte_para() {
        return si_es_aporte_para;
    }

    public void setSi_es_aporte_para(String si_es_aporte_para) {
        this.si_es_aporte_para = si_es_aporte_para;
    }

    public String getCuenta_numero_db() {
        return cuenta_numero_db;
    }

    public void setCuenta_numero_db(String cuenta_numero_db) {
        this.cuenta_numero_db = cuenta_numero_db;
    }

    public String getCuenta_nombre_db() {
        return cuenta_nombre_db;
    }

    public void setCuenta_nombre_db(String cuenta_nombre_db) {
        this.cuenta_nombre_db = cuenta_nombre_db;
    }

    public String getCuenta_nombre_depende_db() {
        return cuenta_nombre_depende_db;
    }

    public void setCuenta_nombre_depende_db(String cuenta_nombre_depende_db) {
        this.cuenta_nombre_depende_db = cuenta_nombre_depende_db;
    }

    public String getCuenta_depende_db() {
        return cuenta_depende_db;
    }

    public void setCuenta_depende_db(String cuenta_depende_db) {
        this.cuenta_depende_db = cuenta_depende_db;
    }

    public String getCuenta_naturaleza_db() {
        return cuenta_naturaleza_db;
    }

    public void setCuenta_naturaleza_db(String cuenta_naturaleza_db) {
        this.cuenta_naturaleza_db = cuenta_naturaleza_db;
    }

    public String getCuenta_nivel_db() {
        return cuenta_nivel_db;
    }

    public void setCuenta_nivel_db(String cuenta_nivel_db) {
        this.cuenta_nivel_db = cuenta_nivel_db;
    }

    public String getCuenta_afectable_db() {
        return cuenta_afectable_db;
    }

    public void setCuenta_afectable_db(String cuenta_afectable_db) {
        this.cuenta_afectable_db = cuenta_afectable_db;
    }

    public String getCuenta_numero_cr() {
        return cuenta_numero_cr;
    }

    public void setCuenta_numero_cr(String cuenta_numero_cr) {
        this.cuenta_numero_cr = cuenta_numero_cr;
    }

    public String getCuenta_nombre_cr() {
        return cuenta_nombre_cr;
    }

    public void setCuenta_nombre_cr(String cuenta_nombre_cr) {
        this.cuenta_nombre_cr = cuenta_nombre_cr;
    }

    public String getCuenta_nombre_depende_cr() {
        return cuenta_nombre_depende_cr;
    }

    public void setCuenta_nombre_depende_cr(String cuenta_nombre_depende_cr) {
        this.cuenta_nombre_depende_cr = cuenta_nombre_depende_cr;
    }

    public String getCuenta_depende_cr() {
        return cuenta_depende_cr;
    }

    public void setCuenta_depende_cr(String cuenta_depende_cr) {
        this.cuenta_depende_cr = cuenta_depende_cr;
    }

    public String getCuenta_naturaleza_cr() {
        return cuenta_naturaleza_cr;
    }

    public void setCuenta_naturaleza_cr(String cuenta_naturaleza_cr) {
        this.cuenta_naturaleza_cr = cuenta_naturaleza_cr;
    }

    public String getCuenta_nivel_cr() {
        return cuenta_nivel_cr;
    }

    public void setCuenta_nivel_cr(String cuenta_nivel_cr) {
        this.cuenta_nivel_cr = cuenta_nivel_cr;
    }

    public String getCuenta_afectable_cr() {
        return cuenta_afectable_cr;
    }

    public void setCuenta_afectable_cr(String cuenta_afectable_cr) {
        this.cuenta_afectable_cr = cuenta_afectable_cr;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
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

}