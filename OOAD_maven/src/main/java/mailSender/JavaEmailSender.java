package mailSender;

import java.io.UnsupportedEncodingException;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Random;

public class JavaEmailSender {

    final static String SENDER_NAME = "EasyFixing Admin";   //User name of the Goole(gmail) account
    final static String PASSSWORD = "qekgnrtfklgannmw";  //Password of the Goole(gmail) account
    final static String SENDER_EMAIL = "jdk161201@gmail.com";  //Sender email addresss

    public JavaEmailSender() {
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        JavaEmailSender email = new JavaEmailSender();
        //Sending test email
        email.sendForgetPass("nguyenduongtuky1410@gmail.com");
    }

    public int sendForgetPass(String receiverEmail) throws UnsupportedEncodingException {
        int code;
        code = generateRandomCode();
        String subject = "[EasyFixing] Reset password authentication code";
        String content = "Dear user,\nYou have requested to reset your EasyFixing account password.\nYour authentication code is: " + String.valueOf(code) + "\n Your code is valid in just 3 minutes.\nIf you didn't request to change the password, please don't provide code for anyone!\n\nAdmin";
        if (sendEmailMessage(receiverEmail, subject, content)) return code;
        else return -1;
    }

    private boolean sendEmailMessage(String receiverEmail, String subject, String content) throws UnsupportedEncodingException {

        //Create email sending properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER_EMAIL, PASSSWORD);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER_EMAIL, SENDER_NAME)); //Set email of sender
            message.setContent(content, "text/html"); //set content type of the email

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail)); //Set email recipient
            message.setSubject(subject); //Set email message subject
            message.setText(content);
            Transport.send(message); //Send email message
            
            return true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private int generateRandomCode() {
        // Generate a random 6-digit code
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return code;
    } 
}
