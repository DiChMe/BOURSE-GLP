package action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import data.Bourse;
import data.Entreprise;
import data.Evenement;
import data.Factory;
import data.Marche;
import data.MarcheAction;
import data.Ordre;

public class BourseFonction {
	

	
	public static void ajouterCreerEntreprise(Bourse bourse, String type, String nom, double capital){
		
		Entreprise entreprise = Factory.CreatEntreprise(type, nom, capital);
		entreprise.setIdEntrerpise(bourse.getIdEntreprise());
		
		
		bourse.getListEntreprise().put(entreprise.getIdEntrerpise(), entreprise);
		bourse.setIdEntreprise(bourse.getIdEntreprise()+1);
	}
	
	public static void ajouterEntreprise(Bourse bourse, Entreprise entreprise){
		
		entreprise.setIdEntrerpise(bourse.getIdEntreprise());
		
		bourse.getListEntreprise().put(entreprise.getIdEntrerpise(), entreprise);
		bourse.setIdEntreprise(bourse.getIdEntreprise()+1);
	
		
	}
	

		
	public static void ajouterCreerEvenementAvecIDEntreprise(Bourse bourse,int idEntreprise, String nom, int effet){
		
		Evenement evenement = Factory.CreatEvenement(nom, effet);
		bourse.getListEntreprise().get(idEntreprise).getEvenements().put(evenement.getName(), evenement);
		bourse.getListEvenement().add(nom);
	}
	
	public static void ajouterEvenementDansEntrepriseID(Bourse bourse, Evenement evenement, int idEntreprise){
		
		bourse.getListEntreprise().get(idEntreprise).getEvenements().put(evenement.getName(), evenement);
		bourse.getListEvenement().add(evenement.getName());
		
	}
	
	
	public static void ajouterCreerMarcheAction(Bourse bourse, int idEntreprise, double prixCourant, double prixBas, double prixHaut){
		
		if (bourse.getListEntreprise().containsKey(idEntreprise)&&(bourse.getListEntreprise().get(idEntreprise).getIdMarcheAction()==-1)){
			Marche marche = Factory.CreatMarcheAction(bourse.getIdMarche(), idEntreprise, prixCourant, prixBas, prixHaut);
			bourse.getListMarche().put(marche.getIdMarche(), marche);
			bourse.setIdMarche(bourse.getIdMarche()+1);
			bourse.getListEntreprise().get(idEntreprise).setIdMarcheAction(marche.getIdMarche());
		}
	}
	
	public static void ajouterCreerMarcheObligation(Bourse bourse, int idEntreprise, double prixCourant, double prixBas, double prixHaut, int dureeVie, int interet){
		if (bourse.getListEntreprise().containsKey(idEntreprise)&&(bourse.getListEntreprise().get(idEntreprise).getIdMarcheObligation()==-1)){
			Marche marche = Factory.CreatMarcheObligation(bourse.getIdMarche(), idEntreprise, prixCourant, prixBas, prixHaut, dureeVie, interet);
			bourse.getListMarche().put(marche.getIdMarche(), marche);
			bourse.setIdMarche(bourse.getIdMarche()+1);
			bourse.getListEntreprise().get(idEntreprise).setIdMarcheObligation(marche.getIdMarche());
		}
	}
	
	public static void ajouterMarcheAction(Bourse bourse, MarcheAction marche){
		
		if (bourse.getListEntreprise().containsKey(marche.getIdEntreprise())&&(bourse.getListEntreprise().get(marche.getIdEntreprise()).getIdMarcheAction()==-1)){
			marche.setIdMarche(bourse.getIdMarche());
			bourse.getListMarche().put(marche.getIdMarche(), marche);
			bourse.setIdMarche(bourse.getIdMarche()+1);
			bourse.getListEntreprise().get(marche.getIdEntreprise()).setIdMarcheAction(marche.getIdMarche());
			
		}
	}
	
	public static void ajouterMarcheObligation(Bourse bourse, MarcheAction marche){
		
		if (bourse.getListEntreprise().containsKey(marche.getIdEntreprise())&&(bourse.getListEntreprise().get(marche.getIdEntreprise()).getIdMarcheObligation()==-1)){
			marche.setIdMarche(bourse.getIdMarche());
			bourse.getListMarche().put(marche.getIdMarche(), marche);
			bourse.setIdMarche(bourse.getIdMarche()+1);
			bourse.getListEntreprise().get(marche.getIdEntreprise()).setIdMarcheObligation(marche.getIdMarche());
			
		}
	}
	
	public static Entreprise getEntrepriseParID(Bourse bourse, int idEntreprise){
		return bourse.getListEntreprise().get(idEntreprise);
	}
	
	public static Marche getMarcheParID(Bourse bourse, int idMarche){
		return bourse.getListMarche().get(idMarche);
	}
	
