package projetCERFA.DAO.Int;
import java.util.List;

import projetCERFA.Model.Entity.Trainings;

public interface TrainingsDAO {
	public Trainings add(Trainings training);
	public boolean delete(int id);
	public Trainings update(Trainings training);
	public Trainings find(int id);
	public List<Trainings> findAll();
}
