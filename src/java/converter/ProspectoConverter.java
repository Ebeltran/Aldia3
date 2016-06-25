/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.EmpSDao;
import dao.EmpSDaoImpl;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.EmpS;

/**
 *
 * @author ebeltran
 */
@FacesConverter("prospectoConverter")
public class ProspectoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
        EmpSDao empSDao = new EmpSDaoImpl();
        EmpS empS = empSDao.findByProspecto(string);
        // Aqui deberia exportar objeto
        return empS;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
        EmpS empS = new EmpS();
        empS = (EmpS) o;
        return empS.getIdenti();
    }
    
}
