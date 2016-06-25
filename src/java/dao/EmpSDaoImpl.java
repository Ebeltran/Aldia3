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
import model.EmpS;
import util.MyUtilFormat;

/**
 *
 * @author ebeltran
 */
public class EmpSDaoImpl implements EmpSDao {

    private static ConnectionDB con;
    FacesMessage message;
    String msgEx = null;
    String msg = null;
    Date date = new Date();    
    
    @Override
    public List<EmpS> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmpS> findEmpSAlista(int contratar, int contratado, int rechazado) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_EMP_S_PROSPECTOS ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", ");
        sql.append(contratar).append(", ");
        sql.append(contratado).append(", ");
        sql.append(rechazado).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<EmpS> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                EmpS empS = new EmpS();
                empS.setTipo_doc(rs.getString("tipo_doc"));
                empS.setIdenti(rs.getString("identi"));
                empS.setIdenti_con(MyUtilFormat.formatOutput(rs.getString("identi")));
                empS.setApellidos_nombres(rs.getString("apellidos_nombres"));
                empS.setNombres_apellidos(rs.getString("nombres_apellidos"));
                empS.setNombre_1(rs.getString("nombre_1"));
                empS.setNombre_2(rs.getString("nombre_2"));
                empS.setApellido_1(rs.getString("apellido_1"));
                empS.setApellido_2(rs.getString("apellido_2"));
                empS.setN_nit_tip_identidad(rs.getInt("n_nit_tip_identidad"));
                empS.setN_rotulo(rs.getInt("n_rotulo"));
                empS.setN_emp_estado_laboral(rs.getInt("n_emp_estado_laboral"));
                empS.setN_cargo_aspira(rs.getInt("n_cargo_aspira"));
                empS.setNom_cargo_aspira(rs.getString("nom_cargo_aspira"));
                empS.setN_apl_e_civil(rs.getInt("n_apl_e_civil"));
                empS.setN_apl_sexo(rs.getInt("n_apl_sexo"));
                empS.setN_ciudad_nace(rs.getInt("n_ciudad_nace"));
                empS.setCiudad_nace(rs.getString("ciudad_nace"));
                empS.setCiudad_depto_nace(rs.getString("ciudad_depto_nace"));
                empS.setN_cen_costo(rs.getInt("n_cen_costo"));
                empS.setNom_cen_costo(rs.getString("nom_cen_costo"));
                empS.setN_emp_pago_forma(rs.getInt("n_emp_pago_forma"));
                empS.setSi_contratar(rs.getString("si_es_contratar"));
                if (rs.getString("si_es_contratar").equalsIgnoreCase("Si")) {
                    empS.setSi_es_contratar(true);
                } else {
                    empS.setSi_es_contratar(false);
                }
                empS.setSi_contratado(rs.getString("si_es_contratado"));
                if (rs.getString("si_es_contratar").equalsIgnoreCase("Si")) {
                    empS.setSi_es_contratado(true);
                } else {
                    empS.setSi_es_contratado(false);
                }
                empS.setSi_rechazado(rs.getString("si_es_rechazado"));
                if (rs.getString("si_es_rechazado").equalsIgnoreCase("Si")) {
                    empS.setSi_es_rechazado(true);
                } else {
                    empS.setSi_es_rechazado(false);
                }
                empS.setSi_cabeza_familia(rs.getString("si_es_cabeza_familia"));
                if (rs.getString("si_es_cabeza_familia").equalsIgnoreCase("Si")) {
                    empS.setSi_es_cabeza_familia(true);
                } else {
                    empS.setSi_es_cabeza_familia(false);
                }
