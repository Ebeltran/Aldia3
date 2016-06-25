/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.NitDao;
import dao.NitDaoImpl;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Nit;



/**
 *
 * @author ebeltran
 */
@FacesConverter("nitConverter")
public class NitConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        NitDao nitDao = new NitDaoImpl();
        Nit nit = nitDao.findByNit(string);
        
        return nit;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
        Nit nit = new Nit();
        nit = (Nit) o;
        return nit.getIdenti();

    }
    
}