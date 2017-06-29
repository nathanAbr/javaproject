package projetCERFA.Model.Proxy;

import projetCERFA.DAO.Int.TrainingsDAO;
import projetCERFA.Model.Entity.Trainings;
import projetCERFA.Model.Factory.FactoryDAO;
import projetCERFA.Model.Int.ISpecialties;
import projetCERFA.Model.Int.ITargets;
import projetCERFA.Model.Int.ITrainings;

public class TrainingsProxy implements ITrainings {
	private Trainings training = null;
	private int id;

	public TrainingsProxy(int id) {
		this.id = id;
	}
	
	@Override
	public void setTarget(ITargets target) {
		this.isInstance();
		this.training.setTarget(target);
	}

	@Override
	public void setSpecialtie(ISpecialties specialtie) {
		this.isInstance();
		this.training.setSpecialtie(specialtie);
	}

	@Override
	public ITargets getTarget() {
		this.isInstance();
		return this.training.getTarget();
	}

	@Override
	public ISpecialties getSpecialtie() {
		this.isInstance();
		return this.training.getSpecialtie();
	}

	@Override
	public String getName() {
		this.isInstance();
		return this.training.getName();
	}

	@Override
	public void setName(String name) {
		this.isInstance();
		this.training.setName(name);
	}

	@Override
	public int getId() {
		this.isInstance();
		return this.training.getId();
	}

	@Override
	public void setId(int id) {
		this.isInstance();
		this.training.setId(id);
	}
	
	private void isInstance(){
		if (this.training == null) {
			TrainingsDAO tddao = (TrainingsDAO)FactoryDAO.getDAO(FactoryDAO.TRAINING);
			this.training = tddao.find(this.id); 
		}
	}
}
