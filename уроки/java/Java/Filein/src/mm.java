import java.util.Formatter;
import java.util.Scanner;


public class mm {
	static Formatter x;
	static Scanner scn;
	
	public static void main(String args[]){
		try{
			x = new Formatter("res//2.txt");
			scn = new Scanner(System.in);
			System.out.println("������� ��� ���?");
			int a = (int)Double.parseDouble(scn.next());
			System.out.println("��� ��� �����?");
			String b = scn.next();
			System.out.println("��� �� ������?");
			String c = scn.next();
			x.format("���� ����� %s, � � %s, ��� %d ���", b,c,a);
			x.close();
		}catch (Exception e){};
	}

}
