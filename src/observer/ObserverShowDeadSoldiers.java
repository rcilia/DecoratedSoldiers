package observer;
import soldier.SoldierItf;


public class ObserverShowDeadSoldiers implements Observer {
	private String soldiersNames = new String();

	private static ObserverShowDeadSoldiers instance = null;
	
	public static ObserverShowDeadSoldiers getInstance() {
		if(ObserverShowDeadSoldiers.instance == null)
		instance = new ObserverShowDeadSoldiers();
		
		return instance;
	}
	
	protected ObserverShowDeadSoldiers() {
		ObserverShowDeadSoldiers.instance = this;
	}
	
	@Override
	public void update(SoldierItf object) {
		if(object.getHealthPoints() <= 0) {
			String message = "Décés de : " + object.getClass().getSimpleName();
			soldiersNames += message;
			System.out.println(message);
		}
	}

	public String getSoldiersNames() {
		return soldiersNames;
	}

}
