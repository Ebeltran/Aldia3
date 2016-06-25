/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Contabilidad;

/**
 *
 * @author Eduar
 */
public interface ContabilidadDao {
    
    public List<Contabilidad> findAll();
    public String create(Contabilidad contabilidad);
    public String update(Contabilidad contabilidad);
    
    public Contabilidad findByCuentaConta(String string);
    
    public List<Contabilidad> findByContabilidad(String query);
}
