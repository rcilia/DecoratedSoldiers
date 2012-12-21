package abstractFactory;

import army.ArmyComposite;
import soldier.FootMan;
import soldier.Horseman;
import soldier.ProxySoldier;
import weapon.ShieldDecorator;
import weapon.SwordDecorator;

public class MiddleAgeFactory extends AbstractFactory {

	@Override
	public ArmyComposite createArmy() {
		return new ArmyComposite();
	}
	
	@Override
	public ProxySoldier createFootSoldier() {
		return  new ProxySoldier(new FootMan());
	}

	@Override
	public ProxySoldier createMountedSoldier() {
		return new ProxySoldier(new Horseman());
	}

	@Override
	public void addAttackWeapon(ProxySoldier soldier) {
		soldier.addWeapon(SwordDecorator.class);
	}

	@Override
	public void addDefenseWeapon(ProxySoldier soldier) {
		soldier.addWeapon(ShieldDecorator.class);
	}
}
