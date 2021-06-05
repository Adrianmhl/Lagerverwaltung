/**
 * 
 * @author adrianmuhleisen
 *
 */
public class Lagerplatz {

	private int regalId;// Id des Regals für diesen Lagerplatz
	private int lagerplatzId;// Id des Lagerplatzs
	Produkt belegung;// Der Ihnahlt des Lagerplatzs
	Lagerplatz[] lagerplaetze;// Auflistung aller Lagerplätze

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
}
