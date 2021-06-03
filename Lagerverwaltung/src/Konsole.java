import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author isedo und Adrian 
 *
 */
public class Konsole implements Lagerverwaltung {

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
		 * @author isedo
		 * gespeicherte Produkte 
		 */
	private List<Produkt> produktListe = new ArrayList<>();
	static Konsole console = new Konsole();
		/**@author isedo
		 * Produkte hinzuefugen (Wareneingang) 
		 * ohne Bedingung --> sp�ter :Lagerplatz frei : ja,nein?
		 * @param produkt
		 */
	
	public void eingangProduktListe(String marke, String kategorie,int anzahl) {
		
		Produkt tmprodukt = new Produkt(marke, kategorie, anzahl);
		this.produktListe.add(tmprodukt);
		
	}
		
		/**
		 * @param produkt
		 * 
		 */
	public void ausgangProdukt(Produkt produkt) {
		
	}
	
		/**@author isedo
		 * Produkte ausgeben (Inhalt) 
		 * @param produkt
		 */
	public void alleAusgebenProducts() {
		for(Produkt alleProdukt : produktListe) {
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
	}
	
	public static void wareneingangSnacks() {
		String kategorie = "Snacks";
		System.out.println("noch in bearbeiung!");
		System.out.println("**************************************************************");
	}
	
	
		
		
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		menuAuswahl();
		
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		// throws NumberFormatExeption, Integer (klasse).parseInt(static method)
		int menuNr = Integer.parseInt(br.readLine());
		
		while(menuNr != 0) {

			switch(menuNr) {
			//Abbruch: Exit
			case 0:
				
			break;
			
			//Wareineingang	
			case 1:
				System.out.println("1 Kategorie: ");
				System.out.println("1 Snacks, 2 Getraenke , 3 Zur�ck");
				int katNr = Integer.parseInt(br.readLine());
				
					if(katNr == 1) {
						wareneingangSnacks();
					}
				
					if(katNr == 2) {
						String kategorie = "Getraenke";
					
						/**
						 * Marke
						 */
						// trycatch; Exception , & vllt. neue Methode schreiben ?
						System.out.println("2 Marke: ");
						System.out.println("1 Coca-Cola, 2 Sprite , 3 Red-Bull");
						int markeNr = Integer.parseInt(br.readLine());
						String marke ="";

						if (markeNr == 1 | markeNr == 2 |  markeNr == 3 | markeNr == 0) {

							if (markeNr == 1) {
								marke = "Coca-Cola";
							}

							if (markeNr == 2) {
								marke = "Sprite";
							}

							if (markeNr == 3) {
								marke = "Red-Bull";
							} 	
							
							System.out.println("3 Anzahl: ");
							System.out.println("(max: ist/soll) "); //SUCHT freie Slots im lager / maschine
							int anzahl = Integer.parseInt(br.readLine());


							System.out.println("Eingang: ");

							console.eingangProduktListe(marke, kategorie, anzahl);
							console.alleAusgebenProducts();
							System.out.println("**************************************************************");
							break;
						}  
					} 
					
		
			} 
			menuAuswahl();
			int menurNr = Integer.parseInt(br.readLine());
		} 
		System.out.println("Exit");
	}
}

