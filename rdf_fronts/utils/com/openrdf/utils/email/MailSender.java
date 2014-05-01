package com.openrdf.utils.email;  
  
import java.util.Date;   
import java.util.Properties;  
import javax.mail.Address;   
import javax.mail.BodyPart;   
import javax.mail.Message;   
import javax.mail.MessagingException;   
import javax.mail.Multipart;   
import javax.mail.Session;   
import javax.mail.Transport;   
import javax.mail.internet.InternetAddress;   
import javax.mail.internet.MimeBodyPart;   
import javax.mail.internet.MimeMessage;   
import javax.mail.internet.MimeMultipart;   
  
/**
 * Sender Mail
 * 
 * @description 本程序用于来自谢先斌毕业论文，如有使用请联系作�?�?发�?邮件
 * @URL 代码地址：http://github.com/openRDF/rdfcode
 * @dateTime 2014-3-22 下午7:43:59
 * @author XieXianbin
 * @email a.b@hotmail.com
 *
 */
public class MailSender  {
/**  
  * 以文本格式发送邮成功
  * @param senderMailBean 待发送的邮件的信�? 
  */   
    public boolean sendTextMail(MailSenderBean senderMailBean) {
      // 判断是否�?��身份认证   
      MyAuthenticator authenticator = null;   
      Properties pro = senderMailBean.getProperties();  
      if (senderMailBean.isValidate()) {
    	  // 如果�?��身份认证，则创建�?��密码验证�?  
    	  authenticator = new MyAuthenticator(senderMailBean.getUserName(), senderMailBean.getPassword());   
      }  
      // 根据邮件会话属�?和密码验证器构�?�?��发�?邮件的session   
      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);   
      try {
	      // 根据session创建�?��邮件消息   
	      Message mailMessage = new MimeMessage(sendMailSession);   
	      // 创建邮件发�?者地�?  
	      Address from = new InternetAddress(senderMailBean.getFromAddress());   
	      // 设置邮件消息的发送�?   
	      mailMessage.setFrom(from);   
	      // 创建邮件的接收�?地址，并设置到邮件消息中   
	      Address to = new InternetAddress(senderMailBean.getToAddress());   
	      mailMessage.setRecipient(Message.RecipientType.TO,to);   
	      // 设置邮件消息的主�?  
	      mailMessage.setSubject(senderMailBean.getSubject());   
	      // 设置邮件消息发�?的时�?  
	      mailMessage.setSentDate(new Date());   
	      // 设置邮件消息的主要内�?  
	      String mailContent = senderMailBean.getContent();   
	      mailMessage.setText(mailContent);   
	      // 发�?邮件   
	      Transport.send(mailMessage);  
	      return true;
      } catch (MessagingException ex) {
          ex.printStackTrace();  
      }
      return false;   
    }
      
    /**  
      * 以HTML格式发�?邮件  
      * @param senderMailBean 待发送的邮件信息  
      */   
    public boolean sendHtmlMail(MailSenderBean senderMailBean){
      // 判断是否�?��身份认证   
      MyAuthenticator authenticator = null;  
      Properties pro = senderMailBean.getProperties();  
      //如果�?��身份认证，则创建�?��密码验证�?   
      if (senderMailBean.isValidate()) {
    	  authenticator = new MyAuthenticator(senderMailBean.getUserName(), senderMailBean.getPassword());  
      }
      // 根据邮件会话属�?和密码验证器构�?�?��发�?邮件的session   
      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);   
      try {
	      // 根据session创建�?��邮件消息   
	      Message mailMessage = new MimeMessage(sendMailSession);   
	      // 创建邮件发�?者地�?  
	      Address from = new InternetAddress(senderMailBean.getFromAddress());   
	      // 设置邮件消息的发送�?   
	      mailMessage.setFrom(from);   
	      // 创建邮件的接收�?地址，并设置到邮件消息中   
	      Address to = new InternetAddress(senderMailBean.getToAddress());   
	      // Message.RecipientType.TO属�?表示接收者的类型为TO   
	      mailMessage.setRecipient(Message.RecipientType.TO,to);   
	      // 设置邮件消息的主�?  
	      mailMessage.setSubject(senderMailBean.getSubject());   
	      // 设置邮件消息发�?的时�?  
	      mailMessage.setSentDate(new Date());   
	      // MiniMultipart类是�?��容器类，包含MimeBodyPart类型的对�?  
	      Multipart mainPart = new MimeMultipart();   
	      // 创建�?��包含HTML内容的MimeBodyPart   
	      BodyPart html = new MimeBodyPart();   
	      // 设置HTML内容
	      html.setContent(senderMailBean.getContent(), "text/html; charset=utf-8");   
	      mainPart.addBodyPart(html);   
	      // 将MiniMultipart对象设置为邮件内�?  
	      mailMessage.setContent(mainPart);   
	      // 发�?邮件   
	      Transport.send(mailMessage);   
	      return true;   
      } catch (MessagingException ex) {
          ex.printStackTrace();   
      }
      return false;   
    }
}