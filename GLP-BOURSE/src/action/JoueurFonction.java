package action;

import data.Joueur;
import data.Ordre;

public class JoueurFonction {
	
	public static void genererIdpourOrdre(Joueur joueur, Ordre ordre){
		ordre.setID(joueur.getIdOrdre());
		joueur.setIdOrdre(joueur.getIdOrdre()+1);;
	}
	
}
