package data;

public class MarcheAction extends Marche{

	private String type;
	
	
	public MarcheAction(String type,int idMarche, int idEntreprise, double prixCourant, double prixBas, double prixHaut) {
		super(idMarche, idEntreprise, prixCourant, prixBas, prixHaut);
		this.type=type;
	}

	
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
