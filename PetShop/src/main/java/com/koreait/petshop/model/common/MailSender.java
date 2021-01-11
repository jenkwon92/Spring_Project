package com.koreait.petshop.model.common;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.koreait.petshop.exception.MailSendException;

@Component
public class MailSender {
	String host = "smtp.gmail.com";
	String user = "johye45@gmail.com";
	String password = "xgyqcyhifmzgdnmz";//크롬 브라우저 보안에서 인증받은 비번 넣기
	Properties props = new Properties();
	
	public void send(String to, String title, String content) throws MailSendException{
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(user, password);
	            }	
		});
		
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(title);//메일 제목
			message.setContent(content, "text/html;charset=utf-8");
			
			Transport.send(message);
			System.out.println("Success Message Send");
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new MailSendException("회원가입 메일발송 실패");
		}
	}

}