	public static Evenement getEvenementParID(Bourse bourse, int idEntreprise, String nom){
		return bourse.getListEntreprise().get(idEntreprise).getEvenements().get(nom);
	}
	
	public static void supprimerMarcheActionParID(Bourse bourse, int idMarche){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if (bourse.getJoueur().getListTitre().contains(idMarche)){
			bourse.getJoueur().getListTitre().remove(idMarche);
		}
		
		Collection <Ordre> values = bourse.getJoueur().getListOrdre().values();
		for (Ordre ordre : values){
			if (ordre.getIdEntreprise() == bourse.getListMarche().get(idMarche).getIdEntreprise()){
				list.add(ordre.getID());
			}
			
		}
		
		if(bourse.getListMarche().containsKey(idMarche)){
			bourse.getListEntreprise().get(bourse.getListMarche().get(idMarche)).setIdMarcheAction(-1);
			bourse.getListMarche().remove(idMarche);
		}
		
		for(int i =0; i < list.size(); i++){
			bourse.getJoueur().getListOrdre().remove(list.get(i));
		}
			
	}
	
	public static void supprimerMarcheObligationParID(Bourse bourse, int idMarche){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if (bourse.getJoueur().getListTitre().contains(idMarche)){
			bourse.getJoueur().getListTitre().remove(idMarche);
		}
		
		Collection <Ordre> values = bourse.getJoueur().getListOrdre().values();
		for (Ordre ordre : values){
			if (ordre.getIdEntreprise() == bourse.getListMarche().get(idMarche).getIdEntreprise()){
				list.add(ordre.getID());
			}
			
		}
		
		if(bourse.getListMarche().containsKey(idMarche)){
			bourse.getListEntreprise().get(bourse.getListMarche().get(idMarche)).setIdMarcheObligation(-1);
			bourse.getListMarche().remove(idMarche);
		}
		
		for(int i =0; i < list.size(); i++){
			bourse.getJoueur().getListOrdre().remove(list.get(i));
		}
			
	}
	
	public static void supprimerEvenementDeBourse(Bourse bourse, String nom){
		bourse.getListEvenement().remove(nom);
		
		Collection<Entreprise> values = bourse.getListEntreprise().values();
		for (Entreprise entreprise : values){
			if(entreprise.getEvenements().containsKey(nom)){
				bourse.getListEntreprise().get(entreprise.getIdEntrerpise()).getEvenements().remove(nom);
			}
		}
	}
	
	public static void supprimerEvenementDeEntreprise(Bourse bourse, int idEntreprise, String nom){
		bourse.getListEntreprise().get(idEntreprise).getEvenements().remove(nom);
		
	}
	
	public static void supprimerEvenementDeType(Bourse bourse, String type, String nomEvenement){
		
		Collection<Entreprise> values = bourse.getListEntreprise().values();
		for (Entreprise entreprise : values){
			if(entreprise.getType().equals(type)){
				if(entreprise.getEvenements().containsKey(nomEvenement)){
					entreprise.getEvenements().remove(nomEvenement);
				}
			}
		}
	}
	
	public static void supprimerEntrepriseParID(Bourse bourse, int idEntreprise){
		
		if (bourse.getListEntreprise().get(idEntreprise).getIdMarcheAction()!=-1){
			bourse.getListMarche().remove(bourse.getListEntreprise().get(idEntreprise).getIdMarcheAction());
		}
		
		if (bourse.getListEntreprise().get(idEntreprise).getIdMarcheObligation()!=-1){
			bourse.getListMarche().remove(bourse.getListEntreprise().get(idEntreprise).getIdMarcheObligation());
		}
		bourse.getListEntreprise().remove(idEntreprise);
		

	}
	
	public static void genererEntreprise(Bourse bourse, String chemin){
		String ligne, tableau[];
		try{
			BufferedReader reader = new BufferedReader(new FileReader(chemin));
			
			while((ligne = reader.readLine()) != null){
				tableau = ligne.split(":");
				double capital = Double.parseDouble(tableau[2]);
				Entreprise entreprise = Factory.CreatEntreprise(tableau[0], tableau[1], capital);
				ajouterEntreprise(bourse,entreprise);
				}
			reader.close();
			}catch (IOException e) {
				System.err.println(e.getMessage());
			}
		
		
	}
	
	public static void ajouterCarnetEvenementParType(Bourse bourse, String type, HashMap<String,Evenement> carnetEvenement){
		boolean typeexiste= false;
		Collection <Entreprise> values = bourse.getListEntreprise().values();
		for(Entreprise entreprise : values){
			if(entreprise.getType().equals(type)){
				typeexiste=true;
				getEntrepriseParID(bourse, entreprise.getIdEntrerpise()).setEvenements(carnetEvenement);
			}
		}
		
		if(typeexiste){
			Collection <Evenement> valuesEvenement = carnetEvenement.values();
			for(Evenement evenement : valuesEvenement){
				if(bourse.getListEvenement().contains(evenement.getName())==false){
					bourse.getListEvenement().add(evenement.getName());
				}	
			}		
		}
	}
	
