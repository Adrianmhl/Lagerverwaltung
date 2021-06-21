
public interface Lagerverwaltung {
	abstract void einlagern(Produkt produkt, Lagerplatz lagerplatz);

	abstract void ausbuchen(int lagerpalatzId);

	abstract Produkt produktSuchen(int produktId);

	/**
	 * Diese Methode lagert ein Produkt auf ein Lagerplatz ein
	 * 
	 * @author Adrian
	 * @param lagerplatzId
	 * @param produktId
	 */

}
