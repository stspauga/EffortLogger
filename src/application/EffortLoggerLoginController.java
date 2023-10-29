/* Controller Class for the Effort Logger Login screen
 * Contributions :
 * Zachary Weber
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
import javafx.stage.Stage;
import application.UserModel;
//import application.UserSession;


public class EffortLoggerLoginController {
	private Stage stage;
	private Scene scene;
	//private Parent root;
	
	// FXML elements
	@FXML
	private PasswordField passwordField;
	
	public void logIn(ActionEvent e) throws IOException {
		String enterPassword = passwordField.getText();
		if (true) {
			System.out.println("User Authenticated");
			// do some things
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			// allow user to access the console
			switchToConsole(stage);
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
