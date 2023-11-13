/* Controller Class for the Effort Logger Console screen
 * Contributions :
 * Zachary Weber
 * Tuliloa Pauga
*/
package application;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EffortLoggerConsoleController {
	
	// FXML elements
	@FXML
	Label clockLight;
	@FXML
	ComboBox<String> projectComboBox;
	@FXML
	ComboBox<String> lifeCycleComboBox;
	@FXML
	ComboBox<String> effortCategoryComboBox;
	@FXML
	ComboBox<String> effortTypeComboBox;
	@FXML
	Label timeLabel;

	
	private Stage stage;
	private Scene scene;
	public boolean activityCheck;
	private PopupTutorial tutor;
	//private Parent root;
	// temp project name array for comboBox display
	private ArrayList<String> projectListNames = new ArrayList<String>();
	private ProjectData currProject;
	private String[] effortType;
	
	public void initialize() {
		// load project selection
		if (Main.userData.getProjectArr() != null) {
			loadProjectNameBox();
		}
		// load effort category selection
		if (Main.userData.getEffortCategory().effortCategories != null) {
			loadEffortCategoryBox();
		}
	}
	
	
	
	
	// Set up Project ComboBox for display & selection
	public void loadProjectNameBox() {
		for (int i = 0; i < 9; i++) {
			if (Main.userData.getProjectArr()[i] != null) {
				projectListNames.add(Main.userData.getProjectArr()[i].getName());
			}
		}
		
		projectComboBox.getItems().addAll(projectListNames);
	}
	
	// Set Up Life Cycle Step ComboBox for display and selection 
	public void loadLifeCycleStepBox() {
		lifeCycleComboBox.getItems().clear();
		ProjectData[] tempProject = Main.userData.getProjectArr();
		
		for (int i = 0; i < 9; i++) {
			currProject = tempProject[i];
			if (projectComboBox.getValue() == currProject.getName()) {
				break;
			}
		}
		for (int i = 0; i < 49; i++) {
			if (currProject.getLifeCycleArr()[i] != "") {
				lifeCycleComboBox.getItems().add(currProject.getLifeCycleArr()[i]);
			}
		}
	}
	
	// Set Up Effort Category selection ComboBox
	public void loadEffortCategoryBox() {
		for (int i = 0; i < Main.userData.getEffortDefinitions().size(); i++) {
			effortCategoryComboBox.getItems().add(Main.userData.getEffortDefinitions().get(i)[0]);
		}
	}
	
	public void loadEffortTypeBox() {	
		effortTypeComboBox.getItems().clear();
		String category = effortCategoryComboBox.getValue();
		effortType = Main.userData.getEffortTypeDefinition(category);
		//for (String entry : effortType) {System.out.println(entry);} // Debug
		effortTypeComboBox.getItems().addAll(effortType);
		
		/* Change how the EffortCategoryData object stores data before continuing
		currEffort = Main.userData.getEffortCategory().
		for (int i = 0; i < 9; i++) {
			currProject = [i];
			if (projectComboBox.getValue() == currProject.getName()) {
				lifeCycleComboBox.getItems().addAll(tempProject[i].getLifeCycleArr());
				break;
			}
		}
		*/
	}
	
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

	// Switch to the Effort Logger Editor Scene 
	public void switchToLoginPage(ActionEvent e) throws IOException {
		closeTutorial();
		System.out.println("Switching to Login Page");
		String newScreenFile = "EffortLoggerLogin.fxml";
		switchScreen(newScreenFile, e);
		
	}
	
	//Switch to the Planning poker scene
	public void switchToPlanningPoker(ActionEvent e) throws IOException {
		closeTutorial();
		System.out.println("Switching to Planning Poker");
		String newScreenFile = "PlanningPoker.fxml";
		switchScreen(newScreenFile, e);
	}

	public void switchToSettings(ActionEvent e) throws IOException{
		closeTutorial();
		System.out.println("Switching to Planning Poker");
		String newScreenFile = "SettingsConsole.fxml";
		switchScreen(newScreenFile, e);
	}

	public void switchScreen (String newScreenFile, ActionEvent e) throws IOException{
		// prevent user from leaving during activity -- may need to change later --
		if (activityCheck) {System.out.println("Please conclude the activity before switching screens"); return;}
		Parent root = FXMLLoader.load(getClass().getResource(newScreenFile));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	// This will need to start the activity logging
	// or notify the user that activity is already being logged
	Timeline timeline = new Timeline();
	private int seconds = 0;
	public void startActivity(ActionEvent e) {
		if (activityCheck) {
			System.out.println("There is already an activity started");
			return;
		}
		System.out.println("Start time : " + Instant.now().toString());
		
		timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        seconds = 0;
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1.0), event -> {
            seconds++;
            timeLabel.setText("Time: " + seconds + " seconds");
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
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
		
		System.out.println("End time : " + Instant.now().toString());
		
		if (timeline != null) {
            timeline.stop();
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
		
		tutor = new PopupTutorial(
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
