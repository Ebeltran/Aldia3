/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileOutputStream;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;
import java.io.Serializable;
/**
 *
 * @author ebeltran
 */
public class MyPDFFiles implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void concatenar2PDF (String file1, String file2, String fileSale) throws Exception {
        
        System.out.println("Concatenate Two PDF");
        PdfReader reader1 = new PdfReader(file1);
        PdfReader reader2 = new PdfReader(file2);
        PdfCopyFields copy = new PdfCopyFields(new FileOutputStream(fileSale));
        copy.addDocument(reader1);
        copy.addDocument(reader2);
        copy.close();
        
    }
}
