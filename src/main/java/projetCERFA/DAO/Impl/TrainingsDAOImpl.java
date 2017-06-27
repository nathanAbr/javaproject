package projetCERFA.DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projetCERFA.DAO.Int.TrainingsDAO;
import projetCERFA.Model.Trainings;

public class TrainingsDAOImpl extends DAO<Trainings> implements TrainingsDAO{

	public Trainings add(Trainings training) {
		try{
			PreparedStatement stm = this.con.prepareStatement("INSERT INTO formation (nom, fk_specialite, fk_objectif) VALUES (?, ?, ?)");
			stm.setString(1, training.getName());
			stm.setInt(2, training.getIdSpecialitie());
			stm.setInt(3, training.getIdTarget());
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
			stm.setInt(2, training.getIdSpecialitie());
			stm.setInt(3, training.getIdTarget());
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
			PreparedStatement stm = this.con.prepareStatement("SELECT idFormation, nom, interne FROM formation INNER JOIN specialite ON formation.idFormation  = specialite.idSpecialite INNER JOIN objectif ON formation.idFormation = objectif.idObjectif WHERE formation.idFormation = ?");
			stm.setLong(1, id);
			ResultSet result = stm.executeQuery();
			while(result.next()){
				training = new Trainings(result.getString("nom"), result.getString("prenom"), result.getBoolean("interne"));
				training.setId(result.getInt("idPersonne"));
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
			PreparedStatement stm = this.con.prepareStatement("SELECT idPersonne, nom, prenom, interne FROM formation INNER JOIN formation ON formation.idFormateur = formation.idPersonne");
			ResultSet result = stm.executeQuery();
			while(result.next()){
				Trainings training = new Trainings(result.getString("nom"), result.getString("prenom"), result.getBoolean("interne"));
				training.setId(result.getInt("idPersonne"));
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
