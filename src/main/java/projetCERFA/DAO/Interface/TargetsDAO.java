package projetCERFA.DAO.Interface;

import java.util.List;

import projetCERFA.Model.Targets;

public interface TargetsDAO {
	public Targets find(int id);
	public List<Targets> findAll();
}
