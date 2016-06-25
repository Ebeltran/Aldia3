/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AplDefineDao;
import dao.AplDefineDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import model.AplDefine;
import model.EmpS;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@javax.faces.bean.ViewScoped
public class ContratosBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private EmpS empS = new EmpS();
    private List<EmpS> empSs = new ArrayList<EmpS>();
    private ArrayList<SelectItem> listSelect;
            
    public ContratosBean() {
        this.empS.setN_con_tipo(0);
        this.empS.setN_apl_con_trabajo(0);
    }

    public ArrayList<SelectItem> getDuracionContrato() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<SelectItem>();
        List<AplDefine> lista = aplDefineDao.findContratoTipo();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_con_tipo(), ls.getNom_con_tipo()));
        }
        return listSelect;
    }

    public List<SelectItem> getContratoTrabajo() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<SelectItem>();
        List<AplDefine> lista = aplDefineDao.findContratoTrabajo(empS.getN_con_tipo());
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_apl_con_trabajo(), ls.getNom_con_trabajo()));
        }
        return listSelect;
    }

    public void onCambioContratoTrabajo(){
        if (empS.getN_con_tipo() == 0) {
//            if (empS.getN_con_duracion() == 0) {
//                AplDefineDao aplDefineDao = new AplDefineDaoImpl();
//                this.listSelect = new ArrayList<SelectItem>();
//                List<AplDefine> lista = aplDefineDao.findContratoDuracion();
//                for (AplDefine ls : lista) {
//                    this.listSelect.add(new SelectItem(ls.getN_con_duracion(), ls.getNom_con_duracion()));
//                }
//            } else {
//                AplDefineDao aplDefineDao = new AplDefineDaoImpl();
//                this.listSelect = new ArrayList<SelectItem>();
//                List<AplDefine> lista = aplDefineDao.findContratoTipo(this.empS.getN_con_duracion());
//                for (AplDefine ls : lista) {
//                    this.listSelect.add(new SelectItem(ls.getN_apl_con_trabajo(), ls.getNom_con_trabajo()));
//                }
//            }
        }
    }
    
    public List<SelectItem> onCambioContratoTrabajo1() {
        if (empS.getN_con_tipo() == 0) {
            AplDefineDao aplDefineDao = new AplDefineDaoImpl();
            this.listSelect = new ArrayList<SelectItem>();
            List<AplDefine> lista = aplDefineDao.findContratoTipo();
            for (AplDefine ls : lista) {
                this.listSelect.add(new SelectItem(ls.getN_con_tipo(), ls.getNom_con_tipo()));
            }
        } else {
            AplDefineDao aplDefineDao = new AplDefineDaoImpl();
            this.listSelect = new ArrayList<SelectItem>();
            List<AplDefine> lista = aplDefineDao.findContratoTrabajo(this.empS.getN_con_tipo());
            for (AplDefine ls : lista) {
                this.listSelect.add(new SelectItem(ls.getN_apl_con_trabajo(), ls.getNom_con_trabajo()));
            }
        }
        return listSelect;
    }
    
    public List<SelectItem> onContratoTrabajo() {
        if (empS.getN_con_tipo() != 0) {
            AplDefineDao aplDefineDao = new AplDefineDaoImpl();
            this.listSelect = new ArrayList<SelectItem>();
            List<AplDefine> lista = aplDefineDao.findContratoTrabajoSelect(empS.getN_con_tipo());
            for (AplDefine ls : lista) {
                if (ls.isLsi_vence()) {
                    this.empS.setLfechafin(true);
                } else {
                    this.empS.setFecha_final(aplDefineDao.findByFechaHasta());
                    this.empS.setLfechafin(false);
                }
                if (ls.isLsi_aux_tran()) {
                    this.empS.setLauxtran(true);
                } else {
                    this.empS.setLauxtran(false);
                }
                if (ls.isLsi_salario_integral()) {
                    this.empS.setLintegral(true);
                } else {
                    this.empS.setLintegral(false);
                }
                if (ls.isLsi_pide_labor()) {
                    this.empS.setLlabor(true);
                } else {
                    this.empS.setLlabor(false);
                }
                if (ls.isLsi_pago_eps()) {
                    this.empS.setLsieps(true);
                } else {
                    this.empS.setLsieps(false);
                }
                if (ls.isLsi_pago_fdp()) {
                    this.empS.setLsifdp(true);
                } else {
                    this.empS.setLsifdp(false);
                }
                if (ls.isLsi_pago_fdc()) {
                    this.empS.setLsifdc(true);
                } else {
                    this.empS.setLsifdc(false);
                }
                if (ls.isLsi_pago_arl()) {
                    this.empS.setLsiarl(true);
                } else {
                    this.empS.setLsiarl(false);
                }
                if (ls.isLsi_pago_sena()) {
                    this.empS.setLsisena(true);
                } else {
                    this.empS.setLsisena(false);
                }
                if (ls.isLsi_pago_icbf()) {
                    this.empS.setLsiicbf(true);
                } else {
                    this.empS.setLsiicbf(false);
                }
                if (ls.isLsi_pago_ccf()) {
                    this.empS.setLsiccf(true);
                } else {
                    this.empS.setLsiccf(false);
                }

            }
        }
        return listSelect;
    } 
    
    public EmpS getEmpS() {
        return empS;
    }

    public void setEmpS(EmpS empS) {
        this.empS = empS;
    }

    public List<EmpS> getEmpSs() {
        return empSs;
    }

    public void setEmpSs(List<EmpS> empSs) {
        this.empSs = empSs;
    }

    
}
