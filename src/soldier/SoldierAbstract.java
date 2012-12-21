package soldier;


public abstract class SoldierAbstract extends SoldierItf {

	protected int healthPoints ;
	protected int strikePower ;
			
	public abstract int strike();
	public abstract void parry(int strength);
}
