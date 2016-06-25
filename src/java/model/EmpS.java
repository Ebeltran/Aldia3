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
public class EmpS implements Serializable {

    private static final long serialVersionUID = 7123879679829854409L;
    private String identi;
    private String identi_con;
    private String identi_eps;
    private String identi_fdp;
    private String identi_fdc;
    
    private String identi_eps_con;
    private String identi_fdp_con;
    private String identi_fdc_con;
    
    private String nombre_1;
    private String nombre_2;
    private String apellido_1;
    private String apellido_2;
    
    private String identi_firma;
    private String identi_firma_con;
    private String nombre_firma;
    private String cargo_firma;
    
    private int n_cargo;
    private String nom_cargo;
    private String nom_cargo_id;   
    private String si_es_jefe;
    private int n_cargo_jefe;
    private String nom_cargo_jefe;
    private boolean lsi_jefe;
   
    private int n_cargo_aspira;
    private String nom_cargo_aspira;   
    private String nom_cargo_aspira_id;   
    private String si_es_jefe_aspira;
    private int n_cargo_jefe_aspira;
    private String nom_cargo_aspira_jefe;
    private boolean lsi_jefe_aspira;
   
    private int n_localiza;
    private String descripcion;
    
    private int n_nit_tip_identidad;
    private int n_rotulo;
    private int n_emp_estado_laboral;
    private int n_emp_pago_forma;
    private String nom_nit_tip_identidad;
    private int n_vacante;
    private int n_emp_edu_clase;
    private int n_apl_e_civil;
    private int n_apl_sexo;
    private int n_pago_periodo;

    private int n_emp_horario;
    private int n_emp_motivo_retiro;
    private int id_documen;

    private Date fecha_firma_contra;
    private Date fecha_prueba;
    
    private String si_contratar;
    private String si_contratado;
    private String si_rechazado;
    private String si_cabeza_familia;
    private String si_pago_aux_tran;
    private String si_salario_integral;
    private String si_situacionMilitar;
    
    private Boolean si_es_contratar;
    private Boolean si_es_contratado;
    private Boolean si_es_rechazado;
    private Boolean si_es_cabeza_familia;
    private Boolean si_es_pago_aux_tran;
    private Boolean si_es_salario_integral;
    
    private Boolean si_es_situacion_militar;
    private Boolean si_es_tel_aux;
    private Boolean si_es_fax;
    private Boolean si_es_e_mail_a;
    private Boolean si_es_pagina_web;
    
    private String profesion;
    
    private String pago_forma;
    private String identi_banco;
    
    private int id_ban_cuenta;
    private int n_ban_cuenta_tipo;
    private String identi_banco_con;
    private String nombre_banco;
    private String ban_sucursal;
    private String cuenta_tipo;
    private String cuenta_suc;
    private String cuenta_cta;
    private String cuenta_cta_con;
    private String[] cabeza_es;
    
    private float no_estatura;
    private float no_peso;
    private Date fe_hora;
    private Date fecha_actual;
    private Date fecha_nace;
    private double vr_salario_aspira;
    private String salario_aspira;
    private int n_apl_sangre_tipo;
    private String observacion;
    private int n_con_duracion;
    
    private Date fecha;
    private Date fec_desde;
    private Date fec_hasta;

    private String tipo_iden;
    private String tipo_doc;

    private String direccion;
    private String telefono;
    private String tel_aux;
    private String fax;
    private String barrio;
    private String e_mail;
    private String e_mail_a;
    private String pagina_web;
    private Double latitud;
    private Double longitud;

    private String query;
    private String queryCiudad;
    
    private String nom_pago_forma;
    private String nom_educa;
    
    private String razon_eps;
    private String razon_fdp;
    private String razon_fdc;
    
    private boolean lpersona;
    private boolean ljuridica;
    private boolean lpagoforma;
    private boolean lfechafin;
    private boolean lauxtran;
    private boolean lintegral;
    private boolean llabor;
    private boolean lsieps;
    private boolean lsifdp;
    private boolean lsifdc;
    private boolean lsiarl;
    private boolean lsisena;
    private boolean lsiicbf;
    private boolean lsiccf;
    
    private String mensaje;
    private String razon_social;
    private String apellidos_nombres;
    private String nombres_apellidos;
        
    private Long n_identi;
    
    private int n_apl_ciudad;
    private int n_apl_ciudad_padre;
    private String ciudad;
    private String departamento;
    private String depto;
    private String ciudad_depto;
    private String ciudad_dep;

    private String nom_apl_ciudad_contra;
    private String nom_apl_ciudad_trabaja;
        
    private int n_ciudad_nace;
    private int n_ciudad_padre_nace;
    private String ciudad_nace;
    private String departamento_nace;
    private String depto_nace;
    private String ciudad_depto_nace;
    private String ciudad_dep_nace;
    
