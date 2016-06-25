/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.EmpleadoDao;
import dao.EmpleadoDaoImpl;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Empleado;

/**
 *
 * @author Eduar
 */
@FacesConverter("empleadoSueldoConverter")
public class EmpleadoSueldoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
        Empleado empleado = empleadoDao.findByEmpleado(string);
        // Aqui deberia exportar objeto
        return empleado;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
        Empleado empleado = new Empleado();
        empleado = (Empleado) o;
        return empleado.getIdenti();

    }
    
}    