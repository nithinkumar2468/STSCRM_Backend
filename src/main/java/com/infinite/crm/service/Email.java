package com.infinite.crm.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Email {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(toEmail);
        mail.setFrom("helpdesk.crm.capstone@gmail.com");
        mail.setText(body);
        mail.setSubject(subject);

        mailSender.send(mail);

        logger.info("Mail Sent Successfully");
    }
    
    public void sendEmailToMultipleRecipients(List<String> toEmails, String subject, String body) {
        for (String email : toEmails) {
            sendEmail(email, subject, body);
        }
    }

}
