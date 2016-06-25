/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AplOperador;
/**
 *
 * @author ebeltran
 */
public interface AplOperadorDao {

    public AplOperador findByAplOperador(AplOperador aplOperador);
    public List<AplOperador> findAll();
    public boolean create(AplOperador aplOperador);
    public String update(AplOperador aplOperador);
    public boolean delete(AplOperador aplOperador);
    public String cambioClave(AplOperador aplOperador);
    public String resetClave(AplOperador aplOperador);
    
}
