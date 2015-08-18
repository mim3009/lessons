package stn.cn.ua;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class SendMail {
	
	public static void main(String[] args) {
		Properties properties = new Properties();
		File f = new File("mail.properties");
		if (f.exists()) {
			try {
				System.out.println("Loading properties file 'mail.properties'");
				properties.load(new FileInputStream(f));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("file mail.properties does not exists");
			System.exit(0);
		}

		MailSender mail = new MailSender();
		mail.setFrom(properties.getProperty("email.from"));
		mail.setTo(properties.getProperty("email.to"));
		mail.setSmtpServer(properties.getProperty("mail.smtp.server"));	
		mail.setSubject("L7");
		mail.setFile(f);
		mail.setMailProperties(properties);
		mail.run();
	}
	
}
