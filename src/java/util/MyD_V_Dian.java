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
public class MyD_V_Dian {

    
    /**
     * Calculo de el Digito Verificacion DIAN Colombia Modulo 11
     * @param cNit
     * @return 
     */
    public static String calculoDigitoVerificacion(String cNit) {

        int aFactor[] = {71, 67, 59, 53, 47, 43, 41, 37, 29, 23, 19, 17, 13, 7, 3};
        int nAcum = 0;
        int nResto = 0;
        int b = 1;

        String nD_v = null;
        for (int i = 0; i < cNit.length(); i++) {
            nAcum = nAcum + (Integer.parseInt(cNit.substring(i, b)) * aFactor[i]);
            b++;
        }

        nResto = nAcum - (nAcum / 11) * 11;

        if (nResto == 0 || nResto == 11) {
            nD_v = "0";
        } else if (nResto == 1 || nResto == 10) {
            nD_v = "1";
        } else if (nResto == 2) {
            nD_v = "9";
        } else if (nResto == 3) {
            nD_v = "8";
        } else if (nResto == 4) {
            nD_v = "7";
        } else if (nResto == 5) {
            nD_v = "6";
        } else if (nResto == 6) {
            nD_v = "5";
        } else if (nResto == 7) {
            nD_v = "4";
        } else if (nResto == 8) {
            nD_v = "3";
        } else if (nResto == 9) {
            nD_v = "2";
        }
        return nD_v;
    }
}
