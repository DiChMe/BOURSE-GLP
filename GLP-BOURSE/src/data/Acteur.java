package data;

public abstract class Acteur {
	
	


	private String nom;
	private double capital;
	private double dernierCapital;
	
	
public Acteur(String nom, double capital) {
		
		this.nom = nom;
		this.capital = capital;
		this.dernierCapital=capital;
	}
	@Override
	public String toString() {
		return  nom +  capital;
	}


	public double getCapital() {
		return capital;
	}


	public void setCapital(double capital) {
		this.capital = capital;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getDernierCapital() {
		return dernierCapital;
	}
	public void setDernierCapital(double dernierCapital) {
		this.dernierCapital = dernierCapital;
	}


	
}
