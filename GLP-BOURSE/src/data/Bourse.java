package data;

import java.util.ArrayList;
import java.util.HashMap;

public class Bourse {

	private Joueur joueur;
	private HashMap<Integer,Entreprise>listEntreprise;
	private HashMap<Integer,Marche>listMarche;
	private ArrayList<String> listEvenement;
	//private HashMap<String,MarcheTerme> listMarcheTerme;
	private int idEntreprise=0;
	private int idMarche=0;
	
	public Bourse(){
		listEntreprise= new HashMap<Integer,Entreprise>();
		listMarche= new HashMap<Integer,Marche>();
		listEvenement= new ArrayList<String>();
	}
	
	public Bourse(Joueur joueur, HashMap<Integer, Entreprise> listEntreprise, HashMap<Integer, Marche> listMarche,
			ArrayList<String> listEvenement) {
		super();
		this.joueur = joueur;
		this.listEntreprise = listEntreprise;
		this.listMarche = listMarche;
		this.listEvenement = listEvenement;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public HashMap<Integer, Entreprise> getListEntreprise() {
		return listEntreprise;
	}
	public void setListEntreprise(HashMap<Integer, Entreprise> listEntreprise) {
		this.listEntreprise = listEntreprise;
	}
	public HashMap<Integer, Marche> getListMarche() {
		return listMarche;
	}
	public void setListMarche(HashMap<Integer, Marche> listMarche) {
		this.listMarche = listMarche;
	}
	public ArrayList<String> getListEvenement() {
		return listEvenement;
	}
	public void setListEvenement(ArrayList<String> listEvenement) {
		this.listEvenement = listEvenement;
	}

	public int getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public int getIdMarche() {
		return idMarche;
	}

	public void setIdMarche(int idMarche) {
		this.idMarche = idMarche;
	}

}
    
	

