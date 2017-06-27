package projetCERFA.DAO.Interface;

import java.util.List;

import projetCERFA.Model.Finances;


public interface FinancesDAO {
	public Finances find(int id);
	public List<Finances> findAll();
}
