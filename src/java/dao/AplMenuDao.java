/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AplMenu;

/**
 *
 * @author ebeltran
 */
public interface AplMenuDao {

    public AplMenu findByAplMenu(AplMenu aplMenu);
    public List<AplMenu> findAll();
    public boolean create(AplMenu aplMenu);
    public String update(AplMenu aplMenu);
    public String desActivate(AplMenu aplMenu);
    
}
