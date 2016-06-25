/**
 * 
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;

import dao.EmpSDao;
import dao.EmpSDaoImpl;
import javax.faces.bean.ManagedBean;
import model.EmpS;

/**
 * @author ebeltran
 *
 */
@ManagedBean
@ViewScoped
public class AutoCoProspectoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private EmpS empS;
    private List<EmpS> lsEmpSs = new ArrayList<>();

    /**
     * Metodo para realizar Consultar de prospectos en la tabala EMP_S 
     * que se encuentren con N_EMP_ESTADO_LABORAL_E = 1 equivalentes a 
     * CANDIDATO SELECCIONABLE
     * @param query
     * @return 
     */
    public List<String> completeProspecto(String query) {

        int i = 1; 
    	EmpSDao empSDao = new EmpSDaoImpl();
        query = query.toUpperCase();
        List<EmpS> quieries = empSDao.findAutoCompProspecto(query, i);
        List<String> ls = new ArrayList<>();
        for (EmpS m :quieries) {
        	ls.add(m.getApellidos_nombres() + " ID => " + m.getIdenti_con());
        }
        
        return ls;

    }

	public EmpS getEmpS() {
		return empS;
	}

	public void setEmpS(EmpS empS) {
		this.empS = empS;
	}

	public List<EmpS> getLsEmpSs() {
		return lsEmpSs;
	}

	public void setLsEmpSs(List<EmpS> lsEmpSs) {
		this.lsEmpSs = lsEmpSs;
	}  

}
