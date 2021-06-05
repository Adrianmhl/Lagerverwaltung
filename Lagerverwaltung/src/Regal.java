/**
 * 
 * @author adrianmuhleisen
 *
 */
public class Regal {
	private int lagerId;
	private int regalId;// Zusammengesetzt aus lagerId+ Regalnummer(aufsteigent gezählt)
	private int regalBreite;// Hat die Einheit Lagerplatz
	private int regalHoehe;// Hat die Einheit Lagerplatz
	int anzahlRegale; // Anzahl aller Regale
	Regal[] regale; // Auflistung aller Regale
	Lagerplatz[][][] lagerplaetze; // Lagerplätze [regalId] [Spalte] [Reihe]

	/**
	 * Der Konstruktor erzeigt ein neues Regal und dessen Lagerplätze Die
	 * Lagerplätze werden direkt in den zugehörigen Array eingesetzt
	 * 
	 * @param lagerId
	 * @param regalBreite
	 * @param regalHoehe
	 */
	public Regal(int lagerId, int regalBreite, int regalHoehe) {
		anzahlRegale++;
		// Attribute mit Werten versehen

		this.lagerId = lagerId;
		this.regalBreite = regalBreite;
		this.regalHoehe = regalHoehe;

		// regalId erzeugen, nach obrigem Muster
		this.regalId = Integer.parseInt(Integer.toString(lagerId) + Integer.toString(anzahlRegale));

		// Erzeugtes Regal in Array regale stecken
		if (regale != null) {
			regale[0] = this;
		} else {
			regale[regale.length] = this;
		}

		// Die neuen Lagerplätze erzeugen und direkt in Array lagerplaetze stecken
		for (int i = regalBreite; i > 0; i--) {
			for (int l = regalHoehe; l > 0; l--) {
				lagerplaetze[this.regalId][i][l] = new Lagerplatz(this.regalId, i, l); // lagerplaetze [0][0] bleibt
																						// frei, dafür sind die Nummern gleich
			}

		}
	}

	/**
	 * Diese Methode löscht ein Regal und seine Lagerplätze Die Produkte bekommen
	 * als Lagerplatz den Wert null
	 * 
	 * @param regalId
	 */
	public void regalAbbauen(int regalId) {
		Regal zumAbbauen;
		// mit ID Regal ausfindig machen
		for (int i = regale.length; i > 0; i--) {
			if (regale[i - 1].regalId == regalId) {
				zumAbbauen = regale[i - 1];
			}
		}

		// Produkte im Regal Lagerplatz = null
		
		// Lagerplätze löschen
		// Regal löschen
	}

	public int getLagerId() {
		return lagerId;
	}

	public void setLagerId(int lagerId) {
		this.lagerId = lagerId;
	}

	public int getRegalId() {
		return regalId;
	}

	public void setRegalId(int regalId) {
		this.regalId = regalId;
	}

	public int getRegalBreite() {
		return regalBreite;
	}

	public void setRegalBreite(int regalBreite) {
		this.regalBreite = regalBreite;
	}

	public int getRegalHoehe() {
		return regalHoehe;
	}

	public void setRegalHoehe(int regalHoehe) {
		this.regalHoehe = regalHoehe;
	}

	public Regal[] getRegale() {
		return regale;
	}

	public void setRegale(Regal[] regale) {
		this.regale = regale;
	}

}
