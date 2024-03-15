package com.send.email.service;

import com.send.email.model.MailStructure;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("$(spring.mail.username)")
    private String fromMail;
    public void sendEmail(String mail, MailStructure mailStructure) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromMail);
            message.setTo(mail);
            message.setText(mailStructure.getMessage());
            message.setSubject(mailStructure.getSubject());
            mailSender.send(message);

        } catch (MailException ex) {

            System.err.println("Error sending email: " + ex.getMessage());
            throw new RuntimeException("Error sending email", ex);
        }
    }
}
