/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.NitDao;
import dao.NitDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.AplDefine;
import model.Nit;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class AutoCompletarRazonSocial implements Serializable { 

    private static final long serialVersionUID = 1L;
    private Nit nit;
    private ArrayList<AplDefine> lsNits  = new ArrayList<AplDefine>();
    
    public AutoCompletarRazonSocial() {
        
    }

    /**
     * Para generar Autocompletar para Razon Social
     * @param query
     * @return 
     */
    public List<Nit> completeNit(String query) {

        NitDao nitDao = new NitDaoImpl();
        List<Nit> quieries = nitDao.findAutoCompRazonSocial(query);
        return quieries;
    }   

    public Nit getNit() {
        return nit;
    }

    public void setNit(Nit nit) {
        this.nit = nit;
    }

    public ArrayList<AplDefine> getLsNits() {
        return lsNits;
    }

    public void setLsNits(ArrayList<AplDefine> lsNits) {
        this.lsNits = lsNits;
    }

}
