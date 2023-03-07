package si.um.feri.jee.sample;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Properties;

@Stateless
public class MailSender {

    public static void send(String prejemnik, String subject, String body){
        try{
            System.out.println("1");
            Properties properties = new Properties();
            properties.put("mail.smpt.host", "localhost");
            properties.put("mail.smpt.port", "25");
            System.out.println("4");

            Session session = (Session) new InitialContext().lookup("java:jboss/mail/Default");
            System.out.println("2");

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("zunanji@lmao.lmao"));
            Address prejemnikAdress = new InternetAddress(prejemnik);
            message.setRecipient(Message.RecipientType.TO, prejemnikAdress);
            message.setSubject(subject);
            message.setContent(body, "text/plain");
            System.out.println("3");

            Transport.send(message);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
