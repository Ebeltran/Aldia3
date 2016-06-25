/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author ebeltran
 */
public class ManejoFechas {
    private int hora;
    private int minuto;
    private int segundo;
    
    public void setTime (int h, int m, int s) {
        hora = ((h >= 0 && h < 24) ? h : 0);
        hora = ((m >= 0 && m < 60) ? m : 0);
        hora = ((s >= 0 && s < 60) ? s : 0);
        
    }
    
    public String toMilitary () {
        return String.format("%02d:%02d:%02d", hora, minuto,segundo); 
    } 
}
