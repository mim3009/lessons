package stn.cn.ua;

import java.util.Date;
import java.util.Properties;
import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender extends Thread{

	private String smtpServer;
	private String to;
	private String from;
	private String subject;
	private File file;
	private Properties mailProperties;
	private static String LONG_SPACE = "   ";  
	
	public MailSender() {
		super();
	}

	public MailSender(String smtpServer, String to, String from, String subject, String body) {
		super();
		this.smtpServer = smtpServer;
		this.to = to;
		this.from = from;
		this.subject = subject;
	}

	public void run() {
		try {
		      Properties props = System.getProperties();
		      props.setProperty("mail.host", smtpServer);
		      props.setProperty("mail.smtp.auth", "false");
		      Session session = Session.getDefaultInstance(props);

		      //session.setDebug(true);
		      Transport t = session.getTransport("smtp");
		      // ������� ����� ���������
		      Message msg = new MimeMessage(session);	      
		      // ������������� ���� ��:, ����:, ����:
		      msg.setFrom(new InternetAddress(from));
		      msg.setRecipient(Message.RecipientType.TO,
		    		  			new InternetAddress(to));
		      msg.setSubject(subject);

		      // ������� ������ ���������� ������ � ��������� ��� ����������
			  MimeBodyPart mbp1 = new MimeBodyPart();
			  mbp1.setText("Hello from JavaMail");

			  // ������� ������ ����� ������
			  MimeBodyPart mbp2 = new MimeBodyPart();

		      // ����������� ���� � ������
			  if (file.exists()){
		   	  FileDataSource fds = new FileDataSource(file); 
			  mbp2.setDataHandler(new DataHandler(fds));
			  mbp2.setFileName(fds.getName());

			  // ������� Multipart � ��������� � ���� �����
			  Multipart mp = new MimeMultipart();
			  mp.addBodyPart(mbp1);
			  mp.addBodyPart(mbp2);
			  // ��������� Multipart � ������
			  msg.setContent(mp);

			  msg.setSentDate(new Date());
		      msg.saveChanges();
		      // �������� ������
		      String login = null;
		      String passwd = null;
		      synchronized (mailProperties) {
			      login = mailProperties.getProperty("mail.smtp.login");
			      System.out.println(LONG_SPACE + " Using smtp.login: " + login);
			      passwd = mailProperties.getProperty("mail.smtp.passwd");
			      System.out.println(LONG_SPACE + " Using smtp.password: " + passwd);
		      }
		      if ((login != null)&&(passwd != null)){
		    	  t.connect(smtpServer, login, passwd);
		    	  t.sendMessage(msg, msg.getAllRecipients());
		    	  t.close();
		    	  file.delete();
		    	  System.out.println(LONG_SPACE + " Sending mail to " + to);
		    	  System.out.println(LONG_SPACE + "==================");
		      }
			  }
			} catch (Exception e){
				e.printStackTrace();
			}
		
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setMailProperties(Properties mailProperties) {
		this.mailProperties = mailProperties;
	}

	
}
