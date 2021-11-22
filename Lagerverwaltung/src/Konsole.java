
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author isedo und Adrian Version 15/06 10:27
 */
public class Konsole implements Lagerverwaltung {

	static Konsole console = new Konsole();
	static List<Produkt> produktListe = new ArrayList<>();
	static List<Lager> lagerIdListe = new ArrayList<>();
	static int ids[];

	/**
	 * Diese Methode loescht die belegung des Lagerplatzs und den lagerplatz des
	 * Produkts
	 * 
	 * @author Adrian
	 * @param lagerplatzId
	 */
	@Override
	public void ausbuchen(int lagerplatzId) {
		try {
			Lagerplatz zumAusbuchen = Lagerplatz.lagerplatzSuchen(lagerplatzId);
			zumAusbuchen.getBelegung().setLagerplatz(null);
			zumAusbuchen.setBelegung(null);
			for (int i = 0; i < Produkt.produkte.length; i++) {
				if (zumAusbuchen.getBelegung() == Produkt.produkte[i]) {

					Produkt.produkte[i] = null;

				}
			}
		} catch (Exception e) {
			System.err.print("Es konnte nicht ausgebucht werden, bitte gueltige lagerplatzId eingeben");
		}
	}

	/**
	 * Diese Methode macht ein Produkt mit der ProduktId ausfindig
	 * 
	 * @author Adrian
	 * @param produktId
	 */
	@Override
	public Produkt produktSuchen(int produktId) {
		try {
			for (int i = 0; i < Produkt.produkte.length; i++) {
				if (produktId == Produkt.produkte[i].getProduktId()) {

					return Produkt.produkte[i];

				}
			}
			return null;
		} catch (Exception e) {
			System.err.println("Bitte gueltige produktId eingeben, Produkt konnte nicht gefunden werden");
			return null;
		}
	}

