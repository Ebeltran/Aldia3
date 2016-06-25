/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionXBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.XBase;

/**
 *
 * @author Eduar
 */
public class XBaseDaoImpl implements XBaseDao {
    
    private static ConnectionXBase conX;
    String msgEx = null;
    String msg = null;
    Date date = new Date();    

    @Override
    public List<XBase> findAll() {
        
        conX = new ConnectionXBase();
        conX.connect();
        
        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT COD, NOMBRE, NIT, DV FROM MUS9500 ORDER BY COD");
        sql.append("SELECT * FROM MUS9500 ORDER BY NOMBRE");
        
        List<XBase> list = new ArrayList<>();
        try {
            ResultSet rs = conX.query(sql.toString());
            while (rs.next()) {
                XBase xBase = new XBase();
                
                xBase.setCod(rs.getString("cod"));
                xBase.setNombre(rs.getString("nombre"));
                xBase.setNit(rs.getString("nit"));
                xBase.setClase(rs.getString("clase"));
                xBase.setDv(rs.getString("dv"));
                xBase.setCliente(rs.getString("cliente"));
                xBase.setEmplead(rs.getString("emplead"));
                xBase.setTercero(rs.getString("tercero"));
                xBase.setBanco(rs.getString("banco"));
                xBase.setActivo(rs.getString("activo"));
                xBase.setFactua(rs.getDate("factua"));
                xBase.setCal_fis(rs.getString("cal_fis"));
                xBase.setAuto_rf(rs.getString("auto_rf"));
                xBase.setPejuri(rs.getString("pejuri"));
                xBase.setApe1(rs.getString("ape1"));
                xBase.setApe2(rs.getString("ape2"));
                xBase.setNom1(rs.getString("nom1"));
                xBase.setNom2(rs.getString("nom2"));
                xBase.setControl(rs.getString("control"));
                xBase.setTa_cree(rs.getString("ta_cree"));
                
                list.add(xBase);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "MUS9500.DBF", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            conX.close();
        }
        return list;
    }

    @Override
    public XBase findByEmpleado(String query) {
        
        conX = new ConnectionXBase();
        conX.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MUS9500 WHERE NIT = '");
        sql.append(query).append("'");
        
        XBase xBase = new XBase();
        try {
            ResultSet rs = conX.query(sql.toString());
            while (rs.next()) {
                
                xBase.setCod(rs.getString("cod"));
                xBase.setNombre(rs.getString("nombre"));
                xBase.setNit(rs.getString("nit"));
                xBase.setClase(rs.getString("clase"));
                xBase.setDv(rs.getString("dv"));
                xBase.setCliente(rs.getString("cliente"));
                xBase.setEmplead(rs.getString("emplead"));
                xBase.setTercero(rs.getString("tercero"));
                xBase.setBanco(rs.getString("banco"));
                xBase.setActivo(rs.getString("activo"));
                xBase.setFactua(rs.getDate("factua"));
                xBase.setCal_fis(rs.getString("cal_fis"));
                xBase.setAuto_rf(rs.getString("auto_rf"));
                xBase.setPejuri(rs.getString("pejuri"));
                xBase.setApe1(rs.getString("ape1"));
                xBase.setApe2(rs.getString("ape2"));
                xBase.setNom1(rs.getString("nom1"));
                xBase.setNom2(rs.getString("nom2"));
                xBase.setControl(rs.getString("control"));
                xBase.setTa_cree(rs.getString("ta_cree"));
                
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "MUS9500.DBF", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            conX.close();
        }
        return xBase;
    }
    
}
