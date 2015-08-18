import java.util.Scanner;

import javax.swing.JOptionPane;


public class Rezultat {
	static Scanner scn;
	public static void main(String[] args) {
		try{
		komnata k=new komnata();
		scn = new Scanner(System.in);
		System.out.println("¬ведите год изготовление первого компьютера");
		int a = (int)Double.parseDouble(scn.next());
		k.addKom(new Computer(a));
		System.out.println("¬ведите год изготовление второго компьютера");
		int b = (int)Double.parseDouble(scn.next());
		k.addKom(new Computer(b));
		System.out.println("¬ведите год изготовление третьего компьютера");
		int c = (int)Double.parseDouble(scn.next());
		k.addKom(new Computer(c));
		System.out.println("¬ведите год изготовление четвертого компьютера");
		int d = (int)Double.parseDouble(scn.next());
		k.addKom(new Computer(d));
		System.out.println("¬ведите год изготовление п€того компьютера");
		int e = (int)Double.parseDouble(scn.next());
		k.addKom(new Computer(e));
		k.show();
		k.delOld(2010);
		k.show();
		}catch (Exception g){JOptionPane.showMessageDialog(null, "¬водите число а не буквы");}
	}
}
