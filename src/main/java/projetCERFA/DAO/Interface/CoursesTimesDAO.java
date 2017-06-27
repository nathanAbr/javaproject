package projetCERFA.DAO.Interface;

import projetCERFA.Model.CoursesTimes;

public interface CoursesTimesDAO {
	public CoursesTimes add(CoursesTimes coursesTimes);
	public boolean delete(int id);
	public CoursesTimes update(CoursesTimes coursesTimes);
}
