package projetCERFA.DAO.Int;

import java.util.List;

import projetCERFA.Model.Entity.Finances;


public interface FinancesDAO {
	public Finances find(int id);
	public List<Finances> findAll();
}
