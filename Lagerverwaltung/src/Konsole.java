import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author isedo und Adrian Version 12/06 0047
 */
public class Konsole implements Lagerverwaltung {

	static Konsole console = new Konsole();
	static List<Produkt> produktListe = new ArrayList<>();
	static List<Produkt> produktEingelagertListe = new ArrayList<>();
	static List<Lager> lagerIdListe = new ArrayList<>();
	static int ids[];

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

	}

	/**
	 * Diese Methode liest aus einer Textdatei eingegebene Marken und Kategroien aus
	 * 
	 * @author Adrian, isedo
	 * @param dateipfad
	 * @throws FileNotFoundException
	 */

	public static void produktEinlesen(String fileName, List<Produkt> markenListe) throws FileNotFoundException {

		try {

			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String reihe;

			while ((reihe = br.readLine()) != null) {

				String werte[] = reihe.split(","); // werte[0] = Kategorie werte[1] = Marke
				String kategorie = werte[0];
				String marke = werte[1];

				markenListe.add(new Produkt(kategorie, marke));

			}
			br.close();
		} catch (IOException e) {
			System.err.print("Die Zeile konnte nicht gelesen werden!");

		}
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
	public void alleGelagerteProdukte() {
		System.out.println("****************************");
		System.out.println("Waren im Lager:");
		// IF STATE-ment falls lager leer

		if (produktEingelagertListe.isEmpty()) {
			System.out.println("LEER");
		} else {
			for (Produkt alleProdukte : produktEingelagertListe) {

				System.out.println(alleProdukte);
			}
		}
		System.out.println("****************************");
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
	 * Konsole Ausgabe: Menuauswahl, mit Array
	 * 
	 */
	public static void auswahlMenu(String nr[], int bezeichnung[]) {
		System.out.println("M E N U - Logistica21");
		System.out.println("****************************");
		for (int i = 0; i < nr.length; i++) {
			System.out.printf("%d. %-15s \n", bezeichnung[i], nr[i]);
		}
		System.out.println("****************************");

	}

	/**
	 * Konsole Ausgabe: Menuauswahl, mit ArrayList
	 *
	 */

	public static void auswahlMenu(List<Produkt> marken) {
		System.out.println("****************************");
		for (int i = 0; i < marken.size(); i++) {

			String auswahlBezeichnungKat = marken.get(i).getKategorie();
			String auswahlBezeichnungMarke = marken.get(i).getMarke();
			System.out.printf("%d. %-15s %s \n", i + 1, auswahlBezeichnungMarke, auswahlBezeichnungKat);

		}

		System.out.printf("%d. %-20s \n", marken.size() + 1, "Exit");
		System.out.println("****************************");
	}

	/**
	 * Überprüft zahl => gültig/nichtgültig
	 */
	public static int zahlInput(String eingabeText, String eingabeErrorText, int min, int max) throws IOException {
		// Input Onjekt erzeugen
		Input zahl = new Input();

		// zahl.inputReader: überprüft Input (Menu Zahl)
		return zahl.inputReader(eingabeText, eingabeErrorText, min, max);

	}

	/**
	 * gewaehltes Produkt wird in Liste "produktEingelagertListe" gespeichert
	 * 
	 */
	public static void produktEinlagern(Produkt katgMarke) {
		produktEingelagertListe.add(new Produkt(katgMarke.getMarke(), katgMarke.getKategorie(), idVergabe()));

	}

	/**
	 * Gibt ausgewähltes Produkt in der Konsole aus, (vllt. mit Methode
	 * produktEinlagern verbinden)
	 */

	private static void gewaehltesProduktConsoleAusgabe(int produktWahlNr, List<Produkt> produkt) {
		Produkt katgMarke = produkt.get(produktWahlNr);
		produktEinlagern(katgMarke);
		System.out.printf("%s %-10s %s ", "Produkt eingelagert: ", katgMarke.getMarke(), katgMarke.getKategorie());

	}

	/**
	 * Main-Methode, Steuerung des Programms
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		produktEinlesen("C:\\Users\\isedo\\git\\Lagerverwaltung\\Lagerverwaltung\\src\\EinzulesendeDatei.txt",
				produktListe);
		// Einstellungen Hauptmenu

		int auswahlHauptMenu[] = { 1, 2, 3, 4, 5, 6 };
		String auswahlMenu[] = { "Lagerverwaltung", "Wareneingang", "Warenausgang", "Bestand", "Suche", "Exit" };
		int exitHauptmenu = auswahlHauptMenu.length;

		// Ausgabe: Hauptmenu
		auswahlMenu(auswahlMenu, auswahlHauptMenu);

		int menuWaehlNr = zahlInput("Eingabe: ",
				"Error: Bitte Zahl zwischen:" + auswahlHauptMenu[0] + " - " + auswahlHauptMenu.length,
				auswahlHauptMenu[0], auswahlHauptMenu.length);

		// Hauptmenu
		while (menuWaehlNr != exitHauptmenu) {

			/**
			 * Steurung: Lagerverwaltung
			 */
			if (menuWaehlNr == auswahlHauptMenu[0]) {
				System.out.println("Lagerverwaltung ");
				int auswahlLagerMenu[] = { 1, 2, 3 };
				String auswahlLager[] = { "Lager erstellen", "Lager wählen", "Exit" };

				int exitLagerverwaltung = auswahlLagerMenu.length;
				// Ausgabe: Lagermenu
				auswahlMenu(auswahlLager, auswahlLagerMenu);

				// Input des Users lesen, validieren
				int lagerWaehlNr = zahlInput("Eingabe: ",
						"Error: Bitte Zahl zwischen:" + auswahlLagerMenu[0] + " - " + auswahlLagerMenu.length,
						auswahlLagerMenu[0], auswahlLagerMenu.length);

				while (lagerWaehlNr != exitLagerverwaltung) {

					// Lager erstellen
					if (lagerWaehlNr == auswahlLagerMenu[0]) {

//						lagerIdListe.add(new Lager(idVergabe()));
//						lagerIdListe.get(0).setLagerId(idVergabe());
//
//						System.out.println(lagerIdListe.get(0).toString());

						int auswahlMenuRegal[] = { 1, 2, 3 };
						String auswahlRegal[] = { "neuer Regal", "existierender Regal", "Exit" };
						int exitRegal = auswahlHauptMenu.length;

						// Ausgabe: Regal
						auswahlMenu(auswahlRegal, auswahlMenuRegal);

						int regalWaehlNr = zahlInput("Eingabe: ",
								"Error: Bitte Zahl zwischen:" + auswahlMenuRegal[0] + " - " + auswahlMenuRegal.length,
								auswahlMenuRegal[0], auswahlMenuRegal.length);

						// Hauptmenu
						while (menuWaehlNr != exitHauptmenu) {

						}

						// Lager wählen
						if (lagerWaehlNr == auswahlLagerMenu[1]) {
							System.out.println("Lager wählen");

							break;
						} else if (lagerWaehlNr == exitLagerverwaltung)

							System.out.println("Exit");
						System.out.println("****************************");
						;
					}
				}
			}
			/**
			 * Steurung: Produkt einlagern
			 */
			if (menuWaehlNr == auswahlHauptMenu[1]) {

				int exitWareneingang = produktListe.size() + 1;
				// Output Konsole, alle Produkte
				System.out.println("Produkt zum einlagern wählen: ");
				System.out.printf("%-15s %s \n", "Marke", "Kategorie");
				// Ausgabe: Produktet aus .txt datei, Quelle --> Anfang main-methode
				auswahlMenu(produktListe);

				int produktWahlNr = zahlInput("Eingabe: ",
						"Error: Bitte Zahl zwischen: " + "1" + " - " + produktListe.size() + 1, 1,
						produktListe.size() + 1);

				if (produktWahlNr < produktListe.size()) {
					gewaehltesProduktConsoleAusgabe(produktWahlNr - 1, produktListe);

				} else if (produktWahlNr == exitWareneingang)
					System.out.println("Exit");
				System.out.println("****************************");
				;

			}
			/**
			 * Steuerung: Warenausgang ausgeben
			 */

			else if (menuWaehlNr == auswahlHauptMenu[2]) {
				System.out.println("Warenausgang *IN BEARBEITUNG*");
			}
			/**
			 * Steuerung: Bestand ausgeben
			 */

			else if (menuWaehlNr == auswahlHauptMenu[3]) {
				console.alleGelagerteProdukte();
			}
			/**
			 * Steuerungg: Produkt suche
			 */

			else if (menuWaehlNr == auswahlHauptMenu[4]) {
				System.out.println("Suche *IN BEARBEITUNG*");
			}
			/**
			 * Schleife, zurück ins Hauptmenu
			 */

			auswahlMenu(auswahlMenu, auswahlHauptMenu);
			menuWaehlNr = zahlInput("Eingabe: ",
					"Error: Bitte Zahl zwischen:" + auswahlHauptMenu[0] + " - " + auswahlHauptMenu.length,
					auswahlHauptMenu[0], auswahlHauptMenu.length);

		}
		System.out.println("Outtie");
		System.out.println("****************************");

	}

}
