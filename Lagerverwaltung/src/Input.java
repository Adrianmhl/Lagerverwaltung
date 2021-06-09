import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input {
	
	
//	private InputStreamReader isr; 
//	private BufferedReader br; 
	
	private InputStreamReader is = new InputStreamReader(System.in);
	private BufferedReader br = new BufferedReader(is); 
	
	
	Input() {
		is = new InputStreamReader(System.in);
		br = new BufferedReader(is);
		
	}
	
	public int inputReader(String eingabeMsg, String eingabeError) throws IOException {
		
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
			}
			catch(NumberFormatException e) {
				System.out.println(eingabeError);
			}
		}
		return num;
		
	}
	
	public int inputReader(String eingabeMsg, String eingabeError, int min, int max) throws IOException {
		
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
				if(num >= min && num <= max) {
				richtig = true;
			
				}
				else System.out.println(eingabeError);
			}
			catch(NumberFormatException e) {
				System.out.println(eingabeError);
			}
		}
		return num;
		
	}

}
	


