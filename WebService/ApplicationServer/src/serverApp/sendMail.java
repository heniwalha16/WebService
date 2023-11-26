package serverApp;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendMail {
	 public static String mailUsername;
	    public static String mailPassword;
	    public static String contenu;
	    public static String destination;
	    public static String subject;

	    public sendMail(String contenu, String destination, String subject) {
	        mailUsername = "anis.bouhamed@esprit.tn";
	        mailPassword = "213JMT7558a";
	        this.contenu = contenu;
	        this.destination = destination;
	        this.subject = subject;
	    }

	    public static void sendMail() {
	        System.out.println("Preparing to send email");
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");

	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(mailUsername, mailPassword);
	            }
	        });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(mailUsername));
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destination));
	            message.setSubject(subject);
	            message.setText(contenu);
	            Transport.send(message);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	           e.printStackTrace();
	        }

	    }
	    
	}