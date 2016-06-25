/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AplMenuBarDao;
import dao.AplMenuBarDaoImpl;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.AplMenuBar;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import util.MyUtil;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@SessionScoped
public class AplMenuBarBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private final MenuModel model;
    private final AplMenuBarDao aplMenuDao = new AplMenuBarDaoImpl();

    long tiempoIni1;
    long tiempoIni2;
    
    double diferencia;
    
    public MenuModel getModel() {
        
        String login = new StringBuilder().append(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login")).toString();
        
        Calendar ahora2 = Calendar.getInstance();
        tiempoIni2 = ahora2.getTimeInMillis();
        diferencia = (tiempoIni2 - tiempoIni1);
        
        System.out.println("ALDIA3_LOG: " + login + " Hacer Menu (ms): " + diferencia);
        
        return model;
    }
    
    public AplMenuBarBean() {
        
        model = new DefaultMenuModel();
        
        Calendar ahora1 = Calendar.getInstance();
        tiempoIni1 = ahora1.getTimeInMillis();
        
        List <AplMenuBar> listaMenu = aplMenuDao.listaTodos();
        
        for (AplMenuBar menu : listaMenu) {
            if (menu.getAplMenuBar().getId_Menu()==0) {
                DefaultSubMenu submenu = new DefaultSubMenu();
                submenu.setLabel(menu.getNombre_Menu());
                submenu.setIcon(menu.getRuta_Icon());
                
                for (AplMenuBar m : aplMenuDao.buscaPorMenu(menu)) {
                    if (m.getTipo_Menu().contains("MenuItem")) {
                        DefaultMenuItem mi = new DefaultMenuItem();
                        mi.setValue(m.getNombre_Menu());
                        mi.setIcon(m.getRuta_Icon());
                        mi.setUrl(new StringBuilder().append(MyUtil.basePath()).append(m.getRuta_Jsp()).toString());
                        mi.setTitle(m.getDescripcion());
                        submenu.getElements().add(mi);
                    } else {
                        DefaultSubMenu sm = new DefaultSubMenu();
                        sm.setLabel(m.getDescripcion());
                        sm.setIcon(m.getRuta_Icon());
                        sm = generaSubmenu(m);
                        submenu.getElements().add(sm);                    }
                }
                model.addElement(submenu);
                
            }
        }
    }
            
    private DefaultSubMenu generaSubmenu(AplMenuBar menu) {
        
        DefaultSubMenu submenu = new DefaultSubMenu();
        submenu.setLabel(menu.getNombre_Menu());
        submenu.setIcon(menu.getRuta_Icon());
        for (AplMenuBar m: aplMenuDao.buscaPorMenu(menu)) {
//            if (!aplMenuDao.verificaSubMenu(m)) {
            if (m.getTipo_Menu().contains("MenuItem")) {    
                DefaultMenuItem mi = new DefaultMenuItem();
                    mi.setValue(m.getNombre_Menu());
                    mi.setIcon(m.getRuta_Icon());
                    mi.setUrl(new StringBuilder().append(MyUtil.basePath()).append(m.getRuta_Jsp()).toString());
                    mi.setTitle(m.getDescripcion());
                    submenu.getElements().add(mi);
            } else {
                submenu.getElements().add(generaSubmenu(m));
            }
        }

        return submenu;
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
}