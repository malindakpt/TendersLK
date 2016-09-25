package businessLogic;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.logging.Logger;
import javax.activation.*;

/**
 * Created by MalindaK on 9/18/2016.
 */
public class EmailSender implements Runnable{

    Queue queue = new LinkedList();
    private static boolean enabled = true;
    public void send()
    {
        String subject = null,text = null;
        String to="malindakpt@gmail.com";
        subject="Voction account create";
        text="Hi, your acc will be activated by 1 hr";
//        switch (type){
//            case 0:
//                subject="Voction account create";
//                text="Hi, your acc will be activated by 1 hr";
//                break;
//            case 1:
//                subject="";
//                text="";
//                break;
//            case 2:
//                subject="";
//                text="";
//                break;
//            default:
//                System.out.println("Invalid message type");
//
//        }

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

        Session session = Session.getDefaultInstance(properties);

        try{
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
            System.out.println("Sent message successfully....");
        }catch (Exception mex) {
            mex.printStackTrace();

        }
    }

    @Override
    public void run() {

        while(enabled){



            System.out.println("M");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Email{
    private String sender;
    private String message;
    private String subject;

    public Email( String sender,String message,String subject){
        this.sender=sender;
        this.subject=subject;
        this.message=message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {

        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
