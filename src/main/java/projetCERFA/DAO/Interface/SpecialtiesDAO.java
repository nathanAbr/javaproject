package projetCERFA.DAO.Interface;

import java.util.List;

import projetCERFA.Model.Specialties;

public interface SpecialtiesDAO {
	public Specialties find(int id);
	public List<Specialties> findAll();
}
