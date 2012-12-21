package soldier;

import observer.Observer;
import visitor.VisitorInterface;

public class Horseman extends SoldierAbstract {

	public Horseman(){
		strikePower = 120 ;
		healthPoints = 200 ;
	}
		
	public int strike() {
		return strikePower ;
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}
	
	public void parry(int strength) {
		this.healthPoints -= strength ;
		this.notifyObservers();
	}

	@Override
	public void accept(VisitorInterface v) {
		v.visitMounted(this);		
	}

	@Override
	public void addObserver(Observer ob) {
		super.addObserver(ob);
	}
	
	@Override
	public void removeObserver(Observer ob) {
		super.removeObserver(ob);
	}
	
	@Override
	public void notifyObservers() {
		super.notifyObservers();
	}
	
	@Override
	public void update(SoldierItf object) {
		super.update(object);
	}
}
