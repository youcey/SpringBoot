package com.spb.springboot.mailtools;

import com.spb.springboot.mailtools.MailContentTypeEnum;
import com.spb.springboot.mailtools.MailSender;

import java.util.ArrayList;

public class TestMail {
    public static void main(String[] args) throws Exception {
        new MailSender()
            .title("测试SpringBoot发送邮件")
            .content("简单文本内容发送")
            .contentType(MailContentTypeEnum.TEXT)
            .targets(new ArrayList<String>(){{
                add("yangjun@chinalawinfo.com");
            }})
            .send();
    }
}
