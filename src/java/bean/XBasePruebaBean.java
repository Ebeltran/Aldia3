/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.XBaseDao;
import dao.XBaseDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.XBase;

/**
 *
 * @author Eduar
 */
@ManagedBean
@ViewScoped
public class XBasePruebaBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private List<XBase> lista;  
    private XBase nit = new XBase(); 

    public List<XBase> getLista() {
        
        XBaseDao xBaseDao = new XBaseDaoImpl();
        this.lista = new ArrayList<>();
        this.lista = xBaseDao.findAll();
        return lista;
    }

    public XBase getNit() {
        return nit;
    }

    public void setLista(List<XBase> lista) {
        this.lista = lista;
    }

    public void setNit(XBase nit) {
        this.nit = nit;
    }
    
}
