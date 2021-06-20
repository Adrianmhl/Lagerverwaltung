
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

//	private InputStreamReader isr; 
//	private BufferedReader br; 

	private InputStreamReader is;
	private BufferedReader br;

	Input() {
		is = new InputStreamReader(System.in);
		br = new BufferedReader(is);

	}

	public String inputStrReader(String eingabeMsg) throws IOException {

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		System.out.println(eingabeMsg);
		String strInput = br.readLine();

		return strInput;

	}

	public int inputIntReader(String eingabeMsg, String eingabeError) throws IOException {

		int num = 0;
		String strInput;
		boolean richtig = false;

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		// Schleife bricht erst wenn Zahl eingegeben wird
		while (richtig == false) {

			// Anwender hinweisen
			System.out.println(eingabeMsg);

			strInput = br.readLine();

			try {
				num = Integer.parseInt(strInput);
				richtig = true;
			} catch (NumberFormatException e) {
				System.out.println(eingabeError);
			}
		}
		return num;

	}

	public int inputIntReader(String eingabeMsg, String eingabeError, int min, int max) throws IOException {

		int num = 0;
		String strInput;
		boolean richtig = false;

		// Schleife bricht erst wenn Zahl eingegeben wird
		while (richtig == false) {

			// Anwender auf Eingabe hinweisen
			System.out.println(eingabeMsg);

			strInput = br.readLine();

			try {

				num = Integer.parseInt(strInput);
				if (num >= min && num <= max) {
					richtig = true;

				} else
					System.out.println(eingabeError);
			} catch (NumberFormatException e) {
				System.out.println(eingabeError);
			}
		}
		return num;

	}

}
