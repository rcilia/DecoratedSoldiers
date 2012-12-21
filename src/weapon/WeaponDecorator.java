package weapon;
import observer.Observer;
import soldier.SoldierItf;
import visitor.VisitorInterface;


public class WeaponDecorator extends SoldierItf {
	
	protected int strikePower;
	protected int parryPower;
	private SoldierItf soldier;
	protected int weaponLife;
	protected int strikeDamages;
	protected int parryDamages;
	
	public WeaponDecorator (SoldierItf s) {
		this.soldier = s ;
	}
	
	public int strike() {
		if ((this.weaponLife - this.strikeDamages) < 0)
			this.weaponLife = 0;
		else
			this.weaponLife -= this.strikeDamages;
			
		return soldier.strike();
	}
	
	public void parry (int strength) {
		if ((this.weaponLife - this.parryDamages) < 0)
			this.weaponLife = 0;
		else
			this.weaponLife -= this.parryDamages;
		
		soldier.parry((strength > 0) ? strength : 0);
	}
	
	public SoldierItf deleg() {
		return soldier;
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
		soldier.addObserver(ob);		
	}

	@Override
	public int getHealthPoints() {
		return soldier.getHealthPoints();
	}
	
	public void update(SoldierItf soldier) {
		this.soldier.update(soldier);
	}
}
