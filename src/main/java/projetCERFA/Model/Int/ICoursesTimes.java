package projetCERFA.Model.Int;

import java.time.LocalDate;

public interface ICoursesTimes {

	int getId();

	void setId(int id);

	LocalDate getBeginDate();

	void setBeginDate(LocalDate beginDate);

	LocalDate getEndDate();

	void setEndDate(LocalDate endDate);

	boolean getInterne();

	void setInterne(boolean interne);

	ITrainings getTraining();

	void setTraining(ITrainings training);

}