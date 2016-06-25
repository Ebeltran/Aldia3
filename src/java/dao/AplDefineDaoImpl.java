/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.AplDefine;
import util.MyUtilFormat;

/**
 *
 * @author ebeltran
 */
public class AplDefineDaoImpl implements AplDefineDao{

    private static ConnectionDB con;
    String msgEx = null;
    String msg = null;
    Date date = new Date();

    
    /**
     * Metodo para extraer la lista de  Actividad Economica
     * @return list
     */
    @Override
    public List<AplDefine> findActEconomica() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_NIT_ACT_ECONOMICA ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_ciiu(rs.getInt("n_ciiu")); 
               actividad.setN_ciiu_padre(rs.getInt("n_ciiu_padre"));
               actividad.setDescripcion(rs.getString("descripcion"));
               actividad.setTarifa(rs.getFloat("tarifa"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_NIT_ACT_ECONOMICA", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    /**
     * Metodo para extraer la lista de Clase de Identidad 
     * @return list
     */
    @Override
    public List<AplDefine> findTipoIdentidad() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_NIT_TIP_IDENTIDAD ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_nit_tip_identidad(rs.getInt("n_nit_tip_identidad")); 
               actividad.setNom_nit_tip_identidad(rs.getString("nombre"));
               actividad.setTipo_doc(rs.getString("tipo_doc"));
               actividad.setDian_cod(rs.getString("dian_cod"));
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_NIT_TIP_IDENTIDAD", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    /**
     * Metodo para extraer la lista de  
     * @return list Clase de Sociedad
     */
    @Override
    public List<AplDefine> findClaseSociedad() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_NIT_CLA_SOCIEDAD ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_nit_cla_sociedad(rs.getInt("n_nit_cla_sociedad")); 
               actividad.setNom_nit_cla_sociedad(rs.getString("nombre"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_NIT_CLA_SOCIEDAD", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    /**
     * Metodo para extraer la lista de  Dignidades
     * @return list
     */
    @Override
    public List<AplDefine> findDignidad() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_NIT_DIGNIDAD ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_nit_digni(rs.getInt("n_nit_digni"));
               actividad.setNom_nit_digni(rs.getString("nombre"));
               actividad.setSi_matricula(rs.getInt("si_matricula"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_NIT_DIGNIDAD", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findGrupo() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_NIT_GRUPO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_nit_grupo(rs.getInt("n_nit_grupo")); 
               actividad.setNom_nit_grupo(rs.getString("nombre"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_NIT_GRUPO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    /**
     * Metodo para extraer la lista de Tipos de Contibuyentes 
     * @return list
     */
    @Override
    public List<AplDefine> findTipContribuyente() {
            
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_NIT_TIP_CONTRIBUYENTE ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_nit_tip_contribuyente(rs.getInt("n_nit_tip_contribuyente")); 
               actividad.setNom_nit_tip_contribuyente(rs.getString("nombre"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_NIT_TIP_CONTRIBUYENTE", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findEstadoCivil() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_E_CIVIL ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_apl_e_civil(rs.getInt("n_apl_e_civil")); 
               actividad.setNom_apl_e_civil(rs.getString("nombre"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_E_CIVIL", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findMotivoRetiro() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_EMP_MOTIVO_RETIRO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_emp_motivo_retiro(rs.getInt("n_emp_motivo_retiro")); 
               actividad.setNom_motivo_retiro(rs.getString("nombre"));
               actividad.setDes_motivo_retiro(rs.getString("descripcion"));
               actividad.setSi_justa_causa(rs.getString("si_justa_causa"));
               actividad.setNo_dias_preaviso(rs.getInt("no_dias_preaviso"));
               
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_SEXO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }
            
            
    @Override
    public List<AplDefine> findSexo() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_SEXO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_apl_sexo(rs.getInt("n_apl_sexo")); 
               actividad.setNom_apl_sexo(rs.getString("nombre"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_SEXO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findTipoSangre() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_SANGRE_TIPO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_apl_sangre_tipo(rs.getInt("n_apl_sangre_tipo")); 
               actividad.setNom_apl_sangre_tipo(rs.getString("nombre"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_SANGRE_TIPO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findEducacionClase() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_EMP_EDU_CLASE ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_emp_edu_clase(rs.getInt("n_emp_edu_clase"));
               actividad.setN_periodo(rs.getInt("n_periodo"));
               actividad.setN_edu_nivel(rs.getInt("n_edu_nivel")); 
               actividad.setNom_educa(rs.getString("nom_educa"));
               actividad.setNombre_titulo(rs.getString("nombre_titulo"));
               actividad.setCantidad_periodo(rs.getFloat("cantidad"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_EMP_EDU_CLASE", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findCabeza() {

        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_CABEZA_FAMILIA ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_apl_cabeza_familia(rs.getInt("n_apl_cabeza_familia")); 
               actividad.setNom_apl_cabeza(rs.getString("nombre"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_CABEZA_FAMILIA", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findContratoTipo() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_CON_TRA_TIPO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setN_con_tipo(rs.getInt("n_apl_con_trabajo"));
                actividad.setNom_con_tipo(rs.getString("nombre"));
                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_CON_TRA_TIPO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }
    
    @Override
    public List<AplDefine> findContratoTrabajo(int i) {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_CON_TRABAJO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("') ");
        sql.append("WHERE N_APL_CON_TRABAJO_PADRE = ").append(i);
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setN_apl_con_trabajo(rs.getInt("n_apl_con_trabajo"));
                actividad.setNom_con_trabajo(rs.getString("nombre"));
                actividad.setNo_dias_avi_noti(rs.getInt("no_dias_avi_noti"));
                actividad.setDias_pru_x_100(rs.getFloat("dias_pru_x_100"));
                actividad.setNo_prueba_max(rs.getInt("no_prueba_max"));
                actividad.setNo_dura_max(rs.getInt("no_dura_max"));
                actividad.setNo_dura_min(rs.getInt("no_dura_min"));
                actividad.setNo_veces_renueva(rs.getInt("no_veces_renueva"));
                actividad.setN_cotiza_tipo(rs.getInt("n_cotiza_tipo"));
                actividad.setN_cotiza_subtipo(rs.getInt("n_cotiza_subtipo"));
                actividad.setSi_se_vence(rs.getString("si_se_vence"));
                if (rs.getString("si_se_vence").equalsIgnoreCase("Si")) {
                    actividad.setLsi_vence(true);
                } else {
                    actividad.setLsi_vence(false);
                }
                actividad.setSi_se_indemniza(rs.getString("si_se_indemniza"));
                if (rs.getString("si_se_indemniza").equalsIgnoreCase("Si")) {
                    actividad.setLsi_indemniza(true);
                } else {
                    actividad.setLsi_indemniza(false);
                }
                actividad.setSi_es_aux_tran(rs.getString("si_es_pago_aux_tran"));
                if (rs.getString("si_es_pago_aux_tran").equalsIgnoreCase("Si")) {
                    actividad.setLsi_aux_tran(true);
                } else {
                    actividad.setLsi_aux_tran(false);
                }
                actividad.setSi_es_salario_integral(rs.getString("si_es_salario_integral"));
                if (rs.getString("si_es_salario_integral").equalsIgnoreCase("Si")) {
                    actividad.setLsi_salario_integral(true);
                } else {
                    actividad.setLsi_salario_integral(false);
                }
                actividad.setSi_se_pide_labor(rs.getString("si_se_pide_labor"));
                if (rs.getString("si_se_pide_labor").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pide_labor(true);
                } else {
                    actividad.setLsi_pide_labor(false);
                }
                actividad.setSi_se_pago_eps(rs.getString("si_se_pago_apor_eps"));
                if (rs.getString("si_se_pago_apor_eps").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_eps(true);
                } else {
                    actividad.setLsi_pago_eps(false);
                }
                actividad.setSi_se_pago_fdp(rs.getString("si_se_pago_apor_fdp"));
                if (rs.getString("si_se_pago_apor_fdp").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_fdp(true);
                } else {
                    actividad.setLsi_pago_fdp(false);
                }
                actividad.setSi_se_pago_fdc(rs.getString("si_se_pago_apor_fdc"));
                if (rs.getString("si_se_pago_apor_fdc").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_fdc(true);
                } else {
                    actividad.setLsi_pago_fdc(false);
                }
                actividad.setSi_se_pago_arl(rs.getString("si_se_pago_apor_arl"));
                if (rs.getString("si_se_pago_apor_arl").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_arl(true);
                } else {
                    actividad.setLsi_pago_arl(false);
                }
                actividad.setSi_se_pago_sena(rs.getString("si_se_pago_apor_sena"));
                if (rs.getString("si_se_pago_apor_sena").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_sena(true);
                } else {
                    actividad.setLsi_pago_sena(false);
                }
                actividad.setSi_se_pago_icbf(rs.getString("si_se_pago_apor_icbf"));
                if (rs.getString("si_se_pago_apor_icbf").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_icbf(true);
                } else {
                    actividad.setLsi_pago_icbf(false);
                }
                actividad.setSi_se_pago_ccf(rs.getString("si_se_pago_apor_ccf"));
                if (rs.getString("si_se_pago_apor_ccf").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_ccf(true);
                } else {
                    actividad.setLsi_pago_ccf(false);
                }
                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_CON_TRABAJO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findContratoTrabajoSelect(int i) {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_CON_TRABAJO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("') ");
        sql.append("WHERE N_APL_CON_TRABAJO = ").append(i);
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                
                actividad.setN_apl_con_trabajo(rs.getInt("n_apl_con_trabajo"));
                actividad.setNom_con_trabajo(rs.getString("nombre"));
                actividad.setNo_dias_avi_noti(rs.getInt("no_dias_avi_noti"));
                actividad.setDias_pru_x_100(rs.getFloat("dias_pru_x_100"));
                actividad.setNo_prueba_max(rs.getInt("no_prueba_max"));
                actividad.setNo_dura_max(rs.getInt("no_dura_max"));
                actividad.setNo_dura_min(rs.getInt("no_dura_min"));
                actividad.setNo_veces_renueva(rs.getInt("no_veces_renueva"));
                actividad.setN_cotiza_tipo(rs.getInt("n_cotiza_tipo"));
                actividad.setN_cotiza_subtipo(rs.getInt("n_cotiza_subtipo"));
                actividad.setSi_se_vence(rs.getString("si_se_vence"));
                if (rs.getString("si_se_vence").equalsIgnoreCase("Si")) {
                    actividad.setLsi_vence(true);
                } else {
                    actividad.setLsi_vence(false);
                }
                actividad.setSi_se_indemniza(rs.getString("si_se_indemniza"));
                if (rs.getString("si_se_indemniza").equalsIgnoreCase("Si")) {
                    actividad.setLsi_indemniza(true);
                } else {
                    actividad.setLsi_indemniza(false);
                }
                actividad.setSi_es_aux_tran(rs.getString("si_es_pago_aux_tran"));
                if (rs.getString("si_es_pago_aux_tran").equalsIgnoreCase("Si")) {
                    actividad.setLsi_aux_tran(true);
                } else {
                    actividad.setLsi_aux_tran(false);
                }
                actividad.setSi_es_salario_integral(rs.getString("si_es_salario_integral"));
                if (rs.getString("si_es_salario_integral").equalsIgnoreCase("Si")) {
                    actividad.setLsi_salario_integral(true);
                } else {
                    actividad.setLsi_salario_integral(false);
                }
                actividad.setSi_se_pide_labor(rs.getString("si_se_pide_labor"));
                if (rs.getString("si_se_pide_labor").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pide_labor(true);
                } else {
                    actividad.setLsi_pide_labor(false);
                }
                actividad.setSi_se_pago_eps(rs.getString("si_se_pago_apor_eps"));
                if (rs.getString("si_se_pago_apor_eps").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_eps(true);
                } else {
                    actividad.setLsi_pago_eps(false);
                }
                actividad.setSi_se_pago_fdp(rs.getString("si_se_pago_apor_fdp"));
                if (rs.getString("si_se_pago_apor_fdp").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_fdp(true);
                } else {
                    actividad.setLsi_pago_fdp(false);
                }
                actividad.setSi_se_pago_fdc(rs.getString("si_se_pago_apor_fdc"));
                if (rs.getString("si_se_pago_apor_fdc").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_fdc(true);
                } else {
                    actividad.setLsi_pago_fdc(false);
                }
                actividad.setSi_se_pago_arl(rs.getString("si_se_pago_apor_arl"));
                if (rs.getString("si_se_pago_apor_arl").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_arl(true);
                } else {
                    actividad.setLsi_pago_arl(false);
                }
                actividad.setSi_se_pago_sena(rs.getString("si_se_pago_apor_sena"));
                if (rs.getString("si_se_pago_apor_sena").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_sena(true);
                } else {
                    actividad.setLsi_pago_sena(false);
                }
                actividad.setSi_se_pago_icbf(rs.getString("si_se_pago_apor_icbf"));
                if (rs.getString("si_se_pago_apor_icbf").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_icbf(true);
                } else {
                    actividad.setLsi_pago_icbf(false);
                }
                actividad.setSi_se_pago_ccf(rs.getString("si_se_pago_apor_ccf"));
                if (rs.getString("si_se_pago_apor_ccf").equalsIgnoreCase("Si")) {
                    actividad.setLsi_pago_ccf(true);
                } else {
                    actividad.setLsi_pago_ccf(false);
                }
                
                list.add(actividad);
                
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_CON_TRABAJO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }       
    
    @Override
    public List<AplDefine> findPagoForma() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_EMP_PAGO_FORMA ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setN_pago_forma(rs.getInt("n_emp_pago_forma"));
                actividad.setNom_pago_forma(rs.getString("nombre"));
                actividad.setDesrip_pago_forma(rs.getString("descripcion"));

                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_EMP_PAGO_FORMA", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findBancoCompensa() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_BAN_NUMERO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setNom_ban_compensa(rs.getString("nombre"));
                actividad.setIdenti_banco(rs.getString("identi_banco"));
                actividad.setIdenti_banco_con(MyUtilFormat.formatOutput(rs.getString("identi_banco")));
                actividad.setIdenti_banco_con(rs.getString("identi_banco_con"));
                

                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_BAN_NUMERO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findBancoCuentaTipo() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_BAN_CUENTA_TIPO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setN_ban_cuenta_tipo(rs.getInt("n_ban_cuenta_tipo"));
                actividad.setNom_ban_cuenta_tipo(rs.getString("nombre"));
                actividad.setSi_se_liq_interes(rs.getString("si_se_liq_interes"));
                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_BAN_CUENTA_TIPO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findNombreEps() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_EMP_SEG_CLASE ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append( 1).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setIdenti_eps(rs.getString("identi_seg"));
                actividad.setIdentif_eps_con(MyUtilFormat.formatOutput(rs.getString("identi_seg")));
                actividad.setCod_plan_u_eps(rs.getString("cod_plan_u"));
                actividad.setNom_seg_eps(rs.getString("nombre"));
                                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_EMP_SEG_CLASE", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findNombreFdp() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_EMP_SEG_CLASE ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append( 2).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");

        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setIdenti_fdp(rs.getString("identi_seg"));
                actividad.setIdentif_fdp_con(MyUtilFormat.formatOutput(rs.getString("identi_seg")));
                actividad.setCod_plan_u_fdp(rs.getString("cod_plan_u"));
                actividad.setNom_seg_fdp(rs.getString("nombre"));
                                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_EMP_SEG_CLASE", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findNombreFdc() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_EMP_SEG_CLASE ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append( 3).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");

        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setIdenti_fdc(rs.getString("identi_seg"));
                actividad.setIdentif_fdc_con(MyUtilFormat.formatOutput(rs.getString("identi_seg")));
                actividad.setCod_plan_u_fdc(rs.getString("cod_plan_u"));
                actividad.setNom_seg_fdc(rs.getString("nombre"));
                                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_EMP_SEG_CLASE", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }


    @Override
    public List<AplDefine> findCotizaTipo() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_COTIZA_TIPO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append( 3).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");

        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setN_cotiza_tipo(rs.getInt("n_cotiza_tipo"));
                actividad.setNom_cotiza_tipo(rs.getString("om_cotiza_tipo"));
                                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_COTIZA_TIPO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findCotizaSubtipo() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_COTIZA_SUBTIPO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append( 3).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");

        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setN_cotiza_subtipo(rs.getInt("n_cotiza_subtipo"));
                actividad.setNom_cotiza_subtipo(rs.getString("om_cotiza_subtipo"));
                                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_COTIZA_SUBTIPO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findDocPendientes() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_DOC_PENDIENTE ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_apl_doc_pendiente(rs.getInt("n_apl_doc_pendiente")); 
               actividad.setNom_apl_doc_pendiente(rs.getString("nombre"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_DOC_PENDIENTE", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findRepresentanteLegal() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_REPRESENTANTE_LEGAL ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setIdenti_firma(rs.getString("identi_firma")); 
               actividad.setIdenti_firma_con(rs.getString("identi_firma_con"));
               actividad.setNombre_firma(rs.getString("nombre_firma"));
               actividad.setCargo_firma(rs.getString("cargo_firma"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_REPRESENTANTE_LEGAL", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }
    
    @Override
    public List<AplDefine> findUnidadMedida() {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_UNI_MEDIDA ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               AplDefine actividad = new AplDefine();
               actividad.setN_apl_uni_medida(rs.getInt("n_apl_uni_medida"));
               actividad.setN_apl_uni_medida_padre(rs.getInt("n_apl_uni_medida_padre"));
               actividad.setNom_apl_doc_pendiente(rs.getString("nombre"));
               actividad.setCantidad(rs.getFloat("cantidad"));
               actividad.setFactor(rs.getFloat("factor"));
               actividad.setSimbolo(rs.getString("simbolo"));
               actividad.setMascara(rs.getString("mascara"));
               
               list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_UNI_MEDIDAL", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findConceptosTipo() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_CONCE_TIPO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setN_apl_conce_tipo(rs.getInt("n_apl_conce_tipo"));
                actividad.setNombre(rs.getString("nombre"));
                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_CONCE_TIPO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findConceptoLiquidacion() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_CONCE_LIQ ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setN_apl_conce_liq(rs.getInt("n_apl_conce_liq"));
                actividad.setNombre(rs.getString("nombre"));
                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_CONCE_LIQ", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findPeriodoPago() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_PERIO_PAGO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setN_apl_perio_pago(rs.getInt("n_apl_perio_pago"));
                actividad.setNombre(rs.getString("nombre"));
                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_PERIO_PAGO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findGrupoConcepto() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_GRUPO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setN_apl_grupo(rs.getInt("n_apl_grupo"));
                actividad.setNombre(rs.getString("nombre"));
                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_GRUPO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AplDefine> findCuentaPucSufijo() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_PUC_SUFIJO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplDefine> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplDefine actividad = new AplDefine();
                actividad.setN_apl_cta_sufijo(rs.getInt("n_apl_cta_sufijo"));
                actividad.setNombre(rs.getString("nombre"));
                actividad.setCta_sufijo(rs.getString("cta_sufijo"));
                
                list.add(actividad);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_PUC_SUFIJO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public Date findByFechaHasta() {
    
        con = new ConnectionDB();
        con.connect();

        Date fecha_Control = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RC_FEC_MAXIMA ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                fecha_Control = rs.getDate("fec_maxima");
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RC_FEC_MAXIMA", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }

        return fecha_Control;
    }
    
}