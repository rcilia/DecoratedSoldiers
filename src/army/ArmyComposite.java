package army;

import java.util.ArrayList;
import java.util.List;

import observer.Observer;

import soldier.SoldierItf;
import visitor.VisitorInterface;


public class ArmyComposite extends Army {
	private List<SoldierItf> childArmies = new ArrayList<SoldierItf>();
		
	public ArmyComposite() {
		super();
	}

	@Override
	public int strike() {
		int totalStrike = 0;
		
		for (SoldierItf a : childArmies) {
			totalStrike += a.strike();
		}		
		return totalStrike;
	}

	@Override
	public void parry(int strength) {
		for (SoldierItf a : childArmies) {
			a.parry(strength / childArmies.size());
		}
		
		this.notifyObservers();
	}

	public void addSoldier(SoldierItf a) {
		childArmies.add(a);
	}
	
	public void removeSoldier(SoldierItf a) {
		childArmies.remove(a);
	}

	public void accept(VisitorInterface v) 
	{
		v.visitArmy(this);
		for(SoldierItf a : childArmies) {
			a.accept(v);
		}
	}

	@Override
	public void notifyObservers() {
		super.notifyObservers();
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
	public int getHealthPoints() {
		int armyHealth = 0;
		for(SoldierItf soldier : childArmies) {
			armyHealth += soldier.getHealthPoints();
		}
		return armyHealth;
	}	
	
	@Override
	public void update(SoldierItf object) {
		super.update(object);
	}
	
	public List<SoldierItf> getChildArmies() {
		return this.childArmies;
	}
}
