/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * tail -f -n 400 /var/log/tomcat8/catalina.out
 *
 */
package jasperSoft;

import connection.ConnectionDB;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static util.MyUtil.rutaReport;

/**
 *
 * @author ebeltran
 */
public abstract class JasperSoftReport implements Serializable {
    
    private static JasperReport report;
    private static JasperPrint reportFilled;
    private static JasperViewer viewer;
    private static String jrxmlFilePath;
    private static String jasperFilePath;
    
    private static ConnectionDB con;
    private static String msgEx;
    private static FacesMessage message;
    private static final long serialVersionUID = 1L;
    
    /**
     * Metodo para crear reportes
     * @param archivoJasper
     * @param parameters 
     * @param archivoSale 
     * @throws java.io.FileNotFoundException 
     */
    public static void createReport(Map parameters, String archivoJasper, String archivoSale) throws FileNotFoundException {
        
        con = new ConnectionDB();
        con.connect();
        
        // Ruta donde estan los reportes
        archivoSale = new StringBuilder().append(rutaReport()).append(archivoSale).toString();
        
        System.out.println("ALDIA3_LOG_RUTA: " + archivoSale);
        // Ruta archivo Archivo Jasper de tipo jrxml
        jrxmlFilePath = new StringBuilder().append(rutaReport()).append(archivoJasper).append(".jrxml").toString();
        
        File jrxmlFile = new File(jrxmlFilePath); 
        if (!jrxmlFile.exists()) {
            msgEx = "No se encuentra el Archivo " + jrxmlFilePath;
            System.out.println("ALDIA3_LOG_jrxmlFilePath_error: " + msgEx);
            
        }
        
        // Ruta archivo Archivo Jasper de tipo jasper
        jasperFilePath = new StringBuilder().append(rutaReport()).append(archivoJasper).append(".jasper").toString();

        File jasperFile = new File(jasperFilePath);
        if (!jasperFile.exists()) {
            try {
                
                JasperCompileManager.compileReportToFile(jrxmlFilePath);
            } catch (JRException ex) {
                msgEx = ex.getMessage();
                System.out.println("ALDIA3_LOG_compileReportToFile_error: " + msgEx);

            }
        }
        
        try {
            
            System.out.println("ALDIA3_LOG_loadObjectFromFile: " + jasperFilePath);
            report = (JasperReport) JRLoader.loadObjectFromFile(jasperFilePath);
            
            // Locale para colombia
//            parameters.put(JRParameter.REPORT_LOCALE, new Locale("es","CO"));
            parameters.put(JRParameter.REPORT_LOCALE, new Locale("es_ES"));
            reportFilled = JasperFillManager.fillReport(report, parameters, con.getConn());
            
            // exports report to pdf
            exportToPdf(archivoSale);
            
//            JRExporter exporter = new JRPdfExporter();
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, reportFilled);
//            
//            System.out.println("ALDIA3_LOG: " + archivoSale + ".PDF");
//            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(archivoSale + ".PDF")); // your output goes here
//            
//            exporter.exportReport();
                        
//            exportToXls(archivoJasper, archivoSale, path, parameters);
//            showViewer();            
            
        } catch (JRException ex) {
            msgEx = ex.getMessage();
            System.out.println("ALDIA3_LOG_JRException_error: " + msgEx);
                        
        }  
        finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception ex) {
                    msgEx = ex.getMessage();
                    System.out.println("ALDIA3_LOG_finally_Exception_error: " + msgEx);
                }
            }
        }

    }
    
    /***
     * 
     */
    public static void showViewer() {
        
//        viewer = new JasperViewer( reportFilled, JRViewerFxMode);
        viewer = new JasperViewer(reportFilled);
        viewer.setVisible( true );
                
    }  
    
    /***
     * 
     * @param archivoSale
     */
    public static void exportToPdf(String archivoSale) {
        
        archivoSale = new StringBuilder().append(archivoSale).append(".PDF").toString();
        
        try {
            
            JasperExportManager.exportReportToPdfFile(reportFilled, archivoSale);
        } catch (JRException ex) {
            msgEx = ex.getMessage();
            System.out.println("ALDIA3_LOG_exportToPdf_error: " + msgEx);
            
        }

    }

    /**
     * 
     * @param archivoSale
     */
    @SuppressWarnings("deprecation")
    public static void exportToXlsx(String archivoSale) {
        try {
            long start = System.currentTimeMillis();
//            File sourceFile = new File("build/reports/ImagesReport.jrprint");
            File sourceFile1 = new File(archivoSale + ".jrprint");
            
//            JasperPrint jasperPrint = (JasperPrint)JRLoader.loadObject(sourceFile);
            JasperPrint jasperPrint1 = (JasperPrint)JRLoader.loadObject(sourceFile1);
            
//            File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".xlsx");
            File destFile1 = new File(sourceFile1.getParent(), jasperPrint1.getName() + ".xlsx");
            // Ruta donde estan los reportes
//            archivoSale = archivoSale + ".XLS";
            
            
            JRXlsxExporter exporter = new JRXlsxExporter();
            
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint1);
//            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile1.toString());
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            
            
            exporter.exportReport();
            
            System.err.println("XLSX creation time : " + (System.currentTimeMillis() - start));
        } catch (JRException ex) {
            msgEx = ex.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
    @SuppressWarnings("deprecation")
    public static void exportToXls(String archivoJasper, String archivoSale, Map parameters) {
        
        try {
            
            // Ruta donde estan los reportes
            archivoSale = archivoSale + ".XLS";
            
            // Ruta archivo Archivo Jasper de tipo jrxml
            jrxmlFilePath = rutaReport() + archivoJasper + ".jrxml";
            
            File jrxmlFile = new File(jrxmlFilePath);
            if (!jrxmlFile.exists()) {
                msgEx = "No se encuentra el Archivo " + jrxmlFilePath;
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            }
            
            // Ruta archivo Archivo Jasper de tipo jasper
            jasperFilePath = rutaReport() + archivoJasper + ".jasper";
            
            File jasperFile = new File(jasperFilePath);
            if (!jasperFile.exists()) {
                try {
                    JasperCompileManager.compileReportToFile(jrxmlFilePath);
                } catch (JRException ex) {
                    msgEx = ex.getMessage();
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                }
            }
            report = (JasperReport) JRLoader.loadObjectFromFile(jasperFilePath);
            
            reportFilled = JasperFillManager.fillReport(report, parameters, con.getConn());
            
            JRXlsExporter exporterXLS = new JRXlsExporter();
            
            exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, reportFilled);
            exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, archivoSale);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporterXLS.exportReport();
        } catch (JRException ex) {
            msgEx = ex.getMessage();
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgEx, null);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        } finally {
            con.close();
        }
    }    
    
    /***
     * 
     * @param archivoSale 
     */
    public static void exportToXml(String archivoSale)  {
        
        archivoSale = archivoSale + ".xml";
        try {
            JasperExportManager.exportReportToXmlFile(reportFilled, archivoSale, true);
        } catch (JRException ex) {
            msgEx = ex.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msgEx, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
       
    }

//    public ByteArrayOutputStream export(Map<String, Object> parameters) {
//
//        try {
//            // Custom code to get DB Connection
//            con = new ConnectionDB();
//            con.connect();
//
//            // This will be output PDF stream
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//            // You will need to specify relative path to your Jasper report:
//            URL fileUrl = getClass().getClassLoader().getResource("path to report.jasper");
//
//            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileUrl);
//
//            /* This line sets correct factory to parse and process PLSQL procedure calls.
//      The PlSqlQueryExecuterFactory class is located in jasperreports-extensions-3.5.3.jar */
//            jasperReport.setProperty("net.sf.jasperreports.query.executer.factory.plsql", "com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");
//
//            /* You may need to execute following line just once in your application.
//     You can try to move it into initialization or static code block.
//     Also you may notice that line below is marked as deprecated. 
//     However in my case the export to pdf fails without this line being executed. */
//            JRProperties.setProperty(JRQueryExecuterFactory.QUERY_EXECUTER_FACTORY_PREFIX + "plsql", "com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");
//
//            /* Prepare Jasper print and exporter objects in lines below */
//            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, con.getConn());
//            JRExporter exporter = new JRPdfExporter();
//            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//            exporter.exportReport();     // Generate PDF report
//            return outputStream;         // Return stream result to your application code
//            // to wrap in response object.
//        } catch (Exception ex) {
//            log.severe("Exception loading pdf: " + ex.getMessage());
//        }
//    }  
}
