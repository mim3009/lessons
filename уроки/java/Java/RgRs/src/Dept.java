public class Dept extends AnyData{
	String chiefName;
	boolean spec;
	public Dept(String name, String cheafFio, boolean spec) {
		super(name);
		this.chiefName = cheafFio;
		this.spec = spec;
	}
	@Override
	public IDlg showSonDialog() {
		DlgGroup g = new DlgGroup();
		g.setVisible(true);
		return g;
	}
	
	@Override
	public IDlg showDialog( boolean b) {
		DlgDept d= new DlgDept(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}

}
