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
import model.Empleado;
import util.MyUtilFormat;

/**
 *
 * @author ebeltran
 */
public class EmpleadoDaoImpl implements EmpleadoDao {

    private static ConnectionDB con;
    String msgEx = null;
    String msg = null;
    FacesMessage message = null;
    Date date = new Date();

    @Override
    public List<Empleado> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> findEmleadoContratar() {
    
//        con = new ConnectionDB();
//        con.connect();
//        
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT * FROM RS_EMPLEADO_CONTRATAR ('");
//        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
//        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
//        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(")");
//        
//        List<Empleado> list = new ArrayList<>();
//        try {
//            ResultSet rs = con.query(sql.toString());
//            while (rs.next()) {
//                Empleado empleado = new Empleado();
//                empleado.setTipo_doc(rs.getString("tipo_doc"));
//                empleado.setIdenti(rs.getString("identi"));
//                empleado.setC_identif(rs.getString("identi"));
//                empleado.setNombre_1(rs.getString("nombre_1"));
//                empleado.setNombre_2(rs.getString("nombre_2"));
//                empleado.setApellido_1(rs.getString("apellido_1"));
//                empleado.setApellido_2(rs.getString("apellido_2"));
//                empleado.setN_nit_tip_iden(rs.getInt("n_nit_tip_iden"));
//                empleado.setN_rotulo(rs.getInt("n_rotulo"));
//                empleado.setN_emp_estado_laboral(rs.getInt("n_emp_estado_laboral"));
//                empleado.setN_trabajo(rs.getInt("n_trabajo"));
//                empleado.setN_cargo(rs.getInt("n_cargo"));
//                empleado.setN_apl_e_civil(rs.getInt("n_apl_e_civil"));
//                empleado.setN_apl_sexo(rs.getInt("n_apl_sexo"));
//                empleado.setN_ciudad_nace(rs.getInt("n_ciudad_nace"));
//                empleado.setN_pago_periodo(rs.getInt("n_pago_periodo"));
//                empleado.setSi_contratar(rs.getString("si_contratar"));
//                empleado.setSi_contratado(rs.getString("si_contratado"));
//                empleado.setSi_rechazado(rs.getString("si_rechazado"));
//                empleado.setSi_cabeza_familia(rs.getString("si_cabeza_familia"));
//                empleado.setSi_pago_a_transporte(rs.getString("si_pago_a_transporte"));
//                empleado.setSi_sal_integral(rs.getString("si_sal_integral"));
//                empleado.setDireccion(rs.getString("direccion"));
//                empleado.setTelefono(rs.getString("telefono"));
//                empleado.setTel_aux(rs.getString("tel_aux"));
//                empleado.setFax(rs.getString("fax"));
//                empleado.setBarrio(rs.getString("barrio"));
//                empleado.setNom_apl_ciudad(rs.getString("nom_apl_ciudad"));
//                empleado.setE_mail(rs.getString("e_mail"));
//                empleado.setE_mail_a(rs.getString("e_mail_a"));
//                empleado.setPagina_web(rs.getString("pagina_web"));
//                empleado.setLatitud(rs.getFloat("latitud"));
//                empleado.setLongitud(rs.getFloat("longitud"));
//                empleado.setProfesion(rs.getString("profesion"));
//                empleado.setId_ban_cuenta(rs.getInt("id_ban_cuenta"));
//                empleado.setN_cuenta_tipo(rs.getInt("n_cuenta_tipo"));
//                empleado.setCuenta_suc(rs.getString("cuenta_suc"));
//                empleado.setCuenta_cta(rs.getString("cuenta_cta"));
//                empleado.setBan_sucursal(rs.getString("ban_suc"));
//                empleado.setNo_estatura(rs.getFloat("no_estatura"));
//                empleado.setNo_peso(rs.getFloat("no_peso"));
//                empleado.setFecha(rs.getDate("fecha"));
//                empleado.setFec_actual(rs.getDate("fec_actual"));
//                empleado.setFec_nace(rs.getDate("fec_nace"));
//                empleado.setVr_salario_aspira(rs.getFloat("vr_salario_aspira"));
//                empleado.setN_apl_sangre_tipo(rs.getInt("n_apl_sangre_tipo"));
//                empleado.setFec_desde(rs.getDate("fec_desde"));
//                empleado.setFec_hasta(rs.getDate("fec_hasta"));
//                list.add(empleado);
//            }
//        } catch (SQLException e) {
//            msgEx = e.getMessage();
//            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_EMPLEADO_CONTRATAR", msgEx);
//            FacesContext.getCurrentInstance().addMessage(null, message); 
//            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
//            
//        } finally {
//            con.close();
//        }
//        return list;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado nombreContrato(Empleado empleado) {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_OPERADOR_LOGIN (");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                empleado.setIdenti(rs.getString("identi"));
                empleado.setNombre_1(rs.getString("nombre_1"));
                empleado.setNombre_2(rs.getString("nombre_2"));
                empleado.setApellido_1(rs.getString("apellido_1"));
                empleado.setApellido_2(rs.getString("apellido_2"));
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_OPERADOR_LOGIN", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return empleado;
    }

    @Override
    public List<Empleado> findAutoCompFuncionario(String query, String Si_es_Vigente) {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_AUTOCOMPLETAR_EMP (");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(query).append("', '");
        sql.append(Si_es_Vigente).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<Empleado> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdenti(rs.getString("identi"));
                empleado.setIdenti_con(rs.getString("identi_con"));
                empleado.setApellidos_nombres(rs.getString("razon_social"));
                empleado.setNo_con_trabajo(rs.getInt("no_con_trabajo"));
                empleado.setFecha_inicia(rs.getDate("fecha_inicia"));
                empleado.setFecha_retiro(rs.getDate("fecha_retiro"));
                empleado.setLpersona(false);
                
                list.add(empleado);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_AUTOCOMPLETAR_EMP", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<Empleado> findVigentes(Date fechaHasta) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RJ_EMP_VIGENTES ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(fechaHasta)).append("')");
        
        List<Empleado> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodo(rs.getString("cod_o"));
                empleado.setIdenti(rs.getString("identi"));
                empleado.setIdenti_con(MyUtilFormat.formatOutput(rs.getString("identi")));
                empleado.setNombre_1(rs.getString("nombre_1"));
                empleado.setNombre_2(rs.getString("nombre_2"));
                empleado.setApellido_1(rs.getString("apellido_1"));
                empleado.setApellido_2(rs.getString("apellido_2"));
                empleado.setNo_con_trabajo(rs.getInt("no_con_trabajo"));
                empleado.setN_centro_costo(rs.getInt("n_cen_costo"));
                empleado.setCen_costo(rs.getString("ubicacion"));
                empleado.setCosto(rs.getString("costo"));
                empleado.setFecha_inicia(rs.getDate("fecha_inicia"));
                empleado.setFecha_retiro(rs.getDate("fecha_retiro"));
                empleado.setCon_trabajo(rs.getString("con_trabajo"));
                empleado.setRazon_eps(rs.getString("razon_eps"));
                empleado.setRazon_fdp(rs.getString("razon_fdp"));
                empleado.setSi_es_pago_aux_tran(rs.getString("si_tra"));
                empleado.setSi_es_salario_integral(rs.getString("si_int"));
                if ("Si".equals(rs.getString("si_tra")) ) {
                    empleado.setSi_pago_aux_tran(true);
                } else {
                    empleado.setSi_pago_aux_tran(false);
                }
                if ("Si".equals(rs.getString("si_int")) ) {
                    empleado.setSi_sal_integral(true);
                } else {
                    empleado.setSi_sal_integral(false);
                }
                if ("Si".equals(rs.getString("si_arl")) ) {
                    empleado.setSi_apor_arl(true);
                } else {
                    empleado.setSi_apor_arl(false);
                }    
                empleado.setVr_tarifa_arl(rs.getFloat("vr_tarifa_arl"));

                empleado.setLpersona(false);
                
                list.add(empleado);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RJ_EMP_VIGENTES", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<Empleado> findCumpleanos(Date fechaHasta) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RJ_EMP_CUMPLEANOS ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(fechaHasta)).append("')");
        
        List<Empleado> list = new ArrayList<>();
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodo(rs.getString("cod_o"));
                empleado.setIdenti(rs.getString("identi"));
                empleado.setIdenti_con(MyUtilFormat.formatOutput(rs.getString("identi")));
                empleado.setNombre_1(rs.getString("nombre_1"));
                empleado.setNombre_2(rs.getString("nombre_2"));
                empleado.setApellido_1(rs.getString("apellido_1"));
                empleado.setApellido_2(rs.getString("apellido_2"));
                empleado.setN_centro_costo(rs.getInt("n_cen_costo"));
                empleado.setCen_costo(rs.getString("ubicacion"));
                empleado.setMes_cumple(rs.getInt("mes_cumple"));
                empleado.setDia_cumple(rs.getInt("dia_cumple"));
                
                empleado.setLpersona(false);
                
                list.add(empleado);
                
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RJ_EMP_CUMPLEANOS", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<Empleado> findIngresos(Date fechaDesde, Date fechaHasta) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RJ_EMP_INGRESOS ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(fechaDesde)).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(fechaHasta)).append("')");
        
        List<Empleado> list = new ArrayList<>();
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodo(rs.getString("cod_o"));
                empleado.setIdenti(rs.getString("identi"));
                empleado.setIdenti_con(MyUtilFormat.formatOutput(rs.getString("identi")));
                empleado.setNombre_1(rs.getString("nombre_1"));
                empleado.setNombre_2(rs.getString("nombre_2"));
                empleado.setApellido_1(rs.getString("apellido_1"));
                empleado.setApellido_2(rs.getString("apellido_2"));
                empleado.setNo_con_trabajo(rs.getInt("no_con_trabajo"));
                empleado.setN_centro_costo(rs.getInt("n_cen_costo"));
                empleado.setCen_costo(rs.getString("ubicacion"));
                empleado.setCosto(rs.getString("costo"));
                empleado.setFecha_inicia(rs.getDate("fecha_inicia"));
                empleado.setFecha_retiro(rs.getDate("fecha_retiro"));
                empleado.setCon_trabajo(rs.getString("con_trabajo"));
                empleado.setRazon_eps(rs.getString("razon_eps"));
                empleado.setRazon_fdp(rs.getString("razon_fdp"));
                empleado.setSi_es_pago_aux_tran(rs.getString("si_tra"));
                empleado.setSi_es_salario_integral(rs.getString("si_int"));
                if ("Si".equals(rs.getString("si_tra")) ) {
                    empleado.setSi_pago_aux_tran(true);
                } else {
                    empleado.setSi_pago_aux_tran(false);
                }
                if ("Si".equals(rs.getString("si_int")) ) {
                    empleado.setSi_sal_integral(true);
                } else {
                    empleado.setSi_sal_integral(false);
                }
                if ("Si".equals(rs.getString("si_arl")) ) {
                    empleado.setSi_apor_arl(true);
                } else {
                    empleado.setSi_apor_arl(false);
                }    
                empleado.setVr_tarifa_arl(rs.getFloat("vr_tarifa_arl"));

                empleado.setLpersona(false);
                
                list.add(empleado);
//                empleado = new Empleado();
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RJ_EMP_INGRESOS", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close(); 
        }
        return list;
    }

    @Override
    public List<Empleado> findRetirados(Date fechaDesde, Date fechaHasta) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RJ_EMP_RETIRADOS ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(fechaDesde)).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(fechaHasta)).append("')");
        
        List<Empleado> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodo(rs.getString("cod_o"));
                empleado.setIdenti(rs.getString("identi"));
                empleado.setIdenti_con(MyUtilFormat.formatOutput(rs.getString("identi")));
                empleado.setNombre_1(rs.getString("nombre_1"));
                empleado.setNombre_2(rs.getString("nombre_2"));
                empleado.setApellido_1(rs.getString("apellido_1"));
                empleado.setApellido_2(rs.getString("apellido_2"));
                empleado.setNo_con_trabajo(rs.getInt("no_con_trabajo"));
                empleado.setN_centro_costo(rs.getInt("n_cen_costo"));
                empleado.setCen_costo(rs.getString("ubicacion"));
                empleado.setCosto(rs.getString("costo"));
                empleado.setFecha_inicia(rs.getDate("fecha_inicia"));
                empleado.setFecha_retiro(rs.getDate("fecha_retiro"));
                empleado.setCon_trabajo(rs.getString("con_trabajo"));
                empleado.setRazon_eps(rs.getString("razon_eps"));
                empleado.setRazon_fdp(rs.getString("razon_fdp"));
                empleado.setSi_es_pago_aux_tran(rs.getString("si_tra"));
                empleado.setSi_es_salario_integral(rs.getString("si_int"));
                if ("Si".equals(rs.getString("si_tra")) ) {
                    empleado.setSi_pago_aux_tran(true);
                } else {
                    empleado.setSi_pago_aux_tran(false);
                }
                if ("Si".equals(rs.getString("si_int")) ) {
                    empleado.setSi_sal_integral(true);
                } else {
                    empleado.setSi_sal_integral(false);
                }
                if ("Si".equals(rs.getString("si_arl")) ) {
                    empleado.setSi_apor_arl(true);
                } else {
                    empleado.setSi_apor_arl(false);
                }    
                empleado.setVr_tarifa_arl(rs.getFloat("vr_tarifa_arl"));

                empleado.setLpersona(false);
                
                list.add(empleado);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RJ_EMP_RETIRADOS", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<Empleado> findSalarios(String identi, Date fechaHasta) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_EMP_SALARIO_ULTIMOS ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(identi).append("', ");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(fechaHasta)).append("')");
        
        List<Empleado> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
        
                Empleado empleado = new Empleado();
