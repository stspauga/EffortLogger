/* Controller Class for the Effort Logger Login screen
 * Contributions :
 * Zachary Weber
 * Sindhu Rallabhandi
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
import application.UserSession;


public class EffortLoggerLoginController {
	private Stage stage;
	private Scene scene;
	//private Parent root;
	

	// FXML elements
	@FXML
	private PasswordField passwordField;
	private Password checker;
	@FXML private TextField usernameField;
	private InputValidation inputValidation;
	
	public void logIn(ActionEvent e) throws IOException {

		if (true) {
			//checking if user name is valid
			String enteredUsername = usernameField.getText();
			inputValidation = new InputValidation();
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
	
				System.out.println("User Authenticated");
				
				System.out.println("Demo Data for Prototype");
				Main.setNewUserData();
				// do some things
				stage = (Stage)((Node)e.getSource()).getScene().getWindow();
				// allow user to access the console
				switchToConsole(stage);
			}
			else {
				System.out.println("Wrong password");
			}
		}
	}
		
	
	public void switchToConsole(Stage stage) throws IOException {
		System.out.println("Switching to Console");
		
		Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		//stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
