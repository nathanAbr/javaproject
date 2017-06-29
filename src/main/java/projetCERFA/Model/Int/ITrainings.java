package projetCERFA.Model.Int;

public interface ITrainings {

	void setTarget(ITargets target);

	void setSpecialtie(ISpecialties specialtie);

	ITargets getTarget();

	ISpecialties getSpecialtie();

	String getName();

	void setName(String name);

	int getId();

	void setId(int id);

}