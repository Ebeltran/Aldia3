/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
@ManagedBean
@ViewScoped
public class AplMailServerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    static Transport transport;
    
    public AplMailServerBean() {
        
    }
    
    public boolean sendMail(String username, String password, String toSend, String subject, String text) throws MessagingException {
      
        boolean oK = false;
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.addRecipient(
        Message.RecipientType.TO, new InternetAddress(toSend));
        message.setSubject(subject);
        message.setText(text);
        javax.mail.Transport t = null;
        t = session.getTransport("smtp");
        t.connect(null, null);
        t.sendMessage(message, message.getAllRecipients());
        
        // Cierre.
        t.close();
        oK = true;
        
        return oK;
    }
}
