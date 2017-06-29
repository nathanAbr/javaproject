package projetCERFA.DAO.Impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projetCERFA.DAO.Int.CoursesTimesDAO;
import projetCERFA.Model.Entity.CoursesTimes;
import projetCERFA.Model.Entity.Professors;
import projetCERFA.Model.Int.ITrainings;
import projetCERFA.Model.Proxy.TrainingsProxy;

public class CoursesTimesDAOImpl extends DAO<CoursesTimes> implements CoursesTimesDAO{

	public boolean delete(int id) {
		try{
			PreparedStatement stm_coursesTime = this.con.prepareStatement("DELETE FROM creneau WHERE idCreneau = ?");
			stm_coursesTime.setInt(1, id);
			stm_coursesTime.execute();
			stm_coursesTime.close();
			return true;
		}
		catch(Exception e){
			
			return false;
		}
	}

	@Override
	public CoursesTimes find(int id) {
		CoursesTimes courseTime = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT idCreneau, dateDebut, dateFin, interne, fk_formation FROM creneau WHERE idCreneau = ?");
			stm.setLong(1, id);
			ResultSet result = stm.executeQuery();
			while(result.next()){
				ITrainings training = new TrainingsProxy(result.getInt("fk_formation"));
				courseTime = new CoursesTimes(result.getInt("id"), result.getDate("dateDebut").toLocalDate(), result.getDate("dateFin").toLocalDate(), result.getBoolean("interne"), training);
				courseTime.setId(result.getInt("idPersonne"));
				break;
			}
			stm.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return courseTime;
	}

	@Override
	public ArrayList<CoursesTimes> findAll() {
		ArrayList<CoursesTimes> courseTimeList = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT idCreneau, dateDebut, dateFin, interne, fk_formation FROM creneau");
			ResultSet result = stm.executeQuery();
			while(result.next()){
				ITrainings training = new TrainingsProxy(result.getInt("fk_formation"));
				CoursesTimes courseTime = new CoursesTimes(result.getInt("id"), result.getDate("dateDebut").toLocalDate(), result.getDate("dateFin").toLocalDate(), result.getBoolean("interne"), training);
				courseTime.setId(result.getInt("idPersonne"));
				courseTimeList.add(courseTime);
			}
			stm.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return courseTimeList;
	}

	@Override
	public CoursesTimes add(CoursesTimes obj) {
		try{
			PreparedStatement stm = this.con.prepareStatement("INSERT INTO creneau (dateDebut, dateFin, interne, fk_formation) VALUES (?, ?, ?, ?)");
			stm.setDate(1, Date.valueOf(obj.getBeginDate()));
			stm.setDate(2, Date.valueOf(obj.getEndDate()));
			stm.setBoolean(3, obj.getInterne());
			stm.setInt(4, obj.getTraining().getId());
			stm.execute();
			stm.close();
			int id = 0;
			Statement lastInsertedId = this.con.createStatement();
			ResultSet lastid = lastInsertedId.executeQuery("SELECT LAST_INSERT_ID() as last_id FROM creneau");
			while(lastid.next()){
				id = lastid.getInt(1);
				break;
			}
			obj.setId(id);
			return obj;
		}
		catch(Exception e){
			e.getMessage();
			return null;
		}
	}

	@Override
	public CoursesTimes update(CoursesTimes obj) {
		try{
			PreparedStatement stm = this.con.prepareStatement("UPDATE creneau SET dateDebut = ?, dateFin = ?, interne = ?, fk_formation = ? WHERE idcreneau = ?");
			stm.setDate(1, Date.valueOf(obj.getBeginDate()));
			stm.setDate(2, Date.valueOf(obj.getEndDate()));
			stm.setBoolean(3, obj.getInterne());
			stm.setInt(4, obj.getTraining().getId());
			stm.execute();
			stm.close();
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return obj;
	}
	
}
