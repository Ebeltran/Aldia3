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
import model.AplMenuPermiso;

/**
 *
 * @author ebeltran
 */
public class AplMenuPermisoDaoImpl implements AplMenuPermisoDao {

    private static ConnectionDB con;
    String msgEx = null;
    String msg = null;
    Date date = new Date();
    
//    public AplMenuPermisoDaoImpl () {
//        AplMenuPermiso aplMenuPer = new AplMenuPermiso();         
//    }
    
    @Override
    public List<AplMenuPermiso> findAll() {
    
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_MENU_OPERADOR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplMenuPermiso> listaMenuPer = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplMenuPermiso menuPer = new AplMenuPermiso();
                menuPer.setId_Menu(rs.getInt("id_menu"));
                menuPer.setTab_Menus_Id(rs.getInt("tab_menus_id"));
                menuPer.setNo_Orden(rs.getInt("no_orden"));
                menuPer.setNombre_Menu(rs.getString("nombre_menu"));
                menuPer.setRuta_Jsp(rs.getString("ruta_jsp"));
                menuPer.setRuta_Icon(rs.getString("ruta_icon"));
                menuPer.setDescripcion(rs.getString("descripcion"));
                menuPer.setRuta_Ayuda(rs.getString("ruta_ayuda"));
                menuPer.setSi_Permiso(rs.getString("si_permiso"));
                if (rs.getString("si_permiso").equals("Si")) {
                    menuPer.setLpermiso(true);
                } else {
                    menuPer.setLpermiso(false);
                }
                menuPer.setTipo_Menu(rs.getString("tipo_menu"));
                listaMenuPer.add(menuPer);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_MENU_OPERADOR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return listaMenuPer;
    }

    @Override
    public List<AplMenuPermiso> findOper() {
    
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_MENU_OPERADOR_PERMISO ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        List<AplMenuPermiso> listaMenuOpera = new ArrayList<>();
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplMenuPermiso menuOpera = new AplMenuPermiso();
                menuOpera.setUsuario(rs.getString("usuario"));
                menuOpera.setNombre(rs.getString("nombre"));
                
                listaMenuOpera.add(menuOpera);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_MENU_OPERADOR_PERMISO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return listaMenuOpera;
    }


    @Override
    public boolean updatePer(List<AplMenuPermiso> aplMenuOpe) {
    
        con = new ConnectionDB();
        con.connect();
        
        con.setAutoCommit(false);

        msg = "";
        /* Obteniendo en String la fecha del sistema */
        String fecha = new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date);

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_APL_MENU_PERMISO_OPERADOR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        
        try {
            for (AplMenuPermiso det : aplMenuOpe) {
                StringBuilder sqlPer = new StringBuilder();
                sqlPer.append(sql.toString());
                sqlPer.append(det.getUsuario()).append("', ");
                sqlPer.append(det.getId_Menu()).append(", '");
                if (det.isLpermiso()) {
                    sqlPer.append("Si").append("', '");
                } else {
                    sqlPer.append("No").append("', '");
                }
                sqlPer.append(fecha).append("')");

                ResultSet rs = con.query(sqlPer.toString());
                while (rs.next()) {
                    msg = rs.getString("mensaje");
                }

            }
            con.commit();
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_APL_MENU_PERMISO_OPERADOR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return true;
    }

    @Override
    public boolean update(List<AplMenuPermiso> aplMenuOpe) {
    
        con = new ConnectionDB();
        con.connect();

        con.setAutoCommit(false);

        msg = "";
        /* Obteniendo en String la fecha del sistema */
        String fecha = new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date);
        
        StringBuilder sql = new StringBuilder();
        StringBuilder sqlPer = new StringBuilder();
        sql.append("SELECT * FROM RMA_APL_MENU_PERMISO_OPERADOR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        
        try {
            for (AplMenuPermiso det : aplMenuOpe) {
                sqlPer.append(sql.toString());
                sqlPer.append(det.getUsuario()).append("', ");
                sqlPer.append(det.getId_Menu()).append(", '");
                sqlPer.append(det.getSi_Permiso()).append("', '");
                sqlPer.append(fecha).append("')");

                ResultSet rs = con.query(sqlPer.toString());
                while (rs.next()) {
                    msg = rs.getString("mensaje");
                }

            }
        
            con.commit();

        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_APL_MENU_PERMISO_OPERADOR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return true;
    }

    @Override
    public List<AplMenuPermiso> findOperOne(String newLogin) {
    
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_MENU_PERMISO_OPERADOR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(newLogin).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplMenuPermiso> listaMenuPer = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplMenuPermiso menuPer = new AplMenuPermiso();
                menuPer.setUsuario(rs.getString("usuario"));
                menuPer.setId_Menu(rs.getInt("id_menu"));
                menuPer.setTab_Menus_Id(rs.getInt("tab_menus_id"));
                menuPer.setNo_Orden(rs.getInt("no_orden"));
                menuPer.setNombre_Menu(rs.getString("nombre_menu"));
                menuPer.setRuta_Jsp(rs.getString("ruta_jsp"));
                menuPer.setRuta_Icon(rs.getString("ruta_icon"));
                menuPer.setDescripcion(rs.getString("descripcion"));
                menuPer.setRuta_Ayuda(rs.getString("ruta_ayuda"));
                menuPer.setSi_Permiso(rs.getString("si_permiso"));
                if (rs.getString("si_permiso").equalsIgnoreCase("Si")) {
                    menuPer.setLpermiso(true);
                } else {
                    menuPer.setLpermiso(false);
                }
                menuPer.setTipo_Menu(rs.getString("tipo_menu"));
                listaMenuPer.add(menuPer);
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