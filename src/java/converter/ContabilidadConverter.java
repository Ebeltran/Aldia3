/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.ContabilidadDao;
import dao.ContabilidadDaoImpl;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Contabilidad;

/**
 *
 * @author Eduar
 */
@FacesConverter("contabilidadConverter")
public class ContabilidadConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        ContabilidadDao contabilidadDao = new ContabilidadDaoImpl();
        Contabilidad conta = contabilidadDao.findByCuentaConta(string);

        return conta;
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Contabilidad conta = new Contabilidad();
        conta = (Contabilidad) o;
        return String.valueOf(conta.getId());
        
    }
    
}
