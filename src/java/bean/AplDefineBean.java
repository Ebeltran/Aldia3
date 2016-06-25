/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AplDefineDao;
import dao.AplDefineDaoImpl;
import dao.EmpSDao;
import dao.EmpSDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import model.AplDefine;
import model.EmpS;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@SessionScoped
public class AplDefineBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<SelectItem> listSelect;

    String msgEx = null;
    String msg = null;
    FacesMessage message;
    int i;

    public List<SelectItem> getClaseSocidad() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findClaseSociedad();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getN_nit_cla_sociedad(), ls.getNom_nit_cla_sociedad()));
        }
        return listSelect;
    }

    public List<SelectItem> getPagoForma() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findPagoForma();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getN_pago_forma(), ls.getNom_pago_forma()));
        }
        return listSelect;
    }
    
    public List<SelectItem > getCotizaTipo() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findCotizaTipo();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getN_cotiza_tipo(), ls.getNom_cotiza_tipo()));
        }
        return listSelect;
    }
    
    public List<SelectItem > getCotizaSubtipo() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findCotizaSubtipo();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getN_cotiza_subtipo(), ls.getNom_cotiza_subtipo()));
        }
        return listSelect;
    }
    
//    public List<SelectItem> getContratoDuracion() throws IOException {
//        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
//        this.listSelect = new ArrayList<SelectItem>();
//        List<AplDefine> lista = aplDefineDao.findContratoDuracion();
//        for (AplDefine ls : lista) {
//            this.listSelect.add(new SelectItem(ls.getN_con_duracion(), ls.getNom_con_duracion()));
//        }
//        return listSelect;
//    }
    
    public List<SelectItem> getBancoCompensa()  {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findBancoCompensa();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getIdenti_banco(), ls.getNom_ban_compensa()));
        }
        return listSelect;
    }
    
    public List<SelectItem> getNombreEps()  {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findNombreEps();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getIdenti_eps(), ls.getNom_seg_eps()));
        }
        return listSelect;
    }
    
    public List<SelectItem> getNombreFdp()  {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findNombreFdp();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getIdenti_fdp(), ls.getNom_seg_fdp()));
        }
        return listSelect;
    }
            
    public List<SelectItem> getNombreFdc()  {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findNombreFdc();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getIdenti_fdc(), ls.getNom_seg_fdc()));
        }
        return listSelect;
    }        
      
    public List<SelectItem> getBancoCuentaTipo()  {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findBancoCuentaTipo();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getN_ban_cuenta_tipo(), ls.getNom_ban_cuenta_tipo()));
        }
        return listSelect;
    }

    public List<SelectItem> getTipoConstribuyente() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findTipContribuyente();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_nit_tip_contribuyente(), ls.getNom_nit_tip_contribuyente()));
        }
        return listSelect;
    }

    public List<SelectItem> getActividadEconomica() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findActEconomica();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_ciiu(), ls.getDescripcion()));
        }
        return listSelect;
    }

    public List<SelectItem> getDignidad() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findDignidad();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_nit_digni(), ls.getNom_nit_digni()));
        }
        return listSelect;
    }

    public List<SelectItem> getTipoIdentidad() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findTipoIdentidad();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_nit_tip_identidad(), ls.getNom_nit_tip_identidad()));
        }
        return listSelect;
    }

    public List<SelectItem> getGrupo() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findGrupo();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getNom_nit_grupo(), ls.getNom_nit_grupo()));
        }
        return listSelect;
    }

    public List<SelectItem> getCabeza() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findCabeza();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_apl_cabeza_familia(), ls.getNom_apl_cabeza()));
        }
        return listSelect;
    }

    public List<SelectItem> getEstadoCivil() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findEstadoCivil();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_apl_e_civil(), ls.getNom_apl_e_civil()));
        }
        return listSelect;
    }

    public List<SelectItem> getMotivoRetiro() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findMotivoRetiro();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_emp_motivo_retiro(), ls.getNom_motivo_retiro()));
        }
        return listSelect;
    }
    public List<SelectItem> getSexo() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findSexo();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_apl_sexo(), ls.getNom_apl_sexo()));
        }
        return listSelect;
    }

    public List<SelectItem> getTipoSangre() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findTipoSangre();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_apl_sangre_tipo(), ls.getNom_apl_sangre_tipo()));
        }
        return listSelect;
    }

    public boolean isPersonaNatural(int n) {
        boolean ok = false;
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findTipoIdentidad();
        for (AplDefine ls : lista) {
            if (ls.getN_nit_tip_identidad()== n
                    && !ls.getNom_nit_tip_identidad().equalsIgnoreCase("NIT")) {
                ok = true;
            }
        }
        return ok;
    }

    public boolean isPersonaJuridica(int n) {
        boolean ok = false;
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findTipoIdentidad();
        for (AplDefine ls : lista) {
            if (ls.getN_nit_tip_identidad()== n
                    && ls.getNom_nit_tip_identidad().equalsIgnoreCase("NIT")) {
                ok = true;
            }
        }
        return ok;
    }

    public boolean isTipoSangre(int n) {
        boolean ok = false;
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findTipoSangre();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_apl_sangre_tipo(), ls.getNom_apl_sangre_tipo()));
        }
        return ok;
    }

    public List<SelectItem> getEducacionClase() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findEducacionClase();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getN_emp_edu_clase(), ls.getNom_educa()));
        }
        return listSelect;
    }

    public List<SelectItem> getRepresentanteLegal() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findRepresentanteLegal();
        for (AplDefine ls : lista) {
            this.listSelect.add(new SelectItem(ls.getIdenti_firma(), ls.getNombre_firma()));
        }
        return listSelect;
    }

    public List<SelectItem> getUnidadMedida() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findClaseSociedad();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getN_apl_uni_medida(), ls.getNombre()));
        }
        return listSelect;
    }
    
    public List<SelectItem> getConceptosTipo() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findConceptosTipo();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getN_apl_conce_tipo(), ls.getNombre()));
        }
        return listSelect;
    }
    
    public List<SelectItem> getConceptoLiquidacion() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findConceptoLiquidacion();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getN_apl_conce_liq(), ls.getNombre()));
        }
        return listSelect;
    }
    
    public List<SelectItem> getPeriodoPago() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findPeriodoPago();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getN_apl_perio_pago(), ls.getNombre()));
        }
        return listSelect;
    }
    
    public List<SelectItem> getGrupoConcepto() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findGrupoConcepto();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getN_apl_grupo(), ls.getNombre()));
        }
        return listSelect;
    }
    
    public List<SelectItem> getCuentaPucSufijo() {
        AplDefineDao aplDefineDao = new AplDefineDaoImpl();
        this.listSelect = new ArrayList<>();
        List<AplDefine> lista = aplDefineDao.findCuentaPucSufijo();
        for (AplDefine ls : lista) {
           this.listSelect.add(new SelectItem(ls.getN_apl_cta_sufijo(), ls.getNombre()));
        }
        return listSelect;
    }
    
    public List<String> buscaCargo(String query) {
        EmpSDao aplDefineDao = new EmpSDaoImpl();
        this.listSelect = new ArrayList<>();
        List<EmpS> lista = aplDefineDao.findAutoCompCargo(query);
        List<String> results = new ArrayList<>();
        for (EmpS m : lista) {
           results.add(m.getNom_cargo());
        }
        return results;         
    }

    public boolean isPersona(int n) {
        boolean ok = true;
        if (n == 4) {
            ok = false;
        }
        return ok;
    }

}

