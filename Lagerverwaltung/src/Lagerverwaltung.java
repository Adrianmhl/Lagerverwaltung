
public interface Lagerverwaltung {
	abstract void einlagern(int lagerplatzId, int produktId);

	abstract void ausbuchen(int lagerpalatzId);

	abstract Produkt produktSuchen(int produktId);
}
