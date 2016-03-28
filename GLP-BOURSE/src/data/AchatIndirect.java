package data;

import java.util.Date;

public class AchatIndirect extends Ordre {
	String type;
	public AchatIndirect(String type,Acteur acteur, int quant, Date date,double prix,int identreprise) {
		super(acteur, quant, date,identreprise);
		setPrix(prix);
		this.type=type;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
