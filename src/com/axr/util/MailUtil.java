package com.axr.util;
import java.io.InputStream;
import java.util.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
@Service
public class MailUtil {
	public static String sendMail(String emailFrom, String emailTo, String subject, String salutation, String bodyMsg) {
		
		Properties prop = new Properties();
		InputStream inputStream = null;
		String email = "";
		String password = "";
		try {
			inputStream = MailUtil.class.getClassLoader().getResourceAsStream("mail.properties");
			prop.load(inputStream);
			email = prop.getProperty("email");
			password = prop.getProperty("password");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final String USERNAME = email;
		final String PASSWORD = password;
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailFrom));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailTo));
			message.setSubject(subject);
			message.setText(salutation+","
				+ "\n\n"+bodyMsg);
 
			message.setContent(bodyMsg, "text/html");
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return "success";
	}
	
	public static void main(String[] args) {
		String emailTo="kranti.chavannavar@gmail.com";
		  // message contains HTML markups
        String message = "<i>Greetings!</i><br>";
        message += "<b>Wish you a nice day!</b><br>";
        message += "<font color=red>Hello Kranti</font>";
        message +="<table border='1px solid black' style='border-collapse:collapse'><tr><td>name</td><td>Kranti</td></tr><tr><td>age</td><td>23</td></tr></table>";
		
		 MailUtil.sendMail("kranti4all@gmail.com", emailTo, "Hi", "as", message);
		
	}
}
