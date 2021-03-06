
/**
 * 
 * @author Adrian
 *
 */
public class Lagerplatz {

	private int regalId;// Id des Regals für diesen Lagerplatz
	private int lagerplatzId;// Id des Lagerplatzs
	private Produkt belegung;// Der Ihnahlt des Lagerplatzs
	static Lagerplatz[] alleLagerplaetze = new Lagerplatz[10];// Auflistung aller Lagerplätze

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

		for (int i = 0; i < alleLagerplaetze.length; i++) {
			if (alleLagerplaetze[i] == null) {
				alleLagerplaetze[i] = this;

				break;
			}
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

		for (int i = 0; i < Lagerplatz.alleLagerplaetze.length; i++) {
			if (Lagerplatz.alleLagerplaetze[i].belegung == null
					&& Lagerplatz.alleLagerplaetze[i].lagerplatzId == lagerplatzId) {

				return Lagerplatz.alleLagerplaetze[i];
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

	@Override
	public String toString() {
		return "Lagerplatz [regalId=" + regalId + ", lagerplatzId=" + lagerplatzId + "]";
	}

}
