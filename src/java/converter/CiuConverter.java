/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.AutoCompDao;
import dao.AutoCompDaoImpl;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.AutoComp;

/**
 *
 * @author ebeltran
 */
@FacesConverter("ciuConverter")
public class CiuConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        
        if (value != null && value.trim().length() > 0) {
            try {
                AutoCompDao aCDao = new AutoCompDaoImpl();
                AutoComp aC = aCDao.findByCiudad(value);

                return aC;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "No es una ciudad valida"));
            }
        } else {
            return null;
        }
            
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        
         if(object != null) {
             AutoComp autoComp = new AutoComp();
            autoComp = (AutoComp) object;

//            return AutoComp.getNo_apl_ciudad();
            return String.valueOf(((AutoComp) object).getN_apl_ciudad());
            
        } else {
            return null;
        }
    }
}