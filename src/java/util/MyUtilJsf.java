/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author ebeltran
 */
public class MyUtilJsf {
    private static ServletContext servletContext;
    

    /**
     * Permite crear un archivo temporal de imagen
     * @param bytes
     * @param nombreArchivo
     * @return ubicacionImagen
     */
    public static String guardaBlobEnFicheroTemporal(byte[] bytes,
            String nombreArchivo) {
        
        String ubicacionImagen = null;
        servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = servletContext.getRealPath("") + File.separatorChar 
                + "files" + File.separatorChar + "upload" + File.separatorChar + nombreArchivo;
        
        File f = null;
        InputStream in = null;
        
        try {
            f = new File(path);
            in = new ByteArrayInputStream(bytes);
            try (FileOutputStream out = new FileOutputStream(f.getAbsolutePath())) {
                int c = 0;
                while ((c = in.read()) >= 0); {
                out.write(c);
            }
                out.flush();
            }
            ubicacionImagen = "../../files/upload" + nombreArchivo;
        } catch (IOException e) {
            System.err.println("No se pudo crear la imagen");
        }
        return ubicacionImagen;
    }   
}