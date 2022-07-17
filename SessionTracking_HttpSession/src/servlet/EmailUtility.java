package servlet;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {

	public static void sendEmail(String host, String port, final String senderEmail, final String senderName,
			final String pass, String recipientEmail, String subject, String message)
			throws AddressException, MessagingException, UnsupportedEncodingException {

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.protocols","TLSv1.2");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.ssl.trust", "*");

		// creates a new session with an authenticator
		/*
		 * Authenticator auth = new Authenticator() { public PasswordAuthentication
		 * getPasswordAuthentication() { return new PasswordAuthentication(senderName,
		 * pass); } };
		 */
		Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, pass);
            }
        });

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(senderEmail, senderName));
		InternetAddress[] toAddresses = { new InternetAddress(recipientEmail) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(message);

		// sends the e-mail
		Transport.send(msg);

	}
}
