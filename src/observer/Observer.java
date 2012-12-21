package observer;
import soldier.SoldierItf;


public interface Observer {
	public void update(SoldierItf object);
	static String reponse = "";
}
