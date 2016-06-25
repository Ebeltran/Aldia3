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
import model.AplParametro;

/**
 *
 * @author ebeltran
 */
public class AplParametroDaoImpl implements AplParametroDao{
    
    private static ConnectionDB con;
    String msgEx = null;
    Date date = new Date();
    
    @Override
    public void callEmpresa(AplParametro aplParametro) {
    
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_PARAMETRO_EMPRESA('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                aplParametro.setEmpresa_nombre(rs.getString("empresa_nombre"));
                aplParametro.setEmpresa_nit(rs.getString("empresa_nit"));
                aplParametro.setEmpresa_direccion(rs.getString("empresa_direccion"));
                aplParametro.setEmpresa_telefono1(rs.getString("empresa_telefono1"));
                aplParametro.setEmpresa_telefono2(rs.getString("empresa_telefono2"));
                aplParametro.setEmpresa_telefax(rs.getString("empresa_telefax"));
                aplParametro.setEmpresa_ciudad(rs.getString("empresa_ciudad"));
                aplParametro.setEmpresa_logo(rs.getString("empresa_logo"));
                aplParametro.setEmpresa_marca_agua(rs.getString("empresa_marca_agua"));
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_PARAMETRO_EMPRESA", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
    }
    
    @Override
    public AplParametro findByParametro(AplParametro aplParametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AplParametro> findAll() {
    
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_PARAMETRO_HOY('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplParametro> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplParametro aplParametro = new AplParametro();
                aplParametro.setN_parametro(rs.getInt("n_parametro"));
                aplParametro.setN_orden(rs.getInt("n_orden"));
                aplParametro.setDenominacion(rs.getString("denominacion")); 
                aplParametro.setImporte(rs.getString("Importe"));          
                aplParametro.setDescripcion(rs.getString("descripcion"));
                aplParametro.setFec_desde(rs.getTimestamp("Fec_desde"));
                aplParametro.setFec_hasta(rs.getTimestamp("Fec_hasta"));
                aplParametro.setFecha_cambio(rs.getTimestamp("Fec_desde"));
                
                
                list.add(aplParametro);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_PARAMETRO_HOY", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public boolean create(AplParametro aplParametro) {
    
        con = new ConnectionDB();
        con.connect();
        boolean flag = false;
       
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RA_APL_OPERADOR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(aplParametro.getN_parametro()).append(", ");
        sql.append(aplParametro.getN_orden()).append(", '");
        sql.append(aplParametro.getDenominacion()).append("', '");
        sql.append(aplParametro.getImporte()).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                aplParametro.setMensaje(rs.getString("mensaje"));
            }
            flag = true;
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RA_APL_OPERADOR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return flag;
    }

    @Override
    public String update(AplParametro aplParametro) {
    
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_APL_PARAMETRO ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(aplParametro.getN_parametro()).append(", ");
        sql.append(aplParametro.getN_orden()).append(", '");
        sql.append(aplParametro.getDenominacion()).append("', '");
        sql.append(aplParametro.getImporte()).append("', '");
        sql.append(aplParametro.getDescripcion()).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(aplParametro.getFecha_cambio())).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                aplParametro.setMensaje(rs.getString("mensaje"));
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_APL_OPERADOR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return aplParametro.getMensaje();
        
    }

}
