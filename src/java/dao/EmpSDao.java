/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.EmpS;

/**
 *
 * @author ebeltran
 */
public interface EmpSDao {
    
    public List<EmpS> findAll();
    public List<EmpS> findEmpSAlista(int contratar, int contratado, int rechazado);
    public boolean create(EmpS empS);
    public String update(EmpS empS);
    public String updateAlista(EmpS empS);
    public String contrataProspecto(EmpS empS);
    
    public String findByEmpS(EmpS empS);
    public boolean updateContrato(EmpS empS);
    
    public List<EmpS> findAutoCompProspecto(String query, int i);
    public List<EmpS> findAutoCompCiudad(String query);
    public List<EmpS> findAutoCompCiudadNace(String query);
    public List<EmpS> findAutoCompCargo(String query);
    public List<EmpS> findAutoCompCentroCosto(String query);
    
    public EmpS findByAlistar(String string);
    public EmpS findByProspecto(String string);
    public EmpS findByCiudad(String string);
    public EmpS findByCiudadNace(String string);
    public EmpS findByCargo(String string);
    public EmpS findByCentroCosto(String string);
    
    public String findByExamenIngreso(EmpS empS);
    public String findByAperturaBanco(EmpS empS);
    public String findByExamenEgreso(EmpS empS);
    
    
}
