import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author isedo und Adrian Version 15/06 10:27
 */
public class Konsole implements Lagerverwaltung {

	static Konsole console = new Konsole();
	static List<Produkt> produktListe = new ArrayList<>();
	static List<Produkt> produktEingelagertListe = new ArrayList<>();
	static List<Lager> lagerIdListe = new ArrayList<>();
	static int ids[];

	/**
	 * Diese Methode lagert ein Produkt auf ein Lagerplatz ein
	 * 
	 * @author Adrian
	 * @param lagerplatzId
	 * @param produktId
	 */
	@Override
	public void einlagern(int lagerplatzId, int produktId) {
		Produkt zurEinlagerung = produktSuchen(produktId);
		Lagerplatz zuBelegen = Lagerplatz.lagerplatzSuchen(lagerplatzId);
		zurEinlagerung.setLagerplatz(zuBelegen);
		zuBelegen.setBelegung(zurEinlagerung);

	}

	/**
	 * Diese Methode löscht die belegung des Lagerplatzs und den lagerplatz des
	 * Produkts
	 * 
	 * @author Adrian
	 * @param lagerplatzId
	 */
	@Override
	public void ausbuchen(int lagerplatzId) {
		Lagerplatz zumAusbuchen = Lagerplatz.lagerplatzSuchen(lagerplatzId);
		zumAusbuchen.belegung.setLagerplatz(null);
		zumAusbuchen.setBelegung(null);

	}

	/**
	 * Diese Methode macht ein Produkt mit der ProduktId ausfindig
	 * 
	 * @author Adrian
	 * @param produktId
	 */
	@Override
	public Produkt produktSuchen(int produktId) {
		for (Produkt produkt : produktEingelagertListe) {
			if (produkt.getProduktId() == produktId) {
				return produkt;
			}
		}
		return null;
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
	 * @author isedo Produkte ausgeben (Inhalt)
	 * @param produkt
	 */
	public static void alleGelagerteProdukte() {
		System.out.println("****************************");
		System.out.println("Waren im Lager:");
		// IF-Statement falls Lager leer

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
	 * Die Methode generiert eine einmalige Id fuer Produkte
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
			System.out.printf("%d: %-15s \n", bezeichnung[i], nr[i]);
		}
		System.out.println("****************************");

	}

	/**
	 * Konsole Ausgabe: Menuauswahl, mit ArrayList
	 *
	 */

