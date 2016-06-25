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
import model.AplOperador;

/**
 *
 * @author ebeltran
 */
public class AplOperadorDaoImpl implements AplOperadorDao{
    
    private static ConnectionDB con;
    String msgEx = null;
    FacesMessage message = null;
    Date date = new Date();
    
    @Override
    public AplOperador findByAplOperador(AplOperador aplOperador) {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_OPERADOR_LOGIN (");
        sql.append(aplOperador.getId_agencia()).append(", '");
        sql.append(aplOperador.getLogin()).append("', '");
        sql.append(aplOperador.getPassword()).append("', '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");

        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                aplOperador.setIdenti(rs.getString("identi"));
                aplOperador.setNombre_1(rs.getString("nombre_1"));
                aplOperador.setNombre_2(rs.getString("nombre_2"));
                aplOperador.setApellido_1(rs.getString("apellido_1"));
                aplOperador.setApellido_2(rs.getString("apellido_2"));
//                aplOperador.setFirmaMecanica(rs.getBlob("firmaMecanica"));  
                aplOperador.setCorreo_email(rs.getString("correo_email"));
                aplOperador.setFec_ini_trabajo(rs.getDate("fec_ini_trabajo"));
                aplOperador.setFec_desde(rs.getDate("fec_desde"));
                aplOperador.setFec_hasta(rs.getDate("fec_hasta"));
                aplOperador.setHora_desde(rs.getDate("hora_desde"));
                aplOperador.setHora_hasta(rs.getDate("hora_hasta"));
                aplOperador.setFec_ult_acceso(rs.getDate("fec_ult_acceso"));
                aplOperador.setId_error(rs.getInt("id_error"));
                aplOperador.setMensaje(rs.getString("mensaje"));
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_OPERADOR_LOGIN", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
            }
        return aplOperador;
    }

    @Override
    public List<AplOperador> findAll() {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_APL_OPERADOR_TODOS ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("',");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<AplOperador> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                AplOperador aplOperador = new AplOperador();
                aplOperador.setUsuario(rs.getString("usuario"));
                aplOperador.setIdenti(rs.getString("identi"));
                aplOperador.setIdenti_con(rs.getString("identi"));
                aplOperador.setNombre_1(rs.getString("nombre_1"));
                aplOperador.setNombre_2(rs.getString("nombre_2"));
                aplOperador.setApellido_1(rs.getString("apellido_1"));
                aplOperador.setApellido_2(rs.getString("apellido_2"));
//                aplOperador.setFirma_mecanica(rs.getBlob("firma_mecanica"));
                aplOperador.setCorreo_email(rs.getString("correo_email"));
                aplOperador.setFec_desde(rs.getDate("fec_desde"));
                aplOperador.setFec_hasta(rs.getDate("fec_hasta"));
                aplOperador.setUltimo(rs.getDate("fec_ult_acceso"));
                aplOperador.setCambio(rs.getDate("fec_cambio_clave"));
                aplOperador.setHora_desde(rs.getDate("hora_desde"));
                aplOperador.setHora_hasta(rs.getDate("hora_hasta"));
                aplOperador.setChora_desde(new java.text.SimpleDateFormat("HH:mm").format(rs.getDate("hora_desde")));
                aplOperador.setChora_hasta(new java.text.SimpleDateFormat("HH:mm").format(rs.getDate("hora_hasta")));
                aplOperador.setSi_festivo(rs.getString("si_festivo"));
                if (rs.getString("si_festivo").equals("Si")) {
                    aplOperador.setLsi_festivo(true);
                } else {
                    aplOperador.setLsi_festivo(false);
                }
                aplOperador.setSi_activo(rs.getString("si_activo"));
                if (rs.getString("si_activo").equals("Si")) {
                    aplOperador.setLsi_activo(true);
                } else {
                    aplOperador.setLsi_activo(false);
                }
                
                list.add(aplOperador);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_APL_OPERADOR_TODOS", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
            }
        return list;
    }

    @Override
    public boolean create(AplOperador aplOperador) {
        
        con = new ConnectionDB();
        con.connect();
        boolean flag = false;
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RA_APL_OPERADOR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(aplOperador.getUsuario()).append("', '");
        sql.append(aplOperador.getIdenti()).append("', '");
        sql.append(aplOperador.getNombre_1()).append("', '");
        sql.append(aplOperador.getNombre_2()).append("', '");
        sql.append(aplOperador.getApellido_1()).append("', '");
        sql.append(aplOperador.getApellido_2()).append("', ");
        sql.append(aplOperador.getFirma_mecanica()).append(", '");
        sql.append(aplOperador.getSi_festivo()).append("', '");
        sql.append(aplOperador.getSi_activo()).append("', '");
        sql.append(aplOperador.getCfec_desde()).append("', '");
        sql.append(aplOperador.getChora_desde()).append("', '");
        sql.append(aplOperador.getChora_hasta()).append("', '");
        sql.append(aplOperador.getCorreo_email()).append("', '");
        sql.append(aplOperador.getClave_1()).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                aplOperador.setMensaje(rs.getString("mensaje"));
            }
            flag = true;
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RA_APL_OPERADOR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
            }
        return flag;
    }

    @Override
    public String update(AplOperador aplOperador) {
        
        con = new ConnectionDB();
        con.connect();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_APL_OPERADOR ('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(aplOperador.getIdenti()).append("', '");
        sql.append(aplOperador.getUsuario()).append("', '");
        sql.append(aplOperador.getNombre_1()).append("', '");
        sql.append(aplOperador.getNombre_2()).append("', '");
        sql.append(aplOperador.getApellido_1()).append("', '");
        sql.append(aplOperador.getApellido_2()).append("', '");
        sql.append(aplOperador.getFirma_mecanica()).append("', '");
        sql.append(aplOperador.getSi_festivo()).append("', '");
        sql.append(aplOperador.getSi_activo()).append("', '");
        sql.append(aplOperador.getChora_desde()).append("', '");
        sql.append(aplOperador.getChora_hasta()).append("', '");
        sql.append(aplOperador.getCorreo_email()).append("')");
        
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                aplOperador.setMensaje(rs.getString("mensaje"));
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_APL_OPERADOR", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
            }
        return aplOperador.getMensaje();
    }

    @Override
    public boolean delete(AplOperador aplOperador) {
        
        con = new ConnectionDB();
        con.connect();
        boolean flag = false;

        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM APL_OPERADOR WHERE USUARIO = '");
        sql.append(aplOperador.getUsuario()).append("', '");
        
        try {
            if (con.execute(sql.toString())) {
                flag = true;
            }
            
        } finally {
            con.close();
        }

        return flag;
    }

    @Override
    public String cambioClave(AplOperador aplOperador) {
        
        con = new ConnectionDB();
        con.connect();
        String msg = null;

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_APL_OPERADOR_CLAVE_CAMBIO('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(aplOperador.getPassword()).append("')");

        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                msg = rs.getString("mensaje");
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_APL_OPERADOR_CLAVE_CAMBIO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }

    @Override
    public String resetClave(AplOperador aplOperador) {
        
        con = new ConnectionDB();
        con.connect();
        String msg = null;

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RMA_APL_OPERADOR_CLAVE_RESET('");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).append("', ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", '");
        sql.append(aplOperador.getUsuario()).append("', '");
        sql.append(aplOperador.getPassword()).append("')");

        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                msg = rs.getString("mensaje");
            }

        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RMA_APL_OPERADOR_CLAVE_RESET", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } finally {
            con.close();
        }
        return msg;
    }

}
