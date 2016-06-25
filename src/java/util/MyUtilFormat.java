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
public class MyUtilFormat {
	
    /**
    * Coloca separador de miles a la cadena de entrada
    * @param cadena String con el valorr a convertir
    * @return aux String de la cadena de entrada con separadores
    * @version 1
    */
    public static String formatOutput(String cadena) {
        String aux = "";
        int k;
        for (int j = cadena.length() - 1; j >= 0; j--) {
            if (aux.length() == 3
                    || aux.length() == 7
                    || aux.length() == 11
                    || aux.length() == 15
                    || aux.length() == 19
                    || aux.length() == 23) {
                aux = "," + aux;
            }
            k = j + 1;
            aux = cadena.substring(j, k) + aux;

        }
        return aux;   
    }

    /**
     * Elimna separadores de la cadena
     * @param valor
     * @return aux String de la cadena de entrada sin separadores
     */
    public static String formatDouble (double valor) {
    	String aux = "";
        int k;
        int n;
        String cDecimal = "";
        String cadena = "";
        String cValor = String.valueOf(valor);
        
        n = cValor.indexOf(".");
        
        if ( n != -1) {
            cDecimal = cValor.substring(n);
            cadena = cValor.substring(0, n);
            
        }
        
        for (int j = cadena.length() - 1; j >= 0; j--) {
            if (aux.length() ==  3 || 
                aux.length() ==  7 || 
                aux.length() == 11 || 
                aux.length() == 15 || 
                aux.length() == 19 || 
                aux.length() == 23) {
                
                aux = "," + aux;
            }
            k = j + 1;
            aux = cadena.substring(j, k) + aux;
        }
        return aux + cDecimal;
    }
    
    public static Double float2Double (float valor) {
        return (double) valor;
    }
    
    public static Double int2Double (int valor) {
        return (double) valor;
    }
    
    public static Float int2Float (int valor) {
        return (float) valor;
    }
    
    /**
     * Elimna separadores de la cadena
     * @param cadena String con el valorr a convertir
     * @return aux String de la cadena de entrada sin separadores
     */
    public static String formatDelete (String cadena) {
    	String aux = "";
    	
        for (int j = 0; j < cadena.length(); j++) {
        	
            if (!cadena.substring(j, j + 1).contains(",")) {
                aux = aux + cadena.substring(j, j + 1);
            }
        }
    	return aux;
    }
    
    /**
     * Elimna separadores del telefono
     * @param cadena String con el valorr a convertir
     * @return aux String de la cadena de entrada sin separadores
     */
    public static String formatDeletePhone (String cadena) {
    	String aux = "";
    	
        for (int j = 0; j < cadena.length(); j++) {
        	
            if (!(cadena.substring(j, j + 1).contains("(") ||
                  cadena.substring(j, j + 1).contains(")") || 
                  cadena.substring(j, j + 1).contains("-"))) {
                aux = aux + cadena.substring(j, j + 1);
            }
        }
    	return aux;
    }
}
