package si.um.feri.jee.sample;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Properties;

public class MailSender {

    private static Session session;
    private static Properties properties = new Properties();


    static {
        try {
            properties.put("mail.smpt.host", "localhost");
            properties.put("mail.smpt.port", "25");
            session = (Session) new InitialContext().lookup("java:jboss/mail/Default");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }


    public static void send(String prejemnik, String subject, String body){
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("zunanji@lmao.lmao"));
            Address prejemnikAdress = new InternetAddress(prejemnik);
            message.setRecipient(Message.RecipientType.TO, prejemnikAdress);
            message.setSubject(subject);
            message.setContent(body, "text/plain");

            Transport.send(message);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void preveriEmail(String email){
        // Ne dela, sem probaval setupat registriranje novega maila v server, sam idk kak
        try {
            Properties props = new Properties();
            props.setProperty("mail.store.protocol", "imap");
            props.setProperty("mail.imap.host", "localhost");
            props.setProperty("mail.imap.port", "143");
            Session session = Session.getInstance(props);
            Store store = session.getStore("imap");
            store.connect("localhost", "zunanji@lmao.lmao", "lmao");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
