import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendOtp {
	int send(String s){
	 int otp=(int)(Math.random()*9000)+1000;
   	 String otpp=String.valueOf(otp);
         final String from = "raghavpartani1@gmail.com"; // change accordingly
         String to = s; // change accordingly

         // Get system properties
         Properties properties = new Properties();

         // Setup mail server

         properties.put("mail.smtp.auth", "true");
         properties.put("mail.smtp.starttls.enable", "true");

         properties.put("mail.smtp.host","smtp.gmail.com");
         properties.put("mail.smtp.port", 587);
     

         Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator()
       		  {
       	                protected PasswordAuthentication getPasswordAuthentication(){
       	                return new  PasswordAuthentication("iclaps01@gmail.com","Raghav@0512");
       	                }});
         try
         {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("This is a verification email!");

            // Now set the actual message
            message.setText("This is an email from indoreclap for verification your otp is"+otpp+".Your otp will be treated as your password.");

            // Send message
            Transport.send(message);
         }
         catch (Exception mex)
         {
            mex.printStackTrace();
         }
         return otp;
	}
	}