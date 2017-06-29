package projetCERFA.Model.Entity;

import projetCERFA.Model.Int.ITargets;

public class Targets implements ITargets {
	private String label;
	private int id;
	
	public Targets(String label){
		this.setLabel(label);
	}
	
	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ITargets#getLabel()
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ITargets#setLabel(java.lang.String)
	 */
	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ITargets#getId()
	 */
	@Override
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see projetCERFA.Model.Entity.ITargets#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}	
}
