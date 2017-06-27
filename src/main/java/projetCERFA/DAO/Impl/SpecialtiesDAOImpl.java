package projetCERFA.DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import projetCERFA.DAO.Int.SpecialtiesDAO;
import projetCERFA.Model.Specialties;
import projetCERFA.Model.Specialties;

public class SpecialtiesDAOImpl extends DAO<Specialties> implements SpecialtiesDAO{

	@Override
	public Specialties add(Specialties obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Specialties update(Specialties obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Specialties find(int id) {
		Specialties specialtie = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT libelle, idSpecialite FROM specialite WHERE idFinancement = ?");
			stm.setInt(1, id);
			ResultSet result = stm.executeQuery();
			while(result.next()){
				specialtie = new Specialties(result.getString("libelle"), result.getString("code"));
				specialtie.setId(result.getInt("idSpecialite"));
				break;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return specialtie;
	}

	@Override
	public ArrayList<Specialties> findAll() {
		ArrayList<Specialties> specialtieList = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT libelle, idSpecialite FROM specialite");
			ResultSet result = stm.executeQuery();
			while(result.next()){
				Specialties specialtie = new Specialties(result.getString("libelle"), result.getString("code"));
				specialtie.setId(result.getInt("idSpecialite"));
				specialtieList.add(specialtie);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return specialtieList;
	}

}
