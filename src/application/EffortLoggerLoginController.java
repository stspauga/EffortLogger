/* Controller Class for the Effort Logger Login screen
 * Contributions :
 * Zachary Weber
 * Sindhu Rallabhandi
 * Madeleinne Tan
 * Nghiem Nguyen
 * Thai Nguyen
*/
package application;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Base64;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EffortLoggerLoginController {
	private Stage stage;
	private Scene scene;
	//private Parent root;
	

	// FXML elements
	@FXML
	private PasswordField passwordField;
	private Password checker;
	@FXML 
	private TextField usernameField;
	private InputValidation inputValidation;

	@FXML
	private TextField userFirstName;
	@FXML
	private TextField userLastName;
	@FXML
	private TextField userAddress;
	@FXML
	private TextField userPhoneNumbers;
	
	private String xorWithKey(String a, String b) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < a.length() && i < b.length(); i++) {
	        sb.append((char) (a.charAt(i) ^ b.charAt(i)));
	    }
	    return sb.toString();
	}

	public void logIn(ActionEvent e) throws IOException {
		
		//checking if user name is valid
		String enteredUsername = usernameField.getText();
		inputValidation = new InputValidation(enteredUsername);
		Main.userSession.logAUserIn(enteredUsername);
		Boolean userSessionCheck = Main.userSession.getUserSessionCheck();
		Main.userSession.setUserName(enteredUsername);
		boolean validUsername = inputValidation.isValidInput(enteredUsername);
		boolean validEmail = inputValidation.isValidEmail(enteredUsername);
		boolean acceptedUser = validUsername || validEmail;
		if(!(acceptedUser))
		{
			System.out.println("Wrong Username - should be valid email or username with letters, numbers, \"-\", or \"_\"");
		}
		
		//checking if password is right

		String enteredPassword = passwordField.getText();
	    checker = new Password(enteredPassword);
	    boolean contentsPass = Password.checkContents(enteredPassword);
	    
	    // broken down for debugging purposes
	    if(contentsPass) {
	    	System.out.println("Contents passed");
	    } else {
	    	System.out.println("Contents are not satisfied!");
	    }
	    boolean lengthPass = Password.checkLength(enteredPassword);
	    if(lengthPass) {
	    	System.out.println("Length passed");
	    } else {
	    	System.out.println("Password is not satisfied!");
	    }
	    boolean accepted = contentsPass && lengthPass;

	    //if password and user name are valid

	    if (accepted && acceptedUser) {
	        // Check if the entered user name and encrypted password match with the ones in the file
	        try (BufferedReader reader = new BufferedReader(new FileReader("userDatabase.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                if (line.contains("Username/email: " + enteredUsername)) {
	                    // The next line contains the password and secret cipher-text
	                    String passwordLine = reader.readLine();
	                    String[] passwordAndCiphertext = passwordLine.substring(passwordLine.indexOf(":") + 2).split(":");
	                    if (passwordAndCiphertext.length < 2) {
	                        // Handle the error, e.g., by showing an error message or throwing an exception
	                        System.err.println("Invalid password line: " + passwordLine);
	                        return;
	                    }
	                    
	                    String storedPassword = passwordAndCiphertext[0];
	                    String storedSecretCiphertext = passwordAndCiphertext[1];

	                    // Encrypt the entered password
	                    String encodedEnteredPassword = Base64.getEncoder().encodeToString(enteredPassword.getBytes());
	                    String xorEnteredPassword = xorWithKey(encodedEnteredPassword, storedSecretCiphertext);
	                    String readableEnteredPassword = Base64.getEncoder().encodeToString(xorEnteredPassword.getBytes());

			            if (storedPassword.equals(readableEnteredPassword)) {
			            	// allow user to access the console
			                switchToConsole(stage);
			                return;
			            }
	                }
	            }
	        }
	        
	        if (userSessionCheck) {
				// Create user data object after authentication
				// For this prototype, every user treated das new and given a demo object ------------
				System.out.println("Demo Data for Prototype");
				Main.setNewUserData();
				
				// do some things
				stage = (Stage)((Node)e.getSource()).getScene().getWindow();
				
				// allow user to access the console
				switchToConsole(stage);
				
			} else {
				System.out.println(Main.userSession.currUser + " is already logged in");
			}

	    } else {
	        System.out.println("Wrong username or password");
	    }

	}

	public void SignUp(ActionEvent e) throws IOException {
		System.out.println("Switching to Sign Up page");
		Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerSignUp.fxml"));
	    stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToConsole(Stage stage) throws IOException {
		System.out.println("Switching to Console");
		Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
