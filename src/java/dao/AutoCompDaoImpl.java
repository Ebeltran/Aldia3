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
import model.AutoComp;

/**
 *
 * @author ebeltran
 */
public class AutoCompDaoImpl implements AutoCompDao {

    private static ConnectionDB con;
    String msgEx = null;
    String msg = null;
    Date date = new Date();
    
    @Override
    public List<AutoComp> findAutoCompCiudad(String query) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_AUTOCOMPLETAR_APL_CIUDAD ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(query).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AutoComp> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AutoComp aC = new AutoComp();
                aC.setN_apl_ciudad(rs.getInt("n_apl_ciudad"));
                aC.setNo_apl_ciudad(Integer.toString(rs.getInt("n_apl_ciudad")));
                aC.setCiudad(rs.getString("ciudad"));
                aC.setDepartamento(rs.getString("departamento"));
                aC.setDepto(rs.getString("depto"));
                aC.setCiudad_depto(rs.getString("ciudad_depto"));
                aC.setCiudad_dep(rs.getString("ciudad_dep"));
                aC.setLatitud(rs.getFloat("latitud"));
                aC.setLongitud(rs.getFloat("longitud"));
                list.add(aC);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_AUTOCOMPLETAR_APL_CIUDAD", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public List<AutoComp> findAutoCompCiudadNace(String query) {
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_AUTOCOMPLETAR_APL_CIUDAD ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(query).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AutoComp> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AutoComp aC = new AutoComp();
                aC.setN_ciudad_nace(rs.getInt("n_apl_ciudad"));
                aC.setNo_ciudad_nace(Integer.toString(rs.getInt("n_apl_ciudad"))); 
                aC.setCiudad_nace(rs.getString("ciudad"));
                aC.setDepartamento_nace(rs.getString("departamento"));
                aC.setDepto(rs.getString("depto"));
                aC.setCiudad_depto_nace(rs.getString("ciudad_depto"));
                aC.setCiudad_dep_nace(rs.getString("ciudad_dep"));
                list.add(aC);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_AUTOCOMPLETAR_APL_CIUDAD", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public AutoComp findByCiudad(String string) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_CIUDAD ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(string).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        AutoComp aC = new AutoComp();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                aC.setN_apl_ciudad(rs.getInt("n_apl_ciudad"));
                aC.setNo_apl_ciudad(Integer.toString(rs.getInt("n_apl_ciudad")));
                aC.setCiudad(rs.getString("ciudad"));
                aC.setDepartamento(rs.getString("departamento"));
                aC.setDepto(rs.getString("depto"));
                aC.setCiudad_depto(rs.getString("ciudad_depto"));
                aC.setCiudad_dep(rs.getString("ciudad_dep"));
                aC.setLatitud(rs.getFloat("latitud"));
                aC.setLongitud(rs.getFloat("longitud"));
                
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_CIUDAD", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }

        return aC;
    }

    @Override
    public AutoComp findByCiudadNace(String string) {
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_D_E_APL_CIUDAD ( '");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(string).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        AutoComp aC = new AutoComp();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                aC.setN_ciudad_nace(rs.getInt("n_apl_ciudad"));
                aC.setNo_ciudad_nace(Integer.toString(rs.getInt("n_apl_ciudad")));
                aC.setCiudad_nace(rs.getString("ciudad"));
                aC.setDepartamento_nace(rs.getString("departamento"));
                aC.setDepto_nace(rs.getString("depto"));
                aC.setCiudad_depto_nace(rs.getString("ciudad_depto"));
                aC.setCiudad_dep_nace(rs.getString("ciudad_dep"));
                aC.setLatitud_nace(rs.getFloat("latitud"));
                aC.setLongitud_nace(rs.getFloat("longitud"));
                
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_D_E_APL_CIUDAD", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }

        return aC;
    }

	@Override
	public List<AutoComp> findAutoCompCargo(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AutoComp> findAutoCompCentroCosto(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutoComp findByCentroCosto(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutoComp findByCargo(String string) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
