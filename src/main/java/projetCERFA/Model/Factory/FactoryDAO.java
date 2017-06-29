package projetCERFA.Model.Factory;

import projetCERFA.DAO.Impl.CoursesTimesDAOImpl;
import projetCERFA.DAO.Impl.FinancesDAOImpl;
import projetCERFA.DAO.Impl.ProfessorsDAOImpl;
import projetCERFA.DAO.Impl.SpecialtiesDAOImpl;
import projetCERFA.DAO.Impl.StudentsDAOImpl;
import projetCERFA.DAO.Impl.TargetsDAOImpl;
import projetCERFA.DAO.Impl.TrainingsDAOImpl;
import projetCERFA.DAO.Int.IDAO;

public class FactoryDAO {
	
	public static final String TRAINING = "Training";
	public static final String STUDENT = "Student";
	public static final String PROFESSOR = "Professor";
	public static final String SPECIALTIE = "Specialtie";
	public static final String TARGET = "Target";
	public static final String FINANCE = "Finance";
	public static final String COURSESTIMES = "CoursesTimes";
	
	public static IDAO getDAO(String typeDao){
		switch(typeDao){
			case TRAINING :
				return new TrainingsDAOImpl();
			case STUDENT :
				return new StudentsDAOImpl();
			case PROFESSOR :
				return new ProfessorsDAOImpl();
			case SPECIALTIE :
				return new SpecialtiesDAOImpl();
			case TARGET:
				return new TargetsDAOImpl();
			case FINANCE :
				return new FinancesDAOImpl();
			case COURSESTIMES :
				return new CoursesTimesDAOImpl();
			default :
				return null;
		}
	}
}