    private int n_ciudad_contrata;
    private int n_ciudad_padre_contrata;
    private String ciudad_contrata;
    private String departamento_contrata;
    private String depto_contrata;
    private String ciudad_depto_contrata;
    private String ciudad_dep_contrata;
    
    private int n_ciudad_firma;
    private int n_ciudad_padre_firma;
    private String ciudad_firma;
    private String departamento_firma;
    private String depto_firma;
    private String ciudad_depto_firma;
    private String ciudad_dep_firma;
    
    private int n_ciudad_trabaja;
    private int n_ciudad_padre_trabaja;
    private String ciudad_trabaja;
    private String departamento_trabaja;
    private String depto_trabaja;
    private String ciudad_depto_trabaja;
    private String ciudad_dep_trabaja;
    
    private int n_cen_costo;
    private String nom_cen_costo;
    private String nom_cen_costo_id;
    private String nom_cen_costo_padre;
    private String costo;
    
    private int n_con_tipo;
    private int n_apl_con_trabajo;
    private String nom_con_tipo;
    private String nom_con_trabajo;
    
    private double vr_salario;
    private String salario;
    
    private int n_emp_jornada;
    private int n_apl_pago_periodo;
    private int nivel;     
    private int no_con_trabajo;
    private int no_renovacion;
    private int n_cotiza_tipo;
    private int n_cotiza_subtipo;    
    
    private String emp_jornada;
    private String nom_horario;
    private String des_horario;
    private String tarifa_arl;
    private String reporte_nombre;
    
    private int n_apl_doc_pendiente;
    private String nom_apl_doc_pendiente;
     
    private Date fecha_inicia;
    private Date fecha_final;
    private Date Fecha_control;
    
    public EmpS() {
    }

    public String getIdenti() {
        return identi;
    }

    public void setIdenti(String identi) {
        this.identi = identi;
    }

    public String getIdenti_con() {
        return identi_con;
    }

    public void setIdenti_con(String identi_con) {
        this.identi_con = identi_con;
    }

    public String getIdenti_eps() {
        return identi_eps;
    }

    public void setIdenti_eps(String identi_eps) {
        this.identi_eps = identi_eps;
    }

    public String getIdenti_fdp() {
        return identi_fdp;
    }

    public void setIdenti_fdp(String identi_fdp) {
        this.identi_fdp = identi_fdp;
    }

    public String getIdenti_fdc() {
        return identi_fdc;
    }

    public void setIdenti_fdc(String identi_fdc) {
        this.identi_fdc = identi_fdc;
    }

    public String getIdenti_eps_con() {
        return identi_eps_con;
    }

    public void setIdenti_eps_con(String identi_eps_con) {
        this.identi_eps_con = identi_eps_con;
    }

    public String getIdenti_fdp_con() {
        return identi_fdp_con;
    }

    public void setIdenti_fdp_con(String identi_fdp_con) {
        this.identi_fdp_con = identi_fdp_con;
    }

    public String getIdenti_fdc_con() {
        return identi_fdc_con;
    }

    public void setIdenti_fdc_con(String identi_fdc_con) {
        this.identi_fdc_con = identi_fdc_con;
    }

    public String getNombre_1() {
        return nombre_1;
    }

    public void setNombre_1(String nombre_1) {
        this.nombre_1 = nombre_1;
    }

    public String getNombre_2() {
        return nombre_2;
    }

    public void setNombre_2(String nombre_2) {
        this.nombre_2 = nombre_2;
    }

    public String getApellido_1() {
        return apellido_1;
    }

    public void setApellido_1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    public String getApellido_2() {
        return apellido_2;
    }

    public void setApellido_2(String apellido_2) {
        this.apellido_2 = apellido_2;
    }

    public String getIdenti_firma() {
        return identi_firma;
    }

    public void setIdenti_firma(String identi_firma) {
        this.identi_firma = identi_firma;
    }

    public String getIdenti_firma_con() {
        return identi_firma_con;
    }

    public void setIdenti_firma_con(String identi_firma_con) {
        this.identi_firma_con = identi_firma_con;
    }

    public String getNombre_firma() {
        return nombre_firma;
    }

    public void setNombre_firma(String nombre_firma) {
        this.nombre_firma = nombre_firma;
    }

    public String getCargo_firma() {
        return cargo_firma;
    }

    public void setCargo_firma(String cargo_firma) {
        this.cargo_firma = cargo_firma;
    }

    public int getN_cargo() {
        return n_cargo;
    }

    public void setN_cargo(int n_cargo) {
        this.n_cargo = n_cargo;
    }

