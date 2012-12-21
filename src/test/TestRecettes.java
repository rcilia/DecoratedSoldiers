package test;

import junit.framework.TestCase;
import observer.ObserverCountDeadSoldiers;
import observer.ObserverShowDeadSoldiers;
import soldier.FootMan;
import soldier.Horseman;
import soldier.ProxySoldier;
import soldier.Stormtrooper;
import visitor.VisitorCountSoldiers;
import visitor.VisitorShowSoldiers;
import weapon.LaserCannonDecorator;
import weapon.LaserShieldDecorator;
import weapon.ShieldDecorator;
import weapon.SwordDecorator;
import abstractFactory.AbstractFactory;
import army.ArmyComposite;


public class TestRecettes extends TestCase {
	RememberAllWrittenTextPrintStream ps;
		
	protected void setUp() throws Exception {
		super.setUp();
	
		// Objet permettant d'enregistrer tout ce qui est écrit
		// sur "System.out" : facilite les tests
		ps = new RememberAllWrittenTextPrintStream(System.out);
		System.setOut(ps);		
	}

	protected void tearDown() throws Exception {
		ps = null;
		System.setOut(System.out);
	}
	
	public void testDecorator() {
		
		ProxySoldier soldier = new ProxySoldier(new FootMan());
		
		assertTrue(soldier.getSoldier() instanceof FootMan);
		assertEquals(100, soldier.strike());
		
		
		soldier.addWeapon(ShieldDecorator.class);
		assertTrue(soldier.getSoldier() instanceof ShieldDecorator);
		assertEquals(160, soldier.strike());
		
		
		soldier.addWeapon(SwordDecorator.class);
		assertTrue(soldier.getSoldier() instanceof SwordDecorator);
		assertEquals(360, soldier.strike());
	}
	
	public void testProxy() {
		System.out.println("-----------------------------------------");
		System.out.println("Test Proxy");
		System.out.println("-----------------------------------------");	
		
		
		ProxySoldier soldier = new ProxySoldier(new FootMan());
		soldier.addWeapon(ShieldDecorator.class);
		soldier.addWeapon(SwordDecorator.class);
		soldier.addWeapon(SwordDecorator.class);
		soldier.addWeapon(ShieldDecorator.class);
		
		assertEquals("-----------------------------------------\n" +
				"Test Proxy\n" +
				"-----------------------------------------\n" +
				"Ce soldat est déjà équipé de cette arme : SwordDecorator\n" +
				"Ce soldat est déjà équipé de cette arme : ShieldDecorator\n",
				
				ps.getAllWrittenText());
		
		assertEquals(360, soldier.strike());
	}
	
	public void testArmyComposite() {
		
		// Création de deux armées
		ArmyComposite army = new ArmyComposite();
		ArmyComposite army2 = new ArmyComposite();
		
		// Création de 5 soldiers
		ProxySoldier soldier1 = new ProxySoldier(new FootMan());
		soldier1.addWeapon(ShieldDecorator.class);
		soldier1.addWeapon(SwordDecorator.class);
		
		ProxySoldier soldier2 = new ProxySoldier(new Horseman());
		soldier2.addWeapon(ShieldDecorator.class);
		soldier2.addWeapon(SwordDecorator.class);

		ProxySoldier soldier3 = new ProxySoldier(new Horseman());
		soldier3.addWeapon(ShieldDecorator.class);
		soldier3.addWeapon(SwordDecorator.class);
		
		ProxySoldier soldier4 = new ProxySoldier(new FootMan());
		soldier4.addWeapon(ShieldDecorator.class);
		soldier4.addWeapon(SwordDecorator.class);
		
		ProxySoldier soldier5 = new ProxySoldier(new FootMan());
		soldier5.addWeapon(ShieldDecorator.class);
		soldier5.addWeapon(SwordDecorator.class);

		
		// Ajout des soldiers dans les armées
		army.addSoldier(soldier1);
		army.addSoldier(soldier2);
		army.addSoldier(soldier3);
		
		army2.addSoldier(soldier4);
		army2.addSoldier(soldier5);
		
		// Ajout d'army2 dans army
		army.addSoldier(army2);
		
		
		// Test des éléments ajoutés aux armées
		assertEquals(soldier1, army.getChildArmies().get(0));
		assertEquals(soldier2, army.getChildArmies().get(1));
		assertEquals(soldier3, army.getChildArmies().get(2));
		assertEquals(army2, army.getChildArmies().get(3));
		
		assertEquals(soldier4, army2.getChildArmies().get(0));
		assertEquals(soldier5, army2.getChildArmies().get(1));
	}
	
	
	public void testVisitor() {
		System.out.println("-----------------------------------------");
		System.out.println("Test Visitor");
		System.out.println("-----------------------------------------");		
		
		AbstractFactory syfyFactory = AbstractFactory.getScienceFictionFactory();		
		
		ArmyComposite army = syfyFactory.createArmy();
		

		ProxySoldier stormTrooper = syfyFactory.createFootSoldier();
		syfyFactory.addAttackWeapon(stormTrooper);
		syfyFactory.addDefenseWeapon(stormTrooper);
		
		ProxySoldier xWing = syfyFactory.createMountedSoldier();
		syfyFactory.addAttackWeapon(xWing);
		syfyFactory.addDefenseWeapon(xWing);
		
		
		army.addSoldier(stormTrooper);
		army.addSoldier(xWing);
		
		
		army.accept(new VisitorCountSoldiers());
		army.accept(new VisitorShowSoldiers());	
				
		assertEquals("-----------------------------------------\n" +
					"Test Visitor\n" +
					"-----------------------------------------\n" +
					"ArmyComposite\n" +
					"Foot : 1\n" +
					"Mounted : 1\n" +
					"ArmyComposite\n" +
					"Stormtrooper\n" +
					"XWing\n",
					
					ps.getAllWrittenText());
	}
	
