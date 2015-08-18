package stn.cn.ua;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class MessageReceiver extends Thread{

	private Properties mailProperties;
	private volatile boolean status = true;

	public MessageReceiver() {
		super();
	}

	public void run() {
		Properties props = System.getProperties();
          props.put("mail.pop3.apop.enable",true);
		Session session = Session.getDefaultInstance(props);
		// session.setDebug(true);
		int delay = 60000;

		while (status) {
			Store store = null;
			Folder folder = null;
			try {
				// получаем хранилище
				store = session.getStore("pop3");
				// пробуем подсоединиться
				String pop3server = null;
				String login = null;
				String passwd = null;
				synchronized (mailProperties) {
					pop3server = mailProperties.getProperty("mail.pop3.server");
					System.out.println("Using pop3.server: " + pop3server);
					login = mailProperties.getProperty("mail.pop3.login");
					System.out.println("Using pop3.login: " + login);
					passwd = mailProperties.getProperty("mail.pop3.passwd");
					System.out.println("Using pop3.password: " + passwd);
					String delayTemp = mailProperties.getProperty("mail.pop3.delay");
					if (delayTemp != null) {
						delay = Integer.parseInt(delayTemp);
					}
				}
				if ((pop3server != null) && (login != null) && (passwd != null)) {
					System.out.println("Retreive mail from pop3 folder");
					store.connect(pop3server, login, passwd);
					folder = store.getFolder("INBOX");
					folder.open(Folder.READ_WRITE);
					// получаем список ссобщений
					Message messages[] = folder.getMessages();
					if (messages.length > 0) {
						// выводи некоторые параметры письма
						Address address[] = messages[0].getFrom();
						System.out.println("From: " + address[0].toString());
						System.out.println("Subject: "
								+ messages[0].getSubject());
						Object cont = messages[0].getContent();
						if (cont instanceof Multipart) {
							Multipart mp = (Multipart) cont;
							BodyPart bp = null;
							try {
								bp = mp.getBodyPart(0);
								if (bp.isMimeType("text/plain")) {
									System.out.println("Body:");
									System.out.println((String) bp.getContent());
								} else if (bp.isMimeType("multipart/*")) {
									System.out.println("This is a Multipart");
									System.out
											.println("---------------------------");
								} else if (bp.isMimeType("message/rfc822")) {
									System.out
											.println("This is a Nested Message");
									System.out
											.println("---------------------------");
								} else {
									Object o = bp.getContent();
									if (o instanceof String) {
										System.out.println((String) o);
									} else if (o instanceof InputStream) {
										InputStream is = (InputStream) o;
										int c;
										while ((c = is.read()) != -1)
											System.out.write(c);
									} else {
										System.out
												.println("This is an unknown type");
										System.out
												.println("---------------------------");
										System.out.println(o.toString());
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							System.out.println("===========");
							// устанавливаем признак удаления письма
							messages[0].setFlag(Flags.Flag.DELETED, true);
							// закрываем folder при этом удаляя письма
							folder.close(true);
							store.close();
						}
					} else
						System.out.println("there are no mail in inbox folder");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				sleep(delay);
			} catch (InterruptedException e) {
			} // while (true)
		}
	}

	public void needToStop(){
		this.status = false;
	}
	
	public void setMailProperties(Properties mailProperties) {
		this.mailProperties = mailProperties;
	}

	
}
