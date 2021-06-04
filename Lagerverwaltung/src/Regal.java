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
	Lagerplatz[][] lagerplaetze; // Lagerplätze [Reihe] [Spalte]

	/**
	 * Der Konstruktor erzeigt ein neues Regal
	 * 
	 * @param lagerId
	 * @param regalBreite
	 * @param regalHoehe
	 */
	public Regal(int lagerId, int regalBreite, int regalHoehe) {
		anzahlRegale++;
		this.lagerId = lagerId;
		this.regalBreite = regalBreite;
		this.regalHoehe = regalHoehe;
		this.regalId = Integer.parseInt(Integer.toString(lagerId) + Integer.toString(anzahlRegale));
		if (regale != null) {
			regale[0] = this;
		} else {
			regale[regale.length + 1] = this;
		}
	}

	/**
	 * Diese Methode löscht ein Regal und seine Lagerplätze Die Produkte bekommen
	 * als Lagerplatz den Wert null
	 * 
	 * @param regalId
	 */
	public void regalAbbauen(int regalId) {
		// mit ID Regal ausfindig machen
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