	public void testObservers() {
		System.out.println("-----------------------------------------");
		System.out.println("Test Observers");
		System.out.println("-----------------------------------------");
		
		// Création des observers
		ObserverCountDeadSoldiers ob = ObserverCountDeadSoldiers.getInstance();
		ObserverShowDeadSoldiers sh = ObserverShowDeadSoldiers.getInstance();
		
		
		// Création d'une armée avec un observer
		ArmyComposite army = new ArmyComposite();
		army.addObserver(sh);
		
		// Création de 2 soldiers avec leurs observers
		ProxySoldier soldier1 = new ProxySoldier(new FootMan());
		soldier1.addWeapon(ShieldDecorator.class);
		soldier1.addWeapon(SwordDecorator.class);
		soldier1.addObserver(ob);
		soldier1.addObserver(sh);
		
		ProxySoldier soldier2 = new ProxySoldier(new Horseman());
		soldier2.addWeapon(ShieldDecorator.class);
		soldier2.addWeapon(SwordDecorator.class);
		soldier2.addObserver(ob);
		soldier2.addObserver(sh);

		// Ajout des soldiers dans les armées
		army.addSoldier(soldier1);
		army.addSoldier(soldier2);
		
		// Chaque soldat observe tous les autres
		soldier1.addObserver(soldier2);
		soldier2.addObserver(soldier1);
		
		
		army.parry(100000);
		
		assertEquals("-----------------------------------------\n" +
					"Test Observers\n" +
					"-----------------------------------------\n" +
					"Nombre de soldat morts au combat : 1\n" +
					"Décés de : FootMan\n" +
					"Horseman a reçu une lettre de condoléances de la part de FootMan\n" +
					"Nombre de soldat morts au combat : 2\n" +
					"Décés de : Horseman\n" +
					"FootMan a reçu une lettre de condoléances de la part de Horseman\n" +
					"Décés de : ArmyComposite\n",
			
			ps.getAllWrittenText());
		
	}
	
	public void testSingleton() {
		
		ObserverCountDeadSoldiers ob1 = ObserverCountDeadSoldiers.getInstance();
		ObserverShowDeadSoldiers sh1 = ObserverShowDeadSoldiers.getInstance();
		
		ObserverCountDeadSoldiers ob2 = ObserverCountDeadSoldiers.getInstance();
		ObserverShowDeadSoldiers sh2 = ObserverShowDeadSoldiers.getInstance();

		assertEquals(ob1, ob2);
		assertEquals(sh1, sh2);
		
	}
	
	public void testFactory() {	
		
		AbstractFactory syfyFactory = AbstractFactory.getScienceFictionFactory();
		
		// Création de 2 armées : une avec et une sans factory
		ArmyComposite armyFact = syfyFactory.createArmy();
		ArmyComposite army = new ArmyComposite();
		
		assertEquals(armyFact.getClass(), army.getClass());
		

		// Création de 2 soldats
		ProxySoldier stormTrooperFact = syfyFactory.createFootSoldier();
		ProxySoldier stormTrooper = new ProxySoldier(new Stormtrooper());
		
		assertEquals(stormTrooperFact.getSoldier().getClass(), stormTrooper.getSoldier().getClass());
		
		
		// Ajout d'une arme d'attaque aux 2 soldats
		syfyFactory.addAttackWeapon(stormTrooperFact);
		stormTrooper.addWeapon(LaserCannonDecorator.class);
		
		assertEquals(stormTrooperFact.getSoldier().getClass(), stormTrooper.getSoldier().getClass());
		
		
		// Ajout d'une arme de défense aux 2 soldats
		syfyFactory.addDefenseWeapon(stormTrooperFact);
		stormTrooper.addWeapon(LaserShieldDecorator.class);
		
		assertEquals(stormTrooperFact.getSoldier().getClass(), stormTrooper.getSoldier().getClass());
				
	}
}
