
public class Group extends AnyData {
	
	String starosta;
	public Group(String name, String starosta) {
		super(name);
		this.starosta = starosta;
	}

	@Override
	public IDlg showSonDialog() {
		Student g = new Student();
		g.setVisible(true);
		return g;
	}
		
	@Override
	public IDlg showDialog(boolean b) {
		DlgGroup d = new DlgGroup(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}

}
