import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
// Test für die Branche


/**

 * 
 * @author isedo und Adrian

 * TESTTEST
 * @author isedo und Adrian 

 *
 */

public class Konsole implements Lagerverwaltung {

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
		// TODO Auto-generated method stub

	}

	/**
	 * @author isedo gespeicherte Produkte
	 */
	private List<Produkt> produktListe = new ArrayList<>();
	static Konsole console = new Konsole();

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
		for (Produkt alleProdukt : produktListe) {
			System.out.println(alleProdukt);
		}
	}

	/**
	 * Auswahl
	 */

	public static void menuAuswahl() {
		System.out.println("1 : Wareneingang");
		System.out.println("2 : Warenausgang");
		System.out.println("3 : Waren im Lager");
		System.out.println("4 : Suche");
		System.out.println("0 : Exit");

	public static void menuAuswahl(int ausw[], String menuAusw[]) {
		System.out.println("1 : Wareneingang");	
		
		// Schleife: Auswahl
		for(int i = 0; i < ausw.length; i++) {
			System.out.println(ausw[i], menuAusw[i]);
		}
		
//		System.out.println("2 : Warenausgang");	
//		System.out.println("3 : Waren im Lager");
//		System.out.println("4 : Suche");
//		System.out.println("0 : Exit");

		System.out.print("Eingabe: ");
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

	public static void main(String[] args) throws NumberFormatException, IOException {

		menuAuswahl();



		
		int auswahl[] = {0,1,2,3,4};
		String menuAuswahl[] = {"Wareneingang", "Warenausgang", "Waren im Lager", "Suche", "Exit"};
		
		

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		// throws NumberFormatExeption, Integer (klasse).parseInt(static method)
		int menuNr = Integer.parseInt(br.readLine());

		while (menuNr != 0) {

			// Abbruch: Exit
			if (menuNr == 0) {

			}


			// Wareineingang
			if (menuNr == 1) {
				System.out.println("1 Kategorie: ");
				System.out.println("1 Snacks 2 Getraenke");
				int katNr = Integer.parseInt(br.readLine());

				if (katNr == 1) {
					wareneingangSnacks();
				}

				else if (katNr == 2) {
					String kategorie = "Getraenke";

					System.out.println("2 Marke: ");
					System.out.println("1 Coca-Cola 2 Sprite 3 Red-Bull");
					int markeNr = Integer.parseInt(br.readLine());
					String marke = "";

					if (markeNr == 1 | markeNr == 2 | markeNr == 3 | markeNr == 0) {

						if (markeNr == 1) {
							marke = "Coca-Cola";
						}

						else if (markeNr == 2) {
							marke = "Sprite";
						}

						else if (markeNr == 3) {
							marke = "Red-Bull";

				
			//Wareineingang	
			if(menuNr == 1) {
				System.out.println("***********************************************************************");
				System.out.println("Kategorie: ");
				System.out.println("1 : Snacks");
				System.out.println("2 : Getraenke");
				System.out.print("Eingabe: ");
				int katNr = Integer.parseInt(br.readLine());
				
					if(katNr == 1) {
						wareneingangSnacks();
					}
				
					else if(katNr == 2) {
						String kategorie = "Getraenke";
						System.out.println("***********************************************************************");
						System.out.println("Marke: ");
						System.out.println("1: Coca-Cola 2: Sprite 3: Red-Bull"); //  �ber datei laden
						int markeNr = Integer.parseInt(br.readLine());
						String marke ="";

						if (markeNr == 1 | markeNr == 2 |  markeNr == 3 | markeNr == 0) {

							if (markeNr == 1) {
								marke = "Coca-Cola";
							}

							else if (markeNr == 2) {
								marke = "Sprite";
							}

							else if (markeNr == 3) {
								marke = "Red-Bull";
							} 	
							
							
							// statt anzahl manuell, automatisch alle freien slots f�llen --> if-schleife
							System.out.println("3 Anzahl: ");
							System.out.println("(max: ist/soll) "); //SUCHT freie Slots im lager / maschine
							int anzahl = Integer.parseInt(br.readLine());


							System.out.println("Eingang: ");

							console.eingangProduktListe(marke, kategorie, anzahl);
							console.alleAusgebenProducts();
							System.out.println("***********************************************************************");
							

						}

						System.out.println("Eingang: ");

						console.eingangProduktListe(marke, kategorie);
						console.alleAusgebenProducts();
						System.out.println("**************************************************************");

					}
				}
			}

			if (menuNr == 2) {
				System.out.println("ayayyayaya");
			}
			
			System.out.println("Zahl zwischen 0 - 4");
			System.out.println("***********************************************************************");
			menuAuswahl();
			menuNr = Integer.parseInt(br.readLine());
		}

		System.out.println("Exit");

	}

}
