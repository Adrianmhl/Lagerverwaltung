public class Lager {
	private int lagerId;
	private String lagerName;

	Lager(String name, int lagerId) {
		this.lagerName = name;
		this.lagerId = lagerId;
	}

	public int getLagerId() {
		return lagerId;
	}

	@Override
	public String toString() {
		return "Lager [lagerName=" + lagerName + "]";
	}

}