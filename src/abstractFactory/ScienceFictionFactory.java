package abstractFactory;

import army.ArmyComposite;
import soldier.ProxySoldier;
import soldier.Stormtrooper;
import soldier.XWing;
import weapon.LaserCannonDecorator;
import weapon.LaserShieldDecorator;

public class ScienceFictionFactory extends AbstractFactory {

	@Override
	public ArmyComposite createArmy() {
		return new ArmyComposite();
	}
	
	@Override
	public ProxySoldier createFootSoldier() {
		return  new ProxySoldier(new Stormtrooper());
	}

	@Override
	public ProxySoldier createMountedSoldier() {
		return  new ProxySoldier(new XWing());
	}

	@Override
	public void addAttackWeapon(ProxySoldier soldier) {
		soldier.addWeapon(LaserCannonDecorator.class);
	}

	@Override
	public void addDefenseWeapon(ProxySoldier soldier) {
		soldier.addWeapon(LaserShieldDecorator.class);
	}
}
