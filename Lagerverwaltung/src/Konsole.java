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
	static List<Produkt> marken = new ArrayList<>();
	static Konsole console = new Konsole();
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
//	public void kategorienEinlesen(String dateipfad) throws FileNotFoundException {
//
//		BufferedReader br = new BufferedReader(new FileReader(dateipfad));
//		try {
//			String reihe = "";
//			while ((reihe = br.readLine()) != null) {//Reader geht jede Zeile durch und liest sie in "reihe" ein
//				String[] werte = reihe.split(",");
//				kategorien[kategorien.length] = werte[0];// Achtung Bezeichning steht aktuell im Array an Stelle 0
//				marken[marken.length] = werte[1];// Achtung Bezeichning steht aktuell im Array an Stelle 0
//			}
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.err.print("Der Dateipfad ist nicht korrekt!");
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.err.print("Die Zeile konnte nicht gelesen werden!");
//		}
//	}

	/**
	 * @author isedo gespeicherte Produkte
	 */

	/**
	 * @author isedo Produkte hinzuefugen (Wareneingang) ohne Bedingung --> spï¿½ter
	 *         :Lagerplatz frei : ja,nein?
	 * @param produkt
	 */

	public void eingangProduktListe(String marke, String kategorie) {

		Produkt tmprodukt = new Produkt(marke, kategorie, idVergabe());
		this.marken.add(tmprodukt);

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

		if (marken.isEmpty()) {
			System.out.println("LEER");
		} else {
			for (Produkt alleProdukte : marken) {

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
	 * Die Methode generiert eine einmalige Id fÃ¼r Proukte
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
	//////////////////////////// HIER
////////////////////////////HIER
////////////////////////////HIER
////////////////////////////HIER
	public static void auswahlMenu(List<Produkt> marken) {
		
		for (int i = 0; i < marken.size(); i++) {
			
			Produkt auswahlBezeichnung = marken.get(i);	
			System.out.println(i+1 + " " + auswahlBezeichnung);
			
		}
		
		System.out.println(marken.size()+1 + " " + "Exit  (funktioniert noch nicht)" );

	}
	
	
	
	
	/**
	 * Überprüft zahl, ob gültig oder nicht gültig 
	 *
	 */
	public static int menuZahl(String eingabeText, String eingabeErrorText, int min, int max) throws IOException {
		
		//Input Onjekt erzeugen
		Input zahlInput  = new Input();
		
		//zahl.inputReader: überprüft Input (Menu Zahl) 
		return zahlInput.inputReader(eingabeText, eingabeErrorText, min, max);
		
	}
	

	private static void completeTransaction(int markeNr, List<Produkt> marken2) {
		
		Produkt marke = marken2.get(markeNr);
		System.out.println(marke.getMarke());
		
		
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
				
					marken.add(new Produkt("Coca-Cola", " Getraenk", 1));
					marken.add(new Produkt("Coca-Colo", " Getraenk", 2));
					marken.add(new Produkt("Coca-Cole", " Getraenk", 3));
					
					
					// Menu Getraenke
					auswahlMenu(marken);

					String kategorie = "Getraenke";

					int markeNr = menuZahl("Eingabe: ", "Error: Bitte Zahl zwischen:" 
							+ 0 + " - " + marken.size(), 
							0, marken.size());
					
					
					completeTransaction(markeNr, marken);
					
			
//					console.eingangProduktListe(marken, kategorie);
					console.alleAusgebenProducts();

				}

			

			else if (hauptMenuNr == auswahlHauptMenu[2]) {
				console.alleAusgebenProducts();
			}

			else if (hauptMenuNr == auswahlHauptMenu[3]) {
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






