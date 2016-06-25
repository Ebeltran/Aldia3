/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cia;

/**
 *
 * @author ebeltran
 */
public interface CiaDao {
 
    public Cia findByAplOperador(Cia cia);
    public List<Cia> findCia();
    public List<Cia> findCiaSucAll(int i);
    
}
