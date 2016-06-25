/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AutoCompDao;
import dao.AutoCompDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.AutoComp;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class AutoCoCiudadBean implements Serializable {    

    private static final long serialVersionUID = 1L;
    private AutoComp ciudad;
    private List<AutoComp> lsCiudads  = new ArrayList<AutoComp>();
    
    public AutoCoCiudadBean() {
    }

    /**
     * Para generar Autocompletar Ciudad
     * @param query
     * @return 
     */
    public List<String> completeCiudad(String query) {

        AutoCompDao aplDefineDao = new AutoCompDaoImpl();
        query = query.toUpperCase();
        List<AutoComp> quieries = aplDefineDao.findAutoCompCiudad(query);
        List<String> ls = new ArrayList<>();
        for (AutoComp m :quieries) {
        	ls.add(m.getCiudad_depto() + " ID => " + m.getN_apl_ciudad());
        }
        
        return ls;
    }   

    public AutoComp getCiudad() {
        return ciudad;
    }

    public void setCiudad(AutoComp ciudad) {
        this.ciudad = ciudad;
    }

    public List<AutoComp> getLsCiudads() {
        return lsCiudads;
    }

    public void setLsCiudads(List<AutoComp> lsCiudads) {
        this.lsCiudads = lsCiudads;
    }

}
