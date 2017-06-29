package projetCERFA.Model.Entity;

import java.util.ArrayList;

import projetCERFA.Model.Int.ICoursesTimes;
import projetCERFA.Model.Int.IProfessors;

public class Professors extends Personn implements IProfessors {
	
	private boolean interne;
	private int id;
	private ArrayList<ICoursesTimes> coursesTimesList;

	public Professors(String firstname, String secondname, boolean interne) {
		super(firstname, secondname);
		this.interne = interne;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IProfessors#getInterne()
	 */
	@Override
	public boolean getInterne(){
		return this.interne;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IProfessors#getId()
	 */
	@Override
	public int getId(){
		return this.id;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IProfessors#setInterne(boolean)
	 */
	@Override
	public void setInterne(boolean interne){
		this.interne = interne;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IProfessors#setId(int)
	 */
	@Override
	public void setId(int id){
		this.id = id;
	}
	
	public ArrayList<ICoursesTimes> getCoursesTimesList() {
		return coursesTimesList;
	}
}
