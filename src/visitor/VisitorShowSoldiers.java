package visitor;
import soldier.SoldierItf;



public class VisitorShowSoldiers implements VisitorInterface {

	@Override
	public void visitArmy(SoldierItf a) {
		System.out.println(a.getClass().getSimpleName());		
	}

	@Override
	public void visitFoot(SoldierItf a) {
		System.out.println(a.getClass().getSimpleName());		
	}

	@Override
	public void visitMounted(SoldierItf a) {
		System.out.println(a.getClass().getSimpleName());		
	}
}
