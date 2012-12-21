package weapon;
import soldier.SoldierItf;


public class ShieldDecorator extends WeaponDecorator {

	public ShieldDecorator (SoldierItf s) {
		super(s);
		strikePower = 60;
		parryPower = 100;
		
		weaponLife = 200;
		strikeDamages = 5;
		parryDamages = 2;
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
