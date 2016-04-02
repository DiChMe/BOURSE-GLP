package data;

public class MarcheAction extends Marche{

	
	
	
	public MarcheAction(String type,int idMarche, int idEntreprise, double prixCourant, double prixBas, double prixHaut) {
		super(idMarche, idEntreprise, prixCourant, prixBas, prixHaut);
		super.setType(type);
	}

	
	
	

}
