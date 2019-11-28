package com.mail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service
public class SmtpMailSender
{	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public String send(String to, String subject, String body) throws MessagingException
	{
		MimeMessage message=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		
		try
		{
		helper.setText("Sending a mail");
		helper.setTo("solankarnilesh@sggs.ac.in");
		helper.setSubject("Hi there, I am working on springboot");
		}
		
		catch (Exception e) 
		{
			return "Error while sending mail";
		}
		
		javaMailSender.send(message);
		return "mail sent to solankarnilesh@sggs.ac.in";
		
	}

}
