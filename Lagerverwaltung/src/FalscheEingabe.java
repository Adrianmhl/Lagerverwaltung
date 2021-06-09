/**
 * Diese Exception wird geworfen, wenn eine falsche Eingabe erfolgt ist
 * @author adrianmuhleisen
 *
 */
public class FalscheEingabe extends Exception{
	public FalscheEingabe() {
		super("Es wurde etwas nicht verwertbares eingegeben!");
	}
	public FalscheEingabe(String fehlermeldung) {
		super(fehlermeldung);
	}

}
