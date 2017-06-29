package projetCERFA.Model.Proxy;


import projetCERFA.DAO.Int.TargetsDAO;
import projetCERFA.Model.Entity.Targets;
import projetCERFA.Model.Factory.FactoryDAO;
import projetCERFA.Model.Int.ITargets;

public class TargetsProxy implements ITargets{
	
	private Targets target = null;
	private int id;
	
	public TargetsProxy(int id){
		this.isInstance();
		this.id = id;
	}
	
	public int getId() {
		this.isInstance();
		return this.target.getId();
	}
	
	public void setId(int id) {
		this.isInstance();
		this.target.setId(id);
	}
	
	@Override
	public String getLabel() {
		this.isInstance();
		return this.target.getLabel();
	}

	@Override
	public void setLabel(String label) {
		this.isInstance();
		this.target.setLabel(label);
	}
	
	private void isInstance(){
		if(this.target == null){
			TargetsDAO sdao = (TargetsDAO)FactoryDAO.getDAO(FactoryDAO.TARGET);
			this.target = sdao.find(this.id);
		}
	}

}
