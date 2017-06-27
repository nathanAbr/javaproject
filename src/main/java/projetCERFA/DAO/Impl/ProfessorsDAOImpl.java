package projetCERFA.DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import projetCERFA.DAO.Int.ProfessorsDAO;
import projetCERFA.Model.Professors;

public class ProfessorsDAOImpl extends DAO<Professors> implements ProfessorsDAO{

	public Professors add(Professors professor) {
		try{
			PreparedStatement stm = this.con.prepareStatement("INSERT INTO personne (nom, prenom) VALUES (?, ?)");
			stm.setString(1, professor.getFirstName());
			stm.setString(2, professor.getSecondName());
			stm.execute();
			stm.close();
			int id = 0;
			Statement lastInsertedId = this.con.createStatement();
			ResultSet lastid = lastInsertedId.executeQuery("SELECT LAST_INSERT_ID() as last_id FROM personn");
			while(lastid.next()){
				id = lastid.getInt(1);
				break;
			}
			professor.setId(id);
			PreparedStatement stm_professor = this.con.prepareStatement("INSERT INTO formateur (interne, idFormateur) VALUES (?, ?)");
			stm_professor.setBoolean(1, professor.getInterne());
			stm_professor.setInt(2, professor.getId());
			stm_professor.execute();
			stm_professor.close();
			return professor;
		}
		catch(Exception e){
			e.getMessage();
			return null;
		}
	}

	public boolean delete(int id) {
		try{
			PreparedStatement stm_professor = this.con.prepareStatement("DELETE FROM formateur WHERE idFormateur = ?");
			stm_professor.setInt(1, id);
			stm_professor.execute();
			stm_professor.close();
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

	public Professors update(Professors professor) {
		try{
			PreparedStatement stm = this.con.prepareStatement("UPDATE personne SET nom = ?, prenom = ? WHERE idPersonne = ?");
			stm.setString(1, professor.getFirstName());
			stm.setString(2, professor.getSecondName());
			stm.setInt(3, professor.getId());
			stm.execute();
			stm.close();
			PreparedStatement stm_professor = this.con.prepareStatement("UPDATE formateur SET interne = ? WHERE idFormateur = ?");
			stm_professor.setBoolean(1, professor.getInterne());
			stm_professor.setInt(2, professor.getId());
			stm_professor.execute();
			stm_professor.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return professor;
	}

	@Override
	public Professors find(int id) {
		Professors professor = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT idPersonn, nom, prenom, interne FROM personne INNER JOIN formateur ON formateur.idFormateur  = personne.idPersonne WHERE personne.idPersonne = ?");
			stm.setLong(1, id);
			ResultSet result = stm.executeQuery();
			while(result.next()){
				professor = new Professors(result.getString("nom"), result.getString("prenom"), result.getBoolean("interne"));
				professor.setId(result.getInt("idPersonne"));
				break;
			}
			stm.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return professor;
	}

	@Override
	public ArrayList<Professors> findAll() {
		ArrayList<Professors> professorList = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT idPersonne, nom, prenom, interne FROM personne INNER JOIN formateur ON formateur.idFormateur = personne.idPersonne");
			ResultSet result = stm.executeQuery();
			while(result.next()){
				Professors professor = new Professors(result.getString("nom"), result.getString("prenom"), result.getBoolean("interne"));
				professor.setId(result.getInt("idPersonne"));
				professorList.add(professor);
			}
			stm.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return professorList;
	}

}
