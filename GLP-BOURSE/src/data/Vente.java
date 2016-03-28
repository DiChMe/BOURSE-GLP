package data;

import java.util.Date;

public class Vente  extends Ordre{

	String type;
	public Vente(String type,Acteur acteur, int quantite, Date date,double prix, int idenreprise) {
		super(acteur, quantite, date,idenreprise);
		setPrix(prix);
		this.type=type;
		
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
