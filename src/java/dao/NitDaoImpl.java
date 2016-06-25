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
import model.Nit;

/**
 *
 * @author ebeltran
 */
public class NitDaoImpl implements NitDao {

    private static ConnectionDB con = new ConnectionDB();;
    String msgEx = null;
    String msg = null;
    FacesMessage message = null;
    Date date = new Date();
        
    public NitDaoImpl() {
    }
    
    @Override
    public Nit findByNit(String query) {
    
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_NIT_BUSCAR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_alamcen")).append(", '");
        sql.append(query).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        
        Nit nit = new Nit();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                nit.setIdenti(rs.getString("identi"));
                nit.setRazon_social(rs.getString("razon_social"));
                nit.setIdenti_con(rs.getString("identi_con"));
                nit.setD_v(rs.getString("d_v"));
                nit.setNombre_1(rs.getString("nombre_1"));
                nit.setNombre_2(rs.getString("nombre_2"));
                nit.setApellido_1(rs.getString("apellido_1"));
                nit.setApellido_2(rs.getString("apellido_2"));
                nit.setRazon_comercial(rs.getString("razon_comercial"));
                nit.setLjuridica(true);
                
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return nit;
    }

    
    @Override
    public List<Nit> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Nit nit) {
    
        con.connect();

        boolean flag = false;
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RA_NIT_ADICIONAR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(nit.getIdenti()).append("', '");
        sql.append(nit.getD_v()).append("', ");
        sql.append(nit.getN_rotulo()).append(", ");
        sql.append(nit.getN_nit_tip_identidad()).append(", ");
        if (nit.getN_nit_cla_sociedad() == 0) {
            sql.append("10, ");
        } else {
            sql.append(nit.getN_nit_cla_sociedad()).append(", ");
        }
        sql.append(nit.getN_nit_tip_contribuyente()).append(", '");
        if (nit.getRazon_social() == null) {
            sql.append("', '");
        } else {
            sql.append(nit.getRazon_social()).append("', '");
        }
        if (nit.getRazon_comercial() == null) {
            sql.append("', '");
        } else {
            sql.append(nit.getRazon_comercial()).append("', '");
        }
        if (nit.getNombre_1() == null) {
            sql.append("', '");
        } else {
            sql.append(nit.getNombre_1()).append("', '");
        }
        if (nit.getNombre_2() == null) {
            sql.append("', '");
        } else {
            sql.append(nit.getNombre_2()).append("', '");
        }
        if (nit.getApellido_1() == null) {
            sql.append("', '");
        } else {
            sql.append(nit.getApellido_1()).append("', '");
        }
        if (nit.getApellido_2() == null) {
            sql.append("', '");
        } else {
            sql.append(nit.getApellido_2()).append("', '");
        }
        if (nit.isSi_es_cli()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (nit.isSi_es_ter()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (nit.isSi_es_emp()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (nit.isSi_es_ban()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (nit.isSi_es_cia()) {
            sql.append("Si").append("', '");
        } else {
            sql.append("No").append("', '");
        }
        if (nit.isSi_es_auto_rf()) {
            sql.append("Si").append("', ");
        } else {
            sql.append("No").append("', ");
        }
        sql.append(nit.getN_apl_e_civil()).append(", ");
        sql.append(nit.getN_apl_sexo()).append(", ");
        sql.append(nit.getN_apl_ciudad_nace()).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd").format(nit.getFec_nace())).append("', ");
        sql.append(nit.getN_apl_ciudad()).append(", '");
        sql.append(nit.getDireccion()).append("', '");
        sql.append(nit.getTelefono()).append("', '");
        sql.append(nit.getTel_aux()).append("', '");
        sql.append(nit.getFax()).append("', '");
        sql.append(nit.getBarrio()).append("', '");
        sql.append(nit.getE_mail()).append("', '");
        sql.append(nit.getE_mail_a()).append("', '");
        sql.append(nit.getPagina_web()).append("', ");
        sql.append(nit.getLatitud()).append(", ");
        sql.append(nit.getLongitud()).append(", '");
        sql.append(nit.getNom_apl_ciudad()).append("', '");
        sql.append(nit.getNom_apl_ciudad_nace()).append("' )");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                nit.setMensaje(rs.getString("mensaje"));
            }
            flag = true;
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return flag;
    }

    @Override
    public String update(Nit nit) {
    
        con.connect();
        
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT * FROM RS_AUTOCOMPLETAR_NIT ('");
//        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
//        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        return null;
        
    }

    @Override
    public List<Nit> findAutoCompRazonSocial(String query) {
    
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_AUTOCOMPLETAR_NIT_N ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(query).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<Nit> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                Nit nit = new Nit();
                nit.setIdenti(rs.getString("identi"));
                nit.setIdenti_con(rs.getString("identi_con"));
                nit.setRazon_social(rs.getString("razon_social"));
                nit.setLjuridica(false);
                
                list.add(nit);
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
}
