package businessLogic;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.logging.Logger;
import javax.activation.*;

/**
 * Created by MalindaK on 9/18/2016.
 */
public class EmailSender{

    Queue queue = new LinkedList();
    private static boolean enabled = true;
    private static boolean started = false;
    public static Thread thread;

    public static  void sendEmail(final int type, final String emailaddr){
        Thread thread = new Thread(){
            public void run(){
                send(type,emailaddr);
            }
        };
        thread.start();
    }

    private static void send(int type,String emailaddr)
    {
        String subject = null,text = null;
        String to = "malindakpt@gmail.com"; //Should be replaced by emailaddr


        switch (type){
            case 0:
                subject="Voction account created";
                text="Hi, your acc will be activated by 1 hr";
                break;
            case 1:
                subject="Advertisement Created";
                text="Your VOCTION advertisement created successfully\n Please refer following details :";
                break;
            case 2:
                subject="";
                text="";
                break;
            default:
                subject="Error";
                text="Unknown message type";
                System.out.println("Invalid message type");

        }

        String from = "voction@yahoo.com";
        String pass ="Vkpt@16709";
        String host = "smtp.mail.yahoo.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", pass);

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        try{
            Session session = Session.getDefaultInstance(properties);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);

            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Email sent to : "+emailaddr);
        }catch (Exception mex) {
            mex.printStackTrace();
            System.out.println(mex.getMessage());
        }
    }

}
