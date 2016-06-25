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
public class CentroCosto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3220573828857923581L;
	private int n_cen_costo;
    private int n_emp_jornada;
    private int n_tarifa_arl;
    private int n_apl_pago_periodo;
    private int n_cta_base;
    private int n_emp_horario;
    private String nom_centro_costo;
    private String nombre_padre;
    private int n_cen_costo_padre;
    private int nivel;
    private String costo;
    private Date fecha;
    private Date fec_ultimo_periodo;
    private String emp_jornada;
    private String nom_horario;
    private String des_horario;
    private String tarifa_arl;
    private float vr_tarifa_arl;
    private int no_dias_novedad;
    private int no_dias_liquida;
    private int no_dias_pago;
    private float no_horas_jornada;
    private float no_horas_descanso;
    private String si_es_interfaz;
    private String si_es_afectable;
    private String si_es_control_fecha;
    private String si_es_pago_jornal;
    private String si_es_pago_horas_extras;
    private String si_es_descanso;
    private String si_es_liquidar;
    private Date ho_inicio_jornada;
    private Date ho_fin_jornada;
    private Date ho_inicio_descanso;
    private Date ho_fin_descanso;
    private String identi_arl;
    private String nombre_arl;
    private String pago_periodo;
    private String nom_periodo;
    private String nom_cbase;
    private String mensaje;
    
    
    private String ho_ini_jor;
    private String ho_fin_jor;
    private String ho_ini_des;
    private String ho_fin_des;
    
    private Boolean si_interfaz;
    private Boolean si_afectable;
    private Boolean si_control_fecha;
    private Boolean si_pago_jornal;
    private Boolean si_pago_horas_extras;
    private Boolean si_descanso;
    private Boolean si_liquidar;

    public int getN_cen_costo() {
        return n_cen_costo;
    }

    public void setN_cen_costo(int n_cen_costo) {
        this.n_cen_costo = n_cen_costo;
    }

    public int getN_emp_jornada() {
        return n_emp_jornada;
    }

    public void setN_emp_jornada(int n_emp_jornada) {
        this.n_emp_jornada = n_emp_jornada;
    }

    public int getN_tarifa_arl() {
        return n_tarifa_arl;
    }

    public void setN_tarifa_arl(int n_tarifa_arl) {
        this.n_tarifa_arl = n_tarifa_arl;
    }

    public int getN_apl_pago_periodo() {
        return n_apl_pago_periodo;
    }

    public void setN_apl_pago_periodo(int n_apl_pago_periodo) {
        this.n_apl_pago_periodo = n_apl_pago_periodo;
    }

    public int getN_cta_base() {
        return n_cta_base;
    }

    public void setN_cta_base(int n_cta_base) {
        this.n_cta_base = n_cta_base;
    }

    public int getN_emp_horario() {
        return n_emp_horario;
    }

    public void setN_emp_horario(int n_emp_horario) {
        this.n_emp_horario = n_emp_horario;
    }

    public String getNom_centro_costo() {
        return nom_centro_costo;
    }

    public void setNom_centro_costo(String nom_centro_costo) {
        this.nom_centro_costo = nom_centro_costo;
    }

    public String getNombre_padre() {
        return nombre_padre;
    }

    public void setNombre_padre(String nombre_padre) {
        this.nombre_padre = nombre_padre;
    }

    public int getN_cen_costo_padre() {
        return n_cen_costo_padre;
    }

    public void setN_cen_costo_padre(int n_cen_costo_padre) {
        this.n_cen_costo_padre = n_cen_costo_padre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFec_ultimo_periodo() {
        return fec_ultimo_periodo;
    }

    public void setFec_ultimo_periodo(Date fec_ultimo_periodo) {
        this.fec_ultimo_periodo = fec_ultimo_periodo;
    }

    public String getEmp_jornada() {
        return emp_jornada;
    }

    public void setEmp_jornada(String emp_jornada) {
        this.emp_jornada = emp_jornada;
    }

    public String getNom_horario() {
        return nom_horario;
    }

    public void setNom_horario(String nom_horario) {
        this.nom_horario = nom_horario;
    }

    public String getDes_horario() {
        return des_horario;
    }

    public void setDes_horario(String des_horario) {
        this.des_horario = des_horario;
    }

    public String getTarifa_arl() {
        return tarifa_arl;
    }

    public void setTarifa_arl(String tarifa_arl) {
        this.tarifa_arl = tarifa_arl;
    }

    public float getVr_tarifa_arl() {
        return vr_tarifa_arl;
    }

    public void setVr_tarifa_arl(float vr_tarifa_arl) {
        this.vr_tarifa_arl = vr_tarifa_arl;
    }

    public int getNo_dias_novedad() {
        return no_dias_novedad;
    }

    public void setNo_dias_novedad(int no_dias_novedad) {
        this.no_dias_novedad = no_dias_novedad;
    }

    public int getNo_dias_liquida() {
        return no_dias_liquida;
    }

    public void setNo_dias_liquida(int no_dias_liquida) {
        this.no_dias_liquida = no_dias_liquida;
    }

    public int getNo_dias_pago() {
        return no_dias_pago;
    }

    public void setNo_dias_pago(int no_dias_pago) {
        this.no_dias_pago = no_dias_pago;
    }

    public float getNo_horas_jornada() {
        return no_horas_jornada;
    }

    public void setNo_horas_jornada(float no_horas_jornada) {
        this.no_horas_jornada = no_horas_jornada;
    }

    public float getNo_horas_descanso() {
        return no_horas_descanso;
    }

    public void setNo_horas_descanso(float no_horas_descanso) {
        this.no_horas_descanso = no_horas_descanso;
    }

    public String getSi_es_interfaz() {
        return si_es_interfaz;
    }

    public void setSi_es_interfaz(String si_es_interfaz) {
        this.si_es_interfaz = si_es_interfaz;
    }

    public String getSi_es_afectable() {
        return si_es_afectable;
    }

    public void setSi_es_afectable(String si_es_afectable) {
        this.si_es_afectable = si_es_afectable;
    }

    public String getSi_es_control_fecha() {
        return si_es_control_fecha;
    }

    public void setSi_es_control_fecha(String si_es_control_fecha) {
        this.si_es_control_fecha = si_es_control_fecha;
    }

    public String getSi_es_pago_jornal() {
        return si_es_pago_jornal;
    }

    public void setSi_es_pago_jornal(String si_es_pago_jornal) {
        this.si_es_pago_jornal = si_es_pago_jornal;
    }

    public String getSi_es_pago_horas_extras() {
        return si_es_pago_horas_extras;
    }

    public void setSi_es_pago_horas_extras(String si_es_pago_horas_extras) {
        this.si_es_pago_horas_extras = si_es_pago_horas_extras;
    }

    public String getSi_es_descanso() {
        return si_es_descanso;
    }

    public void setSi_es_descanso(String si_es_descanso) {
        this.si_es_descanso = si_es_descanso;
    }

    public String getSi_es_liquidar() {
        return si_es_liquidar;
    }

    public void setSi_es_liquidar(String si_es_liquidar) {
        this.si_es_liquidar = si_es_liquidar;
    }

    public Date getHo_inicio_jornada() {
        return ho_inicio_jornada;
    }

    public void setHo_inicio_jornada(Date ho_inicio_jornada) {
        this.ho_inicio_jornada = ho_inicio_jornada;
    }

    public Date getHo_fin_jornada() {
        return ho_fin_jornada;
    }

    public void setHo_fin_jornada(Date ho_fin_jornada) {
        this.ho_fin_jornada = ho_fin_jornada;
    }

    public Date getHo_inicio_descanso() {
        return ho_inicio_descanso;
    }

    public void setHo_inicio_descanso(Date ho_inicio_descanso) {
        this.ho_inicio_descanso = ho_inicio_descanso;
    }

    public Date getHo_fin_descanso() {
        return ho_fin_descanso;
    }

    public void setHo_fin_descanso(Date ho_fin_descanso) {
        this.ho_fin_descanso = ho_fin_descanso;
    }

    public String getIdenti_arl() {
        return identi_arl;
    }

    public void setIdenti_arl(String identi_arl) {
        this.identi_arl = identi_arl;
    }

    public String getNombre_arl() {
        return nombre_arl;
    }

    public void setNombre_arl(String nombre_arl) {
        this.nombre_arl = nombre_arl;
    }

    public String getPago_periodo() {
        return pago_periodo;
    }

    public void setPago_periodo(String pago_periodo) {
        this.pago_periodo = pago_periodo;
    }

    public String getNom_periodo() {
        return nom_periodo;
    }

    public void setNom_periodo(String nom_periodo) {
        this.nom_periodo = nom_periodo;
    }

    public String getNom_cbase() {
        return nom_cbase;
    }

    public void setNom_cbase(String nom_cbase) {
        this.nom_cbase = nom_cbase;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getHo_ini_jor() {
        return ho_ini_jor;
    }

    public void setHo_ini_jor(String ho_ini_jor) {
        this.ho_ini_jor = ho_ini_jor;
    }

    public String getHo_fin_jor() {
        return ho_fin_jor;
    }

    public void setHo_fin_jor(String ho_fin_jor) {
        this.ho_fin_jor = ho_fin_jor;
    }

    public String getHo_ini_des() {
        return ho_ini_des;
    }

    public void setHo_ini_des(String ho_ini_des) {
        this.ho_ini_des = ho_ini_des;
    }

    public String getHo_fin_des() {
        return ho_fin_des;
    }

    public void setHo_fin_des(String ho_fin_des) {
        this.ho_fin_des = ho_fin_des;
    }

    public Boolean getSi_interfaz() {
        return si_interfaz;
    }

    public void setSi_interfaz(Boolean si_interfaz) {
        this.si_interfaz = si_interfaz;
    }

    public Boolean getSi_afectable() {
        return si_afectable;
    }

    public void setSi_afectable(Boolean si_afectable) {
        this.si_afectable = si_afectable;
    }

    public Boolean getSi_control_fecha() {
        return si_control_fecha;
    }

    public void setSi_control_fecha(Boolean si_control_fecha) {
        this.si_control_fecha = si_control_fecha;
    }

    public Boolean getSi_pago_jornal() {
        return si_pago_jornal;
    }

    public void setSi_pago_jornal(Boolean si_pago_jornal) {
        this.si_pago_jornal = si_pago_jornal;
    }

    public Boolean getSi_pago_horas_extras() {
        return si_pago_horas_extras;
    }

    public void setSi_pago_horas_extras(Boolean si_pago_horas_extras) {
        this.si_pago_horas_extras = si_pago_horas_extras;
    }

    public Boolean getSi_descanso() {
        return si_descanso;
    }

    public void setSi_descanso(Boolean si_descanso) {
        this.si_descanso = si_descanso;
    }

    public Boolean getSi_liquidar() {
        return si_liquidar;
    }

    public void setSi_liquidar(Boolean si_liquidar) {
        this.si_liquidar = si_liquidar;
    }


}
