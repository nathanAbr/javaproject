package projetCERFA.DAO.Impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import projetCERFA.DAO.Int.FinancesStudentsDAO;
import projetCERFA.Model.Entity.Finances;
import projetCERFA.Model.Entity.FinancesStudents;
import projetCERFA.Model.Entity.Students;

public class FinancesStudentsDAOImpl extends DAO<FinancesStudents> implements FinancesStudentsDAO{

	@Override
	public FinancesStudents add(FinancesStudents financesStudents) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(FinancesStudents financesStudents) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FinancesStudents update(FinancesStudents financesStudents) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinancesStudents find(int id_financement, int id_stagiaire, LocalDate beginDate) {
		FinancesStudents financesStudents = null;
		try{
			PreparedStatement stm = this.con.prepareStatement("SELECT p.nom, p.prenom, s.idStagiaire, s.interne, f.libelle, f.idFinancement, fs.dateDebut, fs.dateFin FROM financementstagiaire fs INNER JOIN financement f ON f.idFinancement = fs.fk_financement INNER JOIN stagiaire s ON s.idStagiaire = fs.fk_stagiaire INNER JOIN personne p ON p.idPersonne = s.idStagiaire WHERE fs.dateDebut = ? AND fs.fk_stagiaire = ? AND fs.fk_financement = ? ");
			stm.setDate(1,  Date.valueOf(beginDate));
			stm.setLong(2, id_stagiaire);
			stm.setLong(3, id_financement);
			ResultSet result = stm.executeQuery();
			while(result.next()){
				Students student = new Students(result.getString("p.nom"), result.getString("p.prenom"), result.getBoolean("s.interne"));
				student.setId(result.getInt("s.idStagiaire"));
				Finances finance = new Finances(result.getString("f.libelle"));
				finance.setId(result.getInt("f.idFinancement"));
				financesStudents = new FinancesStudents(student, finance, result.getDate("beginDate").toLocalDate(), result.getDate("endDate").toLocalDate());
				break;
			}
			stm.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return financesStudents;
	}
	
	@Override
	public List<FinancesStudents> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FinancesStudents find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
