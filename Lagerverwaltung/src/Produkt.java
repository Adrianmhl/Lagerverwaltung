/**
 * @author Adrian
 */
public class Produkt {

	private String marke;
	private String kategorie;
	private Lagerplatz lagerplatz;
	private static int zaehler = 0;
	private int produktId;
	static int anzahlProdukte; // Anzahl aller Produkte
	static Produkt[] produkte = new Produkt[60]; // Auflistung aller Produkte

	public Produkt(String kategorie, String marke, int produktId) {

		this.produktId = produktId;
		this.kategorie = kategorie;
		this.marke = marke;
	}

	public Produkt(String kategorie, String marke, int produktId, Lagerplatz lagerplatz) {
		anzahlProdukte++;
		this.produktId = produktId;
		this.kategorie = kategorie;
		this.marke = marke;
		this.lagerplatz = lagerplatz;

		for (int i = 0; i < produkte.length; i++) {

			if (produkte[i] == null) {
				produkte[i] = this;
				break;
			}

		}
	}

	public Lagerplatz getLagerplatz() {
		return lagerplatz;
	}

	public void setLagerplatz(Lagerplatz lagerplatz) {
		this.lagerplatz = lagerplatz;
	}

	public Produkt(String kategorie, String marke) {

		this.kategorie = kategorie;
		this.marke = marke;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public static int getZaehler() {
		return zaehler;
	}

	public static void setZaehler(int zaehler) {
		Produkt.zaehler = zaehler;
	}

	public int getProduktId() {
		return produktId;
	}

	public void setProduktId(int produktId) {
		this.produktId = produktId;
	}

	/**
	 * Lässt die Attribute der Klasse Produkte als String ausgeben
	 */
	@Override
	public String toString() {
		return "Produkt [marke=" + marke + ", kategorie=" + kategorie + ", lagerplatz=" + lagerplatz + ", produktId="
				+ produktId + "]";
	}

}
