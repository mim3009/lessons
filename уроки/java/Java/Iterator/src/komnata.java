import java.util.Vector;
import java.util.Iterator;

public class komnata implements Iterable<Computer> {
	private Vector<Computer> s;

	public komnata() {
		s = new Vector<Computer>();
	}

	public Iterator<Computer> iterator() {
		return s.iterator();
	}

	public void delOld(int oldy) {
		for (Iterator i = iterator(); i.hasNext();) {
			if (((Computer) i.next()).getData() < oldy) {
				i.remove();

			}

		}

	}

	public void addKom(Computer computer) {
		s.add(computer);
	}

	public void show() {
		System.out.println("Результат");
		for (Computer c : this)
			System.out.println(c);

	}
}
