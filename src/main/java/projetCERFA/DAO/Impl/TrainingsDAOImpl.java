package projetCERFA.DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import projetCERFA.DAO.Int.TrainingsDAO;
import projetCERFA.Model.Entity.Specialties;
import projetCERFA.Model.Entity.Targets;
import projetCERFA.Model.Entity.Trainings;
import projetCERFA.Model.Int.ISpecialties;
import projetCERFA.Model.Int.ITargets;
import projetCERFA.Model.Proxy.SpecialtiesProxy;
import projetCERFA.Model.Proxy.TargetsProxy;

public class TrainingsDAOImpl extends DAO<Trainings> implements TrainingsDAO {

	public Trainings add(Trainings training) {
		try{
			PreparedStatement stm = this.con.prepareStatement("INSERT INTO formation (nom, fk_specialite, fk_objectif) VALUES (?, ?, ?)");
			stm.setString(1, training.getName());
			stm.setInt(2, training.getSpecialtie().getId());
			stm.setInt(3, training.getTarget().getId());
			stm.execute();
			stm.close();
			int id = 0;
			Statement lastInsertedId = this.con.createStatement();
			ResultSet lastid = lastInsertedId.executeQuery("SELECT LAST_INSERT_ID() as last_id FROM idFormation");
			while(lastid.next()){
				id = lastid.getInt(1);
				break;
			}
			training.setId(id);
			return training;
		}
		catch(Exception e){
			e.getMessage();
			return null;
		}
	}

	public boolean delete(int id) {
		try{
			PreparedStatement stm_training = this.con.prepareStatement("DELETE FROM formation WHERE idFormation = ?");
			stm_training.setInt(1, id);
			stm_training.execute();
			stm_training.close();
			return true;
		}
		catch(Exception e){
			
			return false;
		}
	}

	public Trainings update(Trainings training) {
		try{
			PreparedStatement stm = this.con.prepareStatement("UPDATE formation SET nom = ?, fk_specialite = ?, fk_objectif WHERE idFormation = ?");
			stm.setString(1, training.getName());
			stm.setInt(2, training.getSpecialtie().getId());
			stm.setInt(3, training.getTarget().getId());
			stm.setInt(4, training.getId());
			stm.execute();
			stm.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return training;
	}

	@Override
	public Trainings find(int id) {
		Trainings training = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT idFormation, nom, fk_specialite, fk_objectif, idStagiaire FROM formation WHERE formation.idFormation = ?");
			stm.setLong(1, id);
			ResultSet result = stm.executeQuery();
			while(result.next()){
				ISpecialties specialtie = new SpecialtiesProxy(result.getInt("fk_specialite"));
				ITargets target = new TargetsProxy(result.getInt("fk_objectif"));
				target.setId(result.getInt("fk_objectif"));
				training = new Trainings(result.getString("nom"), target, specialtie);
				training.setId(result.getInt("idFormation"));
				break;
			}
			stm.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return training;
	}

	@Override
	public ArrayList<Trainings> findAll() {
		ArrayList<Trainings> trainingList = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT idFormation, nom, fk_specialite, fk_objectif, specialite.libelle, objectif.libelle, specialite.code FROM formation INNER JOIN specialite ON formation.fk_specialite = specialite.idSpecialite INNER JOIN objectif ON objectif.idObjectif = formation.fk_objectif");
			ResultSet result = stm.executeQuery();
			while(result.next()){
				ISpecialties specialtie = new Specialties(result.getString("specialite.libelle"), result.getString("specialite.code"));
				ITargets target = new Targets(result.getString("objectif.libelle"));
				Trainings training = new Trainings(result.getString("nom"), target, specialtie);
				training.setId(result.getInt("idFormation"));
				trainingList.add(training);
			}
			stm.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return trainingList;
	}

}
