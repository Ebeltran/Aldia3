/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.XBase;

/**
 *
 * @author Eduar
 */
public interface  XBaseDao {

    public List<XBase> findAll();
    public XBase findByEmpleado(String query);
    
}
