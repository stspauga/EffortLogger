/* Controller Class for the Effort Logger Editor Screen
 * TODO:
 * 	need to work on getting a copy of the log object to interact with until it gets saved.
 * 
 * Contributions :
 * Zachary Weber
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EffortLoggerEditorController {
	// FXML elements
	@FXML
	ComboBox<String> projectComboBox;
	@FXML
	ComboBox<String> effortLogComboBox;
	@FXML
	TextField date;
	@FXML
	TextField startTime;
	@FXML
	TextField endTime;
	
	private Stage stage;
	private Scene scene;
	private ProjectData currProject;
	private EffortLog currLog;
	//temp project name array for comboBox display
	private ArrayList<String> projectListNames = new ArrayList<String>();
	private ArrayList<String> effortLogList = new ArrayList<String>();
	
	
	public void initialize() {
		// load project selection
		if (Main.userData.getProjectArr() != null) {
			loadProjectNameBox();
		}
	}
	
	// This should create a duplicate entry, adjusting the currently selected
	// end time as the new end time on the first and the start time of the new log
	public void splitEntries() {
		
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
	
	// Set up Project's Effort log list data into comboBox
	public void loadEffortLogBox() {
		effortLogComboBox.getItems().clear();
		effortLogList.clear();
		ProjectData[] tempProject = Main.userData.getProjectArr();
		
		for (int i = 0; i < 9; i++) {
			currProject = tempProject[i];
			if (projectComboBox.getValue() == currProject.getName()) {
				break;
			}
		}
		for (EffortLog i : currProject.getEffortLogList()) {
			effortLogList.add(i.toString());
		}
		effortLogComboBox.getItems().addAll(effortLogList);
	}
	
	// Use selected log's data to fill the remaining fields
	public void loadEffortLogData() {
		//currLog = currProject.getEffortLogList().
		//loadDateAndTime();
	}
	
	// Set up date and time fields from the log
	public void loadDateAndTime() {
		//date.setText("");
	}
	
	// Switch to the Effort Logger Console
	public void switchToConsole(ActionEvent e) throws IOException {
		System.out.println("Switching to Console");
		
		Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}