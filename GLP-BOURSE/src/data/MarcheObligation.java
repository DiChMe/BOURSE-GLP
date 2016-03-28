package data;

public class MarcheObligation extends Marche{
	
	private int dureeVie;
	private int interet;
	
	private String type;
	
	public MarcheObligation(String type,int idMarche, int idEntreprise, double prixCourant, double prixBas, double prixHaut,int dureeVie, int interet) {
		super(idMarche, idEntreprise, prixCourant, prixBas, prixHaut);
		this.dureeVie = dureeVie;
		this.interet = interet;
		this.type=type;
	}
	
	public int getDureeVie() {
		return dureeVie;
	}
	
	public void setDureeVie(int dureeVie) {
		this.dureeVie = dureeVie;
	}
	
	public int getInteret() {
		return interet;
	}
	
	public void setInteret(int interet) {
		this.interet = interet;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	

}
