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
	static List<Produkt> markenListe = new ArrayList<>();
	static Konsole console = new Konsole();

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
	
	public static void produktEinlesen(String fileName, List<Produkt> markenListe) throws FileNotFoundException {
		
			try {
			
			BufferedReader br = new BufferedReader( new FileReader(fileName));
			String reihe;
			
			while((reihe = br.readLine()) != null) {
				
				String werte[] = reihe.split(",");   //werte[0] = Kategorie werte[1] = Marke
				String kategorie = werte[0];
				String marke = werte[1];
				
				markenListe.add(new Produkt(kategorie, marke));
				
			}
			br.close();
		} 
			catch(IOException e) {
			System.err.print("Die Zeile konnte nicht gelesen werden!");
			
		}
	}

	/**
	 * Diese Methode liest aus einer Textdatei eingegebene Marken 
	 * und Kategroien aus
	 * @author Adrian
	 * @param dateipfad
	 * @throws FileNotFoundException
	 */
	public void kategorienEinlesen(String dateipfad) throws FileNotFoundException {
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
//		System.out.println("**************************************************************");
//		System.out.println("Waren im Lager:");
//		// IF STATE-ment falls lager leer
//
//		if (markenListe.isEmpty()) {
//			System.out.println("LEER");
//		} else {
//			for (Produkt alleProdukte : markenListe) {
//
//				System.out.println(alleProdukte);
//			}
//		}
//		System.out.println("**************************************************************");
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
		
		System.out.println("++++++++++++++++++++++");

	}
	public static void auswahlMenu(List<Produkt> marken) {
		
		for (int i = 0; i < marken.size(); i++) {
			
			Produkt auswahlBezeichnung = marken.get(i);	
			System.out.println(i+1 + " " + auswahlBezeichnung);
			
		}
		
		System.out.println(marken.size()+1 + " " + "Exit" );

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
	
	private static void completeTransaction(int markeNr, List<Produkt> produkt) {
		
		Produkt marke = produkt.get(markeNr);
		System.out.println(marke.getMarke());
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		produktEinlesen("C:\\Users\\isedo\\git\\Lagerverwaltung\\Lagerverwaltung\\src\\EinzulesendeDatei.txt", markenListe);
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
				
					
					
					int exitWareneingang = markenListe.size()+1;
					// Output Konsole, alle Produkte
					auswahlMenu(markenListe);
					
					int markeNr = menuZahl("Eingabe: ", "Error: Bitte Zahl zwischen:"
					+ 1 + " - " + markenListe.size(),1, markenListe.size()+1);
				
					completeTransaction(markeNr-1, markenListe);			
					
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
		System.out.println("++++++++++++++++++++++");
	}
	
}

