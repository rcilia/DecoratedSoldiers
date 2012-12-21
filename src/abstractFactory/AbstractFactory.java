package abstractFactory;

import army.ArmyComposite;
import soldier.ProxySoldier;

public abstract class AbstractFactory {
	
	public static AbstractFactory getMiddleAgeFactory() {
		return(new MiddleAgeFactory());
    }
	
	public static AbstractFactory getScienceFictionFactory() {
		return(new ScienceFictionFactory());
    }
	
	public abstract ArmyComposite createArmy();
	public abstract ProxySoldier createFootSoldier();
	public abstract ProxySoldier createMountedSoldier();
	public abstract void addAttackWeapon(ProxySoldier soldier);
	public abstract void addDefenseWeapon(ProxySoldier soldier);
}
