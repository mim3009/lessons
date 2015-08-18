public class Faculty extends AnyData{

	String deanName;
	public Faculty(String s1, String s2) {
		super(s1);
		this.deanName = s2;
	}
	@Override
	public IDlg showSonDialog() {
		DlgDept d = new DlgDept();
		d.setVisible(true);
		return d;

	}
	@Override
	public IDlg showDialog(boolean b) {
		DlgFclt d = new DlgFclt(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}
}
