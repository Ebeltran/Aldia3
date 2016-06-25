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
public class Nit implements Serializable {
    
    private static final long serialVersionUID = -3456377722495549921L;
    private String identi;
    private String identi_con;
    private String d_v;
    private int n_rotulo;
    private String razon_social;
    private String nombre_1;
    private String nombre_2;
    private String apellido_1;
    private String apellido_2;
    private String razon_comercial;
    
    private int n_nit_tip_identidad;
    private int n_nit_cla_sociedad;
    private int n_nit_tip_contribuyente;
    private int n_apl_e_civil;
    private int n_apl_sexo;
    private int n_apl_sangre_tipo;
        
    private int n_apl_ciudad_nace;
    private int n_apl_ciudad;
    
    private String nom_nit_tip_identidad;
    private String nom_nit_cla_sociedad;
    private String nom_nit_tip_contribuyente;
    private String nom_apl_e_civil;
    private String nom_apl_sexo;
    private String nom_apl_sangre_tipo;
    
    private String nom_apl_ciudad_nace;
    private String nom_apl_ciudad;
    
    private boolean si_es_cli;
    private boolean si_es_ter;
    private boolean si_es_emp;
    private boolean si_es_ban;
    private boolean si_es_cia;
    private boolean si_es_auto_rf;
    private boolean si_es_activo;
    
    private String si_cli;
    private String si_ter;
    private String si_emp;
    private String si_ban;
    private String si_cia;
    private String si_auto_rf;
    private String si_activo;

    private String direccion;
    private String telefono;
    private String tel_aux;
    private String fax;
    private String barrio;
    private String e_mail;
    private String e_mail_a;
    private String pagina_web;
    private float latitud;
    private float longitud;
   
    private String query; 
    private String queryCiudad; 
    private String queryCiudadNace; 
    private String nombre;
    private int n_nit_digni;
    
    private boolean lpersona;
    private boolean ljuridica;
    private String mensaje;
    
    private Date fec_nace;
    private Date fecha;
    private Date fec_desde;
    private Date fec_hasta;
    
    private String[] nit_es;
    private String nom_nit_grupo;
    
    private int n_aplciudad_padre;
    private String ciudad;
    private String depto;
    private String nacionalidad;
    
