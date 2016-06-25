/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AplMenuBarDao;
import dao.AplMenuBarDaoImpl;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.AplMenuBar;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import util.MyUtil;

/**
 *
 * @author Eduar
 */
@ManagedBean
@ViewScoped
public class AplMenuBarBean1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private MenuModel modelo;

    long tiempoIni1;
    long tiempoIni2;
    long tiempoFin1;
    long tiempoFin2;
    long tiempoFin3;
    long tiempoFin4;
    long tiempoFin5;

    double diferencia;

    public AplMenuBarBean1() {

        modelo = new DefaultMenuModel();

        AplMenuBarDao aplMenuBarDao = new AplMenuBarDaoImpl();
        List<AplMenuBar> tds = aplMenuBarDao.listaMenuPermiso();

        // Recorre cada una de las filas del resultado y crea los objetos correspondientes
        int i = 0;
        AplMenuBar td, td1, td2, td3, td4, td5, td6, td7, td8;

        tiempoIni1 = System.nanoTime();

        // Nivel 0
        while (i < tds.size()) {
            td = tds.get(i);
            // Create submenus required
            if (td.getTipo_Menu().contains("SubMenu") && td.getTab_Menus_Id() == 0) {
                DefaultSubMenu subMenu0 = new DefaultSubMenu(td.getNombre_Menu() + " sm0 Vr i: " + i);
                i++;
                if (i >= tds.size()) {
                    this.modelo.addElement(subMenu0);
                    break;
                }
                td1 = tds.get(i);
                // Nivel 1
                while (true) {
                    if (td1.getTab_Menus_Id() != td.getId_Menu()) {
                        i--;
                        break;
                    }
                    if (td1.getTipo_Menu().contains("SubMenu")) {
                        DefaultSubMenu subMenu1 = new DefaultSubMenu(td1.getNombre_Menu() + " sm1 Vr i: " + i);
                        i++;
                        if (i >= tds.size()) {
                            subMenu0.addElement(subMenu1);
                            break;
                        }
                        td2 = tds.get(i);

                        // Nivel 2
                        while (true) {
                            if (td2.getTab_Menus_Id() != td1.getId_Menu()) {
                                i--;
                                break;
                            }
                            if (td2.getTipo_Menu().contains("SubMenu")) {
                                DefaultSubMenu subMenu2 = new DefaultSubMenu(td2.getNombre_Menu() + " sm2 Vr i: " + i);
                                i++;
                                if (i >= tds.size()) {
                                    subMenu1.addElement(subMenu2);
                                    break;
                                }
                                td3 = tds.get(i);

                                // Nivel 3
                                while (true) {
                                    if (td3.getTab_Menus_Id() != td2.getId_Menu()) {
                                        i--;
                                        break;
                                    }
                                    if (td3.getTipo_Menu().contains("SubMenu")) {
                                        DefaultSubMenu subMenu3 = new DefaultSubMenu(td3.getNombre_Menu() + " sm3 Vr i: " + i);
                                        i++;
                                        if (i >= tds.size()) {
                                            subMenu2.addElement(subMenu3);
                                            break;
                                        }
                                        td4 = tds.get(i);
                                        
                                        // Nivel 4
                                        while (true) {
                                            if (td4.getTab_Menus_Id() != td3.getId_Menu()) {
                                                i--;
                                                break;
                                            }
                                            if (td4.getTipo_Menu().contains("SubMenu")) {
                                                DefaultSubMenu subMenu4 = new DefaultSubMenu(td4.getNombre_Menu() + " sm4 Vr i: " + i);
                                                i++;
                                                if (i >= tds.size()) {
                                                    subMenu3.addElement(subMenu4);
                                                    break;
                                                }
                                                td5 = tds.get(i);

                                                // Nivel 5
                                                while (true) {
                                                    if (td5.getTab_Menus_Id() != td4.getId_Menu()) {
                                                        i--;
                                                        break;
                                                    }
                                                    if (td5.getTipo_Menu().contains("SubMenu")) {
                                                        DefaultSubMenu subMenu5 = new DefaultSubMenu(td5.getNombre_Menu() + " sm5 Vr i: " + i);
                                                        i++;
                                                        if (i >= tds.size()) {
                                                            subMenu4.addElement(subMenu5);
                                                            break;
                                                        }
                                                        td6 = tds.get(i);
                                                        
                                                        // Nivel 6
                                                        while (true) {
                                                            if (td6.getTab_Menus_Id() != td5.getId_Menu()) {
                                                                i--;
                                                                break;
                                                            }
                                                            if (td6.getTipo_Menu().contains("SubMenu")) {
                                                                DefaultSubMenu subMenu6 = new DefaultSubMenu(td6.getNombre_Menu() + " sm6 Vr i: " + i);
                                                                i++;
                                                                if (i >= tds.size()) {
                                                                    subMenu5.addElement(subMenu6);
                                                                    break;
                                                                }
                                                                td7 = tds.get(i);
                                                                
                                                                // Nivel 7
                                                                while (true) {
                                                                    if (td7.getTab_Menus_Id() != td6.getId_Menu()) {
                                                                        i--;
                                                                        break;
                                                                    }
                                                                    if (td7.getTab_Menus_Id() != td6.getId_Menu()) {
                                                                        DefaultSubMenu subMenu7 = new DefaultSubMenu(td7.getNombre_Menu() + " sm6 Vr i: " + i);
                                                                        i++;
                                                                        if (i >= tds.size()) {
                                                                            subMenu6.addElement(subMenu7);
                                                                            break;
                                                                        }
                                                                    } /* if Nivel 7 */
                                                                    if (td7.getTipo_Menu().contains("MenuItem")) {
                                                                        DefaultMenuItem item7 = new DefaultMenuItem(td7.getNombre_Menu() + " item 7 vr i: " + i);
                                                                        item7.setUrl(new StringBuilder().append(MyUtil.basePath()).append(td7.getRuta_Jsp()).toString());
                                                                        item7.setIcon(td7.getRuta_Icon());
                                                                        item7.setTitle(td7.getDescripcion());
                                                                        subMenu6.addElement(item7);
                                                                    }
                                                                    i++;
                                                                    if (i >= tds.size()) {
                                                                        break;
                                                                    }
                                                                    td7 = tds.get(i);
                                                                } /* EOF Nivel 7 */
                                                                subMenu6.addElement(subMenu5);
                                                                i++;
                                                                if (i >= tds.size()) {
                                                                    break; 
                                                                }
                                                                td6 = tds.get(i);
                                                                continue;
                                                            } /* if Nivel 6 */
                                                            if (td6.getTipo_Menu().contains("MenuItem")) {
                                                                DefaultMenuItem item6 = new DefaultMenuItem(td6.getNombre_Menu() + " item 6 vr i: " + i);
                                                                item6.setUrl(new StringBuilder().append(MyUtil.basePath()).append(td6.getRuta_Jsp()).toString());
                                                                item6.setIcon(td6.getRuta_Icon());
                                                                item6.setTitle(td6.getDescripcion());
                                                                subMenu5.addElement(item6);
                                                            }
                                                            i++;
                                                            if (i >= tds.size()) {
                                                                break;
                                                            }
                                                            td6 = tds.get(i);
                                                        } /* EOF Nivel 6 */
                                                        subMenu0.addElement(subMenu5);
                                                        i++;
                                                        if (i >= tds.size()) {
                                                           break; 
                                                        }
                                                        td5 = tds.get(i);
                                                        continue;
                                                    } /* if Nivel 5 */
                                                    if (td5.getTipo_Menu().contains("MenuItem")) {
                                                        DefaultMenuItem item5 = new DefaultMenuItem(td5.getNombre_Menu() + " item 5 vr i: " + i);
                                                        item5.setUrl(new StringBuilder().append(MyUtil.basePath()).append(td5.getRuta_Jsp()).toString());
                                                        item5.setIcon(td5.getRuta_Icon());
                                                        item5.setTitle(td5.getDescripcion());
                                                        subMenu4.addElement(item5);
                                                    }
                                                    i++;
                                                    if (i >= tds.size()) {
                                                        break;
                                                    }
                                                    td5 = tds.get(i);
                                                } /* EOF Nivel 5 */
                                                subMenu0.addElement(subMenu4);
                                                i++;
                                                if (i >= tds.size()) {
                                                    break;
                                                }
                                                td4 = tds.get(i);
                                                continue;
                                            } /* if Nivel 4 */
                                            if (td4.getTipo_Menu().contains("MenuItem")) {
                                                DefaultMenuItem item4 = new DefaultMenuItem(td4.getNombre_Menu() + " item 4 vr i: " + i);
                                                item4.setUrl(new StringBuilder().append(MyUtil.basePath()).append(td4.getRuta_Jsp()).toString());
                                                item4.setIcon(td4.getRuta_Icon());
                                                item4.setTitle(td4.getDescripcion());
                                                subMenu3.addElement(item4);
                                            }
                                            i++;
                                            if (i >= tds.size()) {
                                                break;
                                            }
                                            td4 = tds.get(i);
                                        } /* EOF Nivel 4 */
                                        subMenu0.addElement(subMenu3);
                                        i++;
                                        if (i >= tds.size()) {
                                            break;
                                        }
                                        td3 = tds.get(i);
                                        continue;
                                    } /* if Nivel 3 */
                                    if (td3.getTipo_Menu().contains("MenuItem")) {
                                        DefaultMenuItem item3 = new DefaultMenuItem(td3.getNombre_Menu() + " item 3 vr i: " + i);
                                        item3.setUrl(new StringBuilder().append(MyUtil.basePath()).append(td3.getRuta_Jsp()).toString());
                                        item3.setIcon(td3.getRuta_Icon());
                                        item3.setTitle(td3.getDescripcion());
                                        subMenu2.addElement(item3);
                                    }
                                    i++;
                                    if (i >= tds.size()) {
                                        break;
                                    }
                                    td3 = tds.get(i);
                                } /* EOF Nivel 3 */
                                subMenu0.addElement(subMenu2);
                                i++;
                                if (i >= tds.size()) {
                                    break;
                                }
                                td2 = tds.get(i);
                                continue;
                            } /* if Nivel 2 */
                            if (td2.getTipo_Menu().contains("MenuItem")) {
                                DefaultMenuItem item2 = new DefaultMenuItem(td2.getNombre_Menu() + " item 2 vr i: " + i);
                                item2.setUrl(new StringBuilder().append(MyUtil.basePath()).append(td2.getRuta_Jsp()).toString());
                                item2.setIcon(td2.getRuta_Icon());
                                item2.setTitle(td2.getDescripcion());
                                subMenu1.addElement(item2);
                            }
                            i++;
                            if (i >= tds.size()) {
                                break;
                            }
                            td2 = tds.get(i);
                        } /* EOF Nivel 2 */
                        subMenu0.addElement(subMenu1);
                        i++;
                        if (i >= tds.size()) {
                            break;
                        }
                        td1 = tds.get(i);
                        continue;
                    } /* if Nivel 1 */
                    if (td1.getTipo_Menu().contains("MenuItem")) {
                        DefaultMenuItem item1 = new DefaultMenuItem(td1.getNombre_Menu() + " item 1 vr i: " + i);
                        item1.setUrl(new StringBuilder().append(MyUtil.basePath()).append(td1.getRuta_Jsp()).toString());
                        item1.setIcon(td1.getRuta_Icon());
                        item1.setTitle(td1.getDescripcion());
                        subMenu0.addElement(item1);
                    }
                    i++;
                    if (i >= tds.size()) {
                        break;
                    }
                    td1 = tds.get(i);
                } /* EOF Nivel 1 */

                // Associate submenus with the menubar                              
                this.modelo.addElement(subMenu0);

            }
            /* if Nivel 0 */
            i++;
            if (i >= tds.size()) {
                break;
            }
        } /* EOF Nivel 0 */

    }

    public MenuModel getModelo() {

        tiempoFin2 = System.nanoTime();
        diferencia = (tiempoFin2 - tiempoIni1);
        System.out.println(" Tiempo en construir el Menu " + diferencia);

        return modelo;
    }

    public void setModelo(MenuModel modelo) {
        this.modelo = modelo;
    }

}
