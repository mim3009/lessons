package lab3RaspredSys;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class FindKey extends RecursiveTask<Long> {

	Long sd = new Long(0);
	final String md5;
	final int lo;
	final int hi;

	FindKey(String md5, int lo, int hi) {
		this.md5 = md5;
		this.lo = lo;
		this.hi = hi;
	}

	@Override
	protected Long compute() {
		if (hi - lo < 2) {
			for (int i = lo; i < hi; i++) {
				for (int j = 97; j < 122; j++) {
					for (int k = 97; k < 122; k++) {
						for (int l = 97; l < 122; l++) {
							if (md5Custom(String.valueOf((char) i)).equals(md5)) {
								sd = (long) i;
							} else if (md5Custom(
									(String.valueOf((char) i))
											+ String.valueOf((char) j)).equals(
									md5)) {
								String g = String.valueOf(i) + "6"
										+ String.valueOf(j);
								sd = (long) Long.parseLong(g);
							} else if (md5Custom(
									(String.valueOf((char) i))
											+ String.valueOf((char) j)
											+ String.valueOf((char) k)).equals(
									md5)) {
								String g = String.valueOf(i) + "6"
										+ String.valueOf(j) + "6"
										+ String.valueOf(k);
								sd = (long) Long.parseLong(g);
							} else if (md5Custom(
									(String.valueOf((char) i))
											+ String.valueOf((char) j)
											+ String.valueOf((char) k)
											+ String.valueOf((char) l)).equals(
									md5)) {
								String g = String.valueOf(i) + "6"
										+ String.valueOf(j) + "6"
										+ String.valueOf(k) + "6"
										+ String.valueOf(l);
								sd = (long) Long.parseLong(g);
							}
						}
					}
				}
			}
			return sd;
		} else {
			int mid = (lo + hi) >>> 1;
			RecursiveTask<Long> left = new FindKey(md5, lo, mid);
			RecursiveTask<Long> right = new FindKey(md5, mid, hi);
			right.fork();
			return Math.max(left.invoke(), right.join());
		}
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

}