package data;

import java.util.Date;
import java.util.HashMap;

public class Factory {
	
	public static Ordre CreatOrdre(String type,Acteur acteur,double prix,int quantite,int identreprise){
		
		switch(type){
		
		case "vente": 			return new Vente(type, acteur, quantite,new Date(),prix,identreprise);
							
		case "achatIndirect":	return new AchatIndirect(type, acteur, quantite,new Date(),prix,identreprise);
		
		case "achatDirect":		return new AchatDirect(type, acteur, quantite,new Date(),identreprise);
		
		default:
			return null;
		
		}
		
		
	}
	
	public static Evenement CreatEvenement(String nom, int effet){
		
		return new Evenement(nom,effet);
	}
	
	public static Entreprise CreatEntreprise(String type,String nom, double capital){
		
		return new Entreprise(type,nom,capital);
	}
	
	public static Marche CreatMarcheAction(int idMarche, int idEntreprise, double prixCourant, double prixBas, double prixHaut){
		
					return new MarcheAction("Action",idMarche, idEntreprise, prixCourant, prixBas, prixHaut);
	}
	
	public static Marche CreatMarcheObligation(int idMarche, int idEntreprise, double prixCourant, double prixBas, double prixHaut, int dureeVie, int interet){
		
		return new MarcheObligation("Obligation",idMarche, idEntreprise, prixCourant, prixBas, prixHaut, dureeVie, interet);

	}
	
	public static Acteur CreatActeur(String type,String name,double capital){
		
		switch(type){
		
		case "machine": 
					return new Machine(name,capital);
					
		case "joueur":
			
				   return new Joueur(name,capital);
				   
		default:
			
				  return null;
		
		
		}
		
		//ajouter Creer Marché
		
		
	}
	
	public static HashMap<String, Evenement> CreatHashMapCarnetEvenement(){
		return new HashMap<String,Evenement>();
	}

}
