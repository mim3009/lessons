package client;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class sa {

	static String md5;
	static String z;
	static String[] alpha = new String[83];

	public static void main(String[] args) {
		String s = "ef630d62cfbb555d aaaa zzzz";
		zapoln();
		String ss = findPass(s);
		System.out.println(ss);
	}

	private static String[] Razb(String s) {
		String[] ss = s.split(" ");
		return ss;
	}

	public static String md5Custom(String st) {
		MessageDigest messageDigest = null;
		byte[] digest = new byte[0];

		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(st.getBytes());
			digest = messageDigest.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		BigInteger bigInt = new BigInteger(1, digest);
		String md5Hex = bigInt.toString(16);

		while (md5Hex.length() < 32) {
			md5Hex = "0" + md5Hex;
		}

		return md5Hex;
	}

	private static String findPass(String pass2) {
		String[] str = Razb(pass2);
		md5 = str[0];
		String min = str[1];
		String max = str[2];
		String g = poisk();
		return g;
	}

	private static String poisk() {
		for (int l = 0; l < 26; l++) {
			for (int k = 0; k < 26; k++) {
				for (int j = 0; j < 26; j++) {
					for (int i = 0; i < 26; i++) {
						for (int p = 0; p < 26; p++) {
							for (int o = 0; o < 26; o++) {
								for (int u = 0; u < 26; u++) {
									for (int y = 0; y < 26; y++) {
										for (int t = 0; t < 26; t++) {

											String str = alpha[l] + alpha[k]
													+ alpha[j] + alpha[i]
													+ alpha[p] + alpha[o]
													+ alpha[u] + alpha[y]
													+ alpha[t];
											String ss = md5Custom(str);
											if (ss.equals(md5)) {
												z = str;
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return z;
	}

	public static void zapoln() {
		alpha[0] = "a";
		alpha[1] = "b";
		alpha[2] = "c";
		alpha[3] = "d";
		alpha[4] = "e";
		alpha[5] = "f";
		alpha[6] = "g";
		alpha[7] = "h";
		alpha[8] = "i";
		alpha[9] = "j";
		alpha[10] = "k";
		alpha[11] = "l";
		alpha[12] = "m";
		alpha[13] = "n";
		alpha[14] = "o";
		alpha[15] = "p";
		alpha[16] = "q";
		alpha[17] = "r";
		alpha[18] = "s";
		alpha[19] = "t";
		alpha[20] = "u";
		alpha[21] = "v";
		alpha[22] = "w";
		alpha[23] = "x";
		alpha[24] = "y";
		alpha[25] = "z";
		alpha[26] = "A";
		alpha[27] = "B";
		alpha[28] = "C";
		alpha[29] = "D";
		alpha[30] = "E";
		alpha[31] = "F";
		alpha[32] = "G";
		alpha[33] = "H";
		alpha[34] = "I";
		alpha[35] = "J";
		alpha[36] = "K";
		alpha[37] = "L";
		alpha[38] = "M";
		alpha[39] = "N";
		alpha[40] = "O";
		alpha[41] = "P";
		alpha[42] = "Q";
		alpha[43] = "R";
		alpha[44] = "S";
		alpha[45] = "T";
		alpha[46] = "U";
		alpha[47] = "V";
		alpha[48] = "W";
		alpha[49] = "X";
		alpha[50] = "Y";
		alpha[51] = "Z";
		alpha[52] = "'";
		alpha[53] = "[";
		alpha[54] = "]";
		alpha[55] = "(";
		alpha[56] = ")";
		alpha[57] = "{";
		alpha[58] = "}";
		alpha[59] = ":";
		alpha[60] = ",";
		alpha[61] = ".";
		alpha[62] = "-";
		alpha[63] = "!";
		alpha[64] = "?";
		alpha[65] = "<";
		alpha[66] = ">";
		alpha[67] = ";";
		alpha[68] = "/";
		alpha[69] = "\"";
		alpha[70] = "|";
		alpha[71] = " ";
		alpha[72] = "*";
		alpha[73] = "=";
		alpha[74] = "+";
		alpha[75] = "@";
		alpha[76] = "#";
		alpha[77] = "$";
		alpha[78] = "%";
		alpha[79] = "^";
		alpha[80] = "&";
		alpha[81] = "";
		alpha[82] = "/";
	}

}
