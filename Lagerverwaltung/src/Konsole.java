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

	/**@author isedo
	 * Produkte hinzuefugen (Wareneingang) 
	 * ohne Bedingung --> später :Lagerplatz frei : ja,nein?
	 * @param produkt
	 */
	public void eingangProdukt(Produkt produkt) {
		this.produktListe.add(produkt);
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
	
	
	


	public static void main(String[] args) {
		
	/***
	 * @author isedo
	 * test -> später über switch case? manuell über 
	 * konsole oder einscannen
	 */
	Konsole console = new Konsole();
	console.eingangProdukt(new Produkt("CocaCola", "Getraenk", 100));
	console.eingangProdukt(new Produkt("Leitz-Ordner", "Buero-Artikel", 40));
	
	console.alleAusgebenProducts();
	
	}


}
