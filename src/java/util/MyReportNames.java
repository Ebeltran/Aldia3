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
public class MyReportNames {

    private static String returns;

    public static String nombreContrato(String nombreR) {

        returns = "PDF" + File.separatorChar + "CONTRATOS"
                + File.separatorChar + nombreR + "_" + "Contrato";
        return returns;
    }

    public static String nombreResumen(String nombreR) {

        returns = "PDF" + File.separatorChar + "CONTRATOS"
                + File.separatorChar + nombreR + "_" + "ResumenContrato";
        return returns;
    }

    public static String nombreVisita(String nombreR) {

        returns = "PDF" + File.separatorChar + "VISITA_DOM"
                + File.separatorChar + nombreR + "_" + "VisitaDom";
        return returns;
    }

    public static String nombreExamenIngreso(String nombreR) {

        returns = "PDF" + File.separatorChar + "EXAMEN_MED"
                + File.separatorChar + nombreR + "_" + "ExamenIng";
        return returns;
    }

    public static String nombreCartaBanco(String nombreR) {

        returns = "PDF" + File.separatorChar + "CARTA_BAN"
                + File.separatorChar + nombreR + "_" + "CartaBan";
        return returns;
    }

}
