
public class Stud extends AnyData {

	String srbal;
	public Stud(String name, String srbal) {
		super(name);
		this.srbal = srbal;
	}

	@Override
	public IDlg showSonDialog() {
		// TODO Auto-generated method stub
		return null;
	}
		
	@Override
	public IDlg showDialog(boolean b) {
		Student d = new Student(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}

}

