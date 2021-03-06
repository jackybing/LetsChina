package com.ltca.util;


import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

public class SendEmailUtil {
    private static final Logger log = Logger.getLogger(SendEmailUtil.class);
    static final String from = (String) SpringUtil.getBean("letschina.from.email");
    static final String passwd = (String) SpringUtil.getBean("letschina.from.password");
    static final String letschina_HTTP_URL =(String) SpringUtil.getBean("letschina.http.url");
    static final String path =System.getProperty("user.dir");
    
    public static boolean sendMail(String emailAddr,String title,String message){
        Properties props = new Properties();
        props.put( "mail.smtp.auth",   "true");
        props.put("mail.smtp.host", "smtp.yeah.net");
        try {
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                            return new javax.mail.PasswordAuthentication(from,
                                    passwd);
                        }
                    });
            session.setDebug(true);
            InternetAddress fromAddr = new InternetAddress(from);
            InternetAddress toAddr = new InternetAddress(emailAddr);

            
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(fromAddr);
            msg.addRecipient(Message.RecipientType.TO, toAddr);
            msg.setSubject(title);
            msg.setSentDate(new Date());
            
            Multipart mp = new MimeMultipart();  
            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setContent(message.toString(), "text/html;charset=gb2312");
            mp.addBodyPart(mbp);
                      
            msg.setContent(mp);
            Transport.send(msg);
            return true;
        } catch (MessagingException mex) {
            if(log.isDebugEnabled()) {
                log.error("send failed, exception: " + mex);
            }
            return false;
        }
    }
    
    
    static String letschina_ACTIVE_TEXT;
    static String letschina_FIND_TEXT;
    static{
        letschina_ACTIVE_TEXT = 
            "USER_NAME，你好！" +
            "<br/>" +
            "<div>" +
            "欢迎你注册" +
            "<br/>" +
            "这是一封来自letschina网的注册确认信，请点击下面的链接地址，激活账号以完成注册：" +
            "<br/>" +
            "<a href='ACTIVE_URL'>ACTIVE_URL</a>" +
            "<br/>" +
            "（如果你无法点击此链接，请将以上地址复制到你的浏览器地址栏中，打开相应页面即可。）" +
            "<br/>" +
            "感谢您的支持，祝你使用愉快！" +
            "</div>" +
            "<br/>" +
            "<div style=''>letschina网团队（www.letschina.com.cn）</div>" +
            "<br/>" +
            "这是一封系统邮件，请勿回复" +
            "<br/>" +
            "——————————————————————————————" +
            "<br/>" +
            "letschina网 广告语" +
            "<br/>" +
            "http://www.letschina.com.cn" +
            "<br/>" +
            "客服信箱：" +
            "<br/>" +
            "客服QQ：";
        letschina_FIND_TEXT=
        	"USER_NAME，你好！" +
            "<br/>" +
            "<div>" +
            "欢迎你注册" +
            "<br/>" +
            "这是一封来自letschina网的找回密码确认信，请点击下面的链接地址，以便继续完成找回密码步骤：" +
            "<br/>" +
            "<a href='FIND_URL'>FIND_URL</a>" +
            "<br/>" +
            "（如果你无法点击此链接，请将以上地址复制到你的浏览器地址栏中，打开相应页面即可。）" +
            "<br/>" +
            "感谢您的支持，祝你使用愉快！" +
            "</div>" +
            "<br/>" +
            "<div style=''>letschina网团队（www.letschina.com.cn）</div>" +
            "<br/>" +
            "这是一封系统邮件，请勿回复" +
            "<br/>" +
            "<br/>" +
            "letschina网 广告语" +
            "<br/>" +
            "http://www.letschina.com.cn" +
            "<br/>" +
            "客服信箱：" +
            "<br/>" +
            "客服QQ：";
    }
    public static boolean sendActivateMail(String email,String name,long uid,String activateCode){
        if(log.isDebugEnabled()) log.debug("发送激活邮件");
        String text = letschina_ACTIVE_TEXT;
        String url = letschina_HTTP_URL+"/letschina/activate?uid=" + uid + "&activateCode=" + activateCode;
        text = text.replaceAll("USER_NAME", name);
        text = text.replaceAll("ACTIVE_URL", url);
        return SendEmailUtil.sendMail(email, "letschina网注册确认信", text);
    }
    public static boolean sendFindMail(String email,String name,String password,long uid){
    	if(log.isDebugEnabled()) log.debug("发送找回密码邮件");
    	String text = letschina_FIND_TEXT;
    	String url = letschina_HTTP_URL+"/setting/findPassword?uid=" + uid+"&password="+password;
    	text = text.replaceAll("USER_NAME", name);
        text = text.replaceAll("FIND_URL", url);
        return SendEmailUtil.sendMail(email, "letschina网找回密码确认信", text);
    }
}