    public String getNom_cargo() {
        return nom_cargo;
    }

    public void setNom_cargo(String nom_cargo) {
        this.nom_cargo = nom_cargo;
    }

    public String getNom_cargo_id() {
        return nom_cargo_id;
    }

    public void setNom_cargo_id(String nom_cargo_id) {
        this.nom_cargo_id = nom_cargo_id;
    }

    public String getSi_es_jefe() {
        return si_es_jefe;
    }

    public void setSi_es_jefe(String si_es_jefe) {
        this.si_es_jefe = si_es_jefe;
    }

    public int getN_cargo_jefe() {
        return n_cargo_jefe;
    }

    public void setN_cargo_jefe(int n_cargo_jefe) {
        this.n_cargo_jefe = n_cargo_jefe;
    }

    public String getNom_cargo_jefe() {
        return nom_cargo_jefe;
    }

    public void setNom_cargo_jefe(String nom_cargo_jefe) {
        this.nom_cargo_jefe = nom_cargo_jefe;
    }

    public boolean isLsi_jefe() {
        return lsi_jefe;
    }

    public void setLsi_jefe(boolean lsi_jefe) {
        this.lsi_jefe = lsi_jefe;
    }

    public int getN_cargo_aspira() {
        return n_cargo_aspira;
    }

    public void setN_cargo_aspira(int n_cargo_aspira) {
        this.n_cargo_aspira = n_cargo_aspira;
    }

    public String getNom_cargo_aspira() {
        return nom_cargo_aspira;
    }

    public void setNom_cargo_aspira(String nom_cargo_aspira) {
        this.nom_cargo_aspira = nom_cargo_aspira;
    }

    public String getNom_cargo_aspira_id() {
        return nom_cargo_aspira_id;
    }

    public void setNom_cargo_aspira_id(String nom_cargo_aspira_id) {
        this.nom_cargo_aspira_id = nom_cargo_aspira_id;
    }

    public String getSi_es_jefe_aspira() {
        return si_es_jefe_aspira;
    }

    public void setSi_es_jefe_aspira(String si_es_jefe_aspira) {
        this.si_es_jefe_aspira = si_es_jefe_aspira;
    }

    public int getN_cargo_jefe_aspira() {
        return n_cargo_jefe_aspira;
    }

    public void setN_cargo_jefe_aspira(int n_cargo_jefe_aspira) {
        this.n_cargo_jefe_aspira = n_cargo_jefe_aspira;
    }

    public String getNom_cargo_aspira_jefe() {
        return nom_cargo_aspira_jefe;
    }

    public void setNom_cargo_aspira_jefe(String nom_cargo_aspira_jefe) {
        this.nom_cargo_aspira_jefe = nom_cargo_aspira_jefe;
    }

    public boolean isLsi_jefe_aspira() {
        return lsi_jefe_aspira;
    }

    public void setLsi_jefe_aspira(boolean lsi_jefe_aspira) {
        this.lsi_jefe_aspira = lsi_jefe_aspira;
    }

    public int getN_localiza() {
        return n_localiza;
    }

