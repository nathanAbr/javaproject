package projetCERFA.Model.Proxy;

import java.time.LocalDate;
import projetCERFA.DAO.Int.CoursesTimesDAO;
import projetCERFA.Model.Entity.CoursesTimes;
import projetCERFA.Model.Factory.FactoryDAO;
import projetCERFA.Model.Int.ICoursesTimes;
import projetCERFA.Model.Int.ITrainings;

public class CoursesTimesProxy implements ICoursesTimes {
	private CoursesTimes courseTime = null;
	private int id;

	public CoursesTimesProxy(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return this.getInstance().getId();
	}

	@Override
	public void setId(int id) {
		this.getInstance().setId(id);
	}

	@Override
	public LocalDate getBeginDate() {
		return this.getInstance().getBeginDate();
	}

	@Override
	public void setBeginDate(LocalDate beginDate) {
		this.getInstance().setBeginDate(beginDate);

	}

	@Override
	public LocalDate getEndDate() {
		return this.getInstance().getEndDate();
	}

	@Override
	public void setEndDate(LocalDate endDate) {
		this.getInstance().setEndDate(endDate);
	}

	@Override
	public boolean getInterne() {
		return this.getInstance().getInterne();
	}

	@Override
	public void setInterne(boolean interne) {
		this.getInstance().setInterne(interne);
	}

	@Override
	public ITrainings getTraining() {
		return this.getInstance().getTraining();
	}

	@Override
	public void setTraining(ITrainings training) {
		this.getInstance().setTraining(training);
	}

	private CoursesTimes getInstance() {
		if (this.courseTime == null) {
			CoursesTimesDAO cdao = (CoursesTimesDAO) FactoryDAO.getDAO(FactoryDAO.COURSESTIMES);
			this.courseTime = cdao.find(this.id);
		}
		return this.courseTime;
	}

}
