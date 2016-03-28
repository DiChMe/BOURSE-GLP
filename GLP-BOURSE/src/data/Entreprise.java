package data;

import java.util.HashMap;

import action.EventRepository;

public class Entreprise {
	
	
	
	private String nom;
	private double capital;
	private double seuil;
    private HashMap<String, Evenement> evenements = new HashMap<String, Evenement>();
	private String type;
	private int idEntrerpise=0;
	int proportion=0;
	private int idMarcheAction=-1;
	private int idMarcheObligation = -1;
	private int sommeEffet=0;
	
	private int nbAcheteur;
	private int nbVendeur;
	private int nbNeutre;
	
	private double dette=0;
    
	public double getDette() {
		return dette;
	}

	public void setDette(double dette) {
		this.dette = dette;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getSeuil() {
		return seuil;
	}

	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}

	

	public int getProportion() {
		return proportion;
	}

	public void setProportion(int proportion) {
		this.proportion = proportion;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public Entreprise(String type, String name, double capital) {
		this.nom = name;
		this.capital = capital;
		this.seuil=((double)capital*(0.35));
		this.type=type;
		
	}

	public String getName() {
		return nom;
	}

	public void setName(String name) {
		nom = name;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		capital = capital;
	}

	public double getDanger() {
		return seuil;
	}

	public void setDanger(double danger) {
		this.seuil = danger;
	}

	public HashMap<String, Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(HashMap<String, Evenement> evenements) {
		this.evenements = evenements;
	}

	public int getIdEntrerpise() {
		return idEntrerpise;
	}

	public void setIdEntrerpise(int idEntrerpise) {
		this.idEntrerpise = idEntrerpise;
	}

	public int getIdMarcheAction() {
		return idMarcheAction;
	}

	public void setIdMarcheAction(int idMarcheAction) {
		this.idMarcheAction = idMarcheAction;
	}

	public int getIdMarcheObligation() {
		return idMarcheObligation;
	}

	public void setIdMarcheObligation(int idMarcheObligation) {
		this.idMarcheObligation = idMarcheObligation;
	}

	public int getSommeEffet() {
		return sommeEffet;
	}

	public void setSommeEffet(int sommeEffet) {
		this.sommeEffet = sommeEffet;
	}

	public int getNbAcheteur() {
		return nbAcheteur;
	}

	public void setNbAcheteur(int nbAcheteur) {
		this.nbAcheteur = nbAcheteur;
	}

	public int getNbVendeur() {
		return nbVendeur;
	}

	public void setNbVendeur(int nbVendeur) {
		this.nbVendeur = nbVendeur;
	}

	public int getNbNeutre() {
		return nbNeutre;
	}

	public void setNbNeutre(int nbNeutre) {
		this.nbNeutre = nbNeutre;
	}

	
	
	
	
}