    public Nit() {
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

    public String getD_v() {
        return d_v;
    }

    public void setD_v(String d_v) {
        this.d_v = d_v;
    }

    public int getN_rotulo() {
        return n_rotulo;
    }

    public void setN_rotulo(int n_rotulo) {
        this.n_rotulo = n_rotulo;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
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

    public String getRazon_comercial() {
        return razon_comercial;
    }

    public void setRazon_comercial(String razon_comercial) {
        this.razon_comercial = razon_comercial;
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

    public int getN_apl_sangre_tipo() {
        return n_apl_sangre_tipo;
    }

    public void setN_apl_sangre_tipo(int n_apl_sangre_tipo) {
        this.n_apl_sangre_tipo = n_apl_sangre_tipo;
    }

    public int getN_apl_ciudad_nace() {
        return n_apl_ciudad_nace;
    }

    public void setN_apl_ciudad_nace(int n_apl_ciudad_nace) {
        this.n_apl_ciudad_nace = n_apl_ciudad_nace;
    }

    public int getN_apl_ciudad() {
        return n_apl_ciudad;
    }

    public void setN_apl_ciudad(int n_apl_ciudad) {
        this.n_apl_ciudad = n_apl_ciudad;
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

    public String getNom_apl_e_civil() {
        return nom_apl_e_civil;
    }

    public void setNom_apl_e_civil(String nom_apl_e_civil) {
        this.nom_apl_e_civil = nom_apl_e_civil;
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

    public String getNom_apl_ciudad_nace() {
        return nom_apl_ciudad_nace;
    }

    public void setNom_apl_ciudad_nace(String nom_apl_ciudad_nace) {
        this.nom_apl_ciudad_nace = nom_apl_ciudad_nace;
    }

    public String getNom_apl_ciudad() {
        return nom_apl_ciudad;
    }

    public void setNom_apl_ciudad(String nom_apl_ciudad) {
        this.nom_apl_ciudad = nom_apl_ciudad;
    }

    public boolean isSi_es_cli() {
        return si_es_cli;
    }

    public void setSi_es_cli(boolean si_es_cli) {
        this.si_es_cli = si_es_cli;
    }

    public boolean isSi_es_ter() {
        return si_es_ter;
    }

    public void setSi_es_ter(boolean si_es_ter) {
        this.si_es_ter = si_es_ter;
    }

    public boolean isSi_es_emp() {
        return si_es_emp;
    }

    public void setSi_es_emp(boolean si_es_emp) {
        this.si_es_emp = si_es_emp;
    }

    public boolean isSi_es_ban() {
        return si_es_ban;
    }

    public void setSi_es_ban(boolean si_es_ban) {
        this.si_es_ban = si_es_ban;
    }

    public boolean isSi_es_cia() {
        return si_es_cia;
    }

    public void setSi_es_cia(boolean si_es_cia) {
        this.si_es_cia = si_es_cia;
    }

    public boolean isSi_es_auto_rf() {
        return si_es_auto_rf;
    }

    public void setSi_es_auto_rf(boolean si_es_auto_rf) {
        this.si_es_auto_rf = si_es_auto_rf;
    }

    public boolean isSi_es_activo() {
        return si_es_activo;
    }

    public void setSi_es_activo(boolean si_es_activo) {
        this.si_es_activo = si_es_activo;
    }

    public String getSi_cli() {
        return si_cli;
    }

    public void setSi_cli(String si_cli) {
        this.si_cli = si_cli;
    }

    public String getSi_ter() {
        return si_ter;
    }

    public void setSi_ter(String si_ter) {
        this.si_ter = si_ter;
    }

    public String getSi_emp() {
        return si_emp;
    }

    public void setSi_emp(String si_emp) {
        this.si_emp = si_emp;
    }

    public String getSi_ban() {
        return si_ban;
    }

    public void setSi_ban(String si_ban) {
        this.si_ban = si_ban;
    }

    public String getSi_cia() {
        return si_cia;
    }

    public void setSi_cia(String si_cia) {
        this.si_cia = si_cia;
    }

    public String getSi_auto_rf() {
        return si_auto_rf;
    }

    public void setSi_auto_rf(String si_auto_rf) {
        this.si_auto_rf = si_auto_rf;
    }

    public String getSi_activo() {
        return si_activo;
    }

    public void setSi_activo(String si_activo) {
        this.si_activo = si_activo;
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

    public String getQueryCiudadNace() {
        return queryCiudadNace;
    }

    public void setQueryCiudadNace(String queryCiudadNace) {
        this.queryCiudadNace = queryCiudadNace;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getN_nit_digni() {
        return n_nit_digni;
    }

    public void setN_nit_digni(int n_nit_digni) {
        this.n_nit_digni = n_nit_digni;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFec_nace() {
        return fec_nace;
    }

    public void setFec_nace(Date fec_nace) {
        this.fec_nace = fec_nace;
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

    public String[] getNit_es() {
        return nit_es;
    }

    public void setNit_es(String[] nit_es) {
        this.nit_es = nit_es;
    }

    public String getNom_nit_grupo() {
        return nom_nit_grupo;
    }

    public void setNom_nit_grupo(String nom_nit_grupo) {
        this.nom_nit_grupo = nom_nit_grupo;
    }

    public int getN_aplciudad_padre() {
        return n_aplciudad_padre;
    }

    public void setN_aplciudad_padre(int n_aplciudad_padre) {
        this.n_aplciudad_padre = n_aplciudad_padre;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
   
}
