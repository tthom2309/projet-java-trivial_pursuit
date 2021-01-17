package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
	private List<Observer> listeObservers;
	public Observable() {
		listeObservers = new ArrayList<Observer>();
	}
	
	public void ajoute(Observer o) {
		listeObservers.add(o);
	}
	
	public void retire(Observer o) {
		listeObservers.remove(o);
	}
	
	public void notifie() {
		for (Observer o : listeObservers) {
			o.actualise();
		}
	}
}
