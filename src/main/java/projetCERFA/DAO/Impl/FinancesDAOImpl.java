package projetCERFA.DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import projetCERFA.DAO.Int.FinancesDAO;
import projetCERFA.Model.Finances;

public class FinancesDAOImpl extends DAO<Finances> implements FinancesDAO{

	@Override
	public Finances add(Finances obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Finances update(Finances obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Finances find(int id) {
		Finances finance = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT libelle, idFinancement FROM financement WHERE idFinancement = ?");
			stm.setInt(1, id);
			ResultSet result = stm.executeQuery();
			while(result.next()){
				finance = new Finances(result.getString("libelle"));
				finance.setId(result.getInt("idFinancement"));
				break;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return finance;
	}

	@Override
	public ArrayList<Finances> findAll() {
		ArrayList<Finances> financeList = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT libelle, idFinancement FROM financement");
			ResultSet result = stm.executeQuery();
			while(result.next()){
				Finances finance = new Finances(result.getString("libelle"));
				finance.setId(result.getInt("idFinancement"));
				financeList.add(finance);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return financeList;
	}

}
