package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import util.MyFilesProperties;


/***
 * 
 * @author ebeltran
 */
public class ConnectionDB {
   
    private final String driver = "org.firebirdsql.jdbc.FBDriver";
    private final String connectorDB;
    private final String loginDB;
    private final String passwordDB;
    private Connection con;
    
    private String msgEx = null;
    
    /***
     * Constructor
     */
    public ConnectionDB() {
        
        Properties myFdbSQL = new MyFilesProperties().getConnetionDbSQL();
        String connector;
        String login = myFdbSQL.getProperty("loginDB");
        String password = myFdbSQL.getProperty("passwordDB");
        StringBuilder auxiliar = new StringBuilder();

        String strOS = System.getProperty("os.name").toLowerCase();

//        if (strOS.startsWith("windows")) {
//
//            connector = "jdbc:firebirdsql://"
//                    + myFdbSQL.getProperty("urlIpWinDB") + ":"
//                    + myFdbSQL.getProperty("puertoWinDB") + "/"
//                    + myFdbSQL.getProperty("urlWinDB") + "/"
//                    + myFdbSQL.getProperty("nombreDB");
//        } else {
            
            auxiliar.append("jdbc:firebirdsql://");
            auxiliar.append(myFdbSQL.getProperty("urlIpLinDB")).append(":");
            auxiliar.append(myFdbSQL.getProperty("puertoLinDB")).append("//");        
            auxiliar.append(myFdbSQL.getProperty("urlLinDB")).append("/");
            auxiliar.append(myFdbSQL.getProperty("nombreDB")).append(" ?encoding=ISO8859_1");    
            
            connector = auxiliar.toString();
            
//            connector = "jdbc:firebirdsql://"
//                    + myFdbSQL.getProperty("urlIpLinDB") + ":"
//                    + myFdbSQL.getProperty("puertoLinDB") + "//"
//                    + myFdbSQL.getProperty("urlLinDB") + "/"
//                    + myFdbSQL.getProperty("nombreDB");
//        }

        this.connectorDB = connector;
        this.loginDB = login;
        this.passwordDB = password;
        
    }

    /*** 
     *
     *
     */
    public void connect() {
        try {

            Class.forName(this.driver);
            try {
                con = DriverManager.getConnection(this.connectorDB, this.loginDB, this.passwordDB);
            } catch (SQLException ex) {
                msgEx = ex.getMessage();
                System.out.println("ALDIA3_LOG_getConnection_error: " + msgEx);
                
            }
        } catch (ClassNotFoundException ex) {
            msgEx = ex.getMessage();
            System.out.println("ALDIA3_LOG_ClassNotFoundException_error: " + msgEx);
            
        }
    }


    /*** 
     *
     *
     */
    public void close() {

        if (con != null) {
            try {
                if (con.isClosed() == false) {
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                msgEx = ex.getMessage();
                System.out.println("ALDIA3_LOG_isClosed_SQLException_error: " + msgEx);
                
            }
        }
    }

    /*** 
     *
     *
     */
    public void getStateConnection() {

        try {
            if (con.isClosed()) {
                
                msgEx = "Conectado";
            } else {
                msgEx = "Desconectado";
            }
        } catch (SQLException ex) {
            msgEx = ex.getMessage();
            System.out.println("ALDIA3_LOG_getStateConnection_SQLException_error: " + msgEx);
        }
        
    }

    /*** 
     *
     * Getter para coneccion
     *
     * @return
     */
    public Connection getConn() {
        return con;
    }

    /*** 
     *
     * Ejecuta un query
     * 
     * @param query
     * @return
     */
    public ResultSet query(String query) {
        Statement st;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            msgEx = e.getMessage();
            System.out.println("ALDIA3_LOG_query_SQLException_error: " + msgEx);
            
        }
        return rs;
    }

    /*** 
     *
     * eEjecuta un execute
     * 
     * @param query
     * @return
     */
    public boolean execute(String query) {
        Statement st;
        boolean save = true;
        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e) {
            save = false;
            msgEx = e.getMessage();
            System.out.println("ALDIA3_LOG_execute_SQLException_error: " + msgEx);
        }
        return save;
    }

    /**
     * Estable la condicion de Autocommit
     * @param b 
     */
    public void setAutoCommit(boolean b) {
        try {
            con.setAutoCommit(b);
        } catch (SQLException e) {
            msgEx = e.getMessage();
            System.out.println("ALDIA3_LOG_setAutoCommit_SQLException_error: " + msgEx);
            
        }
    }

    /**
     * Commit en DB
     */
    public void commit() {
        try {
            con.commit();
        } catch (SQLException e) {
            msgEx = e.getMessage();
            System.out.println("ALDIA3_LOG_commit_SQLException_error: " + msgEx);
            
        }
    }
}
