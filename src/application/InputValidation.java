/* Input validation class for checking if user input is correct or not
 * Contributions :
 * Sindhu Rallabhandi
*/

package application;


import java.util.regex.Pattern;

public class InputValidation {
	
	public InputValidation() 
	{
		
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
