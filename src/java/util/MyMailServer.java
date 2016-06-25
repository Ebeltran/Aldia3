/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Properties;
import java.util.Date;

import javax.mail.Message;
import javax.mail.Session;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import com.sun.mail.smtp.*;
import com.sun.mail.smtp.SMTPTransport;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

//import java.util.Date;
//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;



/**
 *
 * @author Eduar
 */
public class MyMailServer {

    private String msge = "";
    private FacesMessage message = null;
    
    private String host;
    private boolean okAuth = true;
    private boolean okTls = true; 
    private boolean okDebug;
    private int port;
    private String from;
    private String password; 
    private String msgMail = "Respuesta del servidor de correo: Mensaje No enviado";
    
    
//    public static void main(String args[]) throws Exception {
//
//        MyMailServer1 myMailServer = new MyMailServer1();
//        myMailServer.sendMail("", "", "", "", "");
//
//    }

    public String sendMail(String to, String cc, String subject, String mailer, String body) {

//        from = "aldiasoft@bnsis.com";
//        password = "Aldia1234*";
//        to = "ebeltran@bnsis.com";
//        subject = "creacion cuenta via 587 xcon ";
//        body = "mensaje\nmuy\nlargo\nvia 587 ";

//        cc = "aldiasoft@bnsis.com";
//        mailer = "Aladia Soft";
//        host = "pro.turbo-smtp.com";
//        port = 587;
//        ok = false;
//        okDebug = true;
//        okAuth = true;
//        okTls = true;

        Properties myMailSmtp = new MyFilesProperties().getMailSmtp();
        host = myMailSmtp.getProperty("host");
        okAuth = true;
        okTls = true;
        if (myMailSmtp.getProperty("okDebug").equalsIgnoreCase("1")) {
            okDebug = true;
        } else {
            okDebug = false;
        }
        from = myMailSmtp.getProperty("from");
        password = myMailSmtp.getProperty("password");
        
        try {

            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", okTls);
            props.put("mail.smtp.port", port);
            props.put("mail.smtp.mail.sender", from);
            props.put("mail.smtp.user", to);
            props.put("X-Mailer", mailer);
            props.put("mail.smtp.auth", okAuth);
//            props.put("addContent", "text/html");
            props.put("mail.debug", okDebug);

            Session session = Session.getInstance(props);

            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress((String) props.get("mail.smtp.mail.sender")));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to, false));
            msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc, false));
            msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(from, false));


            msg.setFrom(new InternetAddress(from));

            msg.setSubject(subject);
            msg.setContent(body,"text/html" );
//            msg.setText(body);
            msg.setHeader("X-Mailer", mailer);

            msg.setSentDate(new Date());

            SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
            t.connect(host, from, password);
            t.sendMessage(msg, msg.getAllRecipients());
            msgMail = "Respuesta del servidor de correo :" + t.getLastServerResponse();
            
            t.close();
            
        } catch (MessagingException ex) {
            msge = ex.getMessage();
            System.out.println("ALDIA3_LOG_sendMail_error: " + msge);
            
            
        }
        
        return msgMail;
    }

}
