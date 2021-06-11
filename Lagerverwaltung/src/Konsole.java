import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author isedo und Adrian
 * Version 09/06/2021 22:53
 */
public class Konsole implements Lagerverwaltung {

	static int ids[];
	static List<Produkt> produktListe = new ArrayList<>();
	static Konsole console = new Konsole();
	static String[] kategorien;
	static String[] marken;
	
	static InputStreamReader is = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(is);
	


	@Override
	public void einlagern(int lagerplatzId, int produktId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ausbuchen(int lagepaltzId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void produktSuchen(int produktId) {
		// TODO Auto-generated method stub

	}

	/**
	 * Diese Methode liest aus einer Textdatei eingegebene Marken 
	 * und Kategroien aus
	 * @author Adrian
	 * @param dateipfad
	 * @throws FileNotFoundException
	 */
	public void kategorienEinlesen(String dateipfad) throws FileNotFoundException {

		BufferedReader br = new BufferedReader(new FileReader(dateipfad));
		try {
			String reihe = "";
			while ((reihe = br.readLine()) != null) {//Reader geht jede Zeile durch und liest sie in "reihe" ein
				String[] werte = reihe.split(",");
				kategorien[kategorien.length] = werte[0];// Achtung Bezeichning steht aktuell im Array an Stelle 0
				marken[marken.length] = werte[1];// Achtung Bezeichning steht aktuell im Array an Stelle 0
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.print("Der Dateipfad ist nicht korrekt!");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.print("Die Zeile konnte nicht gelesen werden!");
		}
	}

	/**
	 * @author isedo gespeicherte Produkte
	 */

	/**
	 * @author isedo Produkte hinzuefugen (Wareneingang) ohne Bedingung --> sp�ter
	 *         :Lagerplatz frei : ja,nein?
	 * @param produkt
	 */

	public void eingangProduktListe(String marke, String kategorie) {

		Produkt tmprodukt = new Produkt(marke, kategorie, idVergabe());
		this.produktListe.add(tmprodukt);

	}

	/**
	 * @param produkt
	 * 
	 */
	public void ausgangProdukt(Produkt produkt) {

	}

	/**
	 * @author isedo Produkte ausgeben (Inhalt)
	 * @param produkt
	 */
	public void alleAusgebenProducts() {
		System.out.println("**************************************************************");
		System.out.println("Waren im Lager:");
	    
		// IF STATE-ment falls lager leer
		if (produktListe.isEmpty()) {
			System.out.println("LEER");
		} else {
			for (Produkt alleProdukte : produktListe) {

				System.out.println(alleProdukte);
			}
		}
		System.out.println("**************************************************************");
	}
	
	public static void wareneingangSnacks() {
		String kategorie = "Snacks";
		System.out.println("noch in bearbeiung!");
		System.out.println("**************************************************************");
	}

	/**
	 * Die Methode generiert eine einmalige Id für Proukte
	 * 
	 * @author Adrian
	 */
	public static int idVergabe() {
		Random zufaelligeId = new Random();
		int id = zufaelligeId.nextInt(999);
		if (ids != null) {
			for (int i = 0; i <= ids.length; i++) {
				if (ids[i - 1] == id) {
					idVergabe();
				}
			}
		}
		return id;

	}

	/**
	 * Konsole Ausgabe: Menuauswahl 
	 * 
	 */

	public static void auswahlMenu(String nr[], int bezeichnung[]) {

		for (int i = 0; i < nr.length; i++) {
			System.out.println(bezeichnung[i] + " " + nr[i]);
		}

	}
	
	/**
	 * �berpr�ft zahl, ob g�ltig oder nicht g�ltig 
	 *
	 */
	public static int menuZahl(String eingabeText, String eingabeErrorText, int min, int max) throws IOException {
		
		//Input Onjekt erzeugen
		Input zahlInput  = new Input();
		
		//zahl.inputReader: �berpr�ft Input (Menu Zahl) 
		return zahlInput.inputReader(eingabeText, eingabeErrorText, min, max);
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		// Einstellungen Hauptmenu
		int hauptMenuNr;
		int auswahlHauptMenu[] = { 1, 2, 3, 4, 5};
		String auswahlMenu[] = { "Wareneingang", "Warenausgang", "Waren im Lager", "Suche", "Exit"};
		int exit = auswahlHauptMenu.length;
		// Ausgabe: Menu
		auswahlMenu(auswahlMenu, auswahlHauptMenu);
		
		
		
		hauptMenuNr = menuZahl("Eingabe: ", "Error: Bitte Zahl zwischen:" 
				+ auswahlHauptMenu[0] + " - " + auswahlHauptMenu.length, 
				  auswahlHauptMenu[0], auswahlHauptMenu.length);
		
		// Hauptmenu
		while (hauptMenuNr != exit) {

			// Wareineingang
			if (hauptMenuNr == auswahlHauptMenu[0]) {
				
				// Einstellungen Kategorie Menu
				System.out.println("Kategorie");
				int auswahlKategorieMenu[] = {1, 2};
				String auswahlKategorie[] = {"Snacks", "Getraenke"};
				
				// Output Konsole: Menu Kategorie
				auswahlMenu(auswahlKategorie, auswahlKategorieMenu);
				
				// Input Konsole: einlesen
				int katMenuNr = menuZahl("Eingabe: ", "Error: Bitte Zahl zwischen:" 
						+ auswahlKategorieMenu[0] + " - " + auswahlKategorieMenu.length, 
						auswahlKategorieMenu[0], auswahlKategorieMenu.length);
				
			

				if (katMenuNr == auswahlKategorieMenu[0]) {
					wareneingangSnacks();
				}

				else if (katMenuNr == auswahlKategorieMenu[1]) {
					
					
					String markeGetraenke[] = { "Coca-Cola", "Sprite", "Red-Bull" };
					int auswahlGetraenkeMenu[] = { 1, 2, 3 };
				
					// Menu Getraenke
					auswahlMenu(markeGetraenke, auswahlGetraenkeMenu);

					String kategorie = "Getraenke";

					int markeNr = menuZahl("Eingabe: ", "Error: Bitte Zahl zwischen:" 
							+ auswahlGetraenkeMenu[0] + " - " + auswahlGetraenkeMenu.length, 
							auswahlGetraenkeMenu[0], auswahlGetraenkeMenu.length);
					
					String marke = "";

					if (markeNr == auswahlGetraenkeMenu[0]) {
						marke = markeGetraenke[0];
					}

					else if (markeNr == auswahlGetraenkeMenu[1]) {
						marke = markeGetraenke[1];
					}

					else if (markeNr == auswahlGetraenkeMenu[2]) {
						marke = markeGetraenke[2];
					}
		
					console.eingangProduktListe(marke, kategorie);
					console.alleAusgebenProducts();

				}

			}

			if (hauptMenuNr == auswahlHauptMenu[2]) {
				console.alleAusgebenProducts();
			}

			if (hauptMenuNr == auswahlHauptMenu[3]) {
				System.out.println("SUCHE *in Bearbeitung*");
			}
			
			auswahlMenu(auswahlMenu, auswahlHauptMenu);
			hauptMenuNr = menuZahl("Eingabe: ", "Error: Bitte Zahl zwischen:" 
					+ auswahlHauptMenu[0] + " - " + auswahlHauptMenu.length, 
					  auswahlHauptMenu[0], auswahlHauptMenu.length);
		}

		System.out.println("Exit");

	}

}
