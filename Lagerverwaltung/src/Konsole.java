import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
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
		System.out.println("**************************************************************");
		System.out.println("Waren im Lager:"); 
		// IF STATE-ment falls lager leer
		
		if(produktListe.isEmpty()) {
			System.out.println("LEER");
		}
			else {
				for (Produkt alleProdukte : produktListe) {
			
					System.out.println(alleProdukte);
				}
			}
		System.out.println("**************************************************************");
		}
	/**
	 * Auswahl
	 */
	public static void menuAuswahl() {
		System.out.println("1 : Wareneingang");
		System.out.println("2 : Warenausgang");
		System.out.println("3 : Waren im Lager");
		System.out.println("4 : Suche");
		System.out.println("5 : Exit");
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
	 * Getraenke Auswahl
	 * @author isedo
	 * @param auswahlGetraenke
	 * @param markenGetraenke
	 */
	
	public static void auswahlGetraenke(int auswahlGetraenke[], String markenGetraenke[]) {
		
		System.out.println("Getraenke");
		for(int i = 0; i < auswahlGetraenke.length; i++) {
			System.out.println(auswahlGetraenke[i] + " " + markenGetraenke[i]);
		}
				
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		menuAuswahl();

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		// throws NumberFormatExeption, Integer (klasse).parseInt(static method)
		int menuNr = Integer.parseInt(br.readLine());
		
		
		while (menuNr != 5 ) {

			// Wareineingang
			if (menuNr == 1) {
				System.out.println("Kategorie: ");
				System.out.println("1 Snacks 2 Getraenke");
				int katNr = Integer.parseInt(br.readLine());

				if (katNr == 1) {
					wareneingangSnacks();
				}

				else if (katNr == 2) {
					
					// Input
					int auswahlGetraenke[] = {1,2,3};
					String markeGetraenke[] = {"Coca-Cola","Sprite","Red-Bull"}; 
					// Menu Getraenke
					auswahlGetraenke(auswahlGetraenke, markeGetraenke);
					
					String kategorie = "Getraenke";
					
			
					int markeNr = Integer.parseInt(br.readLine());
					String marke = "";
					
					
						//while-Schleife statt Exeption
							
							//BIG BROBLEM : Falls falsche Eingabezahl (z.B. 4) --> Zur�ck ins Menu: Getraenk
							//->Dafür machen wir eine Exception "Falsche Eingabe" die das Menü neu startet
//							if(markeNr > auswahlGetraenke.length) {
//								auswahlGetraenke(auswahlGetraenke, markenGetraenke);
//								markeNr = Integer.parseInt(br.readLine());
//								
//							} else {
							
								
								if (markeNr == auswahlGetraenke[0]) {
									marke = markeGetraenke[0];
									System.out.println("coke");
								}
		
								else if (markeNr == auswahlGetraenke[1]) {
									marke = markeGetraenke[1];
								}
		
								else if (markeNr == auswahlGetraenke[2]) {
									marke = markeGetraenke[2];
								}
		
								System.out.println("Eingang: ");
								console.eingangProduktListe(marke, kategorie);
								console.alleAusgebenProducts();
								
						
								} 
								
							
			}

			if (menuNr == 3) {
				console.alleAusgebenProducts();
			}
			
			if (menuNr == 4) {
				System.out.println("SUCHE *in Bearbeitung*");
			}
			
			menuAuswahl();
			menuNr = Integer.parseInt(br.readLine());
		}

		System.out.println("Exit");

	}

}