//                empS.setSi_pago_aux_tran(rs.getString("si_es_pago_aux_tran"));
                empS.setDireccion(rs.getString("direccion"));
                empS.setTelefono(rs.getString("telefono"));
                empS.setTel_aux(rs.getString("tel_aux"));
                empS.setFax(rs.getString("fax"));
                empS.setBarrio(rs.getString("barrio"));
                empS.setE_mail(rs.getString("e_mail"));
                empS.setE_mail_a(rs.getString("e_mail_a"));
                empS.setPagina_web(rs.getString("pagina_web"));
                empS.setN_apl_ciudad(rs.getInt("n_apl_ciudad"));
                empS.setCiudad(rs.getString("ciudad"));
                empS.setCiudad_depto(rs.getString("ciudad_depto"));
                empS.setLatitud(rs.getDouble("latitud"));
                empS.setLongitud(rs.getDouble("longitud"));
                empS.setProfesion(rs.getString("profesion"));
                empS.setN_emp_pago_forma(rs.getInt("n_emp_pago_forma"));
                if (empS.getN_emp_pago_forma() == 1) {
                    empS.setLpagoforma(true);
                } else {
                    empS.setLpagoforma(false);        
                } 
                empS.setIdenti_banco(rs.getString("identi_banco"));
                empS.setId_ban_cuenta(rs.getInt("id_ban_cuenta"));
                empS.setN_ban_cuenta_tipo(rs.getInt("n_ban_cuenta_tipo"));
                empS.setCuenta_cta(rs.getString("cuenta_cta"));
                empS.setBan_sucursal(rs.getString("ban_suc"));
                empS.setNo_estatura(rs.getFloat("no_estatura"));
                empS.setNo_peso(rs.getFloat("no_peso"));
                empS.setFecha(rs.getDate("fecha"));
                empS.setFecha_actual(rs.getDate("fecha_actual"));
                empS.setFecha_nace(rs.getDate("fecha_nace"));
                empS.setVr_salario_aspira(rs.getDouble("vr_salario_aspira"));
                empS.setSalario_aspira(String.valueOf(rs.getDouble("vr_salario_aspira")));
                empS.setN_emp_edu_clase(rs.getInt("n_emp_edu_clase"));
                empS.setN_apl_sangre_tipo(rs.getInt("n_apl_sangre_tipo"));
                empS.setObservacion(rs.getString("observacion"));
                empS.setFec_desde(rs.getDate("fec_desde"));
                empS.setFec_hasta(rs.getDate("fec_hasta"));
                empS.setIdenti_eps(rs.getString("identi_eps"));
                empS.setIdenti_eps_con(rs.getString("identi_eps"));
                empS.setIdenti_fdp(rs.getString("identi_fdp"));
                empS.setIdenti_fdp_con(rs.getString("identi_fdp"));
                empS.setIdenti_fdc(rs.getString("identi_fdc"));
                empS.setIdenti_fdc_con(rs.getString("identi_fdc"));
                list.add(empS);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_EMP_S_PROSPECTOS", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }    
    
    @Override
    public boolean create(EmpS empS) {
        con = new ConnectionDB();
        con.connect();
        boolean flag = false;
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RA_EMP_S_ADICIONAR ('");
        
//      IC_LOGIN, ID_AGENCIA, ID_ALMACEN, IDENTI,
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(empS.getIdenti()).append("', '");

//      NOMBRE_1, NOMBRE_2, APELLIDO_1, APELLIDO_2,
        if (empS.getNombre_1() == null) {
            sql.append("', '");
        } else {
            sql.append(empS.getNombre_1()).append("', '");
        }
        if (empS.getNombre_2() == null) {
            sql.append("', '");
        } else {
            sql.append(empS.getNombre_2()).append("', '");
        }
        if (empS.getApellido_1() == null) {
            sql.append("', '");
        } else {
            sql.append(empS.getApellido_1()).append("', '");
        }
        if (empS.getApellido_2() == null) {
            sql.append("', '");
        } else {
            sql.append(empS.getApellido_2()).append("', ");
        }
        
//      N_ROTULO, N_ESTADO_EMP, N_CARGO_ASPIRA, N_NIT_TIP_IDENTIDAD,
        sql.append(empS.getN_rotulo()).append(", ");
        sql.append(empS.getN_emp_estado_laboral()).append(", ");
        sql.append(empS.getN_cargo_aspira()).append(", ");
        sql.append(empS.getN_nit_tip_identidad()).append(", ");

//      N_APL_E_CIVIL, N_APL_SEXO, N_CIUDAD_NACE, N_APL_PAGO_PERIODO,
        sql.append(empS.getN_apl_e_civil()).append(", ");
        sql.append(empS.getN_apl_sexo()).append(", ");
        sql.append(empS.getN_ciudad_nace()).append(", '");
//        sql.append(empS.getN_pago_periodo()).append(", '"); 
        
//      SI_ES_CONTRATAR, SI_ES_CONTRATADO, SI_ES_RECHAZADO, SI_ES_CABEZA_FAMILIA,
        if (empS.getSi_es_contratar()) {  
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (empS.getSi_es_contratado()) { 
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (empS.getSi_es_rechazado()) {  
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (empS.getSi_es_cabeza_familia()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (empS.getSi_es_situacion_militar()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }

//      PROFESION, N_CEN_COSTO, N_EMP_PAGO_FORMA,
        sql.append(empS.getProfesion()).append("', ");
        sql.append(empS.getN_cen_costo()).append(", ");
        sql.append(empS.getN_emp_pago_forma()).append(", '");
        
//      IDENTI_BANCO, ID_BAN_CUENTA, N_BAN_CUENTA_TIPO, CUENTA_CTA, BAN_SUC,
        sql.append(empS.getIdenti_banco()).append("', "); 
        sql.append(empS.getId_ban_cuenta()).append(", "); 
        sql.append(empS.getN_ban_cuenta_tipo()).append(", '");
        sql.append(empS.getCuenta_cta()).append("', '"); 
        sql.append(empS.getBan_sucursal()).append("', "); 
        
//      NO_ESTATURA, NO_PESO, FECHA_ACTUAL, FECHA_NACE, VR_SALARIO_ASPIRA,
        sql.append(empS.getNo_estatura()).append(", ");
        sql.append(empS.getNo_peso()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(empS.getFecha_nace())).append("', ");
        
        sql.append(empS.getVr_salario_aspira()).append(", ");

//      N_APL_SANGRE_TIPO, N_EMP_EDU_CLASE, OBSERVACION,
        sql.append(empS.getN_apl_sangre_tipo()).append(", ");
        sql.append(empS.getN_emp_edu_clase()).append(", '");
        sql.append(empS.getObservacion()).append("', ");

//      N_APL_CIUDAD, DIRECCION, TELEFONO, TEL_AUX, FAX, BARRIO, E_MAIL, E_MAIL_A, PAGINA_WEB,
        sql.append(empS.getN_apl_ciudad()).append(", '");
        sql.append(empS.getDireccion()).append("', '");
        sql.append(empS.getTelefono()).append("', '");
        sql.append(empS.getTel_aux()).append("', '");
        sql.append(empS.getFax()).append("', '");
        sql.append(empS.getBarrio()).append("', '");
        sql.append(empS.getE_mail()).append("', '");
        sql.append(empS.getE_mail_a()).append("', '");
        sql.append(empS.getPagina_web()).append("', ");
        
//      LATITUD, LONGITUD, IDENTI_EPS, IDENTI_FDP, IDENTI_FDC,
        sql.append(empS.getLatitud()).append(", ");
        sql.append(empS.getLongitud()).append(", '");
        sql.append(empS.getIdenti_eps()).append("', '");
        sql.append(empS.getIdenti_fdp()).append("', '");
        sql.append(empS.getIdenti_fdc()).append("', '");
        
//      CIUDAD, NOM_CEN_COSTO, NOM_CARGO_ASPIRA, CIUDAD_DEPTO_NACE)
        sql.append(empS.getCiudad_depto()).append("', '");
        sql.append(empS.getNom_cen_costo()).append("', '");		
        sql.append(empS.getNom_cargo_aspira()).append("', '");		
        sql.append(empS.getCiudad_depto_nace()).append("')");		
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                empS.setMensaje(rs.getString("mensaje"));
            }
            flag = true;
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RA_EMP_S_ADICIONAR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return flag;
    }

    @Override
    public String update(EmpS empS) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_EMP_S_PROSPECTO ('");
        
        // IC_LOGIN,  ID_AGENCIA, ID_ALMACEN, 
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        
        // IDENTI, NOMBRE_1, NOMBRE_2, APELLIDO_1, APELLIDO_2,
        sql.append(empS.getIdenti()).append("', '");
        sql.append(empS.getNombre_1()).append("', '");
        sql.append(empS.getNombre_2()).append("', '");
        sql.append(empS.getApellido_1()).append("', '");
        sql.append(empS.getApellido_2()).append("', ");
        
        // N_NIT_TIP_IDENTIDAD, N_ROTULO, N_EMP_ESTADO_LABORAL, N_CARGO_ASPIRA,
        sql.append(empS.getN_nit_tip_identidad()).append(", ");
        sql.append(empS.getN_rotulo()).append(", ");
        sql.append(empS.getN_emp_estado_laboral()).append(", ");
        sql.append(empS.getN_cargo_aspira()).append(", ");

        // N_APL_E_CIVIL, N_APL_SEXO, N_CIUDAD_NACE, 
        sql.append(empS.getN_apl_e_civil()).append(", ");
        sql.append(empS.getN_apl_sexo()).append(", ");
        sql.append(empS.getN_ciudad_nace()).append(", '");
        
        // SI_ES_CONTRATAR, SI_ES_CONTRATADO, SI_ES_RECHAZADO, SI_ES_CABEZA_FAMILIA, SITUACION MIITAR
        if (empS.getSi_es_contratar()) {  
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (empS.getSi_es_contratado()) { 
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (empS.getSi_es_rechazado()) {  
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (empS.getSi_es_cabeza_familia()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (empS.getSi_es_situacion_militar()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        //  PROFESION, N_CEN_COSTO, N_EMP_PAGO_FORMA, IDENTI_BANCO, ID_BAN_CUENTA, 
        sql.append(empS.getProfesion()).append("', ");
        sql.append(empS.getN_cen_costo()).append(", ");
        sql.append(empS.getN_emp_pago_forma()).append(", '");
        sql.append(empS.getIdenti_banco()).append("', ");
        sql.append(empS.getId_ban_cuenta()).append(", ");
        
        // N_BAN_CUENTA_TIPO, CUENTA_CTA, BAN_SUC, NO_ESTATURA, NO_PESO, 
        sql.append(empS.getN_ban_cuenta_tipo()).append(", '");
        sql.append(empS.getCuenta_cta()).append("', '");
        sql.append(empS.getBan_sucursal()).append("', ");
        sql.append(empS.getNo_estatura()).append(", ");
        sql.append(empS.getNo_peso()).append(", '");

        // FECHA, FECHA_NACE, VR_SALARIO_ASPIRA, N_EMP_EDU_CLASE, N_APL_SANGRE_TIPO,
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empS.getFecha_actual())).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(empS.getFecha_nace())).append("', ");
        sql.append(empS.getVr_salario_aspira()).append(", ");
        sql.append(empS.getN_emp_edu_clase()).append(", ");
        sql.append(empS.getN_apl_sangre_tipo()).append(", '");

        // OBSERVACION, N_APL_CIUDAD, DIRECCION, TELEFONO, TEL_AUX, FAX,
        sql.append(empS.getObservacion()).append("', ");
        sql.append(empS.getN_apl_ciudad()).append(", '");
        sql.append(empS.getDireccion()).append("', '");
        sql.append(empS.getTelefono()).append("', '");
        sql.append(empS.getTel_aux()).append("', '");
        sql.append(empS.getFax()).append("', '");
        
        // BARRIO, E_MAIL, E_MAIL_A, PAGINA_WEB, LATITUD, LONGITUD, FECHA_CONTROL 
        sql.append(empS.getBarrio()).append("', '");
        sql.append(empS.getE_mail()).append("', '");
        sql.append(empS.getE_mail_a()).append("', '");
        sql.append(empS.getPagina_web()).append("', ");
        sql.append(empS.getLatitud()).append(", ");
        sql.append(empS.getLongitud()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empS.getFecha_control())).append("')");
        
        ResultSet rs = con.query(sql.toString());
        try {

            while (rs.next()) {
                msg = rs.getString("mensaje");
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_EMP_S_PROSPECTO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }
    
    @Override
    public String updateAlista(EmpS empS) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_EMP_S_PROSPECTO_PREPARA ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(empS.getIdenti()).append("', ");
        sql.append(empS.getN_emp_estado_laboral()).append(", '");
        sql.append(empS.getSi_es_contratar()).append("', '");
        sql.append(empS.getSi_es_contratado()).append("', '");
        sql.append(empS.getSi_es_rechazado()).append("', ");
        sql.append(empS.getN_emp_pago_forma()).append(", ");
        sql.append(empS.getVr_salario()).append(", '");
        sql.append(empS.getIdenti_banco()).append("', '");
        sql.append(empS.getBan_sucursal()).append("', ");
        sql.append(empS.getId_ban_cuenta()).append(", ");
        sql.append(empS.getN_ban_cuenta_tipo()).append(", '");
        sql.append(empS.getCuenta_cta()).append("', ");
        sql.append(empS.getNo_con_trabajo()).append(", ");
        sql.append(empS.getN_apl_con_trabajo()).append(", ");
        sql.append(empS.getNo_renovacion()).append(", ");
        sql.append(empS.getN_emp_estado_laboral()).append(", ");
        sql.append(empS.getN_cen_costo()).append(", ");
        sql.append(empS.getN_cargo()).append(", ");
        sql.append(empS.getN_ciudad_contrata()).append(", ");
        sql.append(empS.getN_ciudad_trabaja()).append(", ");
        sql.append(empS.getN_ciudad_firma()).append(", ");
        sql.append(empS.getId_documen()).append(", '");
        sql.append(empS.getFecha_inicia()).append("', '");
        sql.append(empS.getFecha_final()).append("', '");
        sql.append(empS.getFecha_firma_contra()).append("', '");
        sql.append(empS.getFecha_prueba()).append("', ");
        sql.append(empS.getN_cotiza_tipo()).append(", ");
        sql.append(empS.getN_cotiza_subtipo()).append(", '");
        sql.append(empS.getIdenti_eps()).append("', '");
        sql.append(empS.getIdenti_fdp()).append("', '");
        sql.append(empS.getIdenti_fdc()).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empS.getFec_desde())).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empS.getFec_hasta())).append("', '");        
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empS.getFecha_control())).append("') ");
        
        ResultSet rs = con.query(sql.toString());
        try {

            while (rs.next()) {
                msg = rs.getString("mensaje");
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_EMP_S_PROSPECTO_PREPARA", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }        
        
    @Override
    public String contrataProspecto(EmpS empS) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RA_EMP_S_CONTRATA ( '"); 
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(empS.getIdenti()).append("', ");
        sql.append(empS.getN_apl_con_trabajo()).append(", ");
        sql.append(empS.getN_cen_costo()).append(", ");
        sql.append(empS.getN_cargo()).append(", ");
        sql.append(empS.getN_ciudad_contrata()).append(", ");
        sql.append(empS.getN_ciudad_firma()).append(", ");
        sql.append(empS.getN_ciudad_trabaja()).append(", ");
        sql.append(empS.getVr_salario()).append(", ");
        sql.append(empS.getN_emp_pago_forma()).append(", '");
        sql.append(empS.getIdenti_banco()).append("', '");
        sql.append(empS.getBan_sucursal()).append("', ");
        sql.append(empS.getN_ban_cuenta_tipo()).append(", '");
        sql.append(empS.getCuenta_cta()).append("', '");
        sql.append(empS.getIdenti_firma()).append("', '");
        sql.append(empS.getIdenti_eps()).append("', '");
        sql.append(empS.getIdenti_fdp()).append("', '");
        sql.append(empS.getIdenti_fdc()).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empS.getFecha_inicia())).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empS.getFecha_final())).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empS.getFecha_firma_contra())).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empS.getFecha_control())).append("') ");
                
        ResultSet rs = con.query(sql.toString());
        try {

            while (rs.next()) {
                msg = rs.getString("mensaje");
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RA_EMP_S_CONTRATA", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }
        
    @Override
    public String findByEmpS(EmpS empS) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_EMP_S_BUSCAR ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(empS.getIdenti()).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");

        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                empS.setIdenti(rs.getString("identi"));
                empS.setIdenti_con(MyUtilFormat.formatOutput(rs.getString("identi")));
                empS.setApellidos_nombres(rs.getString("apellidos_nombres"));
                empS.setNombre_1(rs.getString("nombre_1"));
                empS.setNombre_2(rs.getString("nombre_2"));
                empS.setApellido_1(rs.getString("apellido_1"));
                empS.setApellido_2(rs.getString("apellido_2"));
                empS.setN_nit_tip_identidad(rs.getInt("n_nit_tip_identidad"));
                empS.setN_rotulo(rs.getInt("n_rotulo"));
                empS.setN_emp_estado_laboral(rs.getInt("e_emp_estado_laboral"));
                empS.setN_cargo_aspira(rs.getInt("n_cargo_aspira"));
                empS.setN_apl_e_civil(rs.getInt("n_apl_e_civil"));
                empS.setN_apl_sexo(rs.getInt("n_apl_sexo"));
                empS.setN_ciudad_nace(rs.getInt("n_ciudad_nace"));
                empS.setN_pago_periodo(rs.getInt("n_apl_pago_periodo"));
                empS.setSi_contratar(rs.getString("si_es_contratar"));
                empS.setSi_contratado(rs.getString("si_es_contratado"));
                empS.setSi_rechazado(rs.getString("si_es_rechazado"));
                empS.setSi_cabeza_familia(rs.getString("si_es_cabeza_familia"));
                empS.setDireccion(rs.getString("direccion"));
                empS.setTelefono(rs.getString("telefono"));
                empS.setTel_aux(rs.getString("tel_aux"));
                empS.setFax(rs.getString("fax"));
                empS.setBarrio(rs.getString("barrio"));
                empS.setCiudad(rs.getString("ciudad"));
                empS.setE_mail(rs.getString("e_mail"));
                empS.setE_mail_a(rs.getString("e_mail_a"));
                empS.setPagina_web(rs.getString("pagina_web"));
                empS.setLatitud(rs.getDouble("latitud"));
                empS.setLongitud(rs.getDouble("longitud"));
                empS.setProfesion(rs.getString("profesion"));
                empS.setIdenti_banco(rs.getString("identi_banco"));
                empS.setId_ban_cuenta(rs.getInt("id_ban_cuenta"));
                empS.setN_ban_cuenta_tipo(rs.getInt("n_ban_cuenta_tipo"));
                empS.setCuenta_cta(rs.getString("cuenta_cta"));
                empS.setBan_sucursal(rs.getString("ban_suc"));
                empS.setNo_estatura(rs.getFloat("no_estatura"));
                empS.setNo_peso(rs.getFloat("no_peso"));
                empS.setFecha(rs.getDate("fecha"));
                empS.setFecha_actual(rs.getDate("fecha_actual"));
                empS.setFecha_nace(rs.getDate("fecha_nace"));
                empS.setVr_salario_aspira(rs.getDouble("vr_salario_aspira"));
                empS.setSalario_aspira(String.valueOf(rs.getDouble("vr_salario_aspira")));
                empS.setN_apl_sangre_tipo(rs.getInt("n_apl_sangre_tipo"));
                empS.setFec_desde(rs.getDate("fec_desde"));
                empS.setFec_hasta(rs.getDate("fec_hasta"));
                empS.setLpersona(true);
                msg = rs.getString("mensaje");

            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_EMP_S_BUSCAR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }

    @Override
    public boolean updateContrato(EmpS empS) {
        con = new ConnectionDB();
        con.connect();
        
        con.setAutoCommit(false);

        msg = "";
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RM_EMP_S_PROS_CONTRATAR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(empS.getIdenti()).append("', ");
        sql.append(empS.getN_apl_con_trabajo()).append(", ");
        sql.append(empS.getN_emp_pago_forma()).append(", '");
        sql.append(empS.getIdenti_banco()).append("', ");
        sql.append(empS.getN_ban_cuenta_tipo()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empS.getFecha_inicia())).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empS.getFecha_final())).append("', ");
        sql.append(empS.getVr_salario()).append(", '");
        sql.append(empS.getNom_apl_ciudad_contra()).append("', '");
        sql.append(empS.getNom_apl_ciudad_trabaja()).append("', '");
        sql.append(empS.getNom_cargo()).append("', '");
        sql.append(empS.getNom_cen_costo()).append("', '");
        sql.append(empS.getBan_sucursal()).append("', '");
        sql.append(empS.getCuenta_cta()).append("', '");
        sql.append(empS.getIdenti_eps()).append("', '");
        sql.append(empS.getIdenti_fdp()).append("', '");
        sql.append(empS.getIdenti_fdc()).append("') ");

        ResultSet rs = con.query(sql.toString());
        try {

            while (rs.next()) {
                msg = rs.getString("mensaje");
            }

            con.commit();
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "EMP_S_PROS_CONTRATAR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return true;
    }

    @Override
	public List<EmpS> findAutoCompProspecto(String query, int i) {
    	con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_AUTOCOMPLETAR_EMP_S (");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(query).append("', ");
        sql.append(i).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<EmpS> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                EmpS empS = new EmpS();
                empS.setIdenti(rs.getString("identi"));
                empS.setIdenti_con(MyUtilFormat.formatOutput(rs.getString("identi")));
                empS.setNombre_1(rs.getString("nombre_1"));
                empS.setNombre_2(rs.getString("nombre_2"));
                empS.setApellido_1(rs.getString("apellido_1"));
                empS.setApellido_2(rs.getString("apellido_2"));
                empS.setApellidos_nombres(rs.getString("apellidos_nombres"));
                empS.setNombres_apellidos(rs.getString("nombres_apellidos"));
                empS.setLpersona(true);
                
                list.add(empS);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_AUTOCOMPLETAR_EMP_S", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
	}

    @Override
    public List<EmpS> findAutoCompCiudad(String query) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_AUTOCOMPLETAR_APL_CIUDAD ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(query).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<EmpS> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                EmpS empS = new EmpS();
                empS.setN_apl_ciudad(rs.getInt("n_apl_ciudad"));
                empS.setCiudad(rs.getString("ciudad"));
                empS.setDepartamento(rs.getString("departamento"));
                empS.setDepto(rs.getString("depto"));
                empS.setCiudad_depto(rs.getString("ciudad_depto"));
                empS.setCiudad_dep(rs.getString("ciudad_dep"));
                empS.setLatitud(rs.getDouble("latitud"));
                empS.setLongitud(rs.getDouble("longitud"));
                list.add(empS);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_AUTOCOMPLETAR_APL_CIUDAD", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<EmpS> findAutoCompCiudadNace(String query) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_AUTOCOMPLETAR_APL_CIUDAD ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(query).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<EmpS> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                EmpS empS = new EmpS();
                empS.setN_ciudad_nace(rs.getInt("n_apl_ciudad"));
                empS.setCiudad_nace(rs.getString("ciudad"));
                empS.setDepartamento_nace(rs.getString("departamento"));
                empS.setDepto(rs.getString("depto"));
                empS.setCiudad_depto_nace(rs.getString("ciudad_depto"));
                empS.setCiudad_dep_nace(rs.getString("ciudad_dep"));
                list.add(empS);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_AUTOCOMPLETAR_APL_CIUDAD", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }
    
    @Override
    public List<EmpS> findAutoCompCargo(String query) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_AUTOCOMPLETAR_D_E_EMP_CARGO ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(query).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<EmpS> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
               EmpS empS = new EmpS();
               empS.setN_cargo(rs.getInt("n_emp_cargo")); 
               empS.setNom_cargo(rs.getString("nombre")); 
               empS.setN_cargo_jefe(rs.getInt("n_emp_cargo_jefe")); 
               empS.setSi_es_jefe(rs.getString("si_jefe"));
               if (rs.getString("si_jefe").equalsIgnoreCase("Si")) {
                  empS.setLsi_jefe(true);
               } else {
                  empS.setLsi_jefe(false);
               }
               empS.setNom_cargo_jefe(rs.getString("nombre_cargo_jefe"));
               
               list.add(empS);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_AUTOCOMPLETAR_D_E_EMP_CARGO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<EmpS> findAutoCompCentroCosto(String query) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_AUTOCOMPLETAR_CEN_COSTO ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(query).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<EmpS> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                EmpS empS = new EmpS();
                empS.setN_cen_costo(rs.getInt("n_cen_costo"));
                empS.setN_emp_jornada(rs.getInt("n_emp_jornada"));
                empS.setN_apl_pago_periodo(rs.getInt("n_apl_pago_periodo"));
                empS.setNom_cen_costo(rs.getString("nom_cen_costo"));
                empS.setNom_cen_costo_padre(rs.getString("nom_cen_costo_padre"));
                empS.setNivel(rs.getInt("nivel"));     
                empS.setCosto(rs.getString("costo"));
                empS.setEmp_jornada(rs.getString("emp_jornada"));
                empS.setNom_horario(rs.getString("nom_horario"));
                empS.setDes_horario(rs.getString("des_horario"));
                empS.setTarifa_arl(rs.getString("tarifa_arl"));
                
                list.add(empS);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_AUTOCOMPLETAR_CEN_COSTO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public EmpS findByAlistar (String string) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_EMP_S_PROSPECTO_ALISTAR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(string).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        EmpS empS = new EmpS();
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                // tipo_doc, nom_iden identi, apellidos_nombres, nombres_apellidos
                empS.setTipo_doc(rs.getString("tipo_doc"));
                empS.setIdenti(rs.getString("identi"));
                empS.setIdenti_con(MyUtilFormat.formatOutput(rs.getString("identi")));
                empS.setApellidos_nombres(rs.getString("apellidos_nombres"));
                empS.setNombres_apellidos(rs.getString("nombres_apellidos"));
                
                // nombre_1, nombre_2, apellido_1, apellido_2
                empS.setNombre_1(rs.getString("nombre_1"));
                empS.setNombre_2(rs.getString("nombre_2"));
                empS.setApellido_1(rs.getString("apellido_1"));
                empS.setApellido_2(rs.getString("apellido_2"));
                
                // n_nit_tip_identidad, n_emp_estado_laboral, n_cargo_aspira
                empS.setN_nit_tip_identidad(rs.getInt("n_nit_tip_identidad"));
                empS.setN_emp_estado_laboral(rs.getInt("n_emp_estado_laboral"));
                empS.setN_cargo_aspira(rs.getInt("n_cargo_aspira"));
                
                // si_es_contratar, si_es_contratado, si_es_rechazado, si_es_cabeza_familia
                if (rs.getString("si_es_contratar").equalsIgnoreCase("Si")) {
                    empS.setSi_es_contratar(true);
                } else {
                    empS.setSi_es_contratar(false);
                }
                empS.setSi_contratado(rs.getString("si_es_contratado"));
                if (rs.getString("si_es_contratar").equalsIgnoreCase("Si")) {
                    empS.setSi_es_contratado(true);
                } else {
                    empS.setSi_es_contratado(false);
                }
                empS.setSi_rechazado(rs.getString("si_es_rechazado"));
                if (rs.getString("si_es_rechazado").equalsIgnoreCase("Si")) {
                    empS.setSi_es_rechazado(true);
                } else {
                    empS.setSi_es_rechazado(false);
                }
                if (rs.getString("si_es_cabeza_familia").equalsIgnoreCase("Si")) {
                    empS.setSi_es_cabeza_familia(true);
                } else {
                    empS.setSi_es_cabeza_familia(false);
                }
                
                // n_emp_pago_forma, vr_salario,
                empS.setN_emp_pago_forma(rs.getInt("n_emp_pago_forma"));
                if (empS.getN_emp_pago_forma() == 1) {
                    empS.setLpagoforma(true);
                } else {
                    empS.setLpagoforma(false);        
                }
                empS.setVr_salario(rs.getDouble("vr_salario_aspira"));
                empS.setSalario(MyUtilFormat.formatDouble(rs.getDouble("vr_salario_aspira")));
                empS.setVr_salario_aspira(rs.getDouble("vr_salario_aspira"));
                empS.setSalario_aspira(MyUtilFormat.formatDouble(rs.getDouble("vr_salario_aspira")));
                
                // identi_banco, ban_suc, id_ban_cuenta, n_ban_cuenta_tipo, cuenta_cta,
                empS.setIdenti_banco(rs.getString("identi_banco"));
                empS.setIdenti_banco_con(MyUtilFormat.formatOutput(rs.getString("identi_banco")));
                empS.setBan_sucursal(rs.getString("ban_suc"));
                empS.setId_ban_cuenta(rs.getInt("id_ban_cuenta"));
                empS.setN_ban_cuenta_tipo(rs.getInt("n_ban_cuenta_tipo"));
                empS.setCuenta_cta(rs.getString("cuenta_cta"));
                
                // n_con_duracion, n_apl_con_trabajo, n_cen_costo, 
                empS.setN_con_duracion(rs.getInt("n_con_duracion"));
                empS.setN_apl_con_trabajo(rs.getInt("n_apl_con_trabajo"));
                empS.setN_cen_costo(rs.getInt("n_cen_costo"));
                
                // n_emp_jornada, n_emp_horario, n_apl_pago_periodo
                empS.setN_emp_jornada(rs.getInt("n_emp_jornada"));
                empS.setN_emp_horario(rs.getInt("n_emp_horario"));
                empS.setN_apl_pago_periodo(rs.getInt("n_apl_pago_periodo"));
                
                // n_ciudad_contra, n_ciudad_trabaja, n_ciudad_firma_contra, 
                empS.setN_ciudad_contrata(rs.getInt("n_ciudad_contra"));
                empS.setN_ciudad_trabaja(rs.getInt("n_ciudad_trabaja"));
                empS.setN_ciudad_firma(rs.getInt("n_ciudad_firma_contra"));
                                
                // n_apl_e_civil, n_apl_sexo, n_emp_edu_clase, n_apl_sangre_tipo, 
                empS.setN_apl_e_civil(rs.getInt("n_apl_e_civil"));
                empS.setN_apl_sexo(rs.getInt("n_apl_sexo"));
                empS.setN_emp_edu_clase(rs.getInt("n_emp_edu_clase"));
                empS.setN_apl_sangre_tipo(rs.getInt("n_apl_sangre_tipo"));
                
                // n_apl_ciudad, n_ciudad_nace,
                empS.setN_apl_ciudad(rs.getInt("n_apl_ciudad"));
                empS.setN_ciudad_nace(rs.getInt("n_ciudad_nace"));
                
                // fecha_inicia, fecha_final, fecha_firma_contra, fecha_prueba,
                empS.setFecha_inicia(rs.getDate("fecha_inicia"));
                empS.setFecha_final(rs.getDate("fecha_final"));
                empS.setFecha_firma_contra(rs.getDate("fecha_firma_contra"));
                empS.setFecha_prueba(rs.getDate("fecha_prueba"));
                                
                // identi_eps, identi_fdp, identi_fdc, 
                empS.setIdenti_eps(rs.getString("identi_eps"));
                empS.setIdenti_eps_con(MyUtilFormat.formatOutput(rs.getString("identi_eps")));
                empS.setIdenti_fdp(rs.getString("identi_fdp"));
                empS.setIdenti_fdp_con(MyUtilFormat.formatOutput(rs.getString("identi_fdp")));
                empS.setIdenti_fdc(rs.getString("identi_fdc"));
                empS.setIdenti_fdc_con(MyUtilFormat.formatOutput(rs.getString("identi_fdc")));
                
                //nom_cen_costo, nom_cen_costo_id, nom_cen_costo_padre, 
                empS.setNom_cen_costo(rs.getString("nom_cen_costo"));
                empS.setNom_cen_costo_id(rs.getString("nom_cen_costo_id"));
                empS.setNom_cen_costo_padre(rs.getString("nom_cen_costo_padre"));
                
                // nom_cargo_aspira, nom_cargo_aspira_id, nom_cargo_aspira_jefe, 
                empS.setNom_cargo(rs.getString("nom_cargo_aspira"));
                empS.setNom_cargo_aspira(rs.getString("nom_cargo_aspira"));
                empS.setNom_cargo_aspira_id(rs.getString("nom_cargo_aspira_id"));
                empS.setNom_cargo_id(rs.getString("nom_cargo_aspira_id"));
                empS.setNom_cargo_aspira_jefe(rs.getString("nom_cargo_aspira_jefe"));
                empS.setNom_cargo_jefe(rs.getString("nom_cargo_aspira_jefe"));
                
                // ciudad_depto_contrata_id, ciudad_depto_firma_id, ciudad_depto_trabaja_id, 
                empS.setCiudad_depto_contrata(rs.getString("ciudad_depto_contrata_id"));
                empS.setCiudad_depto_firma(rs.getString("ciudad_depto_firma_id"));
                empS.setCiudad_depto_trabaja(rs.getString("ciudad_depto_trabaja_id"));
                
                // observacion, nom_educa, reporte_nombre, mensaje
                empS.setObservacion(rs.getString("observacion"));
                empS.setNom_educa(rs.getString("nom_educa"));
                empS.setReporte_nombre(rs.getString("reporte_nombre"));
                empS.setMensaje(rs.getString("mensaje"));
                
                empS.setLpersona(true);
                empS.setLauxtran(true);
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_EMP_S_PROSPECTO_ALISTAR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return empS;
    }
            
            
    @Override
    public EmpS findByProspecto(String string) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_EMP_S_UN_PROSPECTO ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(string).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        EmpS empS = new EmpS();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                empS.setTipo_doc(rs.getString("tipo_doc"));
                empS.setIdenti(rs.getString("identi"));
                empS.setIdenti_con(MyUtilFormat.formatOutput(rs.getString("identi")));
                empS.setApellidos_nombres(rs.getString("apellidos_nombres"));
                empS.setNombres_apellidos(rs.getString("nombres_apellidos"));
                empS.setNombre_1(rs.getString("nombre_1"));
                empS.setNombre_2(rs.getString("nombre_2"));
                empS.setApellido_1(rs.getString("apellido_1"));
                empS.setApellido_2(rs.getString("apellido_2"));
                empS.setN_nit_tip_identidad(rs.getInt("n_nit_tip_identidad"));
                empS.setN_rotulo(rs.getInt("n_rotulo"));
                empS.setN_emp_estado_laboral(rs.getInt("n_emp_estado_laboral"));
                empS.setN_cargo_aspira(rs.getInt("n_cargo_aspira"));
                empS.setN_apl_e_civil(rs.getInt("n_apl_e_civil"));
                empS.setN_apl_sexo(rs.getInt("n_apl_sexo"));
                empS.setN_cen_costo(rs.getInt("n_cen_costo"));
                empS.setSi_contratar(rs.getString("si_es_contratar"));
                if (rs.getString("si_es_contratar").equalsIgnoreCase("Si")) {
                    empS.setSi_es_contratar(true);
                } else {
                    empS.setSi_es_contratar(false);
                }
                empS.setSi_contratado(rs.getString("si_es_contratado"));
                if (rs.getString("si_es_contratar").equalsIgnoreCase("Si")) {
                    empS.setSi_es_contratado(true);
                } else {
                    empS.setSi_es_contratado(false);
                }
                empS.setSi_rechazado(rs.getString("si_es_rechazado"));
                if (rs.getString("si_es_rechazado").equalsIgnoreCase("Si")) {
                    empS.setSi_es_rechazado(true);
                } else {
                    empS.setSi_es_rechazado(false);
                }
                empS.setSi_cabeza_familia(rs.getString("si_es_cabeza_familia"));
                if (rs.getString("si_es_cabeza_familia").equalsIgnoreCase("Si")) {
                    empS.setSi_es_cabeza_familia(true);
                } else {
                    empS.setSi_es_cabeza_familia(false);
                }
                if (rs.getString("si_es_situacion_Militar").equalsIgnoreCase("Si")) {
                    empS.setSi_es_situacion_militar(true);
                } else {
                    empS.setSi_es_situacion_militar(false);
                }
                
                empS.setDireccion(rs.getString("direccion"));
                empS.setTelefono(rs.getString("telefono"));
                empS.setTel_aux(rs.getString("tel_aux"));
                empS.setFax(rs.getString("fax"));
                empS.setBarrio(rs.getString("barrio"));
                empS.setE_mail(rs.getString("e_mail"));
                empS.setE_mail_a(rs.getString("e_mail_a"));
                empS.setPagina_web(rs.getString("pagina_web"));
                empS.setN_apl_ciudad(rs.getInt("n_apl_ciudad"));
                empS.setCiudad(rs.getString("ciudad"));
                empS.setCiudad_depto(rs.getString("ciudad_depto"));
                empS.setN_ciudad_nace(rs.getInt("n_ciudad_nace"));
                empS.setCiudad_nace(rs.getString("ciudad_nace"));
                empS.setCiudad_depto_nace(rs.getString("ciudad_depto_nace"));
                empS.setLongitud(rs.getDouble("longitud"));
                empS.setLatitud(rs.getDouble("latitud"));
                empS.setProfesion(rs.getString("profesion"));
                empS.setN_emp_pago_forma(rs.getInt("n_emp_pago_forma"));
                if (empS.getN_emp_pago_forma() == 1) {
                    empS.setLpagoforma(true);
                } else {
                    empS.setLpagoforma(false);        
                }    
                empS.setIdenti_banco(rs.getString("identi_banco"));
                empS.setId_ban_cuenta(rs.getInt("id_ban_cuenta"));
                empS.setN_ban_cuenta_tipo(rs.getInt("n_ban_cuenta_tipo"));
                empS.setCuenta_cta(rs.getString("cuenta_cta"));
                empS.setBan_sucursal(rs.getString("ban_suc"));
                empS.setNo_estatura(rs.getFloat("no_estatura"));
                empS.setNo_peso(rs.getFloat("no_peso"));
                empS.setFecha(rs.getDate("fecha"));
                empS.setFecha_actual(rs.getDate("fecha_actual"));
                empS.setFecha_nace(rs.getDate("fecha_nace"));
                empS.setVr_salario_aspira(rs.getDouble("vr_salario_aspira"));
                empS.setSalario_aspira(MyUtilFormat.formatDouble(rs.getDouble("vr_salario_aspira")));
                empS.setN_emp_edu_clase(rs.getInt("n_emp_edu_clase"));
                empS.setN_apl_sangre_tipo(rs.getInt("n_apl_sangre_tipo"));
                empS.setObservacion(rs.getString("observacion"));
                empS.setFec_desde(rs.getDate("fec_desde"));
                empS.setFec_hasta(rs.getDate("fec_hasta"));
                empS.setLpersona(true);
                empS.setN_con_tipo(0);
                empS.setN_apl_con_trabajo(0);
                
                empS.setNom_cen_costo(rs.getString("nom_cen_costo"));
                empS.setNom_cen_costo_padre(rs.getString("nom_cen_costo_padre"));
                empS.setNom_cargo_aspira(rs.getString("nom_cargo_aspira"));
                empS.setNom_cargo_aspira_jefe(rs.getString("nom_cargo_aspira_jefe"));
                empS.setNom_cargo_id(rs.getString("nom_cargo_aspira_id"));
                
                if (empS.getN_cargo_aspira() != 0) {
                    empS.setNom_cargo_aspira(empS.getNom_cargo_aspira() + 
                                             " Jefe > " + empS.getNom_cargo_aspira_jefe() + 
                                             " ID => "  + empS.getN_cargo_aspira());
                }
                if (empS.getN_cargo() == 0) {
                    empS.setNom_cargo(empS.getNom_cargo_aspira());
                }
                
                if (empS.getN_cen_costo() != 0) {
                    empS.setNom_cen_costo(empS.getNom_cen_costo() + 
                                             " Depende > " + empS.getNom_cen_costo_padre() + 
                                             " ID => " +     Integer.toString(empS.getN_cen_costo()));
                }

