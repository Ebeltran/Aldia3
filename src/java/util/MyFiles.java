/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;

/**
 *
 * @author ebeltran
 */
public class MyFiles {

    public static String eliminarArchivo(String archivo) {

        String cMensaje = new StringBuilder().append("NO ha Sido Eliminado Archivo ").append(archivo).toString();
        if (archivo != null) {
            File file = new File(archivo);

            if (file.exists()) {
                file.delete();
                cMensaje = new StringBuilder().append("Archivo ha Sido Eliminado").append(archivo).toString();
                
            }
            System.out.println("ALDIA3_LOG_eliminarArchivo: " + cMensaje);
        }
        return cMensaje;
    }
    
    public static String numeroRandon() {
        int i = (int) (Math.random() * 10000000);
        return String.valueOf(i);
    }
    
}
