package data;

import org.jfree.data.xy.XYSeries;

public abstract class Marche {
	private int idMarche;
	private int idEntreprise;
	private double prixCourant;
	private double prixBas;
	private double prixHaut;
	private OrderBook carnetOrdre;
	private Acteur[][] matriceActeurs=new Acteur[5][5];
	private XYSeries cotation = new XYSeries("cotation");
	
	
	
	public XYSeries getCotation() {
		return cotation;
	}

	public void setCotation(XYSeries cotation) {
		this.cotation = cotation;
	}

	public Marche(int idMarche, int idEntreprise, double prixCourant, double prixBas, double prixHaut) {
		super();
		this.idMarche = idMarche;
		this.idEntreprise = idEntreprise;
		this.prixCourant = prixCourant;
		this.prixBas = prixBas;
		this.prixHaut = prixHaut;
		this.carnetOrdre = new OrderBook();
		
	}
	
	public int getIdMarche() {
		return idMarche;
	}
	
	
	public void setIdMarche(int idMarche) {
		this.idMarche = idMarche;
	}
	
	public int getIdEntreprise() {
		return idEntreprise;
	}
	
	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}
	
	public double getPrixCourant() {
		return prixCourant;
	}
	
	
	public void setPrixCourant(double prixCourant) {
		this.prixCourant = prixCourant;
	}
	
	
	public double getPrixBas() {
		return prixBas;
	}
	
	
	public void setPrixBas(double prixBas) {
		this.prixBas = prixBas;
	}
	
	
	public double getPrixHaut() {
		return prixHaut;
	}
	
	
	public void setPrixHaut(double prixHaut) {
		this.prixHaut = prixHaut;
	}
	
		
	public OrderBook getCarnetOrdre() {
		return carnetOrdre;
	}

	public void setCarnetOrdre(OrderBook carnetOrdre) {
		this.carnetOrdre = carnetOrdre;
	}

	public Acteur[][] getMatriceActeurs() {
		return matriceActeurs;
	}
	
	public void setMatriceActeurs(Acteur[][] matriceActeurs) {
		this.matriceActeurs = matriceActeurs;
	}
	
	

}
