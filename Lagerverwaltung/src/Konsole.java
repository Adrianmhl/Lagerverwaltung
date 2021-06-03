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
	 * ohne Bedingung --> später :Lagerplatz frei : ja,nein?
	 * @param produkt
	 */
	public void eingangProdukt(String marke, String kategorie,int anzahl) {
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
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		/**
		 * Menu + User Input (BufferedReader)
		 */
		
	System.out.println("1 : Wareneingang");	
	System.out.println("2 : Warenausgang");	
	System.out.println("3 : Waren im Lager");
	System.out.println("4 : Suche");
	System.out.println("0 : Exit");
	
	InputStreamReader is = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(is);
	
	// throws NumberFormatExeption, Integer (klasse).parseInt(static method)
	int n = Integer.parseInt(br.readLine());
	
	
	switch(n) {
	//Abbruch: Exit
	case 0:
		break;
		
	//Wareineingang	
	case 1:
		
		
		//Manuell
		
		System.out.println("1 Marke: ");
		System.out.println("1 Coca-Cola, 2 Sprite , 3 Red-Bull");
		int markeNr = Integer.parseInt(br.readLine());
		String marke ="";
		//trycatch/ Exception , neue Methode schreiben
		
		if (markeNr == 1) {
			 marke = "Coca-Cola";
		}
		
		else if (markeNr == 2) {
			 marke = "Sprite";
		}
		
		else if (markeNr == 3) {
			 marke = "Red-Bull";
		} 
		
		
		System.out.println("2 Kategorie: ");
		String kategorie = br.readLine();
		
		System.out.println("3 Anzahl: ");
		int anzahl = Integer.parseInt(br.readLine());
		
		console.eingangProdukt(marke, kategorie , anzahl);
		
	//Warenausgang	
	case 2:
		
	//Liste aller Produkte ausgeben	
	case 3:
	
	//Suchfunktion
	case 4:
		
	}
		
	/***
	 * @author isedo
	 * test -> später über switch case? manuell über 
	 * konsole oder einscannen
	 */
//	Konsole console = new Konsole();
//	
//	
//	console.eingangProdukt(new Produkt("CocaCola", "Getraenk", 100));
//	console.eingangProdukt(new Produkt("Leitz-Ordner", "Buero-Artikel", 40));
//	console.alleAusgebenProducts();
	
	}


}
