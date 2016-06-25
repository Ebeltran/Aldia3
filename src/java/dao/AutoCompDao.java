/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AutoComp;

/**
 *
 * @author ebeltran
 */
public interface AutoCompDao {
 
    public List<AutoComp> findAutoCompCiudad(String query);
    public List<AutoComp> findAutoCompCiudadNace(String query);
    public List<AutoComp> findAutoCompCargo(String query);
    public List<AutoComp> findAutoCompCentroCosto(String query);
    
    public AutoComp findByCiudad(String string);
    public AutoComp findByCiudadNace(String string);
    public AutoComp findByCentroCosto(String string);
    public AutoComp findByCargo(String string);
    
}
