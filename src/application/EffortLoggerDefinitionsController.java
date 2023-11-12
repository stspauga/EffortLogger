/* Controller Class for the Effort Logger Definitions Scene
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EffortLoggerDefinitionsController {
		
	@FXML
	ComboBox<String> projectList;
	private String[] projectListArr = new String[10];
	
	private Stage stage;
	private Scene scene;
	
	/*
	EffortLoggerDefinitionsController() {
		//loadProjectNames();
	}
	*/
	
	// get names of projects from userData and display in combo box
	public void loadProjectNames() {
	for (int i = 0; i < 9; i++) {
		if (Main.userData.getProjectArr()[i] != null) {
			projectListArr[i] = Main.userData.getProjectArr()[i].getName();
		}
	}
	// Add newly made array of project names to combo box
	projectList.getItems().addAll(projectListArr);
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