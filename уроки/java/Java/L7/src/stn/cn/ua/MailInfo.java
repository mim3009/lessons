package stn.cn.ua;

	import java.io.File;
	
public class MailInfo {

		private String smtpServer;
		private String from;
		private String to;
		private String subject;
		private File file;
		
		public MailInfo() {
			super();
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
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

		public String getSmtpServer() {
			return smtpServer;
		}

		public void setSmtpServer(String smtpServer) {
			this.smtpServer = smtpServer;
		}

		public File getFile() {
			return file;
		}

		public void setFile(File file) {
			this.file = file;
		}
}
