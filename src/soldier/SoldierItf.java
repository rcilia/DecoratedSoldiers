package soldier;
import java.util.ArrayList;
import java.util.List;

import observer.Observer;

import visitor.VisitorInterface;


public abstract class SoldierItf implements Observer {
	private List<Observer> observers = new ArrayList<Observer>();
	private static String telegramme = new String();
	
	public abstract int strike();
	public abstract void parry(int strength);
	public abstract void accept(VisitorInterface v);
	public abstract int getHealthPoints();
	
	public void notifyObservers() {
		for (Observer obs : this.observers) {
			obs.update(this);
		}
	}
	
	public void addObserver(Observer ob) {
		this.observers.add(ob);
	}
	
	public void removeObserver(Observer ob) {
		this.observers.remove(ob);
	}
	
	public void update(SoldierItf object) {
		if(object.getHealthPoints() <= 0) {
			String message = this.getClass().getSimpleName() + " a reçu une lettre de condoléances de la part de " + object.getClass().getSimpleName();
			telegramme += message;
			System.out.println(message);
		}
	}
	
	public String getTelegramme() {
		return telegramme;
	}
}
