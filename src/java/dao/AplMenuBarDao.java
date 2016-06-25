/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AplMenuBar;


/**
 *
 * @author ebeltran
 */
public interface AplMenuBarDao {
    
    public String menuBars();
    public boolean verificaSubMenu(AplMenuBar aplMenuBar);
    public List<AplMenuBar> buscaPorMenu(AplMenuBar aplMenuBar);
    public AplMenuBar buscaPorId (int id_Menu);
    public List<AplMenuBar> listaTodos();
    public List<AplMenuBar> listaTodosTipoMenu();
    public List<AplMenuBar> listaMenuPermiso();
    
}
