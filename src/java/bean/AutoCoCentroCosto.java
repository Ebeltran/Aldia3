/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EmpSDao;
import dao.EmpSDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.EmpS;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class AutoCoCentroCosto implements Serializable {

    private static final long serialVersionUID = 1L;
    private EmpS aplDefine;
    private List<EmpS> lsEmpSs = new ArrayList<EmpS>();
    
    public AutoCoCentroCosto() {
    }

    /**
     * Para generar Autocompletar para Centro Costo
     * @param query
     * @return 
     */
    public List<String> completeCCosto(String query) {

        EmpSDao aplDefineDao = new EmpSDaoImpl();
        query = query.toUpperCase();
        List<EmpS> quieries = aplDefineDao.findAutoCompCentroCosto(query);
        List<String> ls = new ArrayList<>();
        for (EmpS m :quieries) {
            if (m.getN_cen_costo() != 0) {
                ls.add(m.getNom_cen_costo() + " Depende > " + m.getNom_cen_costo_padre() + " ID => " + m.getN_cen_costo());
            }
        }
        
        return ls;
    }   

    public EmpS getEmpS() {
        return aplDefine;
    }

    public void setEmpS(EmpS aplDefine) {
        this.aplDefine = aplDefine;
    }

    public List<EmpS> getLsEmpSs() {
        return lsEmpSs;
    }

    public void setLsEmpSs(List<EmpS> lsEmpSs) {
        this.lsEmpSs = lsEmpSs;
    }
}
