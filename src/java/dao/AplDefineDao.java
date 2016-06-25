/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import model.AplDefine;

/**
 *
 * @author ebeltran
 */
public interface AplDefineDao {
    
    public List<AplDefine> findActEconomica();
    public List<AplDefine> findTipoIdentidad();
    public List<AplDefine> findClaseSociedad();
    public List<AplDefine> findDignidad();
    public List<AplDefine> findGrupo();
    public List<AplDefine> findTipContribuyente();
    public List<AplDefine> findEstadoCivil();
    public List<AplDefine> findMotivoRetiro();
    public List<AplDefine> findSexo();
    public List<AplDefine> findTipoSangre();
    public List<AplDefine> findEducacionClase();
    public List<AplDefine> findCabeza();
    public List<AplDefine> findContratoTipo();
    public List<AplDefine> findContratoTrabajo(int i);
    public List<AplDefine> findContratoTrabajoSelect(int i);
    public List<AplDefine> findPagoForma();
    public List<AplDefine> findBancoCompensa();
    public List<AplDefine> findBancoCuentaTipo();
    public List<AplDefine> findNombreEps();
    public List<AplDefine> findNombreFdp();
    public List<AplDefine> findNombreFdc();
    public List<AplDefine> findCotizaTipo();
    public List<AplDefine> findCotizaSubtipo();
    public List<AplDefine> findDocPendientes();
    public List<AplDefine> findRepresentanteLegal();
    
    public List<AplDefine> findUnidadMedida();
    public List<AplDefine> findConceptosTipo();
    public List<AplDefine> findConceptoLiquidacion();
    public List<AplDefine> findPeriodoPago();
    public List<AplDefine> findGrupoConcepto();
    public List<AplDefine> findCuentaPucSufijo();
    
    public Date findByFechaHasta();
    
}
