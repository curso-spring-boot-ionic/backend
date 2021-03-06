package com.maycon.cursomc.services;

import com.maycon.cursomc.domain.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

public class SMTPEmailService extends AbstractEmailService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private JavaMailSender javaMailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(SMTPEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage msg) {
        LOGGER.info("Enviando email...");
        mailSender.send(msg);
        LOGGER.info("Email enviado");
    }

    @Override
    public void sendHtmlEmail(MimeMessage msg) {
        LOGGER.info("Enviando email...");
        javaMailSender.send(msg);
        LOGGER.info("Email enviado");
    }

    @Override
    public void sendNewPasswordEmail(Cliente cliente, String newPass) {

    }
}
