/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Nit;

/**
 *
 * @author ebeltran
 */
public interface NitDao {
    
    public Nit findByNit(String query);
    
    public List<Nit> findAll();
    public boolean create(Nit nit);
    public String update(Nit nit);
    public List<Nit> findAutoCompRazonSocial(String query);
    
}
