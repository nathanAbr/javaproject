package projetCERFA.DAO.Int;

import java.util.List;

import projetCERFA.Model.Entity.CoursesTimes;

public interface CoursesTimesDAO {
	public CoursesTimes add(CoursesTimes coursesTimes);
	public boolean delete(int id);
	public CoursesTimes update(CoursesTimes coursesTimes);
	public CoursesTimes find(int id);
	public List<CoursesTimes> findAll();
}
