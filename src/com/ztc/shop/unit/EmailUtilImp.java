package com.ztc.shop.unit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

/**
 * Description：用来实现邮件的发送
 * Created by ZTCJoe on 2016/10/3.
 */
@Component("emailUtil")
public class EmailUtilImp implements EmailUtil {
    @Value("#{prop.subject}")
    private  String subject="";
    @Value("#{prop.charset}")
    private String charset="";
    @Value("#{prop.sendEmail}")
    private String sendEmail="";
    @Value("#{prop.emailHost}")
    private String emailHost="";
    @Value("#{prop.emailName}")
    private String emailName="";
    @Value("#{prop.emailPass}")
    private String emailPass="";
    @Value("#{prop.mailProtocol}")
    private String mailProtocol="";
    @Value("#{prop.mailType}")
    private String mailType="";

    public void sendEmail(String emailAddress,String id){
        Properties properties=new Properties();
        Session session=null;
       javax.mail.Message message=null;
        Transport transaction=null;
        try{
            // 此属性在getDefaultInstance方法说明中查找
            properties.setProperty(mailProtocol, mailType);
            // 根据配置文件获取一个session会话
            session=Session.getDefaultInstance(properties);
            // 设置debug格式
            session.setDebug(true);
            // 创建一个邮件对象
            message=new MimeMessage(session);
            // 设置邮件的标题
            message.setSubject(subject);
            //正文
            message.setContent("订单"+id+"已支付成功",charset);
            //发件人邮箱
            message.setFrom(new InternetAddress(sendEmail));
            // 通过sesion获取邮件传输对象
            transaction=session.getTransport();
            // 连接到邮件服务器
            transaction.connect(emailHost,emailName,emailPass);
            //收件人地址
            transaction.sendMessage(message,new Address[]{new InternetAddress(emailAddress)});
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try{
                transaction.close();
            }catch (MessagingException e){
                throw new RuntimeException(e);

            }
        }
    }
}
