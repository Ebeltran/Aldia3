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
import model.Contabilidad;

/**
 *
 * @author Eduar
 */
public class ContabilidadDaoImpl implements ContabilidadDao {

    private static ConnectionDB con;
    String msgEx = null;
    String msg = null;
    FacesMessage message = null;
    
    Date date = new Date();

    @Override
    public List<Contabilidad> findAll() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_CON_MAESTRA_CUENTAS ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<Contabilidad> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                Contabilidad conta = new Contabilidad();

                conta.setId(rs.getInt("id"));
                conta.setId_depende(rs.getInt("id_depende"));
                conta.setCuenta_numero(rs.getString("cuenta_numero"));
                conta.setCuenta_nombre(rs.getString("cuenta_nombre"));
                conta.setCuenta_nombre_depende(rs.getString("cuenta_nombre_depende"));
                conta.setCuenta_depende(rs.getString("cuenta_depende"));
                conta.setCuenta_naturaleza(rs.getString("cuenta_naturaleza"));
                conta.setCuenta_nivel(rs.getString("cuenta_nivel"));
                conta.setCuenta_afectable(rs.getString("cuenta_afectable"));
                conta.setSi_es_cuenta_costo(rs.getString("si_es_cuenta_costo"));

                list.add(conta);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_CON_MAESTRA_CUENTAS", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public String create(Contabilidad contabilidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(Contabilidad contabilidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contabilidad findByCuentaConta(String string) {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_CON_MAESTRA_CUENTA_UNA ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(string).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        Contabilidad conta = new Contabilidad();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                conta.setId(rs.getInt("id"));
                conta.setId_depende(rs.getInt("id_depende"));
                conta.setCuenta_numero(rs.getString("cuenta_numero"));
                conta.setCuenta_nombre(rs.getString("cuenta_nombre"));
                conta.setCuenta_nombre_depende(rs.getString("cuenta_nombre_depende"));
                conta.setCuenta_depende(rs.getString("cuenta_depende"));
                conta.setCuenta_naturaleza(rs.getString("cuenta_naturaleza"));
                conta.setCuenta_nivel(rs.getString("cuenta_nivel"));
                conta.setCuenta_afectable(rs.getString("cuenta_afectable"));
                conta.setSi_es_cuenta_costo(rs.getString("si_es_cuenta_costo"));
                if (rs.getString("si_es_cuenta_costo").equalsIgnoreCase("Si")) {
                    conta.setLsi_cuenta_costo(true);
                    conta.setSi_cuenta_costo(1);
                } else {
                    conta.setLsi_cuenta_costo(false);
                    conta.setSi_cuenta_costo(0);
                }
 
                conta.setFecha_crea(rs.getDate("fecha_crea"));
                conta.setFactual(rs.getDate("factual"));

            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_CON_MAESTRA_CUENTA_UNA", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }

        return conta;
    }
    
    @Override
    public List<Contabilidad> findByContabilidad(String query) {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_AUTOCOMPLETAR_CON_MAESTRA (");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(query).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<Contabilidad> list = new ArrayList<>();
                
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {

                Contabilidad conta = new Contabilidad();
                conta.setId(rs.getInt("id"));
                conta.setId_depende(rs.getInt("id_depende"));
                conta.setCuenta_numero(rs.getString("cuenta_numero"));
                conta.setCuenta_nombre(rs.getString("cuenta_nombre"));
                conta.setCuenta_nombre_depende(rs.getString("cuenta_nombre_depende"));
                conta.setCuenta_depende(rs.getString("cuenta_depende"));
                conta.setCuenta_naturaleza(rs.getString("cuenta_naturaleza"));
                conta.setCuenta_nivel(rs.getString("cuenta_nivel"));
                conta.setCuenta_afectable(rs.getString("cuenta_afectable"));
                conta.setSi_es_cuenta_costo(rs.getString("si_es_cuenta_costo"));

                list.add(conta);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_AUTOCOMPLETAR_CON_MAESTRA", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;

    
    }

}
