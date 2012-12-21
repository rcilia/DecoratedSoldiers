package soldier;

import observer.Observer;
import visitor.VisitorInterface;


public class FootMan extends SoldierAbstract {

	public FootMan(){
		strikePower = 100 ;
		healthPoints = 100 ;
	}
		
	public int strike() {
		return strikePower ;
	}
	
	public void parry(int strength) {
		this.healthPoints -= strength;
		super.notifyObservers();
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}

	@Override
	public void accept(VisitorInterface v) {
		v.visitFoot(this);		
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
