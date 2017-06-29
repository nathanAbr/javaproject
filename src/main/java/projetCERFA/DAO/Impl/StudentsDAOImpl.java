package projetCERFA.DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import projetCERFA.DAO.Int.StudentsDAO;
import projetCERFA.Model.Entity.Students;

public class StudentsDAOImpl extends DAO<Students> implements StudentsDAO{

	public Students add(Students student) {
		try{
			PreparedStatement stm = this.con.prepareStatement("INSERT INTO personne (nom, prenom) VALUES (?, ?)");
			stm.setString(1, student.getFirstName());
			stm.setString(2, student.getSecondName());
			stm.execute();
			stm.close();
			int id = 0;
			Statement lastInsertedId = this.con.createStatement();
			ResultSet lastid = lastInsertedId.executeQuery("SELECT LAST_INSERT_ID() as last_id FROM personn");
			while(lastid.next()){
				id = lastid.getInt(1);
				break;
			}
			student.setId(id);
			PreparedStatement stm_student = this.con.prepareStatement("INSERT INTO stagiaire (interne, idStagiaire) VALUES (?, ?)");
			stm_student.setBoolean(1, student.getInterne());
			stm_student.setInt(2, student.getId());
			stm_student.execute();
			stm_student.close();
			return student;
		}
		catch(Exception e){
			e.getMessage();
			return null;
		}
	}

	public boolean delete(int id) {
		try{
			PreparedStatement stm_student = this.con.prepareStatement("DELETE FROM stagiaire WHERE idStagiaire = ?");
			stm_student.setInt(1, id);
			stm_student.execute();
			stm_student.close();
			PreparedStatement stm_personn = this.con.prepareStatement("DELETE FROM personne WHERE idPersonne = ?");
			stm_personn.setInt(1, id);
			stm_personn.execute();
			stm_personn.close();
			return true;
		}
		catch(Exception e){
			
			return false;
		}
	}

	public Students update(Students student) {
		try{
			PreparedStatement stm = this.con.prepareStatement("UPDATE personne SET nom = ?, prenom = ? WHERE idPersonne = ?");
			stm.setString(1, student.getFirstName());
			stm.setString(2, student.getSecondName());
			stm.setInt(3, student.getId());
			stm.execute();
			stm.close();
			PreparedStatement stm_student = this.con.prepareStatement("UPDATE stagiaire SET interne = ? WHERE idStagiaire = ?");
			stm_student.setBoolean(1, student.getInterne());
			stm_student.setInt(2, student.getId());
			stm_student.execute();
			stm_student.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return student;
	}

	@Override
	public Students find(int id) {
		Students student = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT idPersonn, nom, prenom, interne FROM personne INNER JOIN stagiaire ON stagiaire.idStagiaire  = personne.idPersonne WHERE personne.idPersonne = ?");
			stm.setLong(1, id);
			ResultSet result = stm.executeQuery();
			while(result.next()){
				student = new Students(result.getString("nom"), result.getString("prenom"), result.getBoolean("interne"));
				student.setId(result.getInt("idPersonne"));
				break;
			}
			stm.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return student;
	}

	@Override
	public ArrayList<Students> findAll() {
		ArrayList<Students> studentList = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT idPersonne, nom, prenom, interne FROM personne INNER JOIN stagiaire ON stagiaire.idStagiaire = personne.idPersonne");
			ResultSet result = stm.executeQuery();
			while(result.next()){
				Students student = new Students(result.getString("nom"), result.getString("prenom"), result.getBoolean("interne"));
				student.setId(result.getInt("idPersonne"));
				studentList.add(student);
			}
			stm.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return studentList;
	}

}
