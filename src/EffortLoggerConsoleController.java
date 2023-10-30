/* Controller Class for the Effort Logger Console screen
 * Contributions :
 * Zachary Weber
*/
package src;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class EffortLoggerConsoleController {
	
	// FXML elements
	@FXML
	Label clockLight;
	
	
	private Stage stage;
	private Scene scene;
	public boolean activityCheck;
	private PopupTutorial tutor;
	//private Parent root;
	
	
	
	
	// Switch to the Effort Logger Editor Scene 
	public void switchToEditor(ActionEvent e) throws IOException {
		closeTutorial();
		System.out.println("Switching to Editor");
		String newScreenFile = "EffortLoggerEditor.fxml";
		switchScreen(newScreenFile, e);
	}
	// Switch to the Effort Logger Editor Scene 
	public void switchToDefinitions(ActionEvent e) throws IOException {
		closeTutorial();
		System.out.println("Switching to Definitions");
		String newScreenFile = "EffortLoggerDefinitions.fxml";
		switchScreen(newScreenFile, e);
		
	}
	public void switchScreen (String newScreenFile, ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource(newScreenFile));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//Switch to the EffortLogger Schedule Scene
	public void switchToSchedule(ActionEvent e) throws IOException {
		System.out.println("Switching to Schedule Calendar");
		
		Parent root2 = FXMLLoader.load(getClass().getResource("EffortLoggerSchedule.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root2);
		stage.setScene(scene);
		stage.show();
	}
	
	// This will need to start the activity logging
	// or notify the user that activity is already being logged
	public void startActivity(ActionEvent e) {
		if (activityCheck) {
			System.out.println("There is already an activity started");
			return;
		}
		System.out.println("Clicked Start an Activity Button");
		clockLight.setStyle("-fx-background-color: green");
		clockLight.setText("Clock is Running");
		activityCheck = true;
	}
	// This will need to stop the activity logging (record end time)
	// or notify the user that activity is not being logged 
	public void stopActivity(ActionEvent e) {
		if (!activityCheck) {
			System.out.println("There is no activity started");
			return;
		}
		System.out.println("Clicked Stop an Activity Button");
		clockLight.setStyle("-fx-background-color: red");
		clockLight.setText("Clock is Stopped");
		activityCheck = false;
	}
	
	// One Time Tutorial Prototype
	public void consoleTutorial(ActionEvent e) {
		// Do not allow more than one window at a time
		if (tutor != null) {
			System.out.println("There is already a tutorial window active");
			return;
		}
		System.out.println("Creating tutorial popup");
		
		PopupTutorial tutor = new PopupTutorial(
				"This is the Effort Logger Console.\n"
				+ "Here you can select a project life cycle step to work on, \n"
				+ "then specify what that category of work falls under.\n"
				+ "Press \"Start an Activity\" to being logging your work and \n"
				+ "press \"Stop an Activity\" to end the logging period.\n"
				+ "You can also use the buttons on the bottom of the screen\n"
				+ "to change the screen you are on.");
		tutor.displayTutorial();
		
	}
	public boolean closeTutorial() {
		// Do not allow switching screens without closing tutorial window
		if (tutor == null) {
			return false;
		}
		System.out.println("Closing Tutorial Window");
		tutor.tutorialWindow.close();
		return true;
	}
}
