package visitor;
import soldier.SoldierItf;



public interface VisitorInterface {
	
	public void visitArmy(SoldierItf a);
	public void visitFoot(SoldierItf a);
	public void visitMounted(SoldierItf a);
}
