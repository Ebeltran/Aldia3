/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.sun.mail.smtp.SMTPTransport;
import java.util.Date;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ebeltran
 */
public class MyMailServer2 {
    
    static Transport transport;
    private boolean ok = false;
    private String msge = "";
    
    FacesMessage message = null;
    
    public static void main(String args[]) throws Exception {
        MyMailServer2 myMailServer = new MyMailServer2();
        myMailServer.sendMail("", "", "", "", "");
        
    }
        
    public boolean sendMail(String from, String password, String to, String subject, String body) {   
    
        from = "aldiasoft@bnsis.com";
        password = "Aldia1234";
        to = "ebeltran@bnsis.com";
        String cc = "ebeltranc@bnsis.com";
        String mailer ="Aladia Soft";
        
        subject = "creacion cuenta via 587";
        body = "mensaje\nmuy\nlargo\nvia 587 ";
        String host = "pro.turbo-smtp.com";
        String port = "587";
        boolean okDebug = true;
        boolean okAuth = true;
        boolean okTls = true;
        
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", okAuth);
        props.put("mail.smtp.starttls.enable", okTls);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.mail.sender", from);
        props.put("mail.smtp.user", to);
        props.put("X-Mailer", mailer);
        
        props.put("mail.debug", okDebug);

        Session session = Session.getDefaultInstance(props);
        
        try {
            MimeMessage msg = new MimeMessage(session);
            
            msg.setFrom(new InternetAddress((String) props.get("mail.smtp.mail.sender")));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to, false));
            msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc, false));
            
            msg.setFrom(new InternetAddress(from));
            
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setHeader("X-Mailer", mailer);
            msg.setText(body);

            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
            t.connect(host, from, password);
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response: " + t.getLastServerResponse());
            
            // Cierre.
            t.close();
            ok = true;
        } catch (MessagingException ex) {
            msge = ex.getMessage();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, msge, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        }
        return ok;
    }
}
