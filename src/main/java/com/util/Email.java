package com.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Email {

    public void  sendEmails(String addressee,int code){
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.163.com");//邮箱的SMTP服务器
            email.setCharset("UTF-8");//设置发送的类型
            email.addTo(addressee);//设置收件人
            email.setFrom("weirong2848@163.com");//设置发件人
            email.setAuthentication("weirong2848@163.com", "KJYBLZHSWQVYOXOS");//设置发件人的邮箱和授权密码
            email.setSubject("注册验证码");//设置发送主题
            email.setMsg("此验证码（"+code+"）仅用于注册，千万不要告诉别人哦！");//设置发送内容
            email.send();//进行发送
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
