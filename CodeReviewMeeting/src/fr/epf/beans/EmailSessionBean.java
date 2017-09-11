package fr.epf.beans;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.epf.Protocol;
import fr.epf.dao.MemberDAO;
import fr.epf.dao.PromotionDAO;
import fr.epf.models.Member;

@Stateless
@LocalBean
public class EmailSessionBean {
	@Inject
	private MemberDAO memberDAO;

	private int port = 465;
	private String host = "smtp.free.fr";
	private String from = "donotreply.codereviewmeeting@epf.fr";
	private Protocol protocol = Protocol.SMTPS;
	private boolean debug = true;

	public EmailSessionBean() {
		
	}
	public void sendEmail(String reviewName, String reviewDate, String reviewDescription, List<Member> promo){
		String body = "test";
		String subject ="New Code Review added";
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		switch (protocol) {
		case SMTPS:
			props.put("mail.smtp.ssl.enable", true);
			break;
		case TLS:
			props.put("mail.smtp.starttls.enable", true);
			break;
		}
		Session session = Session.getInstance(props, null);
		session.setDebug(debug);				

		for(Member member : promo) {
			String destinator = member.getEmail();		 
			MimeMessage message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress(from));
				InternetAddress[] address = {new InternetAddress(destinator)};
				message.setRecipients(Message.RecipientType.TO, address);
				message.setSubject(subject);
				message.setSentDate(new Date());
				// message.setText(body);
				Multipart multipart = new MimeMultipart("alternative");
				MimeBodyPart textPart = new MimeBodyPart();
				String textContent = "Hi, Nice to meet you!";
				textPart.setText(textContent);
				MimeBodyPart htmlPart = new MimeBodyPart();
				String htmlContent = createHTMLContent(reviewName, reviewDate, reviewDescription, member.getName());
				htmlPart.setContent(htmlContent, "text/html");
				multipart.addBodyPart(textPart);
				multipart.addBodyPart(htmlPart);
				message.setContent(multipart);
				//
				Transport.send(message);
			} catch (MessagingException ex) {
				ex.printStackTrace();
			}
		}
	}
	public String createHTMLContent(String reviewName, String reviewDate, String reviewDescription, String memberName) {
		String htmlContent;
		htmlContent = "<html><h1>Hello " + memberName + "</h1>";
		htmlContent = htmlContent + "<p>The review <strong>'"+ reviewName + "'</strong> has been added to your timetable.</p>";
		htmlContent = htmlContent + "<p>Scheduled date is " + reviewDate+ "</p>";
		htmlContent = htmlContent + "</html>";
		
		return htmlContent;
	}

}
