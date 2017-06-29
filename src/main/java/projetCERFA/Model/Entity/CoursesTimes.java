package projetCERFA.Model.Entity;

import java.time.LocalDate;

import projetCERFA.Model.Int.ICoursesTimes;
import projetCERFA.Model.Int.ITrainings;

public class CoursesTimes implements ICoursesTimes {

	private int id;
	private LocalDate beginDate;
	private LocalDate endDate;
	private boolean interne;
	private ITrainings training;
	
	public CoursesTimes(int id, LocalDate beginDate, LocalDate endDate, boolean interne, ITrainings training) {
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.interne = interne;
		this.training = training;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ICoursesTimes#getId()
	 */
	@Override
	public int getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ICoursesTimes#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ICoursesTimes#getBeginDate()
	 */
	@Override
	public LocalDate getBeginDate() {
		return beginDate;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ICoursesTimes#setBeginDate(java.time.LocalDate)
	 */
	@Override
	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ICoursesTimes#getEndDate()
	 */
	@Override
	public LocalDate getEndDate() {
		return endDate;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ICoursesTimes#setEndDate(java.time.LocalDate)
	 */
	@Override
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ICoursesTimes#getInterne()
	 */
	@Override
	public boolean getInterne() {
		return interne;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ICoursesTimes#setInterne(boolean)
	 */
	@Override
	public void setInterne(boolean interne) {
		this.interne = interne;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ICoursesTimes#getTraining()
	 */
	@Override
	public ITrainings getTraining() {
		return training;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ICoursesTimes#setTraining(projetCERFA.Model.Int.ITrainings)
	 */
	@Override
	public void setTraining(ITrainings training) {
		this.training = training;
	}
}
