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
import model.CentroCosto;

/**
 *
 * @author ebeltran
 */
public class CentroCostoDaoImpl implements CentroCostoDao {

    private static ConnectionDB con;
    String msgEx = null;
    String msg = null;
    Date date = new Date();

    @Override
    public CentroCosto findByAplOperador(CentroCosto centroCosto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(CentroCosto centroCosto) {
    
        con = new ConnectionDB();
        con.connect();
        boolean flag = false;
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RA_NIT_ADICIONAR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(centroCosto.getN_cen_costo()).append(", ");
        sql.append(centroCosto.getNom_centro_costo()).append("', ");
        sql.append(centroCosto.getN_cen_costo_padre()).append(", ");
        sql.append(centroCosto.getNivel()).append(", '");
        sql.append(centroCosto.getCosto()).append("', '");
        if (centroCosto.getSi_interfaz()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (centroCosto.getSi_afectable()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (centroCosto.getSi_control_fecha()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(centroCosto.getFecha())).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(centroCosto.getFec_ultimo_periodo())).append("', ");
        
        sql.append(centroCosto.getN_tarifa_arl()).append(", ");
        sql.append(centroCosto.getN_apl_pago_periodo()).append(", ");
        sql.append(centroCosto.getN_cta_base()).append(", ");
        sql.append(centroCosto.getNo_dias_novedad()).append(", ");
        sql.append(centroCosto.getNo_dias_liquida()).append(", ");
        sql.append(centroCosto.getNo_dias_pago()).append(", ");
        if (centroCosto.getSi_pago_jornal()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (centroCosto.getSi_pago_horas_extras()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        sql.append(centroCosto.getNo_horas_jornada()).append(", ");
        sql.append(centroCosto.getNo_horas_descanso()).append(", '");
        sql.append(new java.text.SimpleDateFormat("HH:mm:ss").format(centroCosto.getHo_inicio_jornada())).append("', '");
        sql.append(new java.text.SimpleDateFormat("HH:mm:ss").format(centroCosto.getHo_fin_jornada())).append("', '");
        sql.append(new java.text.SimpleDateFormat("HH:mm:ss").format(centroCosto.getHo_inicio_descanso())).append("', '");
        sql.append(new java.text.SimpleDateFormat("HH:mm:ss").format(centroCosto.getHo_fin_descanso())).append(", ");
        if (centroCosto.getSi_descanso()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (centroCosto.getSi_liquidar()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        sql.append(centroCosto.getIdenti_arl()).append("' ) ");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                centroCosto.setMensaje(rs.getString("mensaje"));
            }
            flag = true;
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RA_NIT_ADICIONAR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return flag;
    }

    @Override
    public String update(CentroCosto centroCosto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findByEmpS(CentroCosto centroCosto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CentroCosto> findAll() {
    
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_CON_CEN_COSTO ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");

        List<CentroCosto> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                CentroCosto centroCosto = new CentroCosto();
                centroCosto.setN_cen_costo(rs.getInt("n_cen_costo"));
                centroCosto.setN_emp_jornada(rs.getInt("n_emp_jornada"));
                centroCosto.setN_tarifa_arl(rs.getInt("n_tarifa_arl"));
                centroCosto.setN_apl_pago_periodo(rs.getInt("n_apl_pago_periodo"));
                centroCosto.setN_cta_base(rs.getInt("n_cta_base"));
                centroCosto.setNom_centro_costo(rs.getString("nombre"));
                centroCosto.setNombre_padre(rs.getString("nombre_padre"));
                centroCosto.setNivel(rs.getInt("nivel"));
                centroCosto.setCosto(rs.getString("costo"));
                centroCosto.setFecha(rs.getDate("fecha"));
                centroCosto.setFec_ultimo_periodo(rs.getDate("fec_ultimo_periodo"));
                centroCosto.setEmp_jornada(rs.getString("emp_jornada"));
                centroCosto.setN_emp_horario(rs.getInt("n_emp_horarario"));
                centroCosto.setNom_horario(rs.getString("nom_horario"));
                centroCosto.setDes_horario(rs.getString("des_horario"));
                centroCosto.setVr_tarifa_arl(rs.getFloat("vr_tarifa_arl"));
                centroCosto.setNo_dias_novedad(rs.getInt("no_dias_novedad"));
                centroCosto.setNo_dias_liquida(rs.getInt("no_dias_liquida"));
                centroCosto.setNo_dias_pago(rs.getInt("no_dias_pago"));
                if (rs.getString("si_es_interfaz").equals("Si")) {
                    centroCosto.setSi_interfaz(true);
                } else {
                    centroCosto.setSi_interfaz(false);
                }
                if (rs.getString("si_es_afectable").equals("Si")) {
                    centroCosto.setSi_afectable(true);
                } else {
                    centroCosto.setSi_afectable(false);
                }
                if (rs.getString("si_es_control_fecha").equals("Si")) {
                    centroCosto.setSi_control_fecha(true);
                } else {
                    centroCosto.setSi_control_fecha(false);
                }
                if (rs.getString("si_es_pago_jornal").equals("Si")) {
                    centroCosto.setSi_pago_jornal(true);
                } else {
                    centroCosto.setSi_pago_jornal(false);
                }
                if (rs.getString("si_es_pago_horas_extras").equals("Si")) {
                    centroCosto.setSi_pago_horas_extras(true);
                } else {
                    centroCosto.setSi_pago_horas_extras(false);
                }
                if (rs.getString("si_es_descanso").equals("Si")) {
                    centroCosto.setSi_descanso(true);
                } else {
                    centroCosto.setSi_descanso(false);
                }
                if (rs.getString("si_es_liquidar").equals("Si")) {
                    centroCosto.setSi_liquidar(true);
                } else {
                    centroCosto.setSi_liquidar(false);
                }
                centroCosto.setNo_horas_jornada(rs.getFloat("no_horas_jornada"));
                centroCosto.setNo_horas_descanso(rs.getFloat("no_horas_descanso"));

                centroCosto.setHo_inicio_jornada(rs.getDate("ho_inicio_jornada"));
                centroCosto.setHo_ini_jor(new java.text.SimpleDateFormat("HH:mm").format(rs.getTimestamp("ho_inicio_jornada")));
                centroCosto.setHo_fin_jornada(rs.getDate("ho_fin_jornada"));
                centroCosto.setHo_fin_jor(new java.text.SimpleDateFormat("HH:mm").format(rs.getTimestamp("ho_fin_jornada")));
                centroCosto.setHo_inicio_descanso(rs.getDate("ho_inicio_descanso"));
                centroCosto.setHo_ini_des(new java.text.SimpleDateFormat("HH:mm").format(rs.getTimestamp("ho_inicio_descanso")));
                centroCosto.setHo_fin_descanso(rs.getDate("ho_fin_descanso"));
                centroCosto.setHo_fin_des(new java.text.SimpleDateFormat("HH:mm").format(rs.getTimestamp("ho_fin_descanso")));
                centroCosto.setIdenti_arl(rs.getString("identi_arl"));
                centroCosto.setNombre_arl(rs.getString("nombre_arl"));
                centroCosto.setPago_periodo(rs.getString("pago_periodo"));
                centroCosto.setNom_cbase(rs.getString("nom_cbase"));

                list.add(centroCosto);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_CON_CEN_COSTO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<CentroCosto> findAutoCompCCosto(String query) {
    
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_AUTOCOMPLETAR_CEN_COSTO ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(query).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<CentroCosto> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                CentroCosto centroCosto = new CentroCosto();
                centroCosto.setN_cen_costo(rs.getInt("n_cen_costo"));
                centroCosto.setN_emp_jornada(rs.getInt("n_emp_jornada"));
                centroCosto.setN_tarifa_arl(rs.getInt("n_tarifa_arl"));
                centroCosto.setN_apl_pago_periodo(rs.getInt("n_apl_pago_periodo"));
                centroCosto.setN_cta_base(rs.getInt("n_cta_base"));
                centroCosto.setN_emp_horario(rs.getInt("n_emp_horario"));
                centroCosto.setNom_centro_costo(rs.getString("nom_centro_costo"));
                centroCosto.setNombre_padre(rs.getString("nombre_padre"));
                centroCosto.setNivel(rs.getInt("nivel"));
                centroCosto.setCosto(rs.getString("costo"));
                centroCosto.setFecha(rs.getDate("fecha"));
                centroCosto.setFec_ultimo_periodo(rs.getDate("fec_ultimo_periodo"));
                centroCosto.setEmp_jornada(rs.getString("emp_jornada"));
                centroCosto.setNom_horario(rs.getString("nom_horario"));
                centroCosto.setDes_horario(rs.getString("des_horario"));
                centroCosto.setTarifa_arl(rs.getString("tarifa_arl"));
                centroCosto.setVr_tarifa_arl(rs.getFloat("vr_tarifa_arl"));
                centroCosto.setNo_dias_novedad(rs.getInt("no_dias_novedad"));
                centroCosto.setNo_dias_liquida(rs.getInt("no_dias_liquida"));
                centroCosto.setNo_dias_pago(rs.getInt("no_dias_pago"));
                centroCosto.setNo_horas_jornada(rs.getFloat("no_horas_jornada"));
                centroCosto.setNo_horas_descanso(rs.getFloat("no_horas_descanso"));
                centroCosto.setSi_es_interfaz(rs.getString("si_es_interfaz"));
                centroCosto.setSi_es_afectable(rs.getString("si_es_afectable"));
                centroCosto.setSi_es_control_fecha(rs.getString("si_es_control_fecha"));
                centroCosto.setSi_es_pago_jornal(rs.getString("si_es_pago_jornal"));
                centroCosto.setSi_es_pago_horas_extras(rs.getString("si_es_pago_horas_extras"));
                centroCosto.setSi_es_descanso(rs.getString("si_es_descanso"));
                centroCosto.setSi_es_liquidar(rs.getString("si_es_liquidar"));
                centroCosto.setHo_inicio_jornada(rs.getDate("ho_inicio_jornada"));
                centroCosto.setHo_fin_jornada(rs.getDate("ho_fin_jornada"));
                centroCosto.setHo_inicio_descanso(rs.getDate("ho_inicio_descanso"));
                centroCosto.setHo_fin_descanso(rs.getDate("ho_fin_descanso"));
                centroCosto.setIdenti_arl(rs.getString("identi_arl"));
                centroCosto.setNombre_arl(rs.getString("nombre_arl"));
                centroCosto.setPago_periodo(rs.getString("pago_periodo"));
                centroCosto.setNom_periodo(rs.getString("nom_periodo"));
                centroCosto.setNom_cbase(rs.getString("nom_cbase"));
                        
                list.add(centroCosto);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_AUTOCOMPLETAR_CEN_COSTO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public CentroCosto findByCentroCosto(String string) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_EMP_CARGO ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(string).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        CentroCosto centroCosto = new CentroCosto();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                centroCosto.setN_cen_costo(rs.getInt("n_cen_costo"));
                centroCosto.setEmp_jornada(rs.getString("emp_jornada"));
                centroCosto.setN_tarifa_arl(rs.getInt("n_tarifa_arl"));
                centroCosto.setN_apl_pago_periodo(rs.getInt("n_apl_pago_periodo"));
                centroCosto.setN_cta_base(rs.getInt("n_cta_base"));
                centroCosto.setN_emp_horario(rs.getInt("n_emp_horario"));
                centroCosto.setNom_centro_costo(rs.getString("nom_centro_costo"));
                centroCosto.setNivel(rs.getInt("nivel"));
                centroCosto.setCosto(rs.getString("costo"));
                centroCosto.setFecha(rs.getDate("fecha"));
                centroCosto.setFec_ultimo_periodo(rs.getDate("fec_ultimo_periodo"));
                centroCosto.setEmp_jornada(rs.getString("emp_jornada"));
                centroCosto.setNom_horario(rs.getString("nom_horario"));
                centroCosto.setDes_horario(rs.getString("des_horario"));
                centroCosto.setTarifa_arl(rs.getString("tarifa_arl"));
                centroCosto.setNo_dias_novedad(rs.getInt("no_dias_novedad"));
                centroCosto.setNo_dias_liquida(rs.getInt("no_dias_liquida"));
                centroCosto.setNo_dias_pago(rs.getInt("no_dias_pago"));
                centroCosto.setNo_horas_jornada(rs.getFloat("no_horas_jornada"));
                centroCosto.setNo_horas_descanso(rs.getFloat("no_horas_descanso"));
                centroCosto.setSi_es_interfaz(rs.getString("si_es_interfaz"));
                if (rs.getString("si_es_interfaz").equals("Si")) {
                    centroCosto.setSi_interfaz(true);
                } else {
                    centroCosto.setSi_interfaz(false);
                }
                centroCosto.setSi_es_afectable(rs.getString("si_es_afectable"));
                if (rs.getString("si_es_afectable").equals("Si")) {
                    centroCosto.setSi_afectable(true);
                } else {
                    centroCosto.setSi_afectable(false);
                }
                centroCosto.setSi_es_control_fecha(rs.getString("si_es_control_fecha"));
                if (rs.getString("si_es_control_fecha").equals("Si")) {
                    centroCosto.setSi_control_fecha(true);
                } else {
                    centroCosto.setSi_control_fecha(false);
                }
                centroCosto.setSi_es_pago_jornal(rs.getString("si_es_pago_jornal"));
                if (rs.getString("si_es_pago_jornal").equals("Si")) {
                    centroCosto.setSi_pago_jornal(true);
                } else {
                    centroCosto.setSi_pago_jornal(false);
                }
                centroCosto.setSi_es_pago_horas_extras(rs.getString("si_es_pago_horas_extras"));
                if (rs.getString("si_es_pago_horas_extras").equals("Si")) {
                    centroCosto.setSi_pago_horas_extras(true);
                } else {
                    centroCosto.setSi_pago_horas_extras(false);
                }
                centroCosto.setSi_es_descanso(rs.getString("si_es_descanso"));
                if (rs.getString("si_es_descanso").equals("Si")) {
                    centroCosto.setSi_descanso(true);
                } else {
                    centroCosto.setSi_descanso(false);
                }
                centroCosto.setSi_es_liquidar(rs.getString("si_es_liquidar"));
                if (rs.getString("si_es_liquidar").equals("Si")) {
                    centroCosto.setSi_liquidar(true);
                } else {
                    centroCosto.setSi_liquidar(false);
                }
                centroCosto.setHo_inicio_jornada(rs.getDate("ho_inicio_jornada"));
                centroCosto.setHo_fin_jornada(rs.getDate("ho_fin_jornada"));
                centroCosto.setHo_inicio_descanso(rs.getDate("ho_inicio_descanso"));
                centroCosto.setHo_fin_descanso(rs.getDate("ho_fin_descanso"));
                centroCosto.setIdenti_arl(rs.getString("identi_arl"));
                centroCosto.setNombre_arl(rs.getString("nombre_arl"));
                centroCosto.setPago_periodo(rs.getString("pago_periodo"));
                centroCosto.setNom_periodo(rs.getString("nom_periodo"));
                centroCosto.setNom_cbase(rs.getString("nom_cbase"));
            
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_EMP_CARGO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }

        return centroCosto;
    }
}
