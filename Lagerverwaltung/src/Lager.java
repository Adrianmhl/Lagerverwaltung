public class Lager {
	private int lagerId;
	static Lager[] lager;
//	int[] listeDerIds;

	Lager(int lagerId) {
		this.lagerId = lagerId;
	}

	public int getLagerId() {
		return lagerId;
	}

//	public int[] getListeDerIds() {
//		return listeDerIds;
//	}

	@Override
	public String toString() {
		return "Lager [lagerId=" + lagerId + "]";
	}

}