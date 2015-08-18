package client;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import compute.Task;

public class Pass implements Task {

	String pass;
	static String md5;
	static String z;
	static String[] alpha = new String[26];

	public Pass(String pass) {
		this.pass = pass;
	}

	public Object execute() {
		return findPass(pass);
	}

	public Object execute2() {
		return findPass2(pass);
	}

	private String[] Razb(String s) {
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

	private Object findPass(String pass2) {
		zapoln();
		String[] str = Razb(pass2);
		md5 = str[0];
		String min = str[1];
		String max = str[2];
		String g = poisk();
		return g;
	}

	private Object findPass2(String pass2) {
		zapoln();
		String[] str = Razb(pass2);
		md5 = str[0];
		String min = str[1];
		String max = str[2];
		String g = poisk2();
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

	private static String poisk2() {
		for (int l = 26; l > 0; l--) {
			for (int k = 26; k > 0; k--) {
				for (int j = 26; j > 0; j--) {
					for (int i = 26; i > 0; i--) {
						for (int p = 26; p > 0; p--) {
							String str = alpha[l] + alpha[k] + alpha[j]
									+ alpha[i] + alpha[p];
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
	}

}
