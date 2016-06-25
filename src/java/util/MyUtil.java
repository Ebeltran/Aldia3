/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.io.File;
import java.util.Properties;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author ebeltran
 */
public class MyUtil {

    private static ServletContext context;
    private static FacesContext aFContext;    
    private static String returns;
    
    
    /**
     * Retorna el path de login.xhtml ---> /Aldia3/faces/
     * @return 
     */
    public static String baseLogin() {
    	aFContext = FacesContext.getCurrentInstance();
    	context = (ServletContext) aFContext.getExternalContext().getContext();

        returns = new StringBuilder().append("/").append(context.getServletContextName()).append("/faces/").toString();
        return returns;
    }

    /**
     * Retorna el path real de la aplicacion incluye la carpeta 
     * C:\\glassfish4\\glassfish\\domains\\domain1\\eclipseApps\\Aldia3\\
     * @return 
     */
    public static String realPath() {
        aFContext = FacesContext.getCurrentInstance();
        context = (ServletContext) aFContext.getExternalContext().getContext();
        
        returns = new StringBuilder().append(context.getRealPath("/")).toString();

        return returns;
    }
    
    /**
     * Retorna el path real de los logos de la aplicacion 
     * C:/Workspace.8.02/Aldia/Aldia3/build/web/resources/images/logos/
     *                               
     * @return 
     */
    public static String realPathImagen() {
        aFContext = FacesContext.getCurrentInstance();
        context = (ServletContext) aFContext.getExternalContext().getContext();

        returns = new StringBuilder().append(File.separatorChar).append(context.getServletContextName()).append(File.separatorChar).append("faces").append(File.separatorChar).append("resources").append(File.separatorChar).append("images").append(File.separatorChar).toString();

        return returns;
    }   
    
    /**
     * Retorna el path de URL finalizando en "/"
     * http://localhost:8080/Aldia3/faces/
     * @return 
     */
    public static String baseUrl() {
        aFContext = FacesContext.getCurrentInstance();
        context = (ServletContext) aFContext.getExternalContext().getContext();

        returns = new StringBuilder().append("http://").append(aFContext.getExternalContext().getRequestServerName()).append(":").append(aFContext.getExternalContext().getRequestServerPort()).append("/").append(context.getServletContextName()).append("/faces/").toString();

        return returns;
    }

    /**
     * Retorna el path de URL finalizando en "/"
     * http://localhost:8080/Aldia3/faces/
     * @return 
     */
    public static String baseUrl_noFaces() {
        aFContext = FacesContext.getCurrentInstance();
        context = (ServletContext) aFContext.getExternalContext().getContext();

        returns = new StringBuilder().append("http://").append(aFContext.getExternalContext().getRequestServerName()).append(":").append(aFContext.getExternalContext().getRequestServerPort()).append("/").append(context.getServletContextName()).toString();

        return returns;
    }
    
    /**
     * Retorna el path de URL finalizando en "/"
     * http://localhost:8080/Aldia3/faces/
     *
     * @return
     */
    public static String basePublicUrl() {
        aFContext = FacesContext.getCurrentInstance();
        context = (ServletContext) aFContext.getExternalContext().getContext();

        Properties miFdbSQL = new MyFilesProperties().getConnetionDbSQL();

        returns = new StringBuilder().append("http://").append(aFContext.getExternalContext().getRequestServerName()).append(":").append(miFdbSQL.getProperty("urlIpLinDB")).append(aFContext.getExternalContext().getRequestServerPort()).append("/").append(context.getServletContextName()).append("/").append(File.separatorChar).append("PDF").append(File.separatorChar).toString();

        return returns;
    }
    
    public static String rutaReport() {
        context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        
        returns = new StringBuilder().append(context.getRealPath("")).append("reports").append(File.separatorChar).toString();
        
        return returns;
    }
    
    public static String rutaResources() {
//        'C:/Workspace.8.02/Aldia/Aldia3/build/web/resources/images/logos/';
        context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        
        returns = new StringBuilder().append(context.getRealPath("")).append("resources").append(File.separatorChar).append("images").append(File.separatorChar).append("logos").append(File.separatorChar).toString();

        return returns;
    }
    
    public static String rutaPDF() {
        aFContext = FacesContext.getCurrentInstance();
    	context = (ServletContext) aFContext.getExternalContext().getContext();
        
        returns = new StringBuilder().append("http://").append(aFContext.getExternalContext().getRequestServerName()).append(aFContext.getExternalContext().getRequestServerPort()).append(":").append(context.getServletContextName()).append("/").append("reports/").append("PDF/faces/").toString();
        
        return returns;
    }
    
    public static String rutaContrato() {
        aFContext = FacesContext.getCurrentInstance();
    	context = (ServletContext) aFContext.getExternalContext().getContext();
        
    	returns = new StringBuilder().append("http://").append(aFContext.getExternalContext().getRequestServerName()).append(":").append(aFContext.getExternalContext().getRequestServerPort()).append("/reports/PDF/Contratos/").toString();    
                
        return returns;
    }
    
    public static String rutaTXT_XLS() {
        context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        
        returns = new StringBuilder().append(context.getRealPath("")).append(File.separatorChar).append("reports").append(File.separatorChar).append("TXT_XLS").append(File.separatorChar).toString();
        
        return returns;
    }
     
    public static String basePath() {
        return "/faces/app/";
    }
    
    public static String basePathPDF() {
        return "/faces/app/";
    }
}