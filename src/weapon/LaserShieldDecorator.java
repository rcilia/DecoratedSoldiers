package weapon;

import soldier.SoldierItf;

public class LaserShieldDecorator extends WeaponDecorator{

	public LaserShieldDecorator (SoldierItf s){
		super(s);
		strikePower = 100;
		parryPower = 1000;
		
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
