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
import model.ConceptoPago;

/**
 *
 * @author Eduar
 */
public class ConceptoPagoDaoImpl implements ConceptoPagoDao{

    private static ConnectionDB con;
    String msgEx = null;
    String msg = null;
    Date date = new Date();

    @Override
    public List<ConceptoPago> findAll() {
        
        con = new ConnectionDB();
        con.connect();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RS_NOM_CONCEPTO_PAGO ( ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_agencia")).append(", ");
        sql.append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_almacen")).append(", '");
        sql.append(new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date)).append("')");
        
        List<ConceptoPago> list = new ArrayList<>();
        try {
            ResultSet rs = con.query(sql.toString());
            while (rs.next()) {
                ConceptoPago ls = new ConceptoPago();

                ls.setN_pago_concepto(rs.getInt("n_pago_concepto"));
                ls.setNombre(rs.getString("nombre"));
                ls.setNombre_corto(rs.getString("nombre_corto"));
                ls.setDescripcion(rs.getString("descripcion"));
                ls.setNom_apl_conce_tipo(rs.getString("nom_apl_conce_tipo"));
                ls.setNom_apl_grupo(rs.getString("nom_apl_grupo"));
                ls.setNom_apl_conce_liq(rs.getString("nom_apl_conce_liq"));
                ls.setNom_apl_perio_pago(rs.getString("nom_apl_perio_pago"));
                ls.setNom_apl_cta_base_db(rs.getString("nom_apl_cta_base_db"));
                ls.setNom_apl_cta_base_cr(rs.getString("nom_apl_cta_base_cr"));
                ls.setNom_apl_cta_sufijo_db(rs.getString("nom_apl_cta_sufijo_db"));
                ls.setNom_apl_cta_sufijo_cr(rs.getString("nom_apl_cta_sufijo_cr"));
                ls.setNom_apl_uni_medida(rs.getString("nom_apl_uni_medida"));
                ls.setCuenta_numero_db(rs.getString("cuenta_numero_db"));
                ls.setCuenta_numero_cr(rs.getString("cuenta_numero_cr"));
                ls.setFactor_x_100(rs.getFloat("factor_x_100"));
                ls.setCantidad(rs.getFloat("cantidad"));
                ls.setVr_concepto(rs.getFloat("vr_concepto"));
                ls.setCantidad_minima(rs.getFloat("cantidad_minima"));
                ls.setCantidad_maxima(rs.getFloat("cantidad_maxima"));
                ls.setValor_minimo(rs.getFloat("valor_minimo"));
                ls.setValor_maximo(rs.getFloat("valor_maximo"));
                ls.setSi_es_puc_base_db(rs.getString("si_es_puc_base_db"));
                if (rs.getString("si_es_puc_base_db").equalsIgnoreCase("Si")) {
                    ls.setLsi_puc_base_db(true);
                } else {
                    ls.setLsi_puc_base_db(false);
                }
                ls.setSi_es_puc_base_cr(rs.getString("si_es_puc_base_cr"));
                if (rs.getString("si_es_puc_base_cr").equalsIgnoreCase("Si")) {
                    ls.setLsi_puc_base_cr(true);
                } else {
                    ls.setLsi_puc_base_cr(false);
                }
                ls.setSi_es_control_dia(rs.getString("si_es_control_dia"));
                if (rs.getString("si_es_control_dia").equalsIgnoreCase("Si")) {
                    ls.setLsi_control_dia(true);
                } else {
                    ls.setLsi_control_dia(false);
                }
                ls.setSi_es_pago_cierre(rs.getString("si_es_pago_cierre"));
                if (rs.getString("si_es_pago_cierre").equalsIgnoreCase("Si")) {
                    ls.setLsi_pago_cierre(true);
                } else {
                    ls.setLsi_pago_cierre(false);
                }
                ls.setSi_es_sal_integral(rs.getString("si_es_sal_integral"));
                if (rs.getString("si_es_sal_integral").equalsIgnoreCase("Si")) {
                    ls.setLsi_sal_integral(true);
                } else {
                    ls.setLsi_sal_integral(false);
                }
                ls.setSi_es_sal_basico(rs.getString("si_es_sal_basico"));
                if (rs.getString("si_es_sal_basico").equalsIgnoreCase("Si")) {
                    ls.setLsi_sal_basico(true);
                } else {
                    ls.setLsi_sal_basico(false);
                }
                ls.setSi_es_interfaz(rs.getString("si_es_interfaz"));
                if (rs.getString("si_es_interfaz").equalsIgnoreCase("Si")) {
                    ls.setLsi_interfaz(true);
                } else {
                    ls.setLsi_interfaz(false);
                }
                ls.setSi_es_a_volante(rs.getString("si_es_a_volante"));
                if (rs.getString("si_es_a_volante").equalsIgnoreCase("Si")) {
                    ls.setLsi_a_volante(true);
                } else {
                    ls.setLsi_a_volante(false);
                }
                ls.setSi_es_presenta_can(rs.getString("si_es_presenta_can"));
                if (rs.getString("si_es_presenta_can").equalsIgnoreCase("Si")) {
                    ls.setLsi_presenta_can(true);
                } else {
                    ls.setLsi_presenta_can(false);
                }
                ls.setSi_es_sal_variable(rs.getString("si_es_sal_variable"));
                if (rs.getString("si_es_sal_variable").equalsIgnoreCase("Si")) {
                    ls.setLsi_sal_variable(true);
                } else {
                    ls.setLsi_sal_variable(false);
                }
                ls.setSi_es_cesantia(rs.getString("si_es_cesantia"));
                if (rs.getString("si_es_cesantia").equalsIgnoreCase("Si")) {
                    ls.setLsi_cesantia(true);
                } else {
                    ls.setLsi_cesantia(false);
                }
                ls.setSi_es_prima(rs.getString("si_es_prima"));
                if (rs.getString("si_es_prima").equalsIgnoreCase("Si")) {
                    ls.setLsi_prima(true);
                } else {
                    ls.setLsi_prima(false);
                }
                ls.setSi_es_vacacion(rs.getString("si_es_vacacion"));
                if (rs.getString("si_es_vacacion").equalsIgnoreCase("Si")) {
                    ls.setLsi_vacacion(true);
                } else {
                    ls.setLsi_vacacion(false);
                }
                ls.setSi_es_auxilio_tra(rs.getString("si_es_auxilio_tra"));
                if (rs.getString("si_es_auxilio_tra").equalsIgnoreCase("Si")) {
                    ls.setLsi_auxilio_tra(true);
                } else {
                    ls.setLsi_auxilio_tra(false);
                }
                ls.setSi_es_aporte_pos(rs.getString("si_es_aporte_pos"));
                if (rs.getString("si_es_aporte_pos").equalsIgnoreCase("Si")) {
                    ls.setLsi_aporte_pos(true);
                } else {
                    ls.setLsi_aporte_pos(false);
                }
                ls.setSi_es_aporte_fdp(rs.getString("si_es_aporte_fdp"));
                if (rs.getString("si_es_aporte_fdp").equalsIgnoreCase("Si")) {
                    ls.setLsi_aporte_fdp(true);
                } else {
                    ls.setLsi_aporte_fdp(false);
                }
                ls.setSi_es_aporte_arl(rs.getString("si_es_aporte_arl"));
                if (rs.getString("si_es_aporte_arl").equalsIgnoreCase("Si")) {
                    ls.setLsi_aporte_arl(true);
                } else {
                    ls.setLsi_aporte_arl(false);
                }
                ls.setSi_es_aporte_para(rs.getString("si_es_aporte_para"));
                if (rs.getString("si_es_aporte_para").equalsIgnoreCase("Si")) {
                    ls.setLsi_aporte_para(true);
                } else {
                    ls.setLsi_aporte_para(false);
                }
                ls.setN_apl_grupo(rs.getInt("n_apl_grupo"));
                ls.setN_apl_conce_tipo(rs.getInt("n_apl_conce_tipo"));
                ls.setN_apl_conce_liq(rs.getInt("n_apl_conce_liq"));
                ls.setN_apl_perio_pago(rs.getInt("n_apl_perio_pago"));
                ls.setN_apl_cta_base_db(rs.getInt("n_apl_cta_base_db"));
                ls.setN_apl_cta_base_cr(rs.getInt("n_apl_cta_base_cr"));
                ls.setN_apl_cta_sufijo_db(rs.getInt("n_apl_cta_sufijo_db"));
                ls.setN_apl_cta_sufijo_cr(rs.getInt("n_apl_cta_sufijo_cr"));
                ls.setN_apl_uni_medida(rs.getInt("n_apl_uni_medida"));

                ls.setlCtaBaseDB(false);
                ls.setlCtaBaseCR(false);
                
                list.add(ls);
            }
        } catch (SQLException e) {
            msgEx = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RS_NOM_CONCEPTO_PAGO", msgEx);
            FacesContext.getCurrentInstance().addMessage(null, message); 
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        } finally {
            con.close();
        }
        return list;

        
    }

    @Override
    public String create(ConceptoPago conceptoPago) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(ConceptoPago conceptoPago) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
