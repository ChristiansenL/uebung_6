public class Autotester {
	public static void main(String[] args) {
		//Übung 1+2
		Auto auto1 = new Auto(40, 60, 0.05, 5, "Golf");
		
		auto1.tanken(15);
		auto1.wechsleReifen();
		auto1.fahre(800);
		
		//Übung 3
		Person mensch1 = new Person("Tim", "Manke", 1995);
		Person mensch2 = new Person("Lasse", "Christiansen", 1996);
		
		//Übung 4
		auto1.namenausgeben();
		
		auto1.setfahrer(mensch1);
		mensch2.privatedaten();
	}
}
