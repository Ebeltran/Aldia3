/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import util.MyUtil;

/**
 *
 * @author ebeltran
 */
@ManagedBean
@ViewScoped
public class AppBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of appdBean
     */
    public AppBean() {
    }
    
    public String getBaseLogin() {
        return MyUtil.baseLogin();    	
    }
    
    public String getRealPath() {
        return MyUtil.realPath();
    }
    
    public String getRealPathImagen() {
        return MyUtil.realPathImagen();    	
    }
    
    public String getBaseUrl() {
        return MyUtil.baseUrl();
    }
    
    public String getRutaReport() {
        return MyUtil.rutaReport();
    }
    
    public String getRutaPDF() {
        return MyUtil.rutaPDF();
    }
    
    public String getRutaContrato() {
        return MyUtil.rutaContrato();
    }
    
    public String getRutaTXT_XLS() {
        return MyUtil.rutaTXT_XLS();
    } 
     
    public String getBasePath() {
        return MyUtil.basePath();
    }                
}