package weapon;
import soldier.SoldierItf;


public class SwordDecorator extends WeaponDecorator {
	
	public SwordDecorator (SoldierItf s) {
		super(s);
		strikePower = 200;
		parryPower = 50;
		
		weaponLife = 100;
		strikeDamages = 2;
		parryDamages = 5;
	}
		
	public int strike() {
		int totalStrike = super.strike();
		if (weaponLife > 0)
			totalStrike += this.strikePower;
		return totalStrike;
	}
	
	public void parry(int strength) {
		int totalParry = 0;
		
		if (weaponLife > 0)
			totalParry = this.parryPower;
		
		//int left = (strength - totalParry > 0) ? strength - totalParry : 0;
		super.parry (strength - totalParry);
	}
}
