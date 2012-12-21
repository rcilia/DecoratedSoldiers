package visitor;
import soldier.SoldierItf;



public class VisitorCountSoldiers implements VisitorInterface {
	
	private int mountedCount;
	private int footCount;

	@Override
	public void visitArmy(SoldierItf a) {
		footCount = 0; 
		mountedCount = 0;
		System.out.println(a.getClass().getSimpleName());	
	}

	@Override
	public void visitFoot(SoldierItf a) {
		++footCount;
		System.out.println("Foot : " + footCount);
	}

	@Override
	public void visitMounted(SoldierItf a) {
		++mountedCount;
		System.out.println("Mounted : " + mountedCount);
	}


}
