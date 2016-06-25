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
import model.AplMenuBar;

/**
 *
 * @author ebeltran
 */
public class AplMenuBarDaoImpl implements AplMenuBarDao {

    private static ConnectionDB con;
    String msgEx = null;
    Date date = new Date();
    
    @Override
    public String menuBars() {
    
        con = new ConnectionDB();
        con.connect();
                
        String msg = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_MENU_PERMISO (");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            if (rs.next()) {
                msg = rs.getString("textof");
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_MENU_PERMISO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }

    @Override
    public boolean verificaSubMenu(AplMenuBar aplMenuBar) {
    
        con = new ConnectionDB();
        con.connect();
        
        int t = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_MENU_PERMISO_CONTAR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(aplMenuBar.getId_Menu()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            if (rs.next()) {
                t = rs.getInt("total");
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_MENU_PERMISO_CONTAR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return (t > 0);
    }

    @Override
    public List<AplMenuBar> buscaPorMenu(AplMenuBar aplMenuBar) {
    
        con = new ConnectionDB();
        con.connect();

        List<AplMenuBar> listaMenu = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_MENU_POR_TAB_MENUS_ID ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(aplMenuBar.getId_Menu()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");

        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplMenuBar m = new AplMenuBar();
                m.setId_Menu(rs.getInt("id_menu"));
                m.setNombre_Menu(rs.getString("nombre_menu"));
                m.setRuta_Jsp(rs.getString("ruta_jsp"));
                m.setRuta_Icon(rs.getString("ruta_icon"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setTab_Menus_Id(rs.getInt("tab_menus_id"));
                m.setTipo_Menu(rs.getString("tipo_menu"));

//                AplMenuBar subMenu = new AplMenuBar();
//                subMenu = buscaPorId(rs.getInt("tab_menus_id"));
//
//                m.setAplMenuBar(subMenu);
                listaMenu.add(m);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_MENU_POR_TAB_MENUS_ID", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return listaMenu;
    }    

    @Override
    public AplMenuBar buscaPorId(int id_Menu) {
    
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_MENU_POR_ID_MENU ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(id_Menu).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        AplMenuBar menu = new AplMenuBar();
        try {
            ResultSet rs = con.query(sql.toString());
            if (rs.next()) {
                menu.setId_Menu(rs.getInt("id_menu"));
                menu.setNombre_Menu(rs.getString("nombre_menu"));
                menu.setRuta_Jsp(rs.getString("ruta_jsp"));
                menu.setRuta_Icon(rs.getString("ruta_icon"));
                menu.setDescripcion(rs.getString("descripcion"));
                menu.setTab_Menus_Id(rs.getInt("tab_menus_id"));

                AplMenuBar subMenu = new AplMenuBar();
                subMenu = buscaPorId(rs.getInt("tab_menus_id"));
                menu.setAplMenuBar(subMenu);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_MENU_POR_ID_MENU", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return menu;
    }

    @Override
    public List<AplMenuBar> listaTodos() {
    
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_MENU_PERMISO_TODOS_N ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplMenuBar> listaMenu = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplMenuBar menu = new AplMenuBar();
                menu.setId_Menu(rs.getInt("id_menu"));
                menu.setNombre_Menu(rs.getString("nombre_menu"));
                menu.setRuta_Jsp(rs.getString("ruta_jsp"));
                menu.setRuta_Icon(rs.getString("ruta_icon"));
                menu.setDescripcion(rs.getString("descripcion"));
                menu.setTab_Menus_Id(rs.getInt("tab_menus_id"));

                AplMenuBar subMenu = new AplMenuBar();
//                subMenu = buscaPorId(rs.getInt("tab_menus_id"));
                menu.setAplMenuBar(subMenu);
                listaMenu.add(menu);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_MENU_PERMISO_TODOS_N", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return listaMenu;
    }

    @Override
    public List<AplMenuBar> listaTodosTipoMenu() {
    
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_MENU_PERMISO_N ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplMenuBar> listaMenu = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplMenuBar menu = new AplMenuBar();
                menu.setId_Menu(rs.getInt("id_menu"));
                menu.setNombre_Menu(rs.getString("nombre_menu"));
                menu.setRuta_Jsp(rs.getString("ruta_jsp"));
                menu.setRuta_Icon(rs.getString("ruta_icon"));
                menu.setDescripcion(rs.getString("descripcion"));
                menu.setTab_Menus_Id(rs.getInt("tab_menus_id"));
                menu.setTipo_Menu(rs.getString("tipo_menu"));

                listaMenu.add(menu);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_MENU_PERMISO_N", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return listaMenu;
    }

    @Override
    public List<AplMenuBar> listaMenuPermiso() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_MENU_OPERADOR_PERMISO_N ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplMenuBar> listaMenuPer = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplMenuBar menuBar = new AplMenuBar();
                menuBar.setId_Menu(rs.getInt("id_menu"));
                menuBar.setTab_Menus_Id(rs.getInt("tab_menus_id"));
                menuBar.setNo_Orden(rs.getInt("no_orden"));
                menuBar.setNombre_Menu(rs.getString("nombre_menu"));
                menuBar.setRuta_Jsp(rs.getString("ruta_jsp"));
                menuBar.setRuta_Icon(rs.getString("ruta_icon"));
                menuBar.setDescripcion(rs.getString("descripcion"));
                menuBar.setRuta_Ayuda(rs.getString("ruta_ayuda"));
                menuBar.setSi_Permiso(rs.getString("si_permiso"));
                menuBar.setTipo_Menu(rs.getString("tipo_menu"));
                listaMenuPer.add(menuBar);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_MENU_PERMISO_OPERADOR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return listaMenuPer;
    }
}