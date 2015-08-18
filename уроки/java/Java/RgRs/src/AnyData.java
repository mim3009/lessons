import java.io.Serializable;

public abstract class AnyData implements  Serializable{
	
	abstract IDlg showSonDialog();
	abstract IDlg showDialog(boolean b);

	
	 protected String name;

	public AnyData(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}