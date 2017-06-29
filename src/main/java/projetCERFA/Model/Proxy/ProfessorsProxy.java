package projetCERFA.Model.Proxy;

import projetCERFA.DAO.Int.ProfessorsDAO;
import projetCERFA.Model.Entity.Professors;
import projetCERFA.Model.Factory.FactoryDAO;
import projetCERFA.Model.Int.IProfessors;

public class ProfessorsProxy implements IProfessors{
	

	private Professors professor = null;
	private int id;
	
	public ProfessorsProxy(int id){
		this.id = id;
	}
	public int getId() {
		this.isInstance();
		return this.professor.getId();
	}

	public void setId(int id) {
		this.isInstance();
		this.professor.setId(id);
	}
	@Override
	public boolean getInterne() {
		this.isInstance();
		return this.professor.getInterne();
	}
	@Override
	public void setInterne(boolean interne) {
		this.isInstance();
		this.professor.setInterne(interne);
		
	}
	private void isInstance(){
		if(this.professor == null){
			ProfessorsDAO sdao = (ProfessorsDAO)FactoryDAO.getDAO(FactoryDAO.PROFESSOR);
			this.professor = sdao.find(this.id);
		}
	}
	
}
