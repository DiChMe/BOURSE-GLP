package action;

import data.*;

public class OrderBookFonction {
	
	public static int NBEXE=0;
	
	public static void addOrdre(OrderBook book,Ordre ordre ){
		
		if(ordre.getType().equals("vente")){
			book.getVente().add(ordre);
		}else{
			book.getAchat().add(ordre);
		}
		
	}
/*	
	public static void addVente(OrderBook book,Ordre ordre ){
		
		book.getVente().add(ordre);
	}
	
public static void addachat(OrderBook book,Ordre ordre ){
		
		book.getAchat().add(ordre);
	}
	*/
	
	public static void ExecuteOrder(OrderBook book){
		
		
		while(execution(book)==true){
			
			Ordre vente=book.getVente().peek();
			Ordre achat=book.getAchat().peek();
			Acteur vendeur=vente.getActeur();
			Acteur achteur=achat.getActeur();
			
			if(vente.getQuantite()==achat.getQuantite()){
				vendeur.setDernierCapital(vendeur.getCapital()); 
				vendeur.setCapital(vendeur.getCapital()+vente.getQuantite()*achat.getPrix());
				
				achteur.setDernierCapital(achteur.getCapital());
				achteur.setCapital(achteur.getCapital()-vente.getQuantite()*achat.getPrix());
				
				book.getAchat().poll();
				book.getVente().poll();
				NBEXE++;
				
			}else{
				
				if(vente.getQuantite()>achat.getQuantite()){
					int dif=vente.getQuantite() - achat.getQuantite();
					
					vendeur.setDernierCapital(vendeur.getCapital()); 
					vendeur.setCapital(vendeur.getCapital()+achat.getQuantite()*achat.getPrix());
					
					achteur.setDernierCapital(achteur.getCapital());
					achteur.setCapital(achteur.getCapital()-achat.getQuantite()*achat.getPrix());
					
					book.getAchat().poll();
					vente.setQuantite(dif);
					NBEXE++;
					
				}else{
					
					int dif= achat.getQuantite() - vente.getQuantite();
					
					vendeur.setDernierCapital(vendeur.getCapital()); 
					vendeur.setCapital(vendeur.getCapital()+vente.getQuantite()*achat.getPrix());
					
					achteur.setDernierCapital(achteur.getCapital());
					achteur.setCapital(achteur.getCapital()-vente.getQuantite()*achat.getPrix());
					
					book.getVente().poll();
					achat.setQuantite(dif);
					NBEXE++;
					
				}
			
				
			}
			
			
			
			
			
		}
		
		
	}
	
	public  static boolean execution(OrderBook book){
		if(book.getAchat().isEmpty() || book.getVente().isEmpty()){
			
			return false;
		}else
		
		{if(book.getVente().peek().getPrix()<=book.getAchat().peek().getPrix()){
			return true;
		}else{
			return false;
		}
		}
	}

}