//                empleado.setClase_pago(rs.getString("clase_pago"));
//                empleado.setIso_4217(rs.getString("iso_4217"));
//                empleado.setSimbolo(rs.getString("simbolo"));
//                empleado.setVr_salario(rs.getDouble("vr_a_pagar"));
//                empleado.setSi_es_salario_especie(rs.getString("si_es_salario_especie"));
//                empleado.setFecha_desde(rs.getDate("Fecha_desde"));
                
                list.add(empleado);
                
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_EMP_SALARIO_ULTIMOS", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<Empleado> findRotulo(String identi, Date fechaHasta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> findCargos(String identi, Date fechaHasta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> findCenTrabajo(String identi, Date fechaHasta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> findSeguridad(String identi, Date fechaHasta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> findFormaPago(String identi, Date fechaHasta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String updateSalarios(Empleado empleado, int nEmpPagoClaseOld) {
    
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_EMP_CT_PAGO_CLASE ('");
        
        // IC_LOGIN,  ID_AGENCIA, ID_ALMACEN, 
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        
        sql.append(empleado.getIdenti()).append("', ");
        sql.append(empleado.getNo_con_trabajo()).append(", ");
        sql.append(nEmpPagoClaseOld).append(", ");
        sql.append(empleado.getN_emp_pago_clase()).append(", ");
        sql.append(empleado.getN_apl_moneda()).append(", ");    
        sql.append(empleado.getVr_salario_ultimo()).append(", '");
        if ("Si".equals(empleado.getSi_salario_especie())) {
            sql.append("Si").append("', ");
        } else {
            sql.append("No").append("', ");
        }
        sql.append(empleado.getId_documen()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empleado.getFecha_auxiliar())).append("')");
        
        ResultSet rs = con.query(sql.toString());
        try {

            while (rs.next()) {
                msg = rs.getString("mensaje");
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_EMP_CT_PAGO_CLASE", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }

    @Override
    public String updateRotulo(Empleado empleado) {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_NIT_ROTULO ('");
        
        // IC_LOGIN,  ID_AGENCIA, ID_ALMACEN, 
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", ");
        
        sql.append(empleado.getIdenti()).append(", ");
        sql.append(empleado.getNo_con_trabajo()).append(", ");
        sql.append(empleado.getN_apl_ciudad()).append(", '");
        sql.append(empleado.getDireccion()).append("', '");
        sql.append(empleado.getTel_uno()).append("', '");
        sql.append(empleado.getTel_aux()).append("', '");
        sql.append(empleado.getFax()).append("', '");
        
        // BARRIO, E_MAIL, E_MAIL_A, PAGINA_WEB, LATITUD, LONGITUD, FECHA_CONTROL 
        sql.append(empleado.getBarrio()).append("', '");
        sql.append(empleado.getE_mail()).append("', '");
        sql.append(empleado.getE_mail_a()).append("', '");
        sql.append(empleado.getPagina_web()).append("', ");
        sql.append(empleado.getLatitud()).append(", ");
        sql.append(empleado.getLongitud()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empleado.getFecha_auxiliar())).append("')");
        
        ResultSet rs = con.query(sql.toString());
        try {

            while (rs.next()) {
                msg = rs.getString("mensaje");
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_NIT_ROTULO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }

    @Override
    public String updateCargo(Empleado empleado, int nCargoOld) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_EMP_CT_CARGO ('");
        
        // IC_LOGIN,  ID_AGENCIA, ID_ALMACEN, 
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        
        sql.append(empleado.getIdenti()).append("', ");
        sql.append(empleado.getNo_con_trabajo()).append(", ");
        sql.append(nCargoOld).append(", ");
        sql.append(empleado.getN_cargo()).append(", ");
        sql.append(empleado.getId_documen()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empleado.getFecha_auxiliar())).append("')");
        
        ResultSet rs = con.query(sql.toString());
        try {

            while (rs.next()) {
                msg = rs.getString("mensaje");
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_EMP_CT_CARGO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }

    @Override
    public String updateCenTrabajo(Empleado empleado, int nCenCostoOld) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_EMP_CT_CENTRO_COSTO ('");
        
        // IC_LOGIN,  ID_AGENCIA, ID_ALMACEN, 
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", ");
        
        sql.append(empleado.getIdenti()).append(", ");
        sql.append(empleado.getNo_con_trabajo()).append(", ");
        sql.append(nCenCostoOld).append(", ");
        sql.append(empleado.getN_centro_costo()).append(", ");
        sql.append(empleado.getId_documen()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empleado.getFecha_auxiliar())).append("')");
        
        ResultSet rs = con.query(sql.toString());
        try {

            while (rs.next()) {
                msg = rs.getString("mensaje");
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_EMP_CT_CENTRO_COSTO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }

    @Override
    public String updateSeguridadSocial(Empleado empleado, String IdentiEpsOld, String IdentiFdpOld, String IdentiFdcOld) {
        con = new ConnectionDB();
        con.connect();
        
        con.setAutoCommit(false);

        StringBuilder msg1 = new StringBuilder();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_EMP_CT_SEGURIDAD_SOCIAL ('");
        
        // Actualizacion de EPS
        if (!"".equals(IdentiEpsOld)) {
            // IC_LOGIN,  ID_AGENCIA, ID_ALMACEN, 
            sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
            sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
            sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");

            sql.append(empleado.getIdenti()).append(", ");
            sql.append(empleado.getNo_con_trabajo()).append(", ");
            sql.append(" 1, '");
            sql.append(IdentiEpsOld).append("', '");
            sql.append(empleado.getIdenti_eps()).append("', ");

            sql.append(empleado.getId_documen()).append(", '");
            sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
            sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empleado.getFecha_auxiliar())).append("')");

            ResultSet rs = con.query(sql.toString());
            try {

                while (rs.next()) {
                    msg1.append("EPS ").append(rs.getString("mensaje"));
                }
                
            } catch (SQLException e) {
                msgEx = e.getMessage();
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_EMP_CT_SEGURIDAD_SOCIAL", msgEx);
                FacesContext.getCurrentInstance().addMessage(null, message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

            } finally {
                con.close();
            }
        }
        
        // Actualizacion de FDP
        if (!"".equals(IdentiFdpOld)) {
            
            sql = new StringBuilder();
            
            // IC_LOGIN,  ID_AGENCIA, ID_ALMACEN, 
            sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
            sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
            sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");

            sql.append(empleado.getIdenti()).append(", ");
            sql.append(empleado.getNo_con_trabajo()).append(", ");
            sql.append(" 2, '");
            sql.append(IdentiFdpOld).append("', '");
            sql.append(empleado.getIdenti_fdp()).append("', ");

            sql.append(empleado.getId_documen()).append(", '");
            sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
            sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empleado.getFecha_auxiliar())).append("')");

            ResultSet rs = con.query(sql.toString());
            try {

                while (rs.next()) {
                    msg1.append(" FDP ").append(rs.getString("mensaje"));
                }
                
            } catch (SQLException e) {
                msgEx = e.getMessage();
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_EMP_CT_SEGURIDAD_SOCIAL", msgEx);
                FacesContext.getCurrentInstance().addMessage(null, message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

            } finally {
                con.close();
            }
        }
        
        // Actualizacion de FDC
        if (!"".equals(IdentiFdcOld)) {
            
            sql = new StringBuilder();
            
            // IC_LOGIN,  ID_AGENCIA, ID_ALMACEN, 
            sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
            sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
            sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");

            sql.append(empleado.getIdenti()).append(", ");
            sql.append(empleado.getNo_con_trabajo()).append(", ");
            sql.append(" 2, '");
            sql.append(IdentiFdcOld).append("', '");
            sql.append(empleado.getIdenti_fdc()).append("', ");

            sql.append(empleado.getId_documen()).append(", '");
            sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
            sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empleado.getFecha_auxiliar())).append("')");

            ResultSet rs = con.query(sql.toString());
            try {

                while (rs.next()) {
                    msg1.append(" FDC ").append(rs.getString("mensaje"));
                }
                
            } catch (SQLException e) {
                msgEx = e.getMessage();
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_EMP_CT_SEGURIDAD_SOCIAL", msgEx);
                FacesContext.getCurrentInstance().addMessage(null, message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

            } finally {
                con.close();
            }
        }
        con.commit();
        
        return msg;
    }

    @Override
    public String updateFormaPago(Empleado empleado, int nFormaPagoOld) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_EMP_CT_FORMA_PAGO ('");
        
        // IC_LOGIN,  ID_AGENCIA, ID_ALMACEN, 
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", ");
        
        sql.append(empleado.getIdenti()).append(", ");
        sql.append(empleado.getNo_con_trabajo()).append(", ");
        sql.append(nFormaPagoOld).append(", ");
        sql.append(empleado.getN_emp_pago_forma()).append(", '");
        sql.append(empleado.getIdenti_banco()).append("', ");
        sql.append(empleado.getId_ban_cuenta()).append(", ");
        
        // N_BAN_CUENTA_TIPO, CUENTA_CTA, BAN_SUC, NO_ESTATURA, NO_PESO, 
        sql.append(empleado.getN_ban_cuenta_tipo()).append(", '");
        sql.append(empleado.getCuenta_cta()).append("', '");
        sql.append(empleado.getBan_sucursal()).append("', ");
        sql.append(empleado.getId_documen()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(empleado.getFecha_auxiliar())).append("')");
        
        ResultSet rs = con.query(sql.toString());
        try {

            while (rs.next()) {
                msg = rs.getString("mensaje");
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_EMP_CT_FORMA_PAGO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }
    
    @Override
    public Empleado findByEmpleado(String query) {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_EMPLEADO_BUSCAR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(query).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        Empleado empleado = new Empleado();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                
                // identi, identi_con, no_con_trabajo, d_v, 
                empleado.setIdenti(rs.getString("identi"));
                empleado.setIdenti_con(rs.getString("identi_con"));
                empleado.setNo_con_trabajo(rs.getInt("no_con_trabajo"));
                empleado.setD_v(rs.getString("d_v"));
                // apellidos_nombres, nombres_apellidos, nombre_1, nombre_2, apellido_1, apellido_2,
                empleado.setApellidos_nombres(rs.getString("apellidos_nombres"));
                empleado.setNombres_apellidos(rs.getString("nombres_apellidos"));
                empleado.setNombre_1(rs.getString("nombre_1"));
                empleado.setNombre_2(rs.getString("nombre_2"));
                empleado.setApellido_1(rs.getString("apellido_1"));
                empleado.setApellido_2(rs.getString("apellido_2"));
                // nom_tip_identidad, tipo_doc, dian_cod, nom_tip_contribuyente,
                empleado.setNom_nit_tip_identidad(rs.getString("nom_tip_identidad"));
                empleado.setTipo_doc(rs.getString("tipo_doc"));
                empleado.setDian_cod(rs.getString("dian_cod"));
                empleado.setNom_nit_tip_contribuyente(rs.getString("nom_tip_contribuyente"));
                // si_es_activo, direccion, telefono, telefax, e_mail, barrio, ciudad,
                empleado.setSi_es_activo(rs.getString("si_es_activo"));
                if (rs.getString("si_es_activo").equalsIgnoreCase("Si")) {
                    empleado.setSi_activo(true);
                } else {
                    empleado.setSi_activo(false);
                }  
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setTelefax(rs.getString("telefax"));
                empleado.setTel_uno(rs.getString("tel_uno"));
                empleado.setTel_aux(rs.getString("tel_aux"));
                empleado.setFax(rs.getString("fax"));
                empleado.setE_mail(rs.getString("e_mail"));
                empleado.setE_mail_a(rs.getString("e_mail_a"));
                empleado.setBarrio(rs.getString("barrio"));
                empleado.setCiudad(rs.getString("ciudad"));
                // depto, ciudad_depto, ciudad_dep, pagina_web, latitud, longitud,
                empleado.setDepto(rs.getString("depto"));
                empleado.setCiudad_depto(rs.getString("ciudad_depto"));
                empleado.setCiudad_dep(rs.getString("ciudad_dep"));
                empleado.setPagina_web(rs.getString("pagina_web"));
                empleado.setLatitud(rs.getFloat("latitud"));
                empleado.setLongitud(rs.getFloat("longitud"));
                empleado.setN_apl_ciudad(rs.getInt("n_apl_ciudad"));
                if (empleado.getN_apl_ciudad() != 0) {
                    empleado.setCiudad_depto(empleado.getCiudad_depto() + 
                                         " ID => " + empleado.getN_apl_ciudad());
                }
                
                // no_renovacion, no_impresion, con_trabajo, con_trabajo_padre, estado_laboral,
                empleado.setNo_renovacion(rs.getInt("no_renovacion"));
                empleado.setNo_impresion(rs.getInt("no_impresion"));
                empleado.setCon_trabajo(rs.getString("con_trabajo"));
                empleado.setCon_trabajo_padre(rs.getString("con_trabajo_padre"));
                empleado.setEstado_laboral(rs.getString("estado_laboral"));
                // nom_cen_costo, nom_cargo, nom_horario, pago_periodo, motivo_retiro, jornada,
                empleado.setN_centro_costo(rs.getInt("n_cen_costo"));
                empleado.setCen_costo(rs.getString("nom_cen_costo"));
                empleado.setN_cargo(rs.getInt("n_emp_cargo"));
                empleado.setCargo(rs.getString("nom_cargo"));
                empleado.setCargo_jefe(rs.getString("nombre_cargo_jefe"));
                empleado.setNom_horario(rs.getString("nom_horario"));
                empleado.setPago_periodo(rs.getString("pago_periodo"));
                empleado.setMotivo_retiro(rs.getString("motivo_retiro"));
                empleado.setJornada(rs.getString("jornada"));
                // tarifa_arl, vr_tarifa_arl, ciudad_contra, ciudad_trabaja, ciudad_firma, 
                empleado.setTarifa_arl(rs.getString("tarifa_arl"));
                empleado.setVr_tarifa_arl(rs.getFloat("vr_tarifa_arl"));
                empleado.setCiudad_contra(rs.getString("ciudad_contra"));
                empleado.setCiudad_trabaja(rs.getString("ciudad_trabaja"));
                empleado.setCiudad_firma(rs.getString("ciudad_firma"));
                // ciudad_contra_dep, ciudad_trabaja_dep, ciudad_firma_dep, 
                empleado.setCiudad_contra_dep(rs.getString("ciudad_contra_dep"));
                empleado.setCiudad_trabaja_dep(rs.getString("ciudad_trabaja_dep"));
                empleado.setCiudad_firma_dep(rs.getString("ciudad_firma_dep"));
                // fecha_inicia, fecha_final, fecha_firma_contra, fecha_retiro, fecha_prueba, fecha_impresion,
                empleado.setFecha_inicia(rs.getDate("fecha_inicia"));
                empleado.setFecha_final(rs.getDate("fecha_final"));
                empleado.setFecha_firma_contra(rs.getDate("fecha_firma_contra"));
                empleado.setFecha_retiro(rs.getDate("fecha_retiro"));
                empleado.setFecha_prueba(rs.getDate("fecha_prueba"));
                empleado.setFecha_impresion(rs.getDate("fecha_impresion"));
                // dfecha_inicia, dfecha_final, dfecha_retiro, dfecha_prueba, dfecha_impresion, dfecha_firma,
                empleado.setDfecha_inicia(rs.getString("dfecha_inicia"));
                empleado.setDfecha_final(rs.getString("dfecha_final"));
                empleado.setDfecha_retiro(rs.getString("dfecha_retiro"));
                empleado.setDfecha_prueba(rs.getString("dfecha_prueba"));
                empleado.setDfecha_impresion(rs.getString("dfecha_impresion"));
                empleado.setDfecha_firma(rs.getString("dfecha_firma"));
                // si_es_contrato_firmado, si_es_justa_causa, si_es_salario_integral,
                if (rs.getString("si_es_contrato_firmado").equalsIgnoreCase("Si")) {
                    empleado.setSi_contrato_firmado(true);
                } else {
                    empleado.setSi_contrato_firmado(false);
                } 
                if (rs.getString("si_es_justa_causa").equalsIgnoreCase("Si")) {
                    empleado.setSi_justa_causa(true);
                } else {
                    empleado.setSi_justa_causa(false);
                } 
                if (rs.getString("si_es_salario_integral").equalsIgnoreCase("Si")) {
                    empleado.setSi_salario_integral(true);
                } else {
                    empleado.setSi_salario_integral(false);
                } 
                //  si_es_pago_aux_tran, si_es_liquidado,
                if (rs.getString("si_es_pago_aux_tran").equalsIgnoreCase("Si")) {
                    empleado.setSi_pago_aux_tran(true);
                } else {
                    empleado.setSi_pago_aux_tran(false);
                } 
                if (rs.getString("si_es_liquidado").equalsIgnoreCase("Si")) {
                    empleado.setSi_liquidado(true);
                } else {
                    empleado.setSi_liquidado(false);
                }
                if (rs.getString("si_se_pago_apor_eps").equalsIgnoreCase("Si")) {
                    empleado.setSi_apor_eps(true);
                } else {
                    empleado.setSi_apor_eps(false);
                } 
                if (rs.getString("si_se_pago_apor_fdp").equalsIgnoreCase("Si")) {
                    empleado.setSi_apor_fdp(true);
                } else {
                    empleado.setSi_apor_fdp(false);
                } 
                if (rs.getString("si_se_pago_apor_fdc").equalsIgnoreCase("Si")) {
                    empleado.setSi_apor_fdc(true);
                } else {
                    empleado.setSi_apor_fdc(false);
                } 
                if (rs.getString("si_se_pago_apor_arl").equalsIgnoreCase("Si")) {
                    empleado.setSi_apor_arl(true);
                } else {
                    empleado.setSi_apor_arl(false);
                } 
                if (rs.getString("si_se_pago_apor_sena").equalsIgnoreCase("Si")) {
                    empleado.setSi_apor_sena(true);
                } else {
                    empleado.setSi_apor_sena(false);
                } 
                if (rs.getString("si_se_pago_apor_icbf").equalsIgnoreCase("Si")) {
                    empleado.setSi_apor_icbf(true);
                } else {
                    empleado.setSi_apor_icbf(false);
                } 
                if (rs.getString("si_se_pago_apor_ccf").equalsIgnoreCase("Si")) {
                    empleado.setSi_apor_ccf(true);
                } else {
                    empleado.setSi_apor_ccf(false);
                }
                
                // n_emp_pago_forma, pago_forma, identi_banco, nombre_banco_con, 
                empleado.setN_emp_pago_forma(rs.getInt("n_emp_pago_forma"));
                if (empleado.getN_emp_pago_forma() == 1) {
                    empleado.setLpagoforma(true);
                } else {
                    empleado.setLpagoforma(false);        
                }
                empleado.setPago_forma(rs.getString("pago_forma"));
                empleado.setIdenti_banco(rs.getString("identi_banco"));
                empleado.setIdenti_banco_con(rs.getString("identi_banco_con"));
                // nombre_banco, ban_sucursal, cuenta_tipo, cuenta_cta_con,
                empleado.setNombre_banco(rs.getString("nombre_banco"));
                empleado.setBan_sucursal(rs.getString("ban_sucursal"));
                empleado.setCuenta_tipo(rs.getString("cuenta_tipo"));
                empleado.setN_ban_cuenta_tipo(rs.getInt("n_emp_pago_forma"));
                empleado.setCuenta_cta(rs.getString("cuenta_cta"));
                empleado.setCuenta_cta_con(rs.getString("cuenta_cta_con"));
                // razon_eps, razon_fdp, razon_fdc, texto_valor
                empleado.setRazon_eps(rs.getString("razon_eps"));
                empleado.setRazon_fdp(rs.getString("razon_fdp"));
                empleado.setRazon_fdc(rs.getString("razon_fdc"));
                empleado.setRazon_arl(rs.getString("razon_arl"));
                empleado.setRazon_ccf(rs.getString("razon_ccf"));
                empleado.setTexto_salario_inicial(rs.getString("texto_salario_inicial"));
                empleado.setTexto_salario_ultimo(rs.getString("texto_salario_ultimo"));
                empleado.setVr_salario_inicial(rs.getFloat("vr_salario_inicial"));
                empleado.setVr_salario_ultimo(rs.getFloat("vr_salario_ultimo"));
                empleado.setFecha_salario_cambio(rs.getDate("fecha_salario_cambio"));
                empleado.setReporte_nombre(rs.getString("reporte_nombre"));
                empleado.setFecha_auxiliar(util.ConversionUtil.getTimestamp());
                empleado.setIdenti_eps(rs.getString("identi_eps"));
                empleado.setIdenti_fdp(rs.getString("identi_fdp"));
                empleado.setIdenti_fdc(rs.getString("identi_fdc"));
                empleado.setN_emp_pago_clase(rs.getInt("n_emp_pago_clase"));
                empleado.setN_apl_moneda(rs.getInt("n_apl_moneda"));
                empleado.setSi_salario_especie(rs.getString("si_es_salario_especie"));
                
                empleado.setLpersona(true);
                
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_EMPLEADO_BUSCAR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return empleado;
    }

    @Override
    public String  eliminaContrato(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String  finalContrato(Empleado empleado) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_EMP_CT_CONTRATO_FINAL ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(empleado.getIdenti()).append("', ");
        sql.append(empleado.getNo_con_trabajo()).append(", ");
        sql.append(empleado.getN_emp_motivo_retiro()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(empleado.getFecha_auxiliar())).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                empleado.setMensaje(rs.getString("mensaje"));
                msg = rs.getString("mensaje");

            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_EMP_CT_CONTRATO_FINAL", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }

    @Override
    public String reintegraContrato(Empleado empleado) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_EMP_CT_CONTRATO_REINTEGRA ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(empleado.getIdenti()).append("', ");
        sql.append(empleado.getNo_con_trabajo()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(empleado.getFecha_retiro())).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                empleado.setMensaje(rs.getString("mensaje"));
                msg = rs.getString("mensaje");
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_EMP_CT_CONTRATO_REINTEGRA", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }

}