package zzzz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Z2 {

	static String[] arr = {  " ", "�", "�", "�", "�", "�", "�", "�", "�",
			"�", "�", "�","�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
			"�", "�", "�", "�", "�", "�", "�", "�", "�"};
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
		al[0] = "�";
		al[1] = "�";
		al[2] = "�";
		al[3] = "�";
		al[4] = "�";
		al[5] = "�";
		al[6] = "�";
		al[7] = "�";
		al[8] = "�";
		al[9] = "�";
		al[10] = "�";
		al[11] = "�";
		al[12] = "�";
		al[13] = "�";
		al[14] = "�";
		al[15] = "�";
		al[16] = "�";
		al[17] = "�";
		al[18] = "�";
		al[19] = "�";
		al[20] = "�";
		al[21] = "�";
		al[22] = "�";
		al[23] = "�";
		al[24] = "�";
		al[25] = "�";
		al[26] = "�";
		al[27] = "�";
		al[28] = "�";
		al[29] = "�";
		al[30] = "�";
		al[31] = "�";
		al[32] = "�";
		al[33] = " ";
		
		al2[0] = "�";
		al2[1] = "�";
		al2[2] = "�";
		al2[3] = "�";
		al2[4] = "�";
		al2[5] = "�";
		al2[6] = "�";
		al2[7] = "�";
		al2[8] = "�";
		al2[9] = "�";
		al2[10] = "�";
		al2[11] = "�";
		al2[12] = "�";
		al2[13] = "�";
		al2[14] = "�";
		al2[15] = "�";
		al2[16] = "�";
		al2[17] = "�";
		al2[18] = "�";
		al2[19] = "�";
		al2[20] = "�";
		al2[21] = "�";
		al2[22] = "�";
		al2[23] = "�";
		al2[24] = "�";
		al2[25] = "�";
		al2[26] = "�";
		al2[27] = "�";
		al2[28] = "�";
		al2[29] = "�";
		al2[30] = "�";
		al2[31] = "�";
		al2[32] = "�";
		al2[33] = " ";
	}
}
