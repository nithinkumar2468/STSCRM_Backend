package com.infinite.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Email {
	@Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(toEmail);
        mail.setFrom("nithinkumarkodipyaka@gmail.com");
        mail.setText(body);
        mail.setSubject(subject);

        mailSender.send(mail);

        System.out.println("Mail Sent Successfully");
    }

}