    public void setN_localiza(int n_localiza) {
        this.n_localiza = n_localiza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getN_nit_tip_identidad() {
        return n_nit_tip_identidad;
    }

    public void setN_nit_tip_identidad(int n_nit_tip_identidad) {
        this.n_nit_tip_identidad = n_nit_tip_identidad;
    }

    public int getN_rotulo() {
        return n_rotulo;
    }

    public void setN_rotulo(int n_rotulo) {
        this.n_rotulo = n_rotulo;
    }

    public int getN_emp_estado_laboral() {
        return n_emp_estado_laboral;
    }

    public void setN_emp_estado_laboral(int n_emp_estado_laboral) {
        this.n_emp_estado_laboral = n_emp_estado_laboral;
    }

    public int getN_emp_pago_forma() {
        return n_emp_pago_forma;
    }

    public void setN_emp_pago_forma(int n_emp_pago_forma) {
        this.n_emp_pago_forma = n_emp_pago_forma;
    }

    public String getNom_nit_tip_identidad() {
        return nom_nit_tip_identidad;
    }

    public void setNom_nit_tip_identidad(String nom_nit_tip_identidad) {
        this.nom_nit_tip_identidad = nom_nit_tip_identidad;
    }

    public int getN_vacante() {
        return n_vacante;
    }

    public void setN_vacante(int n_vacante) {
        this.n_vacante = n_vacante;
    }

    public int getN_emp_edu_clase() {
        return n_emp_edu_clase;
    }

    public void setN_emp_edu_clase(int n_emp_edu_clase) {
        this.n_emp_edu_clase = n_emp_edu_clase;
    }

    public int getN_apl_e_civil() {
        return n_apl_e_civil;
    }

    public void setN_apl_e_civil(int n_apl_e_civil) {
        this.n_apl_e_civil = n_apl_e_civil;
    }

    public int getN_apl_sexo() {
        return n_apl_sexo;
    }

    public void setN_apl_sexo(int n_apl_sexo) {
        this.n_apl_sexo = n_apl_sexo;
    }

    public int getN_pago_periodo() {
        return n_pago_periodo;
    }

    public void setN_pago_periodo(int n_pago_periodo) {
        this.n_pago_periodo = n_pago_periodo;
    }

    public int getN_emp_horario() {
        return n_emp_horario;
    }

    public void setN_emp_horario(int n_emp_horario) {
        this.n_emp_horario = n_emp_horario;
    }

    public int getN_emp_motivo_retiro() {
        return n_emp_motivo_retiro;
    }

    public void setN_emp_motivo_retiro(int n_emp_motivo_retiro) {
        this.n_emp_motivo_retiro = n_emp_motivo_retiro;
    }

    public int getId_documen() {
        return id_documen;
    }

    public void setId_documen(int id_documen) {
        this.id_documen = id_documen;
    }

    public Date getFecha_firma_contra() {
        return fecha_firma_contra;
    }

    public void setFecha_firma_contra(Date fecha_firma_contra) {
        this.fecha_firma_contra = fecha_firma_contra;
    }

    public Date getFecha_prueba() {
        return fecha_prueba;
    }

    public void setFecha_prueba(Date fecha_prueba) {
        this.fecha_prueba = fecha_prueba;
    }

    public String getSi_contratar() {
        return si_contratar;
    }

    public void setSi_contratar(String si_contratar) {
        this.si_contratar = si_contratar;
    }

    public String getSi_contratado() {
        return si_contratado;
    }

    public void setSi_contratado(String si_contratado) {
        this.si_contratado = si_contratado;
    }

    public String getSi_rechazado() {
        return si_rechazado;
    }

    public void setSi_rechazado(String si_rechazado) {
        this.si_rechazado = si_rechazado;
    }

    public String getSi_cabeza_familia() {
        return si_cabeza_familia;
    }

    public void setSi_cabeza_familia(String si_cabeza_familia) {
        this.si_cabeza_familia = si_cabeza_familia;
    }

    public String getSi_pago_aux_tran() {
        return si_pago_aux_tran;
    }

    public void setSi_pago_aux_tran(String si_pago_aux_tran) {
        this.si_pago_aux_tran = si_pago_aux_tran;
    }

    public String getSi_salario_integral() {
        return si_salario_integral;
    }

    public void setSi_salario_integral(String si_salario_integral) {
        this.si_salario_integral = si_salario_integral;
    }

    public String getSi_situacionMilitar() {
        return si_situacionMilitar;
    }

    public void setSi_situacionMilitar(String si_situacionMilitar) {
        this.si_situacionMilitar = si_situacionMilitar;
    }

    public Boolean getSi_es_contratar() {
        return si_es_contratar;
    }

    public void setSi_es_contratar(Boolean si_es_contratar) {
        this.si_es_contratar = si_es_contratar;
    }

    public Boolean getSi_es_contratado() {
        return si_es_contratado;
    }

    public void setSi_es_contratado(Boolean si_es_contratado) {
        this.si_es_contratado = si_es_contratado;
    }

    public Boolean getSi_es_rechazado() {
        return si_es_rechazado;
    }

    public void setSi_es_rechazado(Boolean si_es_rechazado) {
        this.si_es_rechazado = si_es_rechazado;
    }

    public Boolean getSi_es_cabeza_familia() {
        return si_es_cabeza_familia;
    }

    public void setSi_es_cabeza_familia(Boolean si_es_cabeza_familia) {
        this.si_es_cabeza_familia = si_es_cabeza_familia;
    }

    public Boolean getSi_es_pago_aux_tran() {
        return si_es_pago_aux_tran;
    }

    public void setSi_es_pago_aux_tran(Boolean si_es_pago_aux_tran) {
        this.si_es_pago_aux_tran = si_es_pago_aux_tran;
    }

    public Boolean getSi_es_salario_integral() {
        return si_es_salario_integral;
    }

    public void setSi_es_salario_integral(Boolean si_es_salario_integral) {
        this.si_es_salario_integral = si_es_salario_integral;
    }

    public Boolean getSi_es_situacion_militar() {
        return si_es_situacion_militar;
    }

    public void setSi_es_situacion_militar(Boolean si_es_situacion_militar) {
        this.si_es_situacion_militar = si_es_situacion_militar;
    }

    public Boolean getSi_es_tel_aux() {
        return si_es_tel_aux;
    }

    public void setSi_es_tel_aux(Boolean si_es_tel_aux) {
        this.si_es_tel_aux = si_es_tel_aux;
    }

    public Boolean getSi_es_fax() {
        return si_es_fax;
    }

    public void setSi_es_fax(Boolean si_es_fax) {
        this.si_es_fax = si_es_fax;
    }

    public Boolean getSi_es_e_mail_a() {
        return si_es_e_mail_a;
    }

    public void setSi_es_e_mail_a(Boolean si_es_e_mail_a) {
        this.si_es_e_mail_a = si_es_e_mail_a;
    }

    public Boolean getSi_es_pagina_web() {
        return si_es_pagina_web;
    }

    public void setSi_es_pagina_web(Boolean si_es_pagina_web) {
        this.si_es_pagina_web = si_es_pagina_web;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getPago_forma() {
        return pago_forma;
    }

    public void setPago_forma(String pago_forma) {
        this.pago_forma = pago_forma;
    }

    public String getIdenti_banco() {
        return identi_banco;
    }

    public void setIdenti_banco(String identi_banco) {
        this.identi_banco = identi_banco;
    }

    public int getId_ban_cuenta() {
        return id_ban_cuenta;
    }

    public void setId_ban_cuenta(int id_ban_cuenta) {
        this.id_ban_cuenta = id_ban_cuenta;
    }

    public int getN_ban_cuenta_tipo() {
        return n_ban_cuenta_tipo;
    }

    public void setN_ban_cuenta_tipo(int n_ban_cuenta_tipo) {
        this.n_ban_cuenta_tipo = n_ban_cuenta_tipo;
    }

    public String getIdenti_banco_con() {
        return identi_banco_con;
    }

    public void setIdenti_banco_con(String identi_banco_con) {
        this.identi_banco_con = identi_banco_con;
    }

    public String getNombre_banco() {
        return nombre_banco;
    }

    public void setNombre_banco(String nombre_banco) {
        this.nombre_banco = nombre_banco;
    }

    public String getBan_sucursal() {
        return ban_sucursal;
    }

    public void setBan_sucursal(String ban_sucursal) {
        this.ban_sucursal = ban_sucursal;
    }

    public String getCuenta_tipo() {
        return cuenta_tipo;
    }

    public void setCuenta_tipo(String cuenta_tipo) {
        this.cuenta_tipo = cuenta_tipo;
    }

    public String getCuenta_suc() {
        return cuenta_suc;
    }

    public void setCuenta_suc(String cuenta_suc) {
        this.cuenta_suc = cuenta_suc;
    }

    public String getCuenta_cta() {
        return cuenta_cta;
    }

    public void setCuenta_cta(String cuenta_cta) {
        this.cuenta_cta = cuenta_cta;
    }

    public String getCuenta_cta_con() {
        return cuenta_cta_con;
    }

    public void setCuenta_cta_con(String cuenta_cta_con) {
        this.cuenta_cta_con = cuenta_cta_con;
    }

    public String[] getCabeza_es() {
        return cabeza_es;
    }

    public void setCabeza_es(String[] cabeza_es) {
        this.cabeza_es = cabeza_es;
    }

    public float getNo_estatura() {
        return no_estatura;
    }

    public void setNo_estatura(float no_estatura) {
        this.no_estatura = no_estatura;
    }

    public float getNo_peso() {
        return no_peso;
    }

    public void setNo_peso(float no_peso) {
        this.no_peso = no_peso;
    }

    public Date getFe_hora() {
        return fe_hora;
    }

    public void setFe_hora(Date fe_hora) {
        this.fe_hora = fe_hora;
    }

    public Date getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public Date getFecha_nace() {
        return fecha_nace;
    }

    public void setFecha_nace(Date fecha_nace) {
        this.fecha_nace = fecha_nace;
    }

    public double getVr_salario_aspira() {
        return vr_salario_aspira;
    }

    public void setVr_salario_aspira(double vr_salario_aspira) {
        this.vr_salario_aspira = vr_salario_aspira;
    }

    public String getSalario_aspira() {
        return salario_aspira;
    }

    public void setSalario_aspira(String salario_aspira) {
        this.salario_aspira = salario_aspira;
    }

    public int getN_apl_sangre_tipo() {
        return n_apl_sangre_tipo;
    }

    public void setN_apl_sangre_tipo(int n_apl_sangre_tipo) {
        this.n_apl_sangre_tipo = n_apl_sangre_tipo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getN_con_duracion() {
        return n_con_duracion;
    }

    public void setN_con_duracion(int n_con_duracion) {
        this.n_con_duracion = n_con_duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public String getTipo_iden() {
        return tipo_iden;
    }

    public void setTipo_iden(String tipo_iden) {
        this.tipo_iden = tipo_iden;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTel_aux() {
        return tel_aux;
    }

    public void setTel_aux(String tel_aux) {
        this.tel_aux = tel_aux;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getE_mail_a() {
        return e_mail_a;
    }

    public void setE_mail_a(String e_mail_a) {
        this.e_mail_a = e_mail_a;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQueryCiudad() {
        return queryCiudad;
    }

    public void setQueryCiudad(String queryCiudad) {
        this.queryCiudad = queryCiudad;
    }

    public String getNom_pago_forma() {
        return nom_pago_forma;
    }

    public void setNom_pago_forma(String nom_pago_forma) {
        this.nom_pago_forma = nom_pago_forma;
    }

    public String getNom_educa() {
        return nom_educa;
    }

    public void setNom_educa(String nom_educa) {
        this.nom_educa = nom_educa;
    }

    public String getRazon_eps() {
        return razon_eps;
    }

    public void setRazon_eps(String razon_eps) {
        this.razon_eps = razon_eps;
    }

    public String getRazon_fdp() {
        return razon_fdp;
    }

    public void setRazon_fdp(String razon_fdp) {
        this.razon_fdp = razon_fdp;
    }

    public String getRazon_fdc() {
        return razon_fdc;
    }

    public void setRazon_fdc(String razon_fdc) {
        this.razon_fdc = razon_fdc;
    }

    public boolean isLpersona() {
        return lpersona;
    }

    public void setLpersona(boolean lpersona) {
        this.lpersona = lpersona;
    }

    public boolean isLjuridica() {
        return ljuridica;
    }

    public void setLjuridica(boolean ljuridica) {
        this.ljuridica = ljuridica;
    }

    public boolean isLpagoforma() {
        return lpagoforma;
    }

    public void setLpagoforma(boolean lpagoforma) {
        this.lpagoforma = lpagoforma;
    }

    public boolean isLfechafin() {
        return lfechafin;
    }

    public void setLfechafin(boolean lfechafin) {
        this.lfechafin = lfechafin;
    }

    public boolean isLauxtran() {
        return lauxtran;
    }

    public void setLauxtran(boolean lauxtran) {
        this.lauxtran = lauxtran;
    }

    public boolean isLintegral() {
        return lintegral;
    }

    public void setLintegral(boolean lintegral) {
        this.lintegral = lintegral;
    }

    public boolean isLlabor() {
        return llabor;
    }

    public void setLlabor(boolean llabor) {
        this.llabor = llabor;
    }

    public boolean isLsieps() {
        return lsieps;
    }

    public void setLsieps(boolean lsieps) {
        this.lsieps = lsieps;
    }

    public boolean isLsifdp() {
        return lsifdp;
    }

    public void setLsifdp(boolean lsifdp) {
        this.lsifdp = lsifdp;
    }

    public boolean isLsifdc() {
        return lsifdc;
    }

    public void setLsifdc(boolean lsifdc) {
        this.lsifdc = lsifdc;
    }

    public boolean isLsiarl() {
        return lsiarl;
    }

    public void setLsiarl(boolean lsiarl) {
        this.lsiarl = lsiarl;
    }

    public boolean isLsisena() {
        return lsisena;
    }

    public void setLsisena(boolean lsisena) {
        this.lsisena = lsisena;
    }

    public boolean isLsiicbf() {
        return lsiicbf;
    }

    public void setLsiicbf(boolean lsiicbf) {
        this.lsiicbf = lsiicbf;
    }

    public boolean isLsiccf() {
        return lsiccf;
    }

    public void setLsiccf(boolean lsiccf) {
        this.lsiccf = lsiccf;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getApellidos_nombres() {
        return apellidos_nombres;
    }

    public void setApellidos_nombres(String apellidos_nombres) {
        this.apellidos_nombres = apellidos_nombres;
    }

    public String getNombres_apellidos() {
        return nombres_apellidos;
    }

    public void setNombres_apellidos(String nombres_apellidos) {
        this.nombres_apellidos = nombres_apellidos;
    }

    public Long getN_identi() {
        return n_identi;
    }

    public void setN_identi(Long n_identi) {
        this.n_identi = n_identi;
    }

    public int getN_apl_ciudad() {
        return n_apl_ciudad;
    }

    public void setN_apl_ciudad(int n_apl_ciudad) {
        this.n_apl_ciudad = n_apl_ciudad;
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

    public String getNom_apl_ciudad_contra() {
        return nom_apl_ciudad_contra;
    }

    public void setNom_apl_ciudad_contra(String nom_apl_ciudad_contra) {
        this.nom_apl_ciudad_contra = nom_apl_ciudad_contra;
    }

    public String getNom_apl_ciudad_trabaja() {
        return nom_apl_ciudad_trabaja;
    }

    public void setNom_apl_ciudad_trabaja(String nom_apl_ciudad_trabaja) {
        this.nom_apl_ciudad_trabaja = nom_apl_ciudad_trabaja;
    }

    public int getN_ciudad_nace() {
        return n_ciudad_nace;
    }

    public void setN_ciudad_nace(int n_ciudad_nace) {
        this.n_ciudad_nace = n_ciudad_nace;
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

    public int getN_ciudad_contrata() {
        return n_ciudad_contrata;
    }

    public void setN_ciudad_contrata(int n_ciudad_contrata) {
        this.n_ciudad_contrata = n_ciudad_contrata;
    }

    public int getN_ciudad_padre_contrata() {
        return n_ciudad_padre_contrata;
    }

    public void setN_ciudad_padre_contrata(int n_ciudad_padre_contrata) {
        this.n_ciudad_padre_contrata = n_ciudad_padre_contrata;
    }

    public String getCiudad_contrata() {
        return ciudad_contrata;
    }

    public void setCiudad_contrata(String ciudad_contrata) {
        this.ciudad_contrata = ciudad_contrata;
    }

    public String getDepartamento_contrata() {
        return departamento_contrata;
    }

    public void setDepartamento_contrata(String departamento_contrata) {
        this.departamento_contrata = departamento_contrata;
    }

    public String getDepto_contrata() {
        return depto_contrata;
    }

    public void setDepto_contrata(String depto_contrata) {
        this.depto_contrata = depto_contrata;
    }

    public String getCiudad_depto_contrata() {
        return ciudad_depto_contrata;
    }

    public void setCiudad_depto_contrata(String ciudad_depto_contrata) {
        this.ciudad_depto_contrata = ciudad_depto_contrata;
    }

    public String getCiudad_dep_contrata() {
        return ciudad_dep_contrata;
    }

    public void setCiudad_dep_contrata(String ciudad_dep_contrata) {
        this.ciudad_dep_contrata = ciudad_dep_contrata;
    }

    public int getN_ciudad_firma() {
        return n_ciudad_firma;
    }

    public void setN_ciudad_firma(int n_ciudad_firma) {
        this.n_ciudad_firma = n_ciudad_firma;
    }

    public int getN_ciudad_padre_firma() {
        return n_ciudad_padre_firma;
    }

    public void setN_ciudad_padre_firma(int n_ciudad_padre_firma) {
        this.n_ciudad_padre_firma = n_ciudad_padre_firma;
    }

    public String getCiudad_firma() {
        return ciudad_firma;
    }

    public void setCiudad_firma(String ciudad_firma) {
        this.ciudad_firma = ciudad_firma;
    }

    public String getDepartamento_firma() {
        return departamento_firma;
    }

    public void setDepartamento_firma(String departamento_firma) {
        this.departamento_firma = departamento_firma;
    }

    public String getDepto_firma() {
        return depto_firma;
    }

    public void setDepto_firma(String depto_firma) {
        this.depto_firma = depto_firma;
    }

    public String getCiudad_depto_firma() {
        return ciudad_depto_firma;
    }

    public void setCiudad_depto_firma(String ciudad_depto_firma) {
        this.ciudad_depto_firma = ciudad_depto_firma;
    }

    public String getCiudad_dep_firma() {
        return ciudad_dep_firma;
    }

    public void setCiudad_dep_firma(String ciudad_dep_firma) {
        this.ciudad_dep_firma = ciudad_dep_firma;
    }

    public int getN_ciudad_trabaja() {
        return n_ciudad_trabaja;
    }

    public void setN_ciudad_trabaja(int n_ciudad_trabaja) {
        this.n_ciudad_trabaja = n_ciudad_trabaja;
    }

    public int getN_ciudad_padre_trabaja() {
        return n_ciudad_padre_trabaja;
    }

    public void setN_ciudad_padre_trabaja(int n_ciudad_padre_trabaja) {
        this.n_ciudad_padre_trabaja = n_ciudad_padre_trabaja;
    }

    public String getCiudad_trabaja() {
        return ciudad_trabaja;
    }

    public void setCiudad_trabaja(String ciudad_trabaja) {
        this.ciudad_trabaja = ciudad_trabaja;
    }

    public String getDepartamento_trabaja() {
        return departamento_trabaja;
    }

    public void setDepartamento_trabaja(String departamento_trabaja) {
        this.departamento_trabaja = departamento_trabaja;
    }

    public String getDepto_trabaja() {
        return depto_trabaja;
    }

    public void setDepto_trabaja(String depto_trabaja) {
        this.depto_trabaja = depto_trabaja;
    }

    public String getCiudad_depto_trabaja() {
        return ciudad_depto_trabaja;
    }

    public void setCiudad_depto_trabaja(String ciudad_depto_trabaja) {
        this.ciudad_depto_trabaja = ciudad_depto_trabaja;
    }

    public String getCiudad_dep_trabaja() {
        return ciudad_dep_trabaja;
    }

    public void setCiudad_dep_trabaja(String ciudad_dep_trabaja) {
        this.ciudad_dep_trabaja = ciudad_dep_trabaja;
    }

    public int getN_cen_costo() {
        return n_cen_costo;
    }

    public void setN_cen_costo(int n_cen_costo) {
        this.n_cen_costo = n_cen_costo;
    }

    public String getNom_cen_costo() {
        return nom_cen_costo;
    }

    public void setNom_cen_costo(String nom_cen_costo) {
        this.nom_cen_costo = nom_cen_costo;
    }

    public String getNom_cen_costo_id() {
        return nom_cen_costo_id;
    }

    public void setNom_cen_costo_id(String nom_cen_costo_id) {
        this.nom_cen_costo_id = nom_cen_costo_id;
    }

    public String getNom_cen_costo_padre() {
        return nom_cen_costo_padre;
    }

    public void setNom_cen_costo_padre(String nom_cen_costo_padre) {
        this.nom_cen_costo_padre = nom_cen_costo_padre;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public int getN_con_tipo() {
        return n_con_tipo;
    }

    public void setN_con_tipo(int n_con_tipo) {
        this.n_con_tipo = n_con_tipo;
    }

    public int getN_apl_con_trabajo() {
        return n_apl_con_trabajo;
    }

    public void setN_apl_con_trabajo(int n_apl_con_trabajo) {
        this.n_apl_con_trabajo = n_apl_con_trabajo;
    }

    public String getNom_con_tipo() {
        return nom_con_tipo;
    }

    public void setNom_con_tipo(String nom_con_tipo) {
        this.nom_con_tipo = nom_con_tipo;
    }

    public String getNom_con_trabajo() {
        return nom_con_trabajo;
    }

    public void setNom_con_trabajo(String nom_con_trabajo) {
        this.nom_con_trabajo = nom_con_trabajo;
    }

    public double getVr_salario() {
        return vr_salario;
    }

    public void setVr_salario(double vr_salario) {
        this.vr_salario = vr_salario;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public int getN_emp_jornada() {
        return n_emp_jornada;
    }

    public void setN_emp_jornada(int n_emp_jornada) {
        this.n_emp_jornada = n_emp_jornada;
    }

    public int getN_apl_pago_periodo() {
        return n_apl_pago_periodo;
    }

    public void setN_apl_pago_periodo(int n_apl_pago_periodo) {
        this.n_apl_pago_periodo = n_apl_pago_periodo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNo_con_trabajo() {
        return no_con_trabajo;
    }

    public void setNo_con_trabajo(int no_con_trabajo) {
        this.no_con_trabajo = no_con_trabajo;
    }

    public int getNo_renovacion() {
        return no_renovacion;
    }

    public void setNo_renovacion(int no_renovacion) {
        this.no_renovacion = no_renovacion;
    }

    public int getN_cotiza_tipo() {
        return n_cotiza_tipo;
    }

    public void setN_cotiza_tipo(int n_cotiza_tipo) {
        this.n_cotiza_tipo = n_cotiza_tipo;
    }

    public int getN_cotiza_subtipo() {
        return n_cotiza_subtipo;
    }

    public void setN_cotiza_subtipo(int n_cotiza_subtipo) {
        this.n_cotiza_subtipo = n_cotiza_subtipo;
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

    public String getReporte_nombre() {
        return reporte_nombre;
    }

    public void setReporte_nombre(String reporte_nombre) {
        this.reporte_nombre = reporte_nombre;
    }

    public int getN_apl_doc_pendiente() {
        return n_apl_doc_pendiente;
    }

    public void setN_apl_doc_pendiente(int n_apl_doc_pendiente) {
        this.n_apl_doc_pendiente = n_apl_doc_pendiente;
    }

    public String getNom_apl_doc_pendiente() {
        return nom_apl_doc_pendiente;
    }

    public void setNom_apl_doc_pendiente(String nom_apl_doc_pendiente) {
        this.nom_apl_doc_pendiente = nom_apl_doc_pendiente;
    }

    public Date getFecha_inicia() {
        return fecha_inicia;
    }

    public void setFecha_inicia(Date fecha_inicia) {
        this.fecha_inicia = fecha_inicia;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public Date getFecha_control() {
        return Fecha_control;
    }

    public void setFecha_control(Date Fecha_control) {
        this.Fecha_control = Fecha_control;
    }
    
}