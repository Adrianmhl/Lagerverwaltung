
public interface Lagerverwaltung {
abstract void einlagern(int lagerplatzId, int produktId);
abstract void ausbuchen(int lagepaltzId);
abstract void produktSuchen(int produktId);
}
