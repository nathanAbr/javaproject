package projetCERFA.DAO.Interface;

import java.util.List;

import projetCERFA.Model.Students;

public interface StudentsDAO {
	public Students add(Students students);
	public boolean delete(int id);
	public Students update(Students students);
	public Students find(int id);
	public List<Students> findAll();
}
