package projetCERFA.Model.Proxy;

import java.time.LocalDate;
import projetCERFA.DAO.Int.CoursesTimesDAO;
import projetCERFA.Model.Entity.CoursesTimes;
import projetCERFA.Model.Factory.FactoryDAO;
import projetCERFA.Model.Int.ICoursesTimes;
import projetCERFA.Model.Int.ITrainings;

public class CoursesTimesProxy implements ICoursesTimes{
	private CoursesTimes courseTime = null;
	private int id;
	
	public CoursesTimesProxy(int id){
		this.id = id;
	}
	
	@Override
	public int getId() {
		this.isInstance();
		return this.courseTime.getId();
	}


	@Override
	public void setId(int id) {
		this.isInstance();
		this.courseTime.setId(id);
	}


	@Override
	public LocalDate getBeginDate() {
		this.isInstance();
		return this.courseTime.getBeginDate();
	}


	@Override
	public void setBeginDate(LocalDate beginDate) {
		this.isInstance();
		this.courseTime.setBeginDate(beginDate);
		
	}


	@Override
	public LocalDate getEndDate() {
		this.isInstance();
		return this.courseTime.getEndDate();
	}


	@Override
	public void setEndDate(LocalDate endDate) {
		this.isInstance();
		this.courseTime.setEndDate(endDate);
	}


	@Override
	public boolean getInterne() {
		this.isInstance();
		return this.courseTime.getInterne();
	}


	@Override
	public void setInterne(boolean interne) {
		this.isInstance();
		this.courseTime.setInterne(interne);
	}

	@Override
	public ITrainings getTraining() {
		this.isInstance();
		return this.courseTime.getTraining();
	}

	@Override
	public void setTraining(ITrainings training) {
		this.isInstance();
		this.courseTime.setTraining(training);
	}
	
	private void isInstance(){
		if(this.courseTime == null){
			CoursesTimesDAO cdao = (CoursesTimesDAO)FactoryDAO.getDAO(FactoryDAO.COURSESTIMES);
			this.courseTime = cdao.find(this.id);
		}
	}

	
}
