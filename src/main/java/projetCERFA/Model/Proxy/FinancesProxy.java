package projetCERFA.Model.Proxy;

import projetCERFA.DAO.Int.FinancesDAO;
import projetCERFA.Model.Entity.Finances;
import projetCERFA.Model.Factory.FactoryDAO;
import projetCERFA.Model.Int.IFinances;

public class FinancesProxy implements IFinances{
	private Finances finances = null;
	private int id;
	
	public FinancesProxy(int id){
		this.id = id;
	}
	
	public int getId() {
		this.isInstance();
		return this.finances.getId();
	}

	public void setId(int id) {
		this.isInstance();
		this.finances.setId(id);
	}
	
	@Override
	public String getLabel() {
		this.isInstance();
		return this.finances.getLabel();
	}
	private void isInstance(){
		if(this.finances == null){
			FinancesDAO fdao = (FinancesDAO)FactoryDAO.getDAO(FactoryDAO.FINANCE);
			this.finances = fdao.find(this.id);
		}
	}

	
}
