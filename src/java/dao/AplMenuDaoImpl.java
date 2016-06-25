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
import model.AplMenu;

/**
 *
 * @author ebeltran
 */
public class AplMenuDaoImpl  implements AplMenuDao{

    private static ConnectionDB con;
    String msgEx = null;
    FacesMessage message = null;
    Date date = new Date();
    
    @Override
    public AplMenu findByAplMenu(AplMenu aplMenu) {
    
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_MENU ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(" )");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
//                aplMenu.setN_modulo(rs.getInt("n_modulo"));
//                aplMenu.setN_modulo_padre(rs.getInt("n_modulo_padre")); 
//                aplMenu.setNombre(rs.getString("nombre"));
//                aplMenu.setNo_orden(rs.getInt("no_orden"));
//                aplMenu.setDescripcion(rs.getString("descripcion"));
//                aplMenu.setRuta_jsp(rs.getString("ruta_jsp"));
//                aplMenu.setRuta_imagen(rs.getString("ruta_imagen"));
//                aplMenu.setRuta_ayuda(rs.getString("ruta_ayuda"));
//                aplMenu.setSi_interfaz(rs.getInt("si_interfaz"));
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_MENU", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return aplMenu;
    }

    @Override
    public List<AplMenu> findAll() {
    
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_MENU_TODOS_N ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("' ,");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplMenu> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplMenu aplMenu = new AplMenu();
                aplMenu.setId_menu(rs.getInt("id_menu"));
                aplMenu.setTab_menus_id(rs.getInt("tab_menus_id")); 
                aplMenu.setNo_orden(rs.getInt("no_orden"));
                aplMenu.setNombre_menu(rs.getString("nombre_menu"));
                aplMenu.setRuta_jsp(rs.getString("ruta_jsp"));
                aplMenu.setRuta_icon(rs.getString("ruta_icon"));
                aplMenu.setDescripcion(rs.getString("descripcion"));
                aplMenu.setRuta_ayuda(rs.getString("ruta_ayuda"));
                aplMenu.setSi_permiso(rs.getString("si_permiso"));
                if (rs.getString("si_permiso").equalsIgnoreCase("Si")) {
                    aplMenu.setLpermiso(true);
                } else {
                    aplMenu.setLpermiso(false);
                }    
                aplMenu.setTipo_menu(rs.getString("tipo_menu"));
                list.add(aplMenu);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_MENU_TODOS_N", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return list;
    }

    @Override
    public boolean create(AplMenu aplMenu) {
    
        con = new ConnectionDB();
        con.connect();

        boolean flag = false;
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RA_APL_MENU('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(aplMenu.getNombre_menu()).append("', '");
        sql.append(aplMenu.getRuta_jsp()).append("', '");
        sql.append(aplMenu.getRuta_icon()).append("', '");
        sql.append(aplMenu.getRuta_ayuda()).append("', '");
        sql.append(aplMenu.getSi_permiso()).append("', ");
        sql.append(aplMenu.getNo_orden()).append(", ");
        sql.append(aplMenu.getTab_menus_id()).append(", '");
        sql.append(aplMenu.getDescripcion()).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                aplMenu.setMensaje(rs.getString("mensaje"));
            }
            flag = true;
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RA_APL_MENU", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally{
            con.close();
        }
        return flag;
    }

    @Override
    public String update(AplMenu aplMenu) {
    
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_APL_MENU ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(aplMenu.getId_menu()).append(", '");
        sql.append(aplMenu.getNombre_menu()).append("', '");
        sql.append(aplMenu.getRuta_jsp()).append("', '");
        sql.append(aplMenu.getRuta_icon()).append("', '");
        sql.append(aplMenu.getRuta_ayuda()).append("', '");
        sql.append(aplMenu.getSi_permiso()).append("', ");
        sql.append(aplMenu.getNo_orden()).append(", ");
        sql.append(aplMenu.getTab_menus_id()).append(", '");
        sql.append(aplMenu.getDescripcion()).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                aplMenu.setMensaje(rs.getString("mensaje"));
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_APL_MENU", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return aplMenu.getMensaje();
    }

    @Override
    public String desActivate(AplMenu aplMenu) {
    
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM DA_APL_MENU ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(aplMenu.getId_menu()).append(")");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                aplMenu.setMensaje(rs.getString("mensaje"));
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "DA_APL_MENU", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return aplMenu.getMensaje();
    }

    
}
