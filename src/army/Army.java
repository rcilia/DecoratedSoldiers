package army;
import soldier.SoldierItf;
import visitor.VisitorInterface;


public abstract class Army extends SoldierItf {
	public abstract int strike();
	public abstract void parry(int strength);
	public abstract void accept(VisitorInterface v);
}
