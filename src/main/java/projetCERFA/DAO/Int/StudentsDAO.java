package projetCERFA.DAO.Int;

import java.util.List;

import projetCERFA.Model.Entity.Students;

public interface StudentsDAO {
	public Students add(Students students);
	public boolean delete(int id);
	public Students update(Students students);
	public Students find(int id);
	public List<Students> findAll();
}
