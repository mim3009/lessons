package stn.cn.ua;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

	public MainClass() {
		super();
	}

	/**
	 * производим создание и запуск процессов
	 * создаем объекты:
	 * messageCreator  - дл€ добавлени€ информации о письмах в очереди
	 * messageProcessor - дл€ выборки информации из очереди и ее обработки
	 * messageReceiver - дл€ получени€ письма с почтового €щика
	 * queue - очередь дл€ хранени€ информации о письмах
	 */
	public static void main(String[] args) {
        Properties properties = new Properties();
		File f = new File ("mail.properties");
        if (f.exists ()) {
            	try {
            		System.out.println("Loading properties file 'mail.properties'");
					properties.load (new FileInputStream(f));
				} catch (Exception e) {
					e.printStackTrace();
				}
        } else {
        	System.out.println("file mail.properties does not exists");
        	System.exit(0);
        }
        	
        // создаем очередь
		Queue<MailInfo> queue = new LinkedList<MailInfo>();
		// создаем экземпл€р объекта, который заносит в очередь информацию о письмах
		MessageCreator messageCreator = new MessageCreator();
		// создаем экземпл€р объекта, который выбирает из очереди информацию о письмах
		MessageProcessor messageProcessor = new MessageProcessor();
		// производим св€зывание объектов с созданной очередью
		ExecutorService exService = Executors.newFixedThreadPool(5);
		messageProcessor.setExecutor(exService);
		messageCreator.setMailProperties(properties);
		messageCreator.setQueue(queue);
		messageCreator.setDaemon(true);
		messageProcessor.setQueue(queue);
		messageProcessor.setMailProperties(properties);
		
		messageProcessor.setDaemon(true);
		// запускаем процессы на выполнениеы
		messageCreator.start();
		messageProcessor.start();
		MessageReceiver messageReceiver = new MessageReceiver();
		messageReceiver.setMailProperties(properties);
		messageReceiver.start();
		
		File newDir = new File("forSend");
		newDir.mkdir();
		
		System.out.println("Type 'bye' for exit program");
		System.out.println();
	    byte kbdInput[] = new byte[256];
	    String input;
		while (true){
			try {
				int count = System.in.read(kbdInput);
				input = new String(kbdInput, 0, count - 2);
				if (input.equals("bye")) break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (messageCreator.isAlive()) messageCreator.needToStop();
		if (messageProcessor.isAlive()) messageProcessor.needToStop();
		if (messageReceiver.isAlive()) messageReceiver.needToStop();
		exService.shutdown();
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
		}
	}

	
}
