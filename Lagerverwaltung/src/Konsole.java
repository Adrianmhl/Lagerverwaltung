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

		for (int i = 0; i < Produkt.produkte.length; i++) {
			if (produktId == Produkt.produkte[i].getProduktId() && Produkt.produkte[i] != null) {
				return Produkt.produkte[i];

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

	public static void logoEinlesen(String fileName) {

		try {
			FileReader fr = new FileReader(fileName);

			int data = fr.read();
			while (data != -1) {
				System.out.print((char) data);
				data = fr.read();
			}
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		System.out.println("MENU");
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
	public static int consoleInput(String eingabeText, String eingabeErrorText, int min, int max) throws IOException {
		// Input Onjekt erzeugen
		Input zahl = new Input();

		// zahl.inputReader: überprüft Input (Menu Zahl)
		return zahl.inputIntReader(eingabeText, eingabeErrorText, min, max);

	}

	public static int consoleInput(String eingabeText, String eingabeErrorText) throws IOException {
		// Input Onjekt erzeugen
		Input zahl = new Input();

		// zahl.inputReader: überprüft Input (Menu Zahl)
		return zahl.inputIntReader(eingabeText, eingabeErrorText);

	}

	public static String consoleInput(String eingabeText) throws IOException {
		// Input Onjekt erzeugen
		Input zahl = new Input();

		// zahl.inputReader: überprüft Input (Menu Zahl)
		return zahl.inputStrReader(eingabeText);

	}

	/**
	 * gewaehltes Produkt wird in Liste "produktEingelagertListe" gespeichert
	 * 
	 */
	public static void produktEinlagern(Produkt produkt) {
		int lagerplatzID = 0;
		// Lagerplatz
		produktEingelagertListe.add(produkt);

		System.out.println(lagerplatzID);
		console.einlagern(produkt.getProduktId(), lagerplatzID);
	}

	/**
	 * 
	 */

	public static void allRegaleAusgeben() {

	}

	/**
	 * Lager Objekt wird erzeugt ; Ausgabe: Name, LagerID
	 * 
	 * 
	 * @param name
	 * @param id
	 */

	public static void lagerErstellen(String name, int id) {

		lagerIdListe.add(new Lager(name, id));
		System.out.println(lagerIdListe.get(0));

	}

	/**
	 * Regal Objekt wird erzeugt
	 * 
	 * @param lagerId
	 * @param regalBreite
	 * @param regalHoehe
	 */

	public static void regalErstellen(int lagerId, int regalBreite, int regalHoehe) {

		Regal tmp = new Regal(lagerId, regalBreite, regalHoehe);
		System.out.println(tmp);
	}

	/**
	 * Gibt ausgewähltes Produkt in der Konsole aus, (vllt. mit Methode
	 * produktEinlagern verbinden)
	 */

	private static void gewaehltesProduktConsoleAusgabe(int produktWahlNr, List<Produkt> produktlist) {
		Produkt produkt = produktlist.get(produktWahlNr);

		System.out.println(produkt);
		int neueId = idVergabe();
		produkt.setProduktId(neueId);

		int lagerplatzID = 0;
		for (int i = Lagerplatz.lagerplaetze.length; i > 0; i--) {
			if (Lagerplatz.lagerplaetze[i - 1] != null && Lagerplatz.lagerplaetze[i - 1].getBelegung() == null) {
				lagerplatzID = Lagerplatz.lagerplaetze[i - 1].getLagerplatzId();
			}
		}

		Lagerplatz zuBelegen = Lagerplatz.lagerplatzSuchen(lagerplatzID);

		Produkt produktTmp = new Produkt(produkt.getKategorie(), produkt.getMarke(), neueId, zuBelegen);
		System.out.println(produktTmp);

//		produktEinlagern(produkt);
//		System.out.println("Produkt eingelagert:");
//		System.out.printf("%-10s %s\n", produkt.getMarke(), produkt.getKategorie());
	}

	/**
	 * Main-Methode, Steuerung des Programms
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		logoEinlesen("asciiArt.txt");
		produktEinlesen("EinzulesendeDatei.txt", produktListe);

		System.out.println("Lager erstellen: y/n ");
		String startEingabe = consoleInput("Eingabe:");

		boolean bol = false;

		do {

			switch (startEingabe) {

			case "n":
				System.out.println("Wiedersehen!");
				bol = true;
				break;
			case "y":
				lagerErstellen(" vers. alpha ", 10);

				// Einstellungen Hauptmenu

				int auswahlHauptMenu[] = { 0, 1, 2, 3, 4, 5 };
				String auswahlMenu[] = { "Exit", "Lagerverwaltung", "Wareneingang", "Warenausgang", "Bestand",
						"Suche" };
				int exitHauptmenu = auswahlHauptMenu[0];

				// Ausgabe: Hauptmenu
				auswahlMenu(auswahlMenu, auswahlHauptMenu);

				int menuEingabe = consoleInput("Eingabe: ",
						"Error: Bitte Zahl zwischen:" + auswahlHauptMenu[0] + " - "
								+ auswahlHauptMenu[auswahlHauptMenu.length - 1],
						auswahlHauptMenu[0], auswahlHauptMenu[auswahlHauptMenu.length - 1]);

				// Hauptmenu
				while (menuEingabe != exitHauptmenu) {

					/**
					 * Steurung: Lagerverwaltung
					 */
					if (menuEingabe == auswahlHauptMenu[1]) {

						System.out.println("Regale ");
						int auswahlRegalMenu[] = { 0, 1, 2, 3 };
						String auswahlRegal[] = { "Exit", "Regal erstellen", "Liste aller Regale", "Regal wählen" };

						int exitRegalverwaltung = auswahlRegalMenu[0];

						auswahlMenu(auswahlRegal, auswahlRegalMenu);

						int regalEingabe = consoleInput("Eingabe: ",
								"Error: Bitte Zahl zwischen:" + auswahlRegalMenu[0] + " - "
										+ auswahlRegalMenu[auswahlRegalMenu.length - 1],
								auswahlRegalMenu[0], auswahlRegalMenu[auswahlRegalMenu.length - 1]);

						while (regalEingabe != exitRegalverwaltung) {

							if (regalEingabe == auswahlRegalMenu[1]) {
								System.out.println("REGAL ERSTELLEN");
								System.out.println("****************************");

								int regalHoeheEingabe = consoleInput("Höhe: ",
										"Error: Bitte Zahl zwischen:" + 1 + " - " + 10, 1, 10);
								System.out.println("****************************");

								int regalBreiteEingabe = consoleInput("Breite: ",
										"Error: Bitte Zahl zwischen:" + 1 + " - " + 10, 1, 10);

								regalErstellen(lagerIdListe.get(0).getLagerId(), regalHoeheEingabe, regalBreiteEingabe);
							}

							if (regalEingabe == auswahlRegalMenu[2]) {
								System.out.println("LISTE ALLER REGALE");

							}

							// Lager wählen
							if (regalEingabe == auswahlRegalMenu[2]) {
								System.out.println("REGAL WÄHLEN");

							}

							auswahlMenu(auswahlRegal, auswahlRegalMenu);
							regalEingabe = consoleInput("Eingabe: ",
									"Error: Bitte Zahl zwischen:" + auswahlRegalMenu[0] + " - "
											+ auswahlRegalMenu[auswahlRegalMenu.length - 1],
									auswahlRegalMenu[0], auswahlRegalMenu[auswahlRegalMenu.length - 1]);

						}

						System.out.println("Exit Lagerverwaltung");

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

						int produktEingabe = consoleInput("Eingabe: ",
								"Error: Bitte Zahl zwischen: " + exitWareneingang + " - " + produktListe.size(), 0,
								produktListe.size());

						while (produktEingabe != exitWareneingang) {

							if (produktEingabe < produktListe.size()) {
								gewaehltesProduktConsoleAusgabe(produktEingabe - 1, produktListe);

							}

							auswahlMenu(produktListe);
							produktEingabe = consoleInput("Eingabe: ",
									"Error: Bitte Zahl zwischen: " + exitWareneingang + " - " + produktListe.size(), 0,
									produktListe.size());
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

						int ausbuchenEingabe = consoleInput("Eingabe: ",
								"Error: Bitte Zahl zwischen:" + auswahlAusbuchenNr[0] + " - "
										+ auswahlAusbuchenNr[auswahlAusbuchenMenu.length - 1],
								auswahlAusbuchenNr[0], auswahlAusbuchenNr[auswahlAusbuchenMenu.length - 1]);

						while (ausbuchenEingabe != exitAusbuchen) {

							if (ausbuchenEingabe == auswahlAusbuchenNr[1]) {

								int sucheIdEingabe = consoleInput("Produkt ID : ", "Error: Nur Zahlen eingeben");

								if (console.produktSuchen(sucheIdEingabe) == null) {
									System.out.println("Nicht im Lager");

								} else {
									console.produktSuchen(sucheIdEingabe);
								}

							}

							auswahlMenu(auswahlAusbuchenMenu, auswahlAusbuchenNr);

							ausbuchenEingabe = consoleInput("Eingabe: ",
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

						int sucheEingabe = consoleInput("Eingabe: ",
								"Error: Bitte Zahl zwischen:" + auswahlSucheNr[0] + " - "
										+ auswahlSucheNr[auswahlSucheNr.length - 1],
								auswahlSucheNr[0], auswahlSucheNr[auswahlSucheNr.length - 1]);

						while (sucheEingabe != exitSuche) {

							if (sucheEingabe == auswahlSucheNr[1]) {

								int sucheIdEingabe = consoleInput("Produkt ID : ", "Error: Nur Zahlen eingeben");

								if (console.produktSuchen(sucheIdEingabe) == null) {
									System.out.println("Nicht im Lager");

								} else {
									console.produktSuchen(sucheIdEingabe);
								}

							}

							auswahlMenu(auswahlSucheMenu, auswahlSucheNr);

							sucheEingabe = consoleInput("Eingabe: ",
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
					menuEingabe = consoleInput("Eingabe: ",
							"Error: Bitte Zahl zwischen: " + auswahlHauptMenu[0] + " - "
									+ auswahlHauptMenu[auswahlHauptMenu.length - 1],
							auswahlHauptMenu[0], auswahlHauptMenu[auswahlHauptMenu.length - 1]);

				}

				System.out.println("Wiedersehen!");
				bol = true;
				break;

			default:
				System.out.println(("y/n"));
				startEingabe = consoleInput("Eingabe:");
			}
		} while (bol == false);
	}
}