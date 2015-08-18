package lab4;

public class Facult {
	
	private String Name;
	private int KolGroup;
	private int KolPrep;
	
	public String getName(){
		return Name;
	}
	
	public void setName(String name){
		Name = name;
	}
	
	public int getKolGroup() {
		return KolGroup;
	}

	public void setKolGroup(int kolgroup) {
		KolGroup = kolgroup;
	}
	
	public int getKolPrep() {
		return KolPrep;
	}
	
	public void setCntHouse(int kolprep) {
		KolPrep = kolprep;
	}
	
	public Facult(String name, int kolgroup, int kolprep) {
		super();
		Name = name;
		KolGroup = kolgroup;
		KolPrep = kolprep;
	}
	
}
