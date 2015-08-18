import java.util.Formatter;
import java.util.Scanner;


public class mm {
	static Formatter x;
	static Scanner scn;
	
	public static void main(String args[]){
		try{
			x = new Formatter("res//2.txt");
			scn = new Scanner(System.in);
			System.out.println("Сколько вам лет?");
			int a = (int)Double.parseDouble(scn.next());
			System.out.println("Как вас зовут?");
			String b = scn.next();
			System.out.println("Где вы живете?");
			String c = scn.next();
			x.format("Меня зовут %s, я с %s, мне %d лет", b,c,a);
			x.close();
		}catch (Exception e){};
	}

}
