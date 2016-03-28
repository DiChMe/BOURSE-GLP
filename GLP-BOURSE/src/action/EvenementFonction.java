package action;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import data.Bourse;
import data.Entreprise;
import data.Evenement;
import data.Factory;
public class EvenementFonction {
	
	public static void ajouterEvenementDansHashMap(HashMap<String, Evenement> carnetEvenement, String nomEvenement, int effetEvenement){
		Evenement evenement = new Evenement(nomEvenement, effetEvenement);
		carnetEvenement.put(evenement.getName(), evenement);
	}
	
	public static HashMap<String, Evenement> GenererHashMapCarnetEvenement(String chemin){
		String ligne, tableau[];
		try{
			BufferedReader reader = new BufferedReader(new FileReader(chemin));
			HashMap<String, Evenement> carnetEvenement = new HashMap<String, Evenement>();
			
			while((ligne = reader.readLine()) != null){
				tableau = ligne.split(":");
				int effet  = Integer.parseInt(tableau[1]);
				ajouterEvenementDansHashMap(carnetEvenement, tableau[0], effet);
				}
			reader.close();
			return carnetEvenement;
			}catch (IOException e) {
				System.err.println(e.getMessage());
			}
		return null;
	}
	
	public static void executerEvenement(Bourse bourse, String nomEvenement){
		
		Collection<Entreprise> values = bourse.getListEntreprise().values();
		
		for (Entreprise entreprise : values){
			if (entreprise.getEvenements().containsKey(nomEvenement)){
				//methode(entreprise, entrerpise.getListEvenement().get(nomEvenement).getEffet()); 
			}
		}
	}
}
