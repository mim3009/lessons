package lab4;

public class Stud {

	private String Name;
	private int Age;
	private int Srbal;

	public String getName(){
		return Name;
	}
	
	public void setName(String name){
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getSrbal() {
		return Srbal;
	}

	public void setSrbal(int srbal) {
		Srbal = srbal;
	}

	
	public Stud(String name, int age, int srbal) {
		super();
		Name = name;
		Age = age;
		Srbal = srbal;
		}
	
}
