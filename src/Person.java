import java.util.*;

public class Person {

	public String vorname;
	public String nachname;
	public int geburtsjahr;

	public Person (String _vorname, String _nachname, int _geburtsjahr) {
		this.vorname = _vorname;
		this.nachname = _nachname;
		this.geburtsjahr = _geburtsjahr;
	}
	
	public int alterausgeben() {
		GregorianCalendar heutigerTag = new GregorianCalendar();
		int aktuellesJahr = heutigerTag.get(Calendar.YEAR);
		int alter = aktuellesJahr - geburtsjahr;
		return alter;		
	}
	
	public void privatedaten() {
		System.out.println(vorname + " " + nachname + "; " + alterausgeben());
	}
	
}
	