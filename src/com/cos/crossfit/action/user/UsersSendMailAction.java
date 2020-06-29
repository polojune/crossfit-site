package com.cos.crossfit.action.user;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.crossfit.action.Action;
import com.cos.crossfit.action.mail.SMTPAuthenticatior;
import com.cos.crossfit.util.Script;

public class UsersSendMailAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");

		Properties p = new Properties();// 정보를 담을 객체
		p.put("mail.smtp.host", "smtp.naver.com"); // 네이버 SMTP

		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		// SMTP 서버에 접속하기 위한 정보들

		// 사용자가 관리자에게 문의를 하는 구조
		try {
			Authenticator auth = new SMTPAuthenticatior();
			Session ses = Session.getInstance(p, auth);

			ses.setDebug(true);

			
			MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
			msg.setHeader("name", name);
			msg.setSubject(subject); // 제목

			Address fromAddr = new InternetAddress(email);
			msg.setFrom(fromAddr); // 보내는 사람

			Address toAddr = new InternetAddress("polo_june@naver.com");
			msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람

			msg.setContent(email + "님께서 " + message, "text/html;charset=UTF-8");

			Transport.send(msg); // 전송
            
			Script.href("메일 보내기 성공","/crossfit/contact.jsp", response);
		} catch (Exception e) {
			e.printStackTrace();
			Script.back("메일 보내기 실패", response);
		}
	
	}
    
}
