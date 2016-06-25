/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CentroCostoDao;
import dao.CentroCostoDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.CentroCosto;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class CentroCostoBean implements Serializable{
  
    private static final long serialVersionUID = -8562210956025385095L;
    private CentroCosto centroCosto = new CentroCosto();
    private List<CentroCosto> lsCentroCosto = new ArrayList<CentroCosto>(); 
           
    String query = null;

    /**
     * Metodo para hacer reset al formulario
     */
    public void resetFormulario(){
        this.centroCosto = new CentroCosto();
    }

    public CentroCosto getCentroCosto() {
        return centroCosto;
    }

    public void setCentroCosto(CentroCosto centroCosto) {
        this.centroCosto = centroCosto;
    }

    public List<CentroCosto> getLsCentroCosto() {
        CentroCostoDao centroCostoDao = new CentroCostoDaoImpl();
        this.lsCentroCosto = new ArrayList<>();
        this.lsCentroCosto = centroCostoDao.findAll();
        return lsCentroCosto;
    }

    public List<String> buscaCentroCosto(String query) {
        CentroCostoDao centroCostoDao = new CentroCostoDaoImpl();
        this.lsCentroCosto = new ArrayList<>();
        List<CentroCosto> lista = centroCostoDao.findAutoCompCCosto(query);
        List<String> results = new ArrayList<String>();
        for (CentroCosto m : lista) {
           results.add(m.getNom_centro_costo());
        }
        return results;         
    }
    
    public void setLsCentroCosto(List<CentroCosto> lsCentroCosto) {
        this.lsCentroCosto = lsCentroCosto;
    }
    
    
}
