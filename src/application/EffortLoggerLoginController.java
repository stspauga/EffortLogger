/* Controller Class for the Effort Logger Login screen
 * Contributions :
 * Zachary Weber
 * Sindhu Rallabhandi
 * Madeleinne Tan
*/
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.UserModel;

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
	@FXML
	Label usernameError;
	@FXML
	Label passwordError;
	//boolean usernameWrong;
	//boolean passwordWrong;

	
	public void logIn(ActionEvent e) throws IOException {
		usernameError.setVisible(false);
		passwordError.setVisible(false);
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
			showUsernameError();
			System.out.println("username wrong");
			
		}
		
		//checking if password is right
		String enteredPassword = passwordField.getText();
	    checker = new Password(enteredPassword);
	    boolean contentsPass = Password.checkContents(enteredPassword);
	    boolean lengthPass = Password.checkLength(enteredPassword);
	    boolean accepted = contentsPass && lengthPass;

	    //if password and user name are valid
		if (accepted && acceptedUser) {
			if (userSessionCheck) {
				Main.setNewUserData();
				stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
				// allow user to access the console
				switchToConsole(stage);
			} else {
				System.out.println(Main.userSession.currUser + " is already logged in");
			}
		}

		else {
			showPasswordError();
			System.out.println("password wrong");
		}

	}
	
	public void showUsernameError() throws IOException{
		usernameError.setVisible(true);
	}
	public void showPasswordError() throws IOException{
		passwordError.setVisible(true);
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
