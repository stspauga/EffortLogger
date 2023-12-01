package application;
/* Controller Class for the Effort Logger Editor Screen
 * TO DO :
 * 	need to work on getting a copy of the log object to interact with until it gets saved.
 * 
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
	@FXML
	ComboBox<String> lifeCycleStepBox;
	@FXML
	ComboBox<String> effortCategoryBox;
	@FXML
	ComboBox<String> effortSubCategoryBox;
	
	private Stage stage;
	private Scene scene;
	private ProjectData currProject;
	private EffortLog currLog;
	// temp project name array for comboBox display
	private ArrayList<String> projectListNames = new ArrayList<String>();
	// temp Log toString array for comboBox display
	private ArrayList<String> effortLogList = new ArrayList<String>();
	private ArrayList<String> lifeCycleStepList = new ArrayList<String>();
	private String[] effortSubCategoryList;
	
	
	public void initialize() {
		// load project selection
		if (Main.userData.getProjectArr() != null) {
			loadProjectNameBox();
		}
	}
	
	// This should create a duplicate entry, adjusting the currently selected
	// end time as the new end time on the first and the start time of the new log
	public void splitEntries() {
		String startDate = currLog.getStartDate();
		String endDate = currLog.getEndDate();
		String midTime = endTime.getText();
		String newEndTime = currProject.getEffortLogList().get(currProject.getEffortLogList().indexOf(currLog)).getEndTime();
		String step = lifeCycleStepBox.getValue();
		String category = effortCategoryBox.getValue();
		updateLog();
		EffortLog dupLog = new EffortLog(startDate, midTime);
		
		String subCategory = effortSubCategoryBox.getValue();
		dupLog.setAll(currProject.getNextLogId(), "", "", endDate, newEndTime, step, category, subCategory);
		currProject.addLog(dupLog);
		loadEffortLogBox();
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
		effortCategoryBox.getItems().clear();
		effortSubCategoryBox.getItems().clear();
		lifeCycleStepBox.getItems().clear();
		currLog = null;
		effortLogList.clear();
		
		ProjectData[] tempProject = Main.userData.getProjectArr();
		
		for (int i = 0; i < 9; i++) {
			currProject = tempProject[i];
			if (projectComboBox.getValue() == currProject.getName()) {
				break;
			}
		}
		if (currProject.getEffortLogList().size() > 0) {
			for (EffortLog i : currProject.getEffortLogList()) {
			effortLogList.add(i.toString());
			}
			effortLogComboBox.getItems().addAll(effortLogList);
		}
	}
	
	// Use selected log's data to fill the remaining fields
	public void loadEffortLogData(){
		date.clear();
		startTime.clear();
		endTime.clear();
		if (effortLogComboBox.getValue() != null) {
			String tempStr = effortLogComboBox.getValue();
			int expId = Integer.parseInt(tempStr.substring(0, tempStr.indexOf('.')));
			System.out.print(expId);
			currLog = currProject.findEffortLog(expId);
			loadDateAndTime();
			loadLifeCycleStep();
			loadEffortCategory();
			loadEffortSubCategory();
		}
	}
	
	public void loadLifeCycleStep() {
		lifeCycleStepBox.getItems().clear();
		lifeCycleStepList.clear();
		for (String step : currProject.getLifeCycleArr()) {
			if(step != "") {
				lifeCycleStepList.add(step);
			}
		}
		
		lifeCycleStepBox.getItems().addAll(lifeCycleStepList);
		
		lifeCycleStepBox.setValue(currLog.getLifeCycleStep());
	}

	public void loadEffortCategory() {
		effortCategoryBox.getItems().clear();
		
		for (int i = 0; i < Main.userData.getEffortDefinitions().size(); i++) {
			effortCategoryBox.getItems().add(Main.userData.getEffortDefinitions().get(i)[0]);
		}
		effortCategoryBox.setValue(currLog.getEffortCategory());
	}

	public void loadEffortSubCategory() {
		effortSubCategoryBox.getItems().clear();
		
		String category = effortCategoryBox.getValue();
		if (category != "Others") {
			if (currProject != null && currProject.getDefectList().size() != 0 && effortCategoryBox.getValue() == "Defects") {
				effortSubCategoryBox.getItems().addAll(currProject.getDefectArr());
				effortSubCategoryBox.setValue(currLog.getEffortSubCategory());
			}
			else {
			effortSubCategoryList = Main.userData.getEffortTypeDefinition(category);
			effortSubCategoryBox.getItems().addAll(effortSubCategoryList);
		
			effortSubCategoryBox.setValue(currLog.getEffortSubCategory());
			}
		}
	}

	// Set up date and time fields from the log
	public void loadDateAndTime() {
		date.setText(currLog.getStartDate());
		startTime.setText(currLog.getStartTime());
		endTime.setText(currLog.getEndTime());
	}
	
	// Update the current log with the currently selected data
	public void updateLog() {
		String newDate, newStartTime, newEndTime, newStep, newCategory, newSubCategory;
		newDate = date.getText();
		newStartTime = startTime.getText();
		newEndTime = endTime.getText();
		newStep = lifeCycleStepBox.getValue();
		newCategory = effortCategoryBox.getValue();
		newSubCategory = effortSubCategoryBox.getValue();
		
		int index = currProject.getEffortLogList().indexOf(currLog);
		currProject.getEffortLogList().get(index).setAll(-1, newDate, newStartTime, "", newEndTime, newStep, newCategory, newSubCategory);
		loadEffortLogBox();
	}
	
	// Deletes all logs in the currently selected project
	public void deleteLogs() {
		currProject.deleteEffortLogs();
		this.loadEffortLogBox();
	}
	// Deletes Currently selected Log
	public void deleteLog() {
		if (currLog != null) {
			currProject.deleteEffortLog(currLog);
			this.loadEffortLogBox();
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