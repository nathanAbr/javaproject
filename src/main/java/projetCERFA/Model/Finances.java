package projetCERFA.Model;

public class Finances {
	private String label;
	private int id;

	public Finances(String label){
		this.setLabel(label);
	}
	
	public String getLabel(){
		return this.label;
	}

	private void setLabel(String label) {
		this.label = label;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