	public static void ajouterOrdreJoueur(Bourse bourse, Ordre ordre){
		
		
		
		if (bourse.getListMarche().containsKey(ordre.getIdMarche())){
			
			if(ordre.getID()==((bourse.getJoueur().getIdOrdre())-1)&&(bourse.getJoueur().getListOrdre().containsKey((bourse.getJoueur().getIdOrdre())-1))==false){
				bourse.getJoueur().getListOrdre().put(ordre.getID(), ordre);
			}else{
				ordre.setID(bourse.getJoueur().getIdOrdre());
				bourse.getJoueur().setIdOrdre(bourse.getJoueur().getIdOrdre()+1);
				bourse.getJoueur().getListOrdre().put(ordre.getID(), ordre);
			}
		
			OrderBookFonction.addOrdre(bourse.getListMarche().get(ordre.getIdMarche()).getCarnetOrdre(), ordre);
			
		}else{
			
		}
	}
	
	
	
	public static void supprimerOrdreJoueur(Bourse bourse, int idOrdre){
		if (bourse.getJoueur().getListOrdre().containsKey(idOrdre)){
			bourse.getJoueur().getListOrdre().remove(idOrdre);
		}
	}
	
	
	public static void ajouterCreerEvenementParType(Bourse bourse , String type,String nom, int effet){
		boolean typeexiste=false;
		
		Evenement evenement = new Evenement(nom, effet);
		
		Collection<Entreprise> values = bourse.getListEntreprise().values();
		
		for (Entreprise entreprise : values){
			if (entreprise.getType().equals(type)){
				typeexiste=true;
				entreprise.getEvenements().put(evenement.getName(), evenement);
			}
		}
		
		if (typeexiste==true){
			if(bourse.getListEvenement().contains(evenement.getName())==false){
				bourse.getListEvenement().add(evenement.getName());
			}
		}
	}
	
	
	public static String toString(Bourse bourse){
		String tmp ="--------Joueur--------\n";
		tmp+="noms:"+bourse.getJoueur().getNom()+"\n"+"Capitale:"+bourse.getJoueur().getCapital()+"\n";
		tmp+= "listeTitreid:\n";
		
		for (int i=0; i < bourse.getJoueur().getListTitre().size(); i++ ){
			tmp+="-idTitre: "+bourse.getJoueur().getListTitre().get(i)+"\n";
		}
		tmp+="Lite Ordre:\n";
		
		Collection<Ordre> values = bourse.getJoueur().getListOrdre().values();
		
		for (Ordre ordre : values){
			tmp+="--Ordreid: "+ordre.getID()+"\n";
			tmp+="-OrdreidEntreprise: "+ordre.getIdEntreprise()+"\n";
			
		}
		
		tmp+="-----------------------------------\n\n";
		
		tmp+="--------ListeEntreprise---------------\n";
		
		Collection<Entreprise> valuesE = bourse.getListEntreprise().values();
		
		for (Entreprise entreprise : valuesE){
			tmp+="\n\n Entreprise "+entreprise.getName()+": \n";
			tmp+="-id: "+entreprise.getIdEntrerpise()+"\n";
			tmp+="-type: "+entreprise.getType()+"\n";
			tmp+="-Capital:"+entreprise.getCapital()+"\n";
			tmp+="-idMarcheObligatoin:"+entreprise.getIdMarcheObligation()+"\n";
			tmp+="-idMarcheAction:"+entreprise.getIdMarcheAction()+"\n";
			
			tmp+="--Liste Evenement de l'entreprise"+entreprise.getName()+": \n";
			Collection <Evenement> valuesEv= entreprise.getEvenements().values();
			
			for(Evenement evenement : valuesEv){
				tmp+="Evenement "+evenement.getName()+"\n";
				tmp+="Effet de l'evenement"+evenement.getName()+":"+evenement.getEffet()+"\n\n";
			}
			tmp+="--fin liste evenement";	
		}
		
		tmp+="------------------------------------------\n\n";
		
		tmp+="--------Liste Marche ---------------------\n";
		
		Collection <Marche> valuesM = bourse.getListMarche().values();
		
		for(Marche marche : valuesM){
			tmp+="--Marche id:"+marche.getIdMarche()+":\n";
			tmp+="- id entreprise: "+marche.getIdEntreprise()+"\n";	
			tmp+="\n---carnetOrdre----";
			tmp+="\n -Odre achat";
			System.out.println(marche.getCarnetOrdre().getAchat());
		}
		tmp+="-----------------------------------------\n\n";
		
		tmp+="------Liste Evenement--------------------\n";
		for(int i=0; i < bourse.getListEvenement().size(); i++){
			tmp+="- "+bourse.getListEvenement().get(i)+"\n";
		}
		
		tmp+="--------------------------------------------";
		
		return tmp;
		
		
			
	}
	
}
