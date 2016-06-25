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
public class AplDefine implements Serializable {
    
    private static final long serialVersionUID = 454846801609243234L;
    private String nombre;
    private int n_orden;
    private int n_ciiu;
    private int n_ciiu_padre;

    private int n_apl_ciudad_nace;
    private String no_apl_ciudad_nace;
    
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
    
    private int n_emp_cargo;
    private int n_emp_cargo_jefe;
    private String cargo_jefe;
    private int n_localiza;
    private String si_es_jefe;
    
    private String descripcion;
    private String desrip_pago_forma;
    private Number tarifa;
    
    private String identi_eps;
    private String identif_eps_con;
    private String identi_fdp;
    private String identif_fdp_con;
    private String identi_fdc;
    private String identif_fdc_con;
    
    private String cod_plan_u_eps;
    private String cod_plan_u_fdp;
    private String cod_plan_u_fdc;
    private String nom_seg_eps;
    private String nom_seg_fdp;
    private String nom_seg_fdc;
    
    private String nom_nit_tip_identidad;
    private String nom_nit_cla_sociedad;
    private String nom_nit_tip_contribuyente;
    private String nom_nit_digni;
    private String nom_apl_e_civil;
    private String nom_nit_grupo;
    private String nom_apl_sexo;
    private String nom_apl_sangre_tipo;
    private String nom_apl_cabeza;
    private String nom_educa;
    private String nom_cargo;
    private String nom_cargo_jefe;
    private String descrip_cargo;
    private String nombre_titulo;
    private String nom_pago_forma;
    private String nom_ciudad;
    private String nom_departamento;
    private String nom_depto;
    private String nom_ciudad_depto;
    private String nom_ciudad_dep;
    
    private String tipo_doc;
    private String dian_cod;
    
    private int n_nit_tip_identidad;
    private int n_nit_cla_sociedad;
    private int n_nit_tip_contribuyente;
    private int n_nit_digni;
    private int n_apl_e_civil;
    private int n_nit_grupo;
    private int n_apl_sexo;
    private int n_apl_sangre_tipo;
    private int n_emp_edu_clase;
    private int n_periodo;
    private int n_edu_nivel;
    private int n_cargo;
    private String no_cargo;
    private int n_cargo_jefe;
    private float cantidad_periodo;
    private int n_apl_cabeza_familia;
    private int n_pago_forma;
    
    private String nom_ban_compensa;
    private String identi_banco;
    private String identi_banco_con;
    
    private int n_ban_cuenta_tipo;
    private String nom_ban_cuenta_tipo;
    private String si_se_liq_interes;
    
    private boolean lsi_jefe;
    
    private int si_matricula;
    private String si_jefe;
     
    private int n_con_tipo;
    private int n_apl_con_trabajo;
    private String nom_con_tipo;
    private String nom_con_trabajo;
    
    private int n_cotiza_tipo;
    private String nom_cotiza_tipo;
    private int n_cotiza_subtipo;
    private String nom_cotiza_subtipo;
    
    private String identi_firma;
    private String identi_firma_con;
    private String nombre_firma;
    private String cargo_firma;
    
    private int n_emp_motivo_retiro;
    private String nom_motivo_retiro;
    private String des_motivo_retiro;
    private String si_justa_causa;
    private int no_dias_preaviso;
    
    private int no_dias_avi_noti;
    private float dias_pru_x_100;
    private int no_prueba_max;
    private int no_dura_min;
    private int no_dura_max;
    private int no_veces_renueva;
    
    private int si_vence;
    private int si_indemniza;
    private int si_pide_labor;
    private int si_aux_tran;
    private int si_salario_integral;
    private int si_pago_eps;
    private int si_pago_fdp;
    private int si_pago_fdc;
    private int si_pago_arl;
    private int si_pago_sena;
    private int si_pago_icbf;
    private int si_pago_ccf;
    
