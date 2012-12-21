package observer;
import soldier.SoldierItf;


public class ObserverCountDeadSoldiers implements Observer {
	
	private String countDown = new String();
	
	private static int deadSoldiers = 0;
	private static ObserverCountDeadSoldiers instance = null;
	
	public static ObserverCountDeadSoldiers getInstance() {
		if(ObserverCountDeadSoldiers.instance == null)
		instance = new ObserverCountDeadSoldiers();
		
		return instance;
	}
	
	private ObserverCountDeadSoldiers() {
		ObserverCountDeadSoldiers.instance = this;
	}
	
	public String getCountDown() {
		return countDown;
	}
	
	@Override
	public void update(SoldierItf object) {
		if(object.getHealthPoints() <= 0) {
			++deadSoldiers;
			String message = "Nombre de soldat morts au combat : " + deadSoldiers;
			countDown += message;
			System.out.println(message);
		}
	}

}
