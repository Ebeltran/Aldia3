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
public class AutoCoCargoBean implements Serializable {   

    private static final long serialVersionUID = 1L;
    private EmpS cargo;
    private List<EmpS> lsEmpSs = new ArrayList<EmpS>();

    /**
     * Para generar Autocompletar para Cargo
     * @param query
     * @return 
     */
    public List<String> completeCargo(String query) {

        EmpSDao empSDao = new EmpSDaoImpl();
        query = query.toUpperCase();
        
        List<EmpS> quieries = empSDao.findAutoCompCargo(query);
        List<String> ls = new ArrayList<>();
        for (EmpS m :quieries) {
        	ls.add(m.getNom_cargo() + " Jefe > " + m.getNom_cargo_jefe() + " ID => " + m.getN_cargo());
        }
        
        return ls;
    }   

    public EmpS getCargo() {
        return cargo;
    }

    public void setCargo(EmpS cargo) {
        this.cargo = cargo;
    }

    public List<EmpS> getLsEmpSs() {
        return lsEmpSs;
    }

    public void setLsEmpSs(List<EmpS> lsEmpSs) {
        this.lsEmpSs = lsEmpSs;
    }
}
