package data;

import java.util.Collections;
import java.util.PriorityQueue;

public class OrderBook {
	
	PriorityQueue<Ordre> vente;
	PriorityQueue<Ordre> achat;
	
	
	
	
	
	public OrderBook() {
		
		this.vente = new PriorityQueue<Ordre>(10000);
		this.achat = new PriorityQueue<Ordre>(10000,Collections.reverseOrder());
	}
	
	
	public PriorityQueue<Ordre> getVente() {
		return vente;
	}
	public void setVente(PriorityQueue<Ordre> vente) {
		this.vente = vente;
	}
	public PriorityQueue<Ordre> getAchat() {
		return achat;
	}
	public void setAchat(PriorityQueue<Ordre> achat) {
		this.achat = achat;
	}


	public Ordre minVente() {
		// TODO Auto-generated method stub
		return vente.peek();
	}


	public Ordre maxAchat() {
		// TODO Auto-generated method stub
		return achat.peek();
	}
	
	

}