	public static void auswahlMenu(List<Produkt> marken) {
		System.out.println("****************************");

		System.out.printf("%d: %-20s \n", 0, "Exit");
		for (int i = 0; i < marken.size(); i++) {

			String auswahlBezeichnungKat = marken.get(i).getKategorie();
			String auswahlBezeichnungMarke = marken.get(i).getMarke();
			System.out.printf("%d: %-15s %s \n", i + 1, auswahlBezeichnungMarke, auswahlBezeichnungKat);

		}

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

	public static int zahlInput(String eingabeText, String eingabeErrorText) throws IOException {
		// Input Onjekt erzeugen
		Input zahl = new Input();

		// zahl.inputReader: überprüft Input (Menu Zahl)
		return zahl.inputReader(eingabeText, eingabeErrorText);

	}

	/**
	 * gewaehltes Produkt wird in Liste "produktEingelagertListe" gespeichert
	 * 
	 */
	public static void produktEinlagern(Produkt katgMarke) {

		// Lagerplatz
		int produktID = idVergabe();
		produktEingelagertListe.add(new Produkt(katgMarke.getMarke(), katgMarke.getKategorie(), produktID));
		int lagerID = lagerIdListe.get(0).getLagerId();
		System.out.println(lagerID);
		console.einlagern(produktID, lagerID);
	}

	public static void lagerErstellen() {
		// max lager
		int lagerID = idVergabe();

		lagerIdListe.add(new Lager(lagerID));
		System.out.println(lagerIdListe.get(0));

	}

	/**
	 * Gibt ausgewähltes Produkt in der Konsole aus, (vllt. mit Methode
	 * produktEinlagern verbinden)
	 */

	private static void gewaehltesProduktConsoleAusgabe(int produktWahlNr, List<Produkt> produkt) {
		Produkt katgMarke = produkt.get(produktWahlNr);
		produktEinlagern(katgMarke);
		System.out.println("Produkt eingelagert:");
		System.out.printf("%-10s %s\n", katgMarke.getMarke(), katgMarke.getKategorie());
	}

	/**
	 * Main-Methode, Steuerung des Programms
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		produktEinlesen("EinzulesendeDatei.txt", produktListe);
		// Einstellungen Hauptmenu

		int auswahlHauptMenu[] = { 0, 1, 2, 3, 4, 5 };
		String auswahlMenu[] = { "Exit", "Lagerverwaltung", "Wareneingang", "Warenausgang", "Bestand", "Suche" };
		int exitHauptmenu = auswahlHauptMenu[0];

		// Ausgabe: Hauptmenu
		auswahlMenu(auswahlMenu, auswahlHauptMenu);

		int menuEingabe = zahlInput("Eingabe: ",
				"Error: Bitte Zahl zwischen:" + auswahlHauptMenu[0] + " - "
						+ auswahlHauptMenu[auswahlHauptMenu.length - 1],
				auswahlHauptMenu[0], auswahlHauptMenu[auswahlHauptMenu.length - 1]);

		// Hauptmenu
		while (menuEingabe != exitHauptmenu) {

			/**
			 * Steurung: Lagerverwaltung
			 */
			if (menuEingabe == auswahlHauptMenu[1]) {
				System.out.println("Lagerverwaltung ");
				int auswahlLagerMenu[] = { 0, 1, 2 };
				String auswahlLager[] = { "Exit", "Lager erstellen", "Liste Lager" };

				int exitLagerverwaltung = auswahlLagerMenu[0];
				// Ausgabe: Lagermenu
				auswahlMenu(auswahlLager, auswahlLagerMenu);

				int lagerEingabe = zahlInput("Eingabe: ",
						"Error: Bitte Zahl zwischen:" + auswahlLagerMenu[0] + " - "
								+ auswahlLagerMenu[auswahlLagerMenu.length - 1],
						auswahlLagerMenu[0], auswahlLagerMenu[auswahlLagerMenu.length - 1]);

				while (lagerEingabe != exitLagerverwaltung) {

					if (lagerEingabe == auswahlLagerMenu[1]) {
						// Lagererstellen
						System.out.println("Lager erstellt:  ");
						lagerErstellen();

					}

					// Lager wählen
					if (lagerEingabe == auswahlLagerMenu[2]) {
						System.out.println(lagerIdListe);

					}
					auswahlMenu(auswahlLager, auswahlLagerMenu);

					lagerEingabe = zahlInput("Eingabe: ",
							"Error: Bitte Zahl zwischen:" + auswahlLagerMenu[0] + " - "
									+ auswahlLagerMenu[auswahlLagerMenu.length - 1],
							auswahlLagerMenu[0], auswahlLagerMenu[auswahlLagerMenu.length - 1]);

				}
				// Exit lagerverwaltung
				System.out.println("EXIT LAGERVERWALTUNG");
				System.out.println("****************************");
			}

			/**
			 * Steurung: Produkt einlagern
			 */
			if (menuEingabe == auswahlHauptMenu[2]) {

				int exitWareneingang = 0;
				// Output Konsole, alle Produkte
				System.out.println("Produkt zum einlagern wählen: ");
				System.out.printf("%-15s %s \n", "Marke", "Kategorie");
				// Ausgabe: Produktet aus .txt datei, Quelle --> Anfang main-methode
				auswahlMenu(produktListe);

				int produktEingabe = zahlInput("Eingabe: ",
						"Error: Bitte Zahl zwischen: " + exitWareneingang + " - " + produktListe.size(), 0,
						produktListe.size());

				while (produktEingabe != exitWareneingang) {

					if (produktEingabe < produktListe.size()) {
						gewaehltesProduktConsoleAusgabe(produktEingabe - 1, produktListe);

					}
				}
				System.out.println("EXIT WARENEINGANG");
				System.out.println("****************************");

			}
			/**
			 * Steuerung: Warenausgang ausgeben
			 */

			else if (menuEingabe == auswahlHauptMenu[3]) {

				System.out.println("SUCHE ");
				int auswahlAusbuchenNr[] = { 0, 1 };
				String auswahlAusbuchenMenu[] = { "Exit", "ID Eingabe" };

				int exitAusbuchen = auswahlAusbuchenNr[0];
				// Ausgabe: Lagermenu
				auswahlMenu(auswahlAusbuchenMenu, auswahlAusbuchenNr);

				int ausbuchenEingabe = zahlInput("Eingabe: ",
						"Error: Bitte Zahl zwischen:" + auswahlAusbuchenNr[0] + " - "
								+ auswahlAusbuchenNr[auswahlAusbuchenMenu.length - 1],
						auswahlAusbuchenNr[0], auswahlAusbuchenNr[auswahlAusbuchenMenu.length - 1]);

				while (ausbuchenEingabe != exitAusbuchen) {

					if (ausbuchenEingabe == auswahlAusbuchenNr[1]) {

						int sucheIdEingabe = zahlInput("Produkt ID : ", "Error: Nur Zahlen eingeben");

						if (console.produktSuchen(sucheIdEingabe) == null) {
							System.out.println("Nicht im Lager");

						} else {
							console.produktSuchen(sucheIdEingabe);
						}

					}

					auswahlMenu(auswahlAusbuchenMenu, auswahlAusbuchenNr);

					ausbuchenEingabe = zahlInput("Eingabe: ",
							"Error: Bitte Zahl zwischen:" + auswahlAusbuchenNr[0] + " - "
									+ auswahlAusbuchenNr[auswahlAusbuchenMenu.length - 1],
							auswahlAusbuchenNr[0], auswahlAusbuchenNr[auswahlAusbuchenMenu.length - 1]);

				}

				System.out.println("EXIT: AUSBUCHEN");
				// quit
			}
			/**
			 * Steuerung: Bestand ausgeben
			 */

			else if (menuEingabe == auswahlHauptMenu[4]) {
				alleGelagerteProdukte();
			}

			/**
			 * Steuerungg: Produkt suche
			 */

			else if (menuEingabe == auswahlHauptMenu[5]) {

				System.out.println("SUCHE ");
				int auswahlSucheNr[] = { 0, 1 };
				String auswahlSucheMenu[] = { "Exit", "ID Eingabe" };

				int exitSuche = auswahlSucheNr[0];
				// Ausgabe: Lagermenu
				auswahlMenu(auswahlSucheMenu, auswahlSucheNr);

				int sucheEingabe = zahlInput("Eingabe: ",
						"Error: Bitte Zahl zwischen:" + auswahlSucheNr[0] + " - "
								+ auswahlSucheNr[auswahlSucheNr.length - 1],
						auswahlSucheNr[0], auswahlSucheNr[auswahlSucheNr.length - 1]);

				while (sucheEingabe != exitSuche) {

					if (sucheEingabe == auswahlSucheNr[1]) {

						int sucheIdEingabe = zahlInput("Produkt ID : ", "Error: Nur Zahlen eingeben");

						if (console.produktSuchen(sucheIdEingabe) == null) {
							System.out.println("Nicht im Lager");

						} else {
							console.produktSuchen(sucheIdEingabe);
						}

					}

					auswahlMenu(auswahlSucheMenu, auswahlSucheNr);

					sucheEingabe = zahlInput("Eingabe: ",
							"Error: Bitte Zahl zwischen:" + auswahlSucheNr[0] + " - "
									+ auswahlSucheNr[auswahlSucheNr.length - 1],
							auswahlSucheNr[0], auswahlSucheNr[auswahlSucheNr.length - 1]);
				}

				System.out.println("EXIT: SUCHE");
				// quit
			}
			/**
			 * Schleife, zurück ins Hauptmenu
			 */

			auswahlMenu(auswahlMenu, auswahlHauptMenu);
			menuEingabe = zahlInput("Eingabe: ",
					"Error: Bitte Zahl zwischen: " + auswahlHauptMenu[0] + " - "
							+ auswahlHauptMenu[auswahlHauptMenu.length - 1],
					auswahlHauptMenu[0], auswahlHauptMenu[auswahlHauptMenu.length - 1]);

		}
		System.out.println("EXIT: Logistica21 ");
		System.out.println("****************************");

	}

}