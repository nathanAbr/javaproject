package projetCERFA.Model.Proxy;

import projetCERFA.DAO.Int.StudentsDAO;
import projetCERFA.Model.Entity.Students;
import projetCERFA.Model.Factory.FactoryDAO;
import projetCERFA.Model.Int.IStudents;

public class StudentsProxy implements IStudents{
	private Students student = null;
	private int id;
	
	public StudentsProxy(int id){
		this.id = id;
	}

	public int getId() {
		this.isInstance();
		return this.student.getId();
	}

	public void setId(int id) {
		this.isInstance();
		this.student.setId(id);
	}
	
	@Override
	public boolean getInterne() {
		this.isInstance();
		return this.student.getInterne();
	}

	@Override
	public void setInterne(boolean interne) {
		this.isInstance();
		this.student.setInterne(interne);
		
	}

	private void isInstance(){
		if(this.student == null){
			StudentsDAO sdao = (StudentsDAO)FactoryDAO.getDAO(FactoryDAO.STUDENT);
			this.student = sdao.find(this.id);
		}
	}

	
	
}
