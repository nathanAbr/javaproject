package projetCERFA.Model.Entity;

import projetCERFA.Model.Int.IFinances;

public class Finances implements IFinances {
	private String label;
	private int id;

	public Finances(String label){
		this.setLabel(label);
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IFinances#getLabel()
	 */
	@Override
	public String getLabel(){
		return this.label;
	}

	private void setLabel(String label) {
		this.label = label;
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IFinances#getId()
	 */
	@Override
	public int getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.IFinances#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
}
