package intelmas.app.retriever.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import intelmas.app.retriever.service.ConstruramaMailService;
import intelmas.app.retriever.test.App;

@Service
public class ConstruramaMailServiceImpl implements ConstruramaMailService{
	
	private static final Logger LOG = Logger.getLogger(ConstruramaMailServiceImpl.class);
	private static final String MAIL_SMTP_SERVER = "mail.smtp.server";
	private static final String MAIL_SMTP_PORT = "mail.smtp.port";
	private static final String MAIL_SMTP_USER = "mail.smtp.user";
	private static final String MAIL_SMTP_PASSWORD = "mail.smtp.password";
	private static final String MAIL_FROM = "mail.from";
	
	@Override
	public void sendMail(String to, String cc, String bcc, String subject, String body) throws Exception {
	
		sendJavaMail(to, cc, bcc, subject, body, null);
	}

	@Override
	public void sendMail(String to, String cc, String bcc, String subject, String body, Map<String, String> attachments)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	private static void sendJavaMail(final String to, final String cc, final String bcc, final String subject, final String body,
			final Map<String, String> attachments)
			throws MessagingException
	{
		final String host = "smtp.gmail.com";
		final String port = "465";
		final String user = "pablousegreenj2ee@gmail.com";
		final String pass = "Loreto25gi";

		LOG.info("mail host=" + host);
		LOG.info("mail port=" + port);


		final Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

		final Session session = javax.mail.Session.getDefaultInstance(props, null);

		final MimeMessage message = new MimeMessage(session);

		final InternetAddress[] parseTo = InternetAddress.parse(to);

		for (int i = 0; i < parseTo.length; i++)
		{
			LOG.info("TO: " + parseTo[0].getAddress());
		}

		final InternetAddress[] parseCC = InternetAddress.parse(cc);
		for (int i = 0; i < parseCC.length; i++)
		{
			LOG.info("CC: " + parseCC[0].getAddress());
		}


		message.setFrom(new InternetAddress(MAIL_FROM));
		message.addRecipients(Message.RecipientType.TO, parseTo);

		if (!cc.trim().equals(""))
		{
			message.addRecipients(Message.RecipientType.CC, parseCC);
		}

		if (!bcc.trim().equals(""))
		{
			message.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
		}

		message.setSubject(subject, "UTF-8");
		message.setContent(body, "text/html; charset=UTF-8");

		if (attachments != null)
		{
			final Multipart multipart = new MimeMultipart();

			final Iterator it = attachments.entrySet().iterator();

			while (it.hasNext())
			{
				final Map.Entry pair = (Map.Entry) it.next();

				try
				{
					addAttachment(multipart, pair.getKey().toString(), pair.getValue().toString());
				}
				catch (final UnsupportedEncodingException e)
				{
					e.printStackTrace();
				}
			}

			message.setContent(multipart);
		}

		final Transport transport = session.getTransport("smtp");
		transport.connect(host, user, pass);
		Transport.send(message);
	}
	
	private static void addAttachment(final Multipart multipart, final String filename, final String attachment)
			throws MessagingException, UnsupportedEncodingException
	{
		final DataSource source = new ByteArrayDataSource(attachment.getBytes("UTF-8"), "application/octet-stream");
		final BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(filename);
		multipart.addBodyPart(messageBodyPart);
	}
	
	

		public void sendBasicMail (final String to, final String cc, final String bcc, final String subject, final String body) { 
			
			// change accordingly 
			final String username = "pablousegreenj2ee@gmail.com"; 
//			if(username == null || username.equals("")) {
//				username = "pablousegreenj2ee@gmail.com"; 
//			}
			
			// change accordingly 
			final String password = "Loreto25gi"; 
//			if(password == null || password.equals("")) {
//				password = "Loreto25gi"; 
//			}
			
			// or IP address 
			final String host = "localhost"; 
//			if(host == null || host.equals("")) {
//				host = "localhost"; 
//			}

			// Get system properties 
			Properties props = new Properties();			 
			
			// enable authentication 
			props.put("mail.smtp.auth", host);			 
			
			// enable STARTTLS 
			props.put("mail.smtp.starttls.enable", "true");	 
			
			// Setup mail server 
			props.put("mail.smtp.host", "smtp.gmail.com");	 
			
			// TLS Port 
			props.put("mail.smtp.port", "587");				 

			// creating Session instance referenced to 
			// Authenticator object to pass in 
			// Session.getInstance argument 
			Session session = Session.getInstance(props, 
			new javax.mail.Authenticator() { 
				
				//override the getPasswordAuthentication method 
				protected PasswordAuthentication 
							getPasswordAuthentication() { 
											
					return new PasswordAuthentication(username, 
													password); 
				} 
			}); 

			try { 
				
				// compose the message 
				// javax.mail.internet.MimeMessage class is 
				// mostly used for abstraction. 
				Message message = new MimeMessage(session);	 
				
				// header field of the header. 
				message.setFrom(new InternetAddress("pablousegreenj2ee@gmail.com")); 
				
				message.setRecipients(Message.RecipientType.TO, 
					InternetAddress.parse(to)); 
				message.setSubject(subject); 
				message.setText(body); 

				Transport.send(message);		 //send Message 

				System.out.println("Done"); 

			} catch (MessagingException e) { 
				throw new RuntimeException(e); 
			} 
		} 

		public void SendEmailUsingGMailSMTP(final String mailId, final String to, final String cc, final String bcc, final String subject, final String body) throws Exception {
		      // Recipient's email ID needs to be mentioned.
//		      String to = "xyz@gmail.com";//change accordingly
			  App app = new App();
		      // Sender's email ID needs to be mentioned
		      String from = "neorisqueretaroti@gmail.com";//change accordingly
		      final String username = "neorisqueretaroti@gmail.com";//change accordingly
		      final String password = "Loreto25gi";//change accordingly

		      // Assuming you are sending email through relay.jangosmtp.net
		      String host = "smtp.gmail.com";

		      Properties props = new Properties();
		      props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.starttls.enable", "true");
		      props.put("mail.smtp.host", host);
		      props.put("mail.smtp.socketFactory.port", "465");
//		      props.put("mail.smtp.port", "587");
		      props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//		      props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.port", "465");


		      // Get the Session object.
		      Session session = Session.getInstance(props,
		      new javax.mail.Authenticator() {
		         protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(username, password);
		         }
		      });

		      try {
		         // Create a default MimeMessage object.
		         Message message = new MimeMessage(session);
		       
		         // Set From: header field of the header.
		         message.setFrom(new InternetAddress(from));

		         // Set To: header field of the header.
		         message.setRecipients(Message.RecipientType.TO,
		         InternetAddress.parse(to));

		         // Set Subject: header field
		         message.setSubject(subject);
		         
		         //we will get the correct format in html
		         
		         // Now set the actual message
//		         System.out.println("200 BEFORE SEND MAIL BODY: "+app.buildingHTMLMailArray(body));
		         message.setContent(app.buildingHTMLMailArray(mailId, body),"text/html; charset=utf-8");

		         // Send message
		         Transport.send(message);

		         System.out.println("Sent message successfully....");

		      } catch (MessagingException e) {
		            throw new RuntimeException(e);
		      }
		}	
		
}
