//package application;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Password {
	public static void main(String[] args) {
		// accept user input
		Scanner scanner = new Scanner(System.in);
		boolean acceptable = false;
		
		// Check the password
		while(acceptable == false) {
			// Password must be at least 7 chars and have one of the following phrases:
			// "CSE", "360", "TH24", or "ELV2"
			System.out.println("Enter Password (at least 7 characters and with one or more accepted phrases): ");
			String pswrd = scanner.nextLine();
			acceptable = ((checkContents(pswrd)) && checkLength(pswrd));
			if(acceptable == true) {
				//allow log in
			}
			else {
				System.out.println("Please enter a valid password.");
			}
		}
		
		scanner.close();
	}
	public static boolean checkLength(String pswrd) {
		if(pswrd.length() >= 7) {
			return true;
		}
		return false;
	}
	public static boolean checkContents(String pswrd) {
		String accepts = "(a-z)*(A-Z)*(CSE|360|TH24|ELV2)(a-z)*(A-Z)*";
		
		Pattern pattern = Pattern.compile(accepts);
		Matcher match = pattern.matcher(pswrd);
		return match.matches();
	}
}
