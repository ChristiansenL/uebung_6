public class Auto {

	private double kilometerstand;
	private double tankinhalt;
	private final double verbrauchprokm;
	private final double tankinhaltmax;
	private double profiltiefe;
	private final String wagenname;
	private final int fahrgestellnummer;
	private static int letzteFGNR = 0;
	private Person fahrer;
	

	public Auto (double _tankinhalt, double _tankinhaltmax, double _verbrauchprokm, double _profiltiefe, String _wagenname) {
		this.tankinhalt = _tankinhalt;
		this.tankinhaltmax = _tankinhaltmax;
		this.verbrauchprokm = _verbrauchprokm;
		this.profiltiefe = _profiltiefe;
		this.wagenname = _wagenname;
		fahrgestellnummer = letzteFGNR + 1;
		letzteFGNR = fahrgestellnummer;
	}
	
	public void fahre(double kilometer) {
		double reichweite = tankinhalt / verbrauchprokm;
		double starttankinhalt = tankinhalt;
		double profiltiefemin = 2;
		double reifenabnutzung = 0.01;
		
		System.out.println("Ihre Profiltiefe beträgt aktuell " + profiltiefe + " mm.");
		double reifenreichweite = ((profiltiefe-profiltiefemin)/reifenabnutzung);
		
		profiltiefe = profiltiefe - (reifenabnutzung*kilometer); 
		if (profiltiefe < profiltiefemin) {	
			System.out.println("Sie können nur noch "+ reifenreichweite + " Kilometer mit den aktuellen Reifen fahren. Bitte Reifen wechseln.");
			return;
		}
		
		tankinhalt = tankinhalt - (kilometer * verbrauchprokm);

		if (tankinhalt >= 0) {
			kilometerstand = kilometerstand + kilometer;
			System.out.println("Ihr Kilometerstand beträgt jetzt " + kilometerstand + " Kilometer.");
			System.out.println("Ihr Tank enthält jetzt " + tankinhalt + " Liter.");
		} else {			
			kilometerstand = reichweite;
			System.out.println("Mit einem Tankinhalt von " + starttankinhalt + " Liter, können sie maxmimal "
					+ reichweite + "km fahren!");
			System.out.println("Bitte tanken Sie noch " + tankinhalt * (-1) + " Liter, um Ihre Strecke von " + kilometer
					+ " Kilometer fahren zu können.");
		}
	}

	public void tanken(int liter) {
		if (tankinhalt + liter < tankinhaltmax) {
			tankinhalt = tankinhalt + liter;
			System.out.println("Ihr Tankinhalt beträgt jetzt: " + tankinhalt + " Liter!");
		} else {
			tankinhalt = tankinhaltmax;
			System.out.println("Ihr Tankinhalt beträgt maximal " + tankinhaltmax + " Liter! Sie haben vollgetankt!");
		}
	}
	
	public void wechsleReifen() {
		profiltiefe = 10;
	}
	
	public void namenausgeben() {
		System.out.println(wagenname);
	}
	
	public void setfahrer(Person neuerfahrer) {
		fahrer = neuerfahrer;
	}
	
}