	/**
	 * Diese Methode laesst Produkte anhand ihrer produktId auslagern
	 * 
	 * @author Adrian
	 * @param produktId
	 */
	public void produktAuslagern(int produktId) {

		try {
			// Lagerplatz Belegung löschen
			produktSuchen(produktId).getLagerplatz().setBelegung(null);
			// Produkt Lagerplatz löschen
			produktSuchen(produktId).setLagerplatz(null);
			for (int i = 0; i < Produkt.produkte.length; i++) {
				if (produktSuchen(produktId) == Produkt.produkte[i]) {
					System.out.print(schriftFarbe.GREEN);
					System.out.println(Produkt.produkte[i] + " wurde ausgelagert!");
					System.out.print(schriftFarbe.RESET);
					Produkt.produkte[i] = null;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Bitte gueltige Produkt-Id eingeben ! ");
		}

	}

	/**
	 * Diese Methode liest aus einer Textdatei eingegebene Marken und Kategroien aus
	 * 
	 * @author Adrian, isedo
	 * @param dateipfad
	 * @throws FileNotFoundException
	 */

	public static void produktEinlesen(String fileName, List<Produkt> produktListe) throws FileNotFoundException {

		// yo
		try {

			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String reihe;

			while ((reihe = br.readLine()) != null) {

				String werte[] = reihe.split(","); // werte[0] = Kategorie werte[1] = Marke
				String kategorie = werte[0];
				String marke = werte[1];

				produktListe.add(new Produkt(kategorie, marke));
				Collections.sort(produktListe);

			}
			br.close();
		} catch (IOException e) {
			System.err.print("Die Zeile konnte nicht gelesen werden!");

		}
	}

	/**
	 * ASCII-Logo Logistica21 wird gelesen und in der Konsole ausgegeben
	 * 
	 * @author isedo
	 * @param fileName
	 */

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
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

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
	 * @author isedo
	 * 
	 */
	public static void auswahlMenu(String nr[], int bezeichnung[], String bezeichnungMenu) {

		System.out.println(schriftFarbe.RED_BOLD_BRIGHT + "---------------------------" + schriftFarbe.RESET);
		System.out.println(schriftFarbe.BLUE_BOLD_BRIGHT + "MENU - " + bezeichnungMenu + schriftFarbe.RESET);

		for (int i = 0; i < nr.length; i++) {
			System.out.printf("%d: %-15s \n", bezeichnung[i], nr[i]);
		}

	}

	/**
	 * Konsole Ausgabe: Menuauswahl, mit ArrayList
	 * 
	 * @author isedo
	 *
	 */

	public static void auswahlMenu(List<Produkt> produkte, String bezeichnungMenu) {

		System.out.println(schriftFarbe.RED_BOLD_BRIGHT + "---------------------------" + schriftFarbe.RESET);
		System.out.println(schriftFarbe.BLUE_BOLD_BRIGHT + "MENU - " + bezeichnungMenu + schriftFarbe.RESET);

		System.out.printf("%-20s %s \n", "Marke", "Kategorie");
		System.out.println("---------------------------");
		System.out.printf("%2d: %-20s \n", 0, "zurueck");
		for (int i = 0; i < produkte.size(); i++) {

			String auswahlBezeichnungKat = produkte.get(i).getKategorie();
			String auswahlBezeichnungMarke = produkte.get(i).getMarke();

			System.out.printf("%2d: %-20s %s \n", i + 1, auswahlBezeichnungMarke, auswahlBezeichnungKat);

		}

	}

	/**
	 * Überprüft Gueltigkeit der Konsolen-Eingabe
	 * 
	 * @author isedo
	 */
	public static int konsoleEingabe(String eingabeText, String eingabeErrorText, int min, int max) throws IOException {
		// Input Onjekt erzeugen
		Input zahl = new Input();

		// zahl.inputReader: Ã¼berprÃ¼ft Input (Menu Zahl)
		return zahl.inputIntReader(eingabeText, eingabeErrorText, min, max);

	}

	/**
	 * Ueberprueft Gueltigkeit der Konsolen-Eingabe
	 * 
	 * @author isedo
	 */
	public static int konsoleEingabe(String eingabeText, String eingabeErrorText) throws IOException {
		// Input Onjekt erzeugen
		Input zahl = new Input();

		// zahl.inputReader: Ã¼berprÃ¼ft Input (Menu Zahl)
		return zahl.inputIntReader(eingabeText, eingabeErrorText);

	}

	/**
	 * Ueberprueft Gueltigkeit der Konsolen-Eingabe
	 * 
	 * @author isedo
	 */
	public static String konsoleEingabe(String eingabeText) throws IOException {
		// Input Onjekt erzeugen
		Input zahl = new Input();

		// zahl.inputReader: Ã¼berprÃ¼ft Input (Menu Zahl)
		return zahl.inputStrReader(eingabeText);

	}

	/**
	 * Lager Objekt wird erzeugt ; Ausgabe: Name, LagerID
	 * 
	 * @isedo
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
	 * @isedo
	 * @param lagerId
	 * @param regalBreite
	 * @param regalHoehe
	 */

	public static void regalErstellen(int lagerId, int regalBreite, int regalHoehe) {
		Regal tmp = null;
		tmp = new Regal(lagerId, regalBreite, regalHoehe);

	}

	/**
	 * Sucht Lagerplatz mit leeren Belegung
	 * 
	 * @author isedo, adrian
	 * @return
	 */

	public static int lagerplatzIdSuchen() {

		for (int i = 0; i < Lagerplatz.alleLagerplaetze.length; i++) {
			if (Lagerplatz.alleLagerplaetze[i] != null && Lagerplatz.alleLagerplaetze[i].getBelegung() == null) {
				int lagerplatzId = Lagerplatz.alleLagerplaetze[i].getLagerplatzId();
				return lagerplatzId;
			}
		}
		return 0;

	}

	/**
	 * Gibt ausgewaehltes Produkt in der Konsole aus, erstellt Produkt Objekt und
	 * uebergibt sie zu Methode:einlagern
	 * 
	 * @author isedo
	 */

	private static void produktWaehlenLagern(int produktWahlNr, List<Produkt> produktlist) {
		try {
			Produkt produkttmp = produktlist.get(produktWahlNr);

			int produktId = idVergabe();
			produkttmp.setProduktId(produktId);

			// hier exeption, falls keine Lagerplätze
			Lagerplatz zuBelegen = Lagerplatz.lagerplatzSuchen(lagerplatzIdSuchen());

			Produkt produkt = new Produkt(produkttmp.getKategorie(), produkttmp.getMarke(), produkttmp.getProduktId(),
					zuBelegen);

			console.einlagern(produkt, zuBelegen);

		} catch (Exception e) {
			System.err.println("Bitte '0: zurueck' -> '1: Lagerverwaltung' -> '1: Regal erstellen' ! ");
		}

	}

	/**
	 * Diese Methode lagert ein Produkt auf ein Lagerplatz ein(Anhand von Objekten)
	 * 
	 * @author Adrian
	 * @param lagerplatzId
	 * @param produktId
	 */
	@Override
	public void einlagern(Produkt produkt, Lagerplatz zuBelegen) {
		try {
			Produkt produktZurEinlagerung = console.produktSuchen(produkt.getProduktId());

			produktZurEinlagerung.setLagerplatz(zuBelegen);

			zuBelegen.setBelegung(produktZurEinlagerung);
			System.out.print(schriftFarbe.GREEN);
			System.out.println(produkt);
			System.out.print(schriftFarbe.RESET);

		} catch (Exception e) {
			System.err.print("Es konnte nicht eingelagert werden, das Produkt oder Der Lagerplatz ist nicht gültig");

		}
	}

	/**
	 * Alle Produkte im Lager werden in der Konsole ausgegeben
	 * 
	 * @author isedo
	 * @return
	 */

	public boolean produktBestandAusgeben() {

		boolean bol = false;

		for (Produkt produktBestand : Produkt.produkte) {
			if (produktBestand != null) {
				System.out.print(schriftFarbe.GREEN);
				System.out.println(produktBestand);
				System.out.print(schriftFarbe.RESET);
				bol = true;
				continue;
			}
		}
		return bol;

	}

	/**
	 * Alle verfuegbaren Regale werden in der Konsole ausgegeben
	 * 
	 * @author isedo
	 * @return
	 */

	public boolean regaleAusgeben() {

		boolean bol = false;

		for (Regal regal : Regal.regale) {
			if (regal != null) {
				System.out.print(schriftFarbe.GREEN);
				System.out.println(regal);
				System.out.print(schriftFarbe.RESET);
				bol = true;
				continue;
			}
		}
		return bol;
	}

	/**
	 * Main-Methode, Steuerung des Programms
	 * 
	 * @author isedo
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.print(schriftFarbe.BLUE_BOLD_BRIGHT);
		logoEinlesen("asciiArt.txt");
		System.out.print(schriftFarbe.RESET);

		produktEinlesen("EinzulesendeDatei.txt", produktListe);

		System.out.println("Lager erstellen: y/n ");
		String startEingabe = konsoleEingabe("Eingabe: ");

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

				String bezeichnungHauptmenu = "Hauptmenu";
				int auswahlHauptMenu[] = { 0, 1, 2, 3, 4, 5 };
				String auswahlMenu[] = { "Programmm beenden", "Lagerverwaltung", "Wareneingang", "Warenausgang",
						"Bestand", "Suche" };
				int exitHauptmenu = auswahlHauptMenu[0];

				// Ausgabe: Hauptmenu
				auswahlMenu(auswahlMenu, auswahlHauptMenu, bezeichnungHauptmenu);

				int menuEingabe = konsoleEingabe("Eingabe: ",
						"Error: Bitte Zahl zwischen:" + auswahlHauptMenu[0] + " - "
								+ auswahlHauptMenu[auswahlHauptMenu.length - 1],
						auswahlHauptMenu[0], auswahlHauptMenu[auswahlHauptMenu.length - 1]);

				// Hauptmenu
				while (menuEingabe != exitHauptmenu) {

					/**
					 * Steurung: Lagerverwaltung
					 */
					if (menuEingabe == auswahlHauptMenu[1]) {

						String bezeichnungRegal = "Lagerverwaltung";
						int auswahlRegalMenu[] = { 0, 1, 2, 3 };
						String auswahlRegal[] = { "zurueck", "Regal erstellen", "Regale im Lager",
								"Regal loeschen (..in Bearbeitung)" };

						int exitRegalverwaltung = auswahlRegalMenu[0];

						auswahlMenu(auswahlRegal, auswahlRegalMenu, bezeichnungRegal);

						int regalEingabe = konsoleEingabe("Eingabe: ",
								"Error: Bitte Zahl zwischen:" + auswahlRegalMenu[0] + " - "
										+ auswahlRegalMenu[auswahlRegalMenu.length - 1],
								auswahlRegalMenu[0], auswahlRegalMenu[auswahlRegalMenu.length - 1]);

						while (regalEingabe != exitRegalverwaltung) {

							if (regalEingabe == auswahlRegalMenu[1]) {
								System.out.println(
										schriftFarbe.BLUE_BOLD_BRIGHT + "Regal erstellen" + schriftFarbe.RESET);

								int regalHoeheEingabe = konsoleEingabe("hoehe: ",
										"Error: Bitte Zahl zwischen:" + 1 + " - " + 10, 1, 10);

								int regalBreiteEingabe = konsoleEingabe("breite: ",
										"Error: Bitte Zahl zwischen:" + 1 + " - " + 10, 1, 10);

								regalErstellen(lagerIdListe.get(0).getLagerId(), regalHoeheEingabe, regalBreiteEingabe);
							}

							if (regalEingabe == auswahlRegalMenu[2]) {

								if (console.regaleAusgeben() == false) {
									System.out.println("Keine Regale im Lager !");
								}

							}

							if (regalEingabe == auswahlRegalMenu[3]) {

								int regalIdEingabe = konsoleEingabe("Regal-Id : ", "Error: Nur Zahlen eingeben");
								Regal.regalAbbauen(regalIdEingabe);

							}

							auswahlMenu(auswahlRegal, auswahlRegalMenu, bezeichnungRegal);
							regalEingabe = konsoleEingabe("Eingabe: ",
									"Error: Bitte Zahl zwischen:" + auswahlRegalMenu[0] + " - "
											+ auswahlRegalMenu[auswahlRegalMenu.length - 1],
									auswahlRegalMenu[0], auswahlRegalMenu[auswahlRegalMenu.length - 1]);

						}

					}

					/**
					 * Steuerung: Wareneingang (Produkt auswaehlen und einlagern)
					 */
					if (menuEingabe == auswahlHauptMenu[2]) {

						int exitWareneingang = 0;
						// Output Konsole, alle Produkte
						String bezeichnungWareneingang = "Wareneingang";
						// Ausgabe: Produktet aus .txt datei, Quelle --> Anfang main-methode, sonst kein
						// reset
						auswahlMenu(produktListe, bezeichnungWareneingang);

						// Validierung der Eingabe
						int produktEingabe = konsoleEingabe("Eingabe: ",
								"Error: Bitte Zahl zwischen: " + exitWareneingang + " - " + produktListe.size(),
								exitWareneingang, produktListe.size());

						while (produktEingabe != exitWareneingang) {

							if (produktEingabe <= produktListe.size()) {
								produktWaehlenLagern(produktEingabe - 1, produktListe);

							}

							auswahlMenu(produktListe, bezeichnungWareneingang);
							produktEingabe = konsoleEingabe("Eingabe: ",
									"Error: Bitte Zahl zwischen: " + exitWareneingang + " - " + produktListe.size(), 0,
									produktListe.size());
						}

					}
					/**
					 * Steuerung: Warenausgang ausgeben
					 */

					else if (menuEingabe == auswahlHauptMenu[3]) {

						String bezeichnungSuche = "Warenausgang";
						int auswahlAusbuchenNr[] = { 0, 1 };
						String auswahlAusbuchenMenu[] = { "zurueck", "Produkt-Id Eingabe" };

						int exitAusbuchen = auswahlAusbuchenNr[0];
						// Ausgabe: Lagermenu
						auswahlMenu(auswahlAusbuchenMenu, auswahlAusbuchenNr, bezeichnungSuche);

						int ausbuchenEingabe = konsoleEingabe("Eingabe: ",
								"Error: Bitte Zahl zwischen:" + auswahlAusbuchenNr[0] + " - "
										+ auswahlAusbuchenNr[auswahlAusbuchenMenu.length - 1],
								auswahlAusbuchenNr[0], auswahlAusbuchenNr[auswahlAusbuchenMenu.length - 1]);

						while (ausbuchenEingabe != exitAusbuchen) {

							if (ausbuchenEingabe == auswahlAusbuchenNr[1]) {

								int sucheIdEingabe = konsoleEingabe("Produkt-Id : ", "Error: Nur Zahlen eingeben");

								console.produktAuslagern(sucheIdEingabe);

							}

							auswahlMenu(auswahlAusbuchenMenu, auswahlAusbuchenNr, bezeichnungSuche);

							ausbuchenEingabe = konsoleEingabe("Eingabe: ",
									"Error: Bitte Zahl zwischen:" + auswahlAusbuchenNr[0] + " - "
											+ auswahlAusbuchenNr[auswahlAusbuchenMenu.length - 1],
									auswahlAusbuchenNr[0], auswahlAusbuchenNr[auswahlAusbuchenMenu.length - 1]);

						}

					}
					/**
					 * Steuerung: Bestand ausgeben
					 */

					else if (menuEingabe == auswahlHauptMenu[4]) {

						if (console.produktBestandAusgeben() == false) {
							System.out.print(schriftFarbe.MAGENTA_BRIGHT);
							System.out.println("Kein Bestand im Lager!");
							System.out.print(schriftFarbe.RESET);
						}

					}

					/**
					 * Steuerungg: Produkt suche
					 */

					else if (menuEingabe == auswahlHauptMenu[5]) {

						String bezeichnungProdSuche = "Produktsuche";
						int auswahlSucheNr[] = { 0, 1 };
						String auswahlSucheMenu[] = { "zurueck", "Produkt-Id Eingabe" };

						int exitSuche = auswahlSucheNr[0];
						// Ausgabe: Lagermenu
						auswahlMenu(auswahlSucheMenu, auswahlSucheNr, bezeichnungProdSuche);

						int sucheEingabe = konsoleEingabe("Eingabe: ",
								"Error: Bitte Zahl zwischen:" + auswahlSucheNr[0] + " - "
										+ auswahlSucheNr[auswahlSucheNr.length - 1],
								auswahlSucheNr[0], auswahlSucheNr[auswahlSucheNr.length - 1]);

						while (sucheEingabe != exitSuche) {

							if (sucheEingabe == auswahlSucheNr[1]) {

								int sucheIdEingabe = konsoleEingabe("Produkt ID : ", "Error: Nur Zahlen eingeben");

								if (console.produktSuchen(sucheIdEingabe) == null) {
									System.out.println(console.produktSuchen(sucheIdEingabe));

								} else {
									System.out.print(schriftFarbe.GREEN);
									System.out.println(console.produktSuchen(sucheIdEingabe));
									System.out.print(schriftFarbe.RESET);

								}

							}

							auswahlMenu(auswahlSucheMenu, auswahlSucheNr, bezeichnungProdSuche);

							sucheEingabe = konsoleEingabe("Eingabe: ",
									"Error: Bitte Zahl zwischen:" + auswahlSucheNr[0] + " - "
											+ auswahlSucheNr[auswahlSucheNr.length - 1],
									auswahlSucheNr[0], auswahlSucheNr[auswahlSucheNr.length - 1]);
						}

					}
					/**
					 * Schleife, zurueck ins Hauptmenu
					 */

					auswahlMenu(auswahlMenu, auswahlHauptMenu, bezeichnungHauptmenu);
					menuEingabe = konsoleEingabe("Eingabe: ",
							"Error: Bitte Zahl zwischen: " + auswahlHauptMenu[0] + " - "
									+ auswahlHauptMenu[auswahlHauptMenu.length - 1],
							auswahlHauptMenu[0], auswahlHauptMenu[auswahlHauptMenu.length - 1]);

				}

				System.out.println("Wiedersehen!");
				bol = true;
				break;

			default:
				System.out.println(("y/n"));
				startEingabe = konsoleEingabe("Eingabe:");
			}
		} while (bol == false);
	}

}