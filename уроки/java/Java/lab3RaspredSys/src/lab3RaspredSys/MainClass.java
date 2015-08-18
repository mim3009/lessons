package lab3RaspredSys;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MainClass {

	static final ForkJoinPool mainPool = new ForkJoinPool();

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Введите мд5: ");
		String md5 = scn.nextLine();
		scn.close();
		long startTime = System.currentTimeMillis();
		RecursiveTask<Long> key = new FindKey(md5, 97, 122);
		long fk = mainPool.invoke(key);

		String h = String.valueOf(fk);
		String[] parts = h.split("6");
		String result = "";
		for (int i = 0; i < parts.length; i++) {
			int r = Integer.valueOf(parts[i]);
			result = result + String.valueOf((char) r);
		}
		System.out.println(result);
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("Поиск выполнялся " + timeSpent + " миллисекунд");
	}

}