package zzzz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Z2 {

	static String[] arr = {  " ", "î", "è", "à", "í", "å", "ò", "ñ", "ð",
			"ê", "ë", "ì","â", "ó", "ä", "û", "ÿ", "ü", "á", "ï", "÷", "ã", "æ", "õ",
			"ç", "é", "ø", "þ", "ù", "ö", "ý", "ô", "ú"};
	static int[] mas2 = new int[34];
	static double[] mas3 = new double[34];
	static String[] al = new String[34];
	static String[] al2 = new String[34];
	
	static Scanner scn;
	static Formatter x;
	static Scanner scn2;

	public static void main(String[] args) throws FileNotFoundException {
		int kolbukw = 0;
		String str = "";
		zapoln();
		scn = new Scanner(new File("res//2.txt"));
		while (scn.hasNext()) {
			String a = scn.nextLine();
			kolbukw = kolbukw + a.length();
		}
		scn.close();
		System.out.println(kolbukw);

		scn2 = new Scanner(new File("res//2.txt"));
		while (scn2.hasNext()) {
			str = str + scn2.nextLine();
		}
		scn2.close();
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < al.length; j++) {
				if (al[j].equals(String.valueOf(str.charAt(i)).toLowerCase())) {
					mas2[j] += 1;
				}
			}
		}
		sort();
		
		for(int i = 0;i<mas2.length;i++){
			System.out.println(mas2[i]);
			System.out.println(al2[i] + " " + i);
		}
		String res = "";
		for(int i = 0; i < str.length(); i++){
			for(int j = 0; j < al2.length; j++){
				if(String.valueOf(str.charAt(i)).equals(al2[j])){
					res = res + arr[j];
				}
			}
		}
		
		x = new Formatter("res//3.txt");
		x.format(res, null);
		x.close();
	}
	
	public static void sort(){
		for (int i = 0; i < mas2.length; i++){
	        for (int j = i; j < mas2.length; j++){
	            if (mas2[i] < mas2[j]) {
	                int t = mas2[i];
	                mas2[i] = mas2[j];
	                mas2[j] = t;
	                String b = al2[i];
	                al2[i] = al2[j];
	                al2[j] = b;
	            }
	        }
	    }
	}
	
	public static void zapoln() {
		al[0] = "à";
		al[1] = "á";
		al[2] = "â";
		al[3] = "ã";
		al[4] = "ä";
		al[5] = "å";
		al[6] = "¸";
		al[7] = "æ";
		al[8] = "ç";
		al[9] = "è";
		al[10] = "é";
		al[11] = "ê";
		al[12] = "ë";
		al[13] = "ì";
		al[14] = "í";
		al[15] = "î";
		al[16] = "ï";
		al[17] = "ð";
		al[18] = "ñ";
		al[19] = "ò";
		al[20] = "ó";
		al[21] = "ô";
		al[22] = "õ";
		al[23] = "ö";
		al[24] = "÷";
		al[25] = "ø";
		al[26] = "ù";
		al[27] = "ú";
		al[28] = "û";
		al[29] = "ü";
		al[30] = "ý";
		al[31] = "þ";
		al[32] = "ÿ";
		al[33] = " ";
		
		al2[0] = "à";
		al2[1] = "á";
		al2[2] = "â";
		al2[3] = "ã";
		al2[4] = "ä";
		al2[5] = "å";
		al2[6] = "¸";
		al2[7] = "æ";
		al2[8] = "ç";
		al2[9] = "è";
		al2[10] = "é";
		al2[11] = "ê";
		al2[12] = "ë";
		al2[13] = "ì";
		al2[14] = "í";
		al2[15] = "î";
		al2[16] = "ï";
		al2[17] = "ð";
		al2[18] = "ñ";
		al2[19] = "ò";
		al2[20] = "ó";
		al2[21] = "ô";
		al2[22] = "õ";
		al2[23] = "ö";
		al2[24] = "÷";
		al2[25] = "ø";
		al2[26] = "ù";
		al2[27] = "ú";
		al2[28] = "û";
		al2[29] = "ü";
		al2[30] = "ý";
		al2[31] = "þ";
		al2[32] = "ÿ";
		al2[33] = " ";
	}
}
