/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {

    private static final long serialVersionUID = 1286738766870628399L;
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String duracionContrato; 
    private String tipoContrato;  
    private Map<String,String> duracionContratos;
    private Map<String,String> tiposContratos;
     
    @PostConstruct
    public void init() {
        duracionContratos  = new HashMap<String, String>();
        duracionContratos.put("Termino indefinido", "Termino indefinido");
        duracionContratos.put("Termino Fijo menos a 1 año", "Termino Fijo menos a 1 año");
        duracionContratos.put("Termino Fijo mayor a 1 año", "Termino Fijo mayor a 1 año");
        duracionContratos.put("Contrato de Aprendisaje", "Contrato de Aprendisaje");
         
        Map<String,String> map = new HashMap<String, String>();
        map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        data.put("USA", map);
         
        map = new HashMap<String, String>();
        map.put("Berlin", "Berlin");
        map.put("Munich", "Munich");
        map.put("Frankfurt", "Frankfurt");
        data.put("Germany", map);
         
        map = new HashMap<String, String>();
        map.put("Sao Paolo", "Sao Paolo");
        map.put("Rio de Janerio", "Rio de Janerio");
        map.put("Salvador", "Salvador");
        data.put("Brazil", map);
    }
 
    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public String getDuracionContrato() {
        return duracionContrato;
    }

    public void setDuracionContrato(String duracionContrato) {
        this.duracionContrato = duracionContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Map<String, String> getDuracionContratos() {
        return duracionContratos;
    }

    public void setDuracionContratos(Map<String, String> duracionContratos) {
        this.duracionContratos = duracionContratos;
    }

    public Map<String, String> getTiposContratos() {
        return tiposContratos;
    }

    public void setTiposContratos(Map<String, String> tiposContratos) {
        this.tiposContratos = tiposContratos;
    }
     
    public void displayLocation() {
        FacesMessage msg;
        if(tipoContrato != null && duracionContrato != null)
            msg = new FacesMessage("Selecionado", tipoContrato + " de " + duracionContrato);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No valid", "tipoContrato no se ha seleccionado."); 
             
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
}
