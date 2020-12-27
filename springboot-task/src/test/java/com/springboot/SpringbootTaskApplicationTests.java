package com.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootTaskApplicationTests {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    /**
     * 测试发送普通邮件
     */
    @Test
    void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("springboot邮件");
        simpleMailMessage.setText("发送成功");
        simpleMailMessage.setFrom("2420222806@qq.com");
        simpleMailMessage.setTo("sun14741205521@163.com");
        javaMailSender.send(simpleMailMessage);
    }

    /**
     * 测试发送特殊邮件
     */
    @Test
    void test() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject("springboo邮件");
        mimeMessageHelper.setText("<p style='color:red'>发送成功111</p>",true);
        mimeMessageHelper.setFrom("2420222806@qq.com");
        mimeMessageHelper.setTo("sun14741205521@163.com");
        mimeMessageHelper.addAttachment("6.SSMAOP日志.pdf", new File("D:\\DownLoad\\6.SSMAOP日志.pdf"));
        javaMailSender.send(mimeMessage);
    }

}
