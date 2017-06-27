package projetCERFA.Model;

public class Specialties {
	
	private String nom;
	private String code;
	private int id;
	
	public Specialties(String nom, String code){
		this.setNom(nom);
		this.setCode(code);
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}

