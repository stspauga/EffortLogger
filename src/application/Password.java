// Coded By : Madeleinne Tan 
// Current File : 10/28/2023 at 10:22pm

package application;
//import javafx.application.Application;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Password {
	String pswrd = "";
	
	public Password(String password) {
		this.pswrd = password;
	}
	
	// password must be at least 7 chars long
	public static boolean checkLength(String pswrd) {
		if(pswrd.length() >= 7) {
			return true;
		}
		return false;
	}

	// Password must be at least 7 chars and has the phrase "TH24" in it
	public static boolean checkContents(String pswrd) {
		String accepts = ".*TH24.*";
		
		Pattern pattern = Pattern.compile(accepts);
		Matcher match = pattern.matcher(pswrd);
		return match.matches();
	}
}
