/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Eduar
 */
public class MailSender {

    protected String domain;
    protected String host;
    protected String port;
    protected String username;
    protected String password;

    public MailSender(String domain, String host, String port, String username,
            String password) {
        super();
        this.domain = domain;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MailSender() {

    }

    public void sendEmail(ArrayList<String> to, String subject, String content) {
        /*(1)*/

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.starttls.enable", "true");

        properties.setProperty("mail.smtp.port", port);
        properties.setProperty("mail.smtp.user", username);
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties);
        session.setDebug(true);
        /*(3)*/
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(username));
            message.setSubject(subject);
            InternetAddress[] address = new InternetAddress[to.size()];
            for (int i = 0; i < to.size(); i++) {
                address[i] = new InternetAddress(to.get(i));
            }
            message.setRecipients(Message.RecipientType.TO, address);
            message.setText(content, "ISO-8859-1", "html");
            /*(4)*/
            Transport transport = session.getTransport("smtp");
            transport.connect(username, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception e) {

        }

    }
}
