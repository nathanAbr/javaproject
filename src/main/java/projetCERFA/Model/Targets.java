package projetCERFA.Model;

public class Targets {
	private String label;
	private int id;
	
	public Targets(String label){
		this.setLabel(label);
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}
