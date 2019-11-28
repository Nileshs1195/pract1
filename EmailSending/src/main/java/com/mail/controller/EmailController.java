package com.mail.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.service.SmtpMailSender;

@RestController
@RequestMapping("/Mail")
public class EmailController
{	
	@Autowired
	private SmtpMailSender smtpmailSender;
	
	@GetMapping("/sendMail")
	public String sendMail() throws MessagingException {
		return smtpmailSender.send("solankarnilesh@sggs.ac.in", "Sending mail from Springboot App", "Dear Nilesh, You have been added to project");
	}
	
}
