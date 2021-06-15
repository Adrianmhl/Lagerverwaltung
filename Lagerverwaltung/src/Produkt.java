
public class Produkt {

	/**
	 * @author isedo produktId --> jedes mal wenn ein produkt hinzugefuegt wird
	 */
	private String marke;
	private String kategorie;

	private static int zaehler = 0;
	private int produktId;

	public Produkt(String kategorie, String marke, int produktId) {
		this.produktId = produktId;
		this.kategorie = kategorie;
		this.marke = marke;
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
