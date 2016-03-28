package data;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GestionOrdre {
	
	public static void TasMax(ArrayList<Ordre> items){
		
		 int k = items.size() - 1;
	        while (k > 0) {
	            int p = (k-1)/2;
	            Ordre item = items.get(k);
	            Ordre parent = items.get(p);
	            if (item.compareTo(parent) > 0) {
	                // swap
	                items.set(k, parent);
	                items.set(p, item);
	                 
	                // move up one level
	                k = p;
	            } else {
	                break;
	            }
	        }	
			
		}


public static void insertAchat(ArrayList<Ordre> items,Ordre item) {
   items.add(item);
   TasMax(items);
}
private static void TasMin(ArrayList<Ordre> items) {
   int k = 0;
   int l = 2*k+1;
   while (l < items.size()) {
       int max=l, r=l+1;
       if (r < items.size()) { // there is a right child
           if (items.get(r).compareTo(items.get(l)) > 0) {
               max++;
           }
       }
       if (items.get(k).compareTo(items.get(max)) < 0) {
               // switch
               Ordre temp = items.get(k);
               items.set(k, items.get(max));
               items.set(max, temp);
               k = max;
               l = 2*k+1;
       } else {
           break;
       }
   }
}

public static void vent(ArrayList<Ordre> items,Ordre or)throws NoSuchElementException{
	
	  if (items.size() == 0) {
         throw new NoSuchElementException();
     }
	  else{
     		while(!items.isEmpty() && or.getQuant()>0){
     			 Ordre hold = items.get(0);
     			
     			if(items.get(0).getQuant()>or.getQuant()){
 		        	items.get(0).setQuant(items.get(0).getQuant()-or.getQuant());
 		        	or.setQuant(0);
 		        	
 		        }else{
 		        	if(items.get(0).getQuant()==or.getQuant()){
 		        		items.set(0, items.remove(items.size()-1));
		  		          TasMin(items);
		  		          break;
 		        	}else{
 		        		
 		        		items.set(0, items.remove(items.size()-1));
	  		  		          TasMin(items);
 		        		or.setQuant(or.getQuant()-hold.getQuant());
 		        	}	
 		        	
 		     }
  		          
		        }
	  } 	
	
}

public static void rec(ArrayList<Ordre> items,Ordre or){
	
	if(items.size()>0 && or.getQuant()>0){
		
		Ordre tmp=items.get(0);
		
		if(tmp.getQuant()>or.getQuant()){
			
			tmp.setQuant(tmp.getQuant()-or.getQuant());
			or.setQuant(0);
		}else{
				//items.remove(0);
			items.set(0, items.remove(items.size()-1));
				or.setQuant(or.getQuant()-tmp.getQuant());
				TasMin(items);
				
			}
		rec(items,or);	
				
			}
			
		}
private static void mise3(ArrayList<Ordre> items) {
   int k = 0;
   int l = 2*k+1;
   while (l < items.size()) {
       int max=l, r=l+1;
       if (r < items.size()) { // there is a right child
           if (items.get(r).compareTo(items.get(l)) < 0) {
               max++;
           }
       }
       if (items.get(k).compareTo(items.get(max)) > 0) {
               // switch
               Ordre temp = items.get(k);
               items.set(k, items.get(max));
               items.set(max, temp);
               k = max;
               l = 2*k+1;
       } else {
           break;
       }
   }
}	
		
public static void recachat(ArrayList<Ordre> items,Ordre or)throws NoSuchElementException{
	
if(items.size()>0 && or.getQuant()>0){
		
		Ordre tmp=items.get(0);
		
		if(tmp.getQuant()>or.getQuant()){
			
			tmp.setQuant(tmp.getQuant()-or.getQuant());
			or.setQuant(0);
		}else{
				items.remove(0);
			//items.set(0, items.remove(items.size()-1));
				or.setQuant(or.getQuant()-tmp.getQuant());
				mise3(items);
				
			}
		recachat(items,or);	
}

}


}
