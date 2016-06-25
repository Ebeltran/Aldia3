/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.AplParametro;

/**
 *
 * @author ebeltran
 */
public interface AplParametroDao {
    
    public void callEmpresa(AplParametro aplParametro);
    public AplParametro findByParametro(AplParametro aplParametro);
    public List<AplParametro> findAll();
    public boolean create(AplParametro aplParametro);
    public String update(AplParametro aplParametro);
    
}
