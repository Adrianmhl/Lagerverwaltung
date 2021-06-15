/**
 * 
 * @author Adrian
 *
 */
public class Lagerplatz {

	private int regalId;// Id des Regals für diesen Lagerplatz
	private int lagerplatzId;// Id des Lagerplatzs
	Produkt belegung;// Der Ihnahlt des Lagerplatzs
	static Lagerplatz[] lagerplaetze;// Auflistung aller Lagerplätze

	/**
	 * Dieser Konstruktor erstellein neuen Lagerplatz
	 * 
	 * @param regalId
	 * @param vertikalerPlatz
	 * @param horizontalerPlatz
	 */
	public Lagerplatz(int regalId, int vertikalerPlatz, int horizontalerPlatz) {
		this.regalId = regalId;
		this.lagerplatzId = Integer.parseInt(
				Integer.toString(regalId) + Integer.toString(vertikalerPlatz) + Integer.toString(horizontalerPlatz));
		if (lagerplaetze != null) {
			lagerplaetze[0] = this;
		} else {
			lagerplaetze[lagerplaetze.length + 1] = this;
		}

	}

	/**
	 * Diese Methode macht ein Lagerplatz mit seiner Id ausfindig
	 * 
	 * @author Adrian
	 * @param lagerplatzId
	 * @return
	 */
	public static Lagerplatz lagerplatzSuchen(int lagerplatzId) {

		for (int i = lagerplaetze.length; i > 0; i--) {
			if (lagerplaetze[i - 1].lagerplatzId == lagerplatzId) {
				return lagerplaetze[i - 1];
			}
		}
		return null;
	}

	public int getRegalId() {
		return regalId;
	}

	public void setRegalId(int regalId) {
		this.regalId = regalId;
	}

	public int getLagerplatzId() {
		return lagerplatzId;
	}

	public void setLagerplatzId(int lagerplatzId) {
		this.lagerplatzId = lagerplatzId;
	}

	public Produkt getBelegung() {
		return belegung;
	}

	public void setBelegung(Produkt belegung) {
		this.belegung = belegung;
	}
	
}
