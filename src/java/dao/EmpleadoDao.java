/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import model.Empleado;

/**
 *
 * @author ebeltran
 */
public interface EmpleadoDao {

    
    public List<Empleado> findAll();
    public List<Empleado> findEmleadoContratar(); 
    public Empleado nombreContrato (Empleado empleado);
    public List<Empleado> findAutoCompFuncionario(String query, String Si_es_Vigente);
    public List<Empleado> findVigentes(Date fechaHasta);
    public List<Empleado> findCumpleanos(Date fechaHasta);
    public List<Empleado> findIngresos(Date fechaDesde, Date fechaHasta);
    public List<Empleado> findRetirados(Date fechaDesde, Date fechaHasta);
    
    public List<Empleado> findSalarios(String identi, Date fechaHasta);
    public List<Empleado> findRotulo(String identi, Date fechaHasta);
    public List<Empleado> findCargos(String identi, Date fechaHasta);
    public List<Empleado> findCenTrabajo(String identi, Date fechaHasta);
    public List<Empleado> findSeguridad(String identi, Date fechaHasta);
    public List<Empleado> findFormaPago(String identi, Date fechaHasta);
    
    public String updateSalarios(Empleado empleado, int nEmpPagoClaseOld);
    public String updateRotulo(Empleado empleado);
    public String updateCargo(Empleado empleado, int nCargoOld);
    public String updateCenTrabajo(Empleado empleado, int nCenCostoOld);
    public String updateSeguridadSocial(Empleado empleado, String IdentiEpsOld, String IdentiFdpOld, String IdentiFdcOld);
    public String updateFormaPago(Empleado empleado, int nFormaPagoOld);
    
    
    public Empleado findByEmpleado(String query);
    public String  eliminaContrato(Empleado empleado);
    public String  finalContrato(Empleado empleado);
    public String  reintegraContrato(Empleado empleado);
    
}