/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Eduar
 */
public class MyFilesPropertiesXBase {
    
    /**
     * Metodo para leer Archivo properties de 
     * ConnetionDbSQL
     * @return 
     */
    public Properties getConnetionDbXBase() {

        try {
            //se crea una instancia a la clase Properties
            Properties propiedades = new Properties();
            //se leen el archivo .properties
            propiedades.load(getClass().getResourceAsStream("../ConnectionDbXBase.properties"));
            //si el archivo de propiedades NO esta vacio retornan las propiedes leidas

            if (!propiedades.isEmpty()) {
                return propiedades;
            } else {//sino  retornara NULL
                return null;
            }
        } catch (IOException ex) {
            return null;
        }
    }
}
