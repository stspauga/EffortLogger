/* Controller Class for the Effort Logger Login screen
 * Contributions :
 * Zachary Weber
 * Sindhu Rallabhandi
 * Madeleinne Tan
 * Nghiem Nguyen
*/
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.UserModel;

public class EffortLoggerSignUpController {
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
	
	public void SignUp(ActionEvent e) throws IOException {
		
		//Insert first name into text field
		String enteredFirstName = userFirstName.getText();
		
		//Insert last name into text field
		String enteredLastName = userLastName.getText();
		
		//Insert address into text field
		String enteredAddress = userAddress.getText();
		
		//Insert phone numbers into text field
		String enteredPhoneNumbers = userPhoneNumbers.getText();
			
		//checking if user name is valid
		String enteredUsername = usernameField.getText();
		inputValidation = new InputValidation(enteredUsername);
	
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
	    boolean contentsPass = checker.checkContents(enteredPassword);
	    
	    // broken down for debugging purposes
	    if(contentsPass) {
	    	System.out.println("contents passed");
	    }
	    boolean lengthPass = checker.checkLength(enteredPassword);
	    if(lengthPass) {
	    	System.out.println("length passed");
	    }
	    boolean accepted = contentsPass && lengthPass;
	
	
	    //if password and user name are valid
		if (accepted && acceptedUser) {
	
			// Create user data object after authentication
			// For this prototype, every user treated as new and given a demo object ------------
			System.out.println("Demo Data for Prototype");
			Main.setNewUserData();
			
			// do some things
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			// allow user to access the console
			switchToLogin(stage);
		}
	
		else {
			System.out.println("Wrong password");
		}
	}
		
	public void switchToLogin(Stage stage) throws IOException {
		System.out.println("Switching to Login Page");
		Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerLogin.fxml"));
		//stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}