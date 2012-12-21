package soldier;
import observer.Observer;
import visitor.VisitorInterface;
import weapon.WeaponDecorator;

public class ProxySoldier extends SoldierItf{

	private SoldierItf soldier;
	
	
	public ProxySoldier(SoldierItf soldier) {
		this.soldier = soldier;
	}

	@Override
	public int strike() {
		return soldier.strike();
	}

	@Override
	public void parry(int strength) {
		soldier.parry(strength);
	}


	public <T> void addWeapon(Class<T> c) {	
		SoldierItf it = soldier;
		while(it instanceof WeaponDecorator) {
			if (it.getClass().equals(c)) {
				System.out.println("Ce soldat est déjà équipé de cette arme : " + c.getSimpleName());
				return;
				}
			else
				it = ((WeaponDecorator) it).deleg();	
		}
		
		try {
			soldier = (SoldierItf) c.getConstructor(SoldierItf.class).newInstance(soldier);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void accept(VisitorInterface v) {
		soldier.accept(v);
	}

	@Override
	public void notifyObservers() {
		soldier.notifyObservers();
	}

	@Override
	public void addObserver(Observer ob) {
		soldier.addObserver(ob);
	}
	
	@Override
	public void removeObserver(Observer ob) {
		soldier.removeObserver(ob);
	}
	
	@Override
	public int getHealthPoints() {
		return soldier.getHealthPoints();
	}

	@Override
	public void update(SoldierItf object) {
		soldier.update(object);
	}
	
	public SoldierItf getSoldier() {
		return this.soldier;
	}
}








