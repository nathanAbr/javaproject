package projetCERFA.DAO.Int;

import java.time.LocalDate;
import java.util.List;

import projetCERFA.Model.Entity.FinancesStudents;

public interface FinancesStudentsDAO {
	public FinancesStudents add(FinancesStudents financesStudents);
	public boolean delete(FinancesStudents financesStudents);
	public FinancesStudents update(FinancesStudents financesStudents);
	public FinancesStudents find(int id_finances, int id_students, LocalDate beginDate);
	public List<FinancesStudents> findAll();
}
