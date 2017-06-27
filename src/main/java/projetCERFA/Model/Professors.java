package projetCERFA.Model;

public class Professors extends Personn {
	private boolean interne;
	private int id;
	
	public Professors(String firstname, String secondname, boolean interne) {
		super(firstname, secondname);
		this.interne = interne;
	}
	
	public boolean getInterne(){
		return this.interne;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setInterne(boolean interne){
		this.interne = interne;
	}
	
	public void setId(int id){
		this.id = id;
	}
}
