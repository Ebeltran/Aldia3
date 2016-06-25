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
import model.Cia;


/**
 *
 * @author ebeltran
 */
public class CiaDaoImpl implements CiaDao {

    private static ConnectionDB con;
    String msgEx = null;
    FacesMessage message = null;
    Date date = new Date();
    
    @Override
    public List<Cia> findCia() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_CIA_HOY ('");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<Cia> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                Cia cia = new Cia();
                cia.setId_agencia(rs.getInt("id_agencia"));
                cia.setEmp_nombre(rs.getString("emp_nombre"));
                cia.setEmp_nit(rs.getString("emp_nit"));
                cia.setEmp_direccion(rs.getString("emp_direccion"));
                cia.setEmp_telefono1(rs.getString("emp_telefono1"));
                cia.setEmp_telefono2(rs.getString("emp_telefono2"));
                cia.setEmp_telefax(rs.getString("emp_telefax"));
                cia.setEmp_ciudad(rs.getString("emp_ciudad"));
                cia.setEmp_barrio(rs.getString("emp_barrio"));
                cia.setEmp_e_mail(rs.getString("emp_e_mail"));
                cia.setEmp_e_mail_a(rs.getString("emp_e_mail_a"));
                cia.setEmp_logo(rs.getString("emp_logo"));
                cia.setEmp_marca_agua(rs.getString("emp_marca_agua"));
                cia.setEmp_latitud(rs.getFloat("emp_latitud"));
                cia.setEmp_longitud(rs.getFloat("emp_longitud"));

                list.add(cia);
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();

        }
        return list;
    }

    @Override
    public List<Cia> findCiaSucAll(int i) {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_CIA_SUC_HOY ( ").append(i).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<Cia> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                Cia cia = new Cia();
                cia.setId_agencia(rs.getInt("id_agencia"));
                cia.setId_almacen(rs.getInt("id_almacen"));
                cia.setIdenti(rs.getString("identi"));
                cia.setId_almacen_padre(rs.getInt("id_almacen_padre"));
                cia.setRazon_comercial(rs.getString("razon_comercial"));

                list.add(cia);
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public Cia findByAplOperador(Cia cia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
