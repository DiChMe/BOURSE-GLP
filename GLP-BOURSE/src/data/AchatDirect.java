package data;

import java.util.Date;

public class AchatDirect extends Ordre{
	
	
	String type;
	
	

	public AchatDirect(String type,Acteur acteur, int quant, Date date,int identreprise) {
		super(acteur, quant, date,identreprise);
		setPrix(1000);
		this.type=type;
	}

	@Override
	public String getType() {
		
		return "achat";
	}

}
