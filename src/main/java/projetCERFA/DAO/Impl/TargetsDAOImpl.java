package projetCERFA.DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import projetCERFA.DAO.Int.TargetsDAO;
import projetCERFA.Model.Targets;
import projetCERFA.Model.Targets;

public class TargetsDAOImpl extends DAO<Targets> implements TargetsDAO{

	@Override
	public Targets add(Targets obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Targets update(Targets obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Targets find(int id) {
		Targets target = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT libelle, idObjectif FROM objectif WHERE idObjectif = ?");
			stm.setInt(1, id);
			ResultSet result = stm.executeQuery();
			while(result.next()){
				target = new Targets(result.getString("libelle"));
				target.setId(result.getInt("idObjectif"));
				break;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return target;
	}

	@Override
	public ArrayList<Targets> findAll() {
		ArrayList<Targets> targetList = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT libelle, idObjectif FROM objectif");
			ResultSet result = stm.executeQuery();
			while(result.next()){
				Targets target = new Targets(result.getString("libelle"));
				target.setId(result.getInt("idObjectif"));
				targetList.add(target);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return targetList;
	}

}
