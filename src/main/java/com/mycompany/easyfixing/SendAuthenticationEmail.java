/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easyfixing;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author hieut
 */
public class SendAuthenticationEmail {
    //Send authentication email
    // Test sending gmail

    public SendAuthenticationEmail(String senderusername, String senderpassword, String receiverusername, int randomkey) {
        senderUsername = senderusername;
        senderPassword = senderpassword;
        receiverUsername = receiverusername;
        randomKey = randomkey;
    }
    public void SendEmail() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderUsername, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderUsername));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(receiverUsername)
            );
            message.setSubject("GET YOUR AUTHENTICATION CODE!");
            message.setText("""
                            Please confirm your activity in EasyFixing with below code:
                            
                            """ + Integer.toString(randomKey));

            Transport.send(message);
//            JOptionPane.showMessageDialog(this, "Email sent");
//            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    private final String senderUsername;
    private final String senderPassword;
    private final String receiverUsername;
    private final int randomKey;
}
