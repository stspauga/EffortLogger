package application;

public class InputValidation {
	String input = "";
	
	public InputValidation(String input) 
	{
		this.input = input;
	}
	
	public static boolean isValidInput(String input)
	{
		for (char c : input.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
	}
}
