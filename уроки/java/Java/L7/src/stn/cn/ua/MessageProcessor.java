package stn.cn.ua;
	
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
	
public class MessageProcessor extends Thread{

		private volatile boolean status = true;
		// ThreadPool для запуска задач для посылки писем c количеством Thread-ов - 5
		private ExecutorService executor;
		private Queue<MailInfo> queue;
		private Properties mailProperties;
	 	
		public MessageProcessor() {
			super();
		}
		
		public void run(){
			while (status){
				MailInfo mailInfo = null;

				// синхронизация доступа к очереди
				synchronized (queue) {
					mailInfo = queue.poll();
				}
				
				if (mailInfo != null){
					if (mailInfo.getFile().exists() == false) break;
					MailSender mailSender = new MailSender();
					mailSender.setSmtpServer(mailInfo.getSmtpServer());
					mailSender.setFrom(mailInfo.getFrom());
					mailSender.setTo(mailInfo.getTo());
					mailSender.setSubject(mailInfo.getSubject());
					mailSender.setFile(mailInfo.getFile());
					mailSender.setDaemon(true);
					mailSender.setMailProperties(mailProperties);
					executor.execute(mailSender);
				}
				try {
					sleep(20000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void needToStop() {
			this.status = false;
		}

		public Queue getQueue() {
			return queue;
		}

		@SuppressWarnings("unchecked")
		public void setQueue(Queue queue) {
			this.queue = queue;
		}

		public ExecutorService getExecutor() {
			return executor;
		}

		public void setExecutor(ExecutorService executor) {
			this.executor = executor;
		}

		public void setMailProperties(Properties mailProperties) {
			this.mailProperties = mailProperties;
		}
}
