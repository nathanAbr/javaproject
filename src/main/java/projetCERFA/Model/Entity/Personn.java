package projetCERFA.Model.Entity;

import projetCERFA.Model.Int.IPersonn;

public class Personn implements IPersonn {
	private String firstname;
	private String secondname;
	
	protected Personn(String firstname, String secondname){
		this.firstname = firstname;
		this.secondname = secondname;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IPersonn#getFirstName()
	 */
	@Override
	public String getFirstName(){
		return this.firstname;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IPersonn#getSecondName()
	 */
	@Override
	public String getSecondName(){
		return this.secondname;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IPersonn#setFirstName(java.lang.String)
	 */
	@Override
	public void setFirstName(String firstname){
		this.firstname = firstname;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IPersonn#setSecondName(java.lang.String)
	 */
	@Override
	public void setSecondName(String secondname){
		this.secondname = secondname;
	}
}
