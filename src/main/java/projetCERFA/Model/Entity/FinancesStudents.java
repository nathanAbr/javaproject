package projetCERFA.Model.Entity;

import java.time.LocalDate;

public class FinancesStudents{
	
	private Students student;
	private Finances finance;
	private LocalDate beginDate;
	private LocalDate endDate;
	
	public FinancesStudents(Students student, Finances finance, LocalDate beginDate, LocalDate endDate) {
		this.setStudent(student);
		this.setFinance(finance);
		this.setBeginDate(beginDate);
		this.setEndDate(endDate);
	}
	
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
	public Finances getFinance() {
		return finance;
	}
	public void setFinance(Finances finance) {
		this.finance = finance;
	}
	public LocalDate getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
