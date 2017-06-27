package projetCERFA.Model;

public class Trainings {
	private String name;
	private int id;
	private int idTarget;
	private int idSpecialitie;
	
	public Trainings(String name, int idTarget, int idSpecialitie){
		this.setName(name);
		this.setIdTarget(idTarget);
		this.setIdSpecialitie(idSpecialitie);
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdTarget() {
		return this.idTarget;
	}
	public void setIdTarget(int idTarget) {
		this.idTarget = idTarget;
	}
	public int getIdSpecialitie() {
		return this.idSpecialitie;
	}
	public void setIdSpecialitie(int idSpecialitie) {
		this.idSpecialitie = idSpecialitie;
	}
	
	
}
