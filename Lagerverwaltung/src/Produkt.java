/**
 * @author Adrian
 */
public class Produkt {

	private String marke;
	private String kategorie;
	private Lagerplatz lagerplatz;
	private static int zaehler = 0;
	private int produktId;
	int anzahlProdukte; // Anzahl aller Produkte
	static Produkt[] produkte = new Produkt[60]; // Auflistung aller Produkte

	public Produkt(String kategorie, String marke, int produktId) {
		anzahlProdukte++;
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
		// Erzeugtes Produkt in Array regale stecken
		if (produkte == null) {
			produkte[0] = this;
		} else {
			produkte[anzahlProdukte - 1] = this;
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

	public int getproduktId() {
		return produktId;
	}

	public void setproduktId(int id) {
		this.produktId = id;
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

	@Override
	/**
	 * Lässt die Attribute der Klasse Produkte als String ausgeben
	 */

	public String toString() {

		return "Marke=" + marke + ", Kategorie=" + kategorie;
	}

	public String toString2() {

		return "Produkt [Marke=" + marke + ", Kategorie=" + kategorie + ", ProduktId=" + produktId + "]";
	}

}
