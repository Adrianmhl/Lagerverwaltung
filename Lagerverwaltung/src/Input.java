
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author isedo
 *
 */

public class Input {

//	private InputStreamReader isr; 
//	private BufferedReader br; 

	private InputStreamReader is;
	private BufferedReader br;

	Input() {
		is = new InputStreamReader(System.in);
		br = new BufferedReader(is);

	}

	/**
	 * liest Eingabe
	 * 
	 * @param eingabeMsg
	 * @return
	 * @throws IOException
	 */

	public String inputStrReader(String eingabeMsg) throws IOException {

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		System.out.print(schriftFarbe.YELLOW_BOLD_BRIGHT + eingabeMsg + schriftFarbe.RESET);
		String strInput = br.readLine();

		return strInput;

	}

	/**
	 * liest Eingabe und wandelt in ein Integer
	 * 
	 * @isedo
	 * @param eingabeMsg
	 * @param eingabeError
	 * @param min
	 * @param max
	 * @return
	 * @throws IOException
	 */

	public int inputIntReader(String eingabeMsg, String eingabeError) throws IOException {

		int num = 0;
		String strInput;
		boolean bol = false;

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		// Schleife bricht erst wenn Zahl eingegeben wird
		while (bol == false) {

			// Anwender hinweisen
			System.out.print(schriftFarbe.YELLOW_BOLD_BRIGHT + eingabeMsg + schriftFarbe.RESET);

			strInput = br.readLine();

			try {
				num = Integer.parseInt(strInput);
				bol = true;
			} catch (Exception e) {
				System.out.println(eingabeError);
			}
		}
		return num;

	}

	/**
	 * liest Eingabe und wandelt in ein Integer, eingabe muss zwischen min und max
	 * liegen
	 * 
	 * @isedo
	 * @param eingabeMsg
	 * @param eingabeError
	 * @param min
	 * @param max
	 * @return
	 * @throws IOException
	 */

	public int inputIntReader(String eingabeMsg, String eingabeError, int min, int max) throws IOException {

		int num = 0;
		String strInput;
		boolean bol = false;

		// Schleife bricht erst wenn Zahl eingegeben wird
		while (bol == false) {

			// Anwender auf Eingabe hinweisen
			System.out.print(schriftFarbe.YELLOW_BOLD_BRIGHT + eingabeMsg + schriftFarbe.RESET);

			strInput = br.readLine();

			try {

				num = Integer.parseInt(strInput);
				if (num >= min && num <= max) {
					bol = true;

				} else
					System.out.println(eingabeError);
			} catch (NumberFormatException e) {
				System.out.println(eingabeError);
			}
		}
		return num;

	}

}
