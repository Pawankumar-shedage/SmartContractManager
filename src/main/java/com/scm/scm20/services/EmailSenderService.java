package com.scm.scm20.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
@Service
public class EmailSenderService {
    
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail,String subject,String body){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toEmail);
        message.setFrom("pawankumarshedage@gmail.com");
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

        System.out.println("Email sent successfully to: "+toEmail);//Debug log
    }
}
