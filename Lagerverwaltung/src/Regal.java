import java.util.Arrays;

public class Regal extends Lager {
	static int regalId;
	private int lagerId;
	private int regalBreite;
	private int regalHoehe;
	Regal[] regale;

	Regal(int regalId, int lagerId, int regalBreite, int regalHoehe) {
		
		super();
		this.lagerId= lagerId;
		this.regalId=regalId;
		this.regalBreite=regalBreite;
		this.regalHoehe=regalHoehe;
	}
	
	public void regalAbbauen(int regalId) {}

	

	@Override
	public String toString() {
		return "Regal [regale=" + Arrays.toString(regale) + "]";
	}
	
}
