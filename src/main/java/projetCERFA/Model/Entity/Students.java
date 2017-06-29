package projetCERFA.Model.Entity;

import java.util.ArrayList;

import projetCERFA.Model.Int.ICoursesTimes;
import projetCERFA.Model.Int.IStudents;

public class Students extends Personn implements IStudents{

	private boolean interne;
	private int id;
	private ArrayList<ICoursesTimes> coursesTimesList;

	public Students(String firstname, String secondname, boolean interne) {
		super(firstname, secondname);
		this.interne = interne;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IStudents#getInterne()
	 */
	@Override
	public boolean getInterne(){
		return this.interne;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IStudents#getId()
	 */
	@Override
	public int getId(){
		return this.id;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IStudents#setInterne(boolean)
	 */
	@Override
	public void setInterne(boolean interne){
		this.interne = interne;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IStudents#setId(int)
	 */
	@Override
	public void setId(int id){
		this.id = id;
	}
	
	public ArrayList<ICoursesTimes> getCoursesTimesList() {
		return coursesTimesList;
	}
	
}
