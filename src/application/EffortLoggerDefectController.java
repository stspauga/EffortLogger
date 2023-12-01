package application;
/* Controller Class for the Effort Logger Defect Screen
 * Contributions :
 * Zachary Weber
 */

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EffortLoggerDefectController {
	// FXML elements
	@FXML
	ComboBox<String> projectComboBox;
	@FXML
	ComboBox<String> defectComboBox;
	@FXML
	ComboBox<String> startStepBox;
	@FXML
	ComboBox<String> endStepBox;
	@FXML
	ComboBox<String> defectCategoryBox;
	@FXML
	TextField name;
	@FXML
	Label defectNum;
	@FXML
	Label statusLabel;
	@FXML
	TextArea description;
	
	private Stage stage;
	private Scene scene;
	private ProjectData currProject;
	private Defect currLog;
	private boolean tempStatus;
	// temp project name array for comboBox display
	private ArrayList<String> projectListNames = new ArrayList<String>();
	// temp Log toString array for comboBox display
	private ArrayList<String> effortLogList = new ArrayList<String>();
	private ArrayList<String> lifeCycleStepList = new ArrayList<String>();
	private ArrayList<String> defectList = new ArrayList<String>();
	
	
	public void initialize() {
		// load project selection
		if (Main.userData.getProjectArr() != null) {
			loadProjectNameBox();
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
	
	// Sets up Defect combo box
	public void loadDefectBox() {
		defectList.clear();
		description.clear();
		defectCategoryBox.getItems().clear();
		startStepBox.getItems().clear();
		endStepBox.getItems().clear();
		name.clear();
		defectComboBox.getItems().clear();
		currLog = null;
		
		ProjectData[] tempProject = Main.userData.getProjectArr();
		for (int i = 0; i < 9; i++) {
			currProject = tempProject[i];
			if (projectComboBox.getValue() == currProject.getName()) {
				break;
			}
		}
		
		if (currProject.getDefectList().size() > 0) {
			for (Defect i : currProject.getDefectList()) {
			defectList.add(i.toString());
			}
			defectComboBox.getItems().addAll(defectList);
		}
		
		
	}
	
	// Use selected log's data to fill the remaining fields
	public void loadDefectLogData(){
		if (defectComboBox.getValue() != null) {
			String tempStr = defectComboBox.getValue();
			int expId = Integer.parseInt(tempStr.substring(0, tempStr.indexOf('.')));
			currLog = currProject.findDefect(expId);
			
			//set ui elements
			description.setText(currLog.getDescription());
			defectNum.setText("Num: " + currLog.getId());
			name.setText(currLog.getName());
			tempStatus = currLog.isStatus();
			changeStatusLabel();
			
			loadLifeCycleSteps();
			loadDefectCategory();
		}
	}
	
	public void loadLifeCycleSteps() {
		startStepBox.getItems().clear();
		endStepBox.getItems().clear();
		lifeCycleStepList.clear();
		
		for (String step : currProject.getLifeCycleArr()) {
			if(step != "") {
				lifeCycleStepList.add(step);
			}
		}
		
		startStepBox.getItems().addAll(lifeCycleStepList);
		endStepBox.getItems().addAll(lifeCycleStepList);
		
		if (currLog.getStartStep() != null) {
			startStepBox.setValue(currLog.getStartStep());
		}
		if (currLog.getEndStep() != null) {
			endStepBox.setValue(currLog.getEndStep());
		}
	}

	public void loadDefectCategory() {
		defectCategoryBox.getItems().clear();
		for (int i = 0; i < Main.userData.getDefectDefinitions().length; i++) {
			defectCategoryBox.getItems().add(Main.userData.getDefectDefinitions()[i]);
		}
		defectCategoryBox.setValue(currLog.getCategory());
	}
	
	// Create a new defect log in the current project
	public void createDefect() {
		if (currProject != null) {
			currLog = new Defect(currProject.getNextDefectId());
			currProject.addDefect(currLog);
			Defect temp = currLog;

			loadDefectBox();
			defectComboBox.setValue(temp.toString());
		}
	}
	// change defect status
	public void changeStatus() {
		if (currLog != null) {
			tempStatus = !currLog.isStatus();
			changeStatusLabel();
		}
	}
	public void changeStatusLabel() {
		if (tempStatus) {statusLabel.setText("Status: Open");}
		else {statusLabel.setText("Status: Closed");};
	}
	// Update the current log with the currently selected data
	public void updateLog() {
		currLog.setStatus(tempStatus);
		currLog.setName(name.getText());
		if (description.getText().length() < 500) {
			currLog.setDescription(description.getText());
		}
		currLog.setStartStep(startStepBox.getValue());
		currLog.setEndStep(endStepBox.getValue());
		currLog.setCategory(defectCategoryBox.getValue());
		Defect temp = currLog;
		loadDefectBox();
		defectComboBox.setValue(temp.toString());
	}
	
	// Deletes all logs in the currently selected project
	public void deleteLogs() {
		if (currProject != null) {
			currProject.deleteDefectLogs();
			this.loadDefectBox();
		}
		
	}
	// Deletes Currently selected Log
	public void deleteLog() {
		if (currLog != null && currProject != null) {
			currProject.deleteDefectLog(currLog);
			this.loadDefectBox();
		}
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