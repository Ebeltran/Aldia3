/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.CentroCosto;

/**
 *
 * @author ebeltran
 */
public interface CentroCostoDao {
    
    public CentroCosto findByAplOperador(CentroCosto centroCosto);
    
    
    public boolean create(CentroCosto centroCosto);
    public String update(CentroCosto centroCosto);
    public String findByEmpS(CentroCosto centroCosto);
    public List<CentroCosto> findAll();
    public List<CentroCosto> findAutoCompCCosto(String query);
    
    public CentroCosto findByCentroCosto(String string);
    
}
