/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.NitDao;
import dao.NitDaoImpl;
import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import model.Nit;


/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class NitAutoComBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Nit nit;
    private List<Nit> Nits  = new ArrayList<Nit>();
    private String msgEx;
    private FacesMessage message;
        
//    /**
//     * Creates a new instance of nitBean
//     */
//    public nitBean() {
//    
//    }

    public List<Nit> completeNit(String query) {

        NitDao nitDao = new NitDaoImpl();
        List<Nit> quieries = nitDao.findAutoCompRazonSocial(query);

        return quieries;
    }
        
    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nits Seleccionados", event.getObject().toString()));
    }

    public void trasferirNit() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        String aaa = this.nit.getIdenti_con();
        
//        nitResultadoBean nrb = context.getApplication().evaluateExpressionGet(context, "#{nitResultadoBean}", nitResultadoBean.class);
//        nrb.setLtrue(true);
//        nrb.setNit_con(this.nit.getIdenti_con());
//        nrb.setRaz_Soc(this.nit.getRazon_social());
//        String ruta = "http://localhost:8080" + MyUtil.baseLogin() + "app/master/consultaNits.xhtml";
//        context.getExternalContext().redirect(ruta);
//        context.getExternalContext().redirect(MyUtil.baseLogin() + "app/master/consultaNits.xhtml");
    }

    public Nit getNit() {
        return nit;
    }

    public void setNit(Nit nit) {
        this.nit = nit;
    }

    public List<Nit> getNits() {
        return Nits;
    }

    public void setNits(List<Nit> Nits) {
        this.Nits = Nits;
    }

}