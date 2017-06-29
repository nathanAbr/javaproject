package projetCERFA.DAO.Int;

import java.util.List;

import projetCERFA.Model.Entity.Specialties;

public interface SpecialtiesDAO {
	public Specialties find(int id);
	public List<Specialties> findAll();
}
