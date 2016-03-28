package data;

public class Evenement {

	 private String nom;
	 private int effet;
	 
	 
	public Evenement(String nom, int effet) {
		super();
		this.nom = nom;
		this.effet = effet;
	}


	public String getName() {
		return nom;
	}


	public void setName(String name) {
		this.nom = name;
	}


	public int getEffet() {
		return effet;
	}


	public void setEffet(int effet) {
		this.effet = effet;
	}
	
	
	
}
