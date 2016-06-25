/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.ConceptoPago;

/**
 *
 * @author Eduar
 */
public interface ConceptoPagoDao {
    
    public List<ConceptoPago> findAll();
    public String create(ConceptoPago conceptoPago);
    public String update(ConceptoPago conceptoPago);
    
}
