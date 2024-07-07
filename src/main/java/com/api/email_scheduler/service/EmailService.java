package com.api.email_scheduler.service;

import com.api.email_scheduler.controller.dto.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(Email email) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(email.from());
            simpleMailMessage.setTo(email.to());
            simpleMailMessage.setSubject(email.subject());
            simpleMailMessage.setText(email.body());
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.error("error sending email: {}", e.getLocalizedMessage());
        }
    }

}
