package esdgf;

public class sdf {

	public static void main(String[] args) {
		int a = 21;
		int cnt = 0;
		while(a > 0){
			cnt += a % 2;
			a /= 2;
		}
		System.out.println(cnt);
	}

}
