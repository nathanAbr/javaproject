package projetCERFA.Model;

public class Personn {
	private String firstname;
	private String secondname;
	
	protected Personn(String firstname, String secondname){
		this.firstname = firstname;
		this.secondname = secondname;
	}
	
	public String getFirstName(){
		return this.firstname;
	}
	
	public String getSecondName(){
		return this.secondname;
	}
	
	public void setFirstName(String firstname){
		this.firstname = firstname;
	}
	
	public void setSecondName(String secondname){
		this.secondname = secondname;
	}
}
