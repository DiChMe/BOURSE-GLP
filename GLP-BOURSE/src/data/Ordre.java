package data;

import java.util.Date;

public abstract class Ordre implements Comparable{
	
	private Acteur acteur;
	private int id=-10;
	private int quantite;
	private double prix;
	private Date date;
	private int idEntreprise;
	private int idMarche;
	
	public int getIdMarche() {
		return idMarche;
	}


	public void setIdMarche(int idMarche) {
		this.idMarche = idMarche;
	}


	public Acteur getActeur() {
		return acteur;
	}


	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
	}


	public int getID() {
		return id;
	}


	public void setID(int iD) {
		id = iD;
	}


	public int getQuant() {
		return quantite;
	}


	public void setQuant(int quant) {
		quantite = quant;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Ordre(Acteur acteur, int quantite, Date date,int identreprise) {
		super();
		this.acteur = acteur;
		this.quantite = quantite;
		this.date = date;
		this.idEntreprise=identreprise;
		
	}
	
	public Ordre(Acteur acteur, int id, int quantite, double prix, Date date, int idEntreprise, int idMarche) {
		super();
		this.acteur = acteur;
		this.id = id;
		this.quantite = quantite;
		this.prix = prix;
		this.date = date;
		this.idEntreprise = idEntreprise;
		this.idMarche = idMarche;
	}


	public abstract String getType();
	
	public int compareTo(Object o) {
		Ordre other= (Ordre) o;
		
		if(getPrix()>other.getPrix() || getPrix()==-1){
			return 1;
		}
		else{
			if(getPrix()<other.getPrix()){
				return -1;
			}else{
				return getDate().compareTo(other.getDate());
			}
			
		}
		
	}

	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public int getIdEntreprise() {
		return idEntreprise;
	}


	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}


	@Override
	public String toString() {
		return "Ordre [id=" + id + ", quantite=" + quantite + ", prix=" + prix + ", idEntreprise=" + idEntreprise
				+ ", idMarche=" + idMarche + "]";
	}

}
