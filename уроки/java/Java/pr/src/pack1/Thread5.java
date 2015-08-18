package pack1;

//совместный доступ к обьектам//

public class Thread5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Info i = new Info();
		MyWriter w = new MyWriter(i);
		MyReader r = new MyReader(i);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}

		w.stop();
		r.stop();
	}

}