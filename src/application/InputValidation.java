/* Input validation class for checking if user input is correct or not
 * Contributions :
 * Sindhu Rallabhandi
*/

package application;


import java.util.regex.Pattern;

public class InputValidation {
	
String input = "";
	
	public InputValidation(String input) 
	{
		this.input = input;
	}
	
	public static boolean isValidInput1(String input)
	{
		for (char c : input.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
	} 
	
	public boolean isValidInput(String input)
	{
		// Allow letters, numbers, underscores, and hyphens
        String regex = "^[a-zA-Z0-9_\\-]*$";
        return Pattern.matches(regex, input);
	}
	
	public boolean isValidEmail(String input) {
        // Use a regular expression to check for a valid email
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, input);
    }

}

