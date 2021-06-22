
/**
 * 
 * @author Adrian
 *
 */
public class Regal {
	private int lagerId;
	private int regalId;// Zusammengesetzt aus lagerId+ Regalnummer(aufsteigent gezählt)
	private int regalBreite;// Hat die Einheit Lagerplatz
	private int regalHoehe;// Hat die Einheit Lagerplatz
	static int anzahlRegale; // Anzahl aller Regale
	static Regal[] regale = new Regal[20]; // Auflistung aller Regale
	static Lagerplatz[][][] lagerplaetze = new Lagerplatz[1500][100][100]; // Lagerplätze [regalId] [Spalte] [Reihe]

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

		for (int i = 0; i < regale.length; i++) {
			if (regale[i] == null) {
				regale[i] = this;

				System.out.print(schriftFarbe.GREEN);
				System.out.println(this);
				System.out.print(schriftFarbe.RESET);
				break;
			}

		}

		// Die neuen Lagerplätze erzeugen und direkt in Array lagerplaetze stecken
		for (int i = regalBreite; i > 0; i--) {
			for (int l = regalHoehe; l > 0; l--) {
				lagerplaetze[this.regalId][i][l] = new Lagerplatz(this.regalId, i, l); // lagerplaetze [0][0] bleibt
																						// frei, dafür sind die Nummern
																						// gleich

				System.out.print(schriftFarbe.GREEN_BRIGHT);
				System.out.println(lagerplaetze[this.regalId][i][l]);
				System.out.print(schriftFarbe.RESET);
			}

		}
	}

	/**
	 * Diese Methode löscht ein Regal und seine Lagerplätze Die Produkte bekommen
	 * als Lagerplatz den Wert null
	 * 
	 * @param regalId
	 */
	public static void regalAbbauen(int regalId) {
		Regal zumAbbauen = null;
		// mit ID Regal ausfindig machen
		for (int i = regale.length; i > 0; i--) {
			if (regale[i - 1].regalId == regalId) {
				regale[i - 1] = null;
				zumAbbauen = regale[i - 1];
			}
		}
		// Produkte im Regal Lagerplatz = null
		for (int i = lagerplaetze[zumAbbauen.regalId].length; i > 0; i--) {
			for (int l = lagerplaetze[zumAbbauen.regalId][i].length; l > 0; l--) {
				lagerplaetze[zumAbbauen.regalId][i - 1][l - 1] = null;
			}
		}

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

	public int getAnzahlRegale() {
		return anzahlRegale;
	}

	public static void setAnzahlRegale(int anzahlRegale) {
		Regal.anzahlRegale = anzahlRegale;
	}

	public Regal[] getRegale() {
		return regale;
	}

	public void setRegale(Regal[] regale) {
		this.regale = regale;
	}

	public Lagerplatz[][][] getLagerplaetze() {
		return lagerplaetze;
	}

	public void setLagerplaetze(Lagerplatz[][][] lagerplaetze) {
		this.lagerplaetze = lagerplaetze;
	}

	@Override
	public String toString() {
		return "Regal [lagerId=" + lagerId + ", regalId=" + regalId + ", regalBreite=" + regalBreite + ", regalHoehe="
				+ regalHoehe + "]";
	}

}