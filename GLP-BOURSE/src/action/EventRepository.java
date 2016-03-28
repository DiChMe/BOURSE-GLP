package action;

import java.util.HashMap;
import java.util.Map;

import data.Evenement;



public class EventRepository {
	
	private Map<String, Evenement> evenements = new HashMap<String, Evenement>();

	private EventRepository() {

	}

	private static EventRepository instance = new EventRepository();

	public static EventRepository getInstance() {
		return instance;
	}

	public void register(String name, Evenement event) {
		evenements.put(name, event);
	}

	public Evenement search(Evenement event) {
		return evenements.get(event.getName());
	}


}
