package lab4;

public class Grup {

	private String Name;
	private int KolStud;
	private String FIOStar;
	
	public String getName(){
		return Name;
	}
	
	public void setName(String name){
		Name = name;
	}
	
	public int getKolStud() {
		return KolStud;
	}

	public void setKolStud(int kolstud) {
		KolStud = kolstud;
	}
	
	public String getFIO(){
		return FIOStar;
	}
	
	public void setFIOStar(String fiostar){
		FIOStar = fiostar;
	}
	
	
	public Grup(String name, int kolstud, String fiostar) {
		super();
		Name = name;
		KolStud = kolstud;
		FIOStar = fiostar;
	}
	
}
