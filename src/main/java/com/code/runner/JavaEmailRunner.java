package com.code.runner;

import com.code.practise.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author Summer 2020/10/28 15:58
 */
//@Component
public class JavaEmailRunner implements ApplicationRunner {

    @Autowired
    private MailClient mailClient;

    private static final String qq = "1836090435@qq.com";

    private static final String wolwo = "chenzhijian@wolwobiotech.com";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        mailClient.sendSimpleMail(wolwo,"测试邮件发送","该邮件仅测试发送！");
    }
}
