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
@FacesConverter("ciudadConverter")
public class CiudadConverter implements Converter {

    AutoCompDao autoCompDao = new AutoCompDaoImpl();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null || value.equals("")) {
            return null;
        }
        try {
            return autoCompDao.findByCiudad(value);
        } catch (Exception e) {
            throw new ConverterException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Conversion", "No es una ciudad valida."));
        }

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        AutoComp autoComp = new AutoComp();
        autoComp = (AutoComp) object;
        return String.valueOf(autoComp.getNo_apl_ciudad());
    }

}
