

public class Produkt {
	
	/** @author isedo
	 * produktId --> jedes mal wenn ein produkt hinzugefuegt wird
	 */
	private String marke;
	private String kategorie;
	private int anzahl;
	private static int zaehler = 0;
	private int produktId;
	
	
	public Produkt(String marke, String kategorie,int anzahl) {
		zaehler++;
		produktId = zaehler;
		this.kategorie = kategorie;
		this.anzahl = anzahl;
		this.marke = marke;
		
	}


	public String getMarke() {
		return marke;
	}


	public void setMarke(String marke) {
		this.marke = marke;
	}


	public int getAnzahl() {
		return anzahl;
	}


	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
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
	public String toString() {
		return "Produkt [marke=" + marke + ", kategorie=" + kategorie + ", anzahl=" + anzahl + ", produktId="
				+ produktId + "]";
	}





}
