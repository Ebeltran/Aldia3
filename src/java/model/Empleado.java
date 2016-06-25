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
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String tipo_doc;
    private String identi;
    private String identi_con;
    private int no_con_trabajo;
    private String d_v;
    private String dian_cod;
    
    private String identi_eps;
    private String identi_fdp;
    private String identi_fdc;
    private String identi_arl;
    private String identi_ccf;
    
    private String identi_eps_con;
    private String identi_fdp_con;
    private String identi_fdc_con;
    
    private String razon_eps;
    private String razon_fdp;
    private String razon_fdc;
    private String razon_arl;
    private String razon_ccf;
    
    private String nombre_1;
    private String nombre_2;
    private String apellido_1;
    private String apellido_2;
    private String apellidos_nombres;
    private String nombres_apellidos;
    private String nombre_apellido;
    private String con_trabajo;
    private String con_trabajo_padre;
    private String estado_laboral;
    private String cen_costo;
    private String cargo;
    private String cargo_jefe;
    
    private String nom_horario;
    private String pago_periodo;
    private String motivo_retiro;
    private String jornada;
    private String tarifa_arl;
    private String ciudad_contra;
    private String ciudad_trabaja;
    private String ciudad_firma;
    private String ciudad_firma_dep;
    private String ciudad_contra_dep;
    private String ciudad_trabaja_dep;
    private String dfecha_inicia;
    private String dfecha_final;
    private String dfecha_retiro;
    private String dfecha_prueba;
    private String dfecha_impresion;
    private String dfecha_firma;
    private String texto_salario_inicial;
    private String texto_salario_ultimo;
    private Date fecha_salario_cambio;
    private int no_renovacion;
    private int no_impresion;
    
    private Date fecha_inicia;
    private Date fecha_final;
    private Date fecha_firma_contra;
    private Date fecha_retiro;
    private Date fecha_prueba;
    private Date fecha_auxiliar;
    private Date fecha_impresion;
    private Date fecha_desde;
    private Date fecha_hasta;
    
    private int mes_cumple;    
    private int dia_cumple;    
    
    private int n_apl_ciudad;
    private int n_nit_tip_identidad;
    private int n_nit_tip_contribuyente;
    private int n_rotulo;
    private int n_emp_estado_laboral;
    private int n_centro_costo;
    private int n_tipo_contrato;
    
    private String costo;
    private String codo;
    
    private int n_apl_e_civil;
    private int n_apl_sexo;
    private int n_ciudad_nace;
    private int n_ciudad_contrata;
    private int n_ciudad_trabaja;
    private int n_cargo;
    
    private int id_ban_cuenta;
    private int n_cuenta_tipo;
    private int n_emp_pago_forma;
    private float vr_salario_inicial;
    private float vr_salario_ultimo;
    private int n_emp_pago_clase;
    private int n_apl_moneda;
    private String si_salario_especie;
    
    private float vr_tarifa_arl;

    private int n_emp_motivo_retiro;
    private String nom_motivo_retiro;
    private String des_motivo_retiro;
    private int no_dias_preaviso;
    
    private Boolean si_activo;
    private Boolean si_contrato_firmado;
    private Boolean si_justa_causa;
    private Boolean si_salario_integral;
    private Boolean si_pago_aux_tran;
    
    private Boolean si_apor_eps;
    private Boolean si_apor_fdp;
    private Boolean si_apor_fdc;
    private Boolean si_apor_arl;
    private Boolean si_apor_sena;
    private Boolean si_apor_icbf;
    private Boolean si_apor_ccf;
    
    private Boolean si_liquidado;
    private Boolean si_cabeza_familia;
    private Boolean si_pago_a_transporte;
    private Boolean si_sal_integral;
    
    private String si_es_activo;
    private String si_es_contrato_firmado;
    private String si_es_justa_causa;
    private String si_es_salario_integral;
    private String si_es_pago_aux_tran;
    
    private String si_se_pago_;
    private String si_se_apor_fdp;
    private String si_se_apor_fdc;
    private String si_se_apor_arl;
    private String si_se_apor_sena;
    private String si_se_apor_icbf;
    private String si_se_apor_ccf;
    
    private String si_es_liquidado;
    private String si_es_cabeza_familia;
    
    private String nom_nit_tip_identidad;
    private String nom_nit_tip_contribuyente;
    
    private String pago_forma;
    private String identi_banco;
    private String identi_banco_con;
    private String nombre_banco;
    private String ban_sucursal;
    private String cuenta_tipo;
    private String cuenta_cta;
    private String cuenta_cta_con;
    private int n_ban_cuenta_tipo;
    
    private String direccion;
    private String telefono;
    private String telefax;
    private String tel_uno;
    private String tel_aux;
    private String fax;
    private String e_mail_a;
    private String barrio;
    private String e_mail;
    
    private String ciudad;
    private String depto;
    private String departamento;
    private String ciudad_depto;
    private String ciudad_dep;
    private String pagina_web;
    private float latitud;
    private float longitud;
    
    private int n_apl_doc_pendiente;
    private String nom_apl_doc_pendiente;
    
    private String reporte_nombre;
    private String mensaje;
    private String ruta_resources;
    private boolean lpersona;
    
    private boolean lpagoforma;
    private boolean lsieps;
    private boolean lsifdp;
    private boolean lsifdc;
    private int id_documen;
    
    public Empleado() {

    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
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

    public int getNo_con_trabajo() {
        return no_con_trabajo;
    }

    public void setNo_con_trabajo(int no_con_trabajo) {
        this.no_con_trabajo = no_con_trabajo;
    }

    public String getD_v() {
        return d_v;
    }

    public void setD_v(String d_v) {
        this.d_v = d_v;
    }

    public String getDian_cod() {
        return dian_cod;
    }

    public void setDian_cod(String dian_cod) {
        this.dian_cod = dian_cod;
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

    public String getIdenti_arl() {
        return identi_arl;
    }

    public void setIdenti_arl(String identi_arl) {
        this.identi_arl = identi_arl;
    }

    public String getIdenti_ccf() {
        return identi_ccf;
    }

    public void setIdenti_ccf(String identi_ccf) {
        this.identi_ccf = identi_ccf;
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

    public String getRazon_arl() {
        return razon_arl;
    }

    public void setRazon_arl(String razon_arl) {
        this.razon_arl = razon_arl;
    }

    public String getRazon_ccf() {
        return razon_ccf;
    }

    public void setRazon_ccf(String razon_ccf) {
        this.razon_ccf = razon_ccf;
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

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getCon_trabajo() {
        return con_trabajo;
    }

    public void setCon_trabajo(String con_trabajo) {
        this.con_trabajo = con_trabajo;
    }

    public String getCon_trabajo_padre() {
        return con_trabajo_padre;
    }

    public void setCon_trabajo_padre(String con_trabajo_padre) {
        this.con_trabajo_padre = con_trabajo_padre;
    }

    public String getEstado_laboral() {
        return estado_laboral;
    }

    public void setEstado_laboral(String estado_laboral) {
        this.estado_laboral = estado_laboral;
    }

    public String getCen_costo() {
        return cen_costo;
    }

    public void setCen_costo(String cen_costo) {
        this.cen_costo = cen_costo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo_jefe() {
        return cargo_jefe;
    }

    public void setCargo_jefe(String cargo_jefe) {
        this.cargo_jefe = cargo_jefe;
    }

    public String getNom_horario() {
        return nom_horario;
    }

    public void setNom_horario(String nom_horario) {
        this.nom_horario = nom_horario;
    }

    public String getPago_periodo() {
        return pago_periodo;
    }

    public void setPago_periodo(String pago_periodo) {
        this.pago_periodo = pago_periodo;
    }

    public String getMotivo_retiro() {
        return motivo_retiro;
    }

    public void setMotivo_retiro(String motivo_retiro) {
        this.motivo_retiro = motivo_retiro;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getTarifa_arl() {
        return tarifa_arl;
    }

    public void setTarifa_arl(String tarifa_arl) {
        this.tarifa_arl = tarifa_arl;
    }

    public String getCiudad_contra() {
        return ciudad_contra;
    }

    public void setCiudad_contra(String ciudad_contra) {
        this.ciudad_contra = ciudad_contra;
    }

    public String getCiudad_trabaja() {
        return ciudad_trabaja;
    }

    public void setCiudad_trabaja(String ciudad_trabaja) {
        this.ciudad_trabaja = ciudad_trabaja;
    }

    public String getCiudad_firma() {
        return ciudad_firma;
    }

    public void setCiudad_firma(String ciudad_firma) {
        this.ciudad_firma = ciudad_firma;
    }

    public String getCiudad_firma_dep() {
        return ciudad_firma_dep;
    }

    public void setCiudad_firma_dep(String ciudad_firma_dep) {
        this.ciudad_firma_dep = ciudad_firma_dep;
    }

    public String getCiudad_contra_dep() {
        return ciudad_contra_dep;
    }

    public void setCiudad_contra_dep(String ciudad_contra_dep) {
        this.ciudad_contra_dep = ciudad_contra_dep;
    }

    public String getCiudad_trabaja_dep() {
        return ciudad_trabaja_dep;
    }

    public void setCiudad_trabaja_dep(String ciudad_trabaja_dep) {
        this.ciudad_trabaja_dep = ciudad_trabaja_dep;
    }

    public String getDfecha_inicia() {
        return dfecha_inicia;
    }

    public void setDfecha_inicia(String dfecha_inicia) {
        this.dfecha_inicia = dfecha_inicia;
    }

    public String getDfecha_final() {
        return dfecha_final;
    }

    public void setDfecha_final(String dfecha_final) {
        this.dfecha_final = dfecha_final;
    }

    public String getDfecha_retiro() {
        return dfecha_retiro;
    }

    public void setDfecha_retiro(String dfecha_retiro) {
        this.dfecha_retiro = dfecha_retiro;
    }

    public String getDfecha_prueba() {
        return dfecha_prueba;
    }

    public void setDfecha_prueba(String dfecha_prueba) {
        this.dfecha_prueba = dfecha_prueba;
    }

    public String getDfecha_impresion() {
        return dfecha_impresion;
    }

    public void setDfecha_impresion(String dfecha_impresion) {
        this.dfecha_impresion = dfecha_impresion;
    }

    public String getDfecha_firma() {
        return dfecha_firma;
    }

    public void setDfecha_firma(String dfecha_firma) {
        this.dfecha_firma = dfecha_firma;
    }

    public String getTexto_salario_inicial() {
        return texto_salario_inicial;
    }

    public void setTexto_salario_inicial(String texto_salario_inicial) {
        this.texto_salario_inicial = texto_salario_inicial;
    }

    public String getTexto_salario_ultimo() {
        return texto_salario_ultimo;
    }

    public void setTexto_salario_ultimo(String texto_salario_ultimo) {
        this.texto_salario_ultimo = texto_salario_ultimo;
    }

    public Date getFecha_salario_cambio() {
        return fecha_salario_cambio;
    }

    public void setFecha_salario_cambio(Date fecha_salario_cambio) {
        this.fecha_salario_cambio = fecha_salario_cambio;
    }

    public int getNo_renovacion() {
        return no_renovacion;
    }

    public void setNo_renovacion(int no_renovacion) {
        this.no_renovacion = no_renovacion;
    }

    public int getNo_impresion() {
        return no_impresion;
    }

    public void setNo_impresion(int no_impresion) {
        this.no_impresion = no_impresion;
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

    public Date getFecha_firma_contra() {
        return fecha_firma_contra;
    }

    public void setFecha_firma_contra(Date fecha_firma_contra) {
        this.fecha_firma_contra = fecha_firma_contra;
    }

    public Date getFecha_retiro() {
        return fecha_retiro;
    }

    public void setFecha_retiro(Date fecha_retiro) {
        this.fecha_retiro = fecha_retiro;
    }

    public Date getFecha_prueba() {
        return fecha_prueba;
    }

    public void setFecha_prueba(Date fecha_prueba) {
        this.fecha_prueba = fecha_prueba;
    }

    public Date getFecha_auxiliar() {
        return fecha_auxiliar;
    }

    public void setFecha_auxiliar(Date fecha_auxiliar) {
        this.fecha_auxiliar = fecha_auxiliar;
    }

    public Date getFecha_impresion() {
        return fecha_impresion;
    }

    public void setFecha_impresion(Date fecha_impresion) {
        this.fecha_impresion = fecha_impresion;
    }

    public Date getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Date fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public Date getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(Date fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public int getMes_cumple() {
        return mes_cumple;
    }

    public void setMes_cumple(int mes_cumple) {
        this.mes_cumple = mes_cumple;
    }

    public int getDia_cumple() {
        return dia_cumple;
    }

    public void setDia_cumple(int dia_cumple) {
        this.dia_cumple = dia_cumple;
    }

    public int getN_apl_ciudad() {
        return n_apl_ciudad;
    }

    public void setN_apl_ciudad(int n_apl_ciudad) {
        this.n_apl_ciudad = n_apl_ciudad;
    }

    public int getN_nit_tip_identidad() {
        return n_nit_tip_identidad;
    }

    public void setN_nit_tip_identidad(int n_nit_tip_identidad) {
        this.n_nit_tip_identidad = n_nit_tip_identidad;
    }

    public int getN_nit_tip_contribuyente() {
        return n_nit_tip_contribuyente;
    }

    public void setN_nit_tip_contribuyente(int n_nit_tip_contribuyente) {
        this.n_nit_tip_contribuyente = n_nit_tip_contribuyente;
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

    public int getN_centro_costo() {
        return n_centro_costo;
    }

    public void setN_centro_costo(int n_centro_costo) {
        this.n_centro_costo = n_centro_costo;
    }

    public int getN_tipo_contrato() {
        return n_tipo_contrato;
    }

    public void setN_tipo_contrato(int n_tipo_contrato) {
        this.n_tipo_contrato = n_tipo_contrato;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getCodo() {
        return codo;
    }

    public void setCodo(String codo) {
        this.codo = codo;
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

    public int getN_ciudad_nace() {
        return n_ciudad_nace;
    }

    public void setN_ciudad_nace(int n_ciudad_nace) {
        this.n_ciudad_nace = n_ciudad_nace;
    }

    public int getN_ciudad_contrata() {
        return n_ciudad_contrata;
    }

    public void setN_ciudad_contrata(int n_ciudad_contrata) {
        this.n_ciudad_contrata = n_ciudad_contrata;
    }

    public int getN_ciudad_trabaja() {
        return n_ciudad_trabaja;
    }

    public void setN_ciudad_trabaja(int n_ciudad_trabaja) {
        this.n_ciudad_trabaja = n_ciudad_trabaja;
    }

    public int getN_cargo() {
        return n_cargo;
    }

    public void setN_cargo(int n_cargo) {
        this.n_cargo = n_cargo;
    }

    public int getId_ban_cuenta() {
        return id_ban_cuenta;
    }

    public void setId_ban_cuenta(int id_ban_cuenta) {
        this.id_ban_cuenta = id_ban_cuenta;
    }

    public int getN_cuenta_tipo() {
        return n_cuenta_tipo;
    }

    public void setN_cuenta_tipo(int n_cuenta_tipo) {
        this.n_cuenta_tipo = n_cuenta_tipo;
    }

    public int getN_emp_pago_forma() {
        return n_emp_pago_forma;
    }

    public void setN_emp_pago_forma(int n_emp_pago_forma) {
        this.n_emp_pago_forma = n_emp_pago_forma;
    }

    public float getVr_salario_inicial() {
        return vr_salario_inicial;
    }

    public void setVr_salario_inicial(float vr_salario_inicial) {
        this.vr_salario_inicial = vr_salario_inicial;
    }

    public float getVr_salario_ultimo() {
        return vr_salario_ultimo;
    }

    public void setVr_salario_ultimo(float vr_salario_ultimo) {
        this.vr_salario_ultimo = vr_salario_ultimo;
    }

    public int getN_emp_pago_clase() {
        return n_emp_pago_clase;
    }

    public void setN_emp_pago_clase(int n_emp_pago_clase) {
        this.n_emp_pago_clase = n_emp_pago_clase;
    }

    public int getN_apl_moneda() {
        return n_apl_moneda;
    }

    public void setN_apl_moneda(int n_apl_moneda) {
        this.n_apl_moneda = n_apl_moneda;
    }

    public String getSi_salario_especie() {
        return si_salario_especie;
    }

    public void setSi_salario_especie(String si_salario_especie) {
        this.si_salario_especie = si_salario_especie;
    }

    public float getVr_tarifa_arl() {
        return vr_tarifa_arl;
    }

    public void setVr_tarifa_arl(float vr_tarifa_arl) {
        this.vr_tarifa_arl = vr_tarifa_arl;
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

    public int getNo_dias_preaviso() {
        return no_dias_preaviso;
    }

    public void setNo_dias_preaviso(int no_dias_preaviso) {
        this.no_dias_preaviso = no_dias_preaviso;
    }

    public Boolean getSi_activo() {
        return si_activo;
    }

    public void setSi_activo(Boolean si_activo) {
        this.si_activo = si_activo;
    }

    public Boolean getSi_contrato_firmado() {
        return si_contrato_firmado;
    }

    public void setSi_contrato_firmado(Boolean si_contrato_firmado) {
        this.si_contrato_firmado = si_contrato_firmado;
    }

    public Boolean getSi_justa_causa() {
        return si_justa_causa;
    }

    public void setSi_justa_causa(Boolean si_justa_causa) {
        this.si_justa_causa = si_justa_causa;
    }

    public Boolean getSi_salario_integral() {
        return si_salario_integral;
    }

    public void setSi_salario_integral(Boolean si_salario_integral) {
        this.si_salario_integral = si_salario_integral;
    }

    public Boolean getSi_pago_aux_tran() {
        return si_pago_aux_tran;
    }

    public void setSi_pago_aux_tran(Boolean si_pago_aux_tran) {
        this.si_pago_aux_tran = si_pago_aux_tran;
    }

    public Boolean getSi_apor_eps() {
        return si_apor_eps;
    }

    public void setSi_apor_eps(Boolean si_apor_eps) {
        this.si_apor_eps = si_apor_eps;
    }

    public Boolean getSi_apor_fdp() {
        return si_apor_fdp;
    }

    public void setSi_apor_fdp(Boolean si_apor_fdp) {
        this.si_apor_fdp = si_apor_fdp;
    }

    public Boolean getSi_apor_fdc() {
        return si_apor_fdc;
    }

    public void setSi_apor_fdc(Boolean si_apor_fdc) {
        this.si_apor_fdc = si_apor_fdc;
    }

    public Boolean getSi_apor_arl() {
        return si_apor_arl;
    }

    public void setSi_apor_arl(Boolean si_apor_arl) {
        this.si_apor_arl = si_apor_arl;
    }

    public Boolean getSi_apor_sena() {
        return si_apor_sena;
    }

    public void setSi_apor_sena(Boolean si_apor_sena) {
        this.si_apor_sena = si_apor_sena;
    }

    public Boolean getSi_apor_icbf() {
        return si_apor_icbf;
    }

    public void setSi_apor_icbf(Boolean si_apor_icbf) {
        this.si_apor_icbf = si_apor_icbf;
    }

    public Boolean getSi_apor_ccf() {
        return si_apor_ccf;
    }

    public void setSi_apor_ccf(Boolean si_apor_ccf) {
        this.si_apor_ccf = si_apor_ccf;
    }

    public Boolean getSi_liquidado() {
        return si_liquidado;
    }

    public void setSi_liquidado(Boolean si_liquidado) {
        this.si_liquidado = si_liquidado;
    }

    public Boolean getSi_cabeza_familia() {
        return si_cabeza_familia;
    }

    public void setSi_cabeza_familia(Boolean si_cabeza_familia) {
        this.si_cabeza_familia = si_cabeza_familia;
    }

    public Boolean getSi_pago_a_transporte() {
        return si_pago_a_transporte;
    }

    public void setSi_pago_a_transporte(Boolean si_pago_a_transporte) {
        this.si_pago_a_transporte = si_pago_a_transporte;
    }

    public Boolean getSi_sal_integral() {
        return si_sal_integral;
    }

    public void setSi_sal_integral(Boolean si_sal_integral) {
        this.si_sal_integral = si_sal_integral;
    }

    public String getSi_es_activo() {
        return si_es_activo;
    }

    public void setSi_es_activo(String si_es_activo) {
        this.si_es_activo = si_es_activo;
    }

    public String getSi_es_contrato_firmado() {
        return si_es_contrato_firmado;
    }

    public void setSi_es_contrato_firmado(String si_es_contrato_firmado) {
        this.si_es_contrato_firmado = si_es_contrato_firmado;
    }

    public String getSi_es_justa_causa() {
        return si_es_justa_causa;
    }

    public void setSi_es_justa_causa(String si_es_justa_causa) {
        this.si_es_justa_causa = si_es_justa_causa;
    }

    public String getSi_es_salario_integral() {
        return si_es_salario_integral;
    }

    public void setSi_es_salario_integral(String si_es_salario_integral) {
        this.si_es_salario_integral = si_es_salario_integral;
    }

    public String getSi_es_pago_aux_tran() {
        return si_es_pago_aux_tran;
    }

    public void setSi_es_pago_aux_tran(String si_es_pago_aux_tran) {
        this.si_es_pago_aux_tran = si_es_pago_aux_tran;
    }

    public String getSi_se_pago_() {
        return si_se_pago_;
    }

    public void setSi_se_pago_(String si_se_pago_) {
        this.si_se_pago_ = si_se_pago_;
    }

    public String getSi_se_apor_fdp() {
        return si_se_apor_fdp;
    }

    public void setSi_se_apor_fdp(String si_se_apor_fdp) {
        this.si_se_apor_fdp = si_se_apor_fdp;
    }

    public String getSi_se_apor_fdc() {
        return si_se_apor_fdc;
    }

    public void setSi_se_apor_fdc(String si_se_apor_fdc) {
        this.si_se_apor_fdc = si_se_apor_fdc;
    }

    public String getSi_se_apor_arl() {
        return si_se_apor_arl;
    }

    public void setSi_se_apor_arl(String si_se_apor_arl) {
        this.si_se_apor_arl = si_se_apor_arl;
    }

    public String getSi_se_apor_sena() {
        return si_se_apor_sena;
    }

    public void setSi_se_apor_sena(String si_se_apor_sena) {
        this.si_se_apor_sena = si_se_apor_sena;
    }

    public String getSi_se_apor_icbf() {
        return si_se_apor_icbf;
    }

    public void setSi_se_apor_icbf(String si_se_apor_icbf) {
        this.si_se_apor_icbf = si_se_apor_icbf;
    }

    public String getSi_se_apor_ccf() {
        return si_se_apor_ccf;
    }

    public void setSi_se_apor_ccf(String si_se_apor_ccf) {
        this.si_se_apor_ccf = si_se_apor_ccf;
    }

    public String getSi_es_liquidado() {
        return si_es_liquidado;
    }

    public void setSi_es_liquidado(String si_es_liquidado) {
        this.si_es_liquidado = si_es_liquidado;
    }

    public String getSi_es_cabeza_familia() {
        return si_es_cabeza_familia;
    }

    public void setSi_es_cabeza_familia(String si_es_cabeza_familia) {
        this.si_es_cabeza_familia = si_es_cabeza_familia;
    }

    public String getNom_nit_tip_identidad() {
        return nom_nit_tip_identidad;
    }

    public void setNom_nit_tip_identidad(String nom_nit_tip_identidad) {
        this.nom_nit_tip_identidad = nom_nit_tip_identidad;
    }

    public String getNom_nit_tip_contribuyente() {
        return nom_nit_tip_contribuyente;
    }

    public void setNom_nit_tip_contribuyente(String nom_nit_tip_contribuyente) {
        this.nom_nit_tip_contribuyente = nom_nit_tip_contribuyente;
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

    public int getN_ban_cuenta_tipo() {
        return n_ban_cuenta_tipo;
    }

    public void setN_ban_cuenta_tipo(int n_ban_cuenta_tipo) {
        this.n_ban_cuenta_tipo = n_ban_cuenta_tipo;
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

    public String getTelefax() {
        return telefax;
    }

    public void setTelefax(String telefax) {
        this.telefax = telefax;
    }

    public String getTel_uno() {
        return tel_uno;
    }

    public void setTel_uno(String tel_uno) {
        this.tel_uno = tel_uno;
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

    public String getE_mail_a() {
        return e_mail_a;
    }

    public void setE_mail_a(String e_mail_a) {
        this.e_mail_a = e_mail_a;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
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

    public String getReporte_nombre() {
        return reporte_nombre;
    }

    public void setReporte_nombre(String reporte_nombre) {
        this.reporte_nombre = reporte_nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRuta_resources() {
        return ruta_resources;
    }

    public void setRuta_resources(String ruta_resources) {
        this.ruta_resources = ruta_resources;
    }

    public boolean isLpersona() {
        return lpersona;
    }

    public void setLpersona(boolean lpersona) {
        this.lpersona = lpersona;
    }

    public boolean isLpagoforma() {
        return lpagoforma;
    }

    public void setLpagoforma(boolean lpagoforma) {
        this.lpagoforma = lpagoforma;
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

    public int getId_documen() {
        return id_documen;
    }

    public void setId_documen(int id_documen) {
        this.id_documen = id_documen;
    }

}