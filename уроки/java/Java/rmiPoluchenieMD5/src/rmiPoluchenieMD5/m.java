package rmiPoluchenieMD5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class m {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("¬ведите слово-пароль:");
		String key = scn.next();
		scn.close();
		String md5 = md5Custom(key);
		System.out.println(md5);
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
	 
	    while( md5Hex.length() < 32 ){
	        md5Hex = "0" + md5Hex;
	    }
	 
	    return md5Hex;
	}
	
}
