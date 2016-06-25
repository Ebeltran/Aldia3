/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import jstels.jdbc.dbf.DBFDataSource;
import util.MyFilesPropertiesXBase;

/**
 *
 * @author Eduar
 */
public class ConnectionXBase {
    
    private final String driver = "jstels.jdbc.dbf.DBFDriver";
    private final String connectorXBase;
    private Connection conX;
    
    private String msgEx = null;
    private FacesMessage message = null;

    /***
     * Constructor
     */
    public ConnectionXBase() {

        Properties myDbXBase = new MyFilesPropertiesXBase().getConnetionDbXBase();
        String connector;
        

//        DBFDataSource dbfDS = new DBFDataSource();
//        dbfDS.setPath(myDbXBase.getProperty("urlWinDB"));  // path to the DBF directory
//        dbfDS.setFileExtension(".dbf");    	           // file extension is .db
//        dbfDS.setCharset("ISO-8859-1");             	   // file encoding is "ISO-8859-2"
        
        StringBuilder auxiliar = new StringBuilder();

        String strOS = System.getProperty("os.name").toLowerCase();

//        if (strOS.startsWith("windows")) {
//            auxiliar.append("jdbc:jstels:dbf").append(":").append(myDbXBase.getProperty("urlWinDB"));
//            auxiliar.append(" ?encoding=ISO8859_1");
//            
//            // urlWinDB=C:/India/SITARA
//            
//        } else {urlIpLinDB=192.168.1.1
            auxiliar.append("jdbc:jstels:dbf").append("://///");
            auxiliar.append(myDbXBase.getProperty("urlIpLinDB")).append("//");
            auxiliar.append(myDbXBase.getProperty("urlLinDB")).append("/");
            
//            auxiliar.append("jdbc:firebirdsql://");
//            auxiliar.append(myFdbSQL.getProperty("urlIpLinDB")).append(":");
//            auxiliar.append(myFdbSQL.getProperty("puertoLinDB")).append("//");        
//            auxiliar.append(myFdbSQL.getProperty("urlLinDB")).append("/");
//            auxiliar.append(myFdbSQL.getProperty("nombreDB")).append(" ?encoding=ISO8859_1");  
            
//        }
            
        connector = auxiliar.toString();
        this.connectorXBase = connector;

    }
    
    /*** 
     *
     *
     */
    public void connect() {
        try {

            Class.forName(this.driver);
            try {
                conX = DriverManager.getConnection(this.connectorXBase);
            } catch (SQLException ex) {
                msgEx = ex.getMessage();
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            }
        } catch (ClassNotFoundException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }


    /*** 
     *
     *
     */
    public void close() {

        if (conX != null) {
            try {
                if (conX.isClosed() == false) {
                    conX.close();
                    conX = null;
                }
            } catch (SQLException ex) {
                msgEx = ex.getMessage();
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            }
        }
    }

    public ResultSet query(String query) {
                Statement st;
        ResultSet rs = null;

        try {
            st = conX.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            msgEx = e.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
        return rs;
    }
}
