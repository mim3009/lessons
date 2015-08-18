package stn.cn.ua;

	import java.io.File;
	import java.util.Properties;
	import java.util.Queue;
	
public class MessageCreator extends Thread {
	
		private volatile boolean status = true;
		private Queue<MailInfo> queue;
		private Properties mailProperties;
		
		public MessageCreator() {
			super();
		}
		
		public void run(){
			while (status){
				MailInfo mailInfo = new MailInfo();
				try {
					String dirName = "forSend";
					File dirFile = new File(dirName);
					if ((dirFile == null)|| (dirFile.isDirectory() == false))
					{
						// не найден каталог, из которого выбираються файлы для отправки
						break;
					}
					String fileList[] = dirFile.list();
					for (int i = 0; i < fileList.length; i++){
						File newFile = new File(dirName + "/" + fileList[i]);
						if ((newFile != null) && (newFile.isDirectory() == false)) {
							mailInfo.setFile(newFile);
							String smtpServer = null;
							String from = null;
							String to = null;
							synchronized (mailProperties) {
								smtpServer = mailProperties.getProperty("smtpserver");
								from = mailProperties.getProperty("from");
								to = mailProperties.getProperty("to");
							}
							if ((smtpServer != null)&&(from != null)&&(to != null)){
							mailInfo.setSmtpServer(smtpServer);
							mailInfo.setFrom(from);
							mailInfo.setTo(to);
							mailInfo.setSubject("Testing " +"JavaMail");
						
							// синхронизация доступа к очереди
							synchronized (queue) {
								this.queue.offer(mailInfo);
							}
							}
						}
						sleep(2000);
					}
					
					sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void needToStop() {
			this.status = false;
		}

		public void setQueue(Queue<MailInfo> queue) {
			this.queue = queue;
		}

		public void setMailProperties(Properties mailProperties) {
			this.mailProperties = mailProperties;
		}

}
