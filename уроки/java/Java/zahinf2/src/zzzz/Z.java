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
		System.out.println("¬ведите а:");
		int a1 = (int) Double.parseDouble(scn2.next());
		System.out.println("¬ведите b:");
		int b1 = (int) Double.parseDouble(scn2.next());
		System.out.println("¬ведите m:");
		int m1 = (int) Double.parseDouble(scn2.next());
		scn2.close();

		zapoln(a1, b1, m1);

		try {
			scn = new Scanner(new File("res//1.txt"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "файл не найден");
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
		alpha[0] = "а";
		alpha[1] = "б";
		alpha[2] = "в";
		alpha[3] = "г";
		alpha[4] = "д";
		alpha[5] = "е";
		alpha[6] = "Є";
		alpha[7] = "ж";
		alpha[8] = "з";
		alpha[9] = "и";
		alpha[10] = "й";
		alpha[11] = "к";
		alpha[12] = "л";
		alpha[13] = "м";
		alpha[14] = "н";
		alpha[15] = "о";
		alpha[16] = "п";
		alpha[17] = "р";
		alpha[18] = "с";
		alpha[19] = "т";
		alpha[20] = "у";
		alpha[21] = "ф";
		alpha[22] = "х";
		alpha[23] = "ц";
		alpha[24] = "ч";
		alpha[25] = "ш";
		alpha[26] = "щ";
		alpha[27] = "ъ";
		alpha[28] = "ы";
		alpha[29] = "ь";
		alpha[30] = "э";
		alpha[31] = "ю";
		alpha[32] = "€";
		alpha[33] = " ";

		int l = gcd(aa, mm);
		if (l == 1) {
			for (int i = 0; i < alpha.length - 1; i++) {
				beta[i] = alpha[(aa * i + bb) % mm];
				System.out.println(beta[i] + " " + i);
			}
			beta[33] = "&";
		} else {
			System.out.println("¬веденные параметры не верны");
		}

		/*
		 * for (int i = 0; i < alpha.length - 1; i++) { beta[i] = alpha[(aa * i
		 * + bb) % mm]; System.out.println(beta[i] + " " + i); } beta[33] = "&";
		 */
		/*
		 * beta[0]="е"; beta[1]="и"; beta[2]="м"; beta[3]="р"; beta[4]="ф";
		 * beta[5]="ш"; beta[6]="ь"; beta[7]="а"; beta[8]="д"; beta[9]="з";
		 * beta[10]="л"; beta[11]="п"; beta[12]="у"; beta[13]="ч"; beta[14]="ы";
		 * beta[15]="€"; beta[16]="г"; beta[17]="ж"; beta[18]="к"; beta[19]="о";
		 * beta[20]="т"; beta[21]="ц"; beta[22]="ъ"; beta[23]="ю"; beta[24]="в";
		 * beta[25]="Є"; beta[26]="й"; beta[27]="н"; beta[28]="с"; beta[29]="х";
		 * beta[30]="щ"; beta[31]="э"; beta[32]="б"; beta[33]="&";
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
