package projetCERFA.DAO.Interface;

import java.util.List;

import projetCERFA.Model.Professors;

public interface ProfessorsDAO {
	public Professors add(Professors professor);
	public boolean delete(int id);
	public Professors update(Professors professor);
	public Professors find(int id);
	public List<Professors> findAll();
}
