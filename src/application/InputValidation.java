package application;

import java.util.Scanner;

public class InputValidation{
	
	public InputValidation() 
	{
		
	}
	
	public boolean isValidInput(String input)
	{
		for (char c : input.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
	}
	
	public boolean isValidEmail(String input)
	{
		String sub = input.substring(input.length() - 10);
		if(sub.equals("@gmail.com"))
		{
			return true;
		}
		return false;
	}
}
