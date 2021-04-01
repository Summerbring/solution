package com.code.practise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * 邮件客户端
 *
 * @author Summer 2020/10/28 15:48
 */
@Component
public class MailClient {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     *  发送简单邮件
     * @param to 目标接收人邮箱
     * @param subject 主题
     * @param content 内容
     * @throws MailException
     */
    public void sendSimpleMail(String to, String subject, String content) throws MailException {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); // 邮件发送者
        message.setTo(to); // 邮件接受者
        message.setSubject(subject); // 主题
        message.setText(content); // 内容

        mailSender.send(message);

    }

}
