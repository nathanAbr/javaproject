package projetCERFA.Model.Entity;

import projetCERFA.Model.Int.ISpecialties;

public class Specialties implements ISpecialties {
	
	private String nom;
	private String code;
	private int id;
	
	public Specialties(String nom, String code){
		this.setNom(nom);
		this.setCode(code);
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ISpecialties#getNom()
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ISpecialties#setNom(java.lang.String)
	 */
	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ISpecialties#getCode()
	 */
	@Override
	public String getCode() {
		return code;
	}

	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ISpecialties#setCode(java.lang.String)
	 */
	@Override
	public void setCode(String code) {
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ISpecialties#getId()
	 */
	@Override
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ISpecialties#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}	
}