    private boolean lsi_vence;
    private boolean lsi_indemniza;
    private boolean lsi_aux_tran;
    private boolean lsi_salario_integral;
    private boolean lsi_pide_labor;
    private boolean lsi_pago_eps;
    private boolean lsi_pago_fdp;
    private boolean lsi_pago_fdc;
    private boolean lsi_pago_arl;
    private boolean lsi_pago_sena;
    private boolean lsi_pago_icbf;
    private boolean lsi_pago_ccf;
    
    private String si_se_vence;
    private String si_se_indemniza;
    private String si_es_aux_tran;
    private String si_es_salario_integral;
    private String si_se_pide_labor;
    private String si_se_pago_eps;
    private String si_se_pago_fdp;
    private String si_se_pago_fdc;
    private String si_se_pago_arl;
    private String si_se_pago_sena;
    private String si_se_pago_icbf;
    private String si_se_pago_ccf;
    
    private int n_apl_doc_pendiente;
    private String nom_apl_doc_pendiente;
    
    private Date fec_desde;
    private Date fec_hasta;

    private int n_apl_conce_tipo;
    private int n_apl_conce_liq;
    private int n_apl_perio_pago;
    private int n_apl_grupo;
    private int n_apl_cta_sufijo;
    private int n_apl_uni_medida;
    private int n_apl_uni_medida_padre;
    private float cantidad;
    private float factor;
    private String cta_sufijo;
    private String simbolo;
    private String mascara;
   
    public AplDefine() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getN_orden() {
        return n_orden;
    }

    public void setN_orden(int n_orden) {
        this.n_orden = n_orden;
    }

    public int getN_ciiu() {
        return n_ciiu;
    }

    public void setN_ciiu(int n_ciiu) {
        this.n_ciiu = n_ciiu;
    }

    public int getN_ciiu_padre() {
        return n_ciiu_padre;
    }

    public void setN_ciiu_padre(int n_ciiu_padre) {
        this.n_ciiu_padre = n_ciiu_padre;
    }

    public int getN_apl_ciudad_nace() {
        return n_apl_ciudad_nace;
    }

    public void setN_apl_ciudad_nace(int n_apl_ciudad_nace) {
        this.n_apl_ciudad_nace = n_apl_ciudad_nace;
    }

    public String getNo_apl_ciudad_nace() {
        return no_apl_ciudad_nace;
    }

    public void setNo_apl_ciudad_nace(String no_apl_ciudad_nace) {
        this.no_apl_ciudad_nace = no_apl_ciudad_nace;
    }

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

    public int getN_emp_cargo() {
        return n_emp_cargo;
    }

    public void setN_emp_cargo(int n_emp_cargo) {
        this.n_emp_cargo = n_emp_cargo;
    }

    public int getN_emp_cargo_jefe() {
        return n_emp_cargo_jefe;
    }

    public void setN_emp_cargo_jefe(int n_emp_cargo_jefe) {
        this.n_emp_cargo_jefe = n_emp_cargo_jefe;
    }

    public String getCargo_jefe() {
        return cargo_jefe;
    }

    public void setCargo_jefe(String cargo_jefe) {
        this.cargo_jefe = cargo_jefe;
    }

    public int getN_localiza() {
        return n_localiza;
    }

    public void setN_localiza(int n_localiza) {
        this.n_localiza = n_localiza;
    }

    public String getSi_es_jefe() {
        return si_es_jefe;
    }

