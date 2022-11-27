package com.example.demo.emailConfirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailBusinessTest implements EmailSender{
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void send(String to, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nhatnam.0127@gmail.com");
        message.setTo(to);
        message.setText(email);
        message.setSubject("Subject");
        mailSender.send(message);
    }
}
