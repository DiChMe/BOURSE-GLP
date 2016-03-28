package data;

import java.util.ArrayList;
import java.util.HashMap;

public class Joueur extends Acteur{

	private HashMap<Integer, Ordre> listOrdre;
	private ArrayList<Integer> listTitre;
	private int idOrdre=0;
	
	




	public Joueur(String nom, double capital) {
		super(nom, capital);
		listOrdre=new HashMap<Integer, Ordre>();
		listTitre=new ArrayList<Integer>();
	}



	public HashMap<Integer, Ordre> getListOrdre() {
		return listOrdre;
	}



	public void setListOrdre(HashMap<Integer, Ordre> listOrdre) {
		this.listOrdre = listOrdre;
	}



	public ArrayList<Integer> getListTitre() {
		return listTitre;
	}

	public void setListTitre(ArrayList<Integer> listTitre) {
		this.listTitre = listTitre;
	}
	
	public int getIdOrdre() {
		return idOrdre;
	}



	public void setIdOrdre(int idOrdre) {
		this.idOrdre = idOrdre;
	}
	

}