//                if (empS.getN_apl_ciudad() != 0) {
//                    empS.setCiudad_depto(empS.getCiudad_depto() + 
//                                         " ID => " + empS.getN_apl_ciudad());
//                }
//                
//                if (empS.getN_ciudad_nace() != 0) {
//                    empS.setCiudad_depto_nace(empS.getCiudad_depto_nace() + 
//                                         " ID => " + empS.getN_ciudad_nace());
//                }
                
                if (empS.getVr_salario() == 0) {
                    empS.setVr_salario(empS.getVr_salario_aspira());
                    empS.setSalario(MyUtilFormat.formatDouble(empS.getVr_salario_aspira()));
                }

                
                
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_EMP_S_UN_PROSPECTO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return empS;
    }

    @Override
    public EmpS findByCiudad(String string) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_CIUDAD ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(string).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        EmpS empS = new EmpS();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                empS.setN_apl_ciudad(rs.getInt("n_apl_ciudad"));
                empS.setCiudad(rs.getString("ciudad"));
                empS.setN_apl_ciudad_padre(rs.getInt("n_apl_ciudad_padre"));
                empS.setDepartamento(rs.getString("departamento"));
                empS.setDepto(rs.getString("depto"));
                empS.setCiudad_depto(rs.getString("ciudad_depto"));
                empS.setCiudad_dep(rs.getString("ciudad_dep"));
                empS.setLatitud(rs.getDouble("latitud"));
                empS.setLongitud(rs.getDouble("longitud"));
                
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_CIUDAD", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }

        return empS;
    }

    @Override
    public EmpS findByCiudadNace(String string) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_CIUDAD ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(string).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        EmpS empS = new EmpS();
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                empS.setN_ciudad_nace(rs.getInt("n_apl_ciudad"));
                empS.setCiudad_nace(rs.getString("ciudad"));
                empS.setN_ciudad_padre_nace(rs.getInt("n_apl_ciudad_padre"));
                empS.setDepartamento_nace(rs.getString("departamento"));
                empS.setDepto_nace(rs.getString("depto"));
                empS.setCiudad_depto_nace(rs.getString("ciudad_depto"));
                empS.setCiudad_dep_nace(rs.getString("ciudad_dep"));
                empS.setLatitud(rs.getDouble("latitud"));
                empS.setLongitud(rs.getDouble("longitud"));
                
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_CIUDAD", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }

        return empS;
    }
    
    @Override
    public EmpS findByCargo(String string) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_EMP_CARGO ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("') ");
        sql.append("WHERE N_EMP_CARGO = ").append(string);
        
        EmpS empS = new EmpS();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                empS.setN_cargo_aspira(rs.getInt("n_emp_cargo"));
                empS.setNom_cargo(rs.getString("nombre"));
                empS.setN_cargo_jefe(rs.getInt("n_emp_cargo_jefe"));
                empS.setNom_cargo_jefe(rs.getString("cargo_jefe"));
                empS.setN_localiza(rs.getInt("n_localiza"));
                empS.setSi_es_jefe(rs.getString("si_es_jefe"));
                if (rs.getString("si_es_jefe").equalsIgnoreCase("Si")) {
                  empS.setLsi_jefe(true);
               } else {
                  empS.setLsi_jefe(false);
               }
                empS.setDescripcion(rs.getString("descripcion"));
                                
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_EMP_CARGO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }

        return empS;
    }

    @Override
    public EmpS findByCentroCosto(String string) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_CON_CEN_COSTO ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("') ");
        sql.append("WHERE N_CEN_COSTO = ").append(string);
        
        EmpS empS = new EmpS();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                empS.setN_cen_costo(rs.getInt("n_cen_costo"));
                empS.setN_emp_jornada(rs.getInt("n_emp_jornada"));
                empS.setN_apl_pago_periodo(rs.getInt("n_apl_pago_periodo"));
                empS.setNom_cen_costo(rs.getString("nom_cen_costo"));
                empS.setNom_cen_costo_padre(rs.getString("nom_cen_costo_padre"));
                empS.setNivel(rs.getInt("nivel"));     
                empS.setCosto(rs.getString("costo"));
                empS.setEmp_jornada(rs.getString("emp_jornada"));
                empS.setNom_horario(rs.getString("nom_horario"));
                empS.setDes_horario(rs.getString("des_horario"));
                empS.setTarifa_arl(rs.getString("tarifa_arl"));

            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_CON_CEN_COSTO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }

        return empS;
    }

    @Override
    public String findByExamenIngreso(EmpS empS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findByAperturaBanco(EmpS empS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findByExamenEgreso(EmpS empS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}