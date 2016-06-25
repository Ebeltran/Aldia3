/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AplMenuPermiso;

/**
 *
 * @author ebeltran
 */
public interface AplMenuPermisoDao {
    
    public List<AplMenuPermiso> findAll();
    public List<AplMenuPermiso> findOper();
    public List<AplMenuPermiso> findOperOne(String newLogin);
    public boolean update (List<AplMenuPermiso> aplMenuOpe);
    public boolean updatePer (List<AplMenuPermiso> aplMenuOpe);
    
}