    public void setSi_es_jefe(String si_es_jefe) {
        this.si_es_jefe = si_es_jefe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDesrip_pago_forma() {
        return desrip_pago_forma;
    }

    public void setDesrip_pago_forma(String desrip_pago_forma) {
        this.desrip_pago_forma = desrip_pago_forma;
    }

    public Number getTarifa() {
        return tarifa;
    }

    public void setTarifa(Number tarifa) {
        this.tarifa = tarifa;
    }

    public String getIdenti_eps() {
        return identi_eps;
    }

    public void setIdenti_eps(String identi_eps) {
        this.identi_eps = identi_eps;
    }

    public String getIdentif_eps_con() {
        return identif_eps_con;
    }

    public void setIdentif_eps_con(String identif_eps_con) {
        this.identif_eps_con = identif_eps_con;
    }

    public String getIdenti_fdp() {
        return identi_fdp;
    }

    public void setIdenti_fdp(String identi_fdp) {
        this.identi_fdp = identi_fdp;
    }

    public String getIdentif_fdp_con() {
        return identif_fdp_con;
    }

    public void setIdentif_fdp_con(String identif_fdp_con) {
        this.identif_fdp_con = identif_fdp_con;
    }

    public String getIdenti_fdc() {
        return identi_fdc;
    }

    public void setIdenti_fdc(String identi_fdc) {
        this.identi_fdc = identi_fdc;
    }

    public String getIdentif_fdc_con() {
        return identif_fdc_con;
    }

    public void setIdentif_fdc_con(String identif_fdc_con) {
        this.identif_fdc_con = identif_fdc_con;
    }

    public String getCod_plan_u_eps() {
        return cod_plan_u_eps;
    }

    public void setCod_plan_u_eps(String cod_plan_u_eps) {
        this.cod_plan_u_eps = cod_plan_u_eps;
    }

    public String getCod_plan_u_fdp() {
        return cod_plan_u_fdp;
    }

    public void setCod_plan_u_fdp(String cod_plan_u_fdp) {
        this.cod_plan_u_fdp = cod_plan_u_fdp;
    }

    public String getCod_plan_u_fdc() {
        return cod_plan_u_fdc;
    }

    public void setCod_plan_u_fdc(String cod_plan_u_fdc) {
        this.cod_plan_u_fdc = cod_plan_u_fdc;
    }

    public String getNom_seg_eps() {
        return nom_seg_eps;
    }

    public void setNom_seg_eps(String nom_seg_eps) {
        this.nom_seg_eps = nom_seg_eps;
    }

    public String getNom_seg_fdp() {
        return nom_seg_fdp;
    }

    public void setNom_seg_fdp(String nom_seg_fdp) {
        this.nom_seg_fdp = nom_seg_fdp;
    }

    public String getNom_seg_fdc() {
        return nom_seg_fdc;
    }

    public void setNom_seg_fdc(String nom_seg_fdc) {
        this.nom_seg_fdc = nom_seg_fdc;
    }

    public String getNom_nit_tip_identidad() {
        return nom_nit_tip_identidad;
    }

    public void setNom_nit_tip_identidad(String nom_nit_tip_identidad) {
        this.nom_nit_tip_identidad = nom_nit_tip_identidad;
    }

    public String getNom_nit_cla_sociedad() {
        return nom_nit_cla_sociedad;
    }

    public void setNom_nit_cla_sociedad(String nom_nit_cla_sociedad) {
        this.nom_nit_cla_sociedad = nom_nit_cla_sociedad;
    }

    public String getNom_nit_tip_contribuyente() {
        return nom_nit_tip_contribuyente;
    }

    public void setNom_nit_tip_contribuyente(String nom_nit_tip_contribuyente) {
        this.nom_nit_tip_contribuyente = nom_nit_tip_contribuyente;
    }

    public String getNom_nit_digni() {
        return nom_nit_digni;
    }

    public void setNom_nit_digni(String nom_nit_digni) {
        this.nom_nit_digni = nom_nit_digni;
    }

    public String getNom_apl_e_civil() {
        return nom_apl_e_civil;
    }

    public void setNom_apl_e_civil(String nom_apl_e_civil) {
        this.nom_apl_e_civil = nom_apl_e_civil;
    }

    public String getNom_nit_grupo() {
        return nom_nit_grupo;
    }

    public void setNom_nit_grupo(String nom_nit_grupo) {
        this.nom_nit_grupo = nom_nit_grupo;
    }

    public String getNom_apl_sexo() {
        return nom_apl_sexo;
    }

    public void setNom_apl_sexo(String nom_apl_sexo) {
        this.nom_apl_sexo = nom_apl_sexo;
    }

    public String getNom_apl_sangre_tipo() {
        return nom_apl_sangre_tipo;
    }

    public void setNom_apl_sangre_tipo(String nom_apl_sangre_tipo) {
        this.nom_apl_sangre_tipo = nom_apl_sangre_tipo;
    }

    public String getNom_apl_cabeza() {
        return nom_apl_cabeza;
    }

    public void setNom_apl_cabeza(String nom_apl_cabeza) {
        this.nom_apl_cabeza = nom_apl_cabeza;
    }

    public String getNom_educa() {
        return nom_educa;
    }

    public void setNom_educa(String nom_educa) {
        this.nom_educa = nom_educa;
    }

    public String getNom_cargo() {
        return nom_cargo;
    }

    public void setNom_cargo(String nom_cargo) {
        this.nom_cargo = nom_cargo;
    }

    public String getNom_cargo_jefe() {
        return nom_cargo_jefe;
    }

    public void setNom_cargo_jefe(String nom_cargo_jefe) {
        this.nom_cargo_jefe = nom_cargo_jefe;
    }

    public String getDescrip_cargo() {
        return descrip_cargo;
    }

    public void setDescrip_cargo(String descrip_cargo) {
        this.descrip_cargo = descrip_cargo;
    }

    public String getNombre_titulo() {
        return nombre_titulo;
    }

    public void setNombre_titulo(String nombre_titulo) {
        this.nombre_titulo = nombre_titulo;
    }

    public String getNom_pago_forma() {
        return nom_pago_forma;
    }

    public void setNom_pago_forma(String nom_pago_forma) {
        this.nom_pago_forma = nom_pago_forma;
    }

    public String getNom_ciudad() {
        return nom_ciudad;
    }

    public void setNom_ciudad(String nom_ciudad) {
        this.nom_ciudad = nom_ciudad;
    }

    public String getNom_departamento() {
        return nom_departamento;
    }

    public void setNom_departamento(String nom_departamento) {
        this.nom_departamento = nom_departamento;
    }

    public String getNom_depto() {
        return nom_depto;
    }

    public void setNom_depto(String nom_depto) {
        this.nom_depto = nom_depto;
    }

    public String getNom_ciudad_depto() {
        return nom_ciudad_depto;
    }

    public void setNom_ciudad_depto(String nom_ciudad_depto) {
        this.nom_ciudad_depto = nom_ciudad_depto;
    }

    public String getNom_ciudad_dep() {
        return nom_ciudad_dep;
    }

    public void setNom_ciudad_dep(String nom_ciudad_dep) {
        this.nom_ciudad_dep = nom_ciudad_dep;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getDian_cod() {
        return dian_cod;
    }

    public void setDian_cod(String dian_cod) {
        this.dian_cod = dian_cod;
    }

    public int getN_nit_tip_identidad() {
        return n_nit_tip_identidad;
    }

    public void setN_nit_tip_identidad(int n_nit_tip_identidad) {
        this.n_nit_tip_identidad = n_nit_tip_identidad;
    }

    public int getN_nit_cla_sociedad() {
        return n_nit_cla_sociedad;
    }

    public void setN_nit_cla_sociedad(int n_nit_cla_sociedad) {
        this.n_nit_cla_sociedad = n_nit_cla_sociedad;
    }

    public int getN_nit_tip_contribuyente() {
        return n_nit_tip_contribuyente;
    }

    public void setN_nit_tip_contribuyente(int n_nit_tip_contribuyente) {
        this.n_nit_tip_contribuyente = n_nit_tip_contribuyente;
    }

    public int getN_nit_digni() {
        return n_nit_digni;
    }

    public void setN_nit_digni(int n_nit_digni) {
        this.n_nit_digni = n_nit_digni;
    }

    public int getN_apl_e_civil() {
        return n_apl_e_civil;
    }

    public void setN_apl_e_civil(int n_apl_e_civil) {
        this.n_apl_e_civil = n_apl_e_civil;
    }

    public int getN_nit_grupo() {
        return n_nit_grupo;
    }

    public void setN_nit_grupo(int n_nit_grupo) {
        this.n_nit_grupo = n_nit_grupo;
    }

    public int getN_apl_sexo() {
        return n_apl_sexo;
    }

    public void setN_apl_sexo(int n_apl_sexo) {
        this.n_apl_sexo = n_apl_sexo;
    }

    public int getN_apl_sangre_tipo() {
        return n_apl_sangre_tipo;
    }

    public void setN_apl_sangre_tipo(int n_apl_sangre_tipo) {
        this.n_apl_sangre_tipo = n_apl_sangre_tipo;
    }

    public int getN_emp_edu_clase() {
        return n_emp_edu_clase;
    }

    public void setN_emp_edu_clase(int n_emp_edu_clase) {
        this.n_emp_edu_clase = n_emp_edu_clase;
    }

    public int getN_periodo() {
        return n_periodo;
    }

    public void setN_periodo(int n_periodo) {
        this.n_periodo = n_periodo;
    }

    public int getN_edu_nivel() {
        return n_edu_nivel;
    }

    public void setN_edu_nivel(int n_edu_nivel) {
        this.n_edu_nivel = n_edu_nivel;
    }

    public int getN_cargo() {
        return n_cargo;
    }

    public void setN_cargo(int n_cargo) {
        this.n_cargo = n_cargo;
    }

    public String getNo_cargo() {
        return no_cargo;
    }

    public void setNo_cargo(String no_cargo) {
        this.no_cargo = no_cargo;
    }

    public int getN_cargo_jefe() {
        return n_cargo_jefe;
    }

    public void setN_cargo_jefe(int n_cargo_jefe) {
        this.n_cargo_jefe = n_cargo_jefe;
    }

    public float getCantidad_periodo() {
        return cantidad_periodo;
    }

    public void setCantidad_periodo(float cantidad_periodo) {
        this.cantidad_periodo = cantidad_periodo;
    }

    public int getN_apl_cabeza_familia() {
        return n_apl_cabeza_familia;
    }

    public void setN_apl_cabeza_familia(int n_apl_cabeza_familia) {
        this.n_apl_cabeza_familia = n_apl_cabeza_familia;
    }

    public int getN_pago_forma() {
        return n_pago_forma;
    }

    public void setN_pago_forma(int n_pago_forma) {
        this.n_pago_forma = n_pago_forma;
    }

    public String getNom_ban_compensa() {
        return nom_ban_compensa;
    }

    public void setNom_ban_compensa(String nom_ban_compensa) {
        this.nom_ban_compensa = nom_ban_compensa;
    }

    public String getIdenti_banco() {
        return identi_banco;
    }

    public void setIdenti_banco(String identi_banco) {
        this.identi_banco = identi_banco;
    }

    public String getIdenti_banco_con() {
        return identi_banco_con;
    }

    public void setIdenti_banco_con(String identi_banco_con) {
        this.identi_banco_con = identi_banco_con;
    }

    public int getN_ban_cuenta_tipo() {
        return n_ban_cuenta_tipo;
    }

    public void setN_ban_cuenta_tipo(int n_ban_cuenta_tipo) {
        this.n_ban_cuenta_tipo = n_ban_cuenta_tipo;
    }

    public String getNom_ban_cuenta_tipo() {
        return nom_ban_cuenta_tipo;
    }

    public void setNom_ban_cuenta_tipo(String nom_ban_cuenta_tipo) {
        this.nom_ban_cuenta_tipo = nom_ban_cuenta_tipo;
    }

    public String getSi_se_liq_interes() {
        return si_se_liq_interes;
    }

    public void setSi_se_liq_interes(String si_se_liq_interes) {
        this.si_se_liq_interes = si_se_liq_interes;
    }

    public boolean isLsi_jefe() {
        return lsi_jefe;
    }

    public void setLsi_jefe(boolean lsi_jefe) {
        this.lsi_jefe = lsi_jefe;
    }

    public int getSi_matricula() {
        return si_matricula;
    }

    public void setSi_matricula(int si_matricula) {
        this.si_matricula = si_matricula;
    }

    public String getSi_jefe() {
        return si_jefe;
    }

    public void setSi_jefe(String si_jefe) {
        this.si_jefe = si_jefe;
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

    public int getN_cotiza_tipo() {
        return n_cotiza_tipo;
    }

    public void setN_cotiza_tipo(int n_cotiza_tipo) {
        this.n_cotiza_tipo = n_cotiza_tipo;
    }

    public String getNom_cotiza_tipo() {
        return nom_cotiza_tipo;
    }

    public void setNom_cotiza_tipo(String nom_cotiza_tipo) {
        this.nom_cotiza_tipo = nom_cotiza_tipo;
    }

    public int getN_cotiza_subtipo() {
        return n_cotiza_subtipo;
    }

    public void setN_cotiza_subtipo(int n_cotiza_subtipo) {
        this.n_cotiza_subtipo = n_cotiza_subtipo;
    }

    public String getNom_cotiza_subtipo() {
        return nom_cotiza_subtipo;
    }

    public void setNom_cotiza_subtipo(String nom_cotiza_subtipo) {
        this.nom_cotiza_subtipo = nom_cotiza_subtipo;
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

    public int getN_emp_motivo_retiro() {
        return n_emp_motivo_retiro;
    }

    public void setN_emp_motivo_retiro(int n_emp_motivo_retiro) {
        this.n_emp_motivo_retiro = n_emp_motivo_retiro;
    }

    public String getNom_motivo_retiro() {
        return nom_motivo_retiro;
    }

    public void setNom_motivo_retiro(String nom_motivo_retiro) {
        this.nom_motivo_retiro = nom_motivo_retiro;
    }

    public String getDes_motivo_retiro() {
        return des_motivo_retiro;
    }

    public void setDes_motivo_retiro(String des_motivo_retiro) {
        this.des_motivo_retiro = des_motivo_retiro;
    }

    public String getSi_justa_causa() {
        return si_justa_causa;
    }

    public void setSi_justa_causa(String si_justa_causa) {
        this.si_justa_causa = si_justa_causa;
    }

    public int getNo_dias_preaviso() {
        return no_dias_preaviso;
    }

    public void setNo_dias_preaviso(int no_dias_preaviso) {
        this.no_dias_preaviso = no_dias_preaviso;
    }

    public int getNo_dias_avi_noti() {
        return no_dias_avi_noti;
    }

    public void setNo_dias_avi_noti(int no_dias_avi_noti) {
        this.no_dias_avi_noti = no_dias_avi_noti;
    }

    public float getDias_pru_x_100() {
        return dias_pru_x_100;
    }

    public void setDias_pru_x_100(float dias_pru_x_100) {
        this.dias_pru_x_100 = dias_pru_x_100;
    }

    public int getNo_prueba_max() {
        return no_prueba_max;
    }

    public void setNo_prueba_max(int no_prueba_max) {
        this.no_prueba_max = no_prueba_max;
    }

    public int getNo_dura_min() {
        return no_dura_min;
    }

    public void setNo_dura_min(int no_dura_min) {
        this.no_dura_min = no_dura_min;
    }

    public int getNo_dura_max() {
        return no_dura_max;
    }

    public void setNo_dura_max(int no_dura_max) {
        this.no_dura_max = no_dura_max;
    }

    public int getNo_veces_renueva() {
        return no_veces_renueva;
    }

    public void setNo_veces_renueva(int no_veces_renueva) {
        this.no_veces_renueva = no_veces_renueva;
    }

    public int getSi_vence() {
        return si_vence;
    }

    public void setSi_vence(int si_vence) {
        this.si_vence = si_vence;
    }

    public int getSi_indemniza() {
        return si_indemniza;
    }

    public void setSi_indemniza(int si_indemniza) {
        this.si_indemniza = si_indemniza;
    }

    public int getSi_pide_labor() {
        return si_pide_labor;
    }

    public void setSi_pide_labor(int si_pide_labor) {
        this.si_pide_labor = si_pide_labor;
    }

    public int getSi_aux_tran() {
        return si_aux_tran;
    }

    public void setSi_aux_tran(int si_aux_tran) {
        this.si_aux_tran = si_aux_tran;
    }

    public int getSi_salario_integral() {
        return si_salario_integral;
    }

    public void setSi_salario_integral(int si_salario_integral) {
        this.si_salario_integral = si_salario_integral;
    }

    public int getSi_pago_eps() {
        return si_pago_eps;
    }

    public void setSi_pago_eps(int si_pago_eps) {
        this.si_pago_eps = si_pago_eps;
    }

    public int getSi_pago_fdp() {
        return si_pago_fdp;
    }

    public void setSi_pago_fdp(int si_pago_fdp) {
        this.si_pago_fdp = si_pago_fdp;
    }

    public int getSi_pago_fdc() {
        return si_pago_fdc;
    }

    public void setSi_pago_fdc(int si_pago_fdc) {
        this.si_pago_fdc = si_pago_fdc;
    }

    public int getSi_pago_arl() {
        return si_pago_arl;
    }

    public void setSi_pago_arl(int si_pago_arl) {
        this.si_pago_arl = si_pago_arl;
    }

    public int getSi_pago_sena() {
        return si_pago_sena;
    }

    public void setSi_pago_sena(int si_pago_sena) {
        this.si_pago_sena = si_pago_sena;
    }

    public int getSi_pago_icbf() {
        return si_pago_icbf;
    }

    public void setSi_pago_icbf(int si_pago_icbf) {
        this.si_pago_icbf = si_pago_icbf;
    }

    public int getSi_pago_ccf() {
        return si_pago_ccf;
    }

    public void setSi_pago_ccf(int si_pago_ccf) {
        this.si_pago_ccf = si_pago_ccf;
    }

    public boolean isLsi_vence() {
        return lsi_vence;
    }

    public void setLsi_vence(boolean lsi_vence) {
        this.lsi_vence = lsi_vence;
    }

    public boolean isLsi_indemniza() {
        return lsi_indemniza;
    }

    public void setLsi_indemniza(boolean lsi_indemniza) {
        this.lsi_indemniza = lsi_indemniza;
    }

    public boolean isLsi_aux_tran() {
        return lsi_aux_tran;
    }

    public void setLsi_aux_tran(boolean lsi_aux_tran) {
        this.lsi_aux_tran = lsi_aux_tran;
    }

    public boolean isLsi_salario_integral() {
        return lsi_salario_integral;
    }

    public void setLsi_salario_integral(boolean lsi_salario_integral) {
        this.lsi_salario_integral = lsi_salario_integral;
    }

    public boolean isLsi_pide_labor() {
        return lsi_pide_labor;
    }

    public void setLsi_pide_labor(boolean lsi_pide_labor) {
        this.lsi_pide_labor = lsi_pide_labor;
    }

    public boolean isLsi_pago_eps() {
        return lsi_pago_eps;
    }

    public void setLsi_pago_eps(boolean lsi_pago_eps) {
        this.lsi_pago_eps = lsi_pago_eps;
    }

    public boolean isLsi_pago_fdp() {
        return lsi_pago_fdp;
    }

    public void setLsi_pago_fdp(boolean lsi_pago_fdp) {
        this.lsi_pago_fdp = lsi_pago_fdp;
    }

    public boolean isLsi_pago_fdc() {
        return lsi_pago_fdc;
    }

    public void setLsi_pago_fdc(boolean lsi_pago_fdc) {
        this.lsi_pago_fdc = lsi_pago_fdc;
    }

    public boolean isLsi_pago_arl() {
        return lsi_pago_arl;
    }

    public void setLsi_pago_arl(boolean lsi_pago_arl) {
        this.lsi_pago_arl = lsi_pago_arl;
    }

    public boolean isLsi_pago_sena() {
        return lsi_pago_sena;
    }

    public void setLsi_pago_sena(boolean lsi_pago_sena) {
        this.lsi_pago_sena = lsi_pago_sena;
    }

    public boolean isLsi_pago_icbf() {
        return lsi_pago_icbf;
    }

    public void setLsi_pago_icbf(boolean lsi_pago_icbf) {
        this.lsi_pago_icbf = lsi_pago_icbf;
    }

    public boolean isLsi_pago_ccf() {
        return lsi_pago_ccf;
    }

    public void setLsi_pago_ccf(boolean lsi_pago_ccf) {
        this.lsi_pago_ccf = lsi_pago_ccf;
    }

    public String getSi_se_vence() {
        return si_se_vence;
    }

    public void setSi_se_vence(String si_se_vence) {
        this.si_se_vence = si_se_vence;
    }

    public String getSi_se_indemniza() {
        return si_se_indemniza;
    }

    public void setSi_se_indemniza(String si_se_indemniza) {
        this.si_se_indemniza = si_se_indemniza;
    }

    public String getSi_es_aux_tran() {
        return si_es_aux_tran;
    }

    public void setSi_es_aux_tran(String si_es_aux_tran) {
        this.si_es_aux_tran = si_es_aux_tran;
    }

    public String getSi_es_salario_integral() {
        return si_es_salario_integral;
    }

    public void setSi_es_salario_integral(String si_es_salario_integral) {
        this.si_es_salario_integral = si_es_salario_integral;
    }

    public String getSi_se_pide_labor() {
        return si_se_pide_labor;
    }

    public void setSi_se_pide_labor(String si_se_pide_labor) {
        this.si_se_pide_labor = si_se_pide_labor;
    }

    public String getSi_se_pago_eps() {
        return si_se_pago_eps;
    }

    public void setSi_se_pago_eps(String si_se_pago_eps) {
        this.si_se_pago_eps = si_se_pago_eps;
    }

    public String getSi_se_pago_fdp() {
        return si_se_pago_fdp;
    }

    public void setSi_se_pago_fdp(String si_se_pago_fdp) {
        this.si_se_pago_fdp = si_se_pago_fdp;
    }

    public String getSi_se_pago_fdc() {
        return si_se_pago_fdc;
    }

    public void setSi_se_pago_fdc(String si_se_pago_fdc) {
        this.si_se_pago_fdc = si_se_pago_fdc;
    }

    public String getSi_se_pago_arl() {
        return si_se_pago_arl;
    }

    public void setSi_se_pago_arl(String si_se_pago_arl) {
        this.si_se_pago_arl = si_se_pago_arl;
    }

    public String getSi_se_pago_sena() {
        return si_se_pago_sena;
    }

    public void setSi_se_pago_sena(String si_se_pago_sena) {
        this.si_se_pago_sena = si_se_pago_sena;
    }

    public String getSi_se_pago_icbf() {
        return si_se_pago_icbf;
    }

    public void setSi_se_pago_icbf(String si_se_pago_icbf) {
        this.si_se_pago_icbf = si_se_pago_icbf;
    }

    public String getSi_se_pago_ccf() {
        return si_se_pago_ccf;
    }

    public void setSi_se_pago_ccf(String si_se_pago_ccf) {
        this.si_se_pago_ccf = si_se_pago_ccf;
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

    public int getN_apl_perio_pago() {
        return n_apl_perio_pago;
    }

    public void setN_apl_perio_pago(int n_apl_perio_pago) {
        this.n_apl_perio_pago = n_apl_perio_pago;
    }

    public int getN_apl_grupo() {
        return n_apl_grupo;
    }

    public void setN_apl_grupo(int n_apl_grupo) {
        this.n_apl_grupo = n_apl_grupo;
    }

    public int getN_apl_cta_sufijo() {
        return n_apl_cta_sufijo;
    }

    public void setN_apl_cta_sufijo(int n_apl_cta_sufijo) {
        this.n_apl_cta_sufijo = n_apl_cta_sufijo;
    }

    public String getCta_sufijo() {
        return cta_sufijo;
    }

    public void setCta_sufijo(String cta_sufijo) {
        this.cta_sufijo = cta_sufijo;
    }

    public int getN_apl_uni_medida() {
        return n_apl_uni_medida;
    }

    public void setN_apl_uni_medida(int n_apl_uni_medida) {
        this.n_apl_uni_medida = n_apl_uni_medida;
    }

    public int getN_apl_uni_medida_padre() {
        return n_apl_uni_medida_padre;
    }

    public void setN_apl_uni_medida_padre(int n_apl_uni_medida_padre) {
        this.n_apl_uni_medida_padre = n_apl_uni_medida_padre;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getMascara() {
        return mascara;
    }

    public void setMascara(String mascara) {
        this.mascara = mascara;
    }

}