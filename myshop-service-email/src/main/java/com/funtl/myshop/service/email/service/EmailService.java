package com.funtl.myshop.service.email.service;

import com.funtl.myshop.commons.domain.TbUser;
import com.funtl.myshop.commons.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @StreamListener("input")
    public void receive(String json) {
        try {
            // 发送普通邮件
            TbUser tbUser = MapperUtils.json2pojo(json, TbUser.class);
            sendEmail("欢迎注册", "欢迎 " + tbUser.getUsername() + " 加入广州千锋大家庭！", tbUser.getEmail());

            // 发送 HTML 模板邮件
            Context context = new Context();
            context.setVariable("username", tbUser.getUsername());
            String emailTemplate = templateEngine.process("reg", context);
            sendTemplateEmail("欢迎注册", emailTemplate, tbUser.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送普通邮件
     * @param subject
     * @param body
     * @param to
     */
    @Async
    public void sendEmail(String subject, String body, String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(applicationContext.getEnvironment().getProperty("spring.mail.username"));
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }

    /**
     * 发送 HTML 模板邮件
     * @param subject
     * @param body
     * @param to
     */
    @Async
    public void sendTemplateEmail(String subject, String body, String to) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(applicationContext.getEnvironment().getProperty("spring.mail.username"));
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            javaMailSender.send(message);
        } catch (Exception e) {

        }
    }
}
