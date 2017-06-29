package projetCERFA.Model.Entity;

import projetCERFA.Model.Int.ISpecialties;
import projetCERFA.Model.Int.ITargets;
import projetCERFA.Model.Int.ITrainings;

public class Trainings implements ITrainings {
	private String name;
	private int id;
	private ITargets target;
	private ISpecialties specialtie;
	
	public Trainings(String name, ITargets target, ISpecialties specialtie){
		this.setName(name);
		this.setTarget(target);
		this.setSpecialtie(specialtie);
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ITrainings#setTarget(projetCERFA.Model.Entity.Targets)
	 */
	@Override
	public void setTarget(ITargets target){
		this.target = target;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ITrainings#setSpecialtie(projetCERFA.Model.Entity.Specialties)
	 */
	@Override
	public void setSpecialtie(ISpecialties specialtie){
		this.specialtie = specialtie;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ITrainings#getTarget()
	 */
	@Override
	public ITargets getTarget(){
		return this.target;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ITrainings#getSpecialtie()
	 */
	@Override
	public ISpecialties getSpecialtie(){
		return this.specialtie;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ITrainings#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ITrainings#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ITrainings#getId()
	 */
	@Override
	public int getId() {
		return this.id;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ITrainings#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	
}
