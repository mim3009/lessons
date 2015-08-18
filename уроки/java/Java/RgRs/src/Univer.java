
public class Univer extends AnyData {
	
	transient String rectorName;
	int level;
	public Univer(String name, String rectorName, int level) {
		super(name);
		this.rectorName = rectorName;
		this.level = level;
	}
	@Override
	public IDlg showSonDialog() {
		DlgFclt d = new DlgFclt();
		d.setVisible(true);
		return d;
	}
	@Override
	public IDlg showDialog( boolean b) {
		DlgUniver d = new DlgUniver(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}

}
