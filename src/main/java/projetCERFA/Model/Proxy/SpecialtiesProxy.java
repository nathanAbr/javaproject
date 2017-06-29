package projetCERFA.Model.Proxy;

import projetCERFA.DAO.Int.SpecialtiesDAO;
import projetCERFA.Model.Entity.Specialties;
import projetCERFA.Model.Factory.FactoryDAO;
import projetCERFA.Model.Int.ISpecialties;

public class SpecialtiesProxy implements ISpecialties{
	private Specialties specialtie = null;
	private int id;
	
	public SpecialtiesProxy(int id){
		this.id = id;
	}
	
	@Override
	public String getNom() {
		this.isInstance();
		return this.specialtie.getNom();
	}

	@Override
	public void setNom(String nom) {
		this.isInstance();
		this.specialtie.setNom(nom);		
	}

	@Override
	public String getCode() {
		this.isInstance();
		return this.specialtie.getCode();
	}

	@Override
	public void setCode(String code) {
		this.isInstance();
		this.specialtie.setCode(code);
	}

	@Override
	public int getId() {
		this.isInstance();
		return this.specialtie.getId();
	}

	@Override
	public void setId(int id) {
		this.isInstance();
		this.specialtie.setId(id);	
	}
	
	private void isInstance(){
		if(this.specialtie == null){
			SpecialtiesDAO sdao = (SpecialtiesDAO)FactoryDAO.getDAO(FactoryDAO.SPECIALTIE);
			this.specialtie = sdao.find(this.id);
		}
	}

}
