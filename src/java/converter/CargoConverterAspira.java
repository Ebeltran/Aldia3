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
@FacesConverter("cargoConverterAspira")
public class CargoConverterAspira implements Converter {
    
        @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        EmpSDao empSDao = new EmpSDaoImpl();
        EmpS empS = empSDao.findByCargo(string);

        return empS;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        EmpS empS = new EmpS();
        empS = (EmpS) o;
        return String.valueOf(empS.getN_cargo_aspira());

    }

}
