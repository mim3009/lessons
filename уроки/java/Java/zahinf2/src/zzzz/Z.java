package zzzz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Z {

	static String[] alpha = new String[34];
	static String[] beta = new String[34];
	static Scanner scn;
	static Formatter x;
	static Scanner scn2;

	public static void main(String[] args) throws FileNotFoundException {
		String str = "";

		scn2 = new Scanner(System.in);
		System.out.println("������� �:");
		int a1 = (int) Double.parseDouble(scn2.next());
		System.out.println("������� b:");
		int b1 = (int) Double.parseDouble(scn2.next());
		System.out.println("������� m:");
		int m1 = (int) Double.parseDouble(scn2.next());
		scn2.close();

		zapoln(a1, b1, m1);

		try {
			scn = new Scanner(new File("res//1.txt"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���� �� ������");
		}
		;

		while (scn.hasNext()) {
			String a = scn.next();
			int b = a.length();
			for (int j = 0; j < b; j++) {
				char c = a.charAt(j);
				for (int i = 0; i < 33; i++) {
					if (String.valueOf(c).toLowerCase().equals(alpha[i])) {
						str = str + beta[i];
					}
				}
			}
			str = str + " ";
		}
		scn.close();
		x = new Formatter("res//2.txt");
		x.format(str, null);
		x.close();

	}

	public static void zapoln(int aa, int bb, int mm) {
		alpha[0] = "�";
		alpha[1] = "�";
		alpha[2] = "�";
		alpha[3] = "�";
		alpha[4] = "�";
		alpha[5] = "�";
		alpha[6] = "�";
		alpha[7] = "�";
		alpha[8] = "�";
		alpha[9] = "�";
		alpha[10] = "�";
		alpha[11] = "�";
		alpha[12] = "�";
		alpha[13] = "�";
		alpha[14] = "�";
		alpha[15] = "�";
		alpha[16] = "�";
		alpha[17] = "�";
		alpha[18] = "�";
		alpha[19] = "�";
		alpha[20] = "�";
		alpha[21] = "�";
		alpha[22] = "�";
		alpha[23] = "�";
		alpha[24] = "�";
		alpha[25] = "�";
		alpha[26] = "�";
		alpha[27] = "�";
		alpha[28] = "�";
		alpha[29] = "�";
		alpha[30] = "�";
		alpha[31] = "�";
		alpha[32] = "�";
		alpha[33] = " ";

		int l = gcd(aa, mm);
		if (l == 1) {
			for (int i = 0; i < alpha.length - 1; i++) {
				beta[i] = alpha[(aa * i + bb) % mm];
				System.out.println(beta[i] + " " + i);
			}
			beta[33] = "&";
		} else {
			System.out.println("��������� ��������� �� �����");
		}

		/*
		 * for (int i = 0; i < alpha.length - 1; i++) { beta[i] = alpha[(aa * i
		 * + bb) % mm]; System.out.println(beta[i] + " " + i); } beta[33] = "&";
		 */
		/*
		 * beta[0]="�"; beta[1]="�"; beta[2]="�"; beta[3]="�"; beta[4]="�";
		 * beta[5]="�"; beta[6]="�"; beta[7]="�"; beta[8]="�"; beta[9]="�";
		 * beta[10]="�"; beta[11]="�"; beta[12]="�"; beta[13]="�"; beta[14]="�";
		 * beta[15]="�"; beta[16]="�"; beta[17]="�"; beta[18]="�"; beta[19]="�";
		 * beta[20]="�"; beta[21]="�"; beta[22]="�"; beta[23]="�"; beta[24]="�";
		 * beta[25]="�"; beta[26]="�"; beta[27]="�"; beta[28]="�"; beta[29]="�";
		 * beta[30]="�"; beta[31]="�"; beta[32]="�"; beta[33]="&";
		 */
	}

	private static int gcd(int a1, int m1) {
		while (a1 != 0 && m1 != 0) {
			if (a1 > m1) {
				a1 %= m1;
			} else {
				m1 %= a1;
			}
		}
		return a1 + m1;
	}
}
